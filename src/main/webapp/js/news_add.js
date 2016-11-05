/**
 * Created by root on 16-11-5.
 */
$(function () {
   $("#news_add :button").click(function () {
       var title = $("#name").val();
       var summary = $("#shortcut").val();
       var content = $("#comments").val();
       if(title==""){
           alert("title can't be empty");
           return false;
       }
       if(summary==""){
           alert("summary can't be empty");
           return false;
       }
       if(content==""){
           alert("content can't be empty");
           return false
       }

       var json = {
           "title":title,
           "summary":summary,
           "content":content
       };
       $.post("/News/add", json, function (mydata) {
           mydata = $.parseJSON(mydata);
           if (!mydata) {
               alert("something wrong");
           }
           else {
               alert(mydata.message);
               $("#name").val("");
               $("#shortcut").val("");
               $("#comments").val("");
           }
       })
       return false;
   })
});