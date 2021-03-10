package controllers.approval;

import java.io.IOException;
import java.sql.Timestamp;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Approval;
import models.Report;
import utils.DBUtil;

/**
 * Servlet implementation class ApprovalCreateServlet
 */
@WebServlet("/approvals/create")
public class ApprovalCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ApprovalCreateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		EntityManager em = DBUtil.createEntityManager();
		// セッションスコープから日報のidを取得して該当のidの日報１件のみをデータベースから取得

		Report r = em.find(Report.class, (Integer) (request.getSession().getAttribute("report_id")));
		Approval a = new Approval();
		a.setApproval(Integer.parseInt(request.getParameter("approval")));
		a.setReport(r);
		// 状態を合格か不合格に更新する
		r.setStatus(Integer.parseInt(request.getParameter("approval")));
		a.setReview(request.getParameter("review"));
		Timestamp currentTime = new Timestamp(System.currentTimeMillis());
		a.setApproval_at(currentTime);
		em.getTransaction().begin();
		em.persist(a);
		em.getTransaction().commit();
		em.close();
		request.getSession().setAttribute("flush", "レビューしました。");
		request.getSession().removeAttribute("report_id");

		response.sendRedirect(request.getContextPath() + "/reports/index");
	}

}
