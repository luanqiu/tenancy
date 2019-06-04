package ddd.tenancy.tenancy.domain.core.specification;

import ddd.tenancy.tenancy.common.specification.CompositeSpecification;
import ddd.tenancy.tenancy.domain.core.entity.TenantAgreementEntity;
import org.springframework.stereotype.Component;

/**
 * TenantAgreementLegalSpecification
 * date 2019/4/6
 */
@Component
public class TenantAgreementLegalSpecification extends CompositeSpecification<TenantAgreementEntity> {

  @Override
  public boolean isSatisfied(TenantAgreementEntity candidate) {
    return false;
  }

}
