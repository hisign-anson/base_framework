
package com.hisign.xingzhen.xz.mapper;

import com.hisign.bfun.bif.BaseMapper;
import com.hisign.xingzhen.xz.api.entity.GroupBackup;
import com.hisign.xingzhen.xz.api.model.GroupBackupModel;
import org.springframework.stereotype.Repository;

/**
 * 《专案组归档记录》 数据访问接口
 * @author 何建辉
 *
 */
@Repository
public interface GroupBackupMapper extends BaseMapper<GroupBackup,GroupBackupModel,String> {

    public GroupBackupModel findBackUpInfoByEntity(GroupBackup backup);

}