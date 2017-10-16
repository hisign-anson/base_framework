
package com.hisign.framework.xz.mapper;

import com.hisign.bfun.bif.BaseMapper;
import com.hisign.framework.xz.api.entity.AsjAj;
import com.hisign.framework.xz.api.model.AsjAjModel;

import java.util.List;

/**
 * 《案件》 数据访问接口
 *
 * @author 何建辉
 */
public interface AsjAjMapper extends BaseMapper<AsjAj,AsjAjModel, String> {

    public List<AsjAjModel> getAjGroupPage(AsjAj aj);

    public long getAjGroupPageCount(AsjAj aj);

}