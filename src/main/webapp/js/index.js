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

    $.get("/News/callres",null,function (mydata) {
       var pt = $("#nres");
        pt.empty();
        $.each(mydata,function (i,v) {
            var tr = $("<tr>");
            var td = $("<td>");
            td.css({
                "width":"600px",
                "height":"50px",
                "align":"left",
                "valign":"middle"
            })
            var aiter = $("<a>");
            aiter.addClass("color_dark d_block bt_link");
            var text = "";
            if(v.type == "BOOK")
            {
                text = "<span class='scheme_color t_align_r m_right_10'>New Book :</span>"+v.title;
            }
            else {
                text = "<span class='scheme_color t_align_r m_right_10'>New E-Res :</span>"+v.title;
            }
            aiter.html(text);
            aiter.appendTo(td);
            td.appendTo(tr);
            tr.appendTo(pt);

        })
    });
});
