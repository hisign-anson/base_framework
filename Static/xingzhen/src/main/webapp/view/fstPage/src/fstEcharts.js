// 使用
require(
    [
        'echarts',
        //'echarts/chart/bar' // 使用柱状图就加载bar模块，按需加载
    ],
    function (ec) {
        console.log(0);
        // 基于准备好的dom，初始化echarts图表
        document.ready=function(){
            console.log(1);
            var myChart = echarts.init(document.getElementById('kaizhiqkT'));

            var colors = ["#4C8FED", "#38C9DF", "#EFAB42", "#FFCD1E", "#91C53A", "#b5f150", "#CB83E5"];

            option = {
                title: {
                    text: '多 Y 轴示例',
                    x: 'center',
                    align: 'right'
                },
                color: colors,

                tooltip: {
                    trigger: 'axis'
                },
                grid: {
                    right: '20%'
                },
                toolbox: {
                    feature: {
                        dataView: {show: true, readOnly: false},
                        restore: {show: true},
                        saveAsImage: {show: true}
                    }
                },
                legend: {
                    bottom: 0,
                    data:['蒸发量','降水量']
                },
                calculable : true,

                dataZoom: [
                    {
                        type: 'inside',
                        zoomLock: true,//只能平移，不能缩放
                        start: 0,
                        end: 40
                    },
                    {
                        show: false,//显示下面的滚动区域
                        start: 0,
                        end: 100
                    },
                    {
                        show: false,//显示左边的滚动区域
                        yAxisIndex: 0,
                        filterMode: 'empty',
                        width: 10,
                        height: '80%',
                        showDataShadow: false,
                        left: '93%'
                    }
                ],
                xAxis: [
                    {
                        type: 'category',
                        axisTick: {
                            alignWithLabel: true
                        },
                        data: ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月']
                    }
                ],
                yAxis: [
                    {
                        type: 'value',
                        name: '蒸发量',
                        axisLabel: {
                            formatter: '{value} ml'
                        },
                        splitLine:{
                            show:false
                        }
                    },
                    {
                        type: 'value',
                        name: '降水量',
                        axisLabel: {
                            formatter: '{value} ml'
                        },
                        splitLine:{
                            show:false
                        }
                    }
                ],
                series: [
                    {
                        name:'蒸发量',
                        type:'bar',
                        label:{
                            normal:{
                                show:true,
                                position:'top',
                                textStyle:{
                                    fontSize:12,
                                    color:"green"
                                }
                            }
                        },
                        data:[0, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6, 162.2, 32.6, 20.0, 6.4, 3.3]
                    },
                    {
                        name:'降水量',
                        type:'bar',
                        label:{
                            normal:{
                                show:true,
                                position:'top',
                                textStyle:{
                                    fontSize:12,
                                    color:"green"
                                }
                            }
                        },
                        yAxisIndex: 1,
                        data:[2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 175.6, 182.2, 48.7, 18.8, 6.0, 2.3]
                    }
                ]
            };

            // 使用刚指定的配置项和数据显示图表。
            myChart.setOption(option);
        };

    }
);
