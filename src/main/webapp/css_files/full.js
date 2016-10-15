if(typeof lkbhost =='undefined') lkbhost="";
function libtool(json){
  fmjson['toc']='';
     var lbauthor=json.result.authorIntroduction;
     var lbsummary=json.result.summary;
     var lbcatalog=json.result.catalog;
     if(lbsummary.length>5)
         fmjson['toc']+='<fieldset><legend>'+I18N["hint"]["digest"]+'</legend>'+lbsummary+'</fieldset>';
     if(lbauthor.length>5)
	 fmjson['toc']+='<fieldset><legend>'+I18N["hint"]["authorbib"]+'</legend>'+lbauthor+'</fieldset>';
     if(lbcatalog.length>5)
	 fmjson['toc']+='<td class=td1 valign=top><fieldset><legend>'+I18N["hint"]["toc"]+'</legend>'+lbcatalog;
		 
     if(fmjson['toc'].length>10)
     { 
     g('fmt_toc').style.display='';
     fmjson['toc']='<table width="100%" border="0" cellspacing="2"><tr><td class=td1 width=55% valign=top>'+fmjson['toc']+'</table>';
     } 
}
function douban(json){
  var dbcon='';
  if(json.entry.length>0){
	  for (var i = 0; i < json.entry.length; i++) {
		 var entry=json.entry[i];
         var dbauthor=entry.author.name.$t;
		 var dblink=entry.link[1]["@href"];
		 var dbdate=entry.updated.$t;var tmp=dbdate.replace("T"," "); dbdate=tmp.replace(/\+.*/,"");
		 var dbtitle=entry.title.$t;
		 var dbreview=entry.summary.$t;
         if(i==5){dbcon+="<div id=dbhide style='display:none'>";}
         dbcon+="<div style='margin:7px 5px 7px 5px;padding:0'><a target=_blank href="+dblink+">"+dbtitle+"</a> &nbsp <span style='margin-left:35px'>"+dbauthor+" <i>("+dbdate+")</i></span><p style='margin:5px 0 6px 0'>"+dbreview+"</p></div>";
     }
     if(i>5){dbcon+="</div><div style='float:right;cursor:pointer' onclick=\"g('dbhide').style.display=this.innerHTML=='["+I18N["hint"]["collapse"]+"]'?'none':'';this.innerHTML=this.innerHTML=='["+I18N["hint"]["collapse"]+"]'?'["+I18N["hint"]["expand"]+"]':'["+I18N["hint"]["collapse"]+"]';\">["+I18N["hint"]["expand"]+"]</div>"}
     g("douban").innerHTML="<fieldset style='-moz-border-radius:8px;'><legend><b>"+I18N["hint"]["douban"]+"</b></legend>"+dbcon+"</fieldset>";
 }
}

function amazon(json){
  var dbcon='';
  if(json.reviews.length>1){
	  for (var i = 0; i < json.reviews.length-1; i++) {
		 var entry=json.reviews[i];
         var aid=entry["asin"];
		 var rating=entry.rating;
		 var author=entry.author;
		 var summary=entry.summary;
		 var date=entry.date;
		 var content=entry.content;
         var tmp=content.replace(/<br \/><br \/>/g,"<br>");
         tmp=tmp.replace(/^\s*<br \/>/,"");
         content=tmp.substr(0,300)+"<span id='amazon"+i+"' style='display:none'>"+tmp.substr(300)+"</span><span style='cursor:pointer' onclick=\"document.getElementById('amazon"+i+"').style.display=this.innerHTML=='... ["+I18N["hint"]["expand"]+"]'?'':'none';this.innerHTML=this.innerHTML=='... ["+I18N["hint"]["expand"]+"]'?' ["+I18N["hint"]["collapse"]+"]':'... ["+I18N["hint"]["expand"]+"]';\">... ["+I18N["hint"]["expand"]+"]</span>";
         dbcon+="<div style='margin:7px 5px 7px 5px;padding:0'><a target=_blank href=http://www.amazon.com/review/product/"+aid+"#CustomerPopover|id|"+author+"><b>"+summary+"</b></a> &nbsp <span style='margin-left:35px'><b>"+I18N["hint"]["stars"]+":"+rating+"/5</b> <i>("+date+")</i></span><p style='margin:5px 0 9px 0'>"+content+"</p></div>";
     }
     g("amazon").innerHTML="<fieldset style='-moz-border-radius:8px;'><legend><b>"+I18N["hint"]["amazon"]+"</b></legend>"+dbcon+"</fieldset>";
 }
}
function gettoc(id){
    var url=lkbhost+"/cgi-bin/alkb.cgi?t=0&id="+id;
	var script = document.createElement('script');
	script.setAttribute('src', url);
	document.documentElement.firstChild.appendChild(script);
}

function covers(json){
}

function sfxlink(issn){
     var src="/covers/nocover.jpg";
     src="http://202.112.150.126/index.php?client=aleph&isbn="+issn+"/cover";
     g("bigcover").innerHTML="<img id=bigcover src="+src+">";
    if(typeof lkbhost !='undefined' && !flag_sfx)return;
    var request = new XMLRequst("/cgi-bin/asfx.cgi?full=1&issns="+issn,"get").createXMLRequst();
    request.onreadystatechange = function(){
        if (request.readyState == 4){
            if (request.status == 200){
                if(request.responseText.length>10){
                    g('sfxdiv').innerHTML=request.responseText;
                    g('sfxtitle').style.display='';
                }
            }
        }
    }
    request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    request.send(null);
}

function getduxiu(isbn,title,author){//contributed by BNU
    var url="/cgi-bin/duxiu_xml.cgi";
    var urlparam="isbn="+isbn+"&title="+encodeURIComponent(title)+"&author="+encodeURIComponent(author);
    var txt1=" ";
    var request1 = new XMLRequst(url,"post",true,"text/xml").createXMLRequst();
    request1.onreadystatechange = function(){
     if (request1.readyState == 4){
      if (request1.status == 200){
       try
       {
        urlml=request1.responseXML.documentElement.getElementsByTagName("mulureader")[0].firstChild.nodeValue;
        urlqw=request1.responseXML.documentElement.getElementsByTagName("qwreader")[0];
        var urlmlhead=urlml.substr(0,4);
        if (urlmlhead == "http") 
         {
           txt1="<a href="+urlml+" target=_blank><img border=\"0\" src="+icon_path+"duxiu_x2616.jpg>目录</a>";
           if (urlqw.hasChildNodes())
           {
            txt1="<a href="+urlml+" target=_blank><img border=\"0\" src="+icon_path+"duxiu_x2616.jpg>全文</a>";
           }
           g('tab_duxiu').innerHTML=txt1;
         }
       }
       catch(err)
       {
       }
      }
     }
    };
    request1.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    request1.send(urlparam);
}

function getshusheng(isbn,title,author){//contributed by BNU
    var url="/cgi-bin/shusheng_html.cgi?isbn="+isbn+"&title="+encodeURIComponent(title)+"&author="+encodeURIComponent(author);
    var txt1=" ";
// alert(url);
    var request5 = new XMLRequst(url,"get",true,"text/plain").createXMLRequst();
    request5.onreadystatechange = function(){
     if (request5.readyState == 4){
      if (request5.status == 200){
       try
       {
        urlqw=request5.responseText;
        var urlqwhead=urlqw.substr(0,4);
        if (urlqwhead == "http") 
         {
           txt1="<a href="+urlqw+" target=_blank><img border=\"0\" src="+icon_path+"shusheng_x2616.jpg>全文</a>";
           g('tab_shush').innerHTML=txt1;
         }
        }
       catch(err)
       { }
      }
     }
    };
    request5.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    request5.send(null);
}
