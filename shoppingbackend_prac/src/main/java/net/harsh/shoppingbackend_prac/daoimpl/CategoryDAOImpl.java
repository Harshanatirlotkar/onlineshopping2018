package net.harsh.shoppingbackend_prac.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.harsh.shoppingbackend_prac.dao.CategoryDAO;
import net.harsh.shoppingbackend_prac.dto.Category;



@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	private static List<Category> categories = new ArrayList();
	
	/*static {
		Category category = new Category();
		category.setId(1);
		category.setName("Television");
		category.setDescription("argjrghjrgh rrhrghrhghg");
		category.setImageURL("cat_1.png");
		
		categories.add(category);
		
		
		category = new Category();
		category.setId(2);
		category.setName("mobile");
		category.setDescription("argjrghjrgh grgggegg");
		category.setImageURL("cat_2.png");
		
		categories.add(category);
		
		category = new Category();
		category.setId(3);
		category.setName("Laptop");
		category.setDescription("argjrghjrgh rrhrghrhghg");
		category.setImageURL("cat_3.png");
		
		categories.add(category);
	}
	
	@Override
	public Category get(int id) {
		// TODO Auto-generated method stub
		
		for (Category category : categories)
		{
			if(category.getId() == id) return category;
		}	
		return null;
	}*/
	
	
	
	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		String selectActiveCategory = "FROM Category where active= :active";
		
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		query.setParameter("active", true);
		
		System.out.println("---------Count : " + query.getResultList() );
		return query.getResultList();
	}

	//getting single category

	@Override
	public Category get(int id) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));	
		
	}
	
	@Override
	@Transactional
	public boolean add(Category category) {
		try
		{
			sessionFactory.getCurrentSession().persist(category);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean update(Category category) {
		try
		{
			sessionFactory.getCurrentSession().update(category);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Category category) {
		category.setActive(false);
		try
		{
			sessionFactory.getCurrentSession().update(category);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}		

	
	
}
