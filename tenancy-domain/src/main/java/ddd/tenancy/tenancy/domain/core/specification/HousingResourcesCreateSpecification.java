package ddd.tenancy.tenancy.domain.core.specification;

import ddd.tenancy.tenancy.common.exception.Errors;
import ddd.tenancy.tenancy.common.exception.TenancyDomainException;
import ddd.tenancy.tenancy.common.specification.CompositeSpecification;
import ddd.tenancy.tenancy.domain.core.vo.HousingResourcesBuildVO;
import org.springframework.stereotype.Component;

/**
 * HousingResourcesCreateSpecification
 * date 2019/4/6
 */
@Component
public class HousingResourcesCreateSpecification extends CompositeSpecification<HousingResourcesBuildVO> {

  @Override
  public boolean isSatisfied(HousingResourcesBuildVO candidate) {
    boolean success = true;
    if (success) {
      return success;
    }
    throw new TenancyDomainException(Errors.DEFAULT_PARAM_VALID_ERROR);
  }

}
