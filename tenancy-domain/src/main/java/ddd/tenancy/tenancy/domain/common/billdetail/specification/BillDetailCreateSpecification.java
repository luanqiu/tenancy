package ddd.tenancy.tenancy.domain.common.billdetail.specification;

import ddd.tenancy.tenancy.common.exception.Errors;
import ddd.tenancy.tenancy.common.exception.TenancyDomainException;
import ddd.tenancy.tenancy.common.specification.CompositeSpecification;
import ddd.tenancy.tenancy.domain.common.billdetail.vo.BillDetailBuildVO;
import org.springframework.stereotype.Component;

/**
 * BillDetailCreateSpecification
 * date 2019/4/6
 */
@Component
public class BillDetailCreateSpecification extends CompositeSpecification<BillDetailBuildVO> {

  @Override
  public boolean isSatisfied(BillDetailBuildVO candidate) {
    boolean success = true;
    if (success) {
      return success;
    }
    throw new TenancyDomainException(Errors.DEFAULT_PARAM_VALID_ERROR);
  }

}
