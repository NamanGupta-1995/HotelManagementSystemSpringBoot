<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
	rel="stylesheet">
<link href="https://use.fontawesome.com/releases/v5.7.2/css/all.css"
	rel="stylesheet">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"
	rel="stylesheet">

<style>
.divider:after, .divider:before {
	content: "";
	flex: 1;
	height: 1px;
	background: #eee;
}

.h-custom {
	height: calc(100% - 73px);
}

@media ( max-width : 450px) {
	.h-custom {
		height: 100%;
	}
}
</style>
</head>
<body>
	<div class="login-container">
		<form class="login-element" method="post" action="login.htm">
			<section class="vh-100">
				<div class="container-fluid h-custom">
					<div
						class="row d-flex justify-content-center align-items-center h-100">
						<div class="col-md-9 col-lg-6 col-xl-5">
							<img
								src="https://image.shutterstock.com/image-photo/real-estate-luxury-interior-exterior-600w-660324757.jpg"
								class="img-fluid" alt="Sample image">
						</div>
						<div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1">
							<form class="login-element" method="post" action="login.htm">
								<div>
								<h3> WELCOME TO MANDARIN ORIENTEL - THE HOLET GROUP</h3>
								</div>

								<div class="divider d-flex align-items-center my-4">
									<p class="text-center fw-bold mx-3 mb-0">Or</p>
								</div>

								<!-- Email input -->
								<div class="form-outline mb-4">
									<select name="inputRole" class="form-control form-control-lg">
										<option>Select role</option>
										<option>Admin</option>
										<option>Manager</option>
										<option>Receptionist</option>
										<option>Customer</option>
									</select> <label class="form-label" for="form3Example3">Please
										select if you are logging in as a customer or employee</label>
								</div>

								<div class="form-outline mb-4">
									<input type="email" name="email" id="form3Example3"
										class="form-control form-control-lg"
										placeholder="Enter a valid email address" /> <label
										class="form-label" for="form3Example3">Email address</label>
								</div>

								<!-- Password input -->
								<div class="form-outline mb-3">
									<input type="password" name="password" id="form3Example4"
										class="form-control form-control-lg"
										placeholder="Enter password" /> <label class="form-label"
										for="form3Example4">Password</label>
								</div>



								<button type="submit" class="btn btn-primary btn-lg"
									style="padding-left: 2.5rem; padding-right: 2.5rem;">Login</button>
							</form>

							<form method="get" action="register.htm">
								<div class="text-center text-lg-start mt-4 pt-2">

									<p class="small fw-bold mt-2 pt-1 mb-0">
										Already visited our property? You can create account here..
										<button type="submit" class="btn btn-primary btn-sm"
											style="padding-left: 2.5rem; padding-right: 2.5rem;">REGISTER</button>
									</p>
								</div>
							</form>

						</div>
					</div>
				</div>
				<div style="background-color: green;"
					class="d-flex flex-column flex-md-row text-center text-md-start justify-content-between py-4 px-4 px-xl-5 bg-primary">
					<!-- Copyright -->
					<div class="text-white mb-3 mb-md-0">Copyright © 2020. All
						rights reserved.</div>
					<!-- Copyright -->

					<!-- Right -->
					<div>
						<a href="#!" class="text-white me-4"> <i
							class="fab fa-facebook-f"></i>
						</a> <a href="#!" class="text-white me-4"> <i
							class="fab fa-twitter"></i>
						</a> <a href="#!" class="text-white me-4"> <i
							class="fab fa-google"></i>
						</a> <a href="#!" class="text-white"> <i
							class="fab fa-linkedin-in"></i>
						</a>
					</div>
					<!-- Right -->
				</div>
			</section>
</body>
</html>