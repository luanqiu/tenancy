package ddd.tenancy.tenancy.common.exception;

public class TenancySpiException extends TenancyException {

  public TenancySpiException() {
    super();
  }

  public TenancySpiException(int code, String msg) {
    super(code, msg);
  }

  public TenancySpiException(Errors errors) {
    super(errors.getCode(), errors.getMessage());
  }

  public TenancySpiException(Throwable cause) {
    super(cause);
  }

  public TenancySpiException(String msg, Errors errors) {
    super(msg, errors);
  }
}
