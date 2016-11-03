/**
 * Created by yhq on 2016/10/23.
 */


$(function () {
    $("#addBook :button").click(function () {
        var ISBN = $(":input[name='ISBN']").val();
        if( ISBN== ""){
            alert("bad form, ISBN is required");
            return false;
        }
        else if (!(/^[0-9]*$/).test(ISBN)){
            alert("bad form,ISBN must be number");
            return false;
        }
        else if($(":input[name='Book_name']").val() == ""){
            alert("bad form,Book_Name is required");
            return false;
        }
        else if($(":input[name='author']").val() == ""){
            alert("bad form, author is required");
            return false;
        }
        else if($(":input[name='lang']").val() == ""){
            alert("bad form , lang is required");
            return false;
        }
        else if($(":input[name='press']").val() == ""){
            alert("bad form , press is required");
            return false;
        }
        else if($(":input[name='pub_year']").val() == ""){
            alert("bad form, pub_year is required");
            return false;
        }
        else if(!(/^[0-9]*$/).test($(":input[name='pub_year']").val())){
            alert("bad form, pub_year must be int ");
            return false;
        }
        else  if($(":input[name='total_amount']").val() == ""){
            alert("bad form, amount is required ");
            return false;
        }
        else if(!(/^[0-9]*$/).test($(":input[name='total_amount']").val())){
            alert("bad form, amount must be int ");
            return false;
        }
        else if($(":input[name='call_no']").val() == ""){
            alert("bad form, call_no is required ");
            return false;
        }
        else if($(":input[name='pages']").val() != ""&& !(/^[0-9]*$/).test($(":input[name='pages']").val())){
            alert("bad form, pages must be int ");
            return false;
        }
        else if($(":input[name='size']").val() != ""&& !(/^[0-9]*$/).test($(":input[name='size']").val())){
            alert("bad form, size must be int ");
            return false;
        }
        else {
            return true;
        }
    })
});

