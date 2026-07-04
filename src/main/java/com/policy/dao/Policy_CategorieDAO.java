package com.policy.dao;

import java.util.List;

import com.policy.dto.Policy_Categorie;

public interface Policy_CategorieDAO {

	boolean addCategory(Policy_Categorie category);

	boolean updateCategory(Policy_Categorie category);

	boolean deleteCategory(int categoryId);

	Policy_Categorie getCategoryById(int categoryId);

	List<Policy_Categorie> getAllCategories();
}
