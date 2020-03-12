let eventDetailApp = angular.module('eventDetailApp', ['ng-layer']);
eventDetailApp.config(['$locationProvider', function ($locationProvider) {
    $locationProvider.html5Mode({
        enabled: true,
        requireBase: false
    });
}]);
eventDetailApp.controller('bodyController', function ($scope, $location, $http, layer, $window) {
    $scope.conferenceName = $location.search().conferencename;
    $scope.reportList = [];
    $scope.reportDetailList = [];
    $http({
        method: 'GET',
        url: '/conference/getReport',
        params: {
            conferenceName: $scope.conferenceName
        }
    }).then(function success(response) {
        $scope.reportSet = response.data.data;
        if($scope.reportSet.length < 4){
            $scope.reportList = $scope.reportSet;
        }else{
            for(let i = 0; i< 4; i++){
                $scope.reportList.push($scope.reportSet[i]);
            }
        }
    }, function error() {
        alert('请稍后再试');
    });
    $http({
        method: 'GET',
        url: '/conference/getReportDetail',
        params: {
            conferenceName: $scope.conferenceName
        }
    }).then(function success(response) {
        $scope.reportDetailList = response.data.data;
        for(let i = 0; i < $scope.reportDetailList.length; i++){
            $scope.reportDetailList[i].inputValue = $scope.reportDetailList[i].inputValue.split(',');
            $scope.reportDetailList[i].showValue = [];
            if($scope.reportDetailList[i].inputValue.length < 4){
                $scope.reportDetailList[i].showValue = $scope.reportDetailList[i].inputValue;
            }else{
                for(let j = 0 ; j < 4; j++){
                    $scope.reportDetailList[i].showValue.push($scope.reportDetailList[i].inputValue[j]);
                }
            }
        }
    }, function error() {
        alert('请稍后再试');
    });
    $http({
        method: 'GET',
        url: '/conference/getConference',
        params: {
            conferenceName: $scope.conferenceName
        }
    }).then(function success(response) {
        $scope.conference = response.data.data;
    }, function error() {
        alert('请稍后再试');
    });
    $http({
        method: 'GET',
        url: '/conference/getPaper',
        params: {
            conferenceName: $scope.conferenceName
        }
    }).then(function success(response) {
        $scope.paperList = response.data.data;
    }, function error() {
        alert('请稍后再试');
    });
    $http({
        method: 'GET',
        url: '/conference/getTicketDetail',
        params: {
            conferenceName: $scope.conferenceName
        }
    }).then(function success(response) {
        $scope.ticketDetailList = response.data.data;
        $scope.priceSum = 0;
        for(let i = 0; i < $scope.ticketDetailList.length; i ++){
            let s = Number($scope.ticketDetailList[i].priceSum);
            $scope.priceSum = $scope.priceSum + s;
        }
    }, function error() {
        alert('请稍后再试');
    });
    $scope.showDetail = function () {
        layer.open({
            type : 1,
            title: '报名详细信息',
            contentUrl: '../../../../static/modules/account/view/showdetail.html',
            // contentUrl: '/account/showdetail',
            scope: $scope,
            area: ['80%', '80%'],
            btn: ['确认', '取消'],
            yes: function (index, layero) {
                layer.close(index);
            },
            btn2: function (index, layero) {

            }
        });
    };
    $scope.showProfessor = function (paperName) {
        layer.open({
            type : 1,
            title: '报名详细信息',
            // contentUrl: '../../../../static/modules/account/view/showdetail.html',
            content: '\t<table class="table table-hover table-responsive text-center" ng-controller="professorController">\n' +
                '\t\t<thead>\n' +
                '\t\t\t<tr>\n' +
                '\t\t\t\t<th class="text-center">序号</th>\n' +
                '\t\t\t\t<th class="text-center">邮箱</th>\n' +
                '\t\t\t\t<th class="text-center">姓名</th>\n' +
                '\t\t\t\t<th class="text-center">公司</th>\n' +
                '\t\t\t\t<th class="text-center">职位</th>\n' +
                '\t\t\t\t<th></th>\n' +
                '\t\t\t</tr>\t\n' +
                '\t\t</thead>\n' +
                '\t\t<tbody>\n' +
                '\t\t\t<tr ng-repeat="myUser in myJoinList">\n' +
                '\t\t\t\t<td>{{$index + 1}}</td>\n' +
                '\t\t\t\t<td>{{myUser.userEmail}}</td>\n' +
                '\t\t\t\t<td>{{myUser.realName}}</td>\n' +
                '\t\t\t\t<td>{{myUser.company}}</td>\n' +
                '\t\t\t\t<td>{{myUser.job}}</td>\n' +
                '\t\t\t\t<td><input type="radio" name="mark" value="{{myUser.userEmail}}" title="{{myUser.userEmail}}"></td>\n' +
                '\t\t\t</tr>\n' +
                '\t\t</tbody>\n' +
                '\t</table>',
            scope: $scope,
            area: ['80%', '80%'],
            btn: ['确认', '取消'],
            yes: function (index, layero) {
                let inputS = document.getElementsByName('mark');
                for(let i = 0; i < inputS.length; i++){
                    if(inputS[i].checked){
                        // console.log(inputS[i].getAttribute('title'));
                        $http({
                            method: 'GET',
                            url: '/conference/updatePaperCheckUser',
                            params: {
                                paperName: paperName,
                                checkUser: inputS[i].getAttribute('title')
                            }
                        }).then(function success() {
                            $window.location.reload();
                        }, function error() {
                            alert('请稍后再试');
                        });
                    }
                }
                layer.close(index)
            },
            btn2: function (index, layero) {

            }
        });
    };
});
eventDetailApp.controller('professorController', function ($scope, $http) {
    $http({
        method: 'GET',
        url: '/conference/getMyUser',
        params: {
            conferenceName: $scope.conferenceName
        }
    }).then(function success(response) {
        $scope.myJoinList = response.data.data;
    }, function error() {
        alert('请稍后再试');
    });
});
eventDetailApp.filter('changeState', function () {
    return function (input) {
        if(input == 1){
            return '审核通过';
        }else if(input==-1){
            return '审核不通过';
        }else if(input==2){
            return '审核中';
        } else if(input==-2){
            return '未分配';
        }
        else return '';
    }
});