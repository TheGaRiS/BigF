package bot.bigf.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DbConfig extends DefaultDbConfig {

    @Bean
    @Qualifier("bot-db")
    @ConfigurationProperties(prefix = "app.db.bot-db")
    SpringDataJdbcProperties gitlabJdbcProperties() {
        return new SpringDataJdbcProperties();
    }

    @Bean
    @Qualifier("bot-db")
    public DataSource gitlabDataSource(@Qualifier("bot-db") SpringDataJdbcProperties properties) {
        return hikariDataSource("db", properties);
    }

    @Bean
    @Qualifier("bot-db")
    JdbcTemplate gitlabJdbcTemplate(@Qualifier("bot-db") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }



}