let myInfoApp = angular.module('myInfoApp', []);
myInfoApp.controller('bodyController', function ($scope, $http, $window) {
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
    $scope.checkFile = function() {
        let fileName = document.getElementById('head_images').value;
        let file = document.getElementById('head_images').files[0];
        let fileType = fileName.substring(fileName.lastIndexOf('.')).toLowerCase();
        if(fileType !== '.png' && fileType !== '.bmp' && fileType !== '.jpg'){
            alert('请上传png/bmp/jpg格式的图片');
            return false;
        }
        if(file.size > 512000){
            alert('图片大小超过了500KB');
            return false;
        }
        return true;
    };
    $scope.submitEvent = function () {
        if($scope.checkFile()){
            let formData = new FormData();
            formData.append('userEmail', $scope.userMessage.userEmail);
            formData.append('headImgFile', $('#head_images')[0].files[0]);
            formData.append('realName', $scope.userMessage.realName);
            formData.append('companyName', $scope.userMessage.companyName);
            formData.append('job', $scope.userMessage.job);
            $http({
                method: 'POST',
                url: '/account/updateUser',
                data: formData,
                transformRequest: angular.identity,
                headers: {'Content-Type': undefined},
                transformResponse: function (data) {
                    return data;
                }
            }).then(function success(response) {
                let resultSet = JSON.parse(response.data);
                if(resultSet.code === 200){
                    $window.location.reload();
                }
            }, function error() {
                alert('请稍后再试');
            })
        }
    }
});
myInfoApp.filter('lengthLimit', function () {
    return function (input, length) {
        if(input.length > length){
            return input.substring(0, length) + '...';
        }
        else return input;
    }
});