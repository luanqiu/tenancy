package ddd.tenancy.tenancy.common.exception;

import java.text.MessageFormat;

import lombok.Data;
import lombok.Getter;

/**
 * TenancyException
 * date 2019/4/6
 */
@Data
public class TenancyException extends RuntimeException {

  private static final long serialVersionUID = 1623708858076767443L;


  private static final String SEPARATOR = "";

  @Getter
  private int code;

  /**
   * 不建议用这个构造器
   */
  @Deprecated
  public TenancyException() {
    super();
  }

  public TenancyException(String msg) {
    super(msg);
  }

  public TenancyException(Throwable cause) {
    super(cause);
  }

  public TenancyException(String msg, Throwable cause) {
    super(msg, cause);
  }

  public TenancyException(int code, String msg, Throwable cause) {
    super(SEPARATOR + msg, cause);
    this.code = code;
  }

  public TenancyException(String msgFormat, Object... replacement) {
    super(MessageFormat.format(msgFormat, replacement));
  }

  public TenancyException(String msgFormat, Throwable cause, Object... replacement) {
    super(MessageFormat.format(msgFormat, replacement), cause);
  }

  public TenancyException(int code, String msgFormat, Object... replacement) {
    super(SEPARATOR + MessageFormat.format(msgFormat, replacement));
    this.code = code;
  }

  public TenancyException(int code, String msgFormat, Throwable cause, Object... replacement) {
    super(SEPARATOR + MessageFormat.format(msgFormat, replacement), cause);
    this.code = code;
  }

  public TenancyException(Errors errors) {
    super(SEPARATOR + errors.getMessage());
    this.code = errors.getCode();
  }

  public TenancyException(Errors errors, Throwable cause) {
    super(SEPARATOR + errors.getMessage(), cause);
    this.code = errors.getCode();
  }

  public TenancyException(Errors errors, Object... replacement) {
    super(SEPARATOR + MessageFormat.format(errors.getMessage(), replacement));
    this.code = errors.getCode();
  }

  public TenancyException(String msg, Errors errors) {
    super(errors.getMessage() + "-" + msg);
    this.code = errors.getCode();
  }

}
