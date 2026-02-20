<%@page import="day1226.EmpDomain"%>
<%@page import="day1226.SelectService2"%>
<%@page import="day1224.EmpDTO"%>
<%@page import="java.util.List"%>
<%@page import="day1224.SelectService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<h3>서브쿼리의 조회</h3>

<script type="text/javascript">
$(function(){
	$("#btn").click(function(){
		$("#frm").submit();
	});
})
</script>
가장 최근에 입사한 신입사원을 제외한 10명의 사원을 입사일 순으로 검색<br/>

<div id="output">
		<%
			SelectService2 ss = SelectService2.getInstance();
			List<EmpDomain> empList = ss.subquery();
				
			pageContext.setAttribute("empList", empList);
		%>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>사원번호</th>
					<th>사원명</th>
					<th>연봉</th>
					<th>입사일</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${empty empList }">
					<tr>
						<td colspan="4" style="text-align: center">
							<img src="images/na.jpg" style="width: 300px; height: 260px;">
						</td>
					</tr>
				</c:if>
				<c:forEach var="emp" items="${empList }" varStatus="i">
					<tr>
						<td><c:out value="${emp.empno }" /></td>
						<td><c:out value="${emp.ename }" /></td>
						<td><c:out value="${emp.sal }" /></td>
						<td><fmt:formatDate value="${emp.hiredate }" pattern="yyyy-MM-dd kk:mm"/></td>
					</tr>
				</c:forEach>
			</tbody>
		
		</table>
		
</div>