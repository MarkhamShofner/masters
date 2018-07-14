# Applying the following logic. If there are 50 numbers in a pool and we need to pick 5 to win.
# The chance we pick _one_ of the numbers is 5 in 50. Then the chance we pick a _second_ number is 4 in 49.
# Then 3 in 48, etc... down to 1 in 46. So (5/50*4/49*3/48*2/47*1/46). This would be (pick!)/[(pool!)/(pool-pick)!]
# Which can be simplified to [(pick!)*(pool-pick)!]/(pool!)
# Since the output requested for this exercise is not the chance of the occurrence but rather the 1 in X form,
# Let's invert this formula to be (pool!)/[(pick!)*(pool-pick)!]
# Since the largest MIPS single precision integer value will not hold the value of more than 12 Factorial
# we need to adjust this formula to reflect that (pool!)/(pick!) = (pool)*(pool-1)*(pool-2)*...(pool-pick)
# Leading us to (modifiedPool)!/(pick)! for each group. Then groupA*groupB for combined chance.

.globl main
main:   # winning lottery odds based on passed in parameters
        .text

        # grab the params
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

        li          $v0, 4        # system call code for print_str
        la          $a0, str      # address of string to print
        syscall                   # print the string

        # modifiedPool! (Large)
        move        $a0, $s1      # Large Pool to arg0
        sub         $a1, $s1, $s2 # (Large Pool - Large Pick) to find stopping point
        add         $a1, $a1, 2   # add 2 to the argument to avoid extra loops
        jal         modfactrl     # run the factorial method
        move        $t7, $v0      # store result as temp
        slt         $t6, $t7, 2   # is the result less than 2 (was the modfactorial return off)
        beq         $t6, $zero, ElseLrg # if not jump and store
        move        $t2, $s1      # if true store as pool
        j           EndLrg        # end
  ElseLrg:
        move        $t2, $v0      # store the result
  EndLrg:

        # pick! (Large)
        move        $a0, $s2      # Large Pick to arg0
        jal         factrl        # run the factorial method
        move        $t3, $v0      # store the result

        # Odds of getting Large Pool correct
        div         $s5, $t2, $t3

        # modifiedPool! (Small)
        move        $a0, $s3      # Small Pool to arg0
        sub         $a1, $s3, $s4 # (Small Pool - Small Pick) to find stopping point
        add         $a1, $a1, 2   # add 2 to the argument to avoid extra loops
        jal         modfactrl     # run the factorial method
        move        $t7, $v0      # store result as temp
        slt         $t6, $t7, 2   # is the result less than 2 (was the modfactorial return off)
        beq         $t6, $zero, ElseSml # if not jump and store
        move        $t4, $s3      # if true store as pool
        j           EndSm         # end
  ElseSml:
        move        $t4, $v0      # store the result
  EndSm:

        # pick! (Small)
        move        $a0, $s4      # Small Pick to arg0
        jal         factrl        # run the factorial method
        move        $t5, $v0      # store the result

        # Odds of getting Small Pool correct
        div         $s6, $t4, $t5

        # Odds of getting both pools correct
        mul         $s0, $s5, $s6

        # Print result
        li          $v0, 1        # system call code for print_int
        move        $a0, $s0      # integer to print
        syscall                   # print it

        # For debugging
        # li          $v0, 1        # system call code for print_int
        # move        $a0, $zero    # integer to print // $s1
        # syscall                   # print it
        # li          $v0, 1        # system call code for print_int
        # move        $a0, $t2      # integer to print // $s1
        # syscall                   # print it
        # li          $v0, 1        # system call code for print_int
        # move        $a0, $zero    # integer to print // $s1
        # syscall                   # print it
        # li          $v0, 1        # system call code for print_int
        # move        $a0, $t3      # integer to print // $s1
        # syscall                   # print it
        # li          $v0, 1        # system call code for print_int
        # move        $a0, $zero    # integer to print // $s1
        # syscall                   # print it
        # li          $v0, 1        # system call code for print_int
        # move        $a0, $s5      # integer to print // $s1
        # syscall                   # print it
        # li          $v0, 1        # system call code for print_int
        # move        $a0, $zero    # integer to print // $s1
        # syscall
        # li          $v0, 1        # system call code for print_int
        # move        $a0, $s6      # integer to print // $s1
        # syscall                   # print it
        # li          $v0, 1        # system call code for print_int
        # move        $a0, $zero    # integer to print // $s1
        # syscall
        # li          $v0, 1        # system call code for print_int
        # move        $a0, $s0      # integer to print // $s1
        # syscall                   # print it


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

modfactrl: sw $ra, 4($sp)           # save the return address mod
        sw $a0, 0($sp)              # save the current value of n
        addi $sp, $sp, -8           # move stack pointer
        # slti $t0, $a0, 2          # save 1 iteration, n=0 or n=1; n!=1
        # beq $t0, $a1, Loop1       # not less than $a1, calculate n(n-1)!
        slt $t0, $a0, $a1           # save 1 iteration, n=0 or n=1; n!=1
        beq $t0, $zero, Loop1       # not less than $a0, calculate n(n-1)!
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
