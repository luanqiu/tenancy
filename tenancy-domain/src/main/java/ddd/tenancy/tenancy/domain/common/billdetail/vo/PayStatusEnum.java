package ddd.tenancy.tenancy.domain.common.billdetail.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * PayStatusEnum
 * author  wenhe
 * date 2019/6/4
 */
@Getter
@AllArgsConstructor
public enum PayStatusEnum {
  SUCCESS("success", "成功"),
  FAIL("fail", "成功"),
  UNKNOWN("unknown", "成功"),

  ;

  private String code;
  private String desc;

}
