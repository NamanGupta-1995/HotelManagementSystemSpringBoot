<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=League+Spartan&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/css/bootstrap.min.css">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<style>
html {
	background-color: #8f9659; //
	background-image: linear-gradient(135deg, #8BC6EC 0%, #9599E2 100%);
	background-size: cover;
}

body {
	/* background: url('https://www.fifaultimateteam.it/en/wp-content/uploads/2019/05/copertina_tots_pl_fut_19.png');
	background-color: #ccc; */
	background-repeat: no-repeat;
	background-size: cover;
	height: 100vh;
	background: #8f9659 !important;
}

div {
	padding: 20px 0;
}

@import "compass/css3";

@import 'https://fonts.googleapis.com/css?family=Montserrat:300,400,700'
	;

#main-menu .nav-bar {
	list-style: none;
	margin-top: 40px;
	margin-bottom: 10px;
}

#main-menu .nav-bar ul {
	white-space: nowrap;
}

#main-menu .nav-bar li {
	display: inline;
	padding: 0 10px;
}

#main-menu .nav-bar li a {
	text-decoration: none;
	padding-left: 25px;
	text-transform: uppercase;
	color: #333;
	text-shadow: 1px 1px 1px #ccc;
}

.nav-bar .nav-button-home a {
	background:
		url("https://www.cheesetoast.co.uk/cheesepress/wp-content/uploads/2012/08/home.gif")
		no-repeat 0px -2px transparent;
}

.nav-bar .nav-button-services a {
	background:
		url("https://www.cheesetoast.co.uk/cheesepress/wp-content/uploads/2012/08/services.gif")
		no-repeat 0px -2px transparent;
}

.nav-bar .nav-button-products a {
	background:
		url("https://www.cheesetoast.co.uk/cheesepress/wp-content/uploads/2012/08/products.gif")
		no-repeat 0px -2px transparent;
}

.rwd-table {
	margin: 1em 0;
	min-width: 300px;
}

.rwd-table tr {
	border-top: 1px solid #ddd;
	border-bottom: 1px solid #ddd;
}

.rwd-table th {
	display: none;
}

.rwd-table td {
	display: block;
}

.rwd-table td input {
	display: block;
	background-color: rgb(52 73 94/ 0%);
	color: White;
	border: none;
}

.rwd-table td:first-child {
	padding-top: 0.5em;
}

.rwd-table td:last-child {
	padding-bottom: 0.5em;
}

.rwd-table td:before {
	content: attr(data-th) ": ";
	font-weight: bold;
	width: 6.5em;
	display: inline-block;
}

@media ( min-width : 480px) {
	.rwd-table td:before {
		display: none;
	}
}

.rwd-table th, .rwd-table td {
	text-align: left;
}

@media ( min-width : 480px) {
	.rwd-table th, .rwd-table td {
		display: table-cell;
		padding: 0.25em 0.5em;
	}
	.rwd-table th:first-child, .rwd-table td:first-child {
		padding-left: 0;
	}
	.rwd-table th:last-child, .rwd-table td:last-child {
		padding-right: 0;
	}
}

body {
	padding: 0 2em;
	-webkit-font-smoothing: antialiased;
	text-rendering: optimizeLegibility;
	color: #444;
	background: #eee;
	font-family: 'Quicksand', sans-serif;
}

.close:focus {
	outline: 1px dotted #fff !important
}

.modal-body {
	padding: 0rem !important
}

.modal-title {
	color: #fff
}

.modal-header {
	background: #39400e;
	color: #fff !important
}

.fa-close {
	color: #fff
}

.heading {
	font-weight: 500 !important
}

.subheadings {
	font-size: 12px;
	color: #9c27b0
}

.dots {
	height: 10px;
	width: 10px;
	background-color: green;
	border-radius: 50%;
	display: inline-block;
	margin-right: 5px
}

h1 {
	font-weight: normal;
	letter-spacing: -1px;
	color: #34495e;
}

.rwd-table {
	background: rgb(52 73 94/ 90%);
	color: #fff;
	border-radius: 0.4em;
	margin-left: auto;
	margin-right: auto;
	box-shadow: 0 8px 10px 1px rgba(0, 0, 0, .14), 0 3px 14px 2px
		rgba(0, 0, 0, .12), 0 5px 5px -3px rgba(0, 0, 0, .2);
}

.rwd-table tr {
	border-color: #46637f;
}

.rwd-table th, .rwd-table td {
	margin: 0.5em 1em;
}

@media ( min-width : 480px) {
	.rwd-table th, .rwd-table td {
		padding: 1em !important;
	}
}

.rwd-table th, .rwd-table td:before {
	color: #dd5;
}

.TeamList {
	margin: 20px 0;
}

select {
	border: none;
	background-color: inherit;
	font-size: 20px;
}

select:focus-visible {
	outline-offset: 0px;
	border: none;
}

.selectButton {
	border: none;
}

.scoreUpdate {
	background: inherit;
	color: White;
	border: solid;
}

section {
	background: inherit;
	color: #3c195b;
}

section div {
	display: flex;
	flex-wrap: nowrap;
	white-space: nowrap;
	min-width: 100%;
}

section div .news-message {
	display: flex;
	flex-shrink: 0;
	height: 50px;
	align-items: center;
	animation: slide-left 20s linear infinite;
}

section div .news-message p {
	font-size: 1.5em;
	font-weight: 100;
	padding-left: 0.5em;
}

@
keyframes slide-left {from { -webkit-transform:translateX(0);
	transform: translateX(0);
}

to {
	-webkit-transform: translateX(-100%);
	transform: translateX(-100%);
}
}
</style>



</head>
<body>

	<nav id="main-menu">
		<ul class="nav-bar">
			<li class="nav-button-home"><img
				src='https://www.logo.wine/a/logo/Mandarin_Oriental_Hotel_Group/Mandarin_Oriental_Hotel_Group-Logo.wine.svg'
				style="width: 10%; object-fit: contain;" /></li>
			<li style='position: absolute;'>
				<section>
					<div>
						<section class="news-message">
							<p>Deluxe Room -</p>
							<p>Semi-Deluxe Room -</p>
							<p>Normal Room -</p>
							<p>Cottages -</p>
							<p>Family Suite -</p>
							<p>Duplex Villa -</p>
							<p>President Suite -</p>

						</section>

					</div>
				</section>
			</li>
		</ul>
	</nav>
	<div id="exampleModal" tabindex="-1"
		aria-labelledby="exampleModalLabel">
		<form action="feedbackSubmit.htm" method="post">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">THANK YOU FOR
							CHOOSING TO STAY WITH US..</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close"></button>
					</div>
					<div class="modal-body">
						<div class="row g-0">
							<div class="col-md-8 border-right">
								<div class="status p-3">
									<table class="table table-borderless">
										<tbody>
											<tr>
												<td>
													<div class="d-flex flex-column">
														<span class="heading d-block">Hotel</span> <span
															class="subheadings">MANDARIN ORIENTAL</span>
													</div>
												</td>
												<td>
													<div class="d-flex flex-column">
														<span class="heading d-block">Date of Check-in</span> <input
															name="checkindate" type="date" class="subheadings" required>
													</div>
												</td>
												<td>
													<div class="d-flex flex-column">
														<span class="heading d-block">Length Of Stay</span> <input
															name="days" type="text" placeholder="in days"
															class="subheadings" required>
													</div>
												</td>
											</tr>
											<tr>
												<td>
													<div class="d-flex flex-column">
														<span class="heading d-block">Room Number</span> <input
															name="room" type="number" class="subheadings">
													</div>
												</td>
												<td>
													<div class="d-flex flex-column">
														<span class="heading d-block">Manager Attended</span> <input
															name="manager" type="text" placeholder="Name"
															class="subheadings" required>
													</div>
												</td>
												<td>
													<div class="d-flex flex-column">
														<span class="heading d-block">Reason of visit</span> <input
															name="reason" type="text" class="subheadings" required>
													</div>
												</td>
											</tr>
											<tr>
												<td>
													<div class="d-flex flex-column">
														<span class="heading d-block">Ratings(0-5)</span> <input
															type="number" min="0"
															onkeyup="if(value<0 || value>5) value=0;" max="5"
															name="rating" class="subheadings" required>
													</div>
												</td>
												<td colspan="2">
													<div class="d-flex flex-column">
														<span class="heading d-block">Feedback for us</span> <input
															name="feedback" type="text" class="subheadings" required>
													</div>
												</td>
											</tr>
											<tr>
												<td>
													<div class="d-flex flex-column">
														<span class="heading d-block">FOLLOW US ON</span> <span
															class="d-block subheadings">Get All The Latest
															Updates</span> <span class="d-flex flex-row"> <a
															href="https://www.instagram.com/"><img
																src="https://img.icons8.com/color/344/instagram-new--v2.png"
																class="rounded" width="30" /></a> <a
															href="https://www.facebook.com/"><img
																src="https://img.icons8.com/color/344/facebook-new.png"
																class="rounded" width="30" /></a>
														</span>
													</div>
												</td>

											</tr>
										</tbody>
									</table>
								</div>
							</div>
							<div class="col-md-4">
								<div class="p-2 text-center">
									<div class="profile">
										<img
											src="https://www.logo.wine/a/logo/Mandarin_Oriental_Hotel_Group/Mandarin_Oriental_Hotel_Group-Logo.wine.svg"
											width="100" class="rounded-circle img-thumbnail"> <span
											class="d-block mt-3 font-weight-bold">MANADARIN HOTEL</span>
									</div>
									<div class="about-doctor">
										<table class="table table-borderless">
											<tbody>
												<tr>
													<td>
														<div class="d-flex flex-column">
															<span class="heading d-block">Location</span> <span
																class="subheadings">Boston</span>
														</div>
													</td>
													<td>
														<div class="d-flex flex-column">
															<span class="heading d-block">Services</span> <span
																class="subheadings">Stay, Restaurant, Shopping</span>
														</div>
													</td>
												</tr>
												<tr>
													<td>
														<div class="d-flex flex-column">
															<span class="heading d-block">Controlled By</span> <span
																class="subheadings">The Hotel Group</span>
														</div>
													</td>
													<td>
														<div class="d-flex flex-column">
															<span class="heading d-block">Contact Us</span> <span
																class="subheadings">1234567890</span>
														</div>
													</td>
												</tr>
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
	</div>
	<div style="text-align: center;">
		<input style="color: #333;" class='scoreUpdate' type="submit"
			value="Submit Feedback">
	</div>

	</form>
	<form action="customer.htm" method="get">
		<h4>
			<input
				style="text-align: center; text-align: center; background-color: inherit; border: none; font-size: 18px;"
				type="submit" value="Go Back to home Page">
		</h4>
	</form>
</body>
</html>