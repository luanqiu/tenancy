package ddd.tenancy.tenancy.domain.support.appreciationservice.vo;

import ddd.base.domain.VO;

import lombok.Getter;
import lombok.experimental.Builder;

/**
 * 服务信息
 * date 2019/4/6
 */
@Getter
@Builder
public class ServiceInfoVO implements VO {

  private static final long serialVersionUID = -1L;

  /**
   * 租客备注
   */
  private String tenantRemark;


}
