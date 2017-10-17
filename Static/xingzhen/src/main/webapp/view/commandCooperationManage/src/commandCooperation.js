/**
 * Created by dell on 2017/9/28.
 */
define(['underscore',
    'text!/view/commandCooperationManage/tpl/cooperationPage.html',
    'text!/view/commandCooperationManage/tpl/groupTaskList.html',
    'text!/view/commandCooperationManage/tpl/groupTaskListTr.html',
    'text!/view/commandCooperationManage/tpl/groupTaskEdit.html',
    'text!/view/caseInvestigation/tpl/specialCaseGroup/caseList.html'], function (_, cooperationPageTpl,groupTaskListTpl,groupTaskListTrTpl,groupTaskEditTpl,caseListTpl) {
    return {
        showList: function () {
            _self = this;
            $("#mainDiv").empty().html(_.template(cooperationPageTpl, {ops: top.opsMap}));
            $("#toggleGroup").on("click", function () {
                var $this = $(this);
                $(".group-btn-div").removeClass("hide");
                $this.parents(".body-agent").toggleClass("group-list-s");
            });
            $(".choose-group").on("click", function () {
                var $this = $(this);
                $this.next("ul").slideToggle();
                $this.next("ul li").on("click", function () {
                    $(this).parent("ul").slideToggle();
                });
            });
            $(".all-group-list ul li").click(function () {
                var $this = $(this);
                $(".common-group-ul li.active").removeClass("active");
                $this.parents("ul").slideToggle();
                //选中专案组并进行操作
                _self.handleGroup($this);
            });
            $(".common-group-ul li").on("click", function () {
                var $this = $(this);
                $this.addClass("active").siblings(".active").removeClass("active");
                //选中专案组并进行操作
                _self.handleGroup($this);
            });
            //全屏显示脉络图
            _self.fullPanel("#fullscreenBtn");
            //显示脉络图查询条件
            _self.showCondition();
        },
        handleGroup:function (obj) {
            _self = this;
            console.info(obj.index());
            var thisValue = obj.text();
            $(".choose-group").empty().text(thisValue);

            $(".group-btn-div").removeClass("hide");
            //跳转到任务清单
            _self.intoTaskList();
            //跳转到涉及案件
            _self.intoRelatedCase();
            $("#mapSvgFrame").attr("src", "/view/commandCooperationManage/graph/d3graphView.html");
            $("#mapSvgFrame").css({
                "width": "100%",
                "height": "calc(100vh - 105px)"
            });
        },
        showCondition:function () {
            _self = this;
            var conditionDiv = $("#mapConditionWrap");
            conditionDiv.add(conditionDiv.children()).addClass("hide");
            $("#searchBtn").on("click", function () {
                conditionDiv.add(conditionDiv.children()).removeClass("hide");
                conditionDiv.removeClass("hide")
                //     .animate({
                //     width:"340px"
                // },"fast");
                $("#dateRange").daterangepicker({
                    separator: ' 至 ',
                    showWeekNumbers: true,
                    pickTime: true
                }, function (start, end, label) {
                    $('#startTime').val(start.format('YYYY-MM-DD HH:mm:ss'));
                    $('#endTime').val(end.format('YYYY-MM-DD HH:mm:ss'));
                });
                selectUtils.selectTextOption("#changeYesOrNo", "#taskType");
                selectUtils.selectTextOption("#changeTaskStatus", "#taskStatus");
                $("#closeBtn").on("click", function () {
                    conditionDiv.add(conditionDiv.children()).addClass("hide");
                    conditionDiv.addClass("hide")
                    //     .animate({
                    //     width:"0"
                    // },"fast");
                });
            });
        },
        intoCommunication:function () {
            _self = this;
        },
        intoTaskList:function () {
            _self = this;
            $(".into-taskList").on("click", function (){
                $open('#taskListDiv', {width: 800, title: '&nbsp任务清单'});
                _self.showTaskList();
            });
        },
        showTaskList:function() {
            _self = this;
            $("#taskListDiv .panel-container").empty().html(_.template(groupTaskListTpl));
            $("#createDate").daterangepicker({
                separator: ' 至 ',
                showWeekNumbers: true,
                pickTime: true
            }, function (start, end, label) {
                $('#startTime').val(start.format('YYYY-MM-DD HH:mm:ss'));
                $('#endTime').val(end.format('YYYY-MM-DD HH:mm:ss'));
            });
            selectUtils.selectTimeRangeOption("#changeCreateDate", "#createDate", "#startTime", "#endTime");
            selectUtils.selectTextOption(".panel-container #changeTaskStatus", "#taskStatus");
            $("#resetBtn").on("click",function () {

            });
            $("#queryBtn").on("click",function () {
                _self.queryTaskList();
            });
            _self.queryTaskList();
        },
        queryTaskList:function() {
            _self = this;
            var param = $("#queryCondition").serializeObject();
            $.extend(param, {

            });
            var taskData = [
                {
                    "rownum": 0,
                    "id": "BD54F18C24874DBE934472CD21EBC6BB",
                    "taskName": "快递费就能发",
                    "taskContent": "发货人挺好挺好太容易",
                    "belongGroup": "情报科",
                    "createName": "超级管理员",
                    "createDate": "2017-07-06 18:00:16",
                    "recipient": "张三",
                    "taskStatus": "10",
                    "recipientStatus": 0,
                    "submitDate": "2017-09-04 11:59:09",
                    "actualSubmitDate": "2017-09-04 11:59:09"
                },
                {
                    "rownum": 1,
                    "id": "E3E47DAB3F1F44C7BD02ED9E91C6D951",
                    "taskName": "发给后台",
                    "taskContent": "v凤于九天洒多少份",
                    "belongGroup": "市公安局",
                    "createName": "李四",
                    "createDate": "2017-07-05 18:00:16",
                    "recipient": "随便",
                    "taskStatus": "10",
                    "recipientStatus": 3,
                    "submitDate": "2017-09-07 11:59:09",
                    "actualSubmitDate": "2017-09-06 19:59:09"
                }
            ];
            $("#taskListTable tbody").empty().html(_.template(groupTaskListTrTpl, {data: taskData}));
            $(".link-text").on("click",function () {
                $("#taskListDiv .panel-container").empty().html(_.template(groupTaskEditTpl));
                $("#cancelBtn").on("click",function () {
                    _self.showTaskList();
                });
                $("#appendTaskBtn").on("click",function () {
                    _self.showTaskList();
                });
            });
        },
        intoRelatedCase:function () {
            _self = this;
            $(".into-relationCase").on("click", function (){
                $open('#taskListDiv', {width: 800, title: '&nbsp案件查询'});
                _self.showRelatedCaseList();
            });
        },
        showRelatedCaseList:function () {
            _self = this;
            $("#taskListDiv .panel-container").empty().html(_.template(caseListTpl));
            $("#resetBtn").on("click",function () {

            });
            $("#queryBtn").on("click",function () {
                _self.queryRelatedCaseList();
            });
            _self.queryRelatedCaseList();
        },
        queryRelatedCaseList:function () {
            _self = this;
            var param = $("#queryCondition").serializeObject();
            $.extend(param, {

            });
            $("#cancelBtn").on("click",function () {
                if ($("#taskListDiv")) {
                    $("#taskListDiv").$close();
                }
            });
            $("#saveBtn").on("click",function () {
                if ($("#taskListDiv")) {
                    $("#taskListDiv").$close();
                }
            });
        },
        fullPanel: function (ctrlSelector) {
            _self = this;
            var wrap = top.$(window.frameElement);
            var topBody = top.$('body');
            var the = $(ctrlSelector).parents(".map-list");
            var ctrl = $(ctrlSelector);
            ctrl.click(function () {
                if (the.hasClass('full-panel')) {
                    the.siblings().add(the.siblings()).addClass('hidden');

                    topBody.animate({opacity: 0}, 10, function () {
                        //避免引发重绘
                        window._cancelGlobalReFixTbTime = new Date().getTime();
                        $('body').removeClass('full-mode-ovh');
                        topBody.removeClass('full-mode-ovh');
                        wrap.removeClass('full-panel-wrap');
                        //引发重绘
                        window._cancelGlobalReFixTbTime = new Date().getTime() - 500;
                        the.removeClass('full-panel');
                        setTimeout(function () {
                            topBody.animate({opacity: 1}, 60);
                            the.siblings().add(the.siblings()).removeClass('hidden');
                        }, 200);
                    });
                    ctrl[0] && (ctrl[0].title='最大化显示') && ctrl.removeClass('active');

                } else {
                    the.siblings().add(the.siblings()).addClass('hidden');
                    topBody.animate({opacity: 0}, 10, function () {
                        //避免引发重绘
                        window._cancelGlobalReFixTbTime = new Date().getTime();
                        $('body').addClass('full-mode-ovh');
                        topBody.addClass('full-mode-ovh');
                        wrap.addClass('full-panel-wrap');
                        the.addClass('full-panel');
                        //引发重绘
                        window._cancelGlobalReFixTbTime = new Date().getTime() - 500;
                        setTimeout(function () {
                            topBody.animate({opacity: 1}, 60);
                        }, 260);
                    });
                    ctrl[0] && (ctrl[0].title='还原') && ctrl.addClass('active');
                }
            });
            return this;
        }
    }
});