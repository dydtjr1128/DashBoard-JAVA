<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Meta, title, CSS, favicons, etc. -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="icon" href="images/favicon.ico" type="image/ico" />
<%@include file="../include/header.jsp"%>
<title>Gentelella Alela! |</title>


</head>
<body>

	<div class="animated flipInY col-lg-3 col-md-3 col-sm-6 col-xs-12">
		<div class="tile-stats">
			<span class="count_top"><i class="fa fa-user"></i> Total Users</span>
			<div class="count" id="connector"></div>
			<h3>Current connected devices</h3>
			<!-- <p>Lorem ipsum psdea itgum rixt.</p> -->
		</div>
	</div>


	<script type="text/javascript">
		var value1 = document.getElementById("connector");
		setInterval(
				function() {
					url = "http://localhost:8080/dashboard-0.1/DataController/connector"
					var xhr = new XMLHttpRequest;
					xhr.open('get', url);
					xhr.onload = function() {

						value1.innerHTML = xhr.responseText;
						//cb(xhr.response);
					};
					xhr.send();
				}, 1000);
	</script>



</body>
</html>
</body>
</html>