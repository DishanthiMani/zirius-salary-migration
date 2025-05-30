package com.zirius.zerp.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.*;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "com.zirius.zerp.repository.salary",
        entityManagerFactoryRef = "salaryEntityManagerFactory",
        transactionManagerRef = "salaryTransactionManager"
)
public class SalaryDbConfig {

    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource.salary")
    public DataSourceProperties salaryDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    public DataSource salaryDataSource() {
        return salaryDataSourceProperties().initializeDataSourceBuilder().build();
    }



    @Bean(name = "salaryEntityManagerFactory")
    @Primary
    public LocalContainerEntityManagerFactoryBean salaryEntityManagerFactory(
            EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(salaryDataSource())
                .packages("com.zirius.zerp.model.salary")
                .persistenceUnit("salary")
                .build();
    }

    @Bean(name = "salaryTransactionManager")
    @Primary
    public PlatformTransactionManager salaryTransactionManager(
            final @Qualifier("salaryEntityManagerFactory") LocalContainerEntityManagerFactoryBean factory) {
        return new JpaTransactionManager(factory.getObject());
    }
}
