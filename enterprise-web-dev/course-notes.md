Course Overview,
  +;

Module 2 - HTML,
  - Explain what HTML is
  - Identify and define basic HTML tags
    - Block Level versus Inline
    - Semantic Tags
    - Images
    - Media
    - Tables
  - Design and make a simple HTML page using the items above
  - Describe the non-use of Frames
  - Be able to validate web pages
  +;
The HyperText Transfer Protocol (HTTP),
  Is a communications protocol that is used by web browsers to obtain information from the WWW. A communications protocol is the set of standard rules for data representation, signaling, authentication and error detection required to send information over a communications channel.

  HTTP is a request/response protocol. A client (usually your browser), connects to a port on a machine that provides http services. Port 80 is the default port used for HTTP connections and port 443 is the default for secure HTTP connections (HTTPS), though occasionally this can differ.

  HTTP is often allowed through corporate firewalls for two reasons. First, it is a standard service that most users now expect to have access to, and second, the firewall maintains the fact that it is your computer that requests the information from the remote site. When the remote site sends something back to your computer, the firewall knows that it is a response to an original request, and lets it pass. You, in effect, "invite" the information from the remote computer into your site.
  +;
Hyper Text Markup Language (HTML),
  HTML is a markup language. A markup language contains text, and information that is used to provide instructions as to how to mark up that text when presented. HTML is written in terms of tags which are enclosed by "<>". This markup gives instructions to your web-browser so that it knows how to render the text on a page.
  +;
Block-level and Inline elements,
  - A block-level element is an element that appears on a page as if there is a line break before and after them. Examples of block-level elements include <p>, <div>, <form>, <header>, <nav>, <ul>, <li>, <h1>.
  - Inline elements appear within the "flow" of a document and have no impact on the position of the contained content on a page. Examples of Inline Elements include <span>, <b>, <em>, <i>, <cite>, <mark>, and <code>.
  +;

Module 3: CSS & Java,
  +;
World Wide Web Consortium (W3C),
  +;

Module 4: Object Oriented Principles. Exceptions. & Collections,
  Understand the features the Java Collections libraries offer
  Able to compare different Collections implementations and explain their differences
  Be familiar Exception handling concepts
  Design exception handling into their codes
  Optional: Describe and recognize Java generics format.
  Design a Java program using primitive types
  Recognize basic Java syntax
  Be familiar with Object Oriented design concepts
  Be able to describe the differences between Classes, Interfaces and Objects
  Be able to compare Abstract Classes vs. Interfaces
  Be able to override methods in subclasses
  Be able to compare visibility modifiers and explain their differences
  +:
Basic Collection Types,
  Collection - This is that base Interface for all of the more specialized Interfaces. It contains a group of Objects, referred to as elements. This interface has some very general methods like size(), isEmpty(), add(), remove() and iterator(), that are independent of any of the more specialized interfaces.
  Set - A Set is a Collection that cannot contain duplicate elements. Sets will allow you to try to add a duplicate, but they will not modify the Collection if the element is already present.
  List - Unlike Sets, Lists may contain duplicate information. Lists imply a certain amount of ordering, and some methods are defined to access the list with an index and search the List. This interface adds a ListIterator that allows both forward and backward motion through the list. A List may be sorted by using the Collections.sort(l) method.
  Queue - a Queue is a List that is designed to hold items in sequence prior to processing them. Queues typically operate in a FIFO (First in, First out) scheme. Basically it is a List you load from one "end" and unload from the other.
  Deque - This is a double-ended queue. You can load and unload elements from either end.
  Map - This is a Collection that places elements in a Container, but indexes them with keys. A map cannot contain duplicate keys, but may contain duplicate values...the keys are the unique identifiers that allow you to pull out the appropriate element. Maps typically have methods like get(), put(), remove(), containsKey(), containsValue()
  SortedSet - This is a Set container that maintains its elements in ascending order, as prescribed by a default, or custom Comparator.
  SortedMap - This is a Map container that maintains its elements in ascending key order, as prescribed by a default, or custom Comparator.
  +;
Generics,
  - can still use abstraction over types, but you can at least make sure that you are getting what you expect in a Collection.
  - ex - we can specify a type as part the List definition
    List<Employee> employeeList = new List();
  +;

Module 5: Java Swing/Graphics,
  +;

Module 6: Java IO and Networking,
  - Code a File object which accesses a file on the native Operating System
  - Identify and use the basic Java I/O classes for files and streams
    - Text I/O
    - Binary I/O
  - Format output to an output stream.
  - Describe and use basic Network ports
  - Identify commonly used Network port numbers
  - Describe the difference between an network client and server
  - Code a simple Network Socket Server and a simple Network Socket Client
  +;
Basic Networking,
  Every computer (real or virtual) on a network is identified by a name and/or unique IP address. The names of the computers are there for convenience as they are mapped to IP addresses by a Domain Name Server (DNS), which keeps track of the mapping.

  For example, the computer www.jhuep.com has an address of 128.220.101.101. If you typed "ping www.jhuep.com" the DNS server would map that name to the IP address and direct the network traffic to that address.

  One host can run multiple servers of the same or distinct protocols attached to different ports. A port is a connection point to a computer, and you can think of it as a sub-address to the main IP address. There is a list of "well-known" ports that every computer supports. These are services so basic or common, that they have the same port number on every system. For example
    ftp: 21
    ssh: 22
    telnet: 23
    smtp: 25
    httpd: 80
    pop: 109
  +;

Module 7: Forms and Servlets,
  - Describe the different types of basic web form components.
  - Generate a web page with input forms of various types
  - Describe what a web container is, and the services it provides
  - Describe a Servlet life cycle
  - Describe how a Servlet fits in a web container
  - Code a Simple Servlet
    - Text output
    - HTML output
  - Debug Servlets
  - Understand the importance and use of the web.xml file
  - Map a Servlet in a web.xml file
  - Extract form submission information from a Servlet Request
  - Manipulate Header and Response structures
  - Describe and use Cookies
  - Place and use information in an HTTP Session.
  +;
Cookies,
  HTTP is fundamentally a "fire and forget" protocol. That means each independent client request gets back a response from the server and for any subsequent request and response there is no memory of the prior transactions. Cookies are a construct that provide a mechanism for maintaining "memory" across request-response transactions. If Cookies are implemented, after an initial request, a server (or servlet) will return a small piece of textual information (Cookie) with the response that is stored on the client. With any subsequent requests from that client to the server, the client sends that cookie back. When the server sees the cookie it can associate it with the previous requests that either resulted in or used the cookie.
  +;
Session tracking,
  enables tracking and persisting of a user's continuous interaction through multiple HTML pages or servlets by a single web application. The idea is that a user visiting a web site is a single "session", and that it would be beneficial to be able to "carry along" information from one page to the next through that session (like a shopping cart). Since HTTP is defined as being a "stateless" protocol, additional mechanism needs to be employed to do this over the basic request-response model. A session is defined as a series of related browser requests that come from the same browser during a certain time period. This implies that sessions have a life span that can "time out" if a web page is left unattended for too long.
  +;

Module 8: JavaScript,
  - Scripting language. JavaScript lives entirely in the browser. Modern browsers natively interpret and execute the javascript directly on the client.
  - The browser sees the script, interprets and runs it. If there is any output to the "document" object (which is the object that describes your current web page), that output is inserted at that specific location in the document.
  +;

Module 9: Multithreading,
  - Describe what a Thread is
  - Code using Multiple threads
  - Stop, pause, sleep and start Threads
  - Coordinate threads
  - Understand and be able to code using thread safe methods
  - Be familiar with some of the features of the java.util.concurrent package
  +;
Concurrent programming,
  - there are two basic units of execution: processes and threads. In the Java programming language, concurrent programming is mostly concerned with threads. However, processes are also important
  +;
Process,
  has a self-contained execution environment. A process generally has a complete, private set of basic run-time resources; in particular, each process has its own memory space.
  +;
Threads,
  - are sometimes called lightweight processes. Both processes and threads provide an execution environment, but creating a new thread requires fewer resources than creating a new process.
  - Threads exist within a process — every process has at least one. Threads share the process's resources, including memory and open files. This makes for efficient, but potentially problematic, communication.
  +;
Thread states,
  - Initial state: prior to start() being called. The thread is ready to run, but hasn't yet.
  - Runnable state: start() has been called, and the thread is in the run() method
  - Blocked state: If a thread executes a sleep(), join() or wait() method or when a thread blocks for I/O
  - Finished state: The thread finishes the run() method.
  +;

Module 10: JSPs,
  Explain the differences between JSP and Servlets
  Describe components of a JSP page
    JSP expressions
    JSP Scriptlets
    JSP declarations
    JSP directives
  Locate and view the Servlets generated by JSP pages and understand the connection between the two.
  Construct JSP pages which include content from other JSP pages
  Define and use Java Beans in web pages
  Understand the connection between Java Beans and the generated Servlet code
  Access form parameters from JSP pages
  Describe and contrast the different scope options for Java Beans
  Describe how the MVC architecture applies to Servlets/JSP pages
  +;
Java Server Pages (JSP),
  JSP pages end in the .jsp suffix, and are actually converted into Servlets by the server. Even if the page is all HTML, if it is a .jsp page, it is eventually converted into a Servlet with a bunch of println() calls. The entire JSP page gets translated into a servlet the first time it is called, and each time thereafter, it uses the generated Servlet code to service the request.
  +;
Model,
  Business process layer
  Models the data and behavior of the applications
  Responsible for interacting with
    Database
    Executing Business Logic
  Takes care of data and behavior that is independent of presentation
  +;
View
  Shows the application to the user
  Not responsible for obtaining, managing data or modeling behavior
  +;
Controller
  Allows user to interact with the application
  Responsible for selecting View
    Language
    Access Level/privileges
  Controller passes user interaction to model
  +;

Module 11: JDBC,
  (Java Database Connectivity)
  - Describe what a database is
  - Be able to use some basic SQL commands to query a database
  - Create a database and table
  - Query databases
  - Understand what a JOIN is
  - Describe what JDBC is used for
  - Map SQL to JDBC data types
  - Connect to a SQL database
  - Query the database using JDBC
  +;
SQL,
  standard language for storing, manipulating, and retrieving data in databases.
  +;
relational database,
  is a collection of tables, that can be linked, compared and sorted with other tables. The general idea in databases is to make each table as small and independent as possible so that each table contains unique, non-duplicated information that can be combined with other tables to create meaningful results.
  +;
Common terms in WHERE clauses,
  General predicates (<, >, <=, >=, =)
    For number values, no quotes around values
      ID < 3
    For Strings, the values are always in single (not double!) quotes
      STATE = 'WY'
  Compound Conditions
    AND, OR, NOT
    ()
  IN - Results that assess to one or more given values
    where colname IN ('value1', 'value2', 'value', ...)
  Pattern Search
    Use the percent sign (%) for any number of characters
      'Tom%' = values all starting with "Tom"
    Use the underline ( _ ) for a single character wildcard
  +;
JDBC Architecture,
  In the two-tier model, a Java applet or application talks directly to the data source. This requires a JDBC driver that can communicate with the particular data source being accessed. A user's commands are delivered to the database or other data source, and the results of those statements are sent back to the user. The data source may be located on another machine to which the user is connected via a network. This is referred to as a client/server configuration, with the user's machine as the client, and the machine housing the data source as the server. The network can be an intranet, which, for example, connects employees within a corporation, or it can be the Internet.

  In the three-tier model, commands are sent to a "middle tier" of services, which then sends the commands to the data source. The data source processes the commands and sends the results back to the middle tier, which then sends them to the user. MIS directors find the three-tier model very attractive because the middle tier makes it possible to maintain control over access and the kinds of updates that can be made to corporate data. Another advantage is that it simplifies the deployment of applications. Finally, in many cases, the three-tier architecture can provide performance advantages.
  +;

Module 12: RMI and ReST,
  - Describe what Web Services are
  - Understand the history of Web Services including SOAP based Services
  - Understand what ReST services are
  - Build a simple ReST service provider using Jersey and Eclipse
  - Be able to implement ReST services that accept input content
  +;
 Simple Object Access Protocol (SOAP),
  which was used for packaging service calls and responses
  +;
Web Service Definition Language (WSDL),
  for defining the web service methods for clients
  +;
Universal Description Discovery and Integration Service (UDDI),
  to facilitate the investigation and discovery of web services by remote clients.
  +;
Self describing,
  means that a user of the web services doesn't know anything about the implementation when they want to use the web service, they let the web services tell them how it is used.
  +;
Uniform Resource Identifier (URI),
  accessible on a network. The URI's components are used to find the location of a service (host and port) as well as the methods associated with a service endpoint (given in the path component). Data definitions and parameters can also be specified in the path or query parameters that can be part of a URI. The scheme in the URI describes the protocol over which the service can be accessed (most often, but not always http).
  +;

Module 13: Web Data: JSON Java and ReST,
  - Have a high level understanding of XML and JSON
  - Understand the difference between XML and JSON
  - Understand JSON fundamentals
  - Understand how to use JSON with JavaScript
  - Understand how to use JSON with Java, using FasterXML/Jackson API
  - Build a simple service based application that passes data using Java objects and JSON
  +;



+;
