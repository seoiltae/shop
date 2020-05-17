package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import commons.DBUtil;
import vo.Item;

public class ItemDao {

	public void deleteItem(int itemId) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement("DELETE FROM item WHERE item_id=?");
			stmt.setInt(1, itemId);
			stmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("ItemDao.deleteItem 예외발생");
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void updateItem(Item item) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(
					"UPDATE item set category_id=?, item_name=?, item_price=?, item_contents=? WHERE item_id=?");
			stmt.setInt(1, item.getCategoryId());
			stmt.setString(2, item.getItemName());
			stmt.setInt(3, item.getItemPrice());
			stmt.setString(4, item.getItemContents());
			stmt.setInt(5, item.getItemId());
			stmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("ItemDao.updateItem 예외발생");
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public Item selectItemOne(int itemId) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Item item = null;
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement("SELECT * FROM item WHERE item_id=?");
			stmt.setInt(1, itemId);
			rs = stmt.executeQuery();
			while (rs.next()) {
				item = new Item();
				item.setItemId(rs.getInt("item_id"));
				item.setCategoryId(rs.getInt("category_id"));
				item.setItemName(rs.getString("item_name"));
				item.setItemPrice(rs.getInt("item_price"));
				item.setItemContents(rs.getString("item_contents"));
				item.setItemImg(rs.getString("item_img"));
			}
		} catch (Exception e) {
			System.out.println("ItemDao.selectItemOne 예외발생");
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return item;
	}

	public void insertItem(Item item) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try { // 예외가 아니면 db에 입력할 수 있는 쿼리문을 받아오겠다
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(
					"INSERT INTO item(category_id, item_name, item_price, item_contents) VALUES(?, ?, ?, ?)");
			stmt.setInt(1, item.getCategoryId());
			System.out.println(item.getCategoryId());
			stmt.setString(2, item.getItemName());
			stmt.setInt(3, item.getItemPrice());
			stmt.setString(4, item.getItemContents());
			stmt.executeUpdate();
		} catch (Exception e) { // 예외일때 콘솔창 공개
			System.out.println("ItemDao.insertItem 예외발생");
			e.printStackTrace();
		} finally { // 예외가 나도 예외가 나지 않아도 마지막으로 실행하는 것
			try {
				conn.close(); // 마지막으로 쓰레기청소
				stmt.close(); // 쓰레기 청소
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public ArrayList<Item> selectItemListAll() {
		ArrayList<Item> list = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement("SELECT * FROM item");
			rs = stmt.executeQuery();
			list = new ArrayList<Item>();
			while (rs.next()) {
				Item item = new Item();
				item.setItemId(rs.getInt("item_id"));
				item.setCategoryId(rs.getInt("category_id"));
				item.setItemName(rs.getString("item_name"));
				item.setItemPrice(rs.getInt("item_price"));
				item.setItemContents(rs.getString("item_contents"));
				item.setItemImg(rs.getString("item_img"));
				list.add(item);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("ItemDao.selectItemListAll 예외발생");
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
}
