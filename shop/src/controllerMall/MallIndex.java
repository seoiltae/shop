package controllerMall;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ItemDao;
import vo.Item;

/**
 * Servlet implementation class MallIndex
 */
@WebServlet("/mall/MallIndex")
public class MallIndex extends HttpServlet {
	private ItemDao itemDao; // private �ܺο��� ������ϰ�! 1.�߻�ȭ 2.��� 3.������ 4.ĸ��ȭ

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.itemDao = new ItemDao(); // ������ this
		List<Item> list = itemDao.selectItemListAll();
		System.out.println(list.size());
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/jsp/mall/mallIndex.jsp").forward(request, response);
	}

}
