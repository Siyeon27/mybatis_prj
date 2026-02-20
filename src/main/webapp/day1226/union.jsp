<%@page import="day1226.EmpAllDomain"%>
<%@page import="day1226.EmpDomain"%>
<%@page import="day1226.SelectService2"%>
<%@page import="day1224.EmpDTO"%>
<%@page import="java.util.List"%>
<%@page import="day1224.SelectService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<h3>유니온의 조회</h3>

<script type="text/javascript">
$(function(){
	$("#btn").click(function(){
		$("#frm").submit();
	});
})
</script>
본사와 지사의 모든 사원을 검색<br/>

<div id="output">
		<%
			SelectService2 ss = SelectService2.getInstance();
			List<EmpAllDomain> empList = ss.union();
				
			pageContext.setAttribute("empList", empList);
		%>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>사원번호</th>
					<th>사원명</th>
					<th>연봉</th>
					<th>직무</th>
					<th>매니저 번호</th>
					<th>부서번호</th>
					<th>입사일</th>
					<th>분류</th>
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
						<td><c:out value="${emp.job }" /></td>
						<td><c:out value="${emp.mgr }" /></td>
						<td><c:out value="${emp.deptno }" /></td>
						<td><fmt:formatDate value="${emp.hiredate }" pattern="yyyy-MM-dd kk:mm"/></td>
						<td><c:out value="${emp.officeType }" /></td>
					</tr>
				</c:forEach>
			</tbody>
		
		</table>
		
</div>