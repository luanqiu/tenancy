package ddd.tenancy.tenancy.domain.core.repository;

import ddd.base.domain.Repository;
import ddd.base.domain.VO;
import ddd.tenancy.tenancy.common.exception.TenancySpiException;
import ddd.tenancy.tenancy.domain.core.entity.ProprietorManagementAgreementEntity;

/**
 * ProprietorManagementAgreementRepository
 * author  likongpeng
 * date 2019/4/6
 */
public interface ProprietorManagementAgreementRepository extends Repository {

  /**
   * 业主房屋管理合同创建
   */
  Boolean createProprietorManagementAgreement(VO vo);

  /**
   *
   * @param proprietorManagementAgreementEntity
   * @return
   */
  void insert(ProprietorManagementAgreementEntity proprietorManagementAgreementEntity) throws TenancySpiException;

  /**
   *
   * @param proprietorManagementAgreementId
   * @return
   */
  ProprietorManagementAgreementEntity getByProprietorManagementAgreementId(String proprietorManagementAgreementId);

}
