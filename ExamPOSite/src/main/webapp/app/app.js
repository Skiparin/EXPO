'use strict'

var app = angular.module("myApp", []);

app.controller("indexController", ["$http", "$scope", function ($http, $scope) {
        var self = this;
        self.origin = "";
        self.destination = "";
        self.date = document.getElementById("startDate");
        self.passenger = 1;

        //test
//        setTimeout(function () {
//            self.passenger = document.getElementById("count");
//            console.log(self.passenger.value);
//            console.log(self.date.value);
//        }, 4000);
        
        self.getData = function() {
            self.passenger = document.getElementById("count");
            console.log("Hej")
            $http.get('http://airline-plaul.rhcloud.com/api/flightinfo/'+self.origin+'/'+self.destination+'/'+self.date.value+'T00:00:00.000Z/'+self.passenger.value)
                    .success(function (data, status, headers, config) {
                        Access-Control-Allow-Origin: *
                        self.data = data;
                        console.log("Hej")
                        console.log(data);
                        console.log(status);
                    })
                    .error(function (data, status, headers, config) {
                        console.log("nope")
                    })
        };

app.config(['$httpProvider', function($httpProvider) {
        $httpProvider.defaults.useXDomain = true;
        delete $httpProvider.defaults.headers.common['X-Requested-With'];
    }
]);

    }]);

