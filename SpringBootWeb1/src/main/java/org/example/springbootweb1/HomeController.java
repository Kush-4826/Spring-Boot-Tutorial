package org.example.springbootweb1;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String index(){
        return "index.jsp";
    }

    @RequestMapping("add")
    public String add(@RequestParam("num1") int num, int num2, HttpSession session) {

//        int num1 = Integer.parseInt(request.getParameter("num1"));
//        int num2 = Integer.parseInt(request.getParameter("num2"));
        int res = num + num2;
        session.setAttribute("res", res);
        return "add.jsp";
    }
}
