General,
  +;
Goals,
- Source code control (gut, GitHub, gitlab)
- Virtualization/Containerization (virtualbox, VMware EXSi, Docker)
- Build automation/CM (puppet, chef, saltstack, ansible)
- Binary distribution (artifactory)
- Continuous integration (Jenkins)
- Communications & ChatOps
- Automated testing
- Static Code Analysis
- Dynamic Application Scanning
- Patch Management & Library Composition Analysis
- Application Logging & Monitoring
  +;
Benefits,
  - Automation of dev cycle
  - single source of truth, source code management
  - configuration management
  - product readiness to market
  - automation of manual processes
  - containers
  +;
Some Open Source Tooling,
  + Docker: A Docker container consists of packaging the application and its dependencies all up in a box. It runs as an isolated process on the host operating system, sharing the kernel with another container. It enjoys resource isolation and allocation benefits like VMs, but is much more portable and efficient.
  + Kubernetes: Kubernetes is an open source orchestration system for Docker containers. It groups containers into logical units for easy management and discovery, handles scheduling on nodes, and actively manages workloads to ensure their state matches users' declared intentions.
  + Jenkins: Jenkins is a web-enabled tool used through application or a web server such as Tomcat, for continuous build, deployment, and testing, and is integrated with build tools such as Ant/Maven and the source code repository Git. It also has master and dump slaves.
  + Ansible: Ansible automates software provisioning, configuration management, and application deployment with agentless, Secured Shell (SSH) mode, Playbooks, Towers, and Yum scripts are the mechanisms.
  + Chef and Puppet: Chef and Puppet are agent-based pull mechanisms for the deployment automation of work units.
  +;
More Open Source Tools by Bucket,
  + Source code management: Git, GitHub, Subversion, and Bitbucket
  + Build management: Maven, Ant, Make, and MSBuild
  + Testing tools: JUnit, Selenium, Cucumber, and QUnit
  + Repository management: Nexus, Artifactory, and Docker hub
  + Continuous integration: Jenkins, Bamboo, TeamCity, and Visual Studio
  + Configuration provisioning: Chef, Puppet, Ansible, and Salt
  + Release management: Visual Studio, Serena Release, and StackStorm
  + Cloud: AWS, Azure, OpenShift, and Rackspace
  + Deployment management: Rapid Deploy, Code Deploy, and Elastic box
  + Collaboration: Jira, Team Foundation, and Slack
  + BI/Monitoring: Kibana, Elasticsearch, and Nagios
  + Logging: Splunk, Logentries, and Logstash
  + Container: Linux, Docker, Kubernetes, Swam, AWS, and Azure
  +;
Stages,
  Plan
  Create
  Verify
  Package
  Release
  Configure
  Monitor
  +;

Mod 2: Source Code Control,
  - Define key VCS terminology.
  - Explain how to perform basic Git functions.
  - Develop a multi-phase tool selection approach.
  +;
General,
  in fact the survival of most companies and software products is based on the degree to which they automate
  +;

Mod 3:
  Explain virtualization and containerization, including their differences.
  Implement Virtualbox on Windows.
  Create a Ubuntu VM.
  Implement Gitlab.
  +;
Virtualization,
  - refers to the act of creating a virtual version of something, enabling guest operating systems and software to run on host hardware in isolation from eachtother
  - run by a hypervisor - or virtual machine monitor (vmm)
  +;
Virtualbox,
  - Type 2 hypervisor. runs on a host OS (which is installed on top of the host system)
  +;
Docker,
  - runs applications securely isolated in a container, packaged with all its dependencies and libraries
  - apps always have their environment with them, simplifying testing and deployment, and they are fully portable
  +;

Mod 4: Software Component Management,
  +;
Binary Object Repositories,
  - the more specific the repository type, in general the more advanced the features in support of it will be
  - binary tends to refer to Binary Large OBject like a movie, image, song, etc..., while text files (code, etc.) is a subset of binary we still tend to call them text files
  +;

LDAP,
  Lightweight Directory Access Protocol
  The Lightweight Directory Access Protocol (LDAP /ˈɛldæp/) is an open, vendor-neutral, industry standard application protocol for accessing and maintaining distributed directory information services over an Internet Protocol (IP) network.[1] Directory services play an important role in developing intranet and Internet applications by allowing the sharing of information about users, systems, networks, services, and applications throughout the network.[2]
  +;

Mod 7: CMS ... and CD?,
  +;
Chef,
  A Chef recipe is a file that groups related resources, such as everything needed to configure a web server, database server, or a load balancer. Recipes are stored in cookbooks and can have dependencies on other recipes.
  +;
