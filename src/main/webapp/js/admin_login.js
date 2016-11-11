/**
 * Created by yhq on 2016/11/11.
 */
function submitByAjax() {
    var options = {
        url: "/Admin/login",
        type: "POST",
        resetForm: false,
        success: function (mydata) {
            if (mydata == "success")
                window.location.href = "admin_info.jsp";
            else if(mydata == "error")
                alert("Login Failed!\nPlease check you id and password!");
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