let joinDetailApp = angular.module('joinDetailApp', []);
joinDetailApp.config(['$locationProvider', function ($locationProvider) {
    $locationProvider.html5Mode({
        enabled: true,
        requireBase: false
    });
}]);
joinDetailApp.controller('bodyController', function ($scope, $http, $location) {
    $scope.conferenceName = $location.search().conferencename;
    $http({
        method: 'GET',
        url: '/conference/getConference',
        params: {
            conferenceName: $scope.conferenceName
        }
    }).then(function success(response) {
        $scope.conferece = response.data.data;
    }, function error() {
        alert('请稍后再试');
    });
    $http({
        method: 'GET',
        url: '/conference/getPassPaper',
        params: {
            conferenceName: $scope.conferenceName
        }
    }).then(function success(response) {
        $scope.paperList = response.data.data;
    }, function error() {
        alert('请稍后再试');
    });
});