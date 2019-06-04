package ddd.tenancy.tenancy.domain.core.vo;

import ddd.base.domain.VO;

import lombok.Getter;
import lombok.experimental.Builder;

/**
 * 业主信息
 * date 2019/4/6
 */
@Getter
@Builder
public class ProprietorInfoVO implements VO {

  private static final long serialVersionUID = -1L;

  /**
   * 业主标识
   */
  private String proprietorId;

  /**
   * 业主名称
   */
  private String name;


}
