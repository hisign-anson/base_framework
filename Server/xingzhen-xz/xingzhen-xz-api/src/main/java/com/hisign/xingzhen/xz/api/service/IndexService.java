
package com.hisign.xingzhen.xz.api.service;

import com.hisign.bfun.bmodel.JsonResult;

/**
 * 《催办记录》 业务逻辑服务接口
 * @author 何建辉
 */
public interface IndexService {

    public JsonResult getAchievementList();

    public JsonResult getGroupCaseInfo(String backupStatus);

}