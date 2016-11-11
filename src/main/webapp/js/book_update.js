/**
 * Created by root on 16-11-9.
 */


function  iterator( b ) {
    var div = $("<div>");
    //div.addClass("product_item full_width list_type hit m_left_0 m_right_0");
    div.css({
        "width":"710px",
        "margin-top":"30px",
        "padding-left":"25px"
    });
    var aiter = $("<a>");
    //aiter.addClass("d_block f_left relative pp_wrap m_right_30 m_xs_right_25");
    aiter.attr('href','#');
    var img = $("<img>");
    img.css({
        "height":"130px",
        "width":"130px"
    });
    img.addClass("tr_all_hover");
    img.attr('src',b.cover);
    img.onload = function () {
        img.appendTo(aiter);
        aiter.appendTo(div);
    }

    // var cdf = $("<div>");
    // cdf.addClass("f_left p_list_description f_sm_none w_sm_full m_xs_bottom_10");
    // var h3 = $("<h3>");
    // h3.html(b.title);
    // h3.appendTo(cdf);
    // cdf.append("<br>");
    // var hr = $("<hr>");
    // hr.width(350);
    // hr.addClass("m_bottom_10");
    // cdf.append(hr);
    // var p = $("<p>");
    // p.addClass("d_sm_none d_xs_block");
    // cdf.append(p);
    // var ul = $("<ul>");
    // var author = $("<li>");
    // author.html("Author:"+b.author);
    // var press = $("<li>");
    // press.html("Publisher:"+b.press);
    // var call_no = $("<li>");
    // call_no.html("CallNumber:"+b.call_no);
    // var pub_year = $("<li>");
    // pub_year.html("Publication Year:"+b.pub_year);
    // ul.append(author).append(press).append(call_no).append(pub_year);
    // cdf.append(ul);
    // div.append(cdf);
    // var cds = $("<div>");
    // cds.css({
    //     "margin":"100px auto"
    // })
    // cds.addClass("f_right f_sm_none t_align_r t_sm_align_l");
    // var button1 = $("<button>");
    // button1.addClass("button_type_4 bg_scheme_color r_corners tr_all_hover color_light mw_0 m_bottom_15 m_sm_bottom_0 d_sm_inline_middle");
    // button1.html("Modify");
    // var button2 = $("<button>");
    // button2.addClass("button_type_4 bg_scheme_color r_corners tr_all_hover color_light mw_0 m_bottom_15 m_sm_bottom_0 d_sm_inline_middle");
    // button2.html("Delete");
    // cds.append(button1).append(button2);
    // div.append(cds);
    return div;
}

$(function () {
    var pdiv = $(".products_container");
    pdiv.empty();

    $("#lookup").click(function () {
        // var type = $("[name = 'type']").val();
        // var keyword = $(":input[name = 'keyword']").val();
        // if(keyword == ""){
        //     alert("keyword could not be empty");
        // }
        // else {
        //     var json = {
        //         "type":type,
        //         "keyword":keyword
        //     };
        //     $.post("/Search/query",json,function (e) {
        //         $.each(e,function (i,v) {
        //             pdiv.append(iterator(v));
        //         })
        //     },"json")
        // }
        var  b = {
            "cover":"pictures/default.jpg",
            "title":"asdad",
            "author":"dasdasd",
            "press":"dasdas",
            "call_no":"ps_301",
            "pub_year":"2016"
        };
        iterator(b).appendTo(pdiv);
        return false;
    });


});
