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
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

 
@Configuration
@ComponentScan("com.niit.collabackEnd" )
@EnableTransactionManagement

public class HibernateConfig {



	
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
        dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
        dataSource.setUsername("Revti");	        
        dataSource.setPassword("revti");
        return dataSource;
    }
    
	
	
	private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect"); 
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.format_sql", "true");
        properties.put("hibernate.hbm2ddl.auto", "update");
        return properties;        
    }
    
		
	    @Bean(name="sessionFactory")
	    public SessionFactory sessionFactory(DataSource dataSource) {
	        LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource());	        
	        builder.addProperties(hibernateProperties());
	        builder.scanPackages("com.niit.collabackEnd.model");
	        
	      //  builder.addAnnotatedClasses(Product.class);
	        return builder.buildSessionFactory();
	     }
	
		 
		 
	    @Autowired
	    @Bean(name="transactionManager")
	    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
	       HibernateTransactionManager txManager = new HibernateTransactionManager();
	       txManager.setSessionFactory(sessionFactory);
	       return txManager;
	    }
	}