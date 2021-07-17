/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eCommerce.controller;

import ECommerce.dao.CategoryDao;
import ECommerce.dao.CategoryDaoImpl;
import ECommerce.model.Category;
import java.util.List;
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
@RequestMapping("/category")
@ComponentScan("ECommerce")
public class CategoryController {
    
    
    @Autowired
    CategoryDao categoryDao;
    
     @RequestMapping(method=RequestMethod.GET)
    public String showContactUs(Model m){
         List<Category> listCategories=categoryDao.listCategories();
         m.addAttribute("listCategories",listCategories);
         m.addAttribute("pageinfo","AboutUs");
        return "Category";
    }
    
    @RequestMapping(path="/add",method=RequestMethod.POST)
    public String addCategory(Model m,@RequestParam("catName") String categoryName,
    @RequestParam("catDesc") String categoryDescription){
        
        Category category=new Category();
        category.setCategoryName(categoryName);
        category.setCategoryDescription(categoryDescription);
        categoryDao.addCategory(category);
        List<Category> listCategories=categoryDao.listCategories();
         m.addAttribute("listCategories",listCategories);
        m.addAttribute("pageinfo","Manage Category");
        return "Category";
    }
    
      @RequestMapping(path="/update",method=RequestMethod.POST)
    public String updateCategory(Model m,@RequestParam("catId") int categoryId,
    @RequestParam("catName") String categoryName, @RequestParam("catDesc") String categoryDescription){
        
        Category category=categoryDao.getCategory(categoryId);
        category.setCategoryId(categoryId);
        category.setCategoryName(categoryName);
        category.setCategoryDescription(categoryDescription);
        categoryDao.updateCategory(category);
        List<Category> listCategories=categoryDao.listCategories();
         m.addAttribute("listCategories",listCategories);
        m.addAttribute("pageinfo","Manage Category");
        return "Category";
    }
    
       @RequestMapping(path="/delete/{categoryId}",method=RequestMethod.GET)
    public String deleteCategory(Model m,@PathVariable("categoryId") int categoryId){
        
        Category category=categoryDao.getCategory(categoryId);
        categoryDao.deleteCategory(category);
        List<Category> listCategories=categoryDao.listCategories();
         m.addAttribute("listCategories",listCategories);
        m.addAttribute("pageinfo","Manage Category");
        return "Category";
    }
    
    @RequestMapping(path="/edit/{categoryId}",method=RequestMethod.GET)
    public String editCategory(Model m,@PathVariable("categoryId") int categoryId){
        Category category=categoryDao.getCategory(categoryId);
        //categoryDao.updateCategory(category);
        m.addAttribute("category",category);
         m.addAttribute("pageinfo","Manage Category");
        return "UpdateCategory";
    }
    
}
    
   
