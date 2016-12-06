'use strict'

var app = angular.module("myApp", []);

app.controller("indexController", ["$http", "$scope", function ($http, $scope) {
        var self = this;
        self.origin = "";
        self.destination = "";
        self.date = document.getElementById("startDate");
        self.passenger = 1;

        //test
        setTimeout(function () {
            self.passenger = document.getElementById("count");
            console.log(self.passenger.value);
            console.log(self.date.value);
        }, 4000);
        
        function getData() {
            self.passenger = document.getElementById("count");
            $http.get('http://localhost:8080/ExamPo/flight/get/'+self.origin+'/'+self.destination+'/'+self.date.value+'/'+self.passenger.value)
                    .success(function (data, status, headers, config) {
                        $scope.data = data;
                        console.log(data[0])
                    })
                    .error(function (data, status, headers, config) {
                        console.log("nope")
                    })
        }
        ;



    }]);

