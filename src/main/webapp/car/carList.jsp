<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en" data-bs-theme="auto">
<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">

<title>JSP 템플릿</title>
<link rel="shortcut icon" href="http://192.168.10.92/mybatis_prj/common/images/favicon.ico">

<script src="http://192.168.10.92/mybatis_prj/common/js/color-modes.js"></script>
<!-- bootstrap CDN 시작 -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
<!-- bootstrap CDN 끝 -->

<meta name="theme-color" content="#712cf9">
<link href="http://192.168.10.92/mybatis_prj/common/css/carousel.css" rel="stylesheet">

<c:import url="http://192.168.10.92/mybatis_prj/fragments/bootstrap_css.jsp" />

<style type="text/css">
#wrap{  margin: 0px auto; width: 1200px; min-height: 1000px; }	
#header{ height: 150px;	 }	
#container{ min-height: 700px;	 }	
#footer{ height: 150px;}
</style>

<!-- jQuery CDN 시작 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

<script type="text/javascript">
$(function(){
	$("#carCountry").change(function(){
		var selModel = $("#carMaker")[0];
		var selModel = $("#carModel")[0];
		selModel.length = 1;
		
		if($("#carCountry")[0].selectedIndex != 0){
			var param = {country : $("#carCountry").val()};
			
			$.ajax({
				url:"searchMaker.jsp",
				type: "GET",
				data: param,
				dataType: "JSON",
				error: function(xhr){
					alert("제조사 조회 시에 문제가 발생하였습니다. 잠시 후에 다시 시도해주세요");
					console.log(xhr.status);
				},
				success: function(jsonObj){
					if(jsonObj.result && jsonObj.makerCnt != 0){
						//제조사를 설정할 select를 가져옴
						var selMaker = $("#carMaker")[0];
						selMaker.length = 1;
						
						var jsonArr = jsonObj.data;
						
						for(var i = 0; i < jsonArr.length; i++){
							selMaker.options[i+1] = new Option(jsonArr[i].maker, jsonArr[i].maker);
						}
					}
				}
			})//ajax
		}//end if
	});//carCountry
	
	$("#carMaker").change(function(){
		if($("#carMaker")[0].selectedIndex != 0){
			var param = {maker : $("#carMaker").val()};
			
			$.ajax({
				url:"searchModel.jsp",
				type: "GET",
				data: param,
				dataType: "JSON",
				error: function(xhr){
					alert("모델 조회 시에 문제가 발생하였습니다. 잠시 후에 다시 시도해주세요");
					console.log(xhr.status);
				},
				success: function(jsonObj){
					if(jsonObj.result && jsonObj.modelCnt != 0){
						//모델을 설정할 select를 가져옴
						var selModel = $("#carModel")[0];
						selModel.length = 1;
						
						var jsonArr = jsonObj.data;
						
						for(var i = 0; i < jsonArr.length; i++){
							selModel.options[i+1] = new Option(jsonArr[i].model, jsonArr[i].model);
						}
					}
				}
			})//ajax
		}//end if
	});//carMaker
	
	$("#btn").click(function(){
		if($("#carModel")[0].selectedIndex != 0){
			var param = {model : $("#carModel").val()};
			
			$.ajax({
				url:"searchCar.jsp",
				type: "GET",
				data: param,
				dataType: "JSON",
				error: function(xhr){
					alert("세부차량 조회 시에 문제가 발생하였습니다. 잠시 후에 다시 시도해주세요");
					console.log(xhr.status);
				},
				success: function(jsonObj){
					if(jsonObj.result){
						//조회 결과를 보여줄 table을 가져옴
						var createTr = "";
						var selCar = $("#carList")[0];
						
						$("#carList tbody:last").empty();
						
						var jsonArr = jsonObj.data;
						var jsonObjCar;
						
						for(var i = 0; i < jsonArr.length; i++){
							jsonObjCar = jsonArr[i];
							
							createTr = "<tr>";
							
							createTr += "<td>";
							createTr += "<img src='http://localhost/mybatis_prj/day1226/car_img/" + jsonObjCar.car_img + "' style='width: 80px; height: 60px;'>";
							createTr += "</td>";
							
							createTr += "<td>";
							createTr += jsonObjCar.car_option;
							createTr += "</td>";
							
							createTr += "<td>";
							createTr += jsonObjCar.car_year;
							createTr += "</td>";
							
							createTr += "<td>";
							createTr += jsonObjCar.price;
							createTr += "</td>";
							
							createTr += "<td>";
							createTr += jsonObjCar.cc;
							createTr += "</td>";
							
							createTr += "<td>";
							createTr += jsonObjCar.input_date;
							createTr += "</td>";
							
							createTr += "</tr>";
							
							$("#carList tbody:last").append(createTr);
						}//end for
						
						if(jsonObj.carCnt == 0){
							createTr = "<tr> <td colspan='6'>보유중인 차량이 없습니다.</td> </tr>";
							
							$("#carList tbody:last").append(createTr);
						}
						
					}//end if
				}
			})//ajax
		}
	});//carModel
	
});//ready

</script>

</head>
<body>
	<svg xmlns="http://www.w3.org/2000/svg" class="d-none"> <symbol
			id="check2" viewBox="0 0 16 16"> <path
			d="M13.854 3.646a.5.5 0 0 1 0 .708l-7 7a.5.5 0 0 1-.708 0l-3.5-3.5a.5.5 0 1 1 .708-.708L6.5 10.293l6.646-6.647a.5.5 0 0 1 .708 0z"></path> </symbol> <symbol
			id="circle-half" viewBox="0 0 16 16"> <path
			d="M8 15A7 7 0 1 0 8 1v14zm0 1A8 8 0 1 1 8 0a8 8 0 0 1 0 16z"></path> </symbol> <symbol
			id="moon-stars-fill" viewBox="0 0 16 16"> <path
			d="M6 .278a.768.768 0 0 1 .08.858 7.208 7.208 0 0 0-.878 3.46c0 4.021 3.278 7.277 7.318 7.277.527 0 1.04-.055 1.533-.16a.787.787 0 0 1 .81.316.733.733 0 0 1-.031.893A8.349 8.349 0 0 1 8.344 16C3.734 16 0 12.286 0 7.71 0 4.266 2.114 1.312 5.124.06A.752.752 0 0 1 6 .278z"></path> <path
			d="M10.794 3.148a.217.217 0 0 1 .412 0l.387 1.162c.173.518.579.924 1.097 1.097l1.162.387a.217.217 0 0 1 0 .412l-1.162.387a1.734 1.734 0 0 0-1.097 1.097l-.387 1.162a.217.217 0 0 1-.412 0l-.387-1.162A1.734 1.734 0 0 0 9.31 6.593l-1.162-.387a.217.217 0 0 1 0-.412l1.162-.387a1.734 1.734 0 0 0 1.097-1.097l.387-1.162zM13.863.099a.145.145 0 0 1 .274 0l.258.774c.115.346.386.617.732.732l.774.258a.145.145 0 0 1 0 .274l-.774.258a1.156 1.156 0 0 0-.732.732l-.258.774a.145.145 0 0 1-.274 0l-.258-.774a1.156 1.156 0 0 0-.732-.732l-.774-.258a.145.145 0 0 1 0-.274l.774-.258c.346-.115.617-.386.732-.732L13.863.1z"></path> </symbol> <symbol
			id="sun-fill" viewBox="0 0 16 16"> <path
			d="M8 12a4 4 0 1 0 0-8 4 4 0 0 0 0 8zM8 0a.5.5 0 0 1 .5.5v2a.5.5 0 0 1-1 0v-2A.5.5 0 0 1 8 0zm0 13a.5.5 0 0 1 .5.5v2a.5.5 0 0 1-1 0v-2A.5.5 0 0 1 8 13zm8-5a.5.5 0 0 1-.5.5h-2a.5.5 0 0 1 0-1h2a.5.5 0 0 1 .5.5zM3 8a.5.5 0 0 1-.5.5h-2a.5.5 0 0 1 0-1h2A.5.5 0 0 1 3 8zm10.657-5.657a.5.5 0 0 1 0 .707l-1.414 1.415a.5.5 0 1 1-.707-.708l1.414-1.414a.5.5 0 0 1 .707 0zm-9.193 9.193a.5.5 0 0 1 0 .707L3.05 13.657a.5.5 0 0 1-.707-.707l1.414-1.414a.5.5 0 0 1 .707 0zm9.193 2.121a.5.5 0 0 1-.707 0l-1.414-1.414a.5.5 0 0 1 .707-.707l1.414 1.414a.5.5 0 0 1 0 .707zM4.464 4.465a.5.5 0 0 1-.707 0L2.343 3.05a.5.5 0 1 1 .707-.707l1.414 1.414a.5.5 0 0 1 0 .708z"></path> </symbol> </svg>
	<header data-bs-theme="dark">
		<c:import url="http://192.168.10.92/mybatis_prj/fragments/header.jsp" />
	</header>
	<main>
		
		<!-- Marketing messaging and featurettes
  ================================================== -->
		<!-- Wrap the rest of the page in another container to center all the content. -->
		<div class="container marketing">
			<!-- Three columns of text below the carousel -->
			<!-- /.row -->
			<!-- START THE FEATURETTES -->
			<hr class="featurette-divider">
			<div class="row featurette">
				<div>
					<div id="selectDiv">
						<select id="carCountry">
							<option value="N/A">---제조국선택---</option>
							<option value="국산">국산</option>
							<option value="수입">수입</option>
						</select>
						<select id="carMaker">
							<option value="N/A">---제조사선택---</option>
						</select>
						<select id="carModel">
							<option value="N/A">---모델선택---</option>
						</select>
						<input type="button" value="조회" id="btn" class="btn btn-info btn-sm"/>
					</div>
					<div id="carListDiv">
						<table class="table table-hover" id="carList">
							<thead>
								<tr>
									<th>이미지</th>
									<th>옵션</th>
									<th>연식</th>
									<th>가격</th>
									<th>배기량</th>
									<th>입력일</th>
								</tr>
							</thead>
							<tbody>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<hr class="featurette-divider">
			<!-- /END THE FEATURETTES -->
		</div>
		<!-- /.container -->
		
		<footer class="container">
			<c:import url="http://192.168.10.92/mybatis_prj/fragments/footer.jsp" />
		</footer>
	</main>
</body>
</html>