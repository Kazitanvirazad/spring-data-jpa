package com.springdatajpa.app.config;

import java.util.Properties;

import javax.sql.DataSource;
import org.hibernate.cfg.Environment;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {
		"com.springdatajpa.app.repo.mysql" }, transactionManagerRef = "transactionManager", entityManagerFactoryRef = "entityManager")
@PropertySource("classpath:application.properties")
public class PersistentConfig {

	private final String PROPERTY_SHOW_SQL = "hibernate.show_sql";
	private final String PROPERTY_DIALECT = "hibernate.dialect";

	@Value("${spring.jpa.database-platform}")
	private String dialect;

	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String hbm2ddlAuto;

	@Value("${spring.jpa.show-sql}")
	private String showSql;

	@Value("${spring.datasource.url}")
	private String url;

	@Value("${spring.datasource.username}")
	private String user;

	@Value("${spring.datasource.password}")
	private String password;

	@Value("${spring.datasource.driver-class-name}")
	private String driverClassName;

	private DataSource dataSource;

	@Bean(name = "datasource")
	public DataSource getDatasource() {
		Properties properties = new Properties();
		properties.put(Environment.SHOW_SQL, showSql);
		properties.put(Environment.ENABLE_LAZY_LOAD_NO_TRANS, true);
		properties.put(Environment.HBM2DDL_AUTO, org.hibernate.tool.schema.Action.VALIDATE);
		properties.put(Environment.DIALECT, dialect);
		properties.put("user", user);
		properties.put("password", password);
		DriverManagerDataSource dataSource = new DriverManagerDataSource(url, properties);
		dataSource.setDriverClassName(driverClassName);
		this.dataSource = dataSource;
		return this.dataSource;
	}

	@Bean(name = "entityManager")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		Properties properties = new Properties();
		properties.setProperty(PROPERTY_DIALECT, dialect);
		properties.setProperty(PROPERTY_SHOW_SQL, showSql);

		LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		localContainerEntityManagerFactoryBean.setDataSource(getDatasource());
		localContainerEntityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		localContainerEntityManagerFactoryBean.setPackagesToScan("com.springdatajpa.app.dao");
		localContainerEntityManagerFactoryBean.setJpaProperties(properties);
		return localContainerEntityManagerFactoryBean;
	}

	@Bean(name = "transactionManager")
	@DependsOn(value = "entityManager")
	public JpaTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return transactionManager;
	}

}
