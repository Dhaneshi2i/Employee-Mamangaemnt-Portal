package jbr.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jbr.springmvc.dao.UserDao;
import jbr.springmvc.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private UserDao userDao;

    //@RequestMapping(value = "/newContact", method = RequestMethod.GET)
    @RequestMapping(value="/")
    public ModelAndView listContact(ModelAndView model) throws IOException {
        List<Contact> listContact = userDao.list();
        //ModelAndView mav = new ModelAndView("login");
        model.addObject("listContact", listContact);
        model.setViewName("home");

        return model;
    }

    @RequestMapping(value="/newContact", method = RequestMethod.GET)
    public ModelAndView newContact(ModelAndView model){
        Contact newContact = new Contact();
        model.addObject("contact", newContact);
        model.setViewName("ContactForm");
        return model;
    }

    @RequestMapping(value = "/saveContact", method = RequestMethod.POST)
    public ModelAndView saveContact(@ModelAttribute Contact contact){
        userDao.save(contact);
        return new ModelAndView("redirect:/");
    }

}
