/**
 * Created by root on 16-11-14.
 */
$(function () {
    $(":button .button_type_15").click(function () {
        var id =$(this).next().html();
        var json ={
            "id":id
        };
        $.get("/BookManage/insert",json,function (mydata) {
            if (mydata == "success")
                alert("Recommend Success!");
            else if (mydata == "error")
                alert("Recommend Failed! try later");
            else
                alert(mydata);
        });

        window.location.href = "/BookManage/reserve?ISBN="+$("#ISBN").val();
    })
})