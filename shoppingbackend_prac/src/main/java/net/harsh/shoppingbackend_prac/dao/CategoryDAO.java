package net.harsh.shoppingbackend_prac.dao;

import java.util.List;

import net.harsh.shoppingbackend_prac.dto.Category;

public interface CategoryDAO {
	List<Category> list();
	
	Category get(int id);	
}
