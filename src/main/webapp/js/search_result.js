/**
 * Created by root on 16-11-13.
 */
$(function () {
    var cur_page = $("#cur_page").html();
    var page_cnt = $("#page_cnt").html();
    var pre_page = $("#pre_page");
    var tail_page =$("#tail_page");
   if(cur_page-1<1){
       pre_page.attr('href','#');
   }
   else {
       var index = Number(cur_page)-1;
       pre_page.attr('href','/Search/execute?page_index='+index)
   }
   if(cur_page+1>page_cnt){
       tail_page.attr('href','#');
   }
   else {
       var index = Number(cur_page)+1;
       tail_page.attr('href','/Search/execute?page_index='+index)
   }

   $("#jump_page").click(function () {
       var page = $("#page").val();
       if(page<=page_cnt&&page>0){
           window.location.href = '/Search/execute?page_index='+page;
       }
       else {
           alert('page number outrange');
       }
   })

});