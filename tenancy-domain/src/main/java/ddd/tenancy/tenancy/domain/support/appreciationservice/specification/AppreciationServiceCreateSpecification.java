package ddd.tenancy.tenancy.domain.support.appreciationservice.specification;

import ddd.tenancy.tenancy.common.exception.Errors;
import ddd.tenancy.tenancy.common.exception.TenancyDomainException;
import ddd.tenancy.tenancy.common.specification.CompositeSpecification;
import ddd.tenancy.tenancy.domain.support.appreciationservice.vo.AppreciationServiceBuildVO;
import org.springframework.stereotype.Component;

/**
 * AppreciationServiceCreateSpecification
 * date 2019/4/6
 */
@Component
public class AppreciationServiceCreateSpecification extends CompositeSpecification<AppreciationServiceBuildVO> {

  @Override
  public boolean isSatisfied(AppreciationServiceBuildVO candidate) {
    boolean success = true;
    if (success) {
      return success;
    }
    throw new TenancyDomainException(Errors.DEFAULT_PARAM_VALID_ERROR);
  }

}
