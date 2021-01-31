(function () {
'use strict';

angular.module('common')
.service('MyInfoService', MyInfoService);

console.log('myinfo/service.js');

MyInfoService.$inject = [];

function MyInfoService() {
  console.log('MyInfoService');
  debugger;
  var service = this;

  service.getMyInfo = () => {
    console.log('MyInfoService.getMyInfo()');
    return [];
  }
  // this method should return a promise
    // which is a result of using the $http service,
    // using the following REST API endpoint: https://davids-restaurant.herokuapp.com/menu_items.json?category=, where, before the call to the server, your code should append whatever categoryShortName value was passed in as an argument into the getItemsForCategory method.
  // service.getItemsForCategory = (categoryShortName) => {
  //   console.log('getItemsForCategory');
  //   var response = $http({
  //     method: "GET",
  //     url: (`https://davids-restaurant.herokuapp.com/menu_items.json?category=${categoryShortName}`)
  //   })
  //   .catch((error) => {
  //     console.log(error);
  //   });
  //   return response;
  // }
}

})();
