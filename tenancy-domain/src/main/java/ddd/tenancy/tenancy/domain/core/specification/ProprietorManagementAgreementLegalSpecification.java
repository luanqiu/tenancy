package ddd.tenancy.tenancy.domain.core.specification;

import ddd.tenancy.tenancy.common.specification.CompositeSpecification;
import ddd.tenancy.tenancy.domain.core.entity.ProprietorManagementAgreementEntity;
import org.springframework.stereotype.Component;

/**
 * ProprietorManagementAgreementLegalSpecification
 * date 2019/4/6
 */
@Component
public class ProprietorManagementAgreementLegalSpecification extends CompositeSpecification<ProprietorManagementAgreementEntity> {

  @Override
  public boolean isSatisfied(ProprietorManagementAgreementEntity candidate) {
    return false;
  }

}
