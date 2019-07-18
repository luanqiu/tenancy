package ddd.tenancy.tenancy.domain.core.service.impl;

import com.google.common.base.Preconditions;

import ddd.base.domain.DomainService;
import ddd.tenancy.tenancy.common.exception.Errors;
import ddd.tenancy.tenancy.common.exception.TenancyPassException;
import ddd.tenancy.tenancy.domain.core.vo.moment.HoursingAddRequestMomentVO;
import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * 校验房源入参
 * date Jun 4, 2019 12:44:25 PM
 */
@Slf4j
@Service
public class CheckHousingParamsDomainService implements DomainService {

  /**
   * 参数校验
   */
  public void checkHousingParams(HoursingAddRequestMomentVO hoursingAddRequestMomentVO) {
    try {
      Preconditions
          .checkArgument(StringUtils.isNotBlank(hoursingAddRequestMomentVO.getPropertyFee()),
                         "物业费：propertyFee 不能为空");
      // 校验其他字段
    } catch (IllegalArgumentException e) {
      log.info("[CheckHousingParamsDomainService-checkHousingParams] 参数有误", e);
      throw new TenancyPassException(Errors.DEFAULT_PARAM_VALID_ERROR.getCode(), e.getMessage());
    }

  }
}
