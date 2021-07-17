/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eCommerce.controller;

import ECommerce.dao.ProductDao;
import ECommerce.model.Product;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Lazar
 */
@Controller()

public class UserController {

    @Autowired
    ProductDao productDao;

    @RequestMapping(path="/user",method = RequestMethod.GET)
    public String showUserHome(Model m, HttpSession session) {
        m.addAttribute("pageInfo", "Product Catalog");
        List<Product> productsList = productDao.listProducts();
        m.addAttribute("productsList", productsList);
        return "UserHome";
    }

    @RequestMapping(path = "/login_success")
    public String login(Model m, HttpSession session) {
        String page = "";
        boolean loggedIn = false;
        SecurityContext securityContext = SecurityContextHolder.getContext();

        Authentication authentication = securityContext.getAuthentication();
        String username = authentication.getName();
        Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) authentication.getAuthorities();

        for (GrantedAuthority authority : authorities) {
            session.setAttribute("role", authority.getAuthority());
            if (authority.getAuthority().equals("admin")) {
                loggedIn = true;
                page = "AdminHome";
                session.setAttribute("loggedIn", loggedIn);
                session.setAttribute("username", username);
            } else {
                m.addAttribute("pageInfo", "User home");
                List<Product> productsList = productDao.listProducts();
                m.addAttribute("productsList", productsList);
                loggedIn = true;
                page = "UserHome";
                session.setAttribute("loggedIn", loggedIn);
                session.setAttribute("username", username);
            }
        }
        System.out.println(page);
        return page;
    }

}
