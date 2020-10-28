(function () {
'use strict';

angular.module('ShoppingListCheckOff', [])
  .service('ShoppingListCheckOffService', ShoppingListCheckOffService)
  .controller('ToBuyController', ToBuyController)
  .controller('AlreadyBoughtController', AlreadyBoughtController)
  .filter('totalPrice', TotalPriceFilter);

ToBuyController.$inject = ['$scope', 'ShoppingListCheckOffService'];
AlreadyBoughtController.$inject = ['$scope', 'ShoppingListCheckOffService', 'totalPriceFilter'];

function ShoppingListCheckOffService() {
  let service = this;

  service.toBuyItems = [
    { name: "cookies", quantity: 10, pricePerItem: 12 },
    { name: "drones", quantity: 20, pricePerItem: 112 },
    { name: "discs", quantity: 30, pricePerItem: 312 },
    { name: "putters", quantity: 40, pricePerItem: 5512 },
    { name: "lives", quantity: 47, pricePerItem: 9912 },
    { name: "San Franciscos", quantity: 49, pricePerItem: 2 },
    { name: "States", quantity: 50, pricePerItem: 12 },
  ];
  service.alreadyBoughtItems = [];

  service.showEmptyBoughtMessage = [true];

  service.buyItem = function (item) {
    let itemIndex = service.toBuyItems.indexOf(item);
    let purchasedItem = service.toBuyItems.splice(itemIndex, 1)[0];
    // for some reason, the AlreadyBoughtController is only reflecting changes when
    // we store the boolean in an array (e.g. _not_ when we say `.showEmptyBoughtMessage = false`)
    if (service.showEmptyBoughtMessage[0]) {
      service.showEmptyBoughtMessage.shift();
      service.showEmptyBoughtMessage.push(false);
    }
    service.alreadyBoughtItems.push(purchasedItem);
  };
}

function ToBuyController($scope, ShoppingListCheckOffService) {

  $scope.itemsToBuy = ShoppingListCheckOffService.toBuyItems;

  $scope.showEmptyMessage = false;

  $scope.buyItem = function (item) {
    ShoppingListCheckOffService.buyItem(item);
    if ($scope.itemsToBuy.length < 1) $scope.showEmptyMessage = true;
  }
};

function AlreadyBoughtController($scope, ShoppingListCheckOffService, totalPriceFilter) {
  $scope.itemsAlreadyBought = ShoppingListCheckOffService.alreadyBoughtItems;
  $scope.showEmptyBoughtMessage = ShoppingListCheckOffService.showEmptyBoughtMessage;

  $scope.calculateTotalPrice = function (item) {
    return totalPriceFilter(item)
  }
};

function TotalPriceFilter() {
  return function (item) {
    return item.quantity*item.pricePerItem;
  }
}
})();
