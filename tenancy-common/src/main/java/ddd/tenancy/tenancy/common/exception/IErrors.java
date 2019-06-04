package ddd.tenancy.tenancy.common.exception;


public interface IErrors {

  Integer getCode();

  String getMessage();

  OutErrorEnum getOutErrorEnum();

}