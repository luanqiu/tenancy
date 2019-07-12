package ddd.tenancy.tenancy.domain.core.repository;

import java.util.List;

import ddd.base.domain.Repository;
import ddd.tenancy.tenancy.domain.core.vo.OperatorLogVO;

/**
 * 操作记录
 * author  wenhe
 * date 2019/4/6
 */
public interface OperatorLogRepository extends Repository {

  /**
   * 根据业务id和操作记录类型，查询操作记录集合
   */
  List<OperatorLogVO> queryByBizIdAndType(String bizId, String type);

}
