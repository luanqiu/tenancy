package ddd.tenancy.tenancy.domain.common.billdetail.event;

import ddd.base.domain.DomainEvent;
import ddd.tenancy.tenancy.domain.common.billdetail.entity.BillDetailEntity;

import lombok.Data;

/**
 * BillDetailChangeEvent
 * date 2019/4/6
 */
@Data
public class BillDetailChangeEvent implements DomainEvent {

  private static final long serialVersionUID = -1L;

  private BillDetailEntity billDetailEntity;

  public BillDetailChangeEvent(BillDetailEntity billDetailEntity) {
    this.billDetailEntity = billDetailEntity;
  }
}
