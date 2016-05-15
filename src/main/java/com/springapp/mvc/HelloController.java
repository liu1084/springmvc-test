package com.springapp.mvc;

import com.springapp.mvc.model.Shop;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/")
@EnableWebMvc
public class HelloController {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        model.addAttribute("message", "Hello world!");
        return "hello";
    }

    @RequestMapping(value = "/shop/id/{id}", method = RequestMethod.GET)
    public @ResponseBody Shop show(@PathVariable String id, HttpServletResponse response) {
        response.setHeader("Content-Type", "text/json;charset=utf-8");
        Shop shop = new Shop();
        shop.setName(id);
        return shop;
    }
}