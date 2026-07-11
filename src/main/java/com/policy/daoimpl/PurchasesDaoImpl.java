package com.policy.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.policy.dao.PurchasesDao;
import com.policy.dto.Purchase;
import com.policy.utility.Connector;

public class PurchasesDaoImpl implements PurchasesDao {

	@Override
	public boolean purchasePolicy(Purchase purchase) {
		String premiumSql = "SELECT premium_amount FROM policies WHERE policy_id = ?";
		String insertSql = "INSERT INTO purchases (policy_number, user_id, policy_id, purchase_amount, purchase_date, expiry_date, payment_status, status) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		try (Connection con = Connector.requestgetconnection()) {
			double premiumAmount;
			try (PreparedStatement ps = con.prepareStatement(premiumSql)) {
				ps.setInt(1, purchase.getPolicy_id());
				try (ResultSet rs = ps.executeQuery()) {
					if (!rs.next()) {
						return false;
					}
					premiumAmount = rs.getDouble("premium_amount");
				}
			}

			String policyNumber = "PN-" + purchase.getPolicy_id() + "-" + System.currentTimeMillis();
			try (PreparedStatement ps = con.prepareStatement(insertSql)) {
				ps.setString(1, policyNumber);
				ps.setInt(2, purchase.getUser_id());
				ps.setInt(3, purchase.getPolicy_id());
				ps.setDouble(4, premiumAmount);
				ps.setString(5, purchase.getPurchase_date());
				ps.setString(6, purchase.getExpiry_date());
				ps.setString(7, "PENDING");
				ps.setString(8, purchase.getStatus() != null ? purchase.getStatus() : "ACTIVE");
				return ps.executeUpdate() > 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Purchase findpurchasebyId(Integer purchaseId) {
		String sql = "SELECT * FROM purchases WHERE purchase_id = ?";
		try (Connection con = Connector.requestgetconnection();
				PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, purchaseId);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					Purchase purchase = new Purchase();
					purchase.setPurchase_id(rs.getInt("purchase_id"));
					purchase.setUser_id(rs.getInt("user_id"));
					purchase.setPolicy_id(rs.getInt("policy_id"));
					purchase.setPurchase_date(rs.getString("purchase_date"));
					purchase.setExpiry_date(rs.getString("expiry_date"));
					purchase.setStatus(rs.getString("status"));
					return purchase;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Purchase> findpurchaseByUser(Integer UserId) {
		List<Purchase> purchases = new ArrayList<>();
		String sql = "SELECT * FROM purchases WHERE user_id = ?";
		try (Connection con = Connector.requestgetconnection();
				PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, UserId);
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					Purchase purchase = new Purchase();
					purchase.setPurchase_id(rs.getInt("purchase_id"));
					purchase.setUser_id(rs.getInt("user_id"));
					purchase.setPolicy_id(rs.getInt("policy_id"));
					purchase.setPurchase_date(rs.getString("purchase_date"));
					purchase.setExpiry_date(rs.getString("expiry_date"));
					purchase.setStatus(rs.getString("status"));
					purchases.add(purchase);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return purchases;
	}

	@Override
	public List<Purchase> findAll() {
		List<Purchase> purchases = new ArrayList<>();
		String sql = "SELECT * FROM purchases";
		try (Connection con = Connector.requestgetconnection();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql)) {
			while (rs.next()) {
				Purchase purchase = new Purchase();
				purchase.setPurchase_id(rs.getInt("purchase_id"));
				purchase.setUser_id(rs.getInt("user_id"));
				purchase.setPolicy_id(rs.getInt("policy_id"));
				purchase.setPurchase_date(rs.getString("purchase_date"));
				purchase.setExpiry_date(rs.getString("expiry_date"));
				purchase.setStatus(rs.getString("status"));
				purchases.add(purchase);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return purchases;
	}

	@Override
	public boolean Updatepurchase(Integer purchaseId, String status) {
		String sql = "UPDATE purchases SET status = ? WHERE purchase_id = ?";
		try (Connection con = Connector.requestgetconnection();
				PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, status);
			ps.setInt(2, purchaseId);
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deletepurchase(Integer purchaseId) {
		String sql = "DELETE FROM purchases WHERE purchase_id = ?";
		try (Connection con = Connector.requestgetconnection();
				PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, purchaseId);
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
