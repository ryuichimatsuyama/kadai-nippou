<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${errors!=null }">
	<div id="flush_error">
		入力内容にエラーがあります。<br />
		<c:forEach var="error" items="${errors }">
・<c:out value="${error }" />
			<br />
		</c:forEach>
	</div>
</c:if>

<label for="approval">承認</label><br />
<select name="approval">
    <option value="0"<c:if test="${approval.approval == 0}"> selected</c:if>>合格</option>
    <option value="1"<c:if test="${approval.approval == 1}"> selected</c:if>>不合格</option>
</select>
<br /><br />



<label for="review">レビュー</label>
<br />
<input type="text" name="review" value="${approval.review }"/>
<br/><br/>
<input type="hidden" name="_token" value="${_token}" />
<button type="submit">投稿</button>

