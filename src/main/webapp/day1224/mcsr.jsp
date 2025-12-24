<%@page import="day1224.EmpDTO"%>
<%@page import="day1224.SelectService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<h3>컬럼 여러개에 한 행 조회</h3>

<script type="text/javascript">
$(function(){
	$("#btn").click(function(){
		$("#frm").submit();
	});
})
</script>

<form name="frm" id="frm" action="index.jsp">
	<input type="hidden" name="url" value="${param.url }" />
	<label for="empno">사원번호</label>
	<input type="text" name="empno" />
	<input type="button" value="검색" class="btn btn-info btn-sm" id="btn" />
</form>

<div id="output">
	<c:if test="${not empty param.empno }">
		<%
			String empno = request.getParameter("empno");
			
			if(empno != null){
				SelectService ss = SelectService.getInstance();
				EmpDTO eDTO = ss.mcsr(Integer.parseInt(empno));
				
				pageContext.setAttribute("eDTO", eDTO);
			}
		%>
		<c:out value="${param.empno }"/>번 사원 정보 <br/>
		<c:choose>
			<c:when test="${not empty eDTO }">
				사원명: <c:out value="${eDTO.ename }" /> <br/>
				연봉: <fmt:formatNumber pattern="#,###.##" value="${eDTO.sal }" /> <br/>
				직무: <c:out value="${eDTO.job }" /> <br/>
				매니저 번호: <c:out value="${eDTO.mgr }" /> <br/>
				부서 번호: <c:out value="${eDTO.deptno }" /> <br/>
				입사일: <c:out value="${eDTO.strHiredate }" />(
				<fmt:formatDate value="${eDTO.hiredate }" pattern="yyyy-MM-dd kk:mm:ss"/>) <br/>
			</c:when>
			<c:otherwise>
			해당 사원은 존재하지 않습니다.
			</c:otherwise>
		</c:choose>
	</c:if>
</div>