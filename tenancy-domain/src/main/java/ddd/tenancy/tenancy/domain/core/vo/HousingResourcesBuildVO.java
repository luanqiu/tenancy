package ddd.tenancy.tenancy.domain.core.vo;

import ddd.base.domain.VO;

import lombok.Data;

/**
 * HousingResourcesBuildVO
 * date 2019/4/6
 */
@Data
public class HousingResourcesBuildVO implements VO {

  private static final long serialVersionUID = -1L;

  /**
  * 房源唯一标识
  */
  private String housingId;

  /**
  * 房源地址
  */
  private String address;

  /**
  * 业主id
  */
  private String proprietorId;

}
