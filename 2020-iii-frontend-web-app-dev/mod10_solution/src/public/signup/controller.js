(function () {
'use strict';

angular.module('public')
.controller('ActualInfoController', ActualInfoController);


ActualInfoController.$inject = ['MenuService'];
function ActualInfoController(MenuService) {
  console.log('ActualInfoController function');
  let $actualInfo = this;
  // $actualInfo.ActualInfo = ActualInfo;
  // console.log($ActualInfo.ActualInfo)
  // var itemList = this;
  // console.log(items);
  // itemList.items = items;
}


})();
