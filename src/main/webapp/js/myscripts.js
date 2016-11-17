/**
 * Created by root on 16-10-22.
 */
$(function () {
    $("#Borrow :button").click(function () {
        var json = {
            "book_id": $("#book_id").val(),
            "user_id": $("#user_id").val()
        }
        $.post("/BorrowHistory/borrow", json, function (mydata) {
            mydata = $.parseJSON(mydata);
            if (!mydata) {
                alert("Borrow Error!");
            }
            else {
                alert(mydata.message);
                $("#book_id").val("");
                $("#user_id").val("");
            }
        })
        return false;
    })
});
$(function () {
    $("#Return :button").click(function () {
        var json = {
            "book_id": $("#book_id").val()
        }
        $.post("/BorrowHistory/BookReturn", json, function (mydata) {
            mydata = $.parseJSON(mydata);
            if (!mydata) {
                alert("something wrong");
            }
            else {
                alert(mydata.message);
                $("#book_id").val("");
            }
        })
        return false;
    })
});

//注册
$(function () {
    $("#reg_form :button").click(function () {
        var temp = false;
        var Qxcz = $("#reg_form .mycss_3_hidden")
        Qxcz.each(function () {
            if($(this).css("visibility") == "visible")
                temp = true;
        });
        var Fxcz = $("#reg_form .mycss_3").each(function () {
            if($(this).children("input").val() ==""){
                temp = true;
            }
        });
        if(temp){
            alert("You can't submit until you fill the form correctly");
            return false;
        } else{
            var options = {
                url: "/User/register",
                type: "POST",
                resetForm: false,
                success: function (mydata) {
                    if (mydata == "success")
                        alert("Register Success!");
                    else if (mydata == "error")
                        alert("Register Failed!\nThis id is registered!");
                    else
                        alert(mydata);
                },
                error: function () {
                    alert("Request failed! Please retry it!");
                }
            };
            $("#reg_form").ajaxSubmit(options);
            return false;
        }
    })
});

$(function () {
    $("#reg_form .mycss_3").each(function () {
        var a = $(this).children("input")
        var c = $(this).next()
        $(a).on("blur",function () {
            if(a.val() == "")
            {
                c.children("label").text("this field is required")
                c.css("visibility","visible")
            }
            else
            {
                c.css("visibility","hidden")
            }
        })
    })
});
$(function () {
    $("#reg_form :input[name='cfpwd']").on('blur',function () {
        var c = $("#cfinfo");
        if($(this).val() != $("#reg_form :input[name='pwd']").val()){
            c.children("label").text("two password are different")
            c.css("visibility","visible")
        }
        else {
            c.css("visibility","hidden")
        }
    })
});