package ddd.tenancy.tenancy.domain.core.event;

import ddd.base.domain.DomainEvent;
import ddd.tenancy.tenancy.domain.core.entity.TenantAgreementEntity;

import lombok.Data;

/**
 * TenantAgreementChangeEvent
 * date 2019/4/6
 */
@Data
public class TenantAgreementChangeEvent implements DomainEvent {

  private static final long serialVersionUID = -1L;

  private TenantAgreementEntity tenantAgreementEntity;

  public TenantAgreementChangeEvent(TenantAgreementEntity tenantAgreementEntity) {
    this.tenantAgreementEntity = tenantAgreementEntity;
  }
}
