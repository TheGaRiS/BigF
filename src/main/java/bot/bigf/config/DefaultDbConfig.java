package bot.bigf.config;

import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;

import javax.sql.DataSource;

@Slf4j
public class DefaultDbConfig {

        protected DataSource hikariDataSource(String tag, SpringDataJdbcProperties properties) {
            log.info("[{}] настройки БД: [{}]", tag, properties.toString());

            HikariDataSource ds = new HikariDataSource();
            ds.setJdbcUrl(properties.getUrl());
            ds.setDriverClassName(properties.getDriver());
            ds.setUsername(properties.getUser());
            ds.setPassword(properties.getPassword());
            ds.setMaximumPoolSize(Integer.parseInt(properties.getPoolSize()));
            return ds;
    }
}
