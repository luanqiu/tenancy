package ddd.tenancy.tenancy.domain.core.factory;

import ddd.base.domain.DomainFactory;
import ddd.tenancy.tenancy.domain.core.entity.HousingResourcesEntity;
import ddd.tenancy.tenancy.domain.core.service.impl.CheckHousingOwnDomainService;
import ddd.tenancy.tenancy.domain.core.vo.HousingResourcesBuildVO;
import ddd.tenancy.tenancy.domain.core.vo.PropertyInformationVO;
import ddd.tenancy.tenancy.domain.core.vo.ProprietorInfoVO;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * HousingResourcesFactory
 * perfect 简单的构造示范
 * date 2019/4/6
 */
@Component
public class HousingResourcesEntityFactory implements DomainFactory<HousingResourcesBuildVO, HousingResourcesEntity> {

  @Resource
  private CheckHousingOwnDomainService checkHousingOwnDomainService;

  @Override
  public HousingResourcesEntity perfect(HousingResourcesBuildVO vo) {
    HousingResourcesEntity entity = HousingResourcesEntity.get();
    entity.setHousingId("");
    // 实体大多数属性都来自于入参
    entity.setAddress(vo.getAddress());
    entity.setProprietorId(vo.getProprietorId());
    ProprietorInfoVO proprietorInfo = new ProprietorInfoVO();
    proprietorInfo.setProprietorId(vo.getProprietorId());
    /**
     * 实体的有些属性，需要调用领域服务进行查询，封装，才能得到。
     * 一般来说，在工厂里面进行这种调用完全没有问题。
     * 但这个工厂如果是在事务中，通过领域服务调用远程服务就不太恰当。
     * 这时候我们就会把调用领域服务提前，把结果放到 vo 中，然后在传递下来
     */
    proprietorInfo.setOwnHousingLegal(
        checkHousingOwnDomainService.checkHousingOwn(vo.getProprietorId(), vo.getAddress()));

    // 像这样
    proprietorInfo.setOwnHousingLegal(vo.getOwnHousingLegal());
    entity.setProprietorInfo(proprietorInfo);

    PropertyInformationVO propertyInformationVO = PropertyInformationVO.builder()
        .propertyFee(vo.getPropertyFee())
        .propertyName(vo.getPropertyName())
        .build();
    entity.setPropertyInformation(propertyInformationVO);

    return entity;
  }
}
