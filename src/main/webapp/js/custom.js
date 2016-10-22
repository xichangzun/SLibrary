/**
 * LavaLamp - A menu plugin for jQuery with cool hover effects.
 * @requires jQuery v1.1.3.1 or above
 *
 * http://gmarwaha.com/blog/?p=7
 *
 * Copyright (c) 2007 Ganeshji Marwaha (gmarwaha.com)
 * Dual licensed under the MIT and GPL licenses:
 * http://www.opensource.org/licenses/mit-license.php
 * http://www.gnu.org/licenses/gpl.html
 *
 * Version: 0.2.0
 * Requires Jquery 1.2.1 from version 0.2.0 onwards. 
 * For jquery 1.1.x, use version 0.1.0 of lavalamp
 */

	/* ---------------------------------------------------------------------- */
	/*	Content Tabs
	/* ---------------------------------------------------------------------- */
$(function(){
    $(".zimu a").click(function(){
       $(".zimu a").css("color","#666");
       $(".zimu a").css("background-color","#fff");
       $(this).css("background-color","#af2125");
       $(this).css("color","#fff");

    });

    $(".cor a").click(function(){
       $(this).siblings().css("color","#af2125");
       $(this).siblings().css("background-color","#f4f4f4");
       $(this).css("background-color","#af2125");
       $(this).css("color","#fff");

    });
});

	(function() {
		
		if($('.content-tabs').length || $('.aside-tabs').length|| $('.content1-tabs').length.length || $('.aside1-tabs')) {
		
			var $contentTabs  = $('.content-tabs'),
			$contentTabs1  = $('.content1-tabs'),
			$asideTabs	  = $('.aside-tabs');
			$asideTabs1	  = $('.aside1-tabs');

			$.fn.tabs = function($obj) {
				$tabsNavLis = $obj.find('.tabs-nav').children('li'),
				$tabContent = $obj.find('.tab-content');

				$tabsNavLis.first().stop().addClass('active').show();
				$tabContent.first().stop().show();

				$obj.find('ul.tabs-nav li').on('hover', function(e) {
					var $this = $(this);
                    
					$obj.find('ul.tabs-nav li').removeClass('active');
					$this.addClass('active');
					$obj.find('.tab-content').hide(); //Hide all tab content
					$($this.find('a').attr('href')).show().fadeIn();
				});
				
				

				
				
			}

			$contentTabs.tabs($contentTabs);
			$contentTabs1.tabs($contentTabs1);
			$asideTabs.tabs($asideTabs);
			$asideTabs1.tabs($asideTabs1);
		}
		
	})();
	
	
	(function() {
		
		if($('.aside1-tabs')) {
		
			var $asideTabs1	  = $('.aside1-tabs');

			$.fn.tabs = function($obj) {
				$tabsNavLis = $obj.find('.tabs1-nav').children('li'),
				$tabContent = $obj.find('.tab-content');

				$tabsNavLis.first().stop().addClass('active').show();
				$tabContent.first().stop().show();

				$obj.find('ul.tabs1-nav li').on('hover', function(e) {
					var $this = $(this);

					$obj.find('ul.tabs1-nav li').removeClass('active');
					$this.addClass('active');
					$obj.find('.tab-content').hide(); //Hide all tab content
					$($this.find('a').attr('href')).stop().show();

					e.preventDefault();
				});
			}

			$asideTabs1.tabs($asideTabs1);
		}
		
	})();

	/* end Content Tabs */
	/* 鐒︾偣鍥� */
	
$(function(){
	$('.daimabiji').flexslider({
		animation: 'slide',
		pauseOnHover: true
	});

});


$(function(){ 
$(".input_select").click(function(){ 
var ul = $("#dropdown ul"); 
if(ul.css("display")=="none"){ 
ul.slideDown("fast"); 
}else{ 
ul.slideUp("fast"); 
} 
}); 
$("#dropdown ul li a").click(function(){ 
var txt = $(this).text(); 
$(".input_select").val(txt); 
var value = $(this).attr("rel"); 
$("#dropdown ul").hide(); 
});
$(".tabs1-nav li a").hover(function(){ 
var txt = $("#dropdown ul li:first a").text(); 
$(".input_select").val(txt); 
var value = $("#dropdown ul li:first a").attr("rel"); 
$("#dropdown ul").hide(); 
}); 

$('.sidebar dd a').click(function(){
    $('.sidebar dd a').css('background-color','#efefef');
	$('.sidebar dd a').css('color','#333');
	$(this).css('background-color','#ed8083');
	$(this).css('color','#fff');
});



});



$(function(){
    $('#holder').show();
	$('#imgBox').simple_slider({
		'leftID': 'leftNav',
		'rightID': 'rightNav',
		'display': 8
	});	
});


jQuery(".slideTxtBox").slide({effect:"fold",autoPlay:true,easing:"easeOutCirc",delayTime:200});

