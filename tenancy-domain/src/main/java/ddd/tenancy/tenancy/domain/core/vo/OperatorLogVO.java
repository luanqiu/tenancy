package ddd.tenancy.tenancy.domain.core.vo;

import java.util.Date;

import ddd.base.domain.VO;

import lombok.Data;

/**
 * 操作记录
 * date 2019/4/6
 */
@Data
public class OperatorLogVO implements VO {

  private static final long serialVersionUID = -1L;

  /**
   * 操作人id
   */
  private SourceVO source;

  /**
   * 操作记录类型
   */
  private String type;

  /**
   * 操作记录业务id
   */
  private String bizId;

  /**
   * 业务的发生时间
   */
  private Date bizTime;

  /**
   * 记录的内容
   */
  private ContentVO content;


}
