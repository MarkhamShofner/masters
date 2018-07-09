# Applying the following logic. If there are 50 numbers in a pool and we need to pick 5 to win.
# The chance we pick _one_ of the numbers is 5 in 50. Then the chance we pick a _second_ number is 4 in 49.
# Then 3 in 48, etc... down to 1 in 46. So (5/50*4/49*3/48*2/47*1/46). This would be (pick!)/[(pool!)/(pool-pick)!]
# Which can be simplified to [(pick!)*(pool-pick)!]/(pool!)
# Since the output requested for this exercise is not the chance of the occurrence but rather the 1 in X form,
# Let's invert this formula to be (pool!)/[(pick!)*(pool-pick)!]
# Since the largest MIPS single precision integer value will not hold the value of more than 12 Factorial
# we need to adjust this formula to reflect that (pool!)/(pick!) = (pool)*(pool-1)*(pool-2)*...(pool-pick)
# Leading us to (modifiedPool)!/(pick)!

.globl main
main:   # winning lottery odds based on passed in parameters
        .text

        li          $v0, 4        # system call code for print_str
        la          $a0, strLrg1  # address of string to print
        syscall                   # print the string

        li          $v0, 5        # system call code for prompt_int
        syscall                   # get int
        move        $s1, $v0      # save Large Pool in $s1

        li          $v0, 4        # system call code for print_str
        la          $a0, strLrg2  # address of string to print
        syscall                   # print the string

        li          $v0, 5        # system call code for prompt_int
        syscall                   # get int
        move        $s2, $v0      # save Large Pick in $s2

        li          $v0, 4        # system call code for print_str
        la          $a0, strSml1  # address of string to print
        syscall                   # print the string

        li          $v0, 5        # system call code for prompt_int
        syscall                   # get int
        move        $s3, $v0      # save Small Pool in $s3

        li          $v0, 4        # system call code for print_str
        la          $a0, strSml2  # address of string to print
        syscall                   # print the string

        li          $v0, 5        # system call code for prompt_int
        syscall                   # get int
        move        $s4, $v0      # save Small Pick in $s4


        # (pool!)/[(pick!)*(pool-pick)!]
        # pool!
        move        $a0, $s1      # Large Pool to arg0
        jal         factrl        # run the factorial method
        move        $t7, $v0      # store the result

        # modifiedPool! (Large)
        move        $a0, $s1      # Large Pool to arg0
        sub         $a1, $s1, $s2 # (Large Pool - Large Pick) to find stopping point
        add         $a1, $a1, 2   # add 2 to the argument to avoid extra loops
        jal         modfactrl     # run the factorial method
        move        $t2, $v0      # store the result

        # pick! (Large)
        move        $a0, $s2      # Large Pick to arg0
        jal         factrl        # run the factorial method
        move        $t3, $v0      # store the result

        # Cdds of getting Large Pool correct
        div         $s5, $t2, $t3

        # (pool-pick)!
        # sub         $t0, $s1, $s2 # calculate pool-pick
        # li          $v0, 1        # system call code for print_int
        # move        $a0, $t0      # integer to print // $s1
        # syscall                   # print it


        #  move        $a0, $s1      # Large Pool to arg0
        #  move        $a1, $s2      # Large Pick to arg1
        #  jal         factrl        # run the factorial method
        #  move        $t7, $v0      # store the result

        # For debugging
        li          $v0, 1        # system call code for print_int
        move        $a0, $t7      # integer to print // $s1
        syscall                   # print it
        li          $v0, 1        # system call code for print_int
        move        $a0, $zero    # integer to print // $s1
        syscall                   # print it
        li          $v0, 1        # system call code for print_int
        move        $a0, $t2      # integer to print // $s1
        syscall                   # print it
        li          $v0, 1        # system call code for print_int
        move        $a0, $zero    # integer to print // $s1
        syscall                   # print it
        li          $v0, 1        # system call code for print_int
        move        $a0, $t3      # integer to print // $s1
        syscall                   # print it
        li          $v0, 1        # system call code for print_int
        move        $a0, $zero    # integer to print // $s1
        syscall                   # print it
        li          $v0, 1        # system call code for print_int
        move        $a0, $s5     # integer to print // $s1
        syscall                   # print it
        li          $v0, 1        # system call code for print_int
        move        $a0, $zero    # integer to print // $s1


        # End Program
        li $v0, 10
        syscall

######### Factorial Subroutine Fall 2016
#
# Given n, in register $a0;
# calculate n!, store and return the result in register $v0

factrl: sw $ra, 4($sp)              # save the return address
        sw $a0, 0($sp)              # save the current value of n
        addi $sp, $sp, -8           # move stack pointer
        slti $t0, $a0, 2            # save 1 iteration, n=0 or n=1; n!=1
        beq $t0, $zero, L1          # not less than 2, calculate n(n-1)!
        addi $v0, $zero, 1          # n=1; n!=1
        jr $ra                      # now multiply

L1:     addi $a0, $a0, -1           # n = n-1
        jal factrl                  # now (n-1)!
        addi $sp, $sp, 8            # reset the stack pointer
        lw $a0, 0($sp)              # fetch saved (n-1)
        lw $ra, 4($sp)              # fetch return address
        mul $v0, $a0, $v0           # multiply (n)*(n-1)
        jr $ra                      # return value n!

# P Snyder 14 August 2016
######### End of the subroutine

######### Modified Factorial Subroutine Summer 2018
#
# Given n and r, in registers $a0 and $s1;
# calculate (n)*(n-1)*(n-2)*...(r), store and return the result in register $v0

modfactrl: sw $ra, 4($sp)           # save the return address
        sw $a0, 0($sp)              # save the current value of n
        addi $sp, $sp, -8           # move stack pointer
        # slti $t0, $a0, 2          # save 1 iteration, n=0 or n=1; n!=1
        # beq $t0, $a1, Loop1       # not less than $a1, calculate n(n-1)!
        slt $t0, $a0, $a1           # save 1 iteration, n=0 or n=1; n!=1
        beq $t0, $zero, Loop1       # not less than 2, calculate n(n-1)!
        addi $v0, $zero, 1          # n=1; n!=1
        jr $ra                      # now multiply

Loop1:  addi $a0, $a0, -1           # n = n-1
        jal modfactrl               # now (n-1)!
        addi $sp, $sp, 8            # reset the stack pointer
        lw $a0, 0($sp)              # fetch saved (n-1)
        lw $ra, 4($sp)              # fetch return address
        mul $v0, $a0, $v0           # multiply (n)*(n-1)
        jr $ra                      # return value n!

# P Snyder 14 August 2016, modified by M Shofner 9 July 2018
######### End of the subroutine



        .data
str:
            .asciiz "The odds are 1 in "
strLrg1:
            .asciiz "Size of the large pool? \n"
strLrg2:
            .asciiz "Picks needed from the large pool? \n"
strSml1:
            .asciiz "Size of the small pool? \n"
strSml2:
            .asciiz "Picks needed from the small pool? \n"
stopped:
            .asciiz "\nStopped."
