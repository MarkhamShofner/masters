(function() {
'use strict';

angular.module('public')
.config(routeConfig);

/**
 * Configures the routes and views
 */
routeConfig.$inject = ['$stateProvider'];
function routeConfig ($stateProvider) {
  // Routes
  $stateProvider
    .state('public', {
      abstract: true,
      templateUrl: 'src/public/public.html'
    })
    .state('public.home', {
      url: '/',
      templateUrl: 'src/public/home/home.html'
    })
    .state('public.menu', {
      url: '/menu',
      templateUrl: 'src/public/menu/menu.html',
      controller: 'MenuController',
      controllerAs: 'menuCtrl',
      resolve: {
        menuCategories: ['MenuService', function (MenuService) {
          return MenuService.getCategories();
        }]
      }
    })
    .state('public.menuitems', {
      url: '/menu/{category}',
      templateUrl: 'src/public/menu-items/menu-items.html',
      controller: 'MenuItemsController',
      controllerAs: 'menuItemsCtrl',
      resolve: {
        menuItems: ['$stateParams','MenuService', function ($stateParams, MenuService) {
          return MenuService.getMenuItems($stateParams.category);
        }]
      }
    })
    .state('public.signup', {
      url: '/signup',
      templateUrl: 'src/public/myinfo/index.html',
      controller: 'MyInfoController',
      controllerAs: 'myInfoCtrl',
      resolve: {
        // menuItems: ['$stateParams','MenuService', function ($stateParams, MenuService) {
        //   return MenuService.getMenuItems($stateParams.category);
        // }]
        myInfo: ['MyInfoService', function (MyInfoService) {
          debugger;
          return MyInfoService.getMyInfo();
        }]
      }
    })
    .state('public.myinfo', {
      url: '/myinfo',
      templateUrl: 'src/public/signup/index.html',
      controller: 'ActualInfoController',
      controllerAs: 'actualInfoCtrl',
      resolve: {
        // menuItems: ['$stateParams','MenuService', function ($stateParams, MenuService) {
        //   return MenuService.getMenuItems($stateParams.category);
        // }]
        // myInfo: ['ActualInfoService', function (ActualInfoService) {
        //   debugger;
        //   return ActualInfoService.getMyInfo();
        // }]
      }
    })
    ;
}
})();
