package ddd.tenancy.tenancy.domain.support.appreciationservice.repository;

import ddd.base.domain.Repository;
import ddd.base.domain.VO;
import ddd.tenancy.tenancy.common.exception.TenancySpiException;
import ddd.tenancy.tenancy.domain.support.appreciationservice.entity.AppreciationServiceEntity;

/**
 * AppreciationServiceRepository
 * author  likongpeng
 * date 2019/4/6
 */
public interface AppreciationServiceRepository extends Repository {

  /**
   * 增值服务创建
   */
  Boolean createAppreciationService(VO vo);

  /**
   *
   * @param appreciationServiceEntity
   * @return
   */
  void insert(AppreciationServiceEntity appreciationServiceEntity) throws TenancySpiException;

  /**
   *
   * @param appreciationServiceId
   * @return
   */
  AppreciationServiceEntity getByAppreciationServiceId(String appreciationServiceId);

}
