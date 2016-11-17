/**
 * Created by root on 16-11-14.
 */
$(function () {
    var id = $("#user_id").val();
    if(id != ""){
        $("#LoginButton").hide();
        $("#ReButton").hide();
        $("#InfoButton").show();
        $("#CheckOutButton").show();
    }
    else {
        $("#LoginButton").show();
        $("#ReButton").show();
        $("#InfoButton").hide();
        $("#CheckOutButton").hide();
    }

    $("#loginform :button").click(function () {
        var options = {
            url: "/User/ajaxlogin",
            type: "POST",
            resetForm: true,
            success: function (mydata) {

                if (mydata == "success"){
                    alert("login Success!");
                    window.location.href = "/BookManage/reserve?ISBN="+$("#ISBN").val();
                }
                else if(mydata == "error")
                    alert("login Failed!");
                else
                    alert(mydata);
            },
            error: function () {
                alert("Request failed!Please retry it!");
            }
        };
        $("#loginform").ajaxSubmit(options);
        return false;
    });
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