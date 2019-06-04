package ddd.tenancy.tenancy.common.exception;

public class TenancyINFException extends TenancyException {

  public TenancyINFException() {
    super();
  }

  public TenancyINFException(int code, String msg) {
    super(code, msg);
  }

  public TenancyINFException(Errors errors) {
    super(errors.getCode(), errors.getMessage());
  }

  public TenancyINFException(String msg, Errors errors) {
    super(msg, errors);
  }
}
