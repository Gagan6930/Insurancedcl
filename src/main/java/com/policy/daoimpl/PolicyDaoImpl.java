package com.policy.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.policy.dao.PolicyDao;
import com.policy.dto.Policie;
import com.policy.utility.Connector;

public class PolicyDaoImpl implements PolicyDao {

	@Override
	public boolean addpolicy(Policie policy) {
		String sql = "INSERT INTO policies (category_id, policy_name, premium_amount, coverage_amount, duration_months, description, status) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
		try (Connection con = Connector.requestgetconnection();
				PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, policy.getCategory_id());
			ps.setString(2, policy.getPolicy_name());
			ps.setDouble(3, policy.getPremium_amount());
			ps.setDouble(4, policy.getCoveage_amount());
			ps.setInt(5, policy.getDuration_months());
			ps.setString(6, policy.getDescription());
			ps.setString(7, policy.getStatus() != null ? policy.getStatus() : "ACTIVE");
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updatepolicy(Policie policy) {
		String sql = "UPDATE policies SET category_id = ?, policy_name = ?, premium_amount = ?, coverage_amount = ?, "
				+ "duration_months = ?, description = ?, status = ? WHERE policy_id = ?";
		try (Connection con = Connector.requestgetconnection();
				PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, policy.getCategory_id());
			ps.setString(2, policy.getPolicy_name());
			ps.setDouble(3, policy.getPremium_amount());
			ps.setDouble(4, policy.getCoveage_amount());
			ps.setInt(5, policy.getDuration_months());
			ps.setString(6, policy.getDescription());
			ps.setString(7, policy.getStatus());
			ps.setInt(8, policy.getPolicy_id());
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteploicy(Integer policyId) {
		String sql = "DELETE FROM policies WHERE policy_id = ?";
		try (Connection con = Connector.requestgetconnection();
				PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, policyId);
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Policie findbyId(Integer policyid) {
		String sql = "SELECT * FROM policies WHERE policy_id = ?";
		try (Connection con = Connector.requestgetconnection();
				PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, policyid);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					Policie policy = new Policie();
					policy.setPolicy_id(rs.getInt("policy_id"));
					policy.setCategory_id(rs.getInt("category_id"));
					policy.setPolicy_name(rs.getString("policy_name"));
					policy.setPremium_amount(rs.getDouble("premium_amount"));
					policy.setCoveage_amount(rs.getDouble("coverage_amount"));
					policy.setDuration_months(rs.getInt("duration_months"));
					policy.setDescription(rs.getString("description"));
					policy.setStatus(rs.getString("status"));
					return policy;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Policie> findall() {
		List<Policie> policies = new ArrayList<>();
		String sql = "SELECT * FROM policies";
		try (Connection con = Connector.requestgetconnection();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql)) {
			while (rs.next()) {
				Policie policy = new Policie();
				policy.setPolicy_id(rs.getInt("policy_id"));
				policy.setCategory_id(rs.getInt("category_id"));
				policy.setPolicy_name(rs.getString("policy_name"));
				policy.setPremium_amount(rs.getDouble("premium_amount"));
				policy.setCoveage_amount(rs.getDouble("coverage_amount"));
				policy.setDuration_months(rs.getInt("duration_months"));
				policy.setDescription(rs.getString("description"));
				policy.setStatus(rs.getString("status"));
				policies.add(policy);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return policies;
	}

	@Override
	public List<Policie> getPoliciesByCategory(Integer catogeryId) {
		List<Policie> policies = new ArrayList<>();
		String sql = "SELECT * FROM policies WHERE category_id = ?";
		try (Connection con = Connector.requestgetconnection();
				PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, catogeryId);
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					Policie policy = new Policie();
					policy.setPolicy_id(rs.getInt("policy_id"));
					policy.setCategory_id(rs.getInt("category_id"));
					policy.setPolicy_name(rs.getString("policy_name"));
					policy.setPremium_amount(rs.getDouble("premium_amount"));
					policy.setCoveage_amount(rs.getDouble("coverage_amount"));
					policy.setDuration_months(rs.getInt("duration_months"));
					policy.setDescription(rs.getString("description"));
					policy.setStatus(rs.getString("status"));
					policies.add(policy);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return policies;
	}
}
