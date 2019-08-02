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

  @Override
  public HousingResourcesEntity getAggrRoot() {
    return housingResourcesEntity;
  }

  @Resource
  private DomainFactory<VO, HousingAppreciationServiceAggr> housingAppreciationServiceAggrFactory;

  private HousingResourcesEntity housingResourcesEntity;

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

  /**
   * 房源创建
   */
  // 聚合的不同写法
//  public HousingResourcesEntity createHousingResources(
//      HousingResourcesBuildVO housingResourcesBuildVO,
//      HousingResourcesRepository housingResourcesRepository) {
//    try {
//      HousingResourcesEntity housingResourcesEntity =
//          HousingResourcesEntity.get().
//              createHousingResources2(housingResourcesBuildVO);
//
//      housingResourcesRepository.insert(housingResourcesEntity);
//      return housingResourcesEntity;
//    } catch (TenancySpiException e) {
//      throw new TenancyDomainException(Errors.DEFAULT_PARAM_VALID_ERROR.getCode(), e.getMessage());
//    } catch (TenancyDomainException e) {
//      throw e;
//    } catch (Exception e) {
//      throw new TenancyDomainException(Errors.DEFAULT_PARAM_VALID_ERROR.getCode(), e.getMessage());
//    }
//  }

  /**
   * 更新房源
   */
  public void updateHousingResources(VO vo) {
      HousingResourcesEntity.get().updateHousingResources(vo);
  }

  /**
   * 可租校验
   */
  public void checkRent(VO vo) {
    HousingResourcesEntity.get().checkRent(vo);
  }

  /**
   * 校验房源合法性
   */
  public void checkHousingLegality(VO vo) {
    HousingResourcesEntity.get().checkHousingLegality(vo);
  }

}
