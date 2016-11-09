/**
 * Created by yhq on 2016/11/8.
 */
function getData(page, type) {
    $.ajax({
        url: "/Recommend/get",
        type: "GET",
        dataType: "json",
        data:{
            "page": page,
            "type": type
        },
        success: function (mydata) {
            for (var i=1; i<=5; i++)
                $("#rec" + i).hide();
            var p = mydata[0];
            $("#page_cnt").html("/ " + p["page_cnt"] + " ");
            for (var i=1; i<mydata.length; i++){
                var v = mydata[i];
                $("#book" + i).html(v["book_name"]);
                $("#reason" + i).html(v["reason"]);
                $("#rec" + i).show();
            }
        },
        error: function (mydata) {
            for (var i=1; i<=5; i++)
                $("#rec" + i).hide();
        }
    });
}

function getQueryString(name) {
    var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if(r!=null)
        return  unescape(r[2]);
    return null;
}

function jump(page){
    
}