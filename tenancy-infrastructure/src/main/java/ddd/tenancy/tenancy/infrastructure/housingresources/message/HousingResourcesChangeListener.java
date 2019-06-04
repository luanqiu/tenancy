package ddd.tenancy.tenancy.infrastructure.housingresources.message;

import ddd.base.domain.EventListenerI;
import ddd.tenancy.tenancy.domain.core.event.HousingResourcesChangeEvent;
import org.springframework.stereotype.Component;

/**
 * HousingResourcesChangeListener
 * date Jun 4, 2019 12:44:25 PM
 */
@Component
public class HousingResourcesChangeListener implements EventListenerI<HousingResourcesChangeEvent> {

  @Override
  public void execute(HousingResourcesChangeEvent event) {

  }

}
