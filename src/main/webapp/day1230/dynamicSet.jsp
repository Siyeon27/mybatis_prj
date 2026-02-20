<%@page import="day1230.SelectService4"%>
<%@page import="day1224.EmpDTO"%>
<%@page import="day1224.SelectService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<h3>dynamic set</h3>

<script type="text/javascript">

<c:if test="${ param.updateFlag }">
<jsp:useBean id="eDTO" class="day1224.EmpDTO" scope="page" />
<jsp:setProperty property="*" name="eDTO" />
	<%
		SelectService4 ss4 = SelectService4.getInstance();
		
		String msg = eDTO.getEmpno() + "번 ";
		int cnt = ss4.dynamicSet(eDTO);
		
		if(cnt == 1){
			msg += "사원 정보 변경 성공";
		} else {
			msg += "사원 정보 변경 실패";
		}
	%>
	
	alert("<%= msg %>");
</c:if>

$(function(){
	$("#btn").click(function(){
		$("#frm").submit();
	});
	
	$("#btnModify").click(function(){
		$("#updateFrm").submit();
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
				<form action="index.jsp" id="updateFrm" name="updateFrm">
					<input type="hidden" name="url" value="${param.url }" />
					<input type="hidden" name="updateFlag" value="${ empty param.updateFlag }" />
					
					사원번호: <input type="text" name="empno" value="${param.empno }" readonly="readonly" /> <br/>
					사원명: <input type="text" name="ename"  value="${eDTO.ename }" /> <br/>
					연봉: <input type="text" name="sal"  value="${eDTO.sal }" /> <br/>
					직무: <input type="text" name="job"  value="${eDTO.job }" /> <br/>
					매니저 번호: <input type="text" name="mgr"  value="${eDTO.mgr }" /> <br/>
					부서 번호: <input type="text" name="deptno"  value="${eDTO.deptno }" /> <br/>
					입사일: <input type="text" name="strHiredate"  value="${eDTO.strHiredate }" /> <br/>
					
					<input type="button" value="변경" id="btnModify" class="btn btn-sm btn-info" />
				</form>
			</c:when>
			<c:otherwise>
			해당 사원은 존재하지 않습니다.
			</c:otherwise>
		</c:choose>
	</c:if>
</div>