var app = angular.module('collaApp', ['ngRoute','ngCookies']);

app.config(function($routeProvider){
  $routeProvider.when('/login',{                
    templateUrl: 'c_User/login.html',
}).when('/register',{                
    templateUrl: 'c_User/registration.html',
}).otherwise({
  redirectTo: '/',
});
});
