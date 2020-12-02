(function () {
'use strict';

angular.module('Data')
.service('MenuDataService', MenuDataService);

// MenuDataService.$inject = ['$q', '$timeout']
console.log('MenuDataService');

MenuDataService.$inject = ['$http'];

function MenuDataService($http) {
  console.log('MenuDataService');

  var service = this;
  // this method should return a promise
    // which is a result of using the $http service,
    // using the following REST API endpoint: https://davids-restaurant.herokuapp.com/categories.json
  service.getAllCategories = () => {
    console.log('getAllCategoriesFuction');

    var response = $http({
      method: "GET",
      url: ("https://davids-restaurant.herokuapp.com/categories.json")
    })
    .catch((error) => {
      console.log(error);
    });
    return response;
  }
  // this method should return a promise
    // which is a result of using the $http service,
    // using the following REST API endpoint: https://davids-restaurant.herokuapp.com/menu_items.json?category=, where, before the call to the server, your code should append whatever categoryShortName value was passed in as an argument into the getItemsForCategory method.
  service.getItemsForCategory = (categoryShortName) => {
    console.log('getItemsForCategory');
    var response = $http({
      method: "GET",
      url: (`https://davids-restaurant.herokuapp.com/menu_items.json?category=${categoryShortName}`)
    })
    .catch((error) => {
      console.log(error);
    });
    return response;
  }

// MenuDataService.$inject = ['$q', '$timeout']
// function MenuDataService($q, $timeout) {
//   console.log('MenuDataService');

  // Simulates call to server
  // Returns a promise, NOT items array directly
  // service.getItems = function () {
  //   var deferred = $q.defer();
  //
  //   // Wait 2 seconds before returning
  //   $timeout(function () {
  //     // deferred.reject(items);
  //     deferred.resolve(items);
  //   }, 800);
  //
  //   return deferred.promise;
  // };


  //
  // // List of shopping items
  // var items = [];
  //
  // // Pre-populate a no cookie list
  // items.push({
  //   name: "Sugar",
  //   quantity: "2 bags",
  //   description: "Sugar used for baking delicious umm... baked goods."
  // });
  // items.push({
  //   name: "flour",
  //   quantity: "1 bags",
  //   description: "High quality wheat flour. Mix it with water, sugar, 2 raw eggs."
  // });
  // items.push({
  //   name: "Chocolate Chips",
  //   quantity: "3 bags",
  //   description: "Put these in the dough. No reason, really. Gotta store them somewhere!"
  // });
}

})();
