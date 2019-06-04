package ddd.tenancy.tenancy.domain.support.appreciationservice.specification;

import ddd.tenancy.tenancy.common.specification.CompositeSpecification;
import ddd.tenancy.tenancy.domain.support.appreciationservice.entity.AppreciationServiceEntity;
import org.springframework.stereotype.Component;

/**
 * AppreciationServiceLegalSpecification
 * date 2019/4/6
 */
@Component
public class AppreciationServiceLegalSpecification extends CompositeSpecification<AppreciationServiceEntity> {

  @Override
  public boolean isSatisfied(AppreciationServiceEntity candidate) {
    return false;
  }

}
