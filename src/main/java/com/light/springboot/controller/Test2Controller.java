package com.light.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @descrption:
 * @author: bubbles
 */
@Controller
public class Test2Controller {

    @RequestMapping("/cros")
    public String cros() {
        return "cros";
    }

    @RequestMapping("/webscoket")
    public String webscoket() {
        return "webscoket";
    }


}
