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
                alert("something wrong");
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
$(function () {
    $("#reg_form :button").click(function () {
        var temp = false
        var Qxcz = $("#reg_form .fuck_3_hidden")
        Qxcz.each(function () {
            if($(this).css("visibility") == "visible")
                temp = true
        })
        if(temp){
            alert("you can't submit until you fill the form correctly")
            return false;
        }
    })
});

$(function () {
    $("#reg_form .fuck_3").each(function () {
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