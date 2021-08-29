- name: restart system to reboot to newest kernel
  shell: "sleep 5 && reboot"
  async: 1
  poll: 0

- name: wait for 10 seconds
  pause:
    seconds: 10

- name: wait for the system to reboot
  wait_for_connection:
    connect_timeout: 20
    sleep: 5
    delay: 5
    timeout: 60

- name: install epel-release
  yum:
    name: epel-release
    state: latest

- name: Ensure nginx packages are present
    yum:
      name: nginx, python-pip, python-devel, devel
      state: present
    notify: restart-nginx-service

- name: Ensure uwsgi package is present
    pip:
      name: uwsgi
      state: present
    notify: restart-nginx-service

  - name: Ensure latest default.conf is present
    template:
      src: templates/nginx.conf.j2
      dest: /etc/nginx/nginx.conf
      backup: yes
    notify: restart-nginx-service

  - name: Ensure latest index.html is present
    template:
      src: templates/index.html.j2
      dest: /usr/share/nginx/html/index.html

  - name: Ensure nginx service is started and enabled
    service:
      name: nginx
      state: started
      enabled: yes

  - name: Ensure proper response from localhost can be received
    uri:
      url: "http://localhost:80/"
      return_content: yes
    register: response
    until: 'nginx_test_message in response.content'
    retries: 10
    delay: 1
