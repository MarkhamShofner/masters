(function () {
'use strict';

angular.module('public')
.controller('MyInfoController', MyInfoController);


MyInfoController.$inject = ['MenuService', 'myInfo'];
function MyInfoController(MenuService, myInfo) {
  console.log('MyInfoController function');
  let $myInfo = this;
  $myInfo.myInfo = myInfo;

  


}


})();
