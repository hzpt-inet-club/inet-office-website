function uploadpic() {
    var formData = new FormData();
    var file = document.getElementById('file').files[0];
    console.log(file);
    // var id_token = $('#id_token').val();
    formData.append("img_file", file);
    // formData.append("id_token", id_token);
    $.ajax({
        url: "/addImg",
        type: "post",
        data: formData,
        dataType: "json",
        // cache: false,//上传文件无需缓存
        processData: false,//用于对data参数进行序列化处理 这里必须false
        contentType: false, //必须*/
        /*success: function (data) {
            // console.log(data);
            $("#dianziqianmingImg").attr('src', '${path }' + data.msg).removeAttr('style').attr('style', 'width: 100px;height: 100px');
            $("#dianziqianmingPath").val(data.msg)
        }*/
    });}