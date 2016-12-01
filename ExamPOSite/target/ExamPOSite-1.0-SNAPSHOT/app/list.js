'use strict';

var app = angular.module("myApp", []);

app.controller("myCtrl", ["$http", "$scope", function ($http, $scope) {
    var self = this;
    self.firstName = "John";
    self.lastName = "Doe";
}]);

