package com.policy.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.policy.dao.Policy_CategorieDAO;
import com.policy.dto.Policy_Categorie;
import com.policy.utility.Connector;

public class Policy_CategorieDAOImpl implements Policy_CategorieDAO {

	@Override
	public boolean addCategory(Policy_Categorie category) {
		String sql = "INSERT INTO policy_categories (category_name, description) VALUES (?, ?)";
		try (Connection con = Connector.requestgetconnection();
				PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, category.getCategory_name());
			ps.setString(2, category.getDescription());
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateCategory(Policy_Categorie category) {
		String sql = "UPDATE policy_categories SET category_name = ?, description = ? WHERE category_id = ?";
		try (Connection con = Connector.requestgetconnection();
				PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, category.getCategory_name());
			ps.setString(2, category.getDescription());
			ps.setInt(3, category.getCategory_id());
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteCategory(int categoryId) {
		String sql = "DELETE FROM policy_categories WHERE category_id = ?";
		try (Connection con = Connector.requestgetconnection();
				PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, categoryId);
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Policy_Categorie getCategoryById(int categoryId) {
		String sql = "SELECT * FROM policy_categories WHERE category_id = ?";
		try (Connection con = Connector.requestgetconnection();
				PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, categoryId);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					Policy_Categorie category = new Policy_Categorie();
					category.setCategory_id(rs.getInt("category_id"));
					category.setCategory_name(rs.getString("category_name"));
					category.setDescription(rs.getString("description"));
					return category;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Policy_Categorie> getAllCategories() {
		List<Policy_Categorie> categories = new ArrayList<>();
		String sql = "SELECT * FROM policy_categories";
		try (Connection con = Connector.requestgetconnection();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql)) {
			while (rs.next()) {
				Policy_Categorie category = new Policy_Categorie();
				category.setCategory_id(rs.getInt("category_id"));
				category.setCategory_name(rs.getString("category_name"));
				category.setDescription(rs.getString("description"));
				categories.add(category);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categories;
	}
}
