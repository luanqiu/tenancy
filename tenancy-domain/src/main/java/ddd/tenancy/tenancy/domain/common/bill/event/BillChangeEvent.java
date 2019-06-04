package ddd.tenancy.tenancy.domain.common.bill.event;

import ddd.base.domain.DomainEvent;
import ddd.tenancy.tenancy.domain.common.bill.entity.BillEntity;

import lombok.Data;

/**
 * BillChangeEvent
 * date 2019/4/6
 */
@Data
public class BillChangeEvent implements DomainEvent {

  private static final long serialVersionUID = -1L;

  private BillEntity billEntity;

  public BillChangeEvent(BillEntity billEntity) {
    this.billEntity = billEntity;
  }

}
