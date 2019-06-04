package ddd.tenancy.tenancy.common.exception;

import lombok.Getter;

/**
* 外部错误码枚举
*author  likongpeng
*date 2019/4/6
*/
@Getter
public enum OutErrorEnum {

  COMMON_ERROR("9999", "服务器去月球了,请重试~"),
  COMMON_SUCCESS("0000", "成功"),
  COMMON_ALREADY_SUCCESS("0000", "请求已受理，请乎重复发起请求~"),
  SAME_REQUEST("0001", "你的操作太快了,请慢点~"),
  PAYAMS_ERROR("0008", "入参错误，请重试~"),
;

  private String code;
  private String message;

  OutErrorEnum(String code, String message) {
    this.code = code;
    this.message = message;
  }

  /**
   * 通过code查找枚举
   */
  public static OutErrorEnum findByCode(String code) {
    for (OutErrorEnum item : values()) {
      if (item.code.equals(code))
        return item;
    }
    return null;
  }

}
