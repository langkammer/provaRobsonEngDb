'use strict';

// Declare app level module which depends on views, and components
angular.module('App', [
  'ui.router',
  'ngMaterial',
  'ui-notification',
  'checklist-model'
]).
config(['$locationProvider', '$urlRouterProvider','$stateProvider','$mdThemingProvider','NotificationProvider',
      function($locationProvider, $urlRouterProvider,$stateProvider,$mdThemingProvider,NotificationProvider) {

  $urlRouterProvider.otherwise('/');

  $mdThemingProvider.theme('red')
      .primaryPalette('red');

  $mdThemingProvider.theme('blue')
      .primaryPalette('blue');

  NotificationProvider.setOptions({
    delay: 10000,
    startTop: 20,
    startRight: 10,
    verticalSpacing: 20,
    horizontalSpacing: 20,
    positionX: 'center',
    positionY: 'top'
  });

  $stateProvider
    .state('dash',{
      url:'/',
      controller: 'DashCtrl',
      templateUrl:'view/dash/dash.html'
    })
    .state('vendedores',{
      url:'/vendedores',
      controller: 'VendedorCtrl',
      templateUrl:'../view/vendedor/vendedores.html'
    })
    .state('clientes',{
      url:'/clientes',
      controller: 'ClienteCtrl',
      templateUrl:'view/cliente/clientes.html'
    })
    console.log("principal");
}]);