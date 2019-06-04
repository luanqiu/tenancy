package ddd.tenancy.tenancy.domain.common.bill.specification;

import ddd.tenancy.tenancy.common.specification.CompositeSpecification;
import ddd.tenancy.tenancy.domain.common.bill.entity.BillEntity;
import org.springframework.stereotype.Component;

/**
 * BillLegalSpecification
 * date 2019/4/6
 */
@Component
public class BillLegalSpecification extends CompositeSpecification<BillEntity> {

  @Override
  public boolean isSatisfied(BillEntity candidate) {
    return false;
  }

}
