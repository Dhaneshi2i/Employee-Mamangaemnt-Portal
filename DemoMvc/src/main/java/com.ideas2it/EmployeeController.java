package com.ideas2it;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Controller
public class EmployeeController {
    @RequestMapping("/view")
    public ModelAndView employee(HttpServletResponse response, HttpServletRequest request){

        String name = request.getParameter("t1");
        String id = request.getParameter("t2");

        ModelAndView mv = new ModelAndView();
        mv.setViewName("view.jsp");
        mv.addObject("Name", name);
        mv.addObject("Id", id);

        return mv;
    }
}
