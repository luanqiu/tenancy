package ddd.tenancy.tenancy.infrastructure.appreciationservice.message;

import ddd.base.domain.EventListenerI;
import ddd.tenancy.tenancy.domain.support.appreciationservice.event.AppreciationServiceChangeEvent;
import org.springframework.stereotype.Component;

/**
 * AppreciationServiceChangeListener
 * date Jun 4, 2019 12:44:25 PM
 */
@Component
public class AppreciationServiceChangeListener implements EventListenerI<AppreciationServiceChangeEvent> {

  @Override
  public void execute(AppreciationServiceChangeEvent event) {

  }

}
