package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @RequestMapping("/start.ing")
    public String test() {
        System.out.println("start 요청");

       return "hello";
    }

}