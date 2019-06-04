package ddd.tenancy.tenancy.common.exception;

/**
 * 无需预警
 */
public class TenancyPassException extends TenancyException {

  public TenancyPassException() {
    super();
  }

  public TenancyPassException(int code, String msg) {
    super(code, msg);
  }

  public TenancyPassException(Errors errors) {
    super(errors.getCode(), errors.getMessage());
  }

  public TenancyPassException(Errors errors, Throwable cause) {
    super(errors, cause);
  }

  public TenancyPassException(Throwable cause) {
    super(cause);
  }

  public TenancyPassException(String msg) {
    super(msg);
  }

  public TenancyPassException(String msg, Errors errors) {
    super(msg, errors);
  }
}
