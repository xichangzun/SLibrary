/**
 * Created by root on 16-11-14.
 */
$(function () {
    $("#loginform button").click(function () {
        var options = {
            url: "/User/ajaxlogin",
            type: "POST",
            resetForm: true,
            success: function (mydata) {
                if (mydata == "success")
                    alert("Add Success!");
                else if(mydata == "error")
                    alert("Add Failed!\nThe same ISBN is added!");
                else
                    alert(mydata);
            },
            error: function () {
                alert("Request failed!Please retry it!");
            }
        };
        $("#form").ajaxSubmit(options);
    })
    $("button.button_type_15").click(function () {
        var pid = $(this).parent().siblings().first();
        var id = $(pid).html()
        var json ={
            "id": id
        };
        $.get("/BookManage/insert",json,function (mydata) {
            alert(mydata);
            window.location.href = "/BookManage/reserve?ISBN="+$("#ISBN").val();
        });
    })
});