/**
 * Created by dell on 2017/9/20.
 */
importing('currentDate');
define(['underscore',
    'text!/view/caseInvestigation/tpl/task/taskList.html',
    'text!/view/caseInvestigation/tpl/task/taskListTr.html',
    'text!/view/caseInvestigation/tpl/task/taskAdd.html',
    'text!/view/caseInvestigation/tpl/task/taskEdit.html',
    'text!/view/caseInvestigation/tpl/task/taskFeedback.html',
    '../../dictManage/src/dictOpener.js'], function (_, taskListTpl,taskListTrTpl,taskAddTpl,taskEditTpl,taskFeedbackTpl,
                                                     dictOpener) {
    return {
        showList: function () {
            _self = this;
            //关闭没有关闭的弹框
            dictOpener.closeOpenerDiv();
            $("#mainDiv").empty().html(_.template(taskListTpl, {ops: top.opsMap}));
            selectUtils.selectTextOption("#changeTaskType", "#taskType");
            selectUtils.selectTextOption("#changeTaskStatus", "#taskStatus");

            $("#createDate").daterangepicker({
                separator: ' 至 ',
                showWeekNumbers: true,
                pickTime: true
            }, function (start, end, label) {
                $('#startTime').val(start.format('YYYY-MM-DD HH:mm:ss'));
                $('#endTime').val(end.format('YYYY-MM-DD HH:mm:ss'));
            });
            //点击选择时间范围（当天当月当季当年）
            /***参数：（被点击的div包裹层，显示的时间输入框，传入后台的开始时间，传入后台的结束时间）***/
            selectUtils.selectTimeRangeOption("#changeCreateDate", "#createDate", "#startTime", "#endTime");

            $("#addTask").on("click",function () {
                _self.showAdd();
            });

            $("#resetBtn").on("click",function () {

            });
            $("#queryBtn").on("click",function () {
                _self.queryList();
            });
            _self.queryList();
        },
        //查询功能
        queryList:function(){
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
            $("#taskListTable tbody").empty().html(_.template(taskListTrTpl, {data: taskData}));
            $(".link-text").on("click",function () {
                $("#mainDiv").empty().html(_.template(taskEditTpl));
                $("#cancelBtn").on("click",function () {
                    _self.showList();
                });
                $("#appendTaskBtn").on("click",function () {
                    _self.showList();
                });
            });

            $(".into-urge").on("click",function () {

            });
            $(".into-delete").on("click",function () {

            });
            $(".into-feedback").on("click",function () {
                $("#mainDiv").empty().html(_.template(taskFeedbackTpl));
            });
            $(".into-transfer").on("click", function () {
                $open('#userListDiv', {width: 800, title: '&nbsp用户列表'});
            });
        },
        showAdd:function () {
            _self = this;
            $("#mainDiv").empty().html(_.template(taskAddTpl));
            $("#dateDue").datetimepicker({format:'YYYY-MM-DD',pickTime:false});
            $("#createDate").datetimepicker({format:'YYYY-MM-DD',pickTime:false});

            $("#chooseGroup").on('click', function () {
                dictOpener.openChooseDict($(this));
            });
            $("#chooseReceive").on('click', function () {
                dictOpener.openChooseDict($(this));
            });
            $("#cancelBtn").on("click",function () {
                _self.showList();

            });
            $("#saveBtn").on("click",function () {
                _self.showList();
            });
        }
    }
});