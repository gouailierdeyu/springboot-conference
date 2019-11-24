let myJoinApp = angular.module('myJoinApp', ['ngRoute']);
myJoinApp.config(['$routeProvider', function ($routeProvider) {
    $routeProvider.
    when('/join', {
        templateUrl: 'join',
        controller: 'joinController'
    }).
    when('/ticket', {
        templateUrl: 'ticket',
        controller: 'ticketController'
    }).
    otherwise({
        redirectTo: '/join'
    });
}]);
myJoinApp.controller('bodyController', function ($scope, $http, $window) {
    $scope.userEmail = sessionStorage.getItem('userEmail');
    $scope.ticketIndex = sessionStorage.getItem('ticketIndex') === null?$scope.ticketIndex = 1:$scope.ticketIndex = sessionStorage.getItem('ticketIndex');
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
    $scope.setItem = function (ticketIndex) {
        $scope.ticketIndex = ticketIndex;
        sessionStorage.setItem('ticketIndex', ticketIndex);
    }
});
myJoinApp.controller('joinController', function ($scope, $http) {
    $scope.userEmail = sessionStorage.getItem('userEmail');
    $http({
        method: 'GET',
        url: '/account/joinConferenceList',
        params: {
            userEmail: $scope.userEmail
        }
    }).then(function success(response) {
        $scope.joinConferenceList = response.data.data;
    }, function error() {
        alert('请稍后再试');
    });
});
myJoinApp.controller('ticketController', function ($scope, $http) {
    $scope.userEmail = sessionStorage.getItem('userEmail');
    $http({
        method: 'GET',
        url: '/account/myTicketList',
        params: {
            userEmail: $scope.userEmail
        }
    }).then(function success(response) {
        $scope.ticketList = response.data.data;
    }, function error() {
        alert('请稍后再试');
    });
});

myJoinApp.filter('lengthLimit', function () {
    return function (input, length) {
        if(input.length > length){
            return input.substring(0, length) + '...';
        }
        else return input;
    }
});
myJoinApp.filter('getAddress', function () {
    return function (address) {
        let addressNew =  JSON.parse(address);
        return addressNew.district;
    }
});