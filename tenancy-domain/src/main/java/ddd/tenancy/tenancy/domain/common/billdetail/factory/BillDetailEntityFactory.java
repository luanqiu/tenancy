package ddd.tenancy.tenancy.domain.common.billdetail.factory;

import ddd.base.domain.DomainFactory;
import ddd.tenancy.tenancy.domain.common.billdetail.entity.BillDetailEntity;
import ddd.tenancy.tenancy.domain.common.billdetail.vo.BillDetailBuildVO;
import org.springframework.stereotype.Component;

/**
 * BillDetailFactory
 * perfect 简单的构造示范
 * date 2019/4/6
 */
@Component
public class BillDetailEntityFactory implements DomainFactory<BillDetailBuildVO, BillDetailEntity> {

  @Override
  public BillDetailEntity perfect(BillDetailBuildVO vo) {
    BillDetailEntity entity = BillDetailEntity.get();
    entity.setBillDetailId("");
    return entity;
  }
}
