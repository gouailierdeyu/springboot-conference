let editDetail = angular.module('editDetail', []);
editDetail.controller('bodyController', function ($scope, $http, $window) {
    $scope.userEmail = sessionStorage.getItem('userEmail');
    $scope.conferenceName = sessionStorage.getItem('conferenceName');
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
        $window.location.href = '/index';
    };
    $scope.submitEvent = function () {
        let formData = new FormData();
        formData.append('conferenceName', $scope.conferenceName);
        formData.append('startTime', sessionStorage.getItem('startTime'));
        formData.append('endTime', sessionStorage.getItem('endTime'));
        formData.append('field', sessionStorage.getItem('field'));
        formData.append('address', sessionStorage.getItem('address'));
        formData.append('imageUrl', sessionStorage.getItem('imageUrl'));
        formData.append('detail', sessionStorage.getItem($scope.userEmail + $scope.conferenceName + 'ckEditorData'));
        formData.append('userEmail', $scope.userEmail);
        formData.append('reportList', sessionStorage.getItem('reportList'));
        formData.append('ticketList', sessionStorage.getItem('ticketList'));
        formData.append('ownerName', sessionStorage.getItem('ownerName'));
        formData.append('ownerPhone', sessionStorage.getItem('ownerPhone'));
        formData.append('ownerEmail', sessionStorage.getItem('ownerEmail'));
        formData.append('ownerWeb', sessionStorage.getItem('ownerWeb'));
        formData.append('ownerIntroduction', sessionStorage.getItem('ownerIntroduction'));
        $http({
            method: 'POST',
            url: '/conference/insertConference',
            data: formData,
            transformRequest: angular.identity,
            headers: {'Content-Type': undefined},
        }).then(function success(response) {
            $scope.result = response.data;
            if($scope.result.code === 200){
                alert('添加成功，请等待审核');
                sessionStorage.removeItem('startTime');
                sessionStorage.removeItem('endTime');
                sessionStorage.removeItem('field');
                sessionStorage.removeItem('address');
                sessionStorage.removeItem('imageUrl');
                sessionStorage.removeItem($scope.userEmail + $scope.conferenceName + 'ckEditorData');
                sessionStorage.removeItem('reportList');
                sessionStorage.removeItem('ticketList');
                sessionStorage.removeItem('ownerName');
                sessionStorage.removeItem('ownerPhone');
                sessionStorage.removeItem('ownerEmail');
                sessionStorage.removeItem('ownerWeb');
                sessionStorage.removeItem('ownerIntroduction');
                sessionStorage.removeItem('conferenceName');
                sessionStorage.removeItem($scope.userEmail + $scope.conferenceName + 'ckEditorData');
                $window.location.href = '/account/myevent';
            }
            // $scope.userMessage = response.data.data;
        }, function error() {
            $window.location.href = '/index';
        });
        $scope.exitEvent = function () {
            sessionStorage.removeItem('userEmail');
            $window.location.href = '/index';
        };
    };
});
editDetail.filter('lengthLimit', function () {
    return function (input, length) {
        if(input.length > length){
            return input.substring(0, length) + '...';
        }
        else return input;
    }
});
window.onload = function () {
    initPage();
};
window.onresize = function () {
    initCkEditorHeight();
};
function initPage() {
    initCkeditor(sessionStorage.getItem('userEmail'), sessionStorage.getItem('conferenceName'));
}
function initCkeditor(userEmail, conferenceName) {
    let editor = CKEDITOR.replace('editor', {
        filebrowserImageUploadUrl: '/conference/uploadDetailImage?user_id=' + userEmail + '&' + 'conference_name=' + conferenceName,
        width: '50%'
    });
    let ckEditorData = sessionStorage.getItem(userEmail + conferenceName + 'ckEditorData');
    if(ckEditorData !== null){
        editor.setData(ckEditorData);
        document.getElementById('show_section').innerHTML = editor.getData();
        initTable();
    }
    sessionStorage.setItem(userEmail + conferenceName + 'ckEditorData', editor.getData());
    editor.on('instanceReady', function () {
        initCkEditorHeight();
        saveCkEditorData(userEmail, conferenceName, editor);
    });
    editor.on('change', function () {
        document.getElementById('show_section').innerHTML = this.getData();
        initTable();
    });
}
function saveCkEditorData(userEmail, conferenceName, ckEditorInstance) {
    let show_info = document.getElementById('show_info');
    setInterval(function () {
        if(sessionStorage.getItem(userEmail + conferenceName + 'ckEditorData') !== document.getElementById('show_section').innerHTML){
            sessionStorage.setItem(userEmail + conferenceName + 'ckEditorData', document.getElementById('show_section').innerHTML);
            changeDisplay(show_info);
        }
    }, 3000);
    function changeDisplay(show_info) {
        show_info.style.display = 'inline-block';
        setTimeout(function () {
            show_info.style.display = 'none';
        }, 2000)
    }
}
function initTable() {
    let tables = document.getElementsByTagName('table');
    for(let i = 0; i < tables.length; i++){
        if(tables[i].className === '')
            tables[i].className = 'table table-hover table-responsive text-center';
    }
}
function initCkEditorHeight() {
    document.getElementById('cke_1_contents').style.height = document.body.offsetHeight  - document.getElementById('cke_1_top').offsetHeight -
        document.getElementById('cke_1_bottom').offsetHeight - 67 + 'px';
}