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
Basic Colleciton Types,
  Collection - This is that base Interface for all of the more specialized Interfaces. It contains a group of Objects, referred to as elements. This interface has some very general metyhods like size(), isEmpty(), add(), remove() and iterator(), that are independent of any of the more specialized interfaces.
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
