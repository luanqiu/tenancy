package ddd.tenancy.tenancy.domain.common.bill.specification;

import ddd.tenancy.tenancy.common.exception.Errors;
import ddd.tenancy.tenancy.common.exception.TenancyDomainException;
import ddd.tenancy.tenancy.common.specification.CompositeSpecification;
import ddd.tenancy.tenancy.domain.common.bill.vo.BillBuildVO;
import org.springframework.stereotype.Component;

/**
 * BillCreateSpecification
 * date 2019/4/6
 */
@Component
public class BillCreateSpecification extends CompositeSpecification<BillBuildVO> {

  @Override
  public boolean isSatisfied(BillBuildVO candidate) {
    boolean success = true;
    if (success) {
      return success;
    }
    throw new TenancyDomainException(Errors.DEFAULT_PARAM_VALID_ERROR);
  }

}
