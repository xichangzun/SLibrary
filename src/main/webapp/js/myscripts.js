/**
 * Created by root on 16-10-22.
 */
$(function () {
    $("#Borrow :button").click(function () {
        var json = {
            "ISBN": $("#ISBN").val(),
            "User_id": $("#UserID").val()
        }
        $.post("/BorrowHistory/borrow", json, function (mydata) {
            mydata = $.parseJSON(mydata);
            if (!mydata) {
                alert("something wrong");
            }
            else {
                alert(mydata.message);
            }
        })
        return false;
    })
});
$(function () {
    $("#Return :button").click(function () {
        var json = {
            "ISBN": $("#ISBN").val(),
            "User_id": $("#UserID").val()
        }
        $.post("/BorrowHistory/BookReturn", json, function (mydata) {
            mydata = $.parseJSON(mydata);
            if (!mydata) {
                alert("something wrong");
            }
            else {
                alert(mydata.message);
            }
        })
        return false;
    })
});