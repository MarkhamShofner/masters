JavaScript,
  - a dynamic, weakly typed programming language which is interpreted at runtime. It can be executed as part of a webpage in a browser or directly on any machine ("host environment")
  +;
Interpreted,
  code is not pre-compiled but instead evaluated, compiled, and executed at runtime (e.e. when the browser executes the script)
  +;
Dynamic typing,
  assigns types (like number) to variables at runtime, not in advance.
  +;
Weak typing,
  generally tethered to dynamic typing and interpreted languages. implies looser typing rules around data and variables
  +;
Running on the host environment,
  - can manipulate HTML code, CSS, send background http requests and much more
  - cannot access the local filesystem, interact with the operating system, etc.
  - Node.js can be executed on any machine, server-side JavaScript web backends, and CAN access the local filesystem, interact with the os (however it cannot manipulate html or css, which makes sense because it does not have access)
  +;
General,
  .addEventListener('click', addFunction);
  parseInt() / parseFloat()
  .toString()
  getElementsByTagName('p');
  getElementsByClassName('download-button');
  querySelectorAll('li');
  +;
Arrays,
  Array.from({iterable}) --> turns into Array
  unshift(); (add to beginning)
  shift(); (remove item at beginning)
  splice(indexToStart, #elementsToRemove, whatToInsert);
  slice() --> would copy whole array. slice (1, 3) --> returns elements 1 and 2. slice(2) --> 2 thru end
  map()
  +;
Sets,
  - dupes not allowed
  - no index based access
  - some special functions for sets, can't use array methods
    - ids.has(1);
    - .add, .clear, .delete, .forEach, .entries -> [val, val], .values -> val, .size
  - const ids = new Set([1,2,3]);
    - let es6set = new Set(arr);
    - let arr = [...es6set];
  - intersection
    - new Set([...smallerSet].filter(element => largerSet.has(element)))
  - union
    - new Set([...setA, ...setB]);
  +;
Maps,
  - key values can be all sorts of values (unlike objects that are just strings [or numbers that have been type coerced into strings])
  - duplicate keys not allowed, but dupe values are
  - remembers the insertion order
  - better performance (compared to objects) when working with large quantities of data, or adding/removing data frequently
  - some special functions for maps, can't use array methods
    - .get(obj1)
    - .set([obj2, []])
    - .entries()
    - .keys()   .values()
    - .clear()   .delete()
    - .size
  - newMap([[obj1, val]]);
  - for (const[key, value] of personData.entries())
  +;
