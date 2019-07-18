package ddd.tenancy.tenancy.domain.core.repository;

import ddd.base.domain.Repository;
import ddd.base.domain.VO;
import ddd.tenancy.tenancy.common.exception.TenancySpiException;
import ddd.tenancy.tenancy.domain.core.entity.HousingResourcesEntity;
import ddd.tenancy.tenancy.domain.core.vo.OperatorLogVO;
import ddd.tenancy.tenancy.domain.core.vo.QueryHousingParamsVO;

/**
 * HousingResourcesRepository
 * author  likongpeng
 * date 2019/4/6
 */
public interface HousingResourcesRepository extends Repository {

  /**
   * 房源创建
   */
  Boolean createHousingResources(VO vo);

  /**
   *
   * @param housingResourcesEntity
   * @return
   */
  void insert(HousingResourcesEntity housingResourcesEntity) throws TenancySpiException;

  /**
   *
   * @param housingId
   * @return
   */
  HousingResourcesEntity getByHousingId(String housingId);

  /**
   *
   * @param housingId
   * @param queryHousingParamsVO
   * @return
   */
  HousingResourcesEntity getByHousingId(String housingId,QueryHousingParamsVO queryHousingParamsVO);

  /**
   * 新增添加房源的操作记录
   * @param operatorLog
   */
  void addOperatorLog(OperatorLogVO operatorLog);
}
