<#include "include/head.ftl">

package ${NamespaceServiceImpl};

import ${NamespaceDao}.${Po}DAO;
import ${NamespaceDomain}.${Po}Entity;
import ${NamespaceService}.${Po}Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ${NamespaceProject}.base.service.BaseServiceImpl;


 /**
 * 《${tableLabel}》 业务逻辑服务类
 * @author ${copyright.author}
 *
 */
@Service("${po}Service")
public class ${Po}ServiceImpl extends BaseServiceImpl<${Po}Entity, ${pkcolumnSimpleClassName}> implements ${Po}Service{

	@Autowired
	private ${Po}DAO ${po}DAOImpl;

}