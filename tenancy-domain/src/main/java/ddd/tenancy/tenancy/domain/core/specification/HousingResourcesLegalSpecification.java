package ddd.tenancy.tenancy.domain.core.specification;

import ddd.tenancy.tenancy.common.specification.CompositeSpecification;
import ddd.tenancy.tenancy.domain.core.entity.HousingResourcesEntity;
import org.springframework.stereotype.Component;

/**
 * HousingResourcesLegalSpecification
 * date 2019/4/6
 */
@Component
public class HousingResourcesLegalSpecification extends CompositeSpecification<HousingResourcesEntity> {

  @Override
  public boolean isSatisfied(HousingResourcesEntity candidate) {
    return false;
  }

}
