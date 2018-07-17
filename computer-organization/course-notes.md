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
overflow detected/undetected
  - overflow does not just mean when a carry outside of the space occurs. it means when a sign changes unexpectedly of the resulting number. value is too large for number of digits.
- Use two's complement to represent positive and negative numbers because all modern processors do this because of ease of operations.
  - negating a two's complement number: invert all bits and add one
Subtract: change the sign and add
Multiply and divide can be done in a slightly less efficient way if we simply apply the practices we are used to, but with Binary 01001*10111 style contents.
Multiply: booth's algorithm can be more efficient.
Divide: restoring division.

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

- Shift left logical provides a bonus benefit. Shifting left by i bits gives the same result as multiplying by 2i

Conditional statements in MIPS,
  MIPS compilers use the slt, slti, beq, bne, and the  xed value of 0 (always available by reading register $zero) to create all relative conditions: equal, not equal, less than, less than or equal, greater than, greater than or equal.
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
  $ra | 31 | return adress
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
- object  file header describes the size and position of the other pieces of the object  file.
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

Module 5a: MIPS ASsembly Control Structures plus SPIM,
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





-
