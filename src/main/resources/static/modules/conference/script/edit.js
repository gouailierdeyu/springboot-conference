let edit = angular.module('edit', []);
edit.controller('bodyController', function ($scope, $http, $window) {
    $scope.userEmail = sessionStorage.getItem('userEmail');
    $scope.ticketList = [];
    $scope.reportList = [];
    $http({
        method: 'GET',
        url: '/getMyUser',
        params: {
            userEmail: $scope.userEmail
        }
    }).then(function success(response) {
        $scope.userMessage = response.data.data;
    }, function error() {
        alert('请登录');
        $window.location.href = '/login';
    });
    $scope.exitEvent = function () {
        sessionStorage.removeItem('userEmail');
        $window.location.href = '/index';
    };
    $scope.showMap = function(){
        if(document.getElementById('map_div').style.display === ''){
            document.getElementById('map_div').style.display = 'none';
        }else{
            document.getElementById('map_div').style.display = '';
        }
    };
    $scope.deleteTicket = function(index){
        $scope.ticketList.splice(index, 1);
    };
    $scope.saveTicket = function(){
        if($scope.checkTicket()){
            $scope.ticketList.push({
                id: 0,
                name: $scope.name,
                price: $scope.price,
                description: $scope.description,
                conferenceName: $scope.conferenceName
            });
            $scope.cancelTicket();
        }
    };
    $scope.cancelTicket = function(){
        $scope.name = '';
        $scope.price = '';
        $scope.description = '';
    };
    $scope.checkTicket = function(){
        if($scope.name === '' || $scope.name === undefined){
            alert('票名不能为空');
            return false;
        }else if($scope.price === '' || $scope.price === undefined){
            alert('价格不能为空');
            return false;
        }else if($scope.description === '' || $scope.description === undefined){
            alert('描述不能为空');
            return false;
        }else if($scope.conferenceName === '' || $scope.conferenceName === undefined) {
            alert('会议名不能不能为空');
            return false;
        }
        return true;
    };
    $scope.addReport = function(type) {
        if($scope.checkReport()){
            if(type === 'input'){
                $scope.reportList.push({
                    id: 0,
                    inputKey: $scope.inputKey,
                    category: 'input',
                    insertTime: '',
                    conferenceName: $scope.conferenceName
                });
            }else{
                $scope.reportList.push({
                    id: 0,
                    inputKey: $scope.inputKey,
                    category: 'textarea',
                    insertTime: '',
                    conferenceName: $scope.conferenceName
                });
            }
            $scope.inputKey = '';
        }
    };
    $scope.deleteReport = function(index) {
        $scope.reportList.splice(index, 1);
    };
    $scope.checkReport = function(){
        if($scope.inputKey === '' || $scope.inputKey === undefined){
            alert('报名项不能为空');
            return false;
        }else if($scope.conferenceName === '' || $scope.conferenceName === undefined) {
            alert('会议名不能不能为空');
            return false;
        }
        return true;
    };
    $scope.nextEdit = function (){
        let formData = new FormData();
        if($scope.conferenceName === '' || $scope.conferenceName === undefined){
            alert('会议名不能为空');
            return null;
        }else if($('#activity_start_time').val() === '' || $('#activity_start_time').val() === undefined){
            alert('会议开始时间不能为空');
            return null;
        }else if($('#activity_end_time').val() === '' || $('#activity_end_time').val() === undefined){
            alert('会议结束时间不能为空');
            return null;
        }else if(sessionStorage.getItem('address') === '' || sessionStorage.getItem('address') === undefined){
            alert('会议地址不能为空');
            return null;
        }else if($scope.ownerName === '' || $scope.ownerName === undefined){
            alert('会议主办方不能为空');
            return null;
        }else if($scope.ticketList.length === 0){
            alert('请填写会议门票信息');
            return null;
        }else if($scope.reportList.length === 0) {
            alert('请填写会议报名信息');
            return null;
        }else{
            sessionStorage.setItem('conferenceName', $scope.conferenceName);
            sessionStorage.setItem('startTime', $('#activity_start_time').val());
            sessionStorage.setItem('endTime', $('#activity_end_time').val());
            sessionStorage.setItem('ownerName', $scope.ownerName);
            sessionStorage.setItem('ownerPhone', $scope.ownerPhone);
            sessionStorage.setItem('ownerEmail', $scope.ownerEmail);
            sessionStorage.setItem('ownerWeb', $scope.ownerWeb);
            sessionStorage.setItem('ownerIntroduction', $scope.ownerIntroduction);
            sessionStorage.setItem('field', $scope.field);
            sessionStorage.setItem('ticketList', JSON.stringify($scope.ticketList));
            sessionStorage.setItem('reportList', JSON.stringify($scope.reportList));
            sessionStorage.setItem('ticketList', JSON.stringify($scope.ticketList));
            sessionStorage.setItem('ticketList', JSON.stringify($scope.ticketList));
            sessionStorage.setItem('ticketList', JSON.stringify($scope.ticketList));
            formData.append('userEmail', sessionStorage.getItem('userEmail'));
            formData.append('image', $('#activity_image')[0].files[0]);
            formData.append('conferenceName', $scope.conferenceName);
            $http({
                method: 'POST',
                url: '/conference/updateConferenceImage',
                data: formData,
                transformRequest: angular.identity,
                headers: {'Content-Type': undefined},
                transformResponse: function (data) {
                    return data;
                }
            }).then(function success(response) {
                let resultSet = JSON.parse(response.data);
                if(resultSet.code === 200){
                    sessionStorage.setItem('imageUrl', resultSet.data);
                    $window.location.href = '/conference/editdetail';
                }
            }, function error() {
                alert('请稍后再试');
            });
        }
    };
});
edit.filter('lengthLimit', function () {
    return function (input, length) {
        if(input.length > length){
            return input.substring(0, length) + '...';
        }
        else return input;
    }
});
edit.filter('inputType', function () {
    return function (input) {
        if(input === 'input'){
            return '单行文本框';
        }
        else return '多行文本框';
    }
});
window.onload = function () {
    initDateTimePicker();
    initGodMap();
};
function initDateTimePicker() {
    $('.activity_time').datetimepicker({
        pickerPosition: 'bottom-left',
        minView: 'month',
        format: 'yyyy-mm-dd'
    });
}
function  previewImage() {
    let reads= new FileReader();
    let file=document.getElementById('activity_image').files[0];
    reads.readAsDataURL(file);
    reads.onload=function () {
        document.getElementById('activity_show').src=this.result;
    };
};
function initGodMap() {
    let godMap = new AMap.Map(document.getElementById('godMap'), {
        zoom: 12,
        center: [116.397428, 39.90923],
        viewMode: '3D'
    });
    AMapUI.loadUI(['misc/PoiPicker'], function (PoiPicker) {
        let poiPicker = new PoiPicker({
            input: 'address'
        });
        poiPickerReady(poiPicker);
    });
    function poiPickerReady(poiPicker) {
        window.poiPicker = poiPicker;
        let marker = new AMap.Marker();
        let infoWindow = new AMap.InfoWindow({
            offset: new AMap.Pixel(0, -25)
        });
        poiPicker.on('poiPicked', function (poiResult) {
            let poi = poiResult.item;
            marker.setMap(godMap);
            infoWindow.setMap(godMap);
            marker.setPosition(poi.location);
            let infoString = '<div style=""><span><p style="display: inline-block; font-weight: bold">' + poi.name + '</p>&nbsp;&nbsp;<a href="'+'http://ditu.amap.com/regeo?lng=' + poi.location.lng + '&lat=' + poi.location.lat +'" target="_blank">详情>></a></span><p>地址:' + poi.district + poi.address + '</p></div>';
            infoWindow.setContent(infoString);
            infoWindow.open(godMap, marker.getPosition());
            godMap.setFitView();
            marker.on('click', function () {
                document.getElementById('map_div').style.display = 'none';
                document.getElementById('activity_address').value = poi.district + poi.address;
                let addressLocation = {
                    lng: poi.location.lng,
                    lat: poi.location.lat,
                    district: poi.district,
                    address: poi.address
                };
                sessionStorage.setItem('address', JSON.stringify(addressLocation));
            });
        })
    }
}