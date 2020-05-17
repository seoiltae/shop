package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import commons.DBUtil;
import vo.Category;

public class CategoryDao {
	// 인설트 액션
	public void updateCategory(Category category) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopdb", "root", "java1234");
			stmt = conn.prepareStatement("UPDATE category set category_name=? WHERE category_id=?");
			stmt.setString(1, category.getCategoryName());
			stmt.setInt(2, category.getCategoryId());
			stmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("CategoryDao.updateCategory 예외발생");
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

	// 인설트폼
	public Category selectCategoryOne(int categoryId) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Category category = null;
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement("SELECT * FROM category WHERE category_id = ?");
			stmt.setInt(1, categoryId);
			rs = stmt.executeQuery();
			if (rs.next()) {
				category = new Category();
				category.setCategoryId(rs.getInt("category_id"));
				category.setCategoryName(rs.getString("category_name"));
			}
		} catch (Exception e) {
			System.out.println("CategoryDao.selectCategoryOne 예외발생");
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
		return category;
	}

	public void insertCategory(Category category) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement("INSERT INTO category(category_name) VALUES(?)");
			stmt.setString(1, category.getCategoryName());
			stmt.executeUpdate();
			conn.close();
			stmt.close();
		} catch (Exception e) {
			System.out.println("CategoryDao.insertCategory 예외발생");
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

	public ArrayList<Category> selectCategoryListAll() {
		ArrayList<Category> list = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement("SELECT category_id, category_name FROM category");
			ResultSet rs = stmt.executeQuery();
			list = new ArrayList<Category>();
			while (rs.next()) {
				Category category = new Category();
				category.setCategoryId(rs.getInt("category_id"));
				category.setCategoryName(rs.getString("category_name"));
				list.add(category);
			}
		} catch (Exception e) {
			System.out.println("CategoryDao.selectCategoryListAll 예외발생");
			e.printStackTrace();
		}
		return list;
	}
}
