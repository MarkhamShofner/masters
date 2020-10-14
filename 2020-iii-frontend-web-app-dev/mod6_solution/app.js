(function () {
'use strict';

angular.module('LunchCheck', [])
  .controller('lunchCheckerController', lunchCheckerController);

  lunchCheckerController.$inject = ['$scope'];

  function lunchCheckerController($scope) {
    $scope.dishes = '';

    $scope.considerDishes = function () {
      const dishesArray = $scope.dishes.split(',');
      const trimmedDishesArray = dishesArray.filter(dish => dish.trim() !== '');

      let dishesResponse = '';

      if ($scope.dishes === '') {
        $scope.responseFontColor = 'redFont'
        dishesResponse = 'Please enter data first';
      } else if (trimmedDishesArray.length < 4) {
        $scope.responseFontColor = 'greenFont'
        dishesResponse = 'Enjoy!';
      } else {
        $scope.responseFontColor = 'greenFont'
        dishesResponse = 'Too Much!'
      }
      
      $scope.dishesResponse = dishesResponse;
    }
  };

})();
