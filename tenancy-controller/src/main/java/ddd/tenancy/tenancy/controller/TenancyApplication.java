package ddd.tenancy.tenancy.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import ddd.tenancy.tenancy.infrastructure.MyBatisConfig;

/**
* TenancyApplication
*author  wenhe
*date 2019/8/10
*/
@Import(MyBatisConfig.class)
@SpringBootApplication(scanBasePackages = {"ddd.tenancy.tenancy","ddd.base"})
public class TenancyApplication {

  public static void main(String[] args) {
    SpringApplication.run(TenancyApplication.class);
  }


}
