window.onload = function () {
    initPage();
};
window.onresize = function(){
    initCkEditorHeight();
};
function initPage() {
    // var user_id = sessionStorage.getItem('user_id');
    // var conference_name = localStorage.getItem('conference_name');
    var user_id = '4455';
    var conference_name = '第一次';
    // if(user_id === null){
    //     window.location.href = '/index';//这里没有登录就访问该界面将直接跳转到首页
    // }
    // if(conference_name === null){
    //     window.location.href = '/';//这里跳转到床架会议的界面;
    // }
    initCkEditor(user_id, conference_name);
}
function initCkEditor(user_id, conference_name) {
    var config = {
        filebrowserImageUploadUrl: '/conference/uploadDetailImage?user_id=' + user_id + '&' + 'conference_name=' + conference_name,
        width: '50%'
    };
    var editor = CKEDITOR.replace('editor', config);
    var ckEditorData = localStorage.getItem(user_id + conference_name + 'ckEditorData');
    if(ckEditorData !== null){
        editor.setData(ckEditorData);
        document.getElementById('show_section').innerHTML = editor.getData();
        initTable();
    }
    localStorage.setItem(user_id + conference_name + 'ckEditorData', editor.getData());
    editor.on('instanceReady', function () {
        initCkEditorHeight();
        saveCkEditorData(user_id, conference_name, editor);
    });
    editor.on('change', function () {
        document.getElementById('show_section').innerHTML = this.getData();
        initTable();
    });
}
function initCkEditorHeight() {
    document.getElementById('cke_1_contents').style.height = document.body.offsetHeight  - document.getElementById('cke_1_top').offsetHeight -
        document.getElementById('cke_1_bottom').offsetHeight - 67 + 'px';
}
function initTable() {
    var tables = document.getElementsByTagName('table');
    for(var i = 0; i < tables.length; i++){
        if(tables[i].className === '')
            tables[i].className = 'table table-hover table-responsive text-center';
    }
}
function saveCkEditorData(user_id, conference_name, ckEditorInstance) {
    var show_info = document.getElementById('show_info');
    setInterval(function () {
        if(localStorage.getItem(user_id + conference_name + 'ckEditorData') !== ckEditorInstance.getData()){
            localStorage.setItem(user_id + conference_name + 'ckEditorData', ckEditorInstance.getData());
            // console.log(ckEditorInstance.getData());
            changeDisplay(show_info);
        }
    }, 10000);
    function changeDisplay(show_info) {
        show_info.style.display = 'inline-block';
        setTimeout(function () {
            show_info.style.display = 'none';
        }, 2000)
    }
}