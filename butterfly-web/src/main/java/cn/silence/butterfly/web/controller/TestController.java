package cn.silence.butterfly.web.controller;

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
public class TestController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello world";
    }
}
