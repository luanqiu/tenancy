package ddd.tenancy.tenancy.common.exception;

public class TenancyBizException extends TenancyException {

  public TenancyBizException() {
    super();
  }

  public TenancyBizException(int code, String msg) {
    super(code, msg);
  }

  public TenancyBizException(Errors errors) {
    super(errors.getCode(), errors.getMessage());
  }

  public TenancyBizException(Errors errors, Throwable cause) {
    super(errors, cause);
  }

  public TenancyBizException(Errors errors, String extraMsg) {
    super(errors.getCode(), String.format("%s,%s", errors.getMessage(), extraMsg));
  }

  public TenancyBizException(String extraMsg, Errors errors) {
    super(extraMsg,errors);
  }

}
