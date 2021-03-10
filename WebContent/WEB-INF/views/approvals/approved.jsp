<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:import url="/WEB-INF/views/layout/app.jsp">
	<c:param name="content">
		<h2>レビュー 一覧</h2>
		<table id="review_list">
			<tbody>
				<tr>
					<th class="name">承認者</th>
					<th class="title">タイトル</th>
					<th class="review">レビュー</th>
					<th class="approval">状態</th>
					<th class="time">承認日時</th>
				</tr>

				<c:forEach var="approval" items="${approval}" varStatus="status">
					<tr class="row${status.count % 5}">
						<td class="name"><c:out value="${approval.report.boss.name}" /></td>
						<td class="title"><c:out value="${approval.report.title }" /></td>
						<td class="review"><c:out value='${approval.review}' /></td>
						<td class="approval"><c:choose>
								<c:when test="${approval.approval == 0}">合格</c:when>
								<c:otherwise>不合格</c:otherwise>
							</c:choose></td>
						<td class="time"><fmt:formatDate value="${approval.approval_at }" pattern="MM-dd" />
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
        <div id="pagination">
            （全 ${approval_count} 件）<br />
            <c:forEach var="i" begin="1" end="${((approval_count - 1) / 15) + 1}" step="1">
                <c:choose>
                    <c:when test="${i == page}">
                        <c:out value="${i}" />&nbsp;
                    </c:when>
                    <c:otherwise>
                        <a href="<c:url value='/?page=${i}' />"><c:out value="${i}" /></a>&nbsp;
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </div>


		<p>
			<a href="<c:url value='/reports/index' />">一覧に戻る</a>
		</p>
	</c:param>
</c:import>
