$(function(){
	
	var con1_top = $('.articles').offset().top;
	var con2_top = $('.articles1').offset().top;
	var con3_top = $('.articles2').offset().top;
	var topArr = [con1_top,con2_top,con3_top];
	var arr = $(".nav-team>li");
	for(var i = 0; i < arr.length; i++){
		var index = $(".nav-team li").eq(i);
		(function(arg){         
			index.click(function(){
			$('html,body').animate({scrollTop:topArr[arg]},500);	
		   })  
	   })(i);
	}
	$(".nav-team li").click(function(){
        cur = $(this).index();
        $(this).addClass("activea").siblings().removeClass("activea");
    });
})