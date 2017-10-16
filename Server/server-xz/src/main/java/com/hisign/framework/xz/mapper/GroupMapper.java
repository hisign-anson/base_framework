
package com.hisign.framework.xz.mapper;

import com.hisign.bfun.bif.BaseMapper;
import com.hisign.framework.xz.api.entity.Group;
import com.hisign.framework.xz.api.model.GroupModel;

import java.util.List;

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
}