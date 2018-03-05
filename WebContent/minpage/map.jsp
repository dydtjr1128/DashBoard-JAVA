<!DOCTYPE html>
<html>
<head>
<style>
#map {
	height: 400px;
	width: 100%;
}
</style>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.4.0/Chart.min.js"></script>
</head>
<body>
	<h3>My Google Maps Demo</h3>

	<!-- <div style="width: 50%">
		<canvas id="myChart"></canvas>
	</div> -->
	<script>
	//	var ctx = document.getElementById('myChart').getContext('2d');
		var vLat = 37.581456;
		var vLng = 127.010085;
		var latlng;
		
		function initMap() {
			hansung = {
				lat : vLat,
				lng : vLng
			};
			map = new google.maps.Map(document.getElementById('map'), {
				zoom : 10,
				center : hansung
			});
			marker = new google.maps.Marker({
				position : latlng,
				map : map,
				title : "Hansung!"
			});
		
			
		}
		setInterval(
				function() {
					url = "http://localhost:8080/dashboard-0.1/DataController/location"
					var xhr = new XMLHttpRequest;
					xhr.open('get', url);
					xhr.onload = function() {
						
						var myArr = JSON.parse(this.responseText);
						vLat=myArr[0].lat;
						vLng=myArr[0].lng;
					
						
						//cb(xhr.response);
					};
					xhr.send();
					
				}, 1000);
		
		setInterval(function(){
		
			alert("lat: "+ vLat);
			latlng = new google.maps.LatLng(vLat,vLng);
		    marker.setPosition(latlng);
		    map.setCenter(latlng);

		},5000)
	</script>





	<div id="map" style="width: 50%;"></div>
	<!-- <script>
	
		function initMap() {
			hansung = {
				lat : vLat,
				lng : vLng
			};
			map = new google.maps.Map(document.getElementById('map'), {
				zoom : 18,
				center : hansung
			});
			marker = new google.maps.Marker({
				position : hansung,
				map : map,
				title : "Hansung!"
			});
			marker2 = new google.maps.Marker({
				position : hansung,
				map : map,
				title : "Hansung!"
			});
			count = 0;
			x = 1;
			y = 1;
		}
		
	</script> -->
<script async defer
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCvEOqHnPE2pwYnIxREmsbOpvXZYtTbthY&callback=initMap">
		
	</script>
<!-- 
	<script>
		var chart = new Chart(ctx, {
			// The type of chart we want to create
			type : 'line',

			// The data for our dataset
			data : {
				labels : [ "January", "February", "March", "April", "May",
						"June", "July" ],
				datasets : [ {
					label : "My First dataset",
					backgroundColor : 'rgb(255, 99, 132)',
					borderColor : 'rgb(255, 99, 132)',
					data : [ 0, 10, 5, 2, 20, 30, 45 ],
				} ]
			},

			// Configuration options go here
			options : {}
		}); -->
	</script>
</body>
</html>