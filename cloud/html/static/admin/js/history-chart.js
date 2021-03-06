//历史数据图表
var xdata=['周一','周二','周三','周四','周五','周六','周日'];
var historychart=echarts.init(document.getElementById('historycharts'),'macarons');
var data = [["2000-06-05",116],["2000-06-06",129],["2000-06-07",135],["2000-06-08",86],["2000-06-09",73],["2000-06-10",85],
    ["2000-06-11",73],["2000-06-12",68],["2000-06-13",92],["2000-06-14",130],["2000-06-15",245],["2000-06-16",139],["2000-06-17",115],
    ["2000-06-18",111],["2000-06-19",309],["2000-06-20",206],["2000-06-21",1370],["2000-06-22",128],["2000-06-23",85],["2000-06-24",94],
    ["2000-06-25",71],["2000-06-26",106],["2000-06-27",84],["2000-06-28",93],["2000-06-29",85],["2000-06-30",73],["2000-07-01",83],
    ["2000-07-02",125],["2000-07-03",107],["2000-07-04",82],["2000-07-05",44],["2000-07-06",72],["2000-07-07",106],["2000-07-08",107],
    ["2000-07-09",66],["2000-07-10",91],["2000-07-11",92],["2000-07-12",113],["2000-07-13",107],["2000-07-14",131],["2000-07-15",111],
    ["2000-07-16",64],["2000-07-17",69],["2000-07-18",88],["2000-07-19",77],["2000-07-20",83],["2000-07-21",111],["2000-07-22",57],["2000-07-23",55],
    ["2000-07-24",60]];

var dateList;
console.log(dateList);
var valueList;

option = {
    // Make gradient line here
    visualMap: [{
        show: false,
        type: 'continuous',
        seriesIndex: 0,
        min: 0,
        max:1000, //图表最大值设置
        inRange:{
            color:['#FFFF11','#EE0000']
        },
    }],


    title: [{
        left: 'center',
        text: 'Gradient along the y axis'
    }],
    tooltip: {
        trigger: 'axis'
    },
    xAxis: [{
        data: dateList,
        axisLabel: {
            interval:14,

        },
        axisTick: {
            alignWithLabel: true
        }
    }
    ],
    dataZoom : [
        {
            type: 'slider',//图表下方的伸缩条
            show : false,  //是否显示
            realtime : true,  //
            start : 0,  //伸缩条开始位置（1-100），可以随时更改
            end : 1000,  //伸缩条结束位置（1-100），可以随时更改
        },
        {
            type: 'inside',  //鼠标滚轮
            realtime : false,
            //还有很多属性可以设置，详见文档
        }
    ],
    yAxis: [{
        splitLine: {show: true}
    }],
    grid: [
        {
            bottom: '8%',
            top: '8%',
            left:'8%',
            right:'8%'
        }

    ],
    series: [{
        type: 'line',
        showSymbol: false,
        data: valueList
    }, ]
};
;
historychart.setOption(option);
