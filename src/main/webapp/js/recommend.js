/**
 * Created by root on 16-11-13.
 */
$(function () {
    $("#rec_form :button").click(function () {
        if($("#cf_name").val()==""){
            alert("book name cant be empty");
            return false;
        }
        if($("#cf_lang").val() ==""){
            alert("lang cant be empty");
            return false;
        }
        if ($("#cf_author").val()==""){
            alert("author cant be empty");
            return false;
        }
        if($("#cf_press").val() ==""){
            alert("press cant be empty");
            return false;
        }
        if($("#cf_ISBN").val() ==""){
            alert("ISBN cant be empty");
            return false;
        }
        if($("#cf_subject").val()==""||!(/^[0-9]*$/).test($("#cf_subject").val())){
            alert("Please input amount correctly!");
            return false;
        }
        if($("#cf_message").val() ==""){
            alert("Why you want to add this recommend?\nReason is required!");
            return false;
        }

        var options = {
            url: "/Recommend/add",
            type: "POST",
            resetForm: false,
            success: function (mydata) {
                alert(mydata);
            },
            error: function () {
                alert("Request failed! Please retry it!");
            }
        };
        $("#rec_form").ajaxSubmit(options);
        return false;
    })

});