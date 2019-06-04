package ddd.tenancy.tenancy.domain.common.bill.factory;

import ddd.base.domain.DomainFactory;
import ddd.tenancy.tenancy.domain.common.bill.entity.BillEntity;
import ddd.tenancy.tenancy.domain.common.bill.vo.BillBuildVO;
import org.springframework.stereotype.Component;

/**
 * BillFactory
 * perfect 简单的构造示范
 * date 2019/4/6
 */
@Component
public class BillEntityFactory implements DomainFactory<BillBuildVO, BillEntity> {

  @Override
  public BillEntity perfect(BillBuildVO vo) {
    BillEntity entity = BillEntity.get();
    entity.setBillId("");
    return entity;
  }
}
