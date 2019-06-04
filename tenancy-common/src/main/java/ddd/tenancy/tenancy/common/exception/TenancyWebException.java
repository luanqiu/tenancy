package ddd.tenancy.tenancy.common.exception;


public class TenancyWebException extends TenancyException {

  public TenancyWebException() {
    super();
  }

  public TenancyWebException(int code, String msg) {
    super(code, msg);
  }

  public TenancyWebException(Errors errors) {
    super(errors.getCode(), errors.getMessage());
  }

  public TenancyWebException(Errors errors, Throwable cause) {
    super(errors, cause);
  }

  public TenancyWebException(Throwable cause) {
    super(cause);
  }

  public TenancyWebException(String msg, Errors errors) {
    super(msg, errors);
  }
}
