Computer Org,
  +;

Module 1: Introduction, Overview, History,
  - Define computing system objects and components
  - Recognize computers in everyday objects
  - Identify major events in the history of computing
  - Match computing historical figures with their noted accomplishments.
  +;

Module 2: Negative and Other Numbers,
introduced to computer integer and real numbers; and computer arithmetic.
  - Identify methods of representing integer numerical values in common bases
  - Compare the three common binary integer representations
  - Calculate values using integer computer arithmetic
  - Distinguish the difference between Carry and Overflow in integer computer arithmetic
  - Identify methods for multiplying 2’s complement integers
  - Identify methods of representing floating point numerical values
  - Recognize the IEEE 754 standard format
  - Convert values from one format to another
  +;

signed/unsigned
overflow detected/undetected,
  - overflow does not just mean when a carry outside of the space occurs. it means when a sign changes unexpectedly of the resulting number. value is too large for number of digits.
  - Use two's complement to represent positive and negative numbers because all modern processors do this because of ease of operations.
  - negating a two's complement number: invert all bits and add one
Subtract: change the sign and add
Multiply and divide can be done in a slightly less efficient way if we simply apply the practices we are used to, but with Binary 01001*10111 style contents.
Multiply: booth's algorithm can be more efficient.
Divide: restoring division.
+;

Floating Point Representation,
  - Allows us to represent numbers with fractions (pi, etc.), very small numbers, very large numbers
  - |sign|exponent|fraction|
  - IEEE 754
    - single precision: 32 bit |1|8|23|
    - double precision: 64 bit |1|11|52|
    value: sign(-1) x 1+fraction x 2(exponent-127)
  +;
Accuracy issues with floating point,
  - sometimes maths can lead to rounding errors, so a programmer may decided to use guard/round bits to contain information pre normalization (matching the right number of significant digits and only allowing one digit to the left of a decimal place)
  +;

Module 3: MIPS: Machine and Assembly Language.
  In this module, you will be introduced to the basic operations that the computer hardware performs. You will also be introduced to the MIPS Assembly language and the MIPS Machine language.

  Objectives:
    - Recognize the basic operations that the computer hardware must perform
    - Define the Stored Program Concept
    - Identify the kinds and locations of the Operands that the computer must recognize
    - Explain the constraints faced in creating machine instructions
    - Summarize the four design principles that guided the MIPS construction
    - Identify the structure of the MIPS machine instructions
    - Decode binary MIPS instructions
    - Identify the basic MIPS instruction and the functions that the hardware performs
  +;
SLL,
  - Shift left logical provides a bonus benefit. Shifting left by i bits gives the same result as multiplying by 2i
  +;
Conditional statements in MIPS,
  MIPS compilers use the slt, slti, beq, bne, and the xed value of 0 (always available by reading register $zero) to create all relative conditions: equal, not equal, less than, less than or equal, greater than, greater than or equal.
  +;
Branch,
  - branch based on conditional relations, alter the control flow and select the "next" instruction to be executed based on the result
  +;
Jump address table also called jump table,
  - A table of addresses of alternative instruction sequences.
  +;
Memory organization,
  - large, single-dimension array, with an address (index in the array)
  - sets of bytes (8 bits)
  +;
Word,
  - 4 bytes or 32 bits.
  +;
Register,
  - small memory elements. Special locations within the processor. Hold one word (typically).
  - MIPS processor has 32 registers
  +;
LW and SW,
  Load word (copy all 32 bits to a register) and store word (copy all 32 bits to memory)
  +;
Instructions,
  - 3 operands, whose values are in registers
  - operation, destination, operand 1, operand 2, shamt, funct
  +;
Instruction formats,
  Register
    op - rs - rt - rd - shamt - funct
    operation code - register source - register source two - register destination - shift amount - function code
    6 - 5 - 5 - 5 - 5 - 6
  Immediate
    op - rs - rt - 16 bit value
  Jump
    op - 26 bit word address
  +;
MIPS Register Use Convention,
  Name | Register Number | Usage
  --- | ----- | -----
  $zero | 0 | the constant value 0
  $at | 1 | reserved for Assembler
  $v0-$v1 | 2-3| values for results and expression evaluation, if more - on the stack
  $a0-$a3 | 4-7 | arguments, first four values input into a subroutine, if more - on the stack
  $t0-$t7 | 8-15 | temporaries
  $s0-$s7 | 16-23 | saved
  $t8-$t9 | 24-25 | more temporaries
  $k0-$k1 | 26-27 | reserved for operating system
  $gp | 28 | global pointer
  $sp | 29 | stack pointer
  $fp | 30 | frame pointer
  $ra | 31 | return address
  +;


Module 4 - Assembler Design,
  describing the functions of the Assembler.  These include the Basic and Detailed elements of the algorithm as well as the Assembler features that are independent of the hardware.
  - Identify the Basic Assembly algorithm and the functions that the Assembler must perform.
  - Identify the detailed functions that the Assembler must perform.
  - Identify the additional hardware independent functions that Assembler software performs.
  - Use the Assembly algorithm to construct the output of the Assembly of a small program.
  +;
Assembly language,
  A symbolic language that can be translated into binary machine language.
  +;
Object file for UNIX systems typically contains six distinct pieces:,
- object file header describes the size and position of the other pieces of the object file.
- text segment contains the machine language code.
- static data segment contains data allocated for the life of the program. (UNIX allows programs to use both static data, which is allocated throughout the program, and dynamic data, which can grow or shrink as needed by the program. See Figure 2.13.)
- relocation information identifies instructions and data words that depend on absolute addresses when the program is loaded into memory.
- symbol table contains the remaining labels that are not de ned, such as external references.
 125
- debugging information contains a concise description of how the modules were compiled so that a debugger can associate machine instructions with C source files and make data structures readable.
  +;
Machine Language,
  Binary representation used for communication within a computer system.
  +;
Assembler,
  A program that translates a symbolic version of instruction into the binary version,
  +;
Macro,
  A pattern matching and replacement facility that provides a simple mechanism to name a frequently used sequence of instructions.
  - Allows the programmer to extend the assembly language by defining new operations.
  +;
Linker (or link editor),
  A systems program that combines independently assembled machine language programs and resolves all undefined labels into an executable file.
  +;
General path of instructions,
  Program -> Compiler -> Assembler -> Linker -> Computer.
  Can be worth skipping the compiler phase for embedded comps if speed/size requirements are very high, and optimal performance on the specific hardware is paramount.
  +;
Symbol table,
  A table that matches names of labels to the addresses of the memory words that instructions occupy.
  +;
Basic Assembly Functions,
  - Assign memory addresses to symbolic labels
  - Translate mnemonic operation codes to machine operations
  - Convert data constants into machine codes
  - Build machine instructions in the proper format
  - Write the object program and the assembly listing files
  +;
Assembly phases,
  Pass One to build symbol table then Pass Two. Done in two phases to deal with forward references.
  +;
Object File,
  - output of the Assembler. Binary representations of programs intended to execute directly on a processor.
  +;

Module 5a: MIPS Assembly Control Structures plus SPIM,
  - Identify the MIPS instructions for branch and goto.
  - Construct the standard instruction sequences for the four variations of branch instructions.
  - Construct instruction sequences for these Programming Loops:
    - FOR
    - WHILE
    - UNTIL
  - Identify the MIPS instructions used to support Functions and Subroutines
  - Explain the MIPS register use conventions
  - Illustrate the use of the stack and frame pointers
  +;
Frame pointer,
  a value denoting the location of the saved registers and local variables for a given procedure.
  +;
Subroutines,
  Call a Subroutine
    Jump and Link `JAL` routine-name
    address of subroutine
  return from subroutine: return jump = `JR` $ra
  +;
Memory Stack,
  can handle overflow values that don't fit in the set registers
  stack grows downward (in value) from the high point of a register address (and the stack pointer moves lower with the top of the stack).
  standard push and pop methods.
  +;

Module 5b: SPIM - MIPS Assembler,
  - Install the SPIM simulator.
  - Identify the components of the SPIM simulator.
  - Write a MIPS Assembly language program and using the SPIM simulator execute the program to verify the correctness.
  +;
SPIM,
  self-contained system for running MIPS programs.
  +;

Module 8: Compiler Basics,
  - Identify Compiler Basics
  - Explain Grammar
  - Identify the BNF description language components
  - Explain Lexical analysis
  - Explain Syntax analysis
  - Draw structure parse trees using Parsing – Bottom-Up methods
  - Draw structure parse trees using Parsing - Top-Down methods
  - Explain Semantic analysis
  +;
Abstract syntax tree,
  representation of the syntactic structure of the program
  +;
Basic Compiler Tasks,
  Lexical Analysis - scanner
    Read the input text and find the token objects
  Syntactical Analysis - parser
    From the tokens, discover the structure of the program
      Operator-Precedence Parsing (bottom up)
      Recursive-Descent Parsing (top down)
  Semantic analysis - code generator
    From the structure, create the machine language
  +;
Semantic analysis,
  takes the abstract syntax tree and checks the program for semantic correctness (normally ensures that variables and types are properly declared and that the types of operators an objects match, a step called type checking)
  +;
Major families of instructions (impt),
  Arithmetic (add, sub, addi, ...)
  Data transfer (lw, sw, lb, ...)
  Logical (and, or, sll, ...)
  Conditional branch (bew, bne, slt, ...)
  Jump (jump, jr, jal, ...)
  +;
Lexical Analysis,
  Find and identify the tokens - keywords, operators, identifiers, integers, etc.
  +;
Syntax Analysis,
  Parse tree
  - BOTTOM_UP - begin with the tokens and attempt to build a structure
  - TOP_DOWN - begin with a goal and attempt to reach it
  +;
Semantic Analysis,
  - add the meaning and generate the code
  - type checking
    - confirming that there is operator operand type compatibility
    - making sure branches actually lead somewhere
    - unique names only used once
    - etc.
  +;

Module 9a: Compiler - Additional Tasks,
  - Identify methods for compiling Data structures and storage allocation methods.
  - Recognize Intermediate compiler data forms.
  - Create quadruples.
  - Apply optimization methods.
  - Explain how hardware affects the compiler process.
  - Describe Block structured languages.
  - Discuss compiler design options such as Interpreter and P-Code.
  +;
TRANSLATOR,
  - a program which takes text written in one language (the Source language), and converts it into equivalent text in a second language (the Target or Object language.)
  - If the Source is an abstract high-level language, and the Target is a low-level or machine language, then the translator is a COMPILER
  +;
INSIDE THE BLACK BOX,
  SCANNER
  PARSER
  INTERMEDIATE CODE GENERATION
  SEMANTIC PROCESSOR
  OPTIMIZER
  CODE GENERATOR
  TABLES
  +;
SCANNER,
  Converts the stream of characters from the input medium into an internal format suited for use by the Compiler
    Identify the TOKENS of the language
    Remove extraneous blanks and other white space
    Remove comments
    Report errors discovered
  The SCANNER examines the text, character by character, identifying the TOKENS for the Parser. The SCANNER determines whether the symbol is part of the current TOKEN, extraneous, or the beginning of a new TOKEN.
    Depending on the implementation, the SCANNER returns to the Parser
      One TOKEN at a time,
      All TOKENS in a string separated by a special character, or
      All TOKENS as elements in a table.
      +;
PARSER,
  Analyzes the Tokens output by the Scanner, and verifies that the source program satisfies the Rules of the Language.
  The Rules of the Language are given in the grammar.
  The PARSER verifies the syntax of the language. Is the structure correct?
  Create the Parse tree.
  Report errors in structure.
  +;
INTERMEDIATE CODE GENERATOR,
  Takes the output of the Parser and puts into an Intermediate Form so that it can be
  processed by the remaining parts of the Compiler.
  Looks somewhat like assembly language.
  QUADRUPLES is one example
  +;
SEMANTIC PROCESSOR
  Checks the validity of the code.
  Is the MEANING of the statements correct ?
  Are the elements of the code correct in the context in which they are found ?
  For example:
    Are the variables declared exactly once?
    Are the correct data types specified for each operand ?
    Reports errors or perhaps fixes errors using ‘intelligent’ guesses at what the programmer intended.
    +;
OPTIMIZER,
  Module specifically designed to improve some combination of time and space characteristics of the code.
  Register allocation to reduce the number of memory loads and stores.
  Move loop invariant computations
  Compile-time Arithmetic
  +;
CODE GENERATION,
  Takes the intermediate code and generates Assembly or machine language code.
  Highly target machine dependent.
  +;

Module 10a: Linker-Loader,
  - Identify the Loading process
  - Illustrate program Relocation
  - Paraphrase the Linking Algorithm
  - Explain how hardware affects the linking process.
  - Compare the concept of value assignments at Assembly, Linking, and Load time
  - Explain each of these Loader Features:
    - Library Search;
    - Process Options;
    - Linkage Editor;
    - Dynamic Linking;
    - Loader Design
  - Identify a Bootstrap Loader example
  +;
Linker - or link editor,
  - A systems program the combines independently assembled machine language programs and resolves all undefined labels into an executable file.
  - take independently assembled machine language programs and "stitches" them together, which allows us to compile and assemble procedures independently, so that changes to procedures only require compiling and assembling that procedure
  +;
Executable File,
  - A functional program in the format of an object file that contains no unresolved references.
  - It can contain symbol tables and debugging information. A "stripped executable" does not contain that information. Relocation information may be included for the loader.
  +;
Loader,
  - A systems program that places an object program in main memory so that it is ready to execute.
  Steps:
    - determines size of the text and data data segments
    - creates address space large enough for the text and data
    - copies parameters (if any) to the main program onto the stack
    - initializes the machine registers and sets the stack pointer to the first free location
    - jumps to a start-up routine that copies params into the argument registers and calls the main routine of the program. terminates once returned with an exist system call.
  +;
Relocation,
  - modify the object program so that it can be loaded at any address in memory.
  +;

Module 10b: Operating System Basics,
  - Explain why Operating System software was created, and its influence on computer organization.
  - Recite the Basic operating system software functions.
  - Describe the issues of Memory management.
  - Compare Real memory management techniques with the virtual memory method.
  - Explain how hardware affects the memory management process.
  - Explain how hardware differences affect the processing for:
    - I/O supervision
    - Device management
    - File processing
    - Interrupt processing
  +;
RAID (Redundant Arrays of Inexpensive Disks),
  - An organization of disks that uses an array of small and inexpensive disks so as to increase both performance and reliability
  +;
Mirroring,
  Writing identical data to multiple disks to increase data availability.
  +;

Module 11: Operating Systems - Additional Tasks,
  - Illustrate Process scheduling methods.
  - Describe Process Threads.
  - Compare Job scheduling with Process scheduling.
  - Explain Resource allocation.
  - Identify Data security methods.
  - Illustrate the Public key – Private key encryption method.
  - Compare Program Protection methods.
  +;
