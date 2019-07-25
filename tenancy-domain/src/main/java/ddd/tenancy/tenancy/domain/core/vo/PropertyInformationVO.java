package ddd.tenancy.tenancy.domain.core.vo;

import ddd.base.domain.VO;

import lombok.Builder;
import lombok.Getter;

/**
 * 物业信息
 * date 2019/4/6
 */
@Getter
@Builder
public class PropertyInformationVO implements VO {

  private static final long serialVersionUID = -1L;

  /**
   * 物业名称
   */
  private String propertyName;

  /**
   * 物业费
   */
  private String propertyFee;

  /**
   * 这个是演示的默认值，忽略
   */
  @Builder.Default
  private String demoDefaultValue ="defaultDemo";

}
