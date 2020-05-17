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
			System.out.println("ItemDao.deleteItem ���ܹ߻�");
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
			System.out.println("ItemDao.updateItem ���ܹ߻�");
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
			System.out.println("ItemDao.selectItemOne ���ܹ߻�");
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
		try { // ���ܰ� �ƴϸ� db�� �Է��� �� �ִ� �������� �޾ƿ��ڴ�
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(
					"INSERT INTO item(category_id, item_name, item_price, item_contents) VALUES(?, ?, ?, ?)");
			stmt.setInt(1, item.getCategoryId());
			System.out.println(item.getCategoryId());
			stmt.setString(2, item.getItemName());
			stmt.setInt(3, item.getItemPrice());
			stmt.setString(4, item.getItemContents());
			stmt.executeUpdate();
		} catch (Exception e) { // �����϶� �ܼ�â ����
			System.out.println("ItemDao.insertItem ���ܹ߻�");
			e.printStackTrace();
		} finally { // ���ܰ� ���� ���ܰ� ���� �ʾƵ� ���������� �����ϴ� ��
			try {
				conn.close(); // ���������� ������û��
				stmt.close(); // ������ û��
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
			System.out.println("ItemDao.selectItemListAll ���ܹ߻�");
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
