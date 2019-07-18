package ddd.tenancy.tenancy.common.exception;


import ddd.tenancy.tenancy.api.common.OutErrorEnum;

public interface IErrors {

  Integer getCode();

  String getMessage();

  OutErrorEnum getOutErrorEnum();

}