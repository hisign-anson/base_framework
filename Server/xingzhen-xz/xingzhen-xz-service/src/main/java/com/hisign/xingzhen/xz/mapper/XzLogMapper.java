
package com.hisign.xingzhen.xz.mapper;

import com.hisign.bfun.bif.BaseMapper;
import com.hisign.xingzhen.xz.api.entity.XzLog;
import com.hisign.xingzhen.xz.api.model.XzLogModel;
import org.springframework.stereotype.Repository;

/**
 * 《日志》 数据访问接口
 * @author 何建辉
 *
 */
@Repository
public interface XzLogMapper extends BaseMapper<XzLog,XzLogModel,String> {

}