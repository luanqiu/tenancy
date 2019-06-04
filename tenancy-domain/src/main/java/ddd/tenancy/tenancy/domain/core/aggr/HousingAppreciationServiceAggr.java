package ddd.tenancy.tenancy.domain.core.aggr;

import ddd.base.domain.Aggr;
import ddd.base.domain.DomainFactory;
import ddd.base.domain.VO;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import ddd.tenancy.tenancy.domain.core.entity.HousingResourcesEntity;
import ddd.tenancy.tenancy.domain.support.appreciationservice.entity.AppreciationServiceEntity;

/**
 * HousingAppreciationServiceAggr
 * !!!important 禁止直接注入该对象，强烈建议get方法
 * date Jun 4, 2019 12:44:25 PM
 */
@Slf4j
@Data
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class HousingAppreciationServiceAggr implements Aggr<HousingResourcesEntity> {

  @Resource
  private DomainFactory<VO, HousingAppreciationServiceAggr> housingAppreciationServiceAggrFactory;

  @Override
  public HousingResourcesEntity getAggrRoot() {
    return housingResourcesEntity;
  }

  @Resource
  private HousingResourcesEntity housingResourcesEntity;

  @Resource
  private AppreciationServiceEntity appreciationServiceEntity;

  /**
  * 查询看房记录
  */
  public void queryHouseInspectionLog() {

  }

  /**
   *
   * @param vo
   * @return
   */
  public HousingAppreciationServiceAggr get(VO vo) {
    return housingAppreciationServiceAggrFactory.perfect(vo);
  }

  /**
   * 最简单的得到自己新的实例
   * 复杂的请使用Factory
   */
  public static final HousingAppreciationServiceAggr get() {
    return DomainFactory.get(HousingAppreciationServiceAggr.class);
  }

}
