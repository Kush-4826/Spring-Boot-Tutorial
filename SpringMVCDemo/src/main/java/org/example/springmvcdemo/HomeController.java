package org.example.springmvcdemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("add")
    public ModelAndView add(@RequestParam("num1") int num, int num2, ModelAndView modelAndView) {

//        int num1 = Integer.parseInt(request.getParameter("num1"));
//        int num2 = Integer.parseInt(request.getParameter("num2"));
        int res = num + num2;
//        model.addAttribute("res", res);
//        return "add";

        modelAndView.addObject("res", res);
        modelAndView.setViewName("add");
        return modelAndView;
    }

//    @RequestMapping("addAlien")
//    public ModelAndView addAlien(@RequestParam("id") int id, @RequestParam("name") String name, ModelAndView modelAndView) {
//
//        Alien alien = new Alien(id, name);
//
//        modelAndView.addObject("alien", alien);
//        modelAndView.setViewName("add");
//        return modelAndView;
//    }

    @RequestMapping("addAlien")
    public ModelAndView addAlien(@ModelAttribute Alien alien, ModelAndView modelAndView) {

//        Alien alien = new Alien(id, name);
//
//        modelAndView.addObject("alien", alien);
        modelAndView.setViewName("add");
        return modelAndView;
    }
}
