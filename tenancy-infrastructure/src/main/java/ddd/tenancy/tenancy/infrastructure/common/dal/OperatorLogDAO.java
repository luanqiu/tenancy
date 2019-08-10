package ddd.tenancy.tenancy.infrastructure.common.dal;

import org.apache.ibatis.annotations.Param;

import java.util.List;

import ddd.tenancy.tenancy.infrastructure.common.dal.dataobject.OperatorLogDO;

/**
* OperatorLogDAO
*author  wenhe
*date 2019/6/18
*/
public interface OperatorLogDAO {

  List<OperatorLogDO> queryByBizIdAndType(
      @Param("operatorId") String operatorId, @Param("action") String type);

  int insert(@Param("operatorLogDO") OperatorLogDO operatorLogDO);
}
