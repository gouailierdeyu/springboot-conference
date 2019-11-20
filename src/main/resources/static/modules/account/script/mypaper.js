let myPaperApp = angular.module('myPaperApp', ['ngRoute']);
myPaperApp.config(['$routeProvider', function ($routeProvider) {
    $routeProvider.
    when('/unpass', {
        templateUrl: 'unpass',
        controller: 'unPassController'
    }).
    when('/pass', {
        templateUrl: 'pass',
        controller: 'passController'
    }).
    when('/uncheck', {
        templateUrl: 'uncheck',
        controller: 'unCheckController'
    }).
    when('/needcheck', {
        templateUrl: 'needcheck',
        controller: 'needCheckController'
    }).
    otherwise({
        redirectTo: '/unpass'
    });
}]);
myPaperApp.controller('bodyController', function ($scope, $http, $window) {
    $scope.userEmail = sessionStorage.getItem('userEmail');
    $scope.index = sessionStorage.getItem('templates.index') === null?$scope.index = 1:$scope.index = sessionStorage.getItem('templates.index');
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
    $scope.setItem = function (index) {
        $scope.index = index;
        sessionStorage.setItem('templates.index', index);
    };
});
myPaperApp.controller('unPassController', function ($scope, $http) {
    $scope.userEmail = sessionStorage.getItem('userEmail');
    $http({
        method: 'GET',
        url: '/account/unPassPaperList',
        params: {
            userEmail: $scope.userEmail
        }
    }).then(function success(response) {
        // console.log(response);
        $scope.unPassPaperList = response.data.data;
    }, function error() {
        alert('请稍后再试');
    });
});
myPaperApp.controller('passController', function ($scope, $http) {
    $scope.userEmail = sessionStorage.getItem('userEmail');
    $http({
        method: 'GET',
        url: '/account/passPaperList',
        params: {
            userEmail: $scope.userEmail
        }
    }).then(function success(response) {
        $scope.passPaperList = response.data.data;
    }, function error() {
        alert('请稍后再试');
    });
});
myPaperApp.controller('unCheckController', function ($scope, $http) {
    $scope.userEmail = sessionStorage.getItem('userEmail');
    $http({
        method: 'GET',
        url: '/account/waitCheckPaperList',
        params: {
            userEmail: $scope.userEmail
        }
    }).then(function success(response) {
        $scope.unCheckPaperList = response.data.data;
    }, function error() {
        alert('请稍后再试');
    });
});
myPaperApp.controller('needCheckController', function ($scope, $http) {
    $scope.userEmail = sessionStorage.getItem('userEmail');
    $http({
        method: 'GET',
        url: '/account/needCheckPaperList',
        params: {
            userEmail: $scope.userEmail
        }
    }).then(function success(response) {
        $scope.needCheckPaperList = response.data.data;
    }, function error() {
        alert('请稍后再试');
    });
});
myPaperApp.filter('lengthLimit', function () {
    return function (input, length) {
        if(input.length > length){
            return input.substring(0, length) + '...';
        }
        else return input;
    }
});