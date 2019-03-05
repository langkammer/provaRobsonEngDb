'use strict';

// Declare app level module which depends on views, and components
angular.module('App', [
  'ui.router',
  'ui.bootstrap',
  'ui-notification',
  'ngMessages',
  'angularjs-br-directive-validator-cpf'
]).
config(['$locationProvider', '$urlRouterProvider','$stateProvider','NotificationProvider',
      function($locationProvider, $urlRouterProvider,$stateProvider,NotificationProvider) {

  $urlRouterProvider.otherwise('/');


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
      templateUrl:'view/vendedor/vendedores.html'
    })
    .state('clientes',{
      url:'/clientes',
      controller: 'ClienteCtrl',
      templateUrl:'view/cliente/clientes.html'
    })
    console.log("principal");
}]);