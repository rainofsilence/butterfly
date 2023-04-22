package cn.silence.butterfly.web.controller;

import cn.silence.butterfly.core.exception.BizAssert;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author rainofsilence
 * @version 1.0.0
 * @since 2023/04/18 22:34:03
 */
@RestController
@RequestMapping("")
@Slf4j
public class TestController {

    @GetMapping("/hello")
    public String sayHello() {
        log.info("TestController.sayHello run");
        return "Hello world";
    }

    @GetMapping("/getUserName")
    public String getUserName(String id) {
        BizAssert.notNull(id, "id must be not null");
        return id;
    }
}
