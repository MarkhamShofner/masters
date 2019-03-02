Module 1: Introduction,
Computer algorithms are part of the foundation of all of computer science. Computer algorithms focus on how to use computational resources to solve problems. Given the fact that modern computers with gigabytes of memory and terabytes of disk space still have resource limits, a perennial concern is the design of efficient algorithms—algorithms that make the best use of those limited resources. This unit provides essential, fundamental tools that will be needed to begin our journey into designing computer algorithms. Much of the focus of this unit is on providing tools for analyzing algorithms so that one can determine if a given design is efficient with respect to resource limits.
  - Analyze an iterative algorithm using basic summations.
  - Define asymptotic notation as a method for describing the complexity of an algorithm in terms of functional upper bounds and lower bounds.
  - Prove various mathematical properties of asymptotic forms.
  - Apply asymptotic notation to compare the complexity of two or more algorithms.
  +;
Algorithms,
  - well-defined computational procedures taking values as inputs and providing values at outputs
  +;
Comparing Algorithms,
  - assess for time and space complexity
  - can use experimental data, or formal mathematics (or both)
  - can evaluate average case performance, or more preferred (since it is hard to define average)- worst/best case performance scenarios, using asymptotic analysis [where frequently we lean primarily on worst case scenarios - since this one can be more illustrative and hit more frequently if the searched for element is not even in the dataset]
  +;
Insertion Sort,
  - insert one at a time in relation to those elements that have already been sorted (cards in a hand, books in alphabetical order, etc.)
  - sort that works better with small # of elements
  +;
Order of growth,
  - for general comparison's sake, we can drop lower order terms (n as compared to n^2) and coefficients (2n^2 as compared to n^2)
  - O-notation : worst case (big oh)
  - O{theta} notation : bounds function to within constant factors
  - O{omega} notation : best case
  - o-notation : worst case (little oh) that isn't asymptotically tight
  - w-notation : little omega notation that isn't asymptotically tight
  +;
Divide and Conquer Algorithms,
  - Merge Sort
  +;

Module 2: Basic Analysis,
This unit begins with a brief review of fundamental data structures, but presents them from the perspective of typical operations on the data structures. Each of these operations is treated as an algorithm in its own right. Analyzing a computer algorithm consists of assessing the correctness of the algorithm and determining the time and space requirements for executing the algorithm. Correctness analysis involves proving logical characteristics, while time and space complexity analysis involves deriving performance bounds. This unit focuses on complexity analysis, and provides several tools for performing such analyses. Mathematical techniques based on solving finite and infinite series, solving recurrences, and proving bounds using mathematical induction will be emphasized.
  - Construct mathematical proofs about the asymptotic bounds of summations.
  - Determine the best method for solving recurrences.
  - Solve recurrences using the substitution method with induction.
  - Solve recurrences using the iteration method.
  - Solve divide-and-conquer recurrences using the Master Method.
  +;
Structures,
  Stack: push/pop
  Queue: Enqueue/Dequeue
  Linked/Doubly-Linked List: Insert/Delete
  Graphs: vertices and edges (relationships / pairs of vertices), directed graphs/undirected graphs, weighted graphs, paths, cycles, strongly/weakly connected
  Trees: undirected graph, parent/ancestor, child/descendant
  +;
Set,
  - Collection of objects, called elements or members.
  - x is a member of set S. x ~E S
  - Z, set of integers
  - N, set of natural numbers
  - X+, set of positive naturals (no 0)
  subset, proper subset, intersection, union, difference.
  +;
Relations,
  - https://www.youtube.com/watch?v=4DQcTbN0eeY
  - "binary relation" R on two sets A and B is a subset of the Cartesian product A x B
    X = {1,2}
    Y = {3,4}
    XxY = {(1,3),(2,3),(1,4),(2,4)}
  - examples:
    - a = b
    - a <= b
    - a >= b
  - reflexive property, symmetric property, transitive property, equivalence property
  - antisymmetric, partial order
  +;
Functions,
  - Given two sets A and B, a "function" f is a binary relation on A x B such that ~Va ~E A, there exists precisely one b ~E B such that (a, b) ~E f.
    - the set A is the domain of f
    - the set B is the codomain of f
    - the range of f is the image of it's domain (a subset of the codomain)
    b = f(a)
  +;
Properties of Functions,
  - surjection: if it's range is its codomain (i.e. equal and not a proper subset)
    - f(n) = 2n is a surjection from N to even numbers. It is not a surjection from N to N since no odd numbers are produced.
  - injection: if distinct arguments of f produce distinct values, i.e., if a =/= b then f(a) =/= f(b)
    - f(n) = 2n is an injection from N to N but f(n) = [n/2] <-- floor function is not an injection since f(2) = f(3)
  - bijection: (one-to-one correspondence) if both a surjection and an injection. A bijection from A to itself is a permutation.
  +;
Proofs by induction,
  - the base case: show the thing to be proved holds for elementary cases (e.g. n=0 or n=1)
  - the inductive step: show the thing to be proved holds for a more general case.
    - inductive hypothesis: assume holds for m = n
      ... now prove for m = n + 1
  - Axiom of induction: if holds for base case, and if holds for a different number, then that number plus 1, then it holds for all cases
  +;
Recurrences,
  - A recurrence is an equation or inequality that describes a function in terms of its value on smaller and smaller inputs.
  - Typically used to characterize performance of a recursive function or algorithm.
  +;
The substitution method,
  Here we will guess a bound and use mathematical induction to prove whether or not the guess is correct.
  1. guess the form of the solution
  2. use mathematical induction to find the constants and show that the solution works
  +:
The iteration method,
  - convert the recurrence into a summation and bound the summation to solve.
  +;
Recursion trees,
  - construct a tree showing the reduction of the input space and analyze the size of the tree.
  - each node represents the cost of a single subproblem somewhere in the set of recursive function invocations. sum the costs within each level of the tree to obtain a set of per-level costs, then sum all the per-level costs.
  - best used to generate a good guess (which can then be verified using the substitution method)
  +;
The master method,
  - Page 94 in textbook
  - This approach provides a “cookbook recipe” for solving certain types of recurrences. Specifically, we will consider three cases of recurrences of the form T(n) = aT(n/b) +f(n) where a ≥ 1, b > 1, and f(n) is some arbitrary function
    1. If f(b) = O(n^logb(a-~E)), for some constant ~E>0, then T(n) = Theta(n^logba).
    2. If f(b) = Theta(n^logba), then T(n) = Theta(n^logba*lgn).
    3. If f(b) = Omega(n^logb(a+~E)), for some constant ~E>0, and if af(n/b)<=c f(n) for some constant c<1 and all sufficiently large n, then T(n) = Theta(f(n)).
  - for the 1st f(n) must not only be smaller, but polynomially smaller, than n^logba. Meaning f(n) must be asymptotically smaller than n^logba by a factor of n^~E for some constant ~E>0
  - the same applies for the 3rd case, except f(n) must be polynomially larger
  Other:
    - the a = the branch factor or the recursive function - how many recursive calls are had within the algorithm. a-ary tree
    - the b = the height of the tree. represented by logb(n)
    - assuming we have a relatively well balanced tree
  +;
General notes,
  - We normally find it convenient, therefore, to omit the floor and ceiling functions when writing divide-and-conquer recurrences of this form.
  +;
Master Method Special Case,
  As a final comment, we introduce a “special case” of the master method that can come in handy. As we present this, we also note that the special case does not yield a theta bound while the full master method
  does.
  Suppose we have a recurrence of the form T(n) = a1T(n/b1) +a2T(n/b2) +· · ·+amT(n/bm) + 1.
  Now suppose we define some S = ∑i (ai/bi). Then we have three cases as before:
  1. If S < 1, then T(n) = O(n).
  2. If S = 1, then T(n) = O(n lg n)
  3. If S > 1, then T(n) = O(nlg maxi ai ).
  As a final note, the coefficient on the final function n must be 1 for the case to hold.
  +;
Loop Invariants,
  - proving the correctness of an algorithm that involves iteration
  1. Initialization
  2. Maintenance
  3. Termination
  - Theorem: For any integer n ≥ 0 and integer m > 0, there exist q and r such that n = q · m + r and 0 ≤ r < m.
  - Prove that an algorithm with terminate
    - sometimes prove whether or not the while loop is an infinite loop
  - Prove whether or not terminates with the correct result.
  Definition: Let S be some statement. Then S is an invariant of the loop
    while C do
    E;
    end while;
  when both S and C are true before any given iteration of the loop and S remains true after the iteration.
  Theorem: Assume statement S is an invariant of the loop
    while C do
    E;
    end while;
  Assume also that S is true on the first entry to the loop. Then
  1. If the loop terminates, S is true after the last iteration, and
  2. If the loop does not terminate, S remains true after every iteration.
  +;
General Recurrence,
 ~$ --> alpha [lil fish sign]
  T(n) = T(n/3) + T(2n/3) + cn --> O(theta)(n log n)
  can be generalized to
  T(n) = T(~$ n) + T((1 - ~$)n) + cn --> O(theta)(n log n)
  with ~$, 1-~$ ~E (0,1)
  +;

Module 3: NP-Completeness,
  What makes a problem hard? When faced with large problems, why can't we just throw a faster computer with more memory at solving those problems? How do we know the limits of what is solvable in a reasonable time? This course focuses on finding efficient solutions to problems because of resource limitations; however, there is a class of problems for which no known efficient solution has been found. In fact, many believe no efficient solutions exist for problems in this class. This class is the class of NP-complete problems. This week begins a two-week sequence where we review basic computational theory and develop an approach based on computational theory for proving whether or not a problem is NP-complete.

  - Characterize the theoretical difference between tractable and intractable problems.
  - Differentiate between problems that are members of P and members of NP.
  - Map an optimization problem to a decision problem, and vice versa.
  +;
Deterministic Turing Machine,
  Consists of the following:
  - A finite state control,
  - A tape consisting of a two-way sequence of tape squares
  - A read-write head
  A given DTM is manipulated through the execution of a program utilizing the following components:
  - A finite ~T set of symbols
  - a finite set Q of states (qo is the designated start state and qy and qn are designated as halting states)
  - a transition function
  [scan the tape, read the symbol on the table and determine which character to write in its place, and then which direction to move the read-write head]
  - Ends in boolean yes (qy) or no (qn)
  *Turing machine provides the foundation for determining what is computable. In fact, Turing’s thesis is that any computation that can be carried out by mechanical means can also be carried out on a Turing machine*
  +;
Hamiltonian Cycle,
  simple cycle in an undirected graph G = (V , E) that contains each vertex in V.
  +;
Verification Algorithm,
  - A two-argument algorithm A, where one argument is an ordinary input string x and the other is a binary string y called a certificate.
  - A two-argument algorithm A verifies and input string x if there exists a certificate y such that A(x, y) = 1
  +;
Complexity Class NP (nondeterministic polynomial time),
  - class of languages that can be verified by a polynomial-time algorithm
  - A verifies language L in polynomial time
  +;
Decidability,
  - function f is computable in a particular domain if there exists a Turing machine that computes the value of f for all arguments in its domain.
  - Thus, a function f is uncomputable if no such Turing machine exists.
  +;
Formal Languages,
  - {E (sigma) as the alphabet (finite set of symbols). typically {0, 1} in comp sci / turing machine
  - Language L defined over {E is any set of strings made up from the symbols in {E conforming to some set of rules
  - Gramma G (the rules) for determining if a string is a member of L
  +;
Regular Languages,
  right-linear
  left-linear
  +;
The Chomsky Hierarchy,
  Theory of generative grammar that has had a deep impact on computer science.
  relates the expressiveness of the various types of languages. traditionally consists of four types:
  1. Type O languages: also referred to as "unrestricted grammars," type 0 grammars generate all languages that can be recognized by a Turing machine. This type includes the set of recursively enumerable languages.
  2. Type 1 Languages: These correspond to the set of context sensitive languages and correspond to those languages that can be recognized by a Turing machine with a bounded tape.
  3. Type 2 Languages: These are the context free languages as defined previously.
  4. Type 3 Languages: These are the regular languages as defined previously.

  Type | Grammar | Language | Automata
  ---- | ---- | ---- | ----
  3 | Finite State | Regular | Finite
  2 | Context-free | C-F | Pushdown
  1 | Context-sensitive | C-S | Linear bounded
  0 | General rewrite | Unrestricted | Turing machine

  Type 3 more specific than Type 2 ... etc. to Type 0

  Type 0 generates recursively enumerable languages
    - forms the basis for determining what is computable
    - is the theoretical foundation for the theory of NP-completeness
  +;
Further Chomsky Hierarchy,
  - w can be a string (e.b. w = "abc")
  - length of a string s is denoted |s|
  - a symbol ~a occurs in the jth position of a string [like elements in an array] if denoted w(j) = ~a
  +;
Grammars,
  Rules that define legal strings in a language.
  Prescriptive:
    - specifies what is legal through rules
  Descriptive:
    - Describes usage rather than giving rules
  Formal:
    - Precisely defined class of language
  Generative:
    - Specifies how to generate natural expressions

  Vt = terminal vocabulary
  Vn = nonterminal vocabulary
  P = set of productions (rules)
  S = start symbol

  language with grammar G or L(G) is the set of all strings over {E that can be generated by G
  +;
Circuit-satisfiability problem,
  Example of an NP-Complete problem
  “Given a boolean combinational circuit composed of AND, OR, and NOT gates, is it satisfiable?” (i.e. is there a set of conditions that will result in 'True' [or 1] at the end of the circuit)
  +;
Cook's Theorem,
  +;

Module 4: NP-Completeness II,
  Now that we have a sense for what makes a problem hard, we are faced with the rather daunting task of proving that the problem is, indeed hard. Imagine working on a project for a customer, and the customer asks you to solve one of these really hard problems.
  - Apply the concept of reducibility to analyzing an algorithm.
  - Prove whether or not a problem is NP-complete.
  - Differentiate between strong NP-complete problems and pseudo polynomial time problems.
  +;
CNF Satisfiability,
  3-conjunctive normal form (clause of 3 booleans)
  Does there exist a set of assignments that satisfies the result as true? Similar to  circuit-satisfiability problem
  +;
SAT Parse Tree,
  - literals as leaves of the tree, and operators as the nodes
  - can build truth tables at each node
  +;
To Prove that a Problem is NP-Complete,
  1. Show that the problem is in NP
  2. Reduce a known NPC problem to the working problem
  +;
The Polynomial Hierarchy,
  NP, co-NP, and PSPACE
  NP: The complexity class that is a set of concrete decision problems solvable in polynomial time on a non-deterministic Turing machine.
  Co-NP: set of languages L such that the complement of L is in NP
  +;

Module 5: Randomized Algorithms,
  The course concludes with a presentation of a special, advanced topic in computer algorithms. To this point, all of the algorithms discussed and the design methods applied have assumed deterministic decisions are made throughout solving a problem. It can be shown that, for many very complex problems (such as theNP-complete problems discussed in the previous week), introducing a bit of randomness into the process can improve performance. This week we will learn about several methods arising from the field of stochastic optimization that are used to provide solutions to problems in these situations. Algorithms include Markov chain methods and evolutionary search.
    - Assess the appropriateness of randomization in algorithm design.
    - Utilize randomization in the design of an algorithm.
    - Apply the Markov principle to analyze a randomized algorithm.
    - Complete an experiment assessing the empirical performance of an algorithm with and without randomization incorporated.
  +;












+;
