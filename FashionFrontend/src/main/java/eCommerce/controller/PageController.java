/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eCommerce.controller;

import ECommerce.dao.UserDao;
import ECommerce.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Lazar
 */
@Controller
@RequestMapping
public class PageController {
    
    @Autowired UserDao userDao;
    
    @RequestMapping(path="/login",method=RequestMethod.GET)
    public String showLogin(Model m){
        m.addAttribute("pageinfo","Login");
        return "Login";
    }
    @RequestMapping(path="/register",method=RequestMethod.GET)
    public String showRegister(Model m){
         m.addAttribute("pageinfo","Registration");
        return "Registration";
    }
    
    @RequestMapping(path="/reg",method=RequestMethod.POST)
    public String performRegistration(@RequestParam("customerName") String customerName, 
            @RequestParam("address") String address, @RequestParam("username") String username,
            @RequestParam("password") String password){
        User user=new User();
        user.setCustomerName(customerName);
        user.setCustomerAddress(customerName);
        user.setUsername(username);
        user.setPassword(password);
        userDao.addUser(user);
        return "Login";
    }
    
    @RequestMapping(path="/home",method=RequestMethod.GET)
    public String showHome(Model m){
         m.addAttribute("pageinfo","Login");
        return "Home";
    }
    @RequestMapping(path="/aboutus",method=RequestMethod.GET)
    public String showAboutUs(Model m){
         m.addAttribute("pageinfo","Login");
        return "AboutUs";
    }
    @RequestMapping(path="/contactus",method=RequestMethod.GET)
    public String showContactUs(Model m){
         m.addAttribute("pageinfo","Login");
        return "ContactUs";
    }
    
    
    
}
