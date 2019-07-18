package ddd.tenancy.tenancy.app.hoursingresources.add;

import ddd.base.domain.Application;
import ddd.tenancy.tenancy.api.hoursingresources.dto.HoursingAddRequestDTO;
import ddd.tenancy.tenancy.api.hoursingresources.dto.HoursingAddResponseDTO;
import ddd.tenancy.tenancy.common.utils.BeanCopierUtils;
import ddd.tenancy.tenancy.domain.core.entity.HousingResourcesEntity;
import ddd.tenancy.tenancy.domain.core.service.impl.CheckHousingParamsDomainService;
import ddd.tenancy.tenancy.domain.core.service.impl.CheckProprietorDomainService;
import ddd.tenancy.tenancy.domain.core.service.impl.CheckHouseLegalityDomainService;
import ddd.tenancy.tenancy.domain.core.vo.HousingResourcesBuildVO;
import ddd.tenancy.tenancy.domain.core.vo.moment.HoursingAddRequestMomentVO;

import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.Resource;

/**
 * HouseAddApplication
 * 2019.07.18 简单版本。缺少幂等、并发、等等内容
 * date Jun 4, 2019 12:44:25 PM
 */
@Component
public class HouseAddApplication
    implements Application<HoursingAddRequestDTO, HoursingAddResponseDTO> {

  @Resource
  private CheckHousingParamsDomainService checkHousingParamsDomainService;

  @Resource
  private CheckProprietorDomainService checkProprietorDomainService;

  @Resource
  private CheckHouseLegalityDomainService checkHouseLegalityDomainService;

  @Resource
  private TransactionTemplate transactionTemplate;

  @Override
  public HoursingAddResponseDTO doAction(HoursingAddRequestDTO request) {
    HoursingAddRequestMomentVO hoursingAddRequestMomentVO = new HoursingAddRequestMomentVO();
    BeanCopierUtils.copyProperties(hoursingAddRequestMomentVO, request);

    // step 0：入参校验
    checkHousingParamsDomainService.checkHousingParams(hoursingAddRequestMomentVO);

    // step 1：校验业主有效信息
    checkProprietorDomainService.checkProprietor(hoursingAddRequestMomentVO.getProprietorId(),
                                                 hoursingAddRequestMomentVO.getProprietorName());

    // step 2：校验房源合法性
    checkHouseLegalityDomainService.checkHouseLegality(hoursingAddRequestMomentVO);

    // step 3：事务中操作
    /**
     *  hoursingAddRequestMomentVO 转化成了 HousingResourcesBuildVO
     *  你也可以完全不转，hoursingAddRequestMomentVO 是整个流程中所有 step 都可使用的 vo
     *  HousingResourcesBuildVO 仅仅是创建 entity 时的 VO ，如果两者一致，不需要转化的
     *  在我们这个流程里面，其实是不用转化的，这里演示一下转的情况
     *  <br/>
     *  本地事务开启，如果 application 做的事情很少，可以直接使用注解在 doAction 上直接开启注解,
     *  也可以手动开启注解，可以把本地事务的开启工作交给流程引擎
     */
    HousingResourcesEntity housingResourcesEntity =
        transactionTemplate.execute(status -> {
          // step 3-1：实体入库
          HousingResourcesEntity entity = HousingResourcesEntity.get()
              .createHousingResources(HousingResourcesBuildVO.buildFromHoursingAddRequestMomentVO(
                  hoursingAddRequestMomentVO));
          // step 3-2：操作记录入库
          entity.addOperatorLog(hoursingAddRequestMomentVO);
          return entity;
        });

    // step 4：事件通知
    housingResourcesEntity.notifyEntity();

    // step 5：返回
    HoursingAddResponseDTO responseDTO = HoursingAddResponseDTO.buildBaseSuccess(HoursingAddResponseDTO.class);
    responseDTO.setHousingId(housingResourcesEntity.getHousingId());
    return responseDTO;
  }


}
