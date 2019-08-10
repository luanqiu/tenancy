package ddd.tenancy.tenancy.infrastructure;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = {
    "ddd.tenancy.tenancy.infrastructure.common.dal",
    "ddd.tenancy.tenancy.infrastructure.housingresources.dal",
},
    sqlSessionFactoryRef = MyBatisConfig.SESSIONFACTORY_NAME)
public class MyBatisConfig {

  /**SqlSessionFactory名称.*/
  public final static String SESSIONFACTORY_NAME = "sqlSessionFactory";

  /**mapper.xml文件路径，必须与其他SqlSessionFactory-mapper路径区分.*/
  public final static String MAPPER_XML_PATH = "classpath:mybatis/mapper/*.xml";

  @Autowired
  private DataSourceProperties dataSourceProperties;

  @Bean(name = "dataSource")
  public DataSource dataSource() {
    //建议封装成单独的类
    DruidDataSource dataSource = new DruidDataSource();
    dataSource.setValidationQuery("SELECT 1");
    dataSource.setValidationQueryTimeout(2000);
    dataSource.setUrl(dataSourceProperties.getUrl());
    System.err.println(dataSourceProperties.getUrl());
    dataSource.setDriverClassName(dataSourceProperties.getDriverClassName());
    dataSource.setUsername(dataSourceProperties.getUsername());
    dataSource.setPassword(dataSourceProperties.getPassword());

    return dataSource;

  }

  //默认Bean首字母小写，简化配置
  //将SqlSessionFactory作为Bean注入到Spring容器中，成为配置一部分。
  @Bean
  public SqlSessionFactory sqlSessionFactory() throws Exception {
    SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
    sqlSessionFactoryBean.setDataSource(dataSource());
    sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MAPPER_XML_PATH));
    return sqlSessionFactoryBean.getObject();
  }

}