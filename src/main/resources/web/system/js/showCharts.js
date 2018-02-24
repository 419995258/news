var showChartsAppmodule = angular.module('showChartsApp', []);

showChartsAppmodule.controller('showChartsController', function($scope, $http, $rootScope, $stateParams, $state) {
	
	////////////////////////////////////////////////////////判断当前页
	$scope.selectItems = [];


	/*//验证登录
	$http({
		method : "POST",
		url : "../adminC/ckLogined",
		//data : loginItems,
	}).success(function(data, status) {
		if (!data.success) {	
			location.href="002_systemLogin.html";
			}
	}).error(function(data, status) {
		$scope.tsText = "遭遇错误";
	});*/
	
	$scope.init = function() {
		if ($state.current.name == 'news') {
		};
		var queryTemp = [{'type':0,'name':'显示全部'},{'type':2,'name':'搜摘要'}];
		$scope.selectItems = queryTemp;
		$scope.qureyType = queryTemp[0];
        barLine()
	};

	$scope.init();

	// 重新配置大小
    window.onresize=function(){
        barLine()
    }
	

	function barLine() {
        // 基于准备好的dom，初始化echarts实例
		var barline = $("#barLine");
		// 设置宽度大小
        width = document.body.clientWidth
        barline.css("width",width);
        barline.css("height",450);

        echarts.dispose(barline.get(0))
        var myChart = echarts.init(barline.get(0));
        // 指定图表的配置项和数据
        var dataAxis = ['点', '击', '柱', '子', '或', '者', '两', '指', '在', '触', '屏', '上', '滑', '动', '能', '够', '自', '动', '缩', '放'];
        var data = [220, 182, 191, 234, 290, 330, 310, 123, 442, 321, 90, 149, 210, 122, 133, 334, 198, 123, 125, 220];
        var dataShadow = [];
        option = {
            title: {
                text: '特性示例：渐变色 阴影 点击缩放',
                subtext: 'Feature Sample: Gradient Color, Shadow, Click Zoom'
            },
            xAxis: {
                data: dataAxis,
                axisLabel: {
                    // inside: true,
                    textStyle: {
                        color: '#fff'
                    }
                },
                axisTick: {
                    show: false
                },
                axisLine: {
                    show: false
                },
                z: 10
            },
            yAxis: {
                axisLine: {
                    show: false
                },
                axisTick: {
                    show: false
                },
                axisLabel: {
                    textStyle: {
                        color: '#999'
                    }
                }
            },
            dataZoom: [
                {
                    type: 'inside'
                }
            ],
            series: [
                { // For shadow
                    type: 'bar',
                    itemStyle: {
                        normal: {color: 'rgba(0,0,0,0.05)'}
                    },
                    barGap:'-100%',
                    barCategoryGap:'40%',
                    data: dataShadow,
                    animation: false
                },
                {
                    type: 'bar',
                    itemStyle: {
                        normal: {
                            color: new echarts.graphic.LinearGradient(
                                0, 0, 0, 1,
                                [
                                    {offset: 0, color: '#83bff6'},
                                    {offset: 0.5, color: '#188df0'},
                                    {offset: 1, color: '#188df0'}
                                ]
                            )
                        },
                        emphasis: {
                            color: new echarts.graphic.LinearGradient(
                                0, 0, 0, 1,
                                [
                                    {offset: 0, color: '#2378f7'},
                                    {offset: 0.7, color: '#2378f7'},
                                    {offset: 1, color: '#83bff6'}
                                ]
                            )
                        }
                    },
                    data: data
                }
            ]
        };

        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
    }
	

    

	
	
	
	$rootScope.logout = function() {
		$http({
			method : "POST",
			url : "../adminC/logout",
		}).success(function(data, status) {
			if (data.success) {	
				location.href="002_systemLogin.html";
			}
		}).error(function(data, status) {
		});
	};

});