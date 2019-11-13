package ddd.tenancy.tenancy.infrastructure.proprietormanagementagreement.message;

import com.google.common.eventbus.Subscribe;

import ddd.base.domain.EventListenerI;
import ddd.tenancy.tenancy.domain.core.event.ProprietorManagementAgreementChangeEvent;
import org.springframework.stereotype.Component;

/**
 * ProprietorManagementAgreementChangeListener
 * date Jun 4, 2019 12:44:25 PM
 */
@Component
public class ProprietorManagementAgreementChangeListener implements EventListenerI<ProprietorManagementAgreementChangeEvent> {

  @Subscribe
  @Override
  public void execute(ProprietorManagementAgreementChangeEvent event) {

  }

}
