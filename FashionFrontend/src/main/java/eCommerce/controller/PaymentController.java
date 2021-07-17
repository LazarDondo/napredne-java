/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eCommerce.controller;

import ECommerce.dao.CartDao;
import ECommerce.dao.OrderDao;
import ECommerce.dao.ProductDao;
import ECommerce.dao.UserDao;
import ECommerce.model.CartItem;
import ECommerce.model.OrderDetail;
import ECommerce.model.User;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Lazar
 */
@Controller
public class PaymentController {

    @Autowired
    CartDao cartDao;

    @Autowired
    ProductDao productDao;

    @Autowired
    UserDao userDao;

    @Autowired
    OrderDao orderDao;

    @RequestMapping(path = "/checkout")
    public String checkOut(Model m, HttpSession session) {
        String username = (String) session.getAttribute("username");
        List<CartItem> cartItems = cartDao.listCartItems(username);

        m.addAttribute("cartItems", cartItems);
        m.addAttribute("grandTotal", grandTotal(cartItems));

        User user = userDao.getUser(username);
        String address = user.getCustomerAddress();
        m.addAttribute("address", address);

        return "OrderConfirmation";

    }

    @RequestMapping(path = "/address/update", method = RequestMethod.POST)
    public String updateAddress(@RequestParam("address") String address, Model m, HttpSession session) {
        String username = (String) session.getAttribute("username");
        List<CartItem> cartItems = cartDao.listCartItems(username);
        m.addAttribute("cartItems", cartItems);
        m.addAttribute("grandTotal", grandTotal(cartItems));
        User user = userDao.getUser(username);
        user.setCustomerAddress(address);
        userDao.updateUser(user);

        String customerAddress = user.getCustomerAddress();
        m.addAttribute("address", customerAddress);
        return "OrderConfirmation";

    }
    
    @RequestMapping(path = "/receipt")
    public String showReceipt(@RequestParam("rd") String rd, Model m, HttpSession session) {
        String username = (String) session.getAttribute("username");
        
        OrderDetail orderDetail=new OrderDetail();
        orderDetail.setOrderDate(new Date());
        orderDetail.setShippingAdress(userDao.getUser(username).getCustomerAddress());
        orderDetail.setTransaction(rd);
        orderDetail.setUsername(username);
        
        List<CartItem> cartItems = cartDao.listCartItems(username);
        m.addAttribute("cartItems",cartItems);
        m.addAttribute("grandTotal",grandTotal(cartItems));
        
        User user = userDao.getUser(username);
        orderDetail.setTotalAmount(grandTotal(cartItems));
        
        orderDao.saveOrder(orderDetail);
        for (CartItem cartItem : cartItems) {
            cartItem.setPaymentStatus("P");
            cartDao.updateCartItem(cartItem);
        }
        System.out.println(user.getCustomerAddress()+"===================================");
        m.addAttribute("user",user);
        m.addAttribute("orderDetail",orderDetail);
        
        return "Receipt";
    }

    
    @RequestMapping(path="/payment")
    public String paymentPage(){
        return "Payment";
    }

    private int grandTotal(List<CartItem> cartItems) {
        int grandTotal = 0;
        for (CartItem cartItem : cartItems) {
            grandTotal += cartItem.getPrice() * cartItem.getQuantity();
        }
        return grandTotal;
    }

}
