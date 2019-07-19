package ddd.tenancy.tenancy.domain.core.service.impl;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import ddd.base.domain.DomainService;
import ddd.tenancy.tenancy.domain.core.service.HousePropertyAdminService;

/**
* 查询业主是否是房源的真实拥有者
*author  wenhe
*date 2019/7/19
*/
@Service
public class CheckHousingOwnDomainService implements DomainService {

  @Resource
  private HousePropertyAdminService housePropertyAdminService;

  /**
   * 查询业主是否是房源的真实拥有者
   * @param proprietorId
   * @param address
   * @return
   */
  public Boolean checkHousingOwn(String proprietorId,String address){
    return housePropertyAdminService.checkHousingOwn(proprietorId,address);
  }

}
