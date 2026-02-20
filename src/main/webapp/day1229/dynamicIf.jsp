<%@page import="day1229.SelectService3"%>
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
<h3>$의 사용</h3>

<script type="text/javascript">
$(function(){
	$("#btn").click(function(){
		$("#frm").submit();
	});
	
	$("[value='${param.deptno}']").prop("checked", true);
})
</script>
사원 검색<br/>

<form action="index.jsp" id="frm">
	<input type="hidden" name="url" value="${param.url }" />
	
	<input type="radio" name="deptno" value="0" />모든 부서
	<c:forEach var="i" begin="10" end="40" step="10">
		<input type="radio" name="deptno" value="${i}" /><c:out value="${i}" />
	</c:forEach>
	
	<input type="button" value="검색" class="btn btn-sm btn-info" id="btn" />
</form>
<div id="output">
	<c:if test="${not empty param.deptno }">
	<%
			String deptno=request.getParameter("deptno");
		
			SelectService3 ss = SelectService3.getInstance();
			List<EmpAllDomain> empList = ss.dynamicIf(Integer.parseInt(deptno));
				
			pageContext.setAttribute("empList", empList);
		%>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>사원번호</th>
					<th>사원명</th>
					<th>연봉</th>
					<th>직무</th>
					<th>입사일</th>
					<th>부서번호</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${empty empList }">
					<tr>
						<td colspan="6" style="text-align: center">
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
						<td><fmt:formatDate value="${emp.hiredate }" pattern="yyyy-MM-dd kk:mm"/></td>
						<td><c:out value="${emp.deptno }" /></td>
					</tr>
				</c:forEach>
			</tbody>
		
		</table>
		
	</c:if>
	
</div>