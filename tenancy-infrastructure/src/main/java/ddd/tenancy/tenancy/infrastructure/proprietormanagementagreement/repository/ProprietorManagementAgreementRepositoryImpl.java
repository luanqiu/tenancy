package ddd.tenancy.tenancy.infrastructure.proprietormanagementagreement.repository;

import ddd.base.domain.VO;
import ddd.tenancy.tenancy.domain.core.entity.ProprietorManagementAgreementEntity;
import ddd.tenancy.tenancy.domain.core.repository.ProprietorManagementAgreementRepository;
import org.springframework.stereotype.Repository;

/**
* ProprietorManagementAgreementRepositoryImpl
*date Jun 4, 2019 12:44:25 PM
*/
@Repository
public class ProprietorManagementAgreementRepositoryImpl implements ProprietorManagementAgreementRepository {

  @Override
  public Boolean createProprietorManagementAgreement(VO vo) {
    return null;
  }

  @Override
  public void insert(ProprietorManagementAgreementEntity proprietorManagementAgreementEntity) {

  }

  @Override
  public ProprietorManagementAgreementEntity getByProprietorManagementAgreementId(String proprietorManagementAgreementId) {
    return null;
  }

}
