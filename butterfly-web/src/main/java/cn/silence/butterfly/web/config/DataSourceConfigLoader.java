package cn.silence.butterfly.web.config;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.io.File;
import java.nio.charset.Charset;

/**
 * @author rainofsilence
 * @version 1.0.0
 * @since 2023/06/13 23:30:48
 */
@Component
public class DataSourceConfigLoader implements BeanPostProcessor, EnvironmentAware {

    private ConfigurableEnvironment environment;

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = (ConfigurableEnvironment) environment;
    }

    @SneakyThrows
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof MybatisAutoConfiguration) {
            String rootDir = System.getProperty("user.dir");
            String config = FileUtils.readFileToString(
                    new File(rootDir + File.separator + "butterfly-web/src/main/resources/db.json"),
                    Charset.defaultCharset());
            JSONObject configJson = JSON.parseObject(config);
            DataSourceProperties dataSourceProperties = new DataSourceProperties();

            dataSourceProperties.setType(com.zaxxer.hikari.HikariDataSource.class);
            dataSourceProperties.setDriverClassName(configJson.getString("driver-class-name"));
            dataSourceProperties.setUrl(configJson.getString("url"));
            dataSourceProperties.setUsername(configJson.getString("username"));
            dataSourceProperties.setPassword(configJson.getString("password"));

            environment.getSystemProperties().put("spring.datasource.type", "com.zaxxer.hikari.HikariDataSource");
            environment.getSystemProperties().put("spring.datasource.driver-class-name", configJson.getString("driver-class-name"));
            environment.getSystemProperties().put("spring.datasource.url", configJson.getString("url"));
            environment.getSystemProperties().put("spring.datasource.username", configJson.getString("username"));
            environment.getSystemProperties().put("spring.datasource.password", configJson.getString("password"));
        }

        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }
}
