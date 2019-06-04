package ddd.tenancy.tenancy.infrastructure.bill.message;

import ddd.base.domain.EventListenerI;
import ddd.tenancy.tenancy.domain.common.bill.event.BillChangeEvent;
import org.springframework.stereotype.Component;

/**
 * BillChangeListener
 * date Jun 4, 2019 12:44:25 PM
 */
@Component
public class BillChangeListener implements EventListenerI<BillChangeEvent> {

  @Override
  public void execute(BillChangeEvent event) {
    // send
    // 可以把 event 里面的领域对象 转化成对外的消息
    // 基础设置层还必须保证消息一定可以发送出去，如果发送失败了，能够保证重试等等
  }

}
