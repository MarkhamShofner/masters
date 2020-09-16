console.log(`Running Winnow 2`);

const runWinnow2 = () => {
  console.log(`Beginning of Main Function`);
  fit();
}

const fit = () => {
  console.log(testObj.a);
}

const testObj = {
  a: 47
}

runWinnow2();

console.log(`End of Winnow 2`);

// 1) learner receives data instance. set of attributes
  // (boolean attribute where true if the attribute applies to the class being learned, and false if it does not)
// 2) learner makes a prediction for the data instance by assigning a label of 0 or 1
  // 0 indicates the learner believes the instance does not belong to the class
  // 1 indicates the learner believes that it does
  // implementation: using a weighted sum across the attributes to land on 0 or 1
    // f(x) = (weight of i)*(value of i)+....+wNxN. (1 through N where N is total number of attributes)
    // if f(x) > threshold, 1. if <, 0.
    // notes: initially all weights start at 1. and threshold is commonly set to .5. adjustment constant commonly set to 2.
// 3) learner is told whether the prediction was correct
  // if correcdt, do nothing
  // if incorrect
    // 0 when should be 1. then promotion takes place.
    // 1 when should be 0. then demotion takes place.

//
