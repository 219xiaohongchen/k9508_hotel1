 var myChart = echarts.init(document.getElementById('main'));
    //数据接口../json/data01.json文件  访问服务器端的数据的路径
    $.get('roomSale/loadPriceByRoomNum').done(function (data) {
        myChart.setOption({
            title: {
                text: '房间盈利表'
            },
            tooltip: {},
            toolbox: {  //工具
                feature: {
                    dataView: {}, //数据视图按钮
                    saveAsImage: {
                        pixelRatio: 5  //保存为图片
                    },
                    restore: {},
                    magicType : {show: true, type: ['line', 'bar']}
                }
            },
            legend: {
                data:['盈利']
            },
            xAxis: {
                data: data.roomNumList
            },
            yAxis: {},
            series: [{
                name: '盈利',
                type: 'bar',
                data: data.salePriceList
            }]
        });
    });
