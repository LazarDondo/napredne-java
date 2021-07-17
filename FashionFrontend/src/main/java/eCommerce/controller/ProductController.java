/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eCommerce.controller;

import ECommerce.dao.CategoryDao;
import ECommerce.dao.ProductDao;
import ECommerce.dao.SupplierDao;
import ECommerce.model.Category;
import ECommerce.model.Product;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import javax.servlet.MultipartConfigElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;

/**
 *
 * @author Lazar
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductDao productDao;
    @Autowired
    CategoryDao categoryDao;
    @Autowired
    SupplierDao SupplierDao;

    @Bean
    public MultipartConfigElement multipartConfigElement() {
        return new MultipartConfigElement("");
    }

    @Bean
    public MultipartResolver multipartResolver() {
        org.springframework.web.multipart.commons.CommonsMultipartResolver multipartResolver = new org.springframework.web.multipart.commons.CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(10000000);
        return multipartResolver;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String showProduct(Model m) {
        Product p = new Product();
        m.addAttribute(p);
        List<Product> listProducts = productDao.listProducts();
        m.addAttribute("productList", listProducts);
        m.addAttribute("categoryList", categoryDao.listCategories());
        m.addAttribute("supplierList", SupplierDao.listSuppliers());
        m.addAttribute("pageInfo", "Product manager");
        return "Product";
    }

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public String addProduct(@RequestParam("prodName") String productName,
            @RequestParam("prodDesc") String productDescription, @RequestParam("prodPrice") int productPrice,
            @RequestParam("prodStock") int productStock, @RequestParam("prodCat") int productCategory,
            @RequestParam("prodSupp") int productSupplier, @RequestParam("prodImage") MultipartFile filedet, Model m) {

        Product product = new Product();
        product.setProductName(productName);
        product.setProductDescription(productDescription);
        product.setPrice(productPrice);
        product.setStock(productStock);
        product.setCategoryId(productCategory);
        product.setSupplierId(productSupplier);

        productDao.addProduct(product);
        Product product1 = new Product();
        m.addAttribute(product1);
        m.addAttribute("pageInfo", "Manager Product");
        m.addAttribute("categoryList", categoryDao.listCategories());

        String imagePath = "D:\\Users\\Lazar\\Documents\\NetBeansProjects\\FashionFrontend\\src\\main\\resources\\images\\";
        imagePath += String.valueOf(product.getProductId() + ".jpg");

        File image = new File(imagePath);

        if (!filedet.isEmpty()) {
            try {
                byte[] buff = filedet.getBytes();
                FileOutputStream fos = new FileOutputStream(image);
                BufferedOutputStream bos = new BufferedOutputStream(fos);
                bos.write(buff);
                bos.close();
            } catch (Exception e) {
                m.addAttribute("errorInfo", "Exception Occured during image uploading:" + e.getMessage());
            }
        } else {
            m.addAttribute("errorInfo", "Problem occured during image uploading!");
        }
        List<Product> listProducts = productDao.listProducts();
        m.addAttribute("productList", listProducts);
        return "Product";
    }

    @RequestMapping(path = "/update", method = RequestMethod.POST)
    public String updateProduct(@RequestParam("prodId") int productId, @RequestParam("prodName") String productName, @RequestParam("prodDesc") String productDescription,
            @RequestParam("prodPrice") int productPrice,
            @RequestParam("prodStock") int productStock, @RequestParam("prodCat") int productCategory,
            @RequestParam("prodSupp") int productSupplier, Model m) {
        Product product = productDao.getProduct(productId);
        System.out.println(product);
        product.setProductName(productName);
        product.setProductDescription(productDescription);
        product.setPrice(productPrice);
        product.setStock(productStock);
        product.setCategoryId(productCategory);
        product.setSupplierId(productSupplier);
        m.addAttribute("supplierList", SupplierDao.listSuppliers());

        productDao.updateProduct(product);
        Product product1 = new Product();
        m.addAttribute(product1);
        m.addAttribute("categoryList", categoryDao.listCategories());
        m.addAttribute("pageInfo", "Product manager");
        List<Product> listProducts = productDao.listProducts();
        m.addAttribute("productList", listProducts);
        return "Product";
    }

    @RequestMapping(path = "/delete/{productId}", method = RequestMethod.GET)
    public String deleteProduct(@PathVariable("productId") int productId, Model m) {
        productDao.deleteProduct(productDao.getProduct(productId));
        Product product1 = new Product();
        m.addAttribute(product1);
        m.addAttribute("categoryList", categoryDao.listCategories());
        m.addAttribute("pageInfo", "Product manager");
        List<Product> listProducts = productDao.listProducts();
        m.addAttribute("productList", listProducts);
        return "Product";
    }

    @RequestMapping(path = "/edit/{productId}", method = RequestMethod.GET)
    public String editProduct(@PathVariable("productId") int productId, Model m) {
        Product product = productDao.getProduct(productId);
        Product product1 = new Product();
        m.addAttribute("product", product);
        m.addAttribute("categoryList", categoryDao.listCategories());
        m.addAttribute("supplierList", SupplierDao.listSuppliers());
        m.addAttribute("pageInfo", "Product manager");
        return "UpdateProduct";
    }

    @RequestMapping(path = "/display", method = RequestMethod.GET)
    public String displayAllProducts(Model m) {
        m.addAttribute("pageInfo", "Product info");
        List<Product> listProducts = productDao.listProducts();
        m.addAttribute("productList", listProducts);
        return "ProductDisplay";
    }

    @RequestMapping(path = "/display/{productId}")
    public String totalProductDisplay(@PathVariable("productId") int productId, Model m) {
        m.addAttribute("pageInfo", "Product info");
        Product product = productDao.getProduct(productId);
        m.addAttribute("product", product);
        return "TotalProductDisplay";
    }

}
