function timea(){
	var sj =new Date();
	var year=sj.getFullYear();
	var month=sj.getMonth()+1;
	var dath=sj.getDate();
	var hours=sj.getHours();
	var minute=sj.getMinutes();
	var second=sj.getSeconds();
	$(".timeaa").text(year+"-"+month+"-"+dath+"-"+hours+":"+minute+":"+second)
	$(".time1aa").text(year+"-"+month+"-"+dath)
}
setInterval(function(){
	timea();
},1000)