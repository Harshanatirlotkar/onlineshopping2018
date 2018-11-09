package net.harsh.onlineshopping_prac.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.harsh.onlineshopping_prac.exception.ProductNotFoundException;
import net.harsh.shoppingbackend_prac.dao.CategoryDAO;
import net.harsh.shoppingbackend_prac.dao.ProductDAO;
import net.harsh.shoppingbackend_prac.dto.Category;
import net.harsh.shoppingbackend_prac.dto.Product;

@Controller
public class PageController {
	
	private static final Logger logger = LoggerFactory.getLogger(PageController.class);
	
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping(value = {"/", "/home", "/index"})
	public ModelAndView index(){
		ModelAndView mv = new ModelAndView ("page");
		mv.addObject("title", "Home");
		
		logger.info("inside page controller index method - info");
		logger.debug("inside page controller index method - debug");
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("userClickHome", true);
		return mv;
	}
	
	@RequestMapping(value = "about")
	public ModelAndView about(){
		ModelAndView mv = new ModelAndView ("page");
		mv.addObject("title", "About Us");
		mv.addObject("userClickAbout", true);
		return mv;
	}
	
	
	@RequestMapping(value = "/contact")
	public ModelAndView contact(){
		ModelAndView mv = new ModelAndView ("page");
		mv.addObject("title", "Contact Us");
		mv.addObject("userClickContact", true);
		return mv;
	}
	//methods to load all products
	@RequestMapping(value = "/show/all/products")
	public ModelAndView showAllProducts(){
		ModelAndView mv = new ModelAndView ("page");
		mv.addObject("title", "All Products");
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("userClickAllProducts", true);
		return mv;
	}
	
	//methods to load all products
		@RequestMapping(value = "/show/category/{id}/products")
		public ModelAndView showCategoryProducts(@PathVariable("id") int id ){
			ModelAndView mv = new ModelAndView ("page");
			
			// categotyDAO to fetch single category
			Category category = null;
			category = categoryDAO.get(id);
			//paasing list of category
			mv.addObject("title", category.getName());
			
			//passing the single category
			mv.addObject("category", category);
			mv.addObject("categories", categoryDAO.list());
			mv.addObject("userClickCategoryProducts", true);
			return mv;
		}
	
		
		
		
	@RequestMapping(value = "/test")
	public ModelAndView test(@RequestParam(value="greeting",required=false )String greeting ){
		if(greeting == null)
		{
			greeting = "hello from project";
		}	
		ModelAndView mv = new ModelAndView ("page");
		mv.addObject("greeting", greeting);
		return mv;
	}
	
	@RequestMapping(value = "/show/{id}/product")
	public ModelAndView showSingleProduct(@PathVariable("id")int id ) throws ProductNotFoundException{
		ModelAndView mv = new ModelAndView ("page");
		
		Product product = productDAO.get(id);
		
		if(product == null) throw new ProductNotFoundException();
		
		product.setViews(product.getViews() + 1);
		productDAO.update(product);
		
		mv.addObject("title", product.getName());
		mv.addObject("product", product);
		mv.addObject("userClickShowProduct",true);
		
		
		return mv;
	}
	
	@RequestMapping(value = "/test1/{greeting}")
	public ModelAndView test1(@PathVariable("greeting")String greeting ){
		if(greeting == null)
		{
			greeting = "hello from project";
		}	
		ModelAndView mv = new ModelAndView ("page");
		mv.addObject("greeting", greeting);
		return mv;
	}
}
