/**
 * Created by yhq on 2016/11/10.
 */
function submitByAjax() {
    var options = {
        url: "/EBook/add",
        type: "POST",
        resetForm: false,
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

