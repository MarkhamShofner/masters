
            .globl main
main:       # accent Roman numeral input and output its decimal value
            .text

            # grab the Roman string
            li          $v0, 4        # system call code for print_str
            la          $a0, str      # address of string to print
            syscall                   # print the string

            li          $v0, 8        # system call code for read_string
            la          $a0, buffer   # load byte space into arg0
            li          $a1, 9        # assign byte space allocation in arg1
            syscall                   # read the string
            la          $s1, buffer   # save the string in $s1

            # li          $v0, 4        # system call code for print_str
            # move        $a0, $s1      # address of string to print
            # syscall                   # print the string

            la          $t3, romanI   # load I into a temp variable
            la          $t4, romanV   # load V into a temp variable
            la          $t5, romanX   # load X into a temp variable
            la          $t6, romanL   # load L into a temp variable
            la          $t7, romanC   # load C into a temp variable
            la          $t8, romanD   # load D into a temp variable
            la          $t9, romanM   # load M into a temp variable

# s0: the running total
# s1: input string
# s2:
# s3: loop counter

# t0 holds the temp decimal value of the character
# t3-t9 hold the Roman numeral ascii characters

            add $s3, $zero, $zero       # initialize loop counter ($s3) to 0
            # add $s0, $zero, $zero       # initialize running total ($s0) to 0

            # while count is under 8, move forward through the string starting at the beginning
prep:       lb $t2, 0($s1)
            j triage
prep1:      lb $t2, 1($s1)
            j triage
prep2:      lb $t2, 2($s1)
            j triage
prep3:      lb $t2, 3($s1)
            j triage
prep4:      lb $t2, 4($s1)
            j triage
prep5:      lb $t2, 5($s1)
            j triage
prep6:      lb $t2, 6($s1)
            j triage
prep7:      lb $t2, 7($s1)
            j triage

triage:     # crosswalk the parsed character through the Roman ascii value
            lb $t1, 0($t3)              # load I character
            beq $t2, $t1, I             # if parsed character is I, jump to that function

            lb $t1, 0($t4)              # load V character
            beq $t2, $t1, V             # if parsed character is V, jump to that function

            lb $t1, 0($t5)              # load X character
            beq $t2, $t1, X             # if parsed character is X, jump to that function

            lb $t1, 0($t6)              # load L character
            beq $t2, $t1, L             # if parsed character is L, jump to that function

            lb $t1, 0($t7)              # load C character
            beq $t2, $t1, C             # if parsed character is C, jump to that function

            lb $t1, 0($t8)              # load D character
            beq $t2, $t1, D             # if parsed character is D, jump to that function

            lb $t1, 0($t9)              # load M character
            beq $t2, $t1, M             # if parsed character is M, jump to that function

            j invalid                   # skip value input if the character doesn't match any Romans

I:          addi $t0, $zero, 1          # load 1 into $t0
            j maths

V:          addi $t0, $zero, 5          # load 5 into $t0
            j maths

X:          addi $t0, $zero, 10         # load 10 into $t0
            j maths

L:          addi $t0, $zero, 50         # load 50 into $t0
            j maths

C:          addi $t0, $zero, 100        # load 100 into $t0
            j maths

D:          addi $t0, $zero, 500        # load 500 into $t0
            j maths

M:          addi $t0, $zero, 1000       # load 1000 into $t0
            j maths

invalid:    add $t0, $zero, $zero       # treat invalid input as 0 value
            j maths

maths:      add $s0, $s0, $t0           # add $t0 to the running total $s0

            # re-loop
            addi $s3, 1                 # add 1 to counter
            addi $t1, $zero, 1          # load int value 1
            beq $s3, $t1, prep1         # if counter is 1, jump to that function
            addi $t1, $zero, 2          # load int value 2
            beq $s3, $t1, prep2         # if counter is 2, jump to that function
            addi $t1, $zero, 3          # load int value 3
            beq $s3, $t1, prep3         # if counter is 3, jump to that function
            addi $t1, $zero, 4          # load int value 4
            beq $s3, $t1, prep4         # if counter is 4, jump to that function
            addi $t1, $zero, 5          # load int value 5
            beq $s3, $t1, prep5         # if counter is 5, jump to that function
            addi $t1, $zero, 6          # load int value 6
            beq $s3, $t1, prep6         # if counter is 6, jump to that function
            addi $t1, $zero, 7          # load int value 7
            beq $s3, $t1, prep7         # if counter is 7, jump to that function

            # for debugging
print:      li          $v0, 1        # system call code for print_int
            move        $a0, $s0      # integer to print // $s1
            syscall                   # print it

            # li          $v0, 1        # system call code for print_int
            # move        $a0, $t0      # integer to print // $s1
            # syscall                   # print it

            # End Program
            li $v0, 10
            syscall

        .data
str:        .asciiz "Enter the Roman numerals (8 maximum): \n"
buffer:     .space 9
romanI:      .asciiz "I"
romanV:      .asciiz "V"
romanX:      .asciiz "X"
romanL:      .asciiz "L"
romanC:      .asciiz "C"
romanD:      .asciiz "D"
romanM:      .asciiz "M"
