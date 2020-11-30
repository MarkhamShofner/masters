(function () {
'use strict';

angular.module('NarrowItDownApp', [])
  .service('MenuSearchService', MenuSearchService)
  .controller('NarrowItDownController', NarrowItDownController)
  .directive('foundItems', foundItems);

NarrowItDownController.$inject = ['$scope', 'MenuSearchService'];
MenuSearchService.$inject = ['$http'];

function MenuSearchService($http) {
  let service = this;

  service.getMatchedMenuItems = (searchTerm) => {
    var response = $http({
      method: "GET",
      url: ("https://davids-restaurant.herokuapp.com/menu_items.json"),
      searchTerm
    })
    .then((response) => {
      // process result and only keep items that match
      let searchTerm = response.config.searchTerm;
      var foundItems = response.data.menu_items.filter(item => {
        return item.description.includes(searchTerm);
      });
      console.log(foundItems);
      // return processed items
      return foundItems;
    })
    .catch((error) => {
      console.log(error);
    });
    return response;
  };
}

function NarrowItDownController($scope, MenuSearchService) {
  $scope.getMatchedMenuItems = function (searchTerm) {
    $scope.myFoundItems = MenuSearchService.getMatchedMenuItems(searchTerm);
  }
};

function foundItems() {
  var ddo = {
    templateUrl: '../foundItems.html',
    scope: {
      items: '<',
      // myTitle: '@title',
      // badRemove: '=',
      // onRemove: '&'
    },
    controller: NarrowItDownController,
    controllerAs: 'list',
    bindToController: true
  };

  return ddo;
};
})();

// You should also provide a "Don't want this one!" button next to each item in the list
  // to give the user the ability to remove an item from that list.

// If nothing is found as a result of the search
// OR if the user leaves the textbox empty and clicks the "Narrow It Down For Me!" button,
  // you should simply display the message "Nothing found".
