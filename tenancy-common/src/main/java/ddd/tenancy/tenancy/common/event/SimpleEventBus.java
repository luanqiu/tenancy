package ddd.tenancy.tenancy.common.event;

import com.google.common.eventbus.EventBus;

import ddd.base.domain.DomainEvent;
import ddd.base.domain.EventListenerI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

import javax.annotation.PostConstruct;

/**
 * SimpleEventBus
 * date 2019/4/6
 */
@Component
public class SimpleEventBus {

  private final EventBus eventBus = new EventBus("tenancy");

  @Autowired
  private List<EventListenerI> listeners;

  public void register(EventListenerI listener) {
    eventBus.register(listener);
  }

  public void fire(DomainEvent event) {
    eventBus.post(event);
  }

  /**
   * 暂时未实现
   */
  public void asyncFire(DomainEvent event) {
    throw new RuntimeException("异步eventBus暂时不支持");
  }

  @PostConstruct
  public void init() {
    if (CollectionUtils.isEmpty(listeners)) {
      return;
    }
    listeners.forEach(listener -> eventBus.register(listener));
  }

}
