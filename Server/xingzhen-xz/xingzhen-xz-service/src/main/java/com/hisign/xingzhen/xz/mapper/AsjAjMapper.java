
package com.hisign.xingzhen.xz.mapper;

import com.hisign.bfun.bif.BaseMapper;
import com.hisign.xingzhen.xz.api.entity.AsjAj;
import com.hisign.xingzhen.xz.api.model.AsjAjModel;

import java.util.List;

/**
 * 《案件》 数据访问接口
 *
 * @author 何建辉
 */
public interface AsjAjMapper extends BaseMapper<AsjAj,AsjAjModel, String> {

    public List<AsjAjModel> findAjGroupPage(AsjAj aj);

    public long findAjGroupPageCount(AsjAj aj);

    public AsjAj findFirstCaseByGroupId(String id);

}