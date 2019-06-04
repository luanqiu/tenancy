package ddd.tenancy.tenancy.domain.core.vo;

import ddd.base.domain.VO;

import lombok.Getter;
import lombok.experimental.Builder;

/**
 * 操作记录
 * date 2019/4/6
 */
@Getter
@Builder
public class OperatorLogVO implements VO {

  private static final long serialVersionUID = -1L;

  /**
   * 操作人id
   */
  private String operatorLogId;

  /**
   * 操作者
   */
  private String operatorId;


}
