package ddd.tenancy.tenancy.domain.core.repository;

import ddd.base.domain.Repository;
import ddd.base.domain.VO;
import ddd.tenancy.tenancy.common.exception.TenancySpiException;
import ddd.tenancy.tenancy.domain.core.entity.TenantAgreementEntity;

/**
 * TenantAgreementRepository
 * author  likongpeng
 * date 2019/4/6
 */
public interface TenantAgreementRepository extends Repository {

  /**
   * 租房合同创建
   */
  Boolean createTenantAgreement(VO vo);

  /**
   *
   * @param tenantAgreementEntity
   * @return
   */
  void insert(TenantAgreementEntity tenantAgreementEntity) throws TenancySpiException;

  /**
   *
   * @param agreementId
   * @return
   */
  TenantAgreementEntity getByAgreementId(String agreementId);

}
