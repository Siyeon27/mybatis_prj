<%@page import="day1231.MemberDomain"%>
<%@page import="day1231.SelectService5"%>
<%@page import="day1230.SelectService4"%>
<%@page import="day1229.SelectService3"%>
<%@page import="day1226.EmpAllDomain"%>
<%@page import="day1226.EmpDomain"%>
<%@page import="day1226.SelectService2"%>
<%@page import="day1224.EmpDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<h3>prosedure를 사용한 select</h3>

<script type="text/javascript">
$(function(){
	
})
</script>
전체 회원 검색<br/>
<div id="output">
	<%
		SelectService5 ss = SelectService5.getInstance();
		
		List<MemberDomain> md = ss.searchAllMember();
				
		pageContext.setAttribute("mdList", md);
	%>
	<table class="table table-hover">
		<thead>
			<tr>
				<td>번호</td>
				<td>이름</td>
				<td>나이</td>
				<td>성별</td>
				<td>전화번호</td>
				<td>가입일</td>
			</tr>
		</thead>
		
		<tbody>
			<c:if test="${ empty mdList }">
				<tr>
					<td colspan="6">회원정보 없음</td>
				</tr>
			</c:if>
			
			<c:forEach var="md" items="${mdList }">
				<tr>
					<td><c:out value="${ md.num }" /></td>
					<td><c:out value="${ md.name }" /></td>
					<td><c:out value="${ md.age }" /></td>
					<td><c:out value="${ md.gender }" /></td>
					<td><c:out value="${ md.tel }" /></td>
					<td><fmt:formatDate value="${ md.inputDate }" pattern="yyyy-MM-dd EEEE kk:mm:ss"/> / 
					<fmt:formatDate value="${ md.input_date }" pattern="yyyy-MM-dd EEEE kk:mm:ss"/></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>