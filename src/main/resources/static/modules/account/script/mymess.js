let myMessApp = angular.module('myMessApp', ['ngRoute']);
myMessApp.config(['$routeProvider', function ($routeProvider) {
    $routeProvider.
    when('/message', {
        templateUrl: 'message',
        controller: 'messageController'
    }).
    otherwise({
        redirectTo: '/message'
    });
}]);
myMessApp.controller('bodyController', function ($scope, $http, $window) {
    $scope.userEmail = sessionStorage.getItem('userEmail');
    $http({
        method: 'GET',
        url: '/getMyUser',
        params: {
            userEmail: $scope.userEmail
        }
    }).then(function success(response) {
        $scope.userMessage = response.data.data;
    }, function error() {
        $window.location.href = '/index';
    });
    $scope.exitEvent = function () {
        sessionStorage.removeItem('userEmail');
        sessionStorage.removeItem('conferenceIndex');
        sessionStorage.removeItem('ticketIndex');
        sessionStorage.removeItem('templates.index');
        $window.location.href = '/index';
    };
});
myMessApp.controller('messageController', function ($scope, $http) {
    $scope.userEmail = sessionStorage.getItem('userEmail');
    $http({
        method: 'GET',
        url: '/account/getMessage',
        params: {
            userEmail: $scope.userEmail
        }
    }).then(function success(response) {
        $scope.messageList = response.data.data;
    }, function error() {
        alert('请稍后再试');
    });
});
myMessApp.filter('lengthLimit', function () {
    return function (input, length) {
        if(input.length > length){
            return input.substring(0, length) + '...';
        }
        else return input;
    }
});