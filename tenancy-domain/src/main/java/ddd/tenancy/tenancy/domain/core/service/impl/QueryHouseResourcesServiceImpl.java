package ddd.tenancy.tenancy.domain.core.service.impl;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import ddd.tenancy.tenancy.domain.core.entity.HousingResourcesEntity;
import ddd.tenancy.tenancy.domain.core.repository.HousingResourcesRepository;

/**
 * 查询房源的领域服务 演示
 * author  wenhe
 * date 2019/6/4
 */
@Service
public class QueryHouseResourcesServiceImpl {

  /**
   * 根据房屋编号查询房源信息
   * 稍微好一点的写法
   */
  public HousingResourcesEntity getByHousingId(String housingId) {
    return HousingResourcesEntity.get().getByHousingId(housingId);
  }


  @Resource
  private HousingResourcesRepository housingResourcesRepository;

  /**
   * 根据房屋编号查询房源信息
   * 非常糟糕的写法
   */
  public HousingResourcesEntity getByHousingIdBad(String housingId) {
    return housingResourcesRepository.getByHousingId(housingId);
  }

}
