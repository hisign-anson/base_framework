
package com.hisign.xingzhen.xz.api.service;

import com.hisign.bfun.bmodel.JsonResult;
import com.hisign.xingzhen.xz.api.entity.GroupBackup;

import java.util.Date;

/**
 * 《催办记录》 业务逻辑服务接口
 * @author 何建辉
 */
public interface IndexService {

    public JsonResult getAchievementList(GroupBackup groupBackup);

    public JsonResult getGroupCaseInfo(Date[] dateSection,String backupStatus);

    //查询用户待确认的反馈数量
    public Long getNotConfirmCountByCreator(String creator);

}