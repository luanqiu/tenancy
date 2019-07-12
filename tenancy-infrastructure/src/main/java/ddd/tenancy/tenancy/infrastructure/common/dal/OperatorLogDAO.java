package ddd.tenancy.tenancy.infrastructure.common.dal;

import java.util.List;

import ddd.tenancy.tenancy.infrastructure.common.dal.dataobject.OperatorLogDO;

/**
* OperatorLogDAO
*author  wenhe
*date 2019/6/18
*/
public interface OperatorLogDAO {

  List<OperatorLogDO> queryByBizIdAndType(String housingId, String type);
}
