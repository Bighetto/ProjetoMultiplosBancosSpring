package projectspring.estudo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@PropertySource({"classpath:application.properties"})
@EnableJpaRepositories(entityManagerFactoryRef = "dblocal2EntityManagerFactory",
        basePackages = {"projectspring.estudo.repository.dblocal2"}, transactionManagerRef = "dblocal2TransactionManager")
public class dblocal2Config {


    @Value("jdbc:mysql://localhost:3307/dblocal2")
    private String url;

    @Value("root")
    private String username;

    @Value("teste")
    private String password;

    @Bean
    @ConfigurationProperties(prefix = "dblocal2.datasource")
    public DataSource dblocal2DataSource() {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean dblocal2EntityManagerFactory() {
        System.out.println("loading config dblocal2");
        final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setPackagesToScan("projectspring.estudo.model.dblocal2");
        em.setPersistenceUnitName("NamePassword");
        em.setPersistenceUnitName("IdEmail");
        em.setDataSource(dblocal2DataSource());

        final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        final HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        em.setJpaPropertyMap(properties);

        return em;
    }

    @Bean
    public PlatformTransactionManager dblocal2TransactionManager() {
        final JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(dblocal2EntityManagerFactory().getObject());
        return transactionManager;
    }

}

