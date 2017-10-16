/**
 * Created by dell on 2017/9/20.
 */
importing('currentDate');
define(['underscore',
    'text!/view/caseInvestigation/tpl/specialCaseGroup/specialCaseGroupList.html',
    'text!/view/caseInvestigation/tpl/specialCaseGroup/specialCaseGroupListTr.html',
    'text!/view/caseInvestigation/tpl/specialCaseGroup/specialCaseGroupAdd.html',
    'text!/view/caseInvestigation/tpl/specialCaseGroup/archivePage.html',
    'text!/view/caseInvestigation/tpl/specialCaseGroup/groupList.html',
    'text!/view/caseInvestigation/tpl/specialCaseGroup/caseList.html',
    'text!/view/caseInvestigation/tpl/specialCaseGroup/caseListTr.html',
    'text!/view/caseInvestigation/tpl/specialCaseGroup/userList.html',
    'text!/view/caseInvestigation/tpl/specialCaseGroup/userListTr.html',
    'text!/view/chatPage/chatPage.html',
    'text!/view/caseInvestigation/tpl/specialCaseGroup/baseInfo.html',
    'text!/view/caseInvestigation/tpl/specialCaseGroup/relationCase.html',
    'text!/view/caseInvestigation/tpl/specialCaseGroup/relationCaseTr.html',
    'text!/view/caseInvestigation/tpl/specialCaseGroup/groupStaff.html',
    'text!/view/caseInvestigation/tpl/specialCaseGroup/groupStaffTr.html',
    '../../dictManage/src/dictOpener.js'], function (_, specialCaseGroupListTpl, specialCaseGroupListTrTpl, specialCaseGroupAddTpl,archivePageTpl,groupListTpl,caseListTpl,caseTrTpl,
                                                     userListTpl,userListTrTpl,chatPageTpl,baseInfoTpl,relationCaseTpl,relationCaseTrTpl,groupStaffTpl,groupStaffTrTpl,
                                                     dictOpener) {
    return {
        showList: function () {
            _self = this;
            //关闭没有关闭的弹框
            dictOpener.closeOpenerDiv();
            $("#mainDiv").empty().html(_.template(specialCaseGroupListTpl, {ops: top.opsMap}));
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
            selectUtils.selectTimeRangeOption("#changeTimeScope", "#createDate", "#startTime", "#endTime");

            //点击选择是否
            /***参数：（被点击的div包裹层，传入后台的参数）***/
            selectUtils.selectTextOption("#changeYesOrNo", "#msgLevel");
            $("#addSpecialCaseGroup").on("click", function () {
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
        queryList: function () {
            var param = $("#queryCondition").serializeObject();
            $.extend(param, {
                // startTime:$("#startTime").val(),
                // endTime:$("#endTime").val(),
                // name:$.trim($("#name").val()),
                // regName:$.trim($("#regName").val()),
                // totalFund:parseFloat($.trim($("#totalFund").val()))*10000
            });
            var data = [
                {
                    "rownum": 0,
                    "id": "BD54F18C24874DBE934472CD21EBC6BB",
                    "groupId": "ABCDEFGHABCDEFGHABCDEFGH12346157",
                    "groupName": "测试项目1",
                    "groupType": "0",
                    "caseNum": 4,
                    "createName": "张三",
                    "staffNum": "10",
                    "createTime": "2017-07-06 18:00:16",
                    "fileStatus": 0,
                    "fileTime": "2017-09-04 11:59:09"
                },
                {
                    "rownum": 1,
                    "id": "06FB300E23AB4630B1153637D7C655E6",
                    "groupId": "E3E47DAB3F1F44C7BD02ED9E91C6D951",
                    "groupName": "一长四必项目",
                    "groupType": "1",
                    "caseNum": 1,
                    "createName": "超级管理员",
                    "staffNum": "5",
                    "createTime": "2017-07-05 18:00:16",
                    "fileStatus": 1,
                    "fileTime": "2017-09-07 11:59:09"
                }
            ];
            $("#specialGroupListTable tbody").empty().html(_.template(specialCaseGroupListTrTpl, {
                data: data,
                ops: top.opsMap
            }));

            $(".into-archive").on("click", function () {
                $open('#archiveBlock', {width: 800, top: 180, title: '&nbsp专案组归档'});
                $("#archiveBlock .form-content").empty().html(_.template(archivePageTpl));
            });
            $(".into-broadcast").on("click", function () {

            });
            $(".into-communication").on("click", function () {
                console.info("进入聊天界面！");
                $("#mainDiv").empty().html(_.template(chatPageTpl));
            });
            //嵌套表格的实现--------------------------------------------------------------------------------------------
            $(".into-group").on('click',function(){
                var isOpen = $(this).hasClass("clicked-open");
                var data1 = [
                    {
                        "rownum": 0,
                        "id": "BD54F18C24874DBE934472CD21EBC6BB",
                        "groupId": "ABCDEFGHABCDEFGHABCDEFGH12346157",
                        "groupName": "测试项目1",
                        "groupType": "0",
                        "caseNum": 4,
                        "createName": "张三",
                        "staffNum": "10",
                        "createTime": "2017-07-06 18:00:16",
                        "fileStatus": 0,
                        "fileTime": "2017-09-04 11:59:09"
                    },
                    {
                        "rownum": 1,
                        "id": "06FB300E23AB4630B1153637D7C655E6",
                        "groupId": "E3E47DAB3F1F44C7BD02ED9E91C6D951",
                        "groupName": "一长四必项目",
                        "groupType": "1",
                        "caseNum": 1,
                        "createName": "超级管理员",
                        "staffNum": "5",
                        "createTime": "2017-07-05 18:00:16",
                        "fileStatus": 1,
                        "fileTime": "2017-09-07 11:59:09"
                    }
                ];
                var currentTr = $(this).parents("tr");
                if(isOpen){
                    $(this).removeClass("clicked-open");
                    currentTr.next().remove();
                } else {
                    $(this).addClass("clicked-open");
                    var tableHtml = _.template(groupListTpl,{data: data1});
                    console.info(tableHtml);
                    console.info($(tableHtml));
                    //嵌套内容渲染
                    var appendTr = currentTr.after('<tr class="tr-inner-table"><td colspan="12"></td></tr>');
                    currentTr.next().find("td").empty().html(tableHtml);
                }
            });
        },
        showAdd: function () {
            _self = this;
            $("#mainDiv").empty().html(_.template(specialCaseGroupAddTpl));
            var flag = false;
            $('#addGroupTab a').click(function (e) {
                if($(this).attr("id")=="navBaseInfo"){
                    $(this).tab('show');
                    //判断是否有专案组信息
                    //如果有：展示基本信息
                    //否则：报错
                    toast("是否保存过专案组基本信息？").warn();
                    _self.handleBaseInfo(flag);
                }else if($(this).attr("id")=="navRelationCase"){
                    $('#baseInfo .field-valid').validatebox();
                    if($('.validatebox-invalid').length > 0){
                        toast("请先保存专案组基本信息！").warn();
                        return false;
                    } else {
                        $(this).tab('show');
                        $("#saveBtn").trigger("click");
                        flag = true;
                        _self.handleRelationCase();
                    }
                }else if($(this).attr("id")=="navGroupStaff"){
                    $('#baseInfo .field-valid').validatebox();
                    if($('.validatebox-invalid').length > 0){
                        toast("请先保存专案组基本信息！").warn();
                        return false;
                    } else {
                        $(this).tab('show');
                        $("#saveBtn").trigger("click");
                        flag = true;
                        _self.handleGroupStaff();
                    }
                }
            });
            $('#addGroupTab a:first').click();


            // var indexActived = 1;
            // //点击nav时
            // $('#addGroupTab a').click(function (e) {
            //     if($(this).attr("id")=="navBaseInfo"){
            //         $("#btnBaseInfo").parents(".form-btn-block").show();
            //     }else if($(this).attr("id")=="navRelationCase"){
            //         $("#btnBaseInfo").parents(".form-btn-block").hide();
            //         console.info("是否保存专案组基本信息？");
            //     }else if($(this).attr("id")=="navGroupStaff"){
            //         $("#btnBaseInfo").parents(".form-btn-block").hide();
            //         console.info("是否保存专案组基本信息？");
            //     }
            //
            // });
            // //点击按钮时
            // $("#exitBtn").off("click").on('click',function () {
            //     if (indexActived == 1) {
            //         _self.showList();
            //         indexActived = 1;
            //     } else if (indexActived == 2) {
            //         //保存当前显示tab页面的内容，并且跳转到下一个tab
            //         $('#addGroupTab a#navBaseInfo').click();
            //         // $('#addGroupTab a#navBaseInfo').parent("li").addClass("active").siblings(".active").removeClass("active");
            //         // $('.tab-pane#baseInfo').addClass("active").siblings(".active").removeClass("active");
            //
            //         indexActived = 2;
            //     } else if (indexActived == 3) {
            //         $('#addGroupTab a#navRelationCase').click();
            //         // $('#addGroupTab a#navRelationCase').parent("li").addClass("active").siblings(".active").removeClass("active");
            //         // $('.tab-pane#relationCase').addClass("active").siblings(".active").removeClass("active");
            //
            //         indexActived = 3;
            //     }
            // });
            // $("#saveBtn").off("click").on('click',function () {
            //     if (indexActived == 1) {
            //         $('#addGroupTab a#navRelationCase').click();
            //         // $('#addGroupTab a#navRelationCase').parent("li").addClass("active").siblings(".active").removeClass("active");
            //         // $('.tab-pane#relationCase').addClass("active").siblings(".active").removeClass("active");
            //
            //         indexActived = 1;
            //     } else if (indexActived == 2) {
            //         $('#addGroupTab a#navGroupStaff').click();
            //         // $('#addGroupTab a#navGroupStaff').parent("li").addClass("active").siblings(".active").removeClass("active");
            //         // $('.tab-pane#groupStaff').addClass("active").siblings(".active").removeClass("active");
            //
            //         indexActived = 2;
            //     } else if (indexActived == 3) {
            //         _self.showList();
            //         indexActived = 3;
            //     }
            // });
            //
            // //涉及案件
            // _self.handleRelationCase();
            // //组内成员
            // _self.handleGroupStaff();
        },
        handleBaseInfo:function (flag) {
            _self = this;
            $(".form-content-block").empty().html(_.template(baseInfoTpl));
            $(".form-btn-block").removeClass("hide");
            if(flag){
                //已经保存过 输入框设值 并且不可修改 不可提交
                $("#baseInfo").find("input,select,i").attr("disabled","disabled").val("def ");
            } else {
                // $("#baseInfo")
                $("#chooseFactory-button").on('click',function(){
                    dictOpener.openChooseDict($(this));
                });
                $("#saveBtn").on("click",function () {
                    toast("保存专案组基本信息").ok();
                });
            }
        },
        handleRelationCase:function () {
            _self = this;
            $(".form-content-block").empty().html(_.template(relationCaseTpl));
            $(".form-btn-block").addClass("hide");
            $("#resetBtn").on("click",function () {

            });
            $("#queryBtn").on("click",function () {
                _self.queryRelationCaseList();
            });

            //加载已关联案件列表
            _self.queryRelationCaseList();
            //点击选择案件状态
            /***参数：（被点击的div包裹层，传入后台的参数）***/
            selectUtils.selectTextOption("#changeCaseSta", "#caseSta");
            //关联新案件
            $("#linkNewCase").on("click",function () {
                $open('#caseListDiv', {width: 800, title: '&nbsp案件查询'});
                $("#caseListDiv .panel-container").empty().html(_.template(caseListTpl));
                selectUtils.selectTextOption("#changeCaseSta", "#caseSta");
                selectUtils.selectTextOption("#changeCaseType", "#caseType");

                $("#resetBtn").on("click",function () {

                });
                $("#queryBtn").on("click",function () {
                    _self.queryCaseList();
                });

                //加载案件列表
                _self.queryCaseList();

            });
        },
        queryRelationCaseList:function () {
            _self = this;
            var data = [
                {
                    "rownum": 1,
                    "id": "BD54F18C24874DBE934472CD21EBC6BB",
                    "caseId": "A4401010002017031100012",
                    "caseName": "916特大杀人案",
                    "caseType": "刑事",
                    "caseStatus": "已立案",
                    "caseKindle": "持枪杀人案",
                    "caseContent": "916特大杀人案，犯罪嫌疑人在市政大厦...",
                    "casePlace": "越秀中环市政大厦",
                    "caseStaff": "李四"
                }
            ];
            $("#relationCaseTable tbody").empty().html(_.template(relationCaseTrTpl, {
                data: data,
                ops: top.opsMap
            }));
        },
        queryCaseList:function () {
            _self = this;
            var data = [
                {
                    "rownum": 1,
                    "id": "BD54F18C24874DBE934472CD21EBC6BB",
                    "caseId": "A4401010002017031100012",
                    "caseName": "916特大杀人案",
                    "caseType": "刑事",
                    "caseStatus": "已立案",
                    "caseKindle": "持枪杀人案",
                    "caseContent": "916特大杀人案，犯罪嫌疑人在市政大厦...",
                    "casePlace": "越秀中环市政大厦",
                    "caseStaff": "李四"
                },
                {
                    "rownum": 2,
                    "id": "BD54F18C24874DBE934472CD21EBC633",
                    "caseId": "A4401010002017030800001",
                    "caseName": "持枪挟持绑架案",
                    "caseType": "刑事",
                    "caseStatus": "已立案",
                    "caseKindle": "绑架案",
                    "caseContent": "接群众报警，称其丈夫被人持枪挟持绑...",
                    "casePlace": "越秀中环市政大厦",
                    "caseStaff": "李四"
                }
            ];
            $("#caseTable tbody").empty().html(_.template(caseTrTpl, {
                data: data,
                ops: top.opsMap
            }));
        },
        handleGroupStaff:function () {
            _self = this;
            $(".form-content-block").empty().html(_.template(groupStaffTpl));
            $(".form-btn-block").addClass("hide");
            $("#resetBtn").on("click",function () {

            });
            $("#queryBtn").on("click",function () {
                _self.queryRelationCaseList();
            });
            //加载已添加的成员
            _self.queryAddedStaffList();
            //成员添加
            $("#addStaff").on("click",function () {
                $open('#userListDiv', {width: 800, title: '&nbsp用户查询'});
                $("#userListDiv .panel-container").empty().html(_.template(userListTpl));
                $("#resetBtn").on("click",function () {

                });
                $("#queryBtn").on("click",function () {
                    _self.queryUserList();
                });

                //加载用户列表
                _self.queryUserList();
            });
        },
        queryAddedStaffList:function () {
            _self = this;
            var data = [
                {
                    "rownum": 1,
                    "id": "BD54F18C24874DBE934472CD21EBC6BB",
                    "userName": "李四",
                    "userId": "001234",
                    "userPhone": "15111224301",
                    "userUnit": "越秀分局刑事侦查科",
                    "userPost": "领导",
                    "userStatus": "正常"
                }
            ];
            $("#staffTable tbody").empty().html(_.template(groupStaffTrTpl, {
                data: data,
                ops: top.opsMap
            }));
        },
        queryUserList:function () {
            _self = this;
            var data = [
                {
                    "rownum": 1,
                    "id": "BD54F18C24874DBE934472CD21EBC6BB",
                    "userName": "李四",
                    "userId": "001234",
                    "userPhone": "15111224301",
                    "userUnit": "越秀分局刑事侦查科",
                    "userPost": "领导",
                    "userStatus": "正常"
                },
                {
                    "rownum": 2,
                    "id": "BD54F18C24874DBE934472CD21EBC6BB",
                    "userName": "张三",
                    "userId": "001999",
                    "userPhone": "13122291122",
                    "userUnit": "越秀分局刑事侦查科",
                    "userPost": "科员",
                    "userStatus": "正常"
                },
                {
                    "rownum": 3,
                    "id": "BD54F18C24874DBE934472CD21EBC6BB",
                    "userName": "王五",
                    "userId": "061399",
                    "userPhone": "13926541535",
                    "userUnit": "越秀分局刑事侦查科",
                    "userPost": "局长",
                    "userStatus": "正常"
                }
            ];
            $("#userTable tbody").empty().html(_.template(userTrTpl, {
                data: data,
                ops: top.opsMap
            }));
        }
    }
});