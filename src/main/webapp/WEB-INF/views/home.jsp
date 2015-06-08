<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
</head>
<body>
	<h1>Hello world!</h1>

	<P>The time on the server is ${serverTime}.</P>


	<div class="container" style="width: 20%">

		<form class="form-signin"  commandName="user" th:action="@{/home}" th:object="${user}"
			method="post">
			<h2 class="form-signin-heading">Please sign up</h2>
			<label for="userName" class="sr-only">Email address</label> <input
				type="email" id="userName" name="userName" class="form-control" placeholder="Email address"
				required autofocus th:action="*{userName}"> <label
				for="password" class="sr-only">Password</label> <input
				type="password" class="form-control" id="password" name="password" placeholder="Password" required
				th:action="*{password}">
			<div class="checkbox">
				<label> <input type="checkbox" value="remember-me">
					Remember me
				</label>
			</div>
			<button class="btn btn-lg btn-primary btn-block" type="submit"
				value="submit">sing up</button>
		</form>

	</div>




	<table class="table table-striped">

	</table>
</body>
</html>
