package ddd.tenancy.tenancy.domain.support.appreciationservice.event;

import ddd.base.domain.DomainEvent;
import ddd.tenancy.tenancy.domain.support.appreciationservice.entity.AppreciationServiceEntity;

import lombok.Data;

/**
 * AppreciationServiceChangeEvent
 * date 2019/4/6
 */
@Data
public class AppreciationServiceChangeEvent implements DomainEvent {

  private static final long serialVersionUID = -1L;

  private AppreciationServiceEntity appreciationServiceEntity;

  public AppreciationServiceChangeEvent(AppreciationServiceEntity appreciationServiceEntity) {
    this.appreciationServiceEntity = appreciationServiceEntity;
  }
}
