window.onload = function () {
    initLayer();
};

function initLayer() {
    let distributionList = document.getElementsByClassName('distribution');
    for(let i = 0; i < distributionList.length; i++){
        distributionList[i].addEventListener('click', function () {
            layer.open({
                type : 1,
                title: '与会人员信息',
                content: '',
                area: ['80%', '80%'],
                btn: ['确认', '取消'],
                yes: function (index, layero) {
                    layer.close(index);
                },
                btn2: function (index, layero) {

                }
            })
        });
    }
}