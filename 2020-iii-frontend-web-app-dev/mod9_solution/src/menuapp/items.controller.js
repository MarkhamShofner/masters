(function () {
'use strict';

angular.module('Data')
.controller('ItemsController', ItemsController);


ItemsController.$inject = ['MenuDataService', 'items', '$stateParams'];
function ItemsController(MenuDataService, items, $stateParams) {
  console.log('items controller function');
  var itemList = this;
  console.log(items);
  itemList.items = items;
}


})();
