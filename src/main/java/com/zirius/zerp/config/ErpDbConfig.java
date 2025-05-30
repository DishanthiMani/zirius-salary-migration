package com.zirius.zerp.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "com.zirius.zerp.repository.erp",
        entityManagerFactoryRef = "erpEntityManagerFactory",
        transactionManagerRef = "erpTransactionManager"
)
public class ErpDbConfig {

    @Value("${erp.datasource.url}")
    private String url;

    @Value("${erp.datasource.username}")
    private String username;

    @Value("${erp.datasource.password}")
    private String password;

    @Bean
    public DataSource erpDataSource() {
        return DataSourceBuilder.create()
                .url(url)
                .username(username)
                .password(password)
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean erpEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(erpDataSource())
                .packages("com.zirius.zerp.model.erp")
                .persistenceUnit("erp")
                .build();
    }

    @Bean
    public PlatformTransactionManager erpTransactionManager(
            @Qualifier("erpEntityManagerFactory") EntityManagerFactory erpEntityManagerFactory) {
        return new JpaTransactionManager(erpEntityManagerFactory);
    }
}
