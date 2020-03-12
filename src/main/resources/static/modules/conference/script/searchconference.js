let searchApp = angular.module('searchApp', []);
// searchApp.config(['$locationProvider', function ($locationProvider) {
//     $locationProvider.html5Mode({
//         enabled: true,
//         requireBase: false
//     });
// }]);
searchApp.controller('bodyController', function ($scope, $http, $window) {
    sessionStorage.getItem('address') === null?$scope.address = '':$scope.address = sessionStorage.getItem('address');
    sessionStorage.getItem('field') === null?$scope.field = '':$scope.field = sessionStorage.getItem('field');
    sessionStorage.getItem('searchKey') === null?$scope.searchKey = '':$scope.searchKey = sessionStorage.getItem('searchKey');
    $scope.searchEvent = function (conferenceName, address, field) {
        $scope.address = sessionStorage.getItem('address');
        $scope.field = sessionStorage.getItem('field');
        $http({
            method: 'GET',
            url: '/conference/getSearchConferenceList',
            params: {
                conferenceName: conferenceName,
                address: address,
                field: field
            }
        }).then(function success(response) {
            $scope.searchConferenceList = response.data.data;
        }, function error() {
            // $window.location.href = '/index';
            alert('请稍后再试');
        });
    };
    $scope.showFlag = true;
    $scope.userEmail = sessionStorage.getItem('userEmail');
    $scope.searchEvent($scope.searchKey, $scope.address, $scope.field);
    if ($scope.userEmail === null || $scope.userEmail === undefined) {
        $scope.showFlag = true;
    } else {
        $scope.showFlag = false;
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
    }
    $scope.exitEvent = function () {
        sessionStorage.removeItem('userEmail');
        sessionStorage.removeItem('conferenceIndex');
        sessionStorage.removeItem('ticketIndex');
        sessionStorage.removeItem('templates.index');
        $window.location.href = '/index';
    };
    $scope.searchByAddress = function (address) {
        $scope.address = address;
        sessionStorage.setItem('address', address);
        sessionStorage.setItem('searchKey', '');
        $scope.searchEvent('', address, sessionStorage.getItem('field'));
    };
    $scope.searchByField = function (field) {
        $scope.field = field;
        sessionStorage.setItem('field', field);
        sessionStorage.setItem('searchKey', '');
        $scope.searchEvent('', sessionStorage.getItem('address'), field);
    };
    $scope.searchKeyEvent = function () {
        $http({
            method: 'GET',
            url: '/conference/getSearchConferenceList',
            params: {
                conferenceName: $scope.searchKey,
                address: $scope.searchKey,
                field: $scope.searchKey
            }
        }).then(function success(response) {
            $scope.searchConferenceList = response.data.data;
        }, function error() {
            alert('请稍后再试');
        });
    };
});
searchApp.filter('lengthLimit', function () {
    return function (input, length) {
        if(input === null)
            return '';
        if(input.length > length){
            return input.substring(0, length) + '...';
        }
        else return input;
    }
});
searchApp.filter('getAddress', function () {
    return function (address) {
        let addressNew =  JSON.parse(address);
        if(addressNew.district.length > 6){
            return addressNew.district.substring(0, 6) + '...';
        }else{
            return addressNew.district;
        }
    }
});
window.onunload = function () {
    sessionStorage.setItem('searchKey', '');
};