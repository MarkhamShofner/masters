CPU, Central processing unit. electronic circuitry within a computer that carries out the instructions of a computer program by performing the basic arithmetic, logical, control and input/output (I/O) operations specified by the instructions. Stores temp memory in ram, permanent memory on hard drives.+;
Machine language, a computer programming language consisting of binary or hexadecimal instructions that a computer can respond to directly. Low level languages.+;
Compiler, is itself a computer program, reads a program written in a high-level language and translates it into an executable machine language program that a particular type of computer can understand.+;
Source Code, any collection of computer instructions, possible with comments, written using a human-readable programming language, usually as ordinary text.+;
Java Language Compilation, compiled/interpreted into bytecode, which is architecturally neutral (ie only needs to occur once, and then any type of OS can consume the output). "Write once, run everywhere." High portability.+;
Structure of a Java Program,
public class AllWordsCapatilized
{
  public static void main( String [] args )
  {
  System.out.println( "Java Rockz!!" );
  }
}+;
Compiling and Running a Java Program,
 - Name of the file (source code) must match the name of the program exactly
 - File must have a .java extension
 - To compile - JavaC NameOfProgram.java [ will let you know if there are compilation errors]
 - To run - java NameOfProgram   [no file extension]+;
Source Code Comments,
 - Inline program documentation
 - `/* C language style comment and the compilers ignores this */`
 - `// C++ language style comments`+;
Escape Sequences, \", \\, \t tab, \n newline +;
Programming Errors,
  - Syntax - incorrect java syntax. Program will not compile.
  - Logic - incorrect result, even if the program runs.
  - Runtime - occurs when a program is executed, and program will terminate abnormally. Compiles fine, executes incorrectly. (class not found, bad file name, etc...) +;

Declaring and Initializing/Assigning Variables,
	- Java variables are used in Java programs to store information in main memory while the program is running.
	  - Local variables are used inside of methods. Created and exist only when a method is being executed
	  - Instance variables are variables that are associated with a specific object. 
	  -	Class variables are variables that are associated with a whole group of objects.
  - type variableName; // declaration. Examples of types - int, string,
  - Constants are variables whose values cannot be changed once they are initialized.
	  -	`final int x = 10;`
	  -	Commonly names in ALL_UPPERCASE_LETTERS +;
Scope and Lifetime of Variables,
  - Scope of a variable is the portion of a program over which the variable name is known and can be referenced.
	- Lifetime of a variable is the length of time that memory has been reserved to store values of that variable. Variables in main exist for the entire execution of the program. Variables in other methods exist while those methods are executing.
Java Primitive types,
  - byte, short, int, long
  - float, double
  - char
  - boolean
  -	Floats use an f suffix, and an upper or lowercase f can be used. Similarly, doubles may have an upper or lowercase d suffix. If a suffix is not specified for a floating point literal, Java assumes it is of type double.
	-	Chars should be assigned with single quotes
Statement, smallest standalone element of an imperative programming language that expresses some action to be carried out. It is an instruction written in a high-level language that commands the computer to perform a specified action +;
Basic Arithmetic Operators, + - * / %. Binary operators. Need 2 operands.
  - Expressions results in a single value being produced.
  - Remainders or division between integers will be dropped. Use floats or doubles for more accuracy. +;
Automatic type conversion, java attempts to convert the result of an expression or assignment to the largest or most accurate data type. Java does not allow automatic conversion from more accurate to less accurate (ie a double cannot become a float, and a float cannot be assigned to a long). ;
Number Systems,
  - Decimal is base 10
  - Binary is base 2. Modern computer design is based in this system (on/off switches). [indicated in java with a leading 0b or 0B]
  - Hexadecimal is base 16. a=10, b=11, ..., f= 15. Compacy way of representing binary digits. Indicated with 0x or 0X.
  - Conversion from decimal to either just requires finding the largest place that can fit into the remaining value, and chopping that off. i.e. 100 = 01100100
  -	Conversion between hex and binary - split the binary into chunks of four digits and aggregate that value, or the reverse. ie 0x6|4 = 0b0110|0100
  -	Be careful with positive to negative representations. Most Significant Bit (MSB, the first bit) represents if the value is positive or negative. If the MSB is 0, the integer is positive, if 1, the integer is negative.
  +;
Java Assignment and Arithmetic operators,
  - Assignment operator moves some calculated results into a variable (=, +=, -=, etc...)
  - Arithmetic operators
    - increment (++) and decrement (++)
    - Order of the operator wrt the variable affects the value
      -	a = 1; b = a++; // b = 1 (assigned before increase), a = 2
      -	a = 1; b = ++a; // b = 2, a = 2
  +;
Binary,
  -	Each digit in the binary system is called a bit
  -	High bit - used to represent the sign of a number. First in the string of bits.
  -	Byte - 8 bits, short - 16, int - 32, long - 64 +;
Octal,
  -	Base 8
  -	Can assign in java by preceding a number with a 0. int number = 0123; +;
Hexadecimal,
	-	Base 16
	-	Assign in java by preceding with 0X or 0x +;

Relational Operators,
- determine relationship of one operand to another with the result being a boolean true/false, on/off, et cetera value. (==, !=, etc.)
Logical Operators, operate on boolean objects producing a boolean result.
  - &, I, ^ (exclusive or, only one can be true). &&, II are the same as & and I, except they are called short-circuit operators because they will skip the second operand if the first operand fulfills (II) or rejects (I) the condition
  - Also can come with assignment (&=, !=).
    - The results are the same as a non-assignment AND operation except that the value of the left operand is replaced with the result of the operation. (boolean Result |= A;)
	-	? - Ternary (short circuit for if-else control statement)
- Using parenthesis to break up boolean operand interaction helps clarify for human readers (and code writers!)
  +;
Control Statements, If (binary execution path and control flow), Ternary (shorthand), Switch (multiple execution path control flow) +;
If statement, two-way (binary) flow based on a condition +;
Ternary statement, more compact way to write code and assign variables for binary flow control. +;
Switch statement, compact way to implement multiple paths on the value of a single calculation.
  - calculation results in primitive types of String
  - results must be compared against constants (which are determined at compile, not run, time)
  - break statements prevent the next case action (and all following) from being executed
  +;
For Iteration Construct,
  - use to repeat a block of programming statement(s)
  - for (initialization; condition (evaluated as true or false); evaluated after block is executed)
  - The for construct is typically used for counter-controlled interaction problems in which the test expression is not altered during the course of executing the construct.
  +;
While and Do-while, loop evaluates expression at the beginning and executes if true. Do-while always executes at least once because condition is evaluated after the block. The while construct is used for non-counter-controlled iteration problems in which the test expression value could be altered during the course of executing the construct.
  +;

Module 4,
  Methods +;
Method,
  Set of code that performs a well-defined function. In other programming languages, methods may be called subroutines or functions.
  +;
Class method,
  - Java keyword 'static' appears in its definition, so sometimes these are called static methods.
  - Specify the access mode (public, private, or protected)
  - then static
  - then the type of value returned (can be any primitive or non-primitive type), void if no return
  - then the name, usually beginning w a lowercase letter
  - then the arguments
  - then the block statement
  +;
Invoking a method, use its name in an expression or as a statement by itself `displayMessage()`
  +;
Passing Arguments to Methods,
  - methods that accept arguments must specify the number and type of each argument it expected to be passed in
  - Java uses "pass by value" (instead of reference) for primitive argument types
Math Class Methods,
  - Math.sqrt(arg) :: expects a double, returns a double (may need to be casted on return)
  - Math.pow (arg1, arg2) :: ^same
  - Math.random() :: returns double in range 0.0 to 1.0
  +;

Module 5,
  Methods Java Arrays and Strings
  - Create arrays of various primitive types.
  - Use arrays with looping structures.
  - Use arrays as method parameters and returns.
  - Create multi-dimensional arrays of primitive types.
  - Reference dynamically created arrays.
  - Create strings.
  - Use strings as method parameters and returns.
  - Process command-line arguments.
  +;
Array,
  Group of like-typed variables that are referred to by a common name. Convenient means of grouping related information.
  - int month_days[] = new int [12]; // declares and initializes an array of 12 integers
  - int [] myIntArray = {5, 10, 15, 20, 25}; // another option
  - int [][] myIntArray = new int[5][]; // size of all dimensions but last must be specified
  - int [][] myIntArray = {{5, 10}, {15, 20, 25}}; // another option
  +;
Notes on Arrays,
  - When assigning arrays, you are copying the reference, not the data of the array
    - If comparing array variables, the references (not the underlying data) is being compared
    - If references point to different arrays, the results of a comparison will be false even if the underlying data has the same values
  - Default value of an array is a null reference
  - Reading/writing beyond the array size or using an index less than 0 will result in a runtime error, also known as an exception
  +;
String,
  - Widely used in Java programming, is a sequence of characters. In the Java programming language, strings are objects.
  - Convenient for representing text data. Character arrays with wrappers of methods which provide extensive functionality for dealing with a character array as a single unit
  - Strings are immutable - cannot be changed once created. StringBuffer() is a string that can be modified, represents growable and writable character sequences.
  +;
String equality,
  - .equals() // compares the characters inside a String object
  - == // compares two object references to see whether they refer to the same instance
  +;
Other String methods,
  Among many:
  - compareTo() // less than another if it comes before in dictionary order (and vice versa)
  - indexOf() // searches for the first occurrence of a character or substring within a string
  - lastIndexOf() // searches for the last occurrence of a character or substring within a string
  - substring() // extract a substring, can also be used as find/replace
  - concat() // concatenate
  - replace() // find/replace
  - trim() // returns a copy of the invoking string with any leading and trailing whitespace removed
  - valueOf() // string representation of converted data into a human readable form, usually cryptic and can be overloaded in objects
  - toLowerCase() // converts all characters
  - toUpperCase() // converts all characters
  - join() // concatenate two or more strings, separating each with a chosen delimiter
  - charAt() // returns character at that index of the string
  +;
Loops,
  - Loops are designed to process multiple instances of similar logic (enter arrays!)
  - W/ strings - charAt(index), length()
  - Shortcut for loop - for (int tempInt : intArray) // instance in the array, not the index
  +;
Command line arguments in Java,
  - Way to provide data to Java program at run-time
  - java myJavaProgram "arg1" "arg2" // feeds into the array of args in …main(String [] args)
  - Should validate the inputs before use
  - Use quotes for multiple parts of same argument to make sure the modules stay grouped
  - Can set runtime arguments in IDEs
  - Can set debuggers / break points
  +;

Module 6,
  Object-Oriented Programming Concepts:
  - Apply the object-oriented programming concepts of Encapsulation, Inheritance, and Polymorphism.
  - Design Java programs which correctly contain and use multiple classes based on industry-standard design concepts at the beginning level.
  - Design Java programs which specify proper class member access based on industry-standard design concepts.
  - Design Java programs which use the concepts of class containment, aggregation, and Composition.
  +;
Encapsulation,
  - Mechanism that binds together code and the data it manipulates, and keeps both safe from outside interference and misuse.
  - Protective wrapper that prevents the code/data from being arbitrarily accessed by other code
  +;
Inheritance,
  - Process by which one object acquires the properties of another object. Supports the concept of hierarchical classification.
  - Object need only define those qualities that make it unique within its class. Common attributes are pushed to higher levels of the hierarchy, unique characteristics are pushed lower.
  - Subclass inherits from its superclass
  - Key concept that lets object-oriented programs grow in complexity linearly rather than geometrically
  +;
Polymorphism,
  - feature that allows one interface to be used for a general class of actions.
  - concept is often expressed by the phrase "one interface, multiple methods". This means that it is possible to design a generic interface to a group of related activities.
  +;
Class,
  - In Java, the basis of encapsulation. Defines a new data type.
  - Defines the structure and behavior (data/code {instance variables/methods}) that will be shared by a set of objects
  - Objects are instances of classes
  - initializations are referential. // Box b1 = new Box(); Box b2 = b1; b1 = null; // b1 is null and b2 is a reference to the initialized box
  +;
Interfaces,
  - methods define this for most classes.
  +;
Parameter,
  variable defined by a method that receives a value when the method is called.
  +;
Argument,
  value that is passed to a method when it is invoked.
  +;
Constructors,
  - Java will create a default constructor for a class if one is not explicitly defined.
  - Constructor methods can be overloaded with different parameter sets
  +;
This,
  Can be used inside any method to refer to the current object
  +;
Garbage Collection,
  Java handles memory deallocation automatically
  +;
Overloading Methods,
  - Possible to define two or more methods within the same class that share the same name, as long as their parameter declarations are different
  - Concept support Polymorphism
  - Return types do not play a role in overload resolution
  - Can overload constructor methods
  +;
Call-by-value,
  - pass an argument to a subroutine by copying the value of the argument into the formal parameter of the subroutine.
  - occurs when passing a primitive type to a method
  +;
Call-by-reference,
  - pass a reference to an argument to the parameter.
  - inside the subroutine, this reference is used to access the actual argument specified in the call.
    - changes to made to the parameter will affect the argument used to call the subroutine
  - occurs when passing an object to a method
  +;
Recursion,
  - process of defining something in terms of itself
  - need some sort of if statement to exit the method and return a value, or else it will execute indefinitely
  +;
Access Control,
  - public, private, protected
  +;
Public Modifier,
  - when a member of a class uses this modifier, it can be accessed by any other code
  - generally used for methods that define the interface
  +;
Private Modifier,
  - when a member of a classes uses this modifier, it can only be accessed by other members of its class
  - generally used for data that the interface methods will interact with
  +;
Default Modifier,
  - when no access modifier is used, then by default the member of a class is public within its own package, but cannot be accessed outside of its package.
  +;
Static,
  - when a member is declared static, it can be accessed before any objects of its class are created, and without reference to any objects
  - main() is declared static because it must be called before any objects exist
  - outside of the class in which they are defined, static methods and variables can be used independently of any object
  - can only directly call other static methods, can only directly access static data
  - cannot refer to `this` or `super` in any way
  +;
Final,
  - field with this keyword prevents its contents from being modified, essentially a constant
  - means must initialize the field when it is declared
  - typical to name the variable in ALL_CAPS to indicate
  +;
Composition,
  - collection of objects composed as an object
  +;
Containment,
  - contained object cannot be used by other classes, Java implementation is inner/nested classes
  +;
Aggregation,
  - object uses other objects but does not control the used object's existence
    - e.g. stereo receivers uses an mp3 player, or speakers, etc.. but does not control.
  +;

Module 7,
  Inheritance
  - General inheritance concepts & design guidelines.
  - Class member visibility.
  - Call base class constructors.
  - Override inherited methods.
  - Preventing inheritance.
  - Use the object superclass.
  - Cast objects.
  +;
Inheritance,
  - one of the cornerstones of oop because it allows the creation of hierarchical classifications
  - general superclasses can be inherited by other, more specific subclasses
  - class B extends A {}
  - private members of A are not directly accessibly by B
  - protected members are inherited and are directly accessible to the subclasses only
  +;
Super,
  - subclass can refer to its immediate superclass
  - when base classes have constructors that require arguments, the subclass constructors must assume responsibility for calling the base class constructors and passing along the appropriate arguments
    - This must be done by calling the base class constructor in the first executable statement of a subclass constructor using the Java keyword super.
  +;
Method overriding,
  - occurs when the names and the type signatures of the two methods are identical
  - Allows a general class to specify methods that will be common to all of its derivatives, while allowing subclasses to define the specific implementation of some or all of those methods
    - Ability of existing code libraries to call methods on instances of new classes without recompiling while maintaining a clean abstract interface is a profoundly powerful tool
  - Overriding method cannot be more restrictive than the visibility of the inherited method (private cannot override public)
  +;
Dynamic Method Dispatch,
  - mechanism by which a call to an overridden method is resolved at run time, rather than compile time
  - support run-tim Polymorphism
  - it is the type of object being referred to that determines which version of the method will be executed
  +;
Abstract Type Modifier,
  - requires that certain methods be overridden by subclasses
    - no implementation specified in the superclass
    - abstract type name(parameter-list);
  - Any class that contains one or more abstract methods must all be declared abstract.
    - abstract class A {}
  - abstract classes cannot be used to instantiate objects, but they can be used to create object references
    - ^because Java's approach to run-time polymorphism is implemented through the use of superclass references
    - cannot create an abstract object, but can created a reference variable of that type
  +;
Final,
  - can disallow a method from being overridden. final void methA(){}
  - can also be used to prevent inheritance. final class A{}
  +;
Object Class,
  - superclass to all other objects
  - reference variable of type Object can refer to an object of any other class (can then be a method parameter to handle objects of unknown types)
  - some methods available to all objects
    - toString(), .equals() [same reference], .getClass()
    - Operand1 instanceof operand2 // operator (to compare types)
  +;
Casting Objects,
  - objects may be cast up or down the inheritance path in an inheritance hierarchy
  - Animal anAnimal = (Animal) myDog; // casting up (or upcasting) the inheritance path.
	 - Could also say Animal anAnimal = myDog; because a base class object can always reference a subclass object
Unified Modeling Language (UML),
  - standard industry diagramming notation for object-oriented software development projects
  - class diagrams concisely illustrate the attributes and methods a class will have, and also the relationships between classes
  - `+` indicates public visibility, `-` indicates private visibility, `#` indicates protected visibility
  +;
