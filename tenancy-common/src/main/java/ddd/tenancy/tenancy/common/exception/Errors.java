package ddd.tenancy.tenancy.common.exception;


import lombok.Getter;

/**
 * Errors
 * date 2019/4/6
 */
@Getter
public enum Errors {

  /********************************
   * 保留的基本异常
   *********************************/
  DEFAULT_PARAM_VALID_ERROR(1000000000, "{0}", OutErrorEnum.PAYAMS_ERROR),

  /********************************
   * BIZ 异常(必须都有对应的OutErrorEnum)
   *********************************/

  /********************************
   * DOMAIN 异常
   *********************************/

  /********************************
   * SPI 异常
   *********************************/

  /********************************
   * COMMON 异常
   *********************************/

  /********************************
   * WEB 异常

   /********************************
   * INFRASTRUCTURE 异常
   *********************************/

  END(99999999, "end", OutErrorEnum.COMMON_ERROR);

  private Integer code;
  private String message;
  private OutErrorEnum outErrorEnum;

  public Integer getCode() {
    return code;
  }

  public String getMessage() {
    return message;
  }

  public OutErrorEnum getOutErrorEnum() {
    return outErrorEnum;
  }

  Errors(Integer code, String message, OutErrorEnum outErrorEnum) {
    this.code = code;
    this.message = message;
    this.outErrorEnum = outErrorEnum;
  }

  /**
   * 通过code查找枚举
   */
  public static Errors findByCode(Integer code) {
    for (Errors item : values()) {
      if (item.code.equals(code)) {
        return item;
      }
    }
    return null;
  }

}
