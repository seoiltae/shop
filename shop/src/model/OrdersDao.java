package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import commons.DBUtil;
import vo.Orders;

public class OrdersDao {

	public List<Orders> seachmeOrders(String userName, String userPhone) {
		List<Orders> list = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			list = new ArrayList<Orders>();
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement("SELECT * " + "FROM orders " + "WHERE user_name like ? and user_phone like ?");
			stmt.setString(1, "%" + userName + "%");
			stmt.setString(2, "%" + userPhone + "%");
			rs = stmt.executeQuery();
			while (rs.next()) {
				Orders orders = new Orders();
				orders.setOrdersId(rs.getInt("orders_id"));
				orders.setItemCount(rs.getInt("item_count"));
				orders.setOrdersPrice(rs.getInt("orders_price"));
				orders.setOrdersState(rs.getString("orders_state"));
				orders.setUserName(rs.getString("user_name"));
				orders.setUserPhone(rs.getString("user_phone"));
				orders.setUserAddress(rs.getString("user_address"));
				list.add(orders);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("디버깅디버깅");
		}
		return list;
	}

	public void insertOrders(Orders orders) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(
					"INSERT INTO orders(item_id, item_count, orders_date, orders_price, user_name, user_phone, user_address) VALUES(?, ?, NOW(), ?, ?, ?, ?)");
			stmt.setInt(1, orders.getItemId());
			stmt.setInt(2, orders.getItemCount());
			stmt.setInt(3, orders.getOrdersPrice());
			stmt.setString(4, orders.getUserName());
			stmt.setString(5, orders.getUserPhone());
			stmt.setString(6, orders.getUserAddress());
			stmt.executeUpdate();
			conn.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("(OrdersDao)insertOrders<--에러확인디버그");
		}
	}

	public Orders selectOrdersOne(int ordersId) { // ordersId 열을 불러와서 수정할 내용 수정 UpdateForm
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Orders orders = null; // 초기값 null
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement("SELECT * FROM orders WHERE orders_id=?");
			stmt.setInt(1, ordersId);
			rs = stmt.executeQuery();
			orders = new Orders(); // 새로 선언(메모리에 새로운 공간 만든다)
			while (rs.next()) { // 새로 선언한 new 연산자 활요
				orders.setOrdersId(rs.getInt("orders_id"));
				;
				orders.setItemId(rs.getInt("item_id"));
				orders.setItemCount(rs.getInt("item_count"));
				orders.setOrdersPrice(rs.getInt("orders_price"));
				orders.setOrdersState(rs.getString("orders_state"));
				orders.setUserName(rs.getString("user_name"));
				orders.setUserPhone(rs.getString("user_phone"));
				orders.setUserAddress(rs.getString("user_address"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close(); // finally에서 예외가 아니면 닫겠다(가비지커넥터)
				stmt.close();
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return orders;
	}

	public List<Orders> selectOrdersListAll() {
		List<Orders> list = null; // 초기값을 null로 설정
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement("SELECT * FROM orders");
			rs = stmt.executeQuery();
			list = new ArrayList<Orders>();
			while (rs.next()) {
				Orders orders = new Orders();
				orders.setOrdersId(rs.getInt("orders_id"));
				orders.setItemId(rs.getInt("item_id"));
				orders.setItemCount(rs.getInt("item_count"));
				orders.setOrdersDate(rs.getString("orders_date"));
				orders.setOrdersPrice(rs.getInt("orders_price"));
				orders.setOrdersState(rs.getString("orders_state"));
				orders.setUserName(rs.getString("user_name"));
				orders.setUserPhone(rs.getString("user_phone"));
				orders.setUserAddress(rs.getString("user_address"));
				list.add(orders);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	// admin update(orders_state)
	public void updateOrdersState(Orders orders) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement("UPDATE orders set orders_state=? WHERE orders_id=?");
			stmt.setString(1, orders.getOrdersState());
			stmt.setInt(2, orders.getOrdersId());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("ordersId" + orders.getOrdersId());
	}
}
