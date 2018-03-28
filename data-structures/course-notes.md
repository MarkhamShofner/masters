Data Structures Course Overview,
  This course investigates abstract data types (ADTs), recursion, algorithms for searching and sorting, and basic algorithm analysis. ADTs to be covered include lists, stacks, queues, priority queues, trees, sets, and dictionaries. The emphasis is on the trade-offs associated with implementing alternative data structures for these ADTs.
  Course Objectives:
  - Accurately and appropriately use Big "O" notation to describe and compare algorithms, while differentiating algorithm functionality from implementation.
  - Accurately detail at least two implementations for each standard data structure: stacks, queues, lists, and binary trees;
  and analyze the pros and cons of each implementation to match applications in programming assignments.
  - Explain the recursive paradigm through practice with non-trivial programming assignments and assess practical applications of recursion.
  - Analyze the pros and cons of the standard sorting and searching strategies to select an optimal strategy for a specific programming application.
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

Worst-case algorithm analysis,
  - To analyze how runtime of an algorithm scales as the input size increases, we first determine how many operations the algorithm executes for a specific input size, N.
    e.g. - f(N) = 1+1+N(2+2) [for a for loop with an if condition]
      variable initialization, for loop (var init, bool, operation), if condition, action
    which would reduce to O(N)
  +;

Abstract Data Types (ADTs),
  - functional approach to describing information storage and the way we access that information.
  - helps us divorce the way we use the data and the way we store the data.
  - black box of what's inside (implementation), user can only see what goes in and comes out (interface).
  +;

Encapsulation Inheritance and Polymorphism,
  - the three pillars of object oriented Programming
  +;

Encapsulation,
  - information hiding and access control,
  - supported by data abstraction
  +;

Data Abstraction,
  - requires splitting the data itself and how it is stored (implementation) from the way in which it is used (functionality).
  - the goal is to separate the two and have the functionality unaffected by the implementation.
  - user of the data doesn't need to know how the data is stored or organized, simply how information can be used and accessed and what manipulations can be performed.
  - programmer should be able to wear both hats. understand what the user may want/need, and also the specifics of how to achieve the best implementation.
    - Trade offs: typically the best solution is situationally dependent, and different situations will call for different implementations. Matching an implementation to a problem to maximize utility.
  +;

Specifying an ADT,
  - commonly represented by a class
  - use preconditions, postconditions, and invariants
    - precondition: something that must be true before the event is to take place
    - postcondition: something that must be true after the event takes place
    - invariance: something that is true both before and after
  - no function bodies are needed. only need the interfaces.
  +;

ADT Format,
  ADT Name is
    Data
      Describe the nature of the data and any initialization
    Methods
      Method1
        Input: Data from the client
        Precondition: necessary state of the system (what needs to be true) before execution of the method
        Process: actions performed with the data
        Postcondition: state of the system after execution
        Output: data values returned to the client
      Method2
      etc..
  end ADT Name
  +;

Module 2 - Stacks,
  Goals:
  - Define a stack and the standard methods.
  - Differentiate between the rules of the stack definition and various implementation imposed restrictions.
  - Characterize problems that have a LIFO characteristic, and give examples.
  - Assess problems for appropriate use of stacks, and make implementation recommendations.
  - Write a Stack ADT and implement stacks using arrays.
  +;
Stack,
  ADT  in which items are only inserted on or removed from the top of a stack. a LIFO ADT - linked list, array, or a vector. stack of plates analogy.
  - push() operation inserts an item on top of the stack
  - pop() operation removes and returns the item at the top of the stack
  other common operations:
    - peek(stack) - returns but does not remove item
    - isEmpty(stack)
    - getLength(stack)
  +;
Stacks using linked lists,
  - A stack is often implemented using a linked list, with the list's head node being the stack's top. A push is performed by prepending the item to the list. A pop is performed by pointing a local variable to the list's head node, removing the head node from the list, and then returning the local variable.
  +;
Stack Uses,
  - when processing order is not important
  - when application reflects LIFO order
  - Operating Systems use:
    - to support recursion
    - to facilitate program execution
  +;
Stack ADT,
  Stack is
    Data
      A list of items with a reference for the top of the stack, initialized to empty
    Methods
      Push
      Pop
      Is_Empty
      Constructor
      --
      Copy
      Display
      Peek
      etc..
  end Stack
  +;
Stack Application Examples,
  - Parsing for delimiters
  [-] Convert an expression to postfix or prefix
  - Evaluate a converted expression
  - Convert infix to postfix or prefix
  +;
Parsing for delimiters,
  - ex. - [(A+B)-C*{(2-3)C}]+5
  - count left delimiters, count right delimiters. if equal - ok
  - also need to validate that the nesting is logical
  Stacks are a great way to solve this problem. Matching types is  the same when you simply compare to the top of the stack, same with ending counts. Put left delimiters on the stack, drop everything else that isn't a right delimiter, for right delimiters make sure the top of the stack matches.
  +;
Convert Expression,
  - infix. standard PEMDAS that we are used to. operator is in the middle.
  - prefix. operator is pre.
  - postfix. operator is post.
  +;
$,
  - using this symbol for exponentiation
  +;
Evaluate a converted expression,
  postfix/postfix (will just have a different reading / execution order):
  - if it's an operand, push it onto the stack
  - if it's an operator, pop the stack twice and perform an operation with those values and push the result back onto the stack
  +;
Converting expression to postfix,
  - while there is an input, read the expression from the left
  - if it's an operand, send to the output
  - else //operation
    - while stacktop has precedence, pop
    - push operator
  // no more input
    pop stack until empty
  +;
Converting to prefix,
  same as before except:
    - read from right
    - older items in the stack are further to the right
  +;
Stack Implementations,
  - array implementation
  - linked implementation
  - hybrid implementation
  - overflow (trying to insert into a full structure) vs. underflow (attempting to delete from an empty structure)
  +;
Array-based implementation,
  - negatives: limits the size of the stack (static). so must know in advance what the space requirement is going to be.
  - neutral: requires the stack to be homogenous
  - positive: random access
  data: need top pointer & array for data
  notes:
    - arrays and stacks do not act the same always. need to differentiate between a structure (stack) and something that's serving as a home for the structure (array).
  +;
Linked implementation,
  - negatives: sequential access. (potentially not that negative, since stacks always are accessed from the top)
  - neutral: homogenous stack
  - positive: no size limits (dynamic allocation)
  data: need top pointer
  +;
Linked code,
  class SNode {
    Datatype Data; // any appropriate type
    SNode Next;
  }
  public class LStack {
    private SNode Top;
    private int size; // optional size param
  }
  public boolean Empty () {
    return (Top==null);
  }
  public void push (Datatype Item) {
    SNode Temp = new SNode; // allocate space
    Temp.Data = Item; // stuff in info
    Temp.Next = Top; // attach to top of stack
    Top = Temp; // reset Top pointer
  }
  public Datatype pop () {
    Datatype Item;
    SNode Temp = Top;
    if Empty() "error" // do appropriate error handling
    else {
      Item = Top.Data; // Extract info
      Top = Top.Next; // Reset Stack top
      Temp.Next = null; // disconnect node
      Temp.Data = "a string of blanks"; // optional
      return Item;
    }
  }
  +;

Module 3 - Recursion,
  Goals:
  Define recursion informally and give simple examples.
  Define the three characteristics of recursion.
  Illustrate those characteristics using a specific example of recursion.
  Summarize how recursion works behind the scenes.
  Trace recursive execution of an example piece of code.
  Write recursive code to solve a simple, example problem.
  Analyze a complex piece problem and recommend the use of recursion or iterations.
  +;
Recursive Algorithm,
  An algorithm that is defined by repeated applications of the same algorithm on smaller problems
  +;
Base case,
  - A case for which the answer is known (and can be expressed without recursion)
  - At some point, a recursive algorithm must describe how to actually do something
  - The if branch ends the recursion, known as the base case. The else branch has recursive calls. Such an if-else pattern is common in recursive methods.
  +;
Stack overflow,
  - meaning a stack frame extends beyond the memory region allocated for stack, Stack overflow usually causes the program to crash and report an error like: stack overflow error or stack overflow exception.
  +;
Towers of Hanoi,
  - Only one disk can be moved at a time.
  - Each move consists of taking the upper disk from one of the stacks and placing it on top of another stack.
  - No disk may be placed on top of a smaller disk.
  Goal: move the stack from one of the three posts to a separate post.
  The minimal number of moves required to solve a Tower of Hanoi puzzle is 2n − 1, where n is the number of disks.
  +;
Issues with recursion,
  - can be inefficient, redundant, and resource hogging
  +;
Memoization,
  - reduces redundancy in recursive methods
  - creates a table and stores recursively calculated values in the table (which can save time/resources in future calculations of a recursive call - e.g. the fibonacci calculations)
  - check the table before calculating a new value
  +;
Other recursive examples,
  - POW (x, N)
  - Binary Search
  - Max array problem
  - Kth Smallest Value problem
  +;
Procedural languages,
  - C++/Java. iterative. full of for loops, assignment statements, etc...
  - conversely, some languages (like Prolog and SML) are written in a recursive fashion
  +;
Module 4: Queues and Lists,
  Goals:
  Define a queue and the standard methods.
  Differentiate between the rules of the queue definition and implementation imposed restrictions.
  Characterize problems that have a FIFO characteristic, and give examples.
  Assess problems for appropriate use of queues, and make implementation recommendations.
  Discuss the pros and cons, including costs, of the three array based approaches to implementing a queue.
  Write a Queue ADT and Implement queues using arrays.
  Define a list and the standard methods.
  Differentiate between the rules of the list definition and implementation imposed restrictions.
  Characterize problems are appropriate to using a general list and a sorted list, and give examples.
  Assess problems for appropriate use of lists, and make implementation recommendations.
  Write a List ADT and implement lists using plain arrays, arrays using a “marked delete” strategy, and dynamic references (links).
  Rewrite list methods by imposing access restrictions, to obtain the standard stack and queue methods.
  Implement stacks and queues with dynamic references.
  Discuss the pros and cons, including costs, of each implementation type and each access restriction type and match to applications.
  +;
Queue,
  - an ADT in which items are inserted at the end of the queue and removed from the front of the queue. The queue push operation inserts an item at the end of the queue. FIFO.
  - can be implemented using a linked list, an array, or a vector.
  +;
Linked List,
  - list's head node representing the queue's front, and the list's tail node representing the queue's end. Pushing an item to the queue is performed by appending the item to the list
  +;
List ADT,
  - common ADT for holding ordered data, having operations like append a data item, remove a data item, search whether a data item exists, and print the list
  +;
Singly-linked list,
  data structure for implementing a list ADT, where each node has data and a pointer to the next node. The list structure typically has pointers to the list's first node and last node. A singly-linked list's first node is called the head, and the last node the tail.
  +;
Queues: Array implementation,
  - can provide random access :)
  - options
    1) move the front pointer upwards through the array when deleting (from the front of the queue)
      - fast
      - takes up more space because leaving the deleted item in the array, and can also lead to a false overflow because the garbage is still there
    2) shift the array down every time the front pointer bumps
      - fast add O(1)
      - slow delete O(n) because the whole queue has to shift down
    !!3) Standard array implementation of a queue.
    better solution - move the pointers as in 1), and wrap around to the beginning of the array when out of space
      - array fully utilized
      - insert and delete both O(1)
    +;
Queues: Linked implementation,
  - :) no size limits
  - :( forces sequential access
  +;
Lists,
  - ordered collection of data items
  - all locations are available for insertion and deletion
  +;
Lists: Array Implementation,
  - :( limits size, static
  - :) random access
  standard implementation: shifting.
    - i.e. - front of list at 0, end of list at k-1 where k is length (even if k, k+1, etc... in the array have value because they were previously deleted members of the list which have yet to be overwritten)
    - shifting up of contents always occurs after deletion, unless it was the last item in the list that was deleted
  alternatively:
    - can use flags or bits to mark an index in the array as 0/1 not/part of the array, which makes it faster to insert/delete, but harder to get the benefits of random access. So will need to garbage collect the list (and remove all the garbage and consolidate the useful values) which is basically what the standard implementation is doing, but here we would be putting off the pain for a while and doing it in a large batch.
  +;
Lists: Linked implementation,
  - :) no size limits, dynamic allocation
  - :( sequential access. but not a huge problem because the list is sequential
  for insert, search, delete - special care needs to be taken around behavior at the front and end of the lists, as well as if there are duplicate elements (esp in the case of search)
  +;

Module 6 - More on lists (then Graphs),
  Goals:
  - Discuss the pros and cons of each list variation, including costs, and match to applications, separately and in combination.
  - Implement each access restriction type and list variation using the hybrid implementation. Discuss the impact on costs.
  - Categorize and label graphs accurately using basic graph terminology.
  +;
Doubly-linked list,
  A doubly-linked list is a data structure for implementing a list ADT, where each node has data, a pointer to the next node, and a pointer to the previous node. The list structure typically points to the first node and the last node. The doubly-linked list's first node is called the head, and the last node the tail.
  +;
Multi-linked list,
  useful to follow more than one kind of path through the data. Could track towards to pointers (maybe a horizontal and a vertical one)
  +;
Hybrid-implementation,
  ex - two stacks coming from either end of an array towards the middle.
  Idea is to generalize the solution, support the concept of multiple data structures sharing the same space.
  another ex - could have a series of linked lists stored in an array. first piece is value, second piece is pointer to index of the next value.
  +;
Structures Summary,
  List Type,
    - General List
      - sorted
      - unsorted
    - Stack
    - Queue
      - Priority Queue
    - Deque
    - Other Access Restricted structures
    - Tree
  Implementations,
    - Array based
      - traditional
      - using Marked deletes
    - Linked (references)
      - Header
      - Circular
      - Doubly-linked
      - Multiply-linked
    - Hybrid
  Methods
    - insert
    - delete
    - search
    - copy
    - print
    - peek
    - etc...
  +;
Graph,
  data structure for representing connections among items, and consists of vertices connected by edges.
  - A vertex (or node) represents an item in a graph.
  - An edge represents a connection between two vertices in a graph.
  - Two vertices are adjacent if connected by an edge.
  - A path is a sequence of edges leading from a source (starting) vertex to a destination (ending) vertex. The path length is the number of edges in the path.
  - The distance between two vertices is the number of edges on the shortest path between those vertices.
  +;
Sparse graph,
  graph with far fewer edges than the maximum possible. Many graphs are sparse, like those representing a computer network, flights between cities, or friendships among people (every person isn't friends with every other person). Thus, the adjacency list graph representation is very common.
directed graph - or digraph,
  consists of vertices connected by directed edges. A directed edge is a connection between a starting vertex and a terminating vertex. In a directed graph, a vertex Y is adjacent to a vertex X, if there is an edge from X to Y.
  +;
(graph) path,
  sequence of directed edges leading from a source (starting) vertex to a destination (ending) vertex.
  +;
(graph) cycle,
  path that starts and ends at the same vertex. A directed graph is cyclic if the graph contains a cycle, and acyclic if the graph does not contain a cycle.
  +;
weighted graph,
  associates a weight with each edge. A graph edge's weight, or cost, represents some numerical value between vertex items, such as flight cost between airports, connection speed between computers, or travel time between cities. A weighted graph may be directed or undirected.
  +;
Basic Graph Theory,
  Context for follow-on material on binary trees.
  Pictoral way to represent information. Modeling tool.
  +;
Graph definition,
  G=(V,E), an ordered pair, where V is a set of vertices (nodes), & E is a set of edges on the vertices.
  V is not empty. E may be empty.
  +;
Degree of a vertex,
  - number of incident (describes the relationship between an edge and a vertex) edges
  - if a directed graph, can do (in, out) ordered pair of edges wrt a specific node
  +;
Sink,
  when a vertex has an out-degree of 0
  +;
Source,
  in-degree zero and positive out-degree
  +;
Regular graph,
  If the degree of each vertex is the same
  +;

Module 6 - Trees,
  Goals:
    Define an m-ary tree in terms of an underlying graph.
    Restrict an m-ary tree into a rooted tree.
    Build a general tree using a random list of data.
    Define and build a heap using an example data set.
    Define and implement priority queues
    Implement a tree using both array based and linked implementations
    Define a Binary Tree recursively.
    Specify the three traversal orders and generate the traversal orders on example trees.
    Define and implement threaded trees.  
    Appreciate Binary-op trees as an application of Binary trees and tying in earlier material from Stacks.
    Build a balanced tree using a sorted list of data, then compare and contrast with the balanced trees built earlier.
    Define the search tree characteristic
    Perform basic insertions and deletions on search trees, explaining why the rational behind the traditional strategy.
    +;
Binary trees,
  - each node has up to two children, known as a left child and a right child.
  - Leaf: A tree node with no children.
  - Internal node: A node with at least one child.
  - Parent: A node with a child is said to be that child's parent. A node's ancestors include the node's parent, the parent's parent, etc., up to the tree's root.
  - Root: The one tree node with no parent (the "top" node).

  - edge: the link from a node to a child.
  - depth: the number of edges on the path from the root to the node. The root node thus has depth 0.
  - level: all nodes with the same depth form a tree level.
  - height: the largest depth of any node. A tree with just one node has height 0.
  +;
Types of binary trees,
  - A binary tree is full if every node contains 0 or 2 children.
  - A binary tree is complete if all levels, except possibly the last level, are completely full and all nodes in the last level are as far left as possible.
  - A binary tree is perfect, if all internal nodes have 2 children and all leaf nodes are at the same level.
Minimum spanning tree,
  Subset of the graph's edges that connect all vertices in the graph together with the minimum sum of edge weights. The graph must be weighted and connected. A connected graph contains a path between every pair of vertices.
  +;
Kruskal's minimum spanning tree algorithm,
  determines subset of the graph's edges that connect all vertices in an undirected graph with the minimum sum of edge weights. Kruskal's minimum spanning tree algorithm uses 3 collections:
  - An edge list initialized with all edges in the graph.
  - A collection of vertex sets that represent the subsets of vertices connected by current set of edges in the minimum spanning tree. Initially, the vertex sets consists of one set for each vertex.
  - A set of edges forming the resulting minimum spanning tree.
  +;
Max-heap,
  binary tree that maintains the simple property that a node's key is greater than or equal to the node's childrens' keys. (Actually, a max-heap may be any tree, but is commonly a binary tree). Because x ≥ y and y ≥ z implies x ≥ z, the property results in a node's key being greater than or equal to all the node's descendants' keys. Therefore, a max-heap's root always has the maximum key in the entire tree.
  +;
insert: max-heap,
  starts by inserting the node in the tree's last level, and then swapping the node with its parent until no max-heap property violation occurs. Inserts fill a level (left-to-right) before adding another level, so the tree's height is always the minimum possible. The upward movement of a node in a max-heap is sometime called percolating.
+;
remove: max-heap,
  always a removal of the root, and is done by replacing the root with the last level's last node, and swapping that node with its greatest child until no max-heap property violation occurs. Because upon completion that node will occupy another node's location (which was swapped upwards), the tree height remains the minimum possible.
  +;
min-heap,
  similar to a max-heap, but a node's key is less than or equal to its children's keys.
  +;
Heaps,
  Heaps are typically stored using arrays. Given a tree representation of a heap, the heap's array form is produced by traversing the tree's levels from left to right and top to bottom. The root node is always the entry at index 0 in the array, the root's left child is the entry at index 1, the root's right child is the entry at index 2, and so on.
  +;
General tree,
  A (general) tree T=(V,E') is defined on graph G=(V,E)
  Where E' is a subset of the original set of edges (E)
  If the size of V = n, then |E'| = n - 1.
  Note: T is connected and acyclic.
  +;
Rooted tree,
  in-degree will always be 1 in a rooted tree, so when talking about degree we are talking about out-degree (#of child vertices)
  +;
Ancestor/Descendant,
  Nodes in the same lineage but separated by more than one level (as you should call that parent/child).
  +;
M-ary tree,
  rooted tree, with m or fewer children per vertex.
  m describes the maximum (out) degree of the tree
  +;
Regular m-ary tree,
  Every node that has children has to have the same number of children (o or m).
  +;
Complete m-ary tree,
  regular and has all the leaves at same level k (which is the height)
  +;
Almost complete tree,
  Allow missing a few nodes from the right hand end on the bottom level.
  +;
Binary Tree ADT,
  Constructor - initialize empty tree
  MakeTree - create tree containing 1 value as root with no children
  SetLeft - attach value as left child
  SetRight - attach value as right child
  Display Tree - optional
  TraverseTree - move through tree in orderly fashion
  SearchTree - look for a specified value
  DeleteNode - deletes specified node
  Data section:
    - reference to tree (root)
    - NumNodes // optional
    - Height // optional
    - Actual data
  +;
Sequential Array Binary Tree representation,
  works well if the tree is complete or almost complete (so that a lot of space is not wasted in allocating space for the complete version of the array)
  +;
Linked Binary Tree representation,
  dynamic allocation
  node specified as for doubly linked lists, except for child nodes. |left|data|right|
  +;
Recursive Binary Trees,
  A tree is a collection of three things
    - root
    - left subtree (LST)
    - right subtree (RST)
  Traversal
    - Pre-order traversal (ROOT LST RST), visit root, traverse left, traverse right
    - In-order traversal (LST ROOT RST)
    - Post-order traversal (LST RST ROOT)
  +;
Parent pointers,
  can also keep track of an additional piece of data in each node (the parent), effectively making the structure a doubly linked list
  +;
Threaded trees,
  - A binary tree is made threaded by making all right child pointers that would normally be NULL point to the in-order successor of the node (if it exists).
  - eliminates some of the redundancy of recursive traversals
  +;
Binary op-trees,
  - heterogeneous binary trees with operands as the leaves and operators as non-leaves.
  - operator with least precedence is the root of the tree
  +;
Binary Search Trees,
  - "Search Tree" characteristic defines that everything in the LST is <= the root of the subtree. And everything in the RST is >= the root of the subtree.
  - recursive characteristic
  - an in-order traversal will yield the values in a sorted order
  +;















  +;
