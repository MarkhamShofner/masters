(function () {
'use strict';

angular.module('common')
.service('SignUpService', SignUpService);

console.log('signup/service.js');

SignUpService.$inject = ['$http'];

function SignUpService($http) {
  console.log('SignUpService');
  var service = this;

  // this method should return a promise
    // which is a result of using the $http service,
    // using the following REST API endpoint: https://davids-restaurant.herokuapp.com/menu_items.json?category=, where, before the call to the server, your code should append whatever itemShortName value was passed in as an argument into the getItemsForCategory method.
  service.getItemByShortName = (itemShortName) => {
    console.log('getItemByShortName');
    var response = $http({
      method: "GET",
      url: (`https://calm-savannah-12203.herokuapp.com/menu_items/${itemShortName}.json`)
    })
    .catch((error) => {
      console.log(error);
    });
    return response.data;
  }
}

})();
