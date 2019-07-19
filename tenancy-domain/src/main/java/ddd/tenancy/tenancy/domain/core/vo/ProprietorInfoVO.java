package ddd.tenancy.tenancy.domain.core.vo;

import ddd.base.domain.VO;

import lombok.Data;
import lombok.Getter;

/**
 * 业主信息
 * date 2019/4/6
 */
@Data
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

  /**
   * 是否是房源的合法主人
   */
  private Boolean ownHousingLegal;


}
