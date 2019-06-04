package ddd.tenancy.tenancy.common.event;

import ddd.base.domain.DomainEvent;
import ddd.base.domain.DomainEventPublisherI;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 消息发布者
 * 默认都是同步的
 * date 2019/4/6
 */
@Component
public class DomainEventPublisher implements DomainEventPublisherI {

  @Resource
  private SimpleEventBus simpleEventBus;

  @Override
  public void publish(DomainEvent event, Boolean async) {
    if (!async) {
      simpleEventBus.fire(event);
      return;
    }
    simpleEventBus.asyncFire(event);
  }
}
