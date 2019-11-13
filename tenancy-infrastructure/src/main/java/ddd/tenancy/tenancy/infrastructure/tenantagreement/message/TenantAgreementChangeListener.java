package ddd.tenancy.tenancy.infrastructure.tenantagreement.message;

import com.google.common.eventbus.Subscribe;

import ddd.base.domain.EventListenerI;
import ddd.tenancy.tenancy.domain.core.event.TenantAgreementChangeEvent;
import org.springframework.stereotype.Component;

/**
 * TenantAgreementChangeListener
 * date Jun 4, 2019 12:44:25 PM
 */
@Component
public class TenantAgreementChangeListener implements EventListenerI<TenantAgreementChangeEvent> {

  @Subscribe
  @Override
  public void execute(TenantAgreementChangeEvent event) {

  }

}
