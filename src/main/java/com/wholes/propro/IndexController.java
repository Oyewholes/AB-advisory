package com.wholes.propro;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {
    @RequestMapping(value = "home.html", method = RequestMethod.GET)
    public String requestMethodName(@RequestParam(name = "param", required = false) String param) {
        return "home";    }
    
    public String home() {
        return "home";
    }

}

