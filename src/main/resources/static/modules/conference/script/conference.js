let conferenceApp = angular.module('conferenceApp', ['ngSanitize']);
conferenceApp.config(['$locationProvider', function ($locationProvider) {
    $locationProvider.html5Mode({
        enabled: true,
        requireBase: false
    });
}]);
conferenceApp.controller('bodyController', function ($scope, $location, $http, $window) {
    $scope.conferenceName = $location.search().conferencename;
    $scope.ticketSum = [];
    $scope.ticketAble = false;
    $scope.sumPrice = 0;
    $scope.conference = null;
    $scope.ticketList = null;
    $http({
        method: 'GET',
        url: '/conference/getConference',
        params: {
            conferenceName: $scope.conferenceName
        }
    }).then(function success(response) {
        $scope.conference = response.data.data;
        // console.log($scope.conference.detail);
        document.getElementById('detail_panel').innerHTML = $scope.conference.detail;
        $scope.address = JSON.parse($scope.conference.address);
        $scope.marker = new AMap.Marker({
            position: [$scope.address.lng, $scope.address.lat]
        });
        $scope.godMap = new AMap.Map(document.getElementById('godMap'), {
            zoom: 16,
            center: [$scope.address.lng, $scope.address.lat],
            viewMode: '3D'
        });
        $scope.godMap.add($scope.marker);
        $scope.ticketAble = Number(new Date($scope.conference.startTime).getTime()) < Number(new Date().getTime());
    }, function error() {
        alert('请稍后再试');
    });
    $http({
        method: 'GET',
        url: '/conference/getTicketList',
        params: {
            conferenceName: $scope.conferenceName
        }
    }).then(function success(response) {
        $scope.ticketList = response.data.data;
        for(let i = 0 ; i < $scope.ticketList.length; i++){
            $scope.ticketSum.push(0);
        }
    }, function error() {
        alert('请稍后再试');
    });
    $http({
        method: 'GET',
        url: '/conference/getOwner',
        params: {
            conferenceName: $scope.conferenceName
        }
    }).then(function success(response) {
        $scope.owner = response.data.data;
    }, function error() {
        alert('请稍后再试');
    });
    $scope.minus = function (index) {
        if($scope.ticketSum[index] === 0){
            return false;
        }else{
            $scope.ticketSum[index] --;
            $scope.sumPrice -= Number($scope.ticketList[index].price);
        }
    };
    $scope.plus = function (index) {
        $scope.ticketSum[index] ++;
        $scope.sumPrice += Number($scope.ticketList[index].price);
    };
    $scope.payTicketEvent = function () {
        if(sessionStorage.getItem('userEmail') === null || sessionStorage.getItem('userEmail') === undefined){
            alert('请登录');
            $window.location.href = '/login';
            return ;
        }else if($scope.sumPrice === 0){
            alert('请选择门票');
            return ;
        }
        sessionStorage.setItem('sumPrice', $scope.sumPrice);
        sessionStorage.setItem('ticketList', JSON.stringify($scope.ticketList));
        sessionStorage.setItem('ticketSum', JSON.stringify($scope.ticketSum));
        $window.location.href = '/conference/signup?conferencename=' + $scope.conferenceName;
    }
});