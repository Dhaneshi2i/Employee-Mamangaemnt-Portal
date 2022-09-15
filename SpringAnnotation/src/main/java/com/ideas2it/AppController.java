package com.ideas2it;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Controller
public class AppController {
    @RequestMapping("/add")
    public ModelAndView add(@RequestParam("t1") int i,@RequestParam("t2") int k, HttpServletRequest request, HttpServletResponse response) {

        //int i = Integer.parseInt(request.getParameter("t1"));
        //int k = Integer.parseInt(request.getParameter("t2"));
        int s=i+k;

        ModelAndView mv = new ModelAndView();
        mv.setViewName("display");
        mv.addObject("Result",s);

        return mv;
    }
}