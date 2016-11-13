package com.pantrychef.postgresql;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate4.SpringSessionContext;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.TransactionTemplate;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableJpaRepositories(basePackages = "com.pantrychef.repository")
@EnableTransactionManagement(proxyTargetClass = true)
public class JPAConfiguration {
	
	@Value("${database.url}")
	private String databaseUrl;
	
	@Value("${database.username}")
	private String databaseUsername;
	
	@Value("${database.password}")
	private String databasePassword;
	
	@Bean
	public DataSource dataSource() {
		HikariDataSource dataSource = new HikariDataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUsername(databaseUsername);
		dataSource.setPassword(databasePassword);	  
		dataSource.setJdbcUrl(databaseUrl);
		dataSource.setMaximumPoolSize(10);
		dataSource.setMinimumIdle(10);
		dataSource.setPoolName("pantrychef-core-pool");
		dataSource.setConnectionTimeout(20000);
		dataSource.setLeakDetectionThreshold(10000);		
		//dataSource.setMetricRegistry(metricRegistry);
		return dataSource;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(dataSource());
		entityManagerFactoryBean.setPackagesToScan("com.pantrychef.model");
		entityManagerFactoryBean.setJpaProperties(buildHibernateProperties());
		entityManagerFactoryBean.setJpaProperties(new Properties() {
			private static final long serialVersionUID = 1L;
			{
				put("hibernate.current_session_context_class", SpringSessionContext.class.getName());
			}
		});
		entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter() {
			{
				setDatabase(Database.POSTGRESQL);
			}
		});
		return entityManagerFactoryBean;
	}

	protected Properties buildHibernateProperties() {
		Properties hibernateProperties = new Properties();

		hibernateProperties.setProperty("hibernate.dialect", JsonPostgreSQLDialect.class.getCanonicalName());
		hibernateProperties.setProperty("hibernate.show_sql", "true");
		hibernateProperties.setProperty("hibernate.use_sql_comments", "false");
		hibernateProperties.setProperty("hibernate.format_sql", "false");

		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "create");
		hibernateProperties.setProperty("hibernate.generate_statistics", "false");
		hibernateProperties.setProperty("javax.persistence.validation.mode", "none");
		hibernateProperties.setProperty("hibernate.temp.use_jdbc_metadata_defaults", "false");

		// Audit History flags
		hibernateProperties.setProperty("org.hibernate.envers.store_data_at_delete", "true");
		hibernateProperties.setProperty("org.hibernate.envers.global_with_modified_flag", "true");

		return hibernateProperties;
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		return new JpaTransactionManager();
	}

	@Bean
	public TransactionTemplate transactionTemplate() {
		return new TransactionTemplate(transactionManager());
	}

}
