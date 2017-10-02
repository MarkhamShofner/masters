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
Method, set of code that performs a well-defined function. In other programming languages, methods may be called subroutines or functions.
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
