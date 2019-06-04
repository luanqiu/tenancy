package ddd.tenancy.tenancy.domain.core.event;

import ddd.base.domain.DomainEvent;
import ddd.tenancy.tenancy.domain.core.entity.HousingResourcesEntity;

import lombok.Data;

/**
 * HousingResourcesChangeEvent
 * date 2019/4/6
 */
@Data
public class HousingResourcesChangeEvent implements DomainEvent {

  private static final long serialVersionUID = -1L;

  private HousingResourcesEntity housingResourcesEntity;

  public HousingResourcesChangeEvent(HousingResourcesEntity housingResourcesEntity) {
    this.housingResourcesEntity = housingResourcesEntity;
  }
}
