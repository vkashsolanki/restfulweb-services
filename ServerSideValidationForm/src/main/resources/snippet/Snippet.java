<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body style="background: #e2e2e2">
	<div class="container">
		<div class="row mt-5">
			<div class="col-md-6 offset-md-3">

				<form novalidate="novalidate" th:action="@{/success}" method="post" class="bg-white p-4" th:object="${formData}">
					<h1 class="text-center">Login Here</h1>

					<div class="mb-3">
						<label for="exampleInputEmail1" class="form-label">Email
							address</label> <input type="email" name="username"
							th:value="${formData.username}" class="form-control"
							th:classappend="${#fields.hasErrors('username')?'is-invalid':''}"
							id="exampleInputEmail1" aria-describedby="emailHelp">
							
							<div th:each="e : ${#fields.errors('username')}" th:text="${e}" id="validationServer03Feedback" class="invalid-feedback">
						</div>
					</div>
					<div class="mb-3">
						<label for="exampleInputPassword1" class="form-label">Password</label>
						<input type="password" name="password"
							th:value="${formData.password}" class="form-control"
							th:classappend="${#fields.hasErrors('password')?'is-invalid':''}"
							id="exampleInputPassword1">
						<button class="btn btn-outline-secondary mt-1" type="button" id="password-toggle">
							<span id="password-toggle-text">Show</span>
						</button>
						<div th:each="e : ${#fields.errors('password')}" th:text="${e}" id="validationServer03Feedback" class="invalid-feedback">
						</div>
					</div>
					<div class="mb-3 form-check">
						<input name="agreed" type="checkbox" class="form-check-input"
						th:classappend="${#fields.hasErrors('agreed')?'is-invalid':''}"
						 id="exampleCheck1">
						<label class="form-check-label" for="exampleCheck1">I agree Terms and Conditions</label>
					
						<div th:each="e : ${#fields.errors('agreed')}" th:text="${e}" id="validationServer03Feedback" class="invalid-feedback">
						</div>
					</div>
					<button type="submit" class="btn btn-primary">Login</button>
				</form>

			</div>
		</div>
	</div>
	
<script>
	const passwordInput = document.querySelector('input[name="password"]');
	const passwordToggle = document.querySelector('#password-toggle');
	const passwordToggleText = document.querySelector('#password-toggle-text');

	passwordToggle.addEventListener('click', function() {
		if (passwordInput.type === 'password') {
			passwordInput.type = 'text';
			passwordToggleText.textContent = 'Hide';
		} else {
			passwordInput.type = 'password';
			passwordToggleText.textContent = 'Show';
		}
	});
</script>
</body>
</html>

