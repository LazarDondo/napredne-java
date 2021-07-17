/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eCommerce.controller;

import ECommerce.dao.CartDao;
import ECommerce.dao.ProductDao;
import ECommerce.model.CartItem;
import ECommerce.model.Product;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Lazar
 */
@Controller
@RequestMapping("/cart")
@ComponentScan("ECommerce")
public class CartController {

    @Autowired
    CartDao cartDao;

    @Autowired
    ProductDao productDao;

    @RequestMapping(method = RequestMethod.GET)
    public String showCart(Model m, HttpSession session) {
        String username = (String) session.getAttribute("username");
        List<CartItem> cartItems = cartDao.listCartItems(username);

        m.addAttribute("cartItems", cartItems);
        m.addAttribute("grandTotal", getGrandTotal(cartItems));
        return "Cart";
    }

    @RequestMapping(path = "add/{productId}")
    public String addToCart(@PathVariable("productId") int productId, @RequestParam("quantity") int quantity,
            HttpSession session, Model m) {
        Product product = productDao.getProduct(productId);
        String username = (String) session.getAttribute("username");

        CartItem cartItem = new CartItem();
        cartItem.setProductId(productId);
        cartItem.setProductName(product.getProductName());
        cartItem.setQuantity(quantity);
        cartItem.setPrice(product.getPrice());
        cartItem.setPaymentStatus("NP");
        cartItem.setUsername(username);

        cartDao.addCartItem(cartItem);
        List<CartItem> cartItems = cartDao.listCartItems(username);
        m.addAttribute("cartItems", cartItems);
        m.addAttribute("grandTotal", getGrandTotal(cartItems));
        return "Cart";
    }

    @RequestMapping(path = "update/{cartItemID}")
    public String updateCartItem(@PathVariable("cartItemID") int cartItemID, @RequestParam("quantity") int quantity,
            HttpSession session, Model m) {
        CartItem cartItem = cartDao.getCartItem(cartItemID);
        cartItem.setQuantity(quantity);

        cartDao.updateCartItem(cartItem);

        String username = (String) session.getAttribute("username");
        List<CartItem> cartItems = cartDao.listCartItems(username);
        m.addAttribute("cartItems", cartItems);
        m.addAttribute("cartItems", cartItems);
        m.addAttribute("grandTotal", getGrandTotal(cartItems));
        return "Cart";
    }

    @RequestMapping(path = "delete/{cartItemID}")
    public String deleteCartItem(@PathVariable("cartItemID") int cartItemID, HttpSession session, Model m) {

        CartItem cartItem = cartDao.getCartItem(cartItemID);
        cartDao.deleteCartItem(cartItem);

        String username = (String) session.getAttribute("username");
        List<CartItem> cartItems = cartDao.listCartItems(username);
        m.addAttribute("cartItems", cartItems);
        m.addAttribute("cartItems", cartItems);
        m.addAttribute("grandTotal", getGrandTotal(cartItems));
        return "Cart";
    }
    
    @RequestMapping(path="/cart/")

    private int getGrandTotal(List<CartItem> cartItems) {
        int grandTotal = 0, count = 0;
        for (CartItem cartItem : cartItems) {
            grandTotal += cartItem.getQuantity() * cartItem.getPrice();
        }
        return grandTotal;
    }

}
