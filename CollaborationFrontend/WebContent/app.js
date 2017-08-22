var app=angular.module('myApp',['ngRoute','ngCookies', 'ngStorage']);
app.config(function($routeProvider,$locationProvider){
  $locationProvider.hashPrefix('');
  $routeProvider.when('/',{
    templateUrl: 'views/home.html',
    controller: 'HomeController'
  }).when('/login',{
    templateUrl: 'c_User/login.html'
  }).when('/register',{
    templateUrl: 'c_User/registration.html'
}).when('/administrator',{
   templateUrl: 'views/admin.html',
   controller: 'AdminController'
}).when('/driver',{
  templateUrl: 'views/driver.html',
  controller: 'DriverController'
}).when('/addTariffPlan',{
  templateUrl: 'views/addTariffPlan.html',
}).when('/errorPage',{
  templateUrl: 'views/errorPage.html',
}).otherwise({
  redirectTo: '/',
});
});

