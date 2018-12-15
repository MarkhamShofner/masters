Computer Architecture,
  +;
1: Architecture Overview and Computer Performance Metrics,
Introduces the concept of computer architecture and contrasts computer architecture with computer organization and implementation. The instruction set architecture (ISA) is examined as a means of creating a common software interface across different models in a computer family and as a means of providing backward compatibility. RISC versus CISC design approaches are also compared and several performance metrics are defined and explained as ways of assessing the impact of performance enhancement techniques.
  - Identify the different views of a computer from software applications to hardware circuits
  - Identify eight influential ideas affecting computer architecture
  - Classify and describe the classical von Neumann (Princeton) and Harvard architectures.
  - Explain the differences between RISC and CISC processors
  - Describe the MIPS instruction set architecture.
  - Understand the metrics used to evaluate different systems.
  - Describe the relationship between CPU time, CPU clock cycles, and clock rate.
  - Calculate clock cycles per instruction.
  - Use Amdahl’s law.
  +;
Response time,
  Also called execution time. The total time required for the computer to complete a task, including disk accesses, memory accesses, I/O activities, operating system overhead, CPU execution time, and so on.
  +;
Classic CPU Performance Equation,
  CPU time = Instruction count x CPI x Clock cycle time
  CPU time = ( Instruction count x CPI ) / Clock rate
  Seconds/Program = Instructions/Program x Clock cycles/program x Seconds / Clock cycle
  [CPI = (Clock Cycles / Instruction)]
  +,
Computer Level Hierarchy,
  Level 6 | User                | Executable Programs
  Level 5 | High-Level Language | C++, Java, FORTRAN, etc..
  Level 4 | Assembly Language   | Assembly Code
  Level 3 | System Software     | Operating System, Library Code
  Level 2 | Machine Code        | Instruction Set Architecture
  Level 1 | Control             | Microcode or Hardwired
  Level 0 | Digital Logic       | Circuits, Gates, 1s and 0s, etc.
  Comp Arch focuses on the bottom three levels (2,1,0)
  +;
Computer Organization versus Computer Architecture,
  - Comp Arch -  contract with software stating unambiguously what the hardware does. The architecture was essentially a set of statements of the form "If you execute this instruction (or get an interrupt, etc.), then that is what happen
  - Comp Org - defines how the instructions are carried out. high-level description of the logic, memory, etc., used to implement that contract: These registers, those data paths, this connection to memory, etc. Also called microarchitecture - describes how the capability defined by the architecture is implemented.
  - Analogy - arch of a clock defined by the movement of the hands on a marked dial, but one clock may be driven by an entirely different mechanism than another (with the same arch).
  +;
Computer Family,
  - set of computers that share a common architecture (intel x86, motorola 68000, MIPS, etc.)
  +;
3 major components of comp arch (Princeton / von Neumann),
  CPU,
  Main Memory system,
  Input/Output
  +;
1/2/3 address instructions,
  number (costs) of memory addresses/registers for an instruction
  +;
MAR (memory address register),
  holds the address of the item in memory to be accessed.
  +;
MDR (memory data register),
  receives the item read from memory or holds the item to be written into memory.
  +;
MAR and MDR,
  serve as the interface between the CPU and memory
  +;
IR,
  instruction register. instruction fetch (transfer from MDR into the IR)
  +;
PC,
  program counter register. holds the address of the next instruction to be fetched from memory.
  +;
MIPS,
  - Microprocessor without Interlocked Pipeline Stages is a Reduced Instruction Set Computer (RISC) instruction set architecture.
  - three instruction formats
  - four addressing modes
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

Module 2 - ,
  internal machine format of both numeric and non-numeric data, including the way in which signed and unsigned integers as well as floating point values are represented. The impact of the word size and of the data format on the range and precision of numeric values is explained along with the most common techniques for encoding characters. The format used to represent machine code instructions will also be explained. Algorithms for integer and floating point computations are examined to set the stage for studying their implementation within the arithmetic logic unit (ALU).
  - Understand the difference between RISC and CISC processors
  - Convert decimal numbers to binary integer representation and vice versa.
  - Convert decimal numbers to integer representation and vice versa.
  - Determine the range of values possible in integer and floating point numbers.
  - Carry out (on paper) integer and floating point arithmetic processes.
  +;
Two's complement,
  -  first shortcut is a quick way to negate a two’s complement binary number. Simply invert every 0 to 1 and every 1 to 0, then add one to the result
RISC v CISC,
  Reduced Instruction Set Computers.
    example of a RISC instruction - add
  Complex Instruction Set Computers.
    example of a CISC instruction - moving an element from one array to another and updating the indices of both arrays
    - addressing modes that interface more easily with advanced data structures
  +;
Semantic gap,
  - Difference in the way operations are specified in an expressive high-level language such as Java or C++ and the way in which such operations are implemented in hardware.
  +;
CISC,
  - CISC type instructions allow the use of multiple memory operands, each of which may be referenced using a different addressing mode.
  - Instructions support a large and flexible set of operations.
  - Tend to vary in size from as little as one byte to as many as 15 or more bytes
  examples -
    - string scan
    - translate (table lookup)
    - loop
    - push/pop registers to/from the stack
  +;
RISC,
  - (moved away from CISC for speed and consistency. hardwired logic as opposed to microprogramming and heavier CISC lag. can pipeline and overlap execution of instructions)
  - smaller instruction sets that include simple straightforward Instructions
  - simple addressing modes
  - fixed size instructions
  - limit memory access to only load and store type instructions
  - can lead to code expansion due to higher # of required instructions
  - simpler nature of instructions means that the control unit is less complex and consumes less space, leaving more space for registers
  +;
Overflow,
  - occurs when the result from an operation cannot be represented with the available hardware.
  - can affect the sign bit (or the 33rd bit with 32 bit representation)
  +;
Arithmetic Logic Unit (ALU),
  Hardware that performs addition, subtraction, and usually logical operations such as AND and OR.
  +;
Floating point,
  Computer arithmetic that represents numbers in which the binary point is not fixed (as it is for integers).
  1|8|23
  sign|exponent|fraction
  +;
Fraction,
  the value, generally between 0 and 1, placed in the fraction field. also called the mantissa
  +;
Overflow/underflow (floating-point),
  positive/negative exponent becomes too large to fit into exponent field
  +;
Double/single precision,
  fpv represented in two/one 32-bit word(s)
  +;
IEEE 754 floating-point standard,
  the industry standard since 1980.
  (-1)^S x (1 + Fraction) x 2^(Exponent-Bias)
  [bias is typically 127]
  +;
Guard,
  The first of two extra bits kept on the right during intermediate calculations of floating-point numbers; used to improve rounding accuracy
  +;
Round,
  Method to make the intermediate floating-point result fit the floating-point format; the goal is typically to find the nearest number that can be represented in the format.
  +;
Sticky bit,
  A bit used in rounding in addition to guard and round that is set whenever there are nonzero bits to the right of the round bit.
  +;

Module 3: The Datapath and Digital Logic,
  view of the computer system as multiple levels of virtual machines. A summary of the MIPS machine architecture is provided and the MIPS datapath is examined as an example of a typical RISC system. Basic logic gates and their operation are analyzed to set the stage for examining the implementation of the ALU and control unit.
    - Explain MIPS machine instruction formats.
    - Disassemble MIPS machine instruction.
    - Use MIPS assembly language statements.
    - Simplify Boolean Expressions.
    - Derive Boolean Functions from truth tables.
    - Implement simple functions using basic logic gates.
    - Analyze the operation of multiplexers, decoders, adders and shifters.
    - Explain the difference between combinational and sequential circuits.
  +;
Asserted/Deasserted signals,
  Signal that is logically true (or 1) / false (or 0)
  +;
Combinational logic,
  A logic system whose blocks do not contain memory and hence computer the same output given the same input.
  +;
Sequential logic,
  A group of logic elements that contain memory and hence whose value depends on the inputs as well as the current contents of the memory.
  +;
Truth Tables,
  - extension of combinational logic block (since these have no memory and can be completely specified/understood by defining the values of the outputs based on each possible set of inputs)
  - for n inputs, there are 2^n entries in the truth table
  +;
Boolean Algebra,
  - OR operator is written as + -- A + B -- only one need be true
  - AND operator is written as * -- A * B -- both must be true
  - NOT is written with a __ above the A -- must be false
  +;
Gate,
  a device that implements basic logic functions, such as AND or OR.
  +;
Decoder,
  Logic block that has an n-bit input and 2n outputs, where only one output is asserted for each input combination.
  +;
Sum of products,
  a form of logical representation that employs a logical sum (OR) of products (terms joined using the AND operator)
  +;
Read-only memory (ROM),
  contents are designated at creation time, after which can only be read.
  +;
Bus,
  - collection of data lines that is treated together as a single logical signal.
  - also, a shared collection of lines with multiple sources and uses.
  +;
Arithmetic Logic Unit (ALU),
  - brawn of the computer, the device that performs the arithmetic operations like addition and subtraction or logical operations like AND and OR
  +;

Module 4: ALU and Control Unit Implementation,
  the control unit (sometimes referred to as the "brain" of the system) which is responsible for generating the signals required to direct the datapath in carrying out the steps required for each machine instruction. Two approaches to implementing the control unit (single-cycle and multi-cycle) are described along with details on the use of logic gates and programmable logic devices in generating the control signals. A finite state machine will be defined and used to model the behavior required for the multi-cycle control unit.
  - Explain the purpose of the 4 ALU control bits.
  - List the instructions that comprise the core MIPS subset.
  - Identify the steps required to execute the core MIPS instructions.
  - Specify whether an integer add or subtract causes an overflow.
  - Identify where in the datapath the various control bits are used.
  - Describe how the ALU generates the zero flag to control branching.
  - Determine the minimum cycle time required for the datapath.
  - Assess the speed advantage of the look-ahead carry adder.
  +;
Combinational element,
  An operation element, such as an AND gate or an ALU.
  +;
State element,
  A memory element, such as a register or a memory.
  +;
Clocking methodology,
  The approach used to determine when data is valid and stable relative to the clock.
  +;
Edge-triggered clocking,
  A clocking scheme in which all state changes occur on a clock edge.
  +;
Datapath element,
  A unit used to operate on or hold data within a processor. In the MIPS implementation, the datapath elements include the instruction and data memories, the register file, the ALU, and adders.
  +;
Program Counter (PC),
  The register containing the address of the instruction in the program being executed.
  +;
Register File,
  A state element that consists of a set of registers that can be read and written by supplying a register number to be accessed.
  +;
Sign-extend,
  To increase the size of a data item by replicating the high-order sign bit of the original data item in the high-order bits of the larger, destination data item.
  +;
Datapath for all three instruction types,
  Figure 4.15 on page 263
  +;
9 control signals,
  Determine which actions are taken in the datapath.
  Figure 4.16 on page 264
  +;
Single-cycle implementation,
  An implementation in which an instruction in executed in one clock cycle. Not as efficient as it could be.
  +;

Module 5 - Microprogrammed Implementation,
  In this module, techniques such as ROM lookup tables, programmable logic arrays and microprogramming are illustrated as alternatives for the implementation of the control unit. A finite state machine is defined and used to model the control unit, introduced in module 4. A comparison is made between the single-cycle and multi-cycle design options. Multi-cycle execution will serve as a basis for the description of pipelining in module 6:
  - Identify the components and explain the operation of finite state machines (FSM).
  - Distinguish between Moore machines and Mealy machines.
  - Map the steps required to execute the core MIPS instructions onto the FSM.
  - Define PLAs and use them to implement simple logic functions.
  - Describe how micro-instructions are used for datapath control.
  - List the relative advantages of micro-programmed versus hardwired control.
  - Explain how micro-programming can serve as a basis for processor emulation.
  +;
Control,
- Control typically has two parts: a combinational part that lacks state and a sequential control unit that handles sequencing and the main control in a multicycle design. Combinational control units are often used to handle part of the decode and control process.
- ALU is an Example
- The most straightforward way to implement a sequential control function is with a block of logic that takes as inputs the current state and the opcode field of the Instruction register and produces as outputs the datapath control signals and the value of the next state
  +;
Multi-cycle Implementation,
  - instructions are broken up in to a number of microinstructions, where each takes one cycle to move through the data path
  - each microinstruction performs one step in a machine instruction
  +;
Programmable logic array,
  a kind of programmable logic device used to implement combinational logic circuits. The PLA has a set of programmable AND gate planes, which link to a set of programmable OR gate planes, which can then be conditionally complemented to produce an output
  +;

Module 6 - Pipelined Implementation,
  introduces the concept of instruction pipelining and describes the basic MIPS 5-stage pipeline. The function of each pipeline stage is explained and the flow of instructions through the pipeline is illustrated by several examples. Improvement in processor throughput and performance is demonstrated by comparing the sequential execution of instructions with pipelined execution as a means of achieving instruction level parallelism (ILP).
  - Describe the operation of instruction pipelines and their impact on computer performance.
  - Characterize the impact of data dependencies and control hazards on pipeline throughput.
  - Divide the MIPS data path into pipeline stages.
  +;
pipelining,
  An implementation technique in which multiple instructions are overlapped in execution, much like an assembly line.
  +;
latency,
  - the number of stages in a pipeline or the number of stages between two instructions during execution
  - pipelining improves instruction throughput rather than individual instruction execution time or latency.
  +;
Other terms,
  - forwarding (data values to registers (or bypassing the registers) so they don't hold up the pipelining process)
  - Hazards (data, control, resource) that hold up pipeline
  - nops, stalls, bubbled
Control Hazards,
  - assume branch not taken, then flush the instructions if it ended up being taken.
  - can use dynamic branch prediction. prediction of branches at runtime. by using a branch prediction buffer or branch history table.
  +;

-------------------------------------------------------------------,
  -------------------------------------------------------------------------------------------------------
  -------------------------------------------------------------------------------------------------------
  +;

Module 7 - Multiple Functional Units and Superscalar Operations,
  - completes the coverage of pipelining by explaining how branch instructions disrupt the flow of instructions through the pipeline and examining techniques to handle these “control hazards". It also explains how the use of multiple functional units and superscalar techniques push the throughput of the system beyond the one instruction per cycle goal of scalar pipeline.
  - Identify how the hardware detects if there is a hazard and compensates for that hazard using forwarding and stalls.
  - Describe how superscalar pipelines issue multiple instructions.
  +;
Exception,
  an unscheduled event that disrupts program execution; used to detect Overflow
  +;
Interrupt,
  an exception that comes from outside [in MIPs definition] of the processor
  +;
Multiple issue,
  a scheme whereby multiple instructions are launched in one clock cycle.
  +;
Static multiple issue,
  an approach to implementing a multiple-issue processor where many decisions are made by the compiler before execution.
  +;
Dynamic multiple issue,
  an approach to implementing a multiple-issue processor where many decisions are made during execution by the processor.
  +;
Issue slots,
  the positions from which instructions could issue in a given clock cycle (starting blocks for a track sprint).
  +;
Speculation,
  compiler or processor guesses the outcome of an instruction to remove it as a dependence in executing other instructions.
  +;
Loop unrolling,
  A technique to get more performance form loops that access arrays, in which multiple copies of the loop body are made and instructions from different iterations are overlapped
  +;
Superscalar,
  An advanced pipelining technique that enables the processor to execute more than one instruction per clock cycle by selecting them during execution.
  +;
Dynamic pipeline scheduling,
  hardware support for reordering the order of instruction execution so as to avoid stalls.
  +;
Commit unit,
  decides when it is safe to release the result of an operation to programmer-visible registers and memory
  +;

Module 8 - The Memory System,
  +;
Principle of locality,
  states that programs access a relatively small portion of their address space at any instant of time.
  +;
Temporal locality,
  principle stating that if a data location is referenced, then it will tend to be referenced again soon.
  +;
Spatial locality,
  principle stating that if a data location is referenced, data locations with nearby addresses will tend to be referenced again soon.
  +;
Memory Hierarchy,
  - structure that uses multiple levels of memories; as the distance from the processor increases, the size of the memories and the access time both increase.
  - SRAM -> DRAM -> Magnetic disc (small --> large, fast --> slow)
  +;
General memory terms,
  - hit rate (fraction of accesses found in a level of the hierarchy)
  - miss rate
  - hit time
  - miss penalty (time required to fetch block)
  +;
DRAM,
  Dynamic Random Access Memory. Main memory.
  +;
SRAM,
  Static Random Access Memory. Levels closer to the processor (caches). More expensive ($) and space per bit, faster.
  +;
Flash memory,
  type of EEPROM (electrically erasable programmable read-only memory)
  +;
Magnetic Disk,
  largest and slowest
  +;
RAM,
  read/write, can be changed or updated
  +;
ROM,
  read only, can be read but not changed
  +;
Big endian,
  - most significant bits would be stored in lowest address (so 4 byte words, would store most important in first byte - 200 would have 1&2, 201 would have 3&4, etc.. in terms of importance)
  - this storage order is used in MIPS
  +;
Little endian,
  - least significant bits in the first byte
  +;
S-R Latch,
  Set-Reset circuit/latch
  +;
S-R flip-flop,
  similar to S-R latch, but controlled by clock edge
  +;
D-latch,
  when C (the clock) is high, Q takes on the same value as D
  chances wi
  +;
D flip-flop,
  same as d-latch but changes with the falling edge of the clock
  +;

9: Cache Organization and Virtual Memory,
how the different types of computer storage (registers, cache memory, main memory, disk systems, etc.) can be viewed as a multi-level hierarchical system and discusses the variation in the speed, capacity and management of the various levels. The concept of a cache memory will be explained along with techniques for mapping blocks from memory into lines within direct mapped, set associative, and fully associative caches. The impact of the cache hit ratio on the average access time to memory and on overall performance will also be examined. A distinction is drawn between logical addresses and physical address and the concepts underlying virtual memory systems are also explained.
  - Define the concept of locality.
  - Distinguish between temporal and spatial locality.
  - Explain the different levels in the memory hierarchy.
  - Calculate the effective memory access time using cache.
  - Compare different cache organizations.
  - Analyze various cache mapping schemes.
  - Explain the concepts that underlie virtual memory.
  - Contrast the operation of virtual memory and cache memory.
  +;
Direct-mapped cache,
  A cache structure in which each memory location is mapped to exactly one location in the cache.
  +;
Types,
  - Fully Associative - separate comparator is required for every cache line
  - Direct-mapped - only one comparator is required for entire cache
  - Set Associative -
  +;
Methods to replace lines in cache if cache is full,
  - Random
  - FIFO
  - LRU (Least Recently Used) - most common and sensical choice
  +;
Virtual Memory,
  - cache makes memory appear to be faster
    - blocks/lines
  - virtual memory makes main memory appear to be larger
    - pages/frames that map from virtual to physical memory
  +;
Some terms,
  - Address mapping
  - Direct mapping
  - 2-way set associative
  - 4-way set associative

  notes
  - block address = B * block size
  - slide 21
  - cache size / block size = number of blocks
  - offset calculated by taking log2 size of block
  +;

Module 10: Input/Output Systems,
  how the different types of computer storage (registers, cache memory, main memory, disk systems, etc.) can be viewed as a multi-level hierarchical system and discusses the variation in the speed, capacity and management of the various levels. The concept of a cache memory will be explained along with techniques for mapping blocks from memory into lines within direct mapped, set associative and fully associative caches. The impact of the cache hit ratio on the average access time to memory and on overall performance will also be examined. A distinction is drawn between logical addresses and physical address and the concepts underlying virtual memory systems are also explained. Goals:
  - Identify the hardware components that make up the I/O system.
  - Describe the operation of I/O components.
  - Explain the role of software such as device drivers in facilitating I/O.
  - Contrast Memory-mapped I/O with port-mapped I/O.
  - Analyze the different options for controlling I/O.
  - Explain the operation and use of interrupts.
  - Assess the impact of I/O on system performance.
  +;
I/O performance measurements,
  - I/O throughput or bandwidth
  - I/O transactions per unit time
  +;
Amdahl's law,
  formula which gives the theoretical speedup in latency of the execution of a task at fixed workload that can be expected of a system whose resources are improved.
  +;

Module 11: Bus Systems and Internal Communication,
   the bus system as a mechanism for communication and data transfer among the CPU, main memory and I/O devices within the computer system. The different types of buses are identified and the steps involved in typical bus transactions are explained along with techniques for controlling and arbitrating the use of the bus system. The module also defines the concept of disk arrays and describes the properties and operation of the most common RAID systems.
   - Define “bus” and explain the role it plays in performing I/O.
   - Describe the different types of buses used within the computer.
   - Assess the relative performance of parallel and serial buses.
   - Explain different bus arbitration techniques.
   - Analyze bus timing strategies.
   - Explain the operation of disk arrays (RAID).
   - Assess the relative performance of different RAID systems.
   - Compare how different RAID systems provide redundancy.
   +;
RAID (Redundant Arrays of Inexpensive Disks)
  An organization of disks that uses an array of small and inexpensive disks so as to increase both performance and reliability
  +;
Bus Systems,
  - data lines, control lines, address lines
  - can be serial or parallel
  - bus bandwidth
  +;

Module 12: Multi-Processor and Multi-Core Systems,
  - Parallel Processing
  - Flynn's Taxonomy and Vector Processing
  - MIMD
  - GPUs
  - Multi-threading and Clustering
  +;
Parallel Processing,
  - connecting multiple computers to achieve higher performance
  - tends to be more valuable (in terms of overhead, partitioning, communication cost etc.) as the size of the problem increases
  +;
Flynn's Taxonomy,
  categorizing multiprogramming architectures
                                 | Data Streams                |
                                 | Single       | Multiple     |
  Instruction Streams | Single   | SISD (scalar)| SIMD (vector)|
                      | Multiple | MISD (none)  | MIMD         |
  +;
Vector Processing,
  - can do many calculations/operations at a time.
  - vector chaining
  +;
MIMD,
  SMP - shared memory multiprocessor
    there is a need to synchronize shared variables using locks
    UMA - Uniform Memory Access
    NUMA - Non-uniform Memory Access
      - faster local processor memory access than UMA, slower remote access
  +;
Multithreading,
  Fine-grain - switch threads after each cycle
  Course-grain - switch on long stall (miss, etc.)
  Simultaneous
  +;
GPUs (Graphics Processing Unit),
  Highly data-parallel. Many threads running at a time
  
  +;
