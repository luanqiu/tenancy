package ddd.tenancy.tenancy.common.exception;

public class TenancyDomainException extends TenancyException {

  public TenancyDomainException() {
    super();
  }

  public TenancyDomainException(int code, String msg) {
    super(code, msg);
  }

  public TenancyDomainException(int code,Exception errors) {
    super(code+"",errors);
  }

  public TenancyDomainException(Errors errors) {
    super(errors.getCode(), errors.getMessage());
  }

  public TenancyDomainException(Errors errors, Throwable cause) {
    super(errors, cause);
  }

  public TenancyDomainException(String msg, Errors errors) {
    super(msg, errors);
  }
}
