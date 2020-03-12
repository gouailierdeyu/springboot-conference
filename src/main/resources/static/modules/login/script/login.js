let indexApp = angular.module('indexApp', []);
indexApp.controller('indexController', function ($scope, $http, $timeout, $window) {
    $scope.username = '';
    $scope.password = '';
    $scope.loginEvent = function () {
        if($scope.username === ''){
            $scope.email_tips = '邮箱为空';
            $timeout(function () {
                $scope.email_tips = '';
            }, 2000);
        }
        if($scope.password === ''){
            $scope.password_tips = '密码为空';
            $timeout(function () {
                $scope.password_tips = '';
            }, 2000);
        }
        else {
            $http({
                method: 'GET',
                url: '/checkMyUser',
                params: {
                    userEmail: $scope.username,
                    password: $scope.password
                }
            }).then(function success(response){
                if(response.data.message === null){
                    // sessionStorage.setItem('userMessage', JSON.stringify(response.data.data));
                    sessionStorage.setItem('userEmail', $scope.username);
                    $window.location.href = '/index';
                }
                else{
                    if(response.data.message.length === 5){
                        $scope.email_tips = '账号不存在';
                        $timeout(function () {
                            $scope.email_tips = '';
                        }, 2000);
                    }
                    if(response.data.message.length === 4){
                        $scope.password_tips = '密码错误';
                        $timeout(function () {
                            $scope.password_tips = '';
                        }, 2000);
                    }
                }
            }, function error() {
                $scope.email_tips = '请稍后再试';
            });
        }
    }
});