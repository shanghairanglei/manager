var myChart = echarts.init(document.getElementById('main1'));		
option = {
	tooltip: {
		trigger: 'item', 
		formatter: "{a} <br/>{b}: {c} ({d}%)",
		color:'#000',
		textStyle:{
			color:"black",
		}
	},
	legend: {  
		orient: 'vertical',  
		x: 'center',
		data:['工作效率'],
		textStyle:{   
			color:'#91DD6A',  
			fontSize:12   
		}
	},
	series: [
		{
			name:'访问来源',
			type:'pie',
			radius: ['50%', '65%'],
			avoidLabelOverlap: false,
			color:['#91DD6A','#e9e9e9'],
			label: {
				normal: {
					show: true,
					position: 'center',
					formatter:function (){
						var rate ='80%'
						return rate
					},
					textStyle:{
						fontSize:'20',
						color:'#91DD6A'
					}
				},
				emphasis: { 
					show: true,
					textStyle: {
						fontSize: '15',
						fontWeight: 'bold'
					}
				}
			},  
			labelLine: {
				normal: {
					show: false
				}
			},
			data:[
				{value:335, name:'工作效率'},
                {value:50, name:'未完成'},
			]
		}
	]
};
myChart.setOption(option);
var myChart = echarts.init(document.getElementById('main2'));		
option = {
	tooltip: {
		trigger: 'item', 
		formatter: "{a} <br/>{b}: {c} ({d}%)",
		color:'#000',
		textStyle:{
			color:"black",
		}
	},
	legend: {  
		orient: 'vertical',  
		x: 'center',
		data:['人力成本'],
		textStyle:{   
			color:'#59B9EC',  
			fontSize:12   
		}
	},
	series: [
		{
			name:'访问来源',
			type:'pie',
			radius: ['50%', '65%'],
			avoidLabelOverlap: false,
			color:['#59B9EC'],
			label: {
				normal: {
					show: true,
					position: 'center',
					formatter:function(){
                        var rate ='80%'
                        return rate
					},
					textStyle:{
						fontSize:'20',
						color:'#59B9EC'
					}
				},
				emphasis: { 
					show: true,
					textStyle: {
						fontSize: '15',
						fontWeight: 'bold'
					}
				}
			},  
			labelLine: {
				normal: {
					show: false
				}
			},
			data:[
				{value:335, name:'人力成本'},
			]
		}
	]
};
myChart.setOption(option);
var myChart = echarts.init(document.getElementById('main3'));		
option = {
	tooltip: {
		trigger: 'item', 
		formatter: "{a} <br/>{b}: {c} ({d}%)",
		color:'#000',
		textStyle:{
			color:"black",
		}
	},
	legend: {  
		orient: 'vertical',  
		x: 'center',
		data:['销售金额'],
		textStyle:{   
			color:'#FFD133',  
			fontSize:12   
		}
	},
	series: [
		{
			name:'访问来源',
			type:'pie',
			radius: ['50%', '65%'],
			avoidLabelOverlap: false,
			color:['#FFD133'],
			label: {
				normal: {
					show: true,
					position: 'center',
					formatter:function(){
                        var rate ='80%'
                        return rate
					},
					textStyle:{
						fontSize:'20',
						color:'#FFD133'
					}
				},
				emphasis: { 
					show: true,
					textStyle: {
						fontSize: '20',
						fontWeight: 'bold'
					}
				}
			},  
			labelLine: {
				normal: {
					show: false
				}
			},
			data:[
				{value:335, name:'销售金额'},
			]
		}
	]
};
myChart.setOption(option);