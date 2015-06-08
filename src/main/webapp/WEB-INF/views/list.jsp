<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<script
	src="http://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>
<script>
	var app = angular.module('myApp', []);
	app.controller('customersCtrl', function($scope, $http) {

		$scope.graph = {};
		$http.get('http://localhost:8080/web/user/all.json').success(
				function(response) {
					console.log(response.records);

					$scope.User = response;
					$scope.graph.posts = response;
				});
	});
</script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
</head>
<body>
<div class="container">
	<div ng-app="myApp" ng-controller="customersCtrl">
		<p>Filtering input:</p>
		
		<div class="input-group">
			<input class="form-control" type="text" ng-model="test" aria-describedby="basic-addon1">
			<span class="glyphicon glyphicon-search input-group-addon" aria-hidden="true" id="basic-addon1"></span>
		</div>
		
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Firstname</th>

				</tr>
			</thead>
			<tbody>
				<tr ng-repeat="x in User | filter:test | orderBy:'userName'">
					<td>{{ (x.userName | uppercase) }}</td>
				</tr>
			</tbody>
		</table>

	</div>
	</div>
</body>
</html>