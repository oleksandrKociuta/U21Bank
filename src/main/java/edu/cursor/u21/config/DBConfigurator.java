package edu.cursor.u21.config;

import org.hibernate.ejb.HibernatePersistence;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by vk on 3/20/17.
 */
    @Configuration
    @EnableJpaRepositories("edu.cursor.u21.dao")
    public class DBConfigurator {


        @Value("${init-db:false}")
        private String initDatabase;
        @Value("${jdbc.driverClassName}")
        private String driverName;
        @Value("${jdbc.url}")
        private String url;
        @Value("${jdbc.username}")
        private String username;
        @Value("${jdbc.password}")
        private String pass;
        @Value("${db.hibernate.show_sql}")
        private String PROP_HIBERNATE_SHOW_SQL;
        @Value("${db.hibernate.dialect}")
        private String PROP_HIBERNATE_DIALECT;
        @Value("${db.hibernate.hbm2ddl.auto}")
        private String PROP_HIBERNATE_HBM2DDL_AUTO;


        @Bean
        public DataSource dataSource() {
            DriverManagerDataSource dataSource = new DriverManagerDataSource();
            dataSource.setDriverClassName(driverName);
            dataSource.setUrl(url);
            dataSource.setUsername(username);
            dataSource.setPassword(pass);
            return dataSource;
        }

        @Bean
        public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
            LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
            entityManagerFactoryBean.setDataSource(dataSource());
            entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistence.class);
            entityManagerFactoryBean.setPackagesToScan("edu.cursor.u21.users");

            entityManagerFactoryBean.setJpaProperties(getHibernateProperties());

            return entityManagerFactoryBean;
        }

        @Bean
        public JpaTransactionManager transactionManager() {
            JpaTransactionManager transactionManager = new JpaTransactionManager();
            transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());

            return transactionManager;
        }

        private Properties getHibernateProperties() {
            Properties properties = new Properties();
            properties.put(PROP_HIBERNATE_DIALECT, PROP_HIBERNATE_DIALECT);
            properties.put(PROP_HIBERNATE_SHOW_SQL, PROP_HIBERNATE_SHOW_SQL);
            properties.put(PROP_HIBERNATE_HBM2DDL_AUTO, PROP_HIBERNATE_HBM2DDL_AUTO);

            return properties;
        }

        @Bean
        public CacheManager cacheManager() {
            return new ConcurrentMapCacheManager();
        }
}
