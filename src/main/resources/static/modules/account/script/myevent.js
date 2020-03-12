let myEventApp = angular.module('myEventApp', ['ngRoute']);
myEventApp.config(['$routeProvider', function ($routeProvider) {
    $routeProvider.
    when('/conference', {
        templateUrl: 'conference',
        controller: 'conferenceController'
    }).
    when('/waitcheck', {
        templateUrl: 'waitcheck',
        controller: 'waitcheckController'
    }).
    when('/unpass', {
        templateUrl: 'unpass',
        controller: 'unpassController'
    }).
    otherwise({
        redirectTo: '/conference'
    });
}]);
myEventApp.controller('bodyController', function ($scope, $http, $window) {
    $scope.userEmail = sessionStorage.getItem('userEmail');
    $scope.conferenceIndex = sessionStorage.getItem('conferenceIndex') === null?$scope.conferenceIndex = 1:$scope.conferenceIndex = sessionStorage.getItem('conferenceIndex');
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
    $scope.setItem = function (conferenceIndex) {
        $scope.conferenceIndex = conferenceIndex;
        sessionStorage.setItem('conferenceIndex', conferenceIndex);
    };
    $scope.showCheckResult = function (checkResult) {
        layer.open({
            type : 1,
            title: '审核信息',
            content: checkResult,
            scope: $scope,
            area: ['30%', '40%'],
            btn: ['确认', '取消'],
            yes: function (index, layero) {
                layer.close(index);
            },
            btn2: function (index, layero) {

            }
        });
    }
});
myEventApp.controller('conferenceController', function ($scope, $http) {
    $scope.userEmail = sessionStorage.getItem('userEmail');
    $http({
        method: 'GET',
        url: '/account/myConference',
        params: {
            userEmail: $scope.userEmail
        }
    }).then(function success(response) {
        $scope.conferenceList = response.data.data;
    }, function error() {
        alert('请稍后再试');
    });
});
myEventApp.controller('waitcheckController', function ($scope, $http) {
    $scope.userEmail = sessionStorage.getItem('userEmail');
    $http({
        method: 'GET',
        url: '/account/myWaitCheckConference',
        params: {
            userEmail: $scope.userEmail
        }
    }).then(function success(response) {
        $scope.waitcheckList = response.data.data;
    }, function error() {
        alert('请稍后再试');
    });
});
myEventApp.controller('unpassController', function ($scope, $http) {
    $scope.userEmail = sessionStorage.getItem('userEmail');
    $http({
        method: 'GET',
        url: '/account/myUnPassConference',
        params: {
            userEmail: $scope.userEmail
        }
    }).then(function success(response) {
        $scope.unpassList = response.data.data;
    }, function error() {
        alert('请稍后再试');
    });
});
myEventApp.filter('lengthLimit', function () {
    return function (input, length) {
        if(input.length > length){
            return input.substring(0, length) + '...';
        }
        else return input;
    }
});
myEventApp.filter('changeShow', function () {
    return function (input) {
        if(input === -1){
            return '审核不通过';
        }
    }
});
myEventApp.filter('getAddress', function () {
    return function (address) {
        let addressNew =  JSON.parse(address);
        return addressNew.district;
    }
});