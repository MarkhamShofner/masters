Module 0: Course Overview,
  - approach machine learning from a practitioner’s perspective. We will examine the issues that impact our ability to learn good models (e.g., the curse of dimensionality, the bias-variance dilemma, and no free lunch).
  - examine a variety of approaches to learning models, covering the spectrum from unsupervised to supervised learning, as well as parametric versus non-parametric methods. Students will explore and implement several learning methods, including logistic regression, Bayesian classification, decision trees, and feed-forward neural networks, and will incorporate strategies for addressing the issues impacting performance (e.g., regularization, clustering, and dimensionality reduction)
  Course Objectives:
    - Determine the inductive bias of learning methods and how that bias potentially affects learning performance.
    - Assess the impact of the bias-variance dilemma and no free lunch in utilizing machine learning methods.
    - Differentiate between classification and function approximation (regression) in learning.
    - Manage learning complexity through unsupervised learning methods.
    - Manage model fit through regularization and validation data sets.
    - Assess the role of linearity in model selection.
    - Implement and apply a variety of machine learning methods to real-world problems.
    - Assess the empirical performance of machine learning algorithms on different types of data sets
  +;

Module 1: Introduction to Machine Learning,
  Module Objectives:
  - Differentiate between supervised, unsupervised, and reinforcement learners.
  - Analyze a basic learning algorithm to determine both its representation and preference inductive biases.
  - Select between alternative loss functions to evaluate an algorithm's performance.
  - Compare and contrast the basic features of the teacher annotated, active learner, and helpful teacher models of learning.
  - Implement the Winnow-2 algorithm and evaluate its performance.
  +;

Types of Machine Learning,
  - Supervised Learning. Most Common
  - Unsupervised Learning
  - Reinforcement Learning
  +;
Winnow Algorithm,
  Define a line (/ hyperplane) that separates positive from negative.
  1. Receive data instance
  2. Make prediction. 0 if learner believes instance does not belong to the class. 1 if learner believes instance _does_.
  3. Prediction correct?
    * 0->1: Promotion (incorrect label of 0 instead of 1)
    * 1->0: Demotion (incorrect label of 1 instead of 0)
  +;
Why do Machine Learning Algorithms Work,
  - Inductive Bias: enables the model to be able to generalize (on data that was not used in part of the training). Necessary for any learning to occur.
    - Representation Bias
    - Preference (Selection) Bias
  - No Free Lunch Theorem for Optimization:
    - over all possible functions that can be learned using an algorithm, we can never have one algorithm that always beats out the other algorithms.
    - In other words over the space of all possible functions, a best learning algorithm does not exist.
    - This means that an algorithm works well on some problems and not so well on others, so our challenge is to match the algorithm bias to the problem space.
  +;
How to approach using machine learning,
  - First, don't look for a panacea of a learning algorithm to apply to all of your problems. No such algorithm exists.
  - Second, understand your problem so that you can match the right model type with a representation to that problem.
  - Third, once you have figured out which model type to use, pick a performance measure that reflects the behavior you seek. And understand the implications of that measure on the search process.
  - Fourth, pick an algorithm that's well suited to optimizing the performance function. And enforce an appropriate preference in the search process to avoid overfitting.
  +;
Evaluating Performance,
  - Optimization
  - Performance Measures. We want to maximize these measures so that the model is able to generalize (ie handle data it has never seen before and provide and answer that is correct)
  - Risk functions. Provides a measure of the loss we expect to incur when we use the learned model to label an unknown example.
    - the idea is to find a function that minimizes the risk
  +;
Learning Models,
  - Sample Complexity
    - number of training examples required to learn our target concept to some minimal level of performance
  - Computational Learning Theory
    - Teacher annotated learning
    - Active Learning
    - Helpful Teacher
  +;

Module 2,
  - Formulate machine learning as a decision problem.
  - Derive model parameters from data using maximum likelihood estimation.
  - Evaluate the effects of different probability distributions in classification performance
  - Assess the impact of the bias-variance tradeoff in model learning.
  - Implement the Naïve Bayes algorithm and evaluate its performance.
  - Implement stepwise selection methods and evaluate their performance.
  +;
Naive Bayes,
  - use basic probability to classify data
  - attempt to optimize the probability of some hypothesis given the data
  - goal is to find the class that best matches the features of the data
  +;
Bayes Decision Theory,
  
  +;
