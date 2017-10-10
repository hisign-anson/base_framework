<#include "include/head.ftl">

package ${NamespaceDao};

import ${NamespaceProject}.base.dao.BaseDao;
import ${NamespaceDomain}.${Po}Entity;

 /**
 * 《${tableLabel}》 数据访问接口
 * @author ${copyright.author}
 *
 */
public interface ${Po}DAO extends BaseDao<${Po}Entity,${pkcolumnSimpleClassName}> {

}