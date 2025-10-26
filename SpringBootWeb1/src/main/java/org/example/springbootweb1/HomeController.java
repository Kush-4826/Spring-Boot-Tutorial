package org.example.springbootweb1;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String index(){
        return "index.jsp";
    }

    @RequestMapping("add")
    public String add(HttpServletRequest request, HttpSession session) {

        int num1 = Integer.parseInt(request.getParameter("num1"));
        int num2 = Integer.parseInt(request.getParameter("num2"));
        int res = num1 + num2;
        session.setAttribute("res", res);
        return "add.jsp";
    }
}
