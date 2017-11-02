
package com.hisign.xingzhen.xz.mapper;

import com.hisign.bfun.bif.BaseMapper;
import com.hisign.xingzhen.xz.api.entity.Cb;
import com.hisign.xingzhen.xz.api.model.CbModel;
import org.springframework.stereotype.Repository;

/**
 * 《催办记录》 数据访问接口
 * @author 何建辉
 *
 */
@Repository
public interface CbMapper extends BaseMapper<Cb,CbModel,String> {
    public long updateCbTaskid(Cb cb);
}