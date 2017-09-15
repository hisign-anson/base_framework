importing('currentDate');
define(['underscore',
         'echarts',
        'text!/view/fstPage/tpl/fstPage.html',
         'text!/view/fstPage/tpl/newList.html',
         'text!/view/fstPage/tpl/noticeList.html',
         'text!/view/fstPage/tpl/ruleList.html',
         'text!/view/fstPage/tpl/tableDownList.html',
         'text!/view/fstPage/tpl/daibanList.html',
        'text!/view/fstPage/tpl/noticeOne.html',
         'text!/view/fstPage/tpl/ruleOne.html',
        '../dat/fstPage.js'],function(_,ec,fstPageTpl,newListTpl,noticeListTpl,ruleListTpl,tableDownListTpl,daibanListTpl,noticeOneTpl,ruleOneTpl,fstPageAjax){
	
	return {
        showFstPage:function(){
            _self = this;
            $("#main-div").empty().html(_.template(fstPageTpl));
            //显示待办
            _self.showDaibanList();
            //显示新闻
            _self.queryNewList();
            //显示经费开支情况图
            _self.getExpenseStatData();
            //切换个人经费开支情况图月度季度年度
            _self.changeGetExpenseStatData();
            //切换单位经费开支情况图月度季度年度
            _self.unitGetExpenseStatData();
            //显示个人物品申领情况图
            _self.getGoodsStatData();
            //切换个人物品申领情况图月度季度年度
            _self.changeGetGoodsStatData();
            //切换单位物品申领情况图月度季度年度
            _self.unitGetGoodsStatData();
            //显示个人用车情况图
            _self.getCarsStatData();
            //切换个人用车情况图月度季度年度
            _self.changeGetCarsStatData();
            //切换单位用车情况图月度季度年度
            _self.unitGetCarsStatData();

            //显示各处项目开支情况图
            if(top.opsMap && top.opsMap.get('office_exes') && top.opsMap.get('office_exes') == 1){_self.getDevelopStat();}
            //显示各处物品申领情况图
            if(top.opsMap && top.opsMap.get('office_item') && top.opsMap.get('office_item') == 1){_self.getGoodsStat();}
            //显示各处用车情况图
            if(top.opsMap && top.opsMap.get('office_car') && top.opsMap.get('office_car') == 1){_self.getCarsStat();}

            //切换处室项目开支情况图月度季度年度
            _self.officeExpenseStatData();
            //切换处室物品申领情况图月度季度年度
            _self.officeGoodsStatData();
            //切换处室用车情况图月度季度年度
            _self.officeCarStatData();

            //点击更多跳转到当月最新发布更多信息页面
            _self.newsMore();
            //点击更多跳转到通知公告更多信息页面
            _self.noticesMore();
            //点击更多跳转到规章制度更多信息页面
            _self.rulesMore();
            //点击更多跳转到表格下载更多信息页面
            _self.tablesMore();

            //点击当月最新发布每列
            _self.newsOne();
            //点击通知公告每列
            _self.noticeOne();
            //点击规章制度每列
            _self.ruleOne();
            //点击表格下载每列
            //_self.tabledowmOne();
            //右边固定条点击事件
            _self.projectApplyClick();//财务->开支申请快捷入口
            _self.carApplyClick();//车辆->用车申请快捷入口
            _self.itemApplyClick();//物品->物品申领快捷入口
            $("[data-toggle='fixed-tooltip']").hover(function(){
                var content = $(this).attr("tooltip-title");
                var div = '<div class="tooltip-new">'+ content +'</div>';
                $(this).append(div);
            },function(){
                $(this).find(".tooltip-new").remove();
            });

//            $('[data-toggle="tooltip"]').tooltip();
            $('#root-menu', window.parent.document).find('li').each(function(i,item){
                if('C0101'== $(item).attr("page-no")){
                    $("#projectApplyClick").css('display','block');
                }
                if('0101'== $(item).attr("page-no")){
                    $("#carApplyClick").css('display','block');
                }
                if('itemApply'== $(item).attr("page-no")){
                    $("#itemApplyClick").css('display','block');
                }
                
            });
        },
        //切换个人经费开支情况图月度季度年度
        changeGetExpenseStatData:function(){
            $("#expenseQuest").on("click","li",function(){
                $(this).addClass("active").siblings(".active").removeClass("active");
                if($(this).index()==0){
                    var dateType=5;
                    sessionStorage['expenseDateType']='expenseDateType5';//expenseDateType5表示经费月度
                    if(sessionStorage['expense']=='expense11'||!sessionStorage['expense']){
                        _self.getExpenseStatData(dateType);
                    }else if(sessionStorage['expense']=='expense22'){
                        _self.getExpenseStatDataUnit(dateType);
                    }
                }else if($(this).index()==1){
                    var dateType=6;
                    sessionStorage['expenseDateType']='expenseDateType6';//expenseDateType5表示经费季度
                    if(sessionStorage['expense']=='expense11'||!sessionStorage['expense']){
                        _self.getExpenseStatData(dateType);
                    }else if(sessionStorage['expense']=='expense22'){
                        _self.getExpenseStatDataUnit(dateType);
                    }
                }else{
                    var dateType=7;
                    sessionStorage['expenseDateType']='expenseDateType7';//expenseDateType5表示经费年度
                    if(sessionStorage['expense']=='expense11'||!sessionStorage['expense']){
                        _self.getExpenseStatData(dateType);
                    }else if(sessionStorage['expense']=='expense22'){
                        _self.getExpenseStatDataUnit(dateType);
                    }
                }
            });
        },
        //切换单位经费开支情况图月度季度年度
        unitGetExpenseStatData:function(){
            $("#unitExpenseQuest").on("click","button",function(){
                $(this).addClass("btn-primary").siblings(".btn-primary").removeClass("btn-primary");
                var dateType=sessionStorage['expenseDateType']=='expenseDateType5'?5:sessionStorage['expenseDateType']=='expenseDateType6'?6:sessionStorage['expenseDateType']=='expenseDateType7'?7:"";
                if($(this).index()==0){
                    sessionStorage['expense']='expense11';//11表示个人
                    _self.getExpenseStatData(dateType);
                }else{
                    sessionStorage['expense']='expense22';//22表示单位
                    _self.getExpenseStatDataUnit(dateType);
                }
            });
        },
        //切换个人物品申领情况图月度季度年度
        changeGetGoodsStatData:function(){
            $("#goodsQuest").on("click","li",function(){
                $(this).addClass("active").siblings(".active").removeClass("active");
                if($(this).index()==0){
                    var dateType=5;
                    sessionStorage['itemDateType']='itemDateType5';//itemDateType5表示物品月度
                    if(sessionStorage['item']=='item11'||!sessionStorage['item']){
                        _self.getGoodsStatData(dateType);
                    }else if(sessionStorage['item']=='item22'){
                        _self.getGoodsStatDataUnit(dateType);
                    }
                }else if($(this).index()==1){
                    var dateType=6;
                    sessionStorage['itemDateType']='itemDateType6';//itemDateType6表示物品月度
                    if(sessionStorage['item']=='item11'||!sessionStorage['item']){
                        _self.getGoodsStatData(dateType);
                    }else if(sessionStorage['item']=='item22'){
                        _self.getGoodsStatDataUnit(dateType);
                    }
                }else{
                    var dateType=7;
                    sessionStorage['itemDateType']='itemDateType7';//itemDateType7表示物品月度
                    if(sessionStorage['item']=='item11'||!sessionStorage['item']){
                        _self.getGoodsStatData(dateType);
                    }else if(sessionStorage['item']=='item22'){
                        _self.getGoodsStatDataUnit(dateType);
                    }
                }
            });
        },
        //切换单位物品申领情况图月度季度年度
        unitGetGoodsStatData:function(){
            $("#unitGoodsQuest").on("click","button",function(){
                $(this).addClass("btn-primary").siblings(".btn-primary").removeClass("btn-primary");
                var dateType=sessionStorage['itemDateType']=='itemDateType5'?5:sessionStorage['itemDateType']=='itemDateType6'?6:sessionStorage['itemDateType']=='itemDateType7'?7:"";
                if($(this).index()==0){
                    sessionStorage['item']='item11';//item11表示个人
                    _self.getGoodsStatData(dateType);
                }else{
                    sessionStorage['item']='item22';//item22表示个人
                    _self.getGoodsStatDataUnit(dateType);
                }
            });
        },
        //切换个人用车情况图月度季度年度
        changeGetCarsStatData:function(){
            $("#usecarQuest").on("click","li",function(){
                $(this).addClass("active").siblings(".active").removeClass("active");
                if($(this).index()==0){
                    var dateType=5;
                    sessionStorage['carDateType']='carDateType5';//carDateType5表示车辆月度
                    if(sessionStorage['car']=='car11'||!sessionStorage['car']){
                        _self.getCarsStatData(dateType);
                    }else if(sessionStorage['car']=='car22'){
                        _self.getCarsStatDataUnit(dateType);
                    }
                }else if($(this).index()==1){
                    var dateType=6;
                    sessionStorage['carDateType']='carDateType6';//carDateType6表示车辆月度
                    if(sessionStorage['car']=='car11'||!sessionStorage['car']){
                        _self.getCarsStatData(dateType);
                    }else if(sessionStorage['car']=='car22'){
                        _self.getCarsStatDataUnit(dateType);
                    }
                }else{
                    var dateType=7;
                    sessionStorage['carDateType']='carDateType7';//carDateType7表示车辆年度
                    if(sessionStorage['car']=='car11'||!sessionStorage['car']){
                        _self.getCarsStatData(dateType);
                    }else if(sessionStorage['car']=='car22'){
                        _self.getCarsStatDataUnit(dateType);
                    }
                }
            });
        },
        //切换单位用车情况图月度季度年度
        unitGetCarsStatData:function(){
            $("#unitUsecarQuest").on("click","button",function(){
                $(this).addClass("btn-primary").siblings(".btn-primary").removeClass("btn-primary");
                var dateType=sessionStorage['carDateType']=='carDateType5'?5:sessionStorage['carDateType']=='carDateType6'?6:sessionStorage['carDateType']=='carDateType7'?7:"";
                if($(this).index()==0){
                    sessionStorage['car']='car11';//car11表示个人
                    _self.getCarsStatData(dateType);
                }else{
                    sessionStorage['car']='car22';//car22表示个人
                    _self.getCarsStatDataUnit(dateType);
                }
            });
        },


        //切换处室项目开支情况图月度季度年度
        officeExpenseStatData:function(){
            $("#officeExpenseStat").on("click","li",function(){
                $(this).addClass("active").siblings(".active").removeClass("active");
                if($(this).index()==0){
                    var dateType=5;
                    _self.getDevelopStat(dateType);
                }else if($(this).index()==1){
                    var dateType=6;
                    _self.getDevelopStat(dateType);
                }else{
                    var dateType=7;
                    _self.getDevelopStat(dateType);
                }
            });
        },
        //切换处室物品申领情况图月度季度年度
        officeGoodsStatData:function(){
            $("#officeGoodsStat").on("click","li",function(){
                $(this).addClass("active").siblings(".active").removeClass("active");
                if($(this).index()==0){
                    var dateType=5;
                    _self.getGoodsStat(dateType);
                }else if($(this).index()==1){
                    var dateType=6;
                    _self.getGoodsStat(dateType);
                }else{
                    var dateType=7;
                    _self.getGoodsStat(dateType);
                }
            });
        },
        //切换处室用车情况图月度季度年度
        officeCarStatData:function(){
            $("#officeCarStat").on("click","li",function(){
                $(this).addClass("active").siblings(".active").removeClass("active");
                if($(this).index()==0){
                    var dateType=5;
                    _self.getCarsStat(dateType);
                }else if($(this).index()==1){
                    var dateType=6;
                    _self.getCarsStat(dateType);
                }else{
                    var dateType=7;
                    _self.getCarsStat(dateType);
                }
            });
        },


        //加载待办任务
        showDaibanList:function(){
            _self = this;
            var userId=top.userId;
            fstPageAjax.todoList({userId:userId},function(data){
                if(data.flag==1){
                    $("#daibanDiv").empty().html(_.template(daibanListTpl,$.extend(data)));
                    //点击切换待办页面--开支申请
                    $(".expenseApplyTask").on("click",function(){
                        //$('#main-frame', parent.document).attr("src","projectManage/expenseApply.html?id=expense");
                        var modelNo = $(this).attr("modelNo");
                        var en = $(this).attr("en");
                        var status = $(this).attr("status");
                        $('#root-menu', window.parent.document).find('li').each(function(i,item){
                            if(modelNo==$(item).attr("page-no")){
                                $( $(item).find("a")[0]).attr('en',en);
                                $( $(item).find("a")[0]).attr('status',status);
                                $(item).parent().parent().find('a')[0].click();
                                $(item).find("a")[0].click();
                            }
                        });
                    });
                    //点击切换待办页面--车辆用车
                    $(".carApplyTask").on("click",function(){
                        var modelNo = $(this).attr("modelNo");
                        var en = $(this).attr("en");
                        var status = $(this).attr("status");
                        $('#root-menu', window.parent.document).find('li').each(function(i,item){
                            if(modelNo==$(item).attr("page-no")){
                                $( $(item).find("a")[0]).attr('en',en);
                                $( $(item).find("a")[0]).attr('status',status);
                                $(item).parent().parent().find('a')[0].click();
                                $(item).find("a")[0].click();
                            }
                        });
                    });
                    //点击切换待办页面--物品申领
                    $(".itemApplyTask").on("click",function(){
                        //$('#main-frame', parent.document).attr("src","itemManage/itemApply.html?id=item");
                        var modelNo = $(this).attr("modelNo");
                        var en = $(this).attr("en");
                        var status = $(this).attr("status");
                        $('#root-menu', window.parent.document).find('li').each(function(i,item){
                            if(modelNo==$(item).attr("page-no")){
                                $( $(item).find("a")[0]).attr('en',en);
                                $( $(item).find("a")[0]).attr('status',status);
                                $(item).parent().parent().find('a')[0].click();
                                $(item).find("a")[0].click();
                            }
                        });
                    });
                }
            });
        },

        //右边固定条点击事件
        projectApplyClick:function(){
            $('#projectApplyClick').on('click',function(){
                $('#root-menu', window.parent.document).find('li').each(function(i,item){
                    if($(item).attr("page-no")=='C0101'){
                    	$(item).parent().parent().find('a')[0].click();
                        $(item).find("a")[0].click();
                    }
                });
            })
        },
        carApplyClick:function(){
            $('#carApplyClick').on('click',function(){
                $('#root-menu', window.parent.document).find('li').each(function(i,item){
                    if($(item).attr("page-no")=='0101'){
                    	$(item).parent().parent().find('a')[0].click();
                        $(item).find("a")[0].click();
                    }
                });
            })
        },
        itemApplyClick:function(){
            $('#itemApplyClick').on('click',function(){
                $('#root-menu', window.parent.document).find('li').each(function(i,item){
                    if($(item).attr("page-no")=='itemApply'){
                    	$(item).parent().parent().find('a')[0].click();
                        $(item).find("a")[0].click();
                    }
                });
            })
        },
        ////加载局待办任务
        //showDaibanJList:function(){
        //    _self = this;
        //    $("#daibanDiv").empty().html(_.template(daibanJListTpl));
        //
        //},
        ////加载处室待办任务
        //showDaibanCList:function(){
        //    _self = this;
        //    $("#daibanDiv").empty().html(_.template(daibanCListTpl));
        //},
        //绘制经费开支情况图
        getExpenseStatData:function(dateType){
            var myChart = ec.init(byid('kaizhiqkT'));
            var colors = ["#087DC5"];
            var option = {
                color: colors,
                legend: {
                    data:['费用（元）']
                },
                toolbox: {
                    feature: {
                        dataView: {show: true, readOnly: false},
                        restore: {show: true},
                        saveAsImage: {show: true}
                    }

                },
                tooltip: {
                    trigger: 'item',
                    formatter: "{a} <br/>{b} : {c}"
                },
                grid: { // 控制图的大小，调整下面这些值就可以，
                    x: 100,
                    x2: 20
                },
                xAxis : [
                    {
                        type : 'category',
                        //data : ['刑专系统建设项目','XX专项行动','哈哈哈哈哈哈哈','喀喀喀喀喀喀','哇哈哈哈哈哈啊哈','啦啦啦啦啦啦','发发发发发','溜溜溜溜','哈好哦啊哦哈'],
                        data:[],
                        //设置字体倾斜
                        axisLabel:{
                            interval:0,
                            rotate:30,//倾斜度 -90 至 90 默认为0
                            margin:2,
                            textStyle:{
                                //fontWeight:"bolder",
                                color:"#878480"
                            }
                        }
                    }
                ],
                yAxis : [
                    {
                        type : 'value'
                    }
                ],
                series : [
                    {
                        name:'费用（元）',
                        type:'bar',
                        "barWidth": 20,
                        //data:[2020000, 4980000, 1020000, 2888000, 3330000,4550000, 6660000, 3530000, 6000001]
                        data:[]
                    }
                ]
            };
            // 为echarts对象加载数据
            var userId=top.userId;
            if(!dateType){
                var dateType=5;
            }
            var statementType=1;
            fstPageAjax.personList({userId:userId,statementType:statementType,dateType:dateType},function(data){
                if(data.flag==1){
                    var name=[];
                    var value=[];
                    for(var i= 0,len=data.data.length;i<len;i++){
                        name[i]=data.data[i].PROJECTNAME;
                        value[i]=data.data[i].REPAYAMOUNT;
                    }
                    option.xAxis[0].data=name;
                    option.series[0].data=value;
                    myChart.clear();
                    myChart.hideLoading();
                    myChart.setOption(option);
                }
            });
        },
        //绘制经费开支情况图单位
        getExpenseStatDataUnit:function(dateType){
            var myChart = ec.init(byid('kaizhiqkT'));
            var colors = ["#087DC5"];
            var option = {
                color: colors,
                legend: {
                    data:['费用（元）']
                },
                toolbox: {
                    feature: {
                        dataView: {show: true, readOnly: false},
                        restore: {show: true},
                        saveAsImage: {show: true}
                    }

                },
                tooltip: {
                    trigger: 'item',
                    formatter: "{a} <br/>{b} : {c}"
                },
                grid: { // 控制图的大小，调整下面这些值就可以，
                    x: 100,
                    x2: 20
                },
                xAxis : [
                    {
                        type : 'category',
                        //data : ['刑专系统建设项目','XX专项行动','哈哈哈哈哈哈哈','喀喀喀喀喀喀','哇哈哈哈哈哈啊哈','啦啦啦啦啦啦','发发发发发','溜溜溜溜','哈好哦啊哦哈'],
                        data:[],
                        //设置字体倾斜
                        axisLabel:{
                            interval:0,
                            rotate:30,//倾斜度 -90 至 90 默认为0
                            margin:2,
                            textStyle:{
                                //fontWeight:"bolder",
                                color:"#878480"
                            }
                        }
                    }
                ],
                yAxis : [
                    {
                        type : 'value'
                    }
                ],
                series : [
                    {
                        name:'费用（元）',
                        type:'bar',
                        "barWidth": 20,
                        //data:[2020000, 4980000, 1020000, 2888000, 3330000,4550000, 6660000, 3530000, 6000001]
                        data:[]
                    }
                ]
            };
            // 为echarts对象加载数据
            var orgId=top.orgId;
            if(!dateType){
                var dateType=5;
            }
            var statementType=1;
            fstPageAjax.personList({orgId:orgId,statementType:statementType,dateType:dateType},function(data){
                if(data.flag==1){
                    var name=[];
                    var value=[];
                    for(var i= 0,len=data.data.length;i<len;i++){
                        name[i]=data.data[i].PROJECTNAME;
                        value[i]=data.data[i].REPAYAMOUNT;
                    }
                    option.xAxis[0].data=name;
                    option.series[0].data=value;
                    myChart.clear();
                    myChart.hideLoading();
                    myChart.setOption(option);
                }
            });
        },
        //绘制个人物品申领情况图
        getGoodsStatData:function(dateType){
            var myChart = ec.init(byid('wupinqkT'));
            var colors=['#00B5CB'];
            var option = {
                color:colors,
                toolbox: {
                    feature: {
                        dataView: {show: true, readOnly: false},
                        restore: {show: true},
                        saveAsImage: {show: true}
                    }

                },
                tooltip: {
                    show: true
                },
                legend: {
                    data:['数量']
                },
                xAxis : [
                    {
                        type : 'category',
                        data : [],
                        //设置字体倾斜
                        axisLabel:{
                            interval:0,
                                rotate:40,//倾斜度 -90 至 90 默认为0
                                margin:2,
                                textStyle:{
                                //fontWeight:"bolder",
                                color:"#878480"
                            }
                        }
                    }
                ],
                yAxis : [
                    {
                        type : 'value'
                    }
                ],
                series : [
                    {
                        "name":"数量",
                        "type":"bar",
                        "barWidth": 20,
                        "data":[5, 20, 40, 10]
                    }
                ]
            };
            // 为echarts对象加载数据
            var userId=top.userId;
            if(!dateType){
                var dateType=5;
            }
            var statementType=3;
            fstPageAjax.personList({userId:userId,statementType:statementType,dateType:dateType},function(data){
                if(data.flag==1){
                    var name=[];
                    var value=[];
                    for(var i= 0,len=data.data.length;i<len;i++){
                        name[i]=data.data[i].NAME;
                        value[i]=data.data[i].NUM;
                    }
                    option.xAxis[0].data=name;
                    option.series[0].data=value;
                    myChart.clear();
                    myChart.hideLoading();
                    myChart.setOption(option);
                }
            });
        },
        //绘制个人物品申领情况图单位
        getGoodsStatDataUnit:function(dateType){
            var myChart = ec.init(byid('wupinqkT'));
            var colors=['#00B5CB'];
            var option = {
                color:colors,
                toolbox: {
                    feature: {
                        dataView: {show: true, readOnly: false},
                        restore: {show: true},
                        saveAsImage: {show: true}
                    }

                },
                tooltip: {
                    show: true
                },
                legend: {
                    data:['数量']
                },
                xAxis : [
                    {
                        type : 'category',
                        data : [],
                        //设置字体倾斜
                        axisLabel:{
                            interval:0,
                                rotate:40,//倾斜度 -90 至 90 默认为0
                                margin:2,
                                textStyle:{
                                //fontWeight:"bolder",
                                color:"#878480"
                            }
                        }
                    }
                ],
                yAxis : [
                    {
                        type : 'value'
                    }
                ],
                series : [
                    {
                        "name":"数量",
                        "type":"bar",
                        "barWidth": 20,
                        "data":[5, 20, 40, 10]
                    }
                ]
            };
            // 为echarts对象加载数据
            var orgId=top.orgId;
            if(!dateType){
                var dateType=5;
            }
            var statementType=3;
            fstPageAjax.personList({orgId:orgId,statementType:statementType,dateType:dateType},function(data){
                if(data.flag==1){
                    var name=[];
                    var value=[];
                    for(var i= 0,len=data.data.length;i<len;i++){
                        name[i]=data.data[i].NAME;
                        value[i]=data.data[i].NUM;
                    }
                    option.xAxis[0].data=name;
                    option.series[0].data=value;
                    myChart.clear();
                    myChart.hideLoading();
                    myChart.setOption(option);
                }
            });
        },
        //绘制个人用车情况图
        getCarsStatData:function(dateType){
            var myChart = ec.init(byid('yongcheqkT'));
            var colors=['#E8938D'];
            var option = {
                color:colors,
                toolbox: {
                    feature: {
                        dataView: {show: true, readOnly: false},
                        restore: {show: true},
                        saveAsImage: {show: true}
                    }

                },
                tooltip: {
                    show: true
                },
                legend: {
                    data:['次数']
                },
                xAxis : [
                    {
                        type : 'category',
                        data : ['办公用品','酒水','装备','其他'],
                        //设置字体倾斜
                        axisLabel:{
                            interval:0,
                            rotate:40,//倾斜度 -90 至 90 默认为0
                            margin:2,
                            textStyle:{
                                //fontWeight:"bolder",
                                color:"#878480"
                            }
                        }
                    }
                ],
                yAxis : [
                    {
                        type : 'value'
                    }
                ],
                series : [
                    {
                        "name":"次数",
                        "type":"bar",
                        "barWidth": 20,
                        "data":[5, 20, 40, 10]
                    }
                ]
            };
            // 为echarts对象加载数据
            var userId=top.userId;
            if(!dateType){
                var dateType=5;
            }
            var statementType=2;
            fstPageAjax.personList({userId:userId,statementType:statementType,dateType:dateType},function(data){
                if(data.flag==1){
                    var name=[];
                    var value=[];
                    for(var i= 0,len=data.data.length;i<len;i++){
                        name[i]=data.data[i].NAME;
                        value[i]=data.data[i].NUM;
                    }
                    option.xAxis[0].data=name;
                    option.series[0].data=value;
                    //option.legend.data=data.object[0];//传单位
                    myChart.clear();
                    myChart.hideLoading();
                    myChart.setOption(option);
                }
            });
        },
        //绘制个人用车情况图单位
        getCarsStatDataUnit:function(dateType){
            var myChart = ec.init(byid('yongcheqkT'));
            var colors=['#E8938D'];
            var option = {
                color:colors,
                toolbox: {
                    feature: {
                        dataView: {show: true, readOnly: false},
                        restore: {show: true},
                        saveAsImage: {show: true}
                    }

                },
                tooltip: {
                    show: true
                },
                legend: {
                    data:['次数']
                },
                xAxis : [
                    {
                        type : 'category',
                        data : [],
                        //设置字体倾斜
                        axisLabel:{
                            interval:0,
                            rotate:40,//倾斜度 -90 至 90 默认为0
                            margin:2,
                            textStyle:{
                                //fontWeight:"bolder",
                                color:"#878480"
                            }
                        }
                    }
                ],
                yAxis : [
                    {
                        type : 'value'
                    }
                ],
                series : [
                    {
                        "name":"次数",
                        "type":"bar",
                        "barWidth": 20,
                        "data":[5, 20, 40, 10]
                    }
                ]
            };
            // 为echarts对象加载数据
            var orgId=top.orgId;
            if(!dateType){
                var dateType=5;
            }
            var statementType=2;
            fstPageAjax.personList({orgId:orgId,statementType:statementType,dateType:dateType},function(data){
                if(data.flag==1){
                    var name=[];
                    var value=[];
                    for(var i= 0,len=data.data.length;i<len;i++){
                        name[i]=data.data[i].NAME;
                        value[i]=data.data[i].NUM;
                    }
                    option.xAxis[0].data=name;
                    option.series[0].data=value;
                    //option.legend.data=data.object[0];//传单位
                    myChart.clear();
                    myChart.hideLoading();
                    myChart.setOption(option);
                }
            });
        },
        //绘制各处项目开支情况图(物品+用车)
        getDevelopStat:function(dateType){
            // 为echarts对象加载数据
            var userId=top.userId;
            if(!dateType){
                var dateType=5;
            }
            var statementType=1;
            fstPageAjax.officeList({userId:userId,statementType:statementType,dateType:dateType},function(data){
                if(data.flag==1){
                    var myChart = ec.init(byid('gechuxiangmuT'));
                    var option = {
                        tooltip : {
                            trigger: 'item',
                            formatter: "{a} <br/>{b} : <br/>{c} ({d}%)"
                        },
                        color:['#3580B7','#D74844','#93BC58','#856299'],
                        legend: {
                            orient : 'vertical',
                            x : 'right',
                            top:50,
                            itemWidth:10,  //图例标记的图形宽度
                            itemHeight:10, //图例标记的图形高度
                            data: Object.keys(data.data).map(function (key) {
                                return {
                                    name: data.data[key].ORGNAME
                                }
                            })
                        },
                        toolbox: {
                            show : true,
                            feature : {
                                mark : {show: true},
                                dataView : {show: true, readOnly: false},
                                magicType : {
                                    show: true,
                                    type: ['pie', 'funnel'],
                                    option: {
                                        funnel: {
                                            x: '25%',
                                            width: '50%',
                                            funnelAlign: 'left',
                                            max: 1548
                                        }
                                    }
                                },
                                restore : {show: true},
                                saveAsImage : {show: true}
                            }
                        },
                        calculable : true,
                        series : [
                            {
                                name:'各处项目开支情况',
                                type:'pie',
                                radius : '55%',
                                center: ['50%', '60%'],
                                data: Object.keys(data.data).map(function (key) {
                                    return {
                                        name: data.data[key].ORGNAME,
                                        value: data.data[key].REPAYAMOUNT
                                    }
                                })
                            }
                        ]
                    };
                    myChart.clear();
                    myChart.hideLoading();
                    myChart.setOption(option);
                }
            });
        },
        //绘制各处物品申领情况图
        getGoodsStat:function(dateType){
            // 为echarts对象加载数据
            var userId=top.userId;
            if(!dateType){
                var dateType=5;
            }
            var statementType=3;
            fstPageAjax.officeList({userId:userId,statementType:statementType,dateType:dateType},function(data){
                if(data.flag==1){
                    var myChart = ec.init(byid('gechuwupinT'));
                    var option = {
                        tooltip : {
                            trigger: 'item',
                            formatter: "{a} <br/>{b} :<br/> {c} ({d}%)"
                        },
                        color:['#3580B7','#D74844','#93BC58','#856299'],
                        legend: {
                            orient : 'vertical',
                            x : 'right',
                            top:50,
                            itemWidth:10,  //图例标记的图形宽度
                            itemHeight:10, //图例标记的图形高度
                            data: Object.keys(data.data).map(function (key) {
                                return {
                                    name: data.data[key].NAME
                                }
                            })
                        },
                        toolbox: {
                            show : true,
                            feature : {
                                mark : {show: true},
                                dataView : {show: true, readOnly: false},
                                magicType : {
                                    show: true,
                                    type: ['pie', 'funnel'],
                                    option: {
                                        funnel: {
                                            x: '25%',
                                            width: '50%',
                                            funnelAlign: 'left',
                                            max: 1548
                                        }
                                    }
                                },
                                restore : {show: true},
                                saveAsImage : {show: true}
                            }
                        },
                        calculable : true,
                        series : [
                            {
                                name:'各处物品申领情况',
                                type:'pie',
                                radius : '55%',
                                center: ['50%', '60%'],
                                data: Object.keys(data.data).map(function (key) {
                                    return {
                                        name: data.data[key].NAME,
                                        value: data.data[key].NUM
                                    }
                                })
                            }
                        ]
                    };
                    myChart.clear();
                    // 设置加载等待隐藏
                    myChart.hideLoading();
                    myChart.setOption(option);
                }
            });
        },
        //绘制各处用车情况图
        getCarsStat:function(dateType){
            // 为echarts对象加载数据
            var userId=top.userId;
            if(!dateType){
                var dateType=5;
            }
            var statementType=2;
            fstPageAjax.officeList({userId:userId,statementType:statementType,dateType:dateType},function(data){
                if(data.flag==1){
                    var myChart = ec.init(byid('gechuyongcheT'));
                    var option = {
                        tooltip : {
                            trigger: 'item',
                            formatter: "{a} <br/>{b} :<br/> {c} ({d}%)"
                        },
                        color:['#3580B7','#D74844','#93BC58','#856299'],
                        legend: {
                            orient : 'vertical',
                            x : 'right',
                            top:50,
//                            right:20,
                            itemWidth:10,  //图例标记的图形宽度
                            itemHeight:10, //图例标记的图形高度
                            data: Object.keys(data.data).map(function (key) {
                                return {
                                    name: data.data[key].NAME
                                }
                            })
                        },
                        toolbox: {
                            show : true,
                            feature : {
                                mark : {show: true},
                                dataView : {show: true, readOnly: false},
                                magicType : {
                                    show: true,
                                    type: ['pie', 'funnel'],
                                    option: {
                                        funnel: {
                                            x: '25%',
                                            width: '50%',
                                            funnelAlign: 'left',
                                            max: 1548
                                        }
                                    }
                                },
                                restore : {show: true},
                                saveAsImage : {show: true}
                            }
                        },
                        calculable : true,
                        series : [
                            {
                                name:'各处用车情况',
                                type:'pie',
                                //radius: [0, '50%'],
                                radius: [0, '55%'],
                                center: ['48%', '60%'],
                                data: Object.keys(data.data).map(function (key) {
                                    return {
                                        name: data.data[key].NAME,
                                        value: data.data[key].NUM
                                    }
                                })
                            }
                        ]
                    };
                    myChart.clear();
                    // 设置加载等待隐藏
                    myChart.hideLoading();
                    myChart.setOption(option);
                }
            });
        },
        //加载当前最新发布、通知公告、规章制度、表格下载
        queryNewList:function(){
            _self = this;
            fstPageAjax.findReceivePage({receiverId:top.userName,end:20,msgState:"0"},function(data){
                var obj=[];
                for(var i=0;i<data.data.length;i++){
                    obj[i]= JSON.parse(data.data[i].msgContent);
                };
                if(data.flag==1){
                    $(".news").empty().html(_.template(newListTpl, $.extend(data,{obj:obj})));
                    $("#currentNum").text(data.data.length);
                    $("#totalNum").text(data.totalCount)
                    $('[data-grade="newsGrade"]').each(function(){
                        if($.trim(this.innerHTML)=="平急"){
                            $(this).addClass("pingJi")
                        }else if($.trim(this.innerHTML)=="加急"){
                            $(this).addClass("jiaJi");
                        }else if($.trim(this.innerHTML)=="特急"){
                            $(this).addClass("teJi");
                        }else if($.trim((this).innerHTML)==""){

                        }
                    })

                }
            });
            fstPageAjax.findRePage({type:1,receiverId:top.userName,end:5},function(data){
                if(data.flag==1){
                    $(".notice").empty().html(_.template(noticeListTpl,{data:data.data}));
                }
            });
            fstPageAjax.findPage({type:2,end:5},function(data){
                if(data.flag==1){
                    $(".rule").empty().html(_.template(ruleListTpl,{data:data.data}));
                }
            });
            fstPageAjax.findPage({type:3,end:5},function(data){
                if(data.flag==1){
                    $(".tabledown").empty().html(_.template(tableDownListTpl,{data:data.data}));
                }
            });

        },
        //点击当月最新发布每列
        newsOne:function(){
            _self = this;
            $(".news").on("click",".new-column",function(e){
                var id = $(this).attr("data-id");
                var type = $(this).attr("msg-type");

                //如果已经打开过,并且没有被关闭清除, 那就直接选中现在这个
                if(typeof window.msgTab=='object' && window.msgTab.children().length>0){
                    window.msgTab.$close();
                    var html ='<em id="newsTitle" data-id="' + id +'" msg-type="'+type+'">当月最新发布</em>';
                    window.msgTab=$open(getViewPath('fstPage/newsMessage.html'),html);
                }else{
                    var html ='<em id="newsTitle" data-id="' + id +'" msg-type="'+type+'">当月最新发布</em>';
                    window.msgTab=$open(getViewPath('fstPage/newsMessage.html'),html);
                }
                e.preventDefault();
            });
        },
        //点击通知公告每列
        noticeOne:function(){
            _self = this;
            $(".notice").on("click","a.noticeOne",function(e){
                e.preventDefault();
                var id=$(this).attr("data-id");
                $get(top.servicePath+'/sys/message/view',{id:id,userId:top.userName},function(res){
                    //打开弹出框
                    //window.newwin=$open('#opinion-div-block',{width:500,top:100, title:'通知公告'});
                    $('#myModal').modal('show');
                    $('#myModal').on('shown.bs.modal', function (e) {
                        $(".modal-body").height($(".modal-content").outerHeight(true) - $(".panel-header").outerHeight(true) - 35)
                    });
                    if(res.flag==1){
                        $(".modal-content").empty().html(_.template(noticeOneTpl,{data:res.data}));
                        if($.trim($("#noticeRev1").find("a").html())==""){
                            $("#noticeRev1").hide();
                        }
                    }
                });
            })
        },
        //点击规章制度每列
        ruleOne:function(){
            _self = this;
            $(".rule").on("click","a.ruleOne",function(e) {
                e.preventDefault();
                var id = $(this).attr("data-id");
                fstPageAjax.findById({id: id}, function (res) {
                    //打开弹出框
                    $('#myModal').modal('show');
                    $('#myModal').on('shown.bs.modal', function (e) {
                        $(".modal-body").height($(".modal-content").outerHeight(true) - $(".panel-header").outerHeight(true) - 35)
                    });
                    if (res.flag == 1) {
                        $(".modal-content").empty().html(_.template(ruleOneTpl, {data: res.data}));
                        if($.trim($("#ruleRev1").find("a").html())==""){
                            $("#ruleRev1").hide();
                        }
                    }
                })
            })
        },
        //点击表格下载每列
        //tabledowmOne:function(){
        //    _self = this;
        //    $(".tabledown").on("click","a.tableOne",function(e) {
        //        e.preventDefault();
        //        var download=$(this).attr("data-download");
        //        window.newwin=$open('#opinion-div-block',{width:300,top:100, title:'确认下载吗？'});
        //    })
        //},
        //点击更多跳转到当月最新发布更多信息页面
        newsMore:function(){
            $('#newsMore').on('click',function(){
                //如果已经打开过,并且没有被关闭清除, 那就直接选中现在这个
                if(typeof window.msgTab=='object' && window.msgTab.children().length>0){
                    var html ='<em id="newsTitle">当月最新发布</em>';
                    window.msgTab=$openOnce(getViewPath('fstPage/newsMessage.html'), html);
                    $("#msg-left-content div.li:eq(0) .cc").trigger("click");
                }else{
                    var html ='<em id="newsTitle">当月最新发布</em>';
                    window.msgTab=$open(getViewPath('fstPage/newsMessage.html'),html);
                }
            })
        },
        //打开通知公告页面
        noticesMore:function(){
            $('#noticesMore').on('click',function(){
                //如果已经打开过,并且没有被关闭清除, 那就直接选中现在这个
                if(typeof window.msgTab=='object' && window.msgTab.children().length>0){
                    var html ='<em id="noticeTitle">通知公告</em>';
                    $openOnce(getViewPath('fstPage/tpl/noticeMessage.html'), html)
                }else{
                    var html ='<em id="noticeTitle">通知公告</em>';
                    window.msgTab=$open(getViewPath('fstPage/tpl/noticeMessage.html'),html);
                }
            })
        },
        //打开规章制度页面
        rulesMore:function(){
            $('#rulesMore').on('click',function(){
                //如果已经打开过,并且没有被关闭清除, 那就直接选中现在这个
                if(typeof window.msgTab=='object' && window.msgTab.children().length>0){
                    $openOnce(getViewPath('fstPage/tpl/ruleMessage.html'), '规章制度')
                }else{
                    window.msgTab=$open(getViewPath('fstPage/tpl/ruleMessage.html'),'规章制度');
                }
            })
        },
        //打开表格下载页面
        tablesMore:function(){
            $('#tablesMore').on('click',function(){
                //如果已经打开过,并且没有被关闭清除, 那就直接选中现在这个
                if(typeof window.msgTab=='object' && window.msgTab.children().length>0){
                    $openOnce(getViewPath('fstPage/tableMessage.html'), '表格下载')
                }else{
                    window.msgTab=$open(getViewPath('fstPage/tableMessage.html'),'表格下载');
                }
            })
        }

	}
});
   