
package com.hisign.xingzhen.xz.mapper;

import com.hisign.bfun.bif.BaseMapper;
import com.hisign.xingzhen.xz.api.entity.Group;
import com.hisign.xingzhen.xz.api.model.GroupModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 《专案组》 数据访问接口
 *
 * @author 何建辉
 */
public interface GroupMapper extends BaseMapper<Group,GroupModel, String> {

    /**
     * 获取专案组编号
     * @return
     */
    public String getMaxNo();

    public List<GroupModel> getGroupByCondition(Group group);

    public long getCountGroupByCondition(Group group);

    public Map<String,Long> findGroupCaseInfo(@Param("backupStatus") String backupStatus);
}