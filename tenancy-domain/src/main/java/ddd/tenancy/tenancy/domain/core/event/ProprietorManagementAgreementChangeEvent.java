package ddd.tenancy.tenancy.domain.core.event;

import ddd.base.domain.DomainEvent;
import ddd.tenancy.tenancy.domain.core.entity.ProprietorManagementAgreementEntity;

import lombok.Data;

/**
 * ProprietorManagementAgreementChangeEvent
 * date 2019/4/6
 */
@Data
public class ProprietorManagementAgreementChangeEvent implements DomainEvent {

  private static final long serialVersionUID = -1L;

  private ProprietorManagementAgreementEntity proprietorManagementAgreementEntity;

  public ProprietorManagementAgreementChangeEvent(ProprietorManagementAgreementEntity proprietorManagementAgreementEntity) {
    this.proprietorManagementAgreementEntity = proprietorManagementAgreementEntity;
  }
}
