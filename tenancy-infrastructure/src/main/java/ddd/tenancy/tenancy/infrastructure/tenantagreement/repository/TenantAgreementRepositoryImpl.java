package ddd.tenancy.tenancy.infrastructure.tenantagreement.repository;

import ddd.base.domain.VO;
import ddd.tenancy.tenancy.domain.core.entity.TenantAgreementEntity;
import ddd.tenancy.tenancy.domain.core.repository.TenantAgreementRepository;
import org.springframework.stereotype.Repository;

/**
* TenantAgreementRepositoryImpl
*date Jun 4, 2019 12:44:25 PM
*/
@Repository
public class TenantAgreementRepositoryImpl implements TenantAgreementRepository {

  @Override
  public Boolean createTenantAgreement(VO vo) {
    return null;
  }

  @Override
  public void insert(TenantAgreementEntity tenantAgreementEntity) {

  }

  @Override
  public TenantAgreementEntity getByAgreementId(String agreementId) {
    return null;
  }

}
