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

Module 6: Sorting,
  - focus on algorithms for handling two aspects of the data management problem—sorting and searching. During this week, several algorithms are presented for sorting data, together with a theoretical model for comparison-based sorting. This model is used to prove a "best case" performance for comparison-based sorting, and then approaches to sorting that "beat" this performance by setting aside the traditional comparison-based approach are presented.
    - Characterize the fundamental properties of a theoretical model of comparison-based sorting.
    - Apply the theoretical model of comparison-based sorting to the evaluation of performance claims on various sorting algorithms.
    - Differentiate between comparison-based sorting and linear sorting.
    - Assess the merits and applicability of linear sorting to different classes of data sets.
    - Determine the conditions under which best case, worst case, and average case performance of sorting algorithms occur.
  +;
Insertion sort,
  - This is an O(n^2) algorithm that involves incrementally inserting new elements into an array in order. The sort is in place in that only an additional swap variable is required.
  +;
Merge sort,
  - This is an efficient sorting algorithm in that it can be completed in O(n lg n) time. As we will see later in this lecture, merge sort is considered to be an asymptotically optimal sort.
  - Unfortunately, because of the recursive nature of the algorithm merge sort is not an in place sort.
  +;
Selection sort,
  - The selection sort algorithm is extremely simple to implement but runs in O(n^2) time. The reason for the poor performance is that selection sort requires every element to be compared with every other element. Selection sort, however, is an in place sort.
  +;
Bubble sort,
  - Perhaps a favorite sort algorithm to implement, bubble sort is very similar to selection sort in that, in the worst case, every element must be compared with every other element. Thus bubble sort has complexity O(n^2) and is an in place sort. Note that the bound is not a theta bound because bubble sort terminates as soon as no swaps are performed.
  +;
Heap sort,
  Like merge sort, but unlike insertion sort, heapsort’s running time is O(n lg n). Like insertion sort, but unlike merge sort, heapsort sorts in place: only a constant number of array elements are stored outside the input array at any time. Thus, heapsort combines the better attributes of the two sorting algorithms we have already discussed.
  +;
Counting sort,
  - NOT a comparison sort
  - Can be linear, but only situationally
  - Good candidate for groups with repeat values
  - Stable sort
A Stable sort,
  - numbers with the same value appear in the output array in the same order as they do in the input array.
  +;
Radix Sort,
  - non-comparative integer sorting algorithm that sorts data with integer keys by grouping keys by the individual digits which share the same significant position and value
  - each sort must be stable (to hold with sorts that occurred before on other integers/magnitudes)
  +;
Bucket sort,
  - assumes that the input is drawn from a uniform distribution and has an average-case running time of O.n/. Like counting sort, bucket sort is fast because it assumes something about the input.
  +;

Module 7: Selection,
  How does a computer find a particular piece of data in a large data set? More importantly, how does one find the data efficiently? This week, algorithms for finding specific data elements are examined. Primarily, discussion will focus on the "selection" problem where one wishes to find the nth order statistic in an unordered data set where an order statistic is the nth item in a corresponding ordered data set. The week then proceeds to discuss several more advanced data structures, including binary search trees. A data structure for efficient storage and retrieval of data—the hash table—is also covered, as is a technique for augmenting data structures with additional information to improve performance of an associated algorithm.
  - Assess the impact on performance of variations on the OSSelect algorithm.
  - Apply augmentation techniques to data structures to improve algorithm design.
  - Analyze the theoretical properties of binary search trees.
  - Construct an augmenting data structure for calculating order statistics.
  - Construct an augmenting data structure for manipulating numeric intervals.
  +;
Order Statistics,
  The ith order statistic of a set of n elements is the ith smallest element. For example, the minimum of a set of elements is the first order statistic (i D 1), and the maximum is the nth order statistic (i D n). A median, informally, is the “halfway point” of the set.
  +;
Binary Search Tree,
  - The binary search tree property is a property imposed on every vertex of a binary search tree such that the following conditions hold. Let vi and vj be two vertices in the tree. For the sake of discussion, assume all key values are distinct (although, in general, this is not required).
  - An inorder traversal of this tree yields the sequence 2–3–4–6–8–9–12. In other words, an inorder traversal of any binary search tree will visit the vertices of the tree in non-decreasing order of the key values stored in the tree.
  +;
Red-black tree,
  BST that ensures the tree is balanced.
  +;

Module 8: Optimization,
  In algorithm design, two aspects of optimization are important. First, designing an algorithm that minimizes time and space requirements is important, and that aspect has been our focus so far. The second aspect is designing an algorithm whose solution minimizes some cost function. That is the aspect of optimization considered in this unit. Specifically, this unit explores problems that can be represented as a sequence of decisions where each decision has an associated cost. Algorithms are designed that minimize the total cost of a sequence of such decisions using a design method called "dynamic programming." Central to this unit is the emphasis of a common model underlying all dynamic programming problems—the Markov decision process.

  - Argue why all dynamic programming problems correspond to Markov decision problems.
  - Derive the Bellman optimality equation for at least one dynamic programming problem.
  - Map a Bellman equation to a corresponding solution table.
  - Compare and contrast the traditional, bottom-up method applied in dynamic programming to dynamic programming with memoization.
  +;
Memoization,
  A memoized recursive algorithm maintains an entry in a table for the solution to each subproblem.
  +;
Optimal Binary Search Trees,
  - construct a binary search tree such that we can process σ using the smallest expected number of comparison. The issue facing us with this problem is that, because ultimate performance depends upon the sequence σ, we need to know the probabilities of certain members being queried. Thus the final tree will not necessarily be a simple balanced tree.
  +;
Greedy Search,
  - The greedy choice property is the property of a problem whereby a globally optimal solution can be found by making locally optimal choices. Such choices do not depend on solutions to subproblems.
  - A problem exhibits optimal substructure if an optimal solution to the problem contains optimal solutions to the subproblems within it. This is sometimes referred to as the principle of optimality.
  +;

Module 9: Advanced Analysis,
  So far, analysis has focused on determining worst-case bounds for algorithms and has assumed these bounds can be derived from the bounds of individual operations used in the algorithm. This week three alternative approaches to analysis are discussed that provide bounds that can be more realistic with respect to the actual operation of the algorithms. Amortized analysis provides a worst-case bound but considers the interdependence of operations within the algorithm, thus providing a tighter bound on performance. We will consider three approaches to amortized analysis.
  - Analyze the performance of an algorithm using aggregate analysis.
  - Analyze the performance of an algorithm using the accounting method.
  - Analyze the performance of an algorithm, using the potential method.
  - Compare and contrast the key characteristics of the methods for amortized analysis.
  +;

Module 10: Data Structures,
  Often, the performance of an algorithm is driven by the way the data is represented for processing by the algorithm. For this reason, algorithms courses draw upon and extend topics covered in a separate data structures course. This unit begins with a brief review of fundamental data structures, but presents them from the perspective of typical operations on the data structures. Each of these operations is treated as an algorithm in its own right. The week then proceeds to discuss several more advanced data structures, including binary search trees, binomial heaps, and all-dimension trees.

  - Define fundamental data structures as abstract data types.
  - Analyze the asymptotic performance of operations on fundamental data structures on dynamic sets.
  - Evaluate the advantages and disadvantages of applying fundamental data structures to dynamic set problems.
  - Analyze the theoretical properties of binary search trees.
  - Evaluate alternative data structures for union-find problems.
  +;

Module 11: Graph Algorithms I,
  For many problems in computer science, the relationships between objects become important in finding an appropriate solution. When data items or objects are related in some way, a graph can be constructed to represent those relationships. Given a graph representing these relationships, what can a computer do with the graph? For example, maps can be represented as graphs where cities are nodes on the graph and roads are edges between the nodes. How might one use this representation to find a minimum-distance path between two cities on the map?

  This week's material focuses on problems such as this and explores the design of several algorithms applied to graph structures. The algorithms covered range from searching for a particular node in the graph and determining what parts of a graph are connected to determining minimum spanning trees and minimum-cost paths through the graph.

  - Formulate search problems using graph search.
  - Design at least one algorithm to solve a graph-related problem.
  - Prove the correctness of the designed graph algorithm.
  - Argue why a particular graph algorithm does or does not solve a specific problem.
  +;
Breadth First Search (BFS),
  - It starts at the tree root (or some arbitrary node of a graph, sometimes referred to as a 'search key'[1]), and explores all of the neighbor nodes at the present depth prior to moving on to the nodes at the next depth level.
  +;
Depth First Search (DFS),
  - explores the highest-depth nodes first before being forced to backtrack and expand shallower nodes.
  +;

Module 12: Graph Algorithms II,
  Modern day computer networks present interesting problems related to issues such as maximizing throughput to determining if alternative paths exist through the network. Mathematically, networks correspond to directed graphs in which a cost weight (usually representing capacity) is associated with each edge in the graph. This week we focus on problems related to determining the amount of some commodity that can flow through a network. The algorithms covered proceed from a graph-theoretic view of the network and utilize the "max-flow, min-cut theorem" to prove their correctness.
    - Formulate transport and flow problems using network analysis.
    - Design at least one algorithm, to solve a network flow-related problem.
    - Map a graph-theoretic problem to an equivalent network flow problem.
    - Prove the correctness of a network flow-related algorithm.
    - Complete an experiment assessing the empirical performance of two or more network flow algorithms on a specific problem.
  +;
Bellman–Ford algorithm,
  is an algorithm that computes shortest paths from a single source vertex to all of the other vertices in a weighted digraph.[1] It is slower than Dijkstra's algorithm for the same problem, but more versatile, as it is capable of handling graphs in which some of the edge weights are negative number
  +;
Dijkstra's algorithm (or Dijkstra's Shortest Path First algorithm, SPF algorithm),
  is an algorithm for finding the shortest paths between nodes in a graph, which may represent, for example, road networks. ... For a given source node in the graph, the algorithm finds the shortest path between that node and every other.
  +;
Flow Network,
  a flow network (also known as a transportation network) is a directed graph where each edge has a capacity and each edge receives a flow. The amount of flow on an edge cannot exceed the capacity of the edge
  +;
Ford-Fulkerson Algorithm,
  greedy algorithm that computes the maximum flow in a flow network
  +;
Max-flow Min-cut,
  theorem states that in a flow network, the maximum amount of flow passing from the source to the sink is equal to the total weight of the edges in the minimum cut, i.e. the smallest total weight of the edges which if removed would disconnect the source from the sink.
  +;

Module 13: Optimization II,
  One of the most widely used optimization techniques involves minimizing or maximizing a function subject to several "constraints". One can think of a constraint as a rule or condition that restricts the space of possible solutions to the optimization problem. In fact, such constrained optimization problems can be quite challenging. Within the various of mathematics, computer science, operations research, etc., a particular class of constrained optimization problem keeps appearing as having the ability to handle a wide range of problems—linear programming. In this unit, we will focus on specifying and solving such linear programming problems.
  - Map an optimization problem to a linear programming formulation
  - Differentiate between the standard form and the slack form of a linear programming problem.
  - Assess and apply the roles of primal and dual formulations in solving linear programming problems.
  - Analyze the behavior of the simplex algorithm in terms of computational complexity and geometric interpretation.
  +;
Linear Programming,
  provides a method to optimize operations within certain constraints. It is used to make processes more efficient and cost-effective. Some areas of application for linear programming include food and agriculture, engineering, transportation, manufacturing and energy.
  +;
Simplex Method,
  +;
Interior Point Method,
  +;

Module 14: Approximation Algorithms,
This course has focused on designing efficient solutions to computational problems and analyzing the resulting performance of those problems. One of the issues discussed is that, for many real-world problems, no known efficient solution exists. Even so, many of these problems find themselves as being representative or applicable to real-world situations. When such situations arise, it is unacceptable to walk away from the situation and simply claim the problem cannot be solved. It is also unacceptable to apply a brute-force approach unless the associated problem size is small. In this unit, we explore alternatives to these two extremes whereby by attempt to derive approximate solutions and to bound the level of such approximation. In this way, we offer a set of tools that enable reasonable solutions to hard problems to be returned with an acceptable (i.e., polynomial) computational burden.
  - Characterize the type of approximation scheme for approximating the solution to an NP-complete problem.
  - Design an approximation algorithm based on a greedy approach.
  - Design an approximation algorithm based on linear programming.
  - Apply a solution to a simpler problem as an approximate solution to a harder problem.
  - Analyze the level of approximation achieved by an approximation algorithm.
  +;


+;
