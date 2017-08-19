package com.niit.collabackEnd.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages="com.niit.collabackEnd")
public class HibernateConfig {
//create an instance
 @Bean
   public LocalSessionFactoryBean sessionFactory() {
       LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
       sessionFactory.setDataSource(dataSource());
       sessionFactory.setPackagesToScan(new String[] { "com.niit.collabackEnd.model" });
       sessionFactory.setHibernateProperties(hibernateProperties());
       return sessionFactory;
    }
   @Bean
   public DataSource dataSource() {
       DriverManagerDataSource dataSource = new DriverManagerDataSource();
       dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
       dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
       dataSource.setUsername("colla");
       dataSource.setPassword("colla");
       return dataSource;
   }
    
   private Properties hibernateProperties() {
       Properties properties = new Properties();
       properties.put("hibernate.dialect","org.hibernate.dialect.Oracle10gDialect");
       properties.put("hibernate.show_sql",true);
       properties.put("hibernate.format_sql",true);
       properties.put("hibernate.hbm2ddl.auto", "update");
       return properties;        
   }
    
   @Bean
   @Autowired
   public HibernateTransactionManager transactionManager(SessionFactory s) {
      HibernateTransactionManager txManager = new HibernateTransactionManager();
      txManager.setSessionFactory(s);
      return txManager;
   }
}