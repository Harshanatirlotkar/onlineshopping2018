package net.harsh.shoppingbackend_prac.test;


import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.harsh.shoppingbackend_prac.dao.CategoryDAO;
import net.harsh.shoppingbackend_prac.dto.Category;

public class CategoryTestCase {
	
	private static AnnotationConfigApplicationContext context;
	
	private static CategoryDAO categoryDAO;
	
	private Category category;
	
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("net.harsh.shoppingbackend_prac");
		context.refresh();
		categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
	}

	/*@Test
	public void testAddCategory()
	{
		category = new Category();
		category.setName("Speaker");
		category.setDescription("argjrghjrgh rrhrghrhghg");
		category.setImageURL("cat_1.png");
		
		assertEquals("Successfully aaded a category inside the table", true, categoryDAO.add(category));
		
	}*/
	
	
	/*@Test 
	public void testGetCategory()
	{
		category = categoryDAO.get(3);
		assertEquals("Successfully fetched  a single category from the table", "Mobile", category.getName());
	}*/
	
	/*@Test 
	public void testUpdateCategory()
	{
		category = categoryDAO.get(2);
		category.setName("TV");
		assertEquals("Successfully updated  a single category in the table",true, categoryDAO.update(category));
	}*/
	
	
	/*@Test 
	public void testDeleteCategory()
	{
		category = categoryDAO.get(33);
		
		assertEquals("Successfully deleted  a single category from the table",true, categoryDAO.delete(category));
	}*/
	
	/*@Test 
	public void testListCategory()
	{		
		assertEquals("Successfully fetched  a list  category from the table",9, categoryDAO.list().size());
	}*/
	
	
	@Test 
	public void testCRUDCategory()
	{	
		category = new Category();
		category.setName("Laptop");
		category.setDescription("argjrghjrgh rrhrghrhghg");
		category.setImageURL("cat_1.png");
		
		assertEquals("Successfully aaded a category inside the table", true, categoryDAO.add(category));
		
		category = new Category();
		category.setName("Television");
		category.setDescription("argjrghjrgh rrhrghrhghg");
		category.setImageURL("cat_2.png");
		
		assertEquals("Successfully aaded a category inside the table", true, categoryDAO.add(category));
		
		category = categoryDAO.get(2);
		category.setName("TV");
		assertEquals("Successfully updated  a single category in the table",true, categoryDAO.update(category));
		
		category = categoryDAO.get(2);
		
		assertEquals("Successfully deleted  a single category from the table",true, categoryDAO.delete(category));
		
		assertEquals("Successfully fetched  a list  category from the table",1, categoryDAO.list().size());
	}
	
}


