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
		"com.springdatajpa.app.repo.pg" }, transactionManagerRef = "transactionManagePG", entityManagerFactoryRef = "entityManagerPG")
@PropertySource("classpath:application.properties")
public class PersistentConfigPG {
	private final String PROPERTY_SHOW_SQL = "hibernate.show_sql";
	private final String PROPERTY_DIALECT = "hibernate.dialect";

	@Value("${spring.jpa.pg.database-platform}")
	private String pgdialect;

	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String hbm2ddlAuto;

	@Value("${spring.jpa.show-sql}")
	private String showSql;

	@Value("${spring.datasource.pg.url}")
	private String pgurl;

	@Value("${spring.datasource.pg.username}")
	private String pguser;

	@Value("${spring.datasource.pg.password}")
	private String pgpassword;

	@Value("${spring.datasource.pg.driver-class-name}")
	private String pgDriverClassName;

	private DataSource pgDataSource;

	@Bean(name = "datasourcePG")
	public DataSource getPGDatasource() {
		Properties properties = new Properties();
		properties.put(Environment.SHOW_SQL, showSql);
		properties.put(Environment.ENABLE_LAZY_LOAD_NO_TRANS, true);
		properties.put(Environment.HBM2DDL_AUTO, org.hibernate.tool.schema.Action.VALIDATE);
		properties.put(Environment.DIALECT, pgdialect);
		properties.put("user", pguser);
		properties.put("password", pgpassword);
		DriverManagerDataSource dataSource = new DriverManagerDataSource(pgurl, properties);
		dataSource.setDriverClassName(pgDriverClassName);
		this.pgDataSource = dataSource;
		return this.pgDataSource;
	}

	@Bean(name = "entityManagerPG")
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryPG() {
		Properties properties = new Properties();
		properties.setProperty(PROPERTY_DIALECT, pgdialect);
		properties.setProperty(PROPERTY_SHOW_SQL, showSql);

		LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		localContainerEntityManagerFactoryBean.setDataSource(getPGDatasource());
		localContainerEntityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		localContainerEntityManagerFactoryBean.setPackagesToScan("com.springdatajpa.app.dao");
		localContainerEntityManagerFactoryBean.setJpaProperties(properties);
		return localContainerEntityManagerFactoryBean;
	}

	@Bean(name = "transactionManagePG")
	@DependsOn(value = "entityManagerPG")
	public JpaTransactionManager transactionManagePG() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactoryPG().getObject());
		return transactionManager;
	}
}
