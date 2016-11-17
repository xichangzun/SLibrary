/**
 * Created by root on 16-11-14.
 */
$(function () {
    $("button.button_type_15").click(function () {
        var id =$(this).next().html();
        var json ={
            "id": id
        };
        $.get("/BookManage/insert",json,function (mydata) {
            alert(mydata);
        });
        window.location.href = "/BookManage/reserve?ISBN="+$("#ISBN").val();
    })
});