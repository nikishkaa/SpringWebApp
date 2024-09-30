package org.example;

import org.example.model.Login;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;

@Controller
public class HelloController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView hello(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        modelAndView.addObject(new Login()); // stub
        return modelAndView;
    }

    @RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
    public ModelAndView login(@ModelAttribute("login") Login login){
        ModelAndView modelAndView = new ModelAndView();
        // Validation
        if(!Objects.isNull(login)){
            if(login.getLogin().equalsIgnoreCase("Bob")
                    && login.getPassword().equalsIgnoreCase("123")){
                modelAndView.setViewName("welcome");
                modelAndView.addObject("firstName", login.getLogin());
                return modelAndView;
            }
        }
        modelAndView.setViewName("login");
        modelAndView.addObject("msg", "Incorrect User Name or Password!");
        return modelAndView;
    }

    @RequestMapping("/test")
    public ModelAndView test(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("test");
        modelAndView.addObject("msg", "TEST MESSAGE");
        return modelAndView;
    }




    @RequestMapping(value = "/hello_world", method = RequestMethod.GET)
    public String printHelloWorld(ModelMap modelMap) {

        // добавляем атрибут для загрузки modelMap
        modelMap.addAttribute("message",
                "Hello World and welcome to Spring MVC!");

        // возвращаем имя файла для загрузки "hello_world.jsp"
        return "hello_world";
    }

}