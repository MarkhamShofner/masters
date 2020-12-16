(function () {
'use strict';

angular.module('public')
.controller('SignupController', SignupController);


SignupController.$inject = ['MenuService', 'Signup'];
function SignupController(MenuService, Signup) {
  console.log('SignupController function');
  let $signup = this;
  $signup.Signup = Signup;
  console.log($signup.Signup)
  // var itemList = this;
  // console.log(items);
  // itemList.items = items;
}


})();
