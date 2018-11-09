package net.harsh.shoppingbackend_prac.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import net.harsh.shoppingbackend_prac.dto.Category;

@Service
public interface CategoryDAO {
	
	
	
	List<Category> list();
	
	Category get(int id);	
	
	boolean add (Category category);
	
	boolean update (Category category);
	
	
	boolean delete (Category category);
}
