package com.policy.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.policy.dao.UserDAO;
import com.policy.dto.User;
import com.policy.utility.Connector;

public class UserDAOImpl implements UserDAO {

	@Override
	public boolean registerUser(User user) {
		String sql = "INSERT INTO users (full_name, email, password, role) VALUES (?, ?, ?, ?)";
		try (Connection con = Connector.requestgetconnection();
				PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, user.getFull_name());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getRole() != null ? user.getRole() : "CUSTOMER");
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public User loginUser(String email, String password) {
		String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
		try (Connection con = Connector.requestgetconnection();
				PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, email);
			ps.setString(2, password);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					User user = new User();
					user.setUser_id(rs.getInt("user_id"));
					user.setFull_name(rs.getString("full_name"));
					user.setEmail(rs.getString("email"));
					user.setPassword(rs.getString("password"));
					user.setRole(rs.getString("role"));
					user.setCreated_at(rs.getString("created_at"));
					return user;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User getUserById(int userId) {
		String sql = "SELECT * FROM users WHERE user_id = ?";
		try (Connection con = Connector.requestgetconnection();
				PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, userId);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					User user = new User();
					user.setUser_id(rs.getInt("user_id"));
					user.setFull_name(rs.getString("full_name"));
					user.setEmail(rs.getString("email"));
					user.setPassword(rs.getString("password"));
					user.setRole(rs.getString("role"));
					user.setCreated_at(rs.getString("created_at"));
					return user;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateUser(User user) {
		String sql = "UPDATE users SET full_name = ?, email = ?, password = ?, role = ? WHERE user_id = ?";
		try (Connection con = Connector.requestgetconnection();
				PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, user.getFull_name());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getRole());
			ps.setInt(5, user.getUser_id());
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteUser(int userId) {
		String sql = "DELETE FROM users WHERE user_id = ?";
		try (Connection con = Connector.requestgetconnection();
				PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, userId);
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<>();
		String sql = "SELECT * FROM users";
		try (Connection con = Connector.requestgetconnection();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql)) {
			while (rs.next()) {
				User user = new User();
				user.setUser_id(rs.getInt("user_id"));
				user.setFull_name(rs.getString("full_name"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setRole(rs.getString("role"));
				user.setCreated_at(rs.getString("created_at"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
}
