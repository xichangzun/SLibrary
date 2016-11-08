/**
 * Created by root on 16-11-7.
 */
$(function () {
    $.get("/News/callback",null,function (mydata) {
        var pdiv = $("#news");
        pdiv.empty();
        $.each(mydata,function (k,v) {
            var diviter = $("<div>");
            diviter.addClass("clearfix");
            diviter.addClass("m_bottom_15");
            var aiter = $("<a>");
            aiter.addClass("color_dark");
            aiter.addClass("d_block");
            aiter.addClass("bt_link");
            aiter.html(v.title);
            aiter.attr('href','/News/KnowMore?index='+v.id);
            aiter.appendTo(diviter);
            var piter = $("<p>");
            piter.html(v.summary);
            piter.appendTo(diviter);
            diviter.appendTo(pdiv);
            var hiter =$("<hr>");
            hiter.addClass("m_bottom_15");
            hiter.appendTo(pdiv);
        })
    });
});
