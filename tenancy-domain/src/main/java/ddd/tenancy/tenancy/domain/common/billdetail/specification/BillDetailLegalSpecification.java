package ddd.tenancy.tenancy.domain.common.billdetail.specification;

import ddd.tenancy.tenancy.common.specification.CompositeSpecification;
import ddd.tenancy.tenancy.domain.common.billdetail.entity.BillDetailEntity;
import org.springframework.stereotype.Component;

/**
 * BillDetailLegalSpecification
 * date 2019/4/6
 */
@Component
public class BillDetailLegalSpecification extends CompositeSpecification<BillDetailEntity> {

  @Override
  public boolean isSatisfied(BillDetailEntity candidate) {
    return false;
  }

}
