package cn.silence.butterfly.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author rainofsilence
 * @since 2023/4/16 23:40
 */
@EnableWebMvc
@SpringBootApplication
@ComponentScan(basePackages = "cn.silence.butterfly.*")
@MapperScan(basePackages = "cn.silence.butterfly.**.mapper")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
