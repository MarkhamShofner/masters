Foundations of Software Engineerings,
  Software engineering is concerned with the construction of large software systems. Such systems require the efforts of a group of people over a large span of time. This course will focus on techniques that have been found to be effective in the development of these systems. There will be lectures, readings, discussions, research, and a group project. The topics discussed will include software management, software analysis and design techniques, software quality, testing and maintenance.
  +;

Module 1: Intro,
  - Define Software Engineering.
  - Explain why an engineering discipline is needed for software development today.
  - Discuss some of the problems that result if you don’t apply engineering to the development of software.
  - Recognize the goals and principles of Software Engineering.
  - Argue why Software Engineering is, and is not, a Profession.
  +;
Definitions,
  - what work products of software are, and the various tasks that must be completed in order to create them
  - what makes something an engineering discipline
  +;
Complexity,
  LOC (Lines of Code) and the more important Complexity (relationships between the lines of code) are both expanding at a similar rate posited in Moore's law. Exponential increases in complexity can cause major issues when creating and maintaining large codebases. How can software engineering address some of these concerns?
  +;
Goals,
  - Modifiability
  - Efficiency
  - Reliability
  - Usability
  +;
Principles,
  - Modularity
  - Abstraction
  - Encapsulation. High cohesion. Low coupling (simple interfaces).
  +;

Module 2: Process Models,
  - Describe the purpose of software life cycle models.
  - Discuss the benefits of using a life cycle model.
  - Compare and contrast different life cycle models.
  - Differentiate between plan-driven and Agile processes.
  - Select appropriate life cycle model choices for a specific set of project characteristics.
  +;
Software Process / Software Lifecycle,
  - Framework that provides terminology, activity, order/timelines, and project deliverables.
  - Iterative, AGILE, Waterfall, Hybrids...
    - Defining requirements up front with thorough analysis, design, development, testing, deployment - all in distinct phases - with the goal of hitting a specific timeline within a specific budget.
    - then Agile Manifesto, recognizing the shape of modern software development and the competitive advantage gained through responding quickly to changing requirements/landscapes.
  +;
Agile options,
  many types:
    - scrum most common - sprints, team size
    - kanban - no time cycle. to-do, doing, done. (tugboat team)
  +;

Module 3: Software Project Management,
  - Describe the activities in the project management process.
  - Describe the umbrella activities associated with project management.
  - Compare and contrast the different types of estimating techniques used in project planning.
  - Develop a work breakdown structure for a project.
  - Develop a project network diagram and be able to estimate project duration.
  - Describe common types of project risks and how they can be managed.
  - Incorporate uncertainty in project estimates.
  - Compare and contrast the earned value method of measuring project progress with less effective progress measures.
  +;
Team Size and Communication,
  - If we treat the team as a graph, then the expansion if edges between nodes grows exponentially as we add new members, and full communication between each node becomes harder (to keep everyone perfectly in sync)
  - Members will spend more time communicating as team size grows.
  [this isn't to say that we shouldn't have large teams, but to say that "add more people" to a late project/product doesn't always have the intended effects]
  +;
Ranges and Probabilities,
  - Provide ranges and probabilities (for cost, time, risk) to give a proper sense of accuracy/precision and not have teams/individuals be bound to nonreal concreteness. Hone the range throughout the course of the project and converge estimations more tightly bound until the end point.
  +;
Methods for Estimation,
  - Delphi Estimating Process
  - Rule of Thumb
  - Algorithmic Estimation Models
  - Function Point Estimating
  - Activity-Based Estimating - been shown to be the most accurate in practice, but can be quite complex to identify and manage
  +;
Activity-Based Estimating,
  - Task Identification
  - Effort Estimation
  - Cost Estimation
  - Task Sequencing
  - Schedule Estimation
  +;
Three Point Technique for Estimation (tasks projects costs etc.),
  - best case, most likely, worst case
  - provides ranges and a sense of accuracy. normal distribution, long tails depending on the
  +;

Module 4: Software Requirements Engineering,
  - Describe the purpose of systems engineering and requirements engineering.
  - Describe the relationship between systems engineering, requirements engineering, and software engineering.
  - Allocate system-level requirements to hardware & software components.
  - Describe the importance of requirements.
  - Compare and contrast the different types of requirements.
  - Describe the requirements phase work products.
  +;
System,
  - Regularly interacting or interdependent group of items forming a unified whole.
  - A set of interrelated components working together toward some common objective.
  +;
Evaluating Allocation Tradeoffs,
  - in the resource allocation phase (which for nay reasonable sized project won't be carried out perfectly), we'll make sense of the tradeoff landscape between different variations/paths.
  - Pugh Decision Matrix
  - (Weighted) Pugh Decision Matrix
  +;
Requirements Engineering,
  - consists of all the activities involved in discovering, documenting, and maintaining a set of software requirements
  +;
Requirement,
  - [mine] a describable need that needs to be met in order to meet a specific goal
  - a CAPABILITY that must be delivered by the system or a CONDITION that the system must satisfy
  - CAPABILITY = Functional Requirement (must calculate $ discount amount, etc.)
  - CONDITION = Non-Functional Requirement (no more than 5% downtime, etc.)
  +;
Use Cases and User Stories,
  - acceptance-criteria/tracking-mechanic for requirements
  +;

Module 5: Human Computer Interaction,
  - Discuss the history and purpose of user interfaces.
  - Identify Usability and User Experience goals.
  - Perform Usability Analysis.
  - Perform Usability Design.
  - Discuss advantages and disadvantages of four types of user interaction mechanisms.
  - Discuss techniques for handling user errors.
  - Develop a UI prototype and document screen flows and layouts.
  - Apply HCI guidelines and heuristics.
  +;
Modes of communication,
  Human --> Computer
    Data
    Functions
  Computer --> Human
    Data
    Functions
    Status
  +;
Techniques for Usability Analysis,
  - Interviewing
  - Brainstorming
  - Field Studies
  - Scenarios
  +;
Skeuomorphism,
  the design concept of making items represented resemble their real-world counterparts. Skeuomorphism is commonly used in many design fields, including user interface (UI) and Web design, architecture, ceramics and interior design. Skeuomorphism contrasts with flat design, a simpler graphic style.
  +;
Prototyping,
  - reduces risks by preventing user/developer gaps in understanding
  - expose missing capabilities
  - lofi, and hifi
  +;

Module 6: Software Requirements Specification,
  - Describe the three channels of communication.
  - Describe the commonly used models and techniques in requirements elicitation, when they should be used, and why they should be used.
  - Compare and contrast the different types of questions that can be used in requirements elicitation.
  - Develop a set of use cases to model the functional requirements for a project.
  - Develop a decision table to specify the business rules for functional requirements.
  - Describe when and how state models can be used during the requirements phase.
  +;
The Channels of Communication,
  - Verbal, paraverbal (tone), nonverbal (body language)
  - remote projects can lose out on a huge chunk on communication (w/o seeing body language), or if too much is done through text (w/o hearing tone)
  +;
Requirements Definition: Tools and Techniques,
  - Surveys
  - Brainstorming
  - Multi-Voting
  - Cause-Effect Analysis
  +;
Requirements Definition: Use Case Components,
  - summary fields (general info)
  - main success scenario
  - alternate scenarios (alternate ways to achieve the use case or error handling)
  +;
Summary fields,
  - name, number, actors, pre-condition, post-condition, etc.
  +;
Main success scenario,
  - case where everything works perfectly
  +;
Requirements Definition: Using State Models,
  - state transition matrix that tracks conditions/actions when certain states are reached
  +;
Requirements Definition: Data Models,
  - conceptual data model: describes things, called entities, that will be stored, and the relationships between those entities
  - logical data model: elaborates on a conceptual data model by including attributes associated with the entities
  - physical data model: describes how the product’s database will actually be built. It would describe all the data tables, including column names, data types, and so forth
  +;
Data Model,
  - an organized representation of business data that will need to be stored and managed
  - incredibly useful to define upfront in the requirements phase
  +;
Data Normalization,
  - arranging data into logical groupings that match a table format
  - minimizes the amount of duplicate data captured in the database
  - modifications (CRUD) require minimal changes
  +;
First Normal Form,
  - collection of data organized into records which have no repeating groups
  - can be stored in a simple 2-dimensional table
  +;
Second Normal Form,
  - each attribute in a record is functionally dependent on the entire key of that record
  +;
Third Normal Form,
  - each attribute in a record is functionally dependent on the entire key of the record and nothing else
  +;
Requirements Definition: Business Process Models,
  - Process Hierarchy Diagram (Horizontal Decomposition or Vertical Decomposition)
  - Process Dependency Diagram
  - UML Activity Diagram
  - Swim Lane Diagram
  - Context Diagram
  - Data Flow Diagram
  +;

Module 7: Analysis and Design Fundamentals,
  - Explain the importance of each of the three bases of analysis and design: Structure, Information, and Behavior.
  - Utilize structural, informational, and behavioral models in analysis and design.
  - Apply analysis and design principles such as abstraction, modularity, and encapsulation.
  +;
The Three Bases of Analysis and Design,
  Structure, Information, and Behavior
  +;
Structure,
  Distinct modules - in some sort of relationship. Hierarchy, network, layering.
  +;
Information,
  Data - what we keep track of. enumerated in UMLs, Data Models (set, list, array, record, map, scalar, etc.)
  +;
Behavior,
  Functions -
  Imperative: how things happen, change over timeline, inputs/outputs
    - use case specification
    - activity diagram (flowcharts)
    - sequence diagram
  Declarative:
    - rules / decision tables
    - state transition diagrams
  +;
Analysis and Design Principles,
  Modularity
  Abstraction
  Encapsulation
  +;
Modularity,
  - Breaking concepts down into their component parts (decomposing complex things --> increase simplicity)
  - reduces software complexity and encourages parallel development
  - module can be a component/class/method/package/subsystem (many different layers), but the important thing is that there is a well defined interface that helps connect it to other modules
  Main Goals:
    - High Cohesion
    - Low Coupling
  +;
Abstraction,
  - Highlight essential properties of something that might otherwise be too complex
  +;
Encapsulation,
  - complexity of the module doesn't needed to be known by any other module. the implementation details are hidden behind an interface
  +;

Module 8: Object-Oriented Analysis and Design (Part 1),
  - Define basic object-oriented principles: object, message, class, inheritance, and polymorphism.
  - Perform OO Analysis with CRC modeling.
  - Construct UML class diagrams.
  +;
Object oriented principles,
  - objects
  - messages
  - class
  - inheritance
  - polymorphism
  +;
Message,
  - request for service
  - signatures - name, parameters, result
  +;
CRC Analysis,
  - Class Responsibility Collaborator
  - Anthropomorphizes objects that we are modeling. They know things (data) and can do things (functions)
  - team role plays as the objects
  +;
Protocol,
  The set of operation signatures for an object is called its protocol.
  +;

Module 9: Object-Oriented Analysis and Design (Part 2),
  - Perform dynamic object-oriented analysis modeling and express the models using UML activity diagram notation.
  - Create static object-oriented design models of the code using UML class diagram notation.
  - Create dynamic object-oriented design models of the code using UML sequence diagram notation.
  +;
Objects,
  - Made up of information and related operations
  - Should be cohesive and have well defined lightweight coupling to other objects
  +;
Design (as opposed to analysis),
  The How (as opposed to the what)
  +;

Module 10: Patterns Implementation Maintenance & Reuse,
  - Discuss the differences between creational, structural, and behavioral design patterns.
  - Apply a variety of patterns to solve common problems in object-oriented design.
  - Explain why reused software usually is more reliable than handcrafted software.
  - Discuss the types of software reuse.
  - Discuss benefits as well as impediments to software reuse.
  - Explain why maintenance is important.
  +;
Singleton,
  Creational Pattern. Ensures that only a single instance of a class can be created.
  +;
Facade,
  Structural Pattern. Provide a unified/simplified interface for complicated interactions between classes (that the client of the system doesn't need to know).
  +;
Observer,
  Behavioral Pattern. When an object needs to inform other objects that its state has changed, then it can inherit from Subject class and maintains a list [attach()/detach()]of observers and sends updates [notify()] when needed.
  +;

Module 11: Software Quality,
  - Define software quality.
  - Perform activities to achieve and assure software quality.
  - Justify the Return on Investment (ROI) of quality processes.
  - Prevent defects from entering into your software in the first place.
  - Demonstrate how investments in People, Processes, and Tools can promote quality.
  - Describe the Quality organization: CM, Testing, and SQA.
  +;
CASE,
  Computed Aided Software Engineering. Set of tools to improve quality.
  +;

Module 12: Assuring Software Quality,
  - Explain how poor quality impacts cost & schedule.
  - Explain how early defect identification & removal impacts software quality, cost, & schedule.
  - Specify software quality.
  - Measure software quality.
  - Perform effective software quality reviews.
  +;
Types of reviews,
  - round robin
  - informal walkthrough
  - formal inspection
  +;
Price of fixes,
  - goes up the deeper a software moves in the dev lifecycle
  - drivers:
    - amount of rework
    - error amplification (leading to more errors)
  +;
Software Quality Metrics,
  - useful because they can promote concrete visibility, and provide useful feedback and process improvement
  - process
    - effort by phase
    - time to completion
    - average inspection rates
    etc.
  - product
    - size (lines of code)
    - defect density
    - complexity
  - quality
    - defect density
    - test coverage
  +;
Quality Requirements,
  - maintainability: the extent of effort required to make changes to a product
  - portability
  - usability
  - reliability
  - reusability
  - testability
  - interoperability
  +;
The goal,
  - high cohesion (within a component)
  - loose coupling (between components)
  +;
Cyclomatic Complexity,
  - measure of how complex a software component's control flow is.
  - calculated by counting the number of decision keywords, the number of and & or operators, and adding 1 to the total.
  - impacts testability maintainability, understandability, and reliability
  - aim to have components have 8 or fewer (is a good rule of thumb)
  +;

Module 13: Software Testing,
  - Describe the basic principles of software testing.
  - Describe the common software testing work products.
  - Compare and contrast the objectives, testing strategies, and responsibilities for different levels of testing.
  - Compare and contrast the costs and benefits of a life cycle approach to testing with a traditional single-phase approach.
  - Describe and apply black box test design techniques.
  - Describe and apply white box test design techniques.
  +;
Software Testing,
  Measuring/confirming/observing gaps between expectations and what occurs.
  +;
Black Box Testing,
  - designing tests based on the requirements, no code knowledge necessary
  +;
White Box Testing,
  - focuses on designing tests based upon examination of the structural logic (code) for the item under test
  +;
Levels of testing,
  System/Acceptance : All Black box
  Integration : Some White but mainly Black
  Unit : Some Black but mainly White
  +;
Equivalence Classes,
  Subset of the input domain such that any values/conditions in the class will result in an equivalent system response
  +;
Boundary Testing,
  test conditions at the extreme points of the equivalence classes (boundary between conditions)
  +;
