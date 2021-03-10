package models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name = "approvals")
@NamedQueries({
		@NamedQuery(name = "getMyApprovalCount", query = "SELECT COUNT(m) FROM Approval AS m where m.report.employee=:report"),
		@NamedQuery(name = "getMyAllApproved", query = "SELECT m FROM Approval AS m where m.report.employee=:report ORDER BY m.id DESC") })

@Entity
public class Approval {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;


	@ManyToOne
	@JoinColumn(name = "report_id", nullable = false)
	private Report report;

	@Column(name = "approval_at", nullable = false)
	private Timestamp approval_at;

	@Column(name = "approval", nullable = false)
	private Integer approval;

	@Column(name = "review", length = 255, nullable = false)
	private String review;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public Report getReport() {
		return report;
	}

	public void setReport(Report report) {
		this.report = report;
	}

	public Timestamp getApproval_at() {
		return approval_at;
	}

	public void setApproval_at(Timestamp approval_at) {
		this.approval_at = approval_at;
	}

	public Integer getApproval() {
		return approval;
	}

	public void setApproval(Integer approval) {
		this.approval = approval;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

}
