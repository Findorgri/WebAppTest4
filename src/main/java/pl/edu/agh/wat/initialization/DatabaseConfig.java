package pl.edu.agh.wat.configuration;


import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Configuring our repository for testing, use spring boot
 */




@Configuration

public class DatabaseConfig {

    @Value("${spring.datasource.uri}")
    private String databaseUri;

    @Bean
    public DataSource dataSource() throws URISyntaxException {
        org.apache.tomcat.jdbc.pool.DataSource dataSource = new org.apache.tomcat.jdbc.pool.DataSource();

        URI dbUri = new URI(databaseUri);

        dataSource.setUsername(dbUri.getUserInfo().split(":")[0]);
        dataSource.setPassword(dbUri.getUserInfo().split(":")[1]);
        dataSource.setUrl("jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath());

        configureDataSource(dataSource);

        return dataSource;
    }

    void configureDataSource(org.apache.tomcat.jdbc.pool.DataSource dataSource) {
        dataSource.setMaxActive(20);
        dataSource.setMaxIdle(8);
        dataSource.setMinIdle(8);
        dataSource.setTestOnBorrow(false);
        dataSource.setTestOnReturn(false);
        dataSource.setValidationQuery("SELECT 1");
    }
}
