Data Structures Course Overview,
  This course investigates abstract data types (ADTs), recursion, algorithms for searching and sorting, and basic algorithm analysis. ADTs to be covered include lists, stacks, queues, priority queues, trees, sets, and dictionaries. The emphasis is on the trade-offs associated with implementing alternative data structures for these ADTs.
  Course Objectives:
  - Accurately and appropriately use Big "O" notation to describe and compare algorithms, while differentiating
algorithm functionality from implementation.
  - Accurately detail at least two implementations for each standard data structure: stacks, queues, lists, and binary trees;
  and analyze the pros and cons of each implementation to match applications in programming assignments.
  - Explain the recursive paradigm through practice with non-trivial programming assignments and assess practical
  applications of recursion.
  - Analyze the pros and cons of the standard sorting and searching strategies to select an optimal strategy for a specific
  programming application.
  +;

Module 1 - Complexity and ADTs,
  For Complexity, we will introduce the notation we will use to talk about the cost of algorithms or code, for the rest of the term. It's just notation, a convenient tool that facilitates comparison.  It is also something that most of you will see again when you take Foundations of Algorithms.
  In ADTs, we grapple with the idea of looking at structures in which we store information, from a functional standpoint, without worrying about the implementation. This perspective helps us understand the important aspects of the structure

  Goals:
  - Define Big-Oh notation and use to label functions.
  - Calculate and label the cost of simple algorithms.
  - Explain why empirical results may not match the theoretical predictions.
  - Use Big O Notation to choose one algorithm over another for a specific application.
  - Explain the conditions under which a more costly algorithm might be preferable.
  - Give examples that differentiate between the implementation and the functionality of a module of code. Explain how the implementation can affect the functionality.
  - Practice modularity in code design by consciously considering software from a user's perspective as well as from a programmer's perspective.
  - Write ADTs for specified applications using at least one of the styles discussed in class.
  +;

Big O Notation,
  - mathematical way of describing how a function (running time of an algorithm) generally behaves in relation to the input size
  - all functions that have the same growth rate (as determined by the highest order term of the function) are characterized using the same notation
  - used in Computer Science to describe the performance or complexity of an algorithm. Big O specifically describes the worst-case scenario, and can be used to describe the execution time required or the space used (e.g. in memory or on disk) by an algorithm
  - If f(x) is a sum of several terms, the highest order term (the one with the fastest growth rate) - called the dominant term - is kept and others are discarded.
  - If f(x) has a term that is a product of several factors, all constants (those that are not in terms of x) are omitted.
    - using the above two rules. O(5+13N+7N^2) --> O(7N^2) --> O(N^2) [pronounce Oh N Squared]
  +;

More Big O Notation Notes,
  - when comparing algorithms and functions, we usually define 'better' as either faster or taking up less space. Given the low cost of memory these days, speed is generally the characteristic focused on.
  - can break a piece of code into little components and derive the cost of each section (N for linear expressions, N^2 for quadratic, etc...). Then simplify according to the O Notation rules.
  +;

TODO - define the below with the book definition
Upper Bound,
  - g only has to be greater than f beyond a certain point
  - f will do no worse than g (its upper bound)
  - behavior harder to predict closer to the origin
  - O(g(n)) is an estimate, a label. Not perfectly accurate.
  +;

Lower Bound,
  - big omega notation
  +;

TODO ...
Theta,
  - can be used when a function f can use g as it's upper and lower bounds (with different multiples)
  +;

Bound comparison notes,
  - making decisions based on g() values can and will lead to difference decisions than f() values (especially closer to the origin where the behavior is less predictable)
  +;

Polynomial time and Nondeterministically Polynomial Time,
  - Is P a subset of NP? Most theoretical scientists believe so. Helps answer the question - are there faster algorithms that exist?
  +;

Patterns of polynomial labels,
  - Sorts tend to fall into the frame of linear up to quadratic time.
  - Search techniques tend to fall in the constant up to linear time frame.
  +;
