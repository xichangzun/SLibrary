/**
 * Created by yhq on 2016/10/23.
 */
$(function () {
    $("#form :button").click(function () {
        var ISBN = $(":input[name='ISBN']").val();
        if( ISBN.trim()== ""){
            alert("bad form, ISBN is required");
            return false;
        }
        else if (!(/^[0-9]*$/).test(ISBN)){
            alert("bad form,ISBN must be number");
            return false;
        }
        else if($(":input[name='name']").val().trim() == ""){
            alert("bad form,Book_Name is required");
            return false;
        }
        else if($(":input[name='author']").val().trim() == ""){
            alert("bad form, author is required");
            return false;
        }
        else if($(":input[name='lang']").val().trim() == ""){
            alert("bad form , lang is required");
            return false;
        }
        else if($(":input[name='press']").val().trim() == ""){
            alert("bad form , press is required");
            return false;
        }
        else if($(":input[name='pub_year']").val().trim() == ""){
            alert("bad form, pub_year is required");
            return false;
        }
        else if(!(/^[0-9]*$/).test($(":input[name='pub_year']").val())){
            alert("bad form, pub_year must be number ");
            return false;
        }
        else  if($(":input[name='amount']").val().trim() == ""){
            alert("bad form, amount is required ");
            return false;
        }
        else if(!(/^[0-9]*$/).test($(":input[name='amount']").val())){
            alert("bad form, amount must be number ");
            return false;
        }
        else if($(":input[name='call_no']").val().trim() == ""){
            alert("bad form, call_no is required ");
            return false;
        }
        else if($(":input[name='pages']").val() != ""&& !(/^[0-9]*$/).test($(":input[name='pages']").val())){
            alert("bad form, pages must be number ");
            return false;
        }
        else if($(":input[name='size']").val() != ""&& !(/^[0-9]*$/).test($(":input[name='size']").val())){
            alert("bad form, size must be number ");
            return false;
        }
        else {
            var options = {
                url: "/BookManage/Add",
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
            return false;
        }
    })
});

