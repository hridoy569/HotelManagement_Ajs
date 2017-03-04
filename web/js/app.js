/**
 * Created by hridoy on 2/19/17.
 */

var app = angular.module("myApp", ["ngRoute"]);
app.config(function($routeProvider) {
    $routeProvider
        .when("/", {
            templateUrl : "pages/hotelStatus.html"
            //, controller : "showHideCtrl"
        })
        .when("/booking", {
            templateUrl : "guestBooking.html", 
            controller : "guestBctrl"
        })
        .when("/services", {
            templateUrl : "pages/services.html"
        })
        .when("/bill", {
            templateUrl : "pages/bill.html"
        })
        .when("/rooms", {
            templateUrl : "pages/rooms.html"
        })
        .when("/check", {
            templateUrl : "pages/checkInOut.html"
        })
        .when("/todo", {
            templateUrl : "pages/todo.html"
        })
        .when("/admin", {
            templateUrl : "pages/admin.html"
        });

    });
    
