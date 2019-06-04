package ddd.tenancy.tenancy.domain.support.appreciationservice.vo;

import ddd.base.domain.VO;

import lombok.Data;

/**
 * AppreciationServiceBuildVO
 * date 2019/4/6
 */
@Data
public class AppreciationServiceBuildVO implements VO {

  private static final long serialVersionUID = -1L;

  /**
  * 增值服务唯一标识
  */
  private String appreciationServiceId;

}
