(function () {

angular.module('MenuApp')
.config(RoutesConfig);

RoutesConfig.$inject = ['$stateProvider', '$urlRouterProvider'];
function RoutesConfig($stateProvider, $urlRouterProvider) {
  console.log('routes.js');
  // Redirect to `/` if no other URL matches
  $urlRouterProvider.otherwise('/');

  // Set up UI states
  $stateProvider
    .state('home', {
      url: '/',
      templateUrl: 'src/templates/home.html'
    })

    .state('categories', {
      url: '/categories',
      templateUrl: 'src/templates/categories.html',
      controller: 'CategoriesController as categories', // 'MainShoppingListController as mainList',
        resolve: {
          categories: ['MenuDataService', function (MenuDataService) {
            return MenuDataService.getAllCategories();
          }]
        }
    })

    .state('items', {
      url: '/items/{categoryShortName}',
      templateUrl: 'src/templates/items.html',
      controller: 'ItemsController as items',
      resolve: {
        items: ['MenuDataService', '$stateParams', function (MenuDataService, $stateParams) {
          return MenuDataService.getItemsForCategory($stateParams.categoryShortName)
        }]
      }
    });
}
})();
