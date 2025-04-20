package com.jugiyul.village;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String hello() {
        return "동네 서비스가 잘 돌아가고 있어요!";
    }
}
