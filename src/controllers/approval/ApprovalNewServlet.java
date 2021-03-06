package controllers.approval;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Approval;
import models.Report;
import utils.DBUtil;

/**
 * Servlet implementation class ApprovalNewServlet
 */
@WebServlet("/approvals/new")
public class ApprovalNewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ApprovalNewServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		EntityManager em = DBUtil.createEntityManager();
		// セッションスコープから日報のidを取得して該当のidの日報１件のみをデータベースから取得
		Report r = em.find(Report.class, (Integer) (request.getSession().getAttribute("report_id")));

		Approval a = new Approval();
		em.close();
		request.setAttribute("approval", a);
		request.setAttribute("_token", request.getSession().getId());
		request.setAttribute("report", r);
		request.getSession().setAttribute("report_id", r.getId());

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/approvals/new.jsp");
		rd.forward(request, response);
	}
}
