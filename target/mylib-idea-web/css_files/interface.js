$(document).ready(function () {
    addTab();
    run();
});
function addTab() {
    $("#details2")[0].getElementsByTagName("table")[0].id = "cxstarCd";
    //alert($("#details2")[0].getElementsByTagName("table")[0].id);
    $('<tr id="cdcontainer" style="display: none;" ><td class="td1" nowrap="nowrap" valign="top" width="15%">光盘数据库</td><td id=cd class="td1" align="left"></td></tr>').appendTo('#cxstarCd');
}

function run() {
    var xtruid = '202.117.122.61/bookcd';
    var website = '202.117.122.61/bookcd';
    var pinst = '18c4c1a6004ae50bd3';

    var htmlstr = $('#cxstarCd')[0];
    htmlstr = htmlstr.innerHTML.replace(/\t/g, '').replace(/ /g, '').replace(/"/g, '').replace(/\r/g, '').replace(/\n/g, '').toUpperCase();
    htmlstr = htmlstr.replace(/&NBSP;/g, '');
    //alert(htmlstr);

    //regExp = /<TR><TDCLASS=TD1ID=BOLDNOWRAP=VALIGN=TOPWIDTH=15%>出版发行<\/TD><TDCLASS=TD1ALIGN=LEFT><IMGSRC=.*?><AHREF=.*?>(.*?),(.*?)<\/A><\/TD><\/TR>/;
    //regExp.exec(htmlstr);
    //var publish = RegExp.$1;
    //var date = RegExp.$2;

    //regExp = /<TR><TDCLASS=TD1ID=BOLDNOWRAP=VALIGN=TOPWIDTH=15%>ISBN<\/TD><TDCLASS=TD1ALIGN=LEFT><IMGSRC=.*?><AHREF=.*?>(.*?):.*?<\/A><\/TD><\/TR>/;
    //regExp.exec(htmlstr);
    //var isbn = RegExp.$1;

    //regExp = /<TR><TDCLASS=TD1ID=BOLDNOWRAP=VALIGN=TOPWIDTH=15%>载体形态<\/TD><TDCLASS=TD1ALIGN=LEFT>(.*?)<\/TD><\/TR>/;
    //regExp.exec(htmlstr);
    //var cd = RegExp.$1;

    var publish = "";
    var date = "";
    var isbn = "";
    var title = "";
    var cd = "";
    var author = "";
    var publishanddate = "";
    var titleandauthor = "";
    $("#cxstarCd tr").each(function() {
        var td1 = $(this).children().eq(0).text();
        var td2 = $(this).children().eq(1).text();
        if (td1.indexOf("ISBN ") != -1)
            isbn = td2;
        else if (td1.indexOf("题名 ") != -1 && titleandauthor == "")
            titleandauthor = td2;
        else if (td1.indexOf("出版发行 ") != -1)
            publishanddate = td2;
        else if (td1.indexOf("载体形态 ") != -1)
            cd = td2;
    });
    titleandauthor = titleandauthor.replace(/<\/?[^>]+>/gi, '');
    //alert(titleandauthor);
    if (titleandauthor.indexOf('/') != -1) {
        title = titleandauthor.substring(0, titleandauthor.indexOf('/') - 1);
    }
    if (title.indexOf(':') != -1) {
        title = title.substring(0, title.indexOf(':') - 1);
    }
    if (title.indexOf(',') != -1) {
        title = title.substring(0, title.indexOf(','));
    }
    //alert(title);
    publishanddate = publishanddate.replace(/<\/?[^>]+>/gi, '');
    //alert(publishanddate);
    if (publishanddate.indexOf(',') != -1) {
        publish = publishanddate.substring(0, publishanddate.indexOf(','));
    }
    if (publish.indexOf(':') != -1) {
        publish = publish.substring(publish.indexOf(':') + 2, publish.length);
    }
    //alert(publish);
    //alert(publish + date + isbn + cd);

    var flag = 0;
    var headhtmlstr = $('#header')[0].getElementsByTagName("a")[0];
    headhtmlstr = headhtmlstr.innerHTML.replace(/\t/g, '').replace(/ /g, '').replace(/\r/g, '').replace(/\n/g, '').replace(/"/g, '');
    headhtmlstr = headhtmlstr.toUpperCase();
    headhtmlstr = headhtmlstr.replace(/&NBSP;/g, '');
    if (headhtmlstr.indexOf('退出') != -1)
        flag = 1;

    $('#header')[0].getElementsByTagName("a")[2].id = "MyInfo";
    var urlstr = $("#MyInfo").attr("href");

    if (isbn.indexOf(':') != -1) {
        isbn = isbn.substring(0, isbn.indexOf(':'));
    }
    else
        if (isbn.indexOf('光盘') != -1) {
            isbn = isbn.substring(0, isbn.indexOf('光盘'));
        }

    title = title.replace(/\t/g, '').replace(/ /g, '').replace(/\r/g, '').replace(/\n/g, '');
    title = title.replace(/ /g, '').replace(':', '');
    publish = publish.replace(/\t/g, '').replace(/ /g, '').replace(/\r/g, '').replace(/\n/g, '').replace(/&NBSP;/g, '');
    publish = publish.replace(/ /g, '').replace(':', '');
    isbn = isbn.replace(/\t/g, '').replace(/ /g, '').replace(/\r/g, '').replace(/\n/g, '').replace(/&NBSP;/g, '');
    isbn = isbn.replace(/ /g, '');
    isbn = isbn.substring(0, isbn.length - 1);
    
    title = title.replace(/<\/?[^>]+>/gi, '');
    publish = publish.replace(/<\/?[^>]+>/gi, '');
    author = author.replace(/<\/?[^>]+>/gi, '');
    date = date.replace(/[^\d\-]/g, '');
    author = escape(author);
    publish = escape(publish);
    title = escape(title);

    //alert(publish  + title + cd + isbn);

    var cdflag = 0;
    if ((cd.indexOf('光盘') != -1) || (cd.indexOf('CD') != -1) || (cd.indexOf('disc') != -1) || (cd.indexOf('VCD') != -1)) {
        cdflag = 1;
    }
    //alert(publish + date + isbn + cd + cdflag);

    if (flag) {
        var child;
        var xingming;
        var kaohao;
        var authr;
        //http://al.lib.xidian.edu.cn:80/F/3Y54I6E6M8SH85XG281JSYH1FKHLCDPPJYLX7BUTJUPKCRPT1B-46954?func=bor-info
        var iframecode = '<iframe id=\'external\' name=\'external\' style=\'display:none;\' src=\'' + urlstr + '\'></iframe>';
        //document.write(iframecode);
        debugger;//手工造成一个断点效果
//        document.onreadystatechange = function subSomething() {//当页面加载状态改变的时候执行这个方法
//            if (document.readyState == "complete") {//当页面加载状态为完全结束时进入你要做的操作。 
//                child = document.getElementById("external").contentWindow;
//                var childhtmls = child.document.getElementById("baseinfo").innerHTML;
//                childhtmls = childhtmls.replace(/\t/g, '').replace(/\r/g, '').replace(/\n/g, '').toUpperCase();
//                childhtmls = childhtmls.replace(/&NBSP;/g, '');
//                //alert(childhtmls);
//                var regExp = /条码号   <\/TD>   <TD CLASS="TD2" ALIGN="LEFT">     (.*?)   <\/TD>/;
//                regExp.exec(childhtmls);
//                kahao = RegExp.$1;
//                regExp = /姓名<\/TD>      <TD CLASS="TD2" ALIGN="LEFT">       (.*?)<\/TD>/;
//                regExp.exec(childhtmls);
//                xingming = RegExp.$1;
//                xingming = escape(xingming);
//                authr = kahao; //authr = kahao + '@' + xingming;
            if (cdflag == '1') {
                document.getElementById('cdcontainer').style.display = '';
                $('<a style=\'float: left;line-height: 25px;\' class=\'cxcd\' href=\'javascript:void(0)\'><img  style=\'float: left; padding-right: 5px;\' src=\'http://' + xtruid + '/format/Release/aspx/GPyx/img/disc.gif\'>随书光盘下载</a>').appendTo("#cd");
                $("#cd .cxcd")[0].onclick = function() {
                    return function(xtruid, website, publish, date, authr, pinst, urlstr) {
                        $.ajax({
                            url: urlstr,
                            success: function(data, code, state) {
                                var childhtmls = data;
                                childhtmls = childhtmls.replace(/\t/g, '').replace(/ /g,'').replace(/\r/g, '').replace(/\n/g, '').toUpperCase();
                                childhtmls = childhtmls.replace(/&NBSP;/g, '');
                                //alert(childhtmls);
                                //var reg = />      条码号   <\/TD>   <TD  CLASS=TD2 ALIGN=LEFT>     (.*?)   <\/TD>/;
                                var regExp = /条码号<\/TD><TDCLASS=TD2ALIGN=LEFT>(.*?)<\/TD>/;
                                regExp.exec(childhtmls);
                                kahao = RegExp.$1;
                                //regExp = /姓名<\/TD>      <TD CLASS="TD2" ALIGN="LEFT">       (.*?)<\/TD>/;
                                //regExp.exec(childhtmls);
                                //ingming = RegExp.$1;
                                //xingming = escape(xingming);
                                authr = kahao;

                                var url = 'http://' + xtruid + '/format/release/aspx/SysCDResult.aspx?isbn=' + isbn + '&website=' + website + '&type=i&localflag=1&decode=UTF8&author=&title=' + title + '&publish=' + publish + '&date=&authr=' + authr + '&pinst=' + pinst;
                                window.open(url);
                            },
                            error: function(data) {
                                alert("用户信息加载失败");
                            }
                        })
                    } (xtruid, website, publish, date, authr, pinst, urlstr)
                };
                //http://' + xtruid + '/format/release/aspx/SysCDResult.aspx?isbn=' + isbn + '&website=' + website + '&type=i&localflag=1&decode=UTF8&author=&title=&publish=' + publish + '&date=' + date + '&authr=' + authr + '&pinst=' + pinst + '
                //                if (isbn) {
                //                    var s = document.createElement('script');
                //                    s.src = 'http://' + xtruid + '/format/release/aspx/ServerMethodCaller.ashx?dll=extcom406.dll&m=CalOpacEbookDataface&srchType=i&word=' + isbn + '&dmcode=1987051001&charset=UTF-8&idcount=0&cdxsflag=0&authr=' + authr + '&pinst=' + pinst + '&listflag=0&rootappruid=' + pinst + '&imgwi=120&locf=1&tagsflag=0&auintroflag=2&centerurl=';
                //                    s.type = 'text/javascript';
                //                    document.body.appendChild(s);
                //                }
//            }
        }
    }
    else {
        if (cdflag == '1') {
            document.getElementById('cdcontainer').style.display = '';
            document.getElementById('cd').innerHTML = '<a style=\'float: left;line-height: 25px;\' class=\'cxcd\' target=\'_blank\' href=\'http://' + xtruid + '/format/release/aspx/SysCDResult.aspx?isbn=' + isbn + '&website=' + website + '&type=i&localflag=1&decode=UTF8&author=&title=' + title + '&publish=' + publish + '&date=&authr=&pinst=' + pinst + '\'><img  style=\'float: left; padding-right: 5px;\' src=\'http://' + xtruid + '/format/Release/aspx/GPyx/img/disc.gif\'>随书光盘下载</a>';
        }
        
        if (isbn) {
            var s = document.createElement('script');
            s.src = 'http://' + xtruid + '/format/release/aspx/ServerMethodCaller.ashx?dll=extcom406.dll&m=CalOpacEbookDataface&srchType=i&word=' + isbn + '&dmcode=1987051001&charset=UTF-8&idcount=0&cdxsflag=0&pinst=' + pinst + '&listflag=0&rootappruid=' + pinst + '&imgwi=120&locf=1&tagsflag=0&auintroflag=2&centerurl=';
            s.type = 'text/javascript';
            document.body.appendChild(s);
        }
    }
}

function GetContents(cflag) {
    var xtruid = '202.117.122.61/bookcd';
    var website = '202.117.122.61/bookcd';
    var pinst = '18c4c1a6004ae50bd3';
    var htmlstr = document.documentElement.innerHTML.replace(/\t/g, '').replace(/\r/g, '').replace(/\n/g, '').toUpperCase();
    regExp = /ISBN<\/SPAN><\/TD><TD>([\S\s]*?)<\/TD>/;
    regExp.exec(htmlstr);
    var isbn = RegExp.$1;

    if (isbn.indexOf('#') != -1) {
        isbn = isbn.substring(0, isbn.indexOf('#'));
    } else if (isbn.indexOf('光盘') != -1) {
        isbn = isbn.substring(0, isbn.indexOf('光盘'));
    }
    if (isbn) {
        var s = document.createElement('script');
        s.src = 'http://' + xtruid + '/format/release/aspx/ServerMethodCaller.ashx?dll=extcom406.dll&m=CalOpacEbookDataface&srchType=i&word=' + isbn + '&dmcode=1987051001&charset=UTF-8&idcount=0&cdxsflag=0&pinst=' + pinst + '&listflag=0&rootappruid=' + pinst + '&imgwi=120&locf=1&tagsflag=0&auintroflag=2&centerurl=&con=' + cflag;
        s.type = 'text/javascript';
        document.body.appendChild(s);
    }
}

////返回前一页的
function checkblock(id) {
    if (id == 0)
    { id = 'dirblock'; }
    else if (id == 1)
    { id = 'dirnone'; }
    else if (id == 2)
    { id = 'aublock'; }
    else if (id == 3)
    { id = 'aunone'; }
    else if (id == 4)
    { id = 'introblock'; }
    else if (id == 5)
    { id = 'intronone'; }

    var id2;
    if (id.indexOf('block') != -1) {
        id2 = id.replace('block', 'none');
        document.getElementById(id).style.display = 'none';
        document.getElementById(id2).style.display = 'block';
    }
    else {
        id2 = id.replace('none', 'block');
        document.getElementById(id).style.display = 'none';
        document.getElementById(id2).style.display = 'block';
    }
}