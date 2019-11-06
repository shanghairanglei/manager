$(function(){
	var con2_top = $('.top2').offset().top;
	var con3_top = $('.top3').offset().top;
	var con4_top = $('.top4').offset().top;
	var con5_top = $('.top5').offset().top;
    var con6_top = $('.top6').offset().top;
	var topArr = [con2_top,con3_top,con4_top,con5_top,con6_top];
	var arr = $(".data-nav>li");
	for(var i = 0; i < arr.length; i++){
		var index = $(".data-nav li").eq(i);
		(function(arg){
			index.click(function(){
			$('html,body').animate({scrollTop:topArr[arg]},500);
		   })
	   })(i);
	}
	$(".data-nav li").click(function(){
        cur = $(this).index();
        $(this).addClass("activeb").siblings().removeClass("activeb");
    });
})
