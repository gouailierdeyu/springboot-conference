window.onload = function () {
    document.getElementsByClassName('col-sm-2')[0].style.height = document.documentElement.clientHeight - 66 + 'px';
};
window.onresize = function () {
    document.getElementsByClassName('col-sm-2')[0].style.height = document.documentElement.clientHeight - 66 + 'px';
};
function previewImage() {
    let reads= new FileReader();
    let file=document.getElementById('head_images').files[0];
    reads.readAsDataURL(file);
    reads.onload=function () {
        document.getElementById('head-show').src=this.result;
    };
}