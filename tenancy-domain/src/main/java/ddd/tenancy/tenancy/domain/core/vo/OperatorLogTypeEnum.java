package ddd.tenancy.tenancy.domain.core.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * OperatorLogTypeEnum
 * author  wenhe
 */
@Getter
@AllArgsConstructor
public enum OperatorLogTypeEnum {

  OPERATOR_LOG("OPERATOR_LOG", "操作记录"),;

  private String type;
  private String desc;

}
