<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Manage Managers</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=League+Spartan&display=swap"
	rel="stylesheet">

<style>
html{

background-color: #8f9659;
//background-image: linear-gradient(135deg, #8BC6EC 0%, #9599E2 100%);
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

div{
padding: 20px 0 ;
}

@import "compass/css3";

@import 'https://fonts.googleapis.com/css?family=Montserrat:300,400,700';

#main-menu .nav-bar { list-style:none; margin-top: 40px; }
#main-menu .nav-bar ul{overflow:hidden;
white-space:nowrap; }
#main-menu .nav-bar li { 	display:inline; padding:0 10px; }

#main-menu .nav-bar li a {
  text-decoration: none;
  padding-left: 25px;
  text-transform: uppercase;
  color: #333;
	text-shadow: 1px 1px 1px #ccc;
}

.nav-bar .nav-button-home a { background:url("https://www.cheesetoast.co.uk/cheesepress/wp-content/uploads/2012/08/home.gif") no-repeat 0px -2px transparent; }

.nav-bar .nav-button-services a { background:url("https://www.cheesetoast.co.uk/cheesepress/wp-content/uploads/2012/08/services.gif") no-repeat 0px -2px transparent; }

.nav-bar .nav-button-products a { background:url("https://www.cheesetoast.co.uk/cheesepress/wp-content/uploads/2012/08/products.gif") no-repeat 0px -2px transparent; }

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
	font-family: Montserrat, sans-serif;
	-webkit-font-smoothing: antialiased;
	text-rendering: optimizeLegibility;
	color: #444;
	background: #eee;
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
	overflow: hidden;
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

.scoreUpdate{
	background: inherit;
	color: White;
	border: none;
}


section {
	 background: inherit;
	 color: #3c195b;
	 overflow-x: hidden;
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
 @keyframes slide-left {
	 from {
		 -webkit-transform: translateX(0);
		 transform: translateX(0);
	}
	 to {
		 -webkit-transform: translateX(-100%);
		 transform: translateX(-100%);
	}
}
 
</style>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
<nav id="main-menu">
     <ul class="nav-bar">
          <li class="nav-button-home"><img src='https://www.logo.wine/a/logo/Mandarin_Oriental_Hotel_Group/Mandarin_Oriental_Hotel_Group-Logo.wine.svg' style="width: 10%;object-fit: contain;"/></li>
          <li style='position:absolute; '> 
          <section>
<div>
  <section 	class="news-message">
    <p>Deluxe Room - </p>
	<p>Semi-Deluxe Room  -  </p>
	<p>Normal Room  -  </p>
	<p>Cottages  -  </p>
	<p>Family Suite  -  </p>
	<p>Duplex Villa  -  </p>
	<p>President Suite -  </p>
    
    </section>
 
</div>
  </section>
          </li>
     </ul>
</nav>
	<div>
<table class="rwd-table" width="70%" align='center'>
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Contact</th>
						<th>Email</th>
						<th>Role</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${managerLists}" var="managerList">
						<tr>
							<td data-th="Manager ID">
							<c:out value="${managerList.getId()}"/>
							</td>
							<td data-th="Manager Name">
							<c:out value="${managerList.getName()}"/>
								</td>
							<td data-th="Manager Contact">
							<c:out value="${managerList.getContact()}"/>
							</td>
							<td data-th="Manager Email">
							<c:out value="${managerList.getEmail()}"/>
								</td>
						    <td data-th="Manager Role">
							<c:out value="${managerList.getRole()}"/>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

</div>
<div style="text-align: center;">
		<h3>PLEASE MANAGE MANAGER.</h3>
		<div style="height: 400px">
			<form action="addManager.htm" method="post">
				<h3>Create a new Manager here.</h3>
				<div>
					<label>Name : </label> <input type="text" name="newManagerName" placeholder="Name" required/>
				</div>
				<div>
					<label>Contact : </label>
					<input type="number" name="newManagerContact" placeholder="Contact" required/>
				</div>
				<div>
					<label>Email : </label>
					<input type="text" name="newManagerEmail" placeholder="Email" required/>
				</div>
				<div>
					<label>Password : </label>
					<input type="text" name="newManagerPassword" placeholder="Password" required/>
				</div>



				<input style="color: #333;" class='scoreUpdate' type="submit"
					value="ADD Manager">
		</form>
		</div>

		
	</div>
<form action="back.htm" method="get">
<h4><input style="text-align: center; text-align: center;
    background-color: inherit;
    border: none;
    font-size: 18px;" type="submit" value="Go Back to home Page"></h4>
</form>
</body>
</html>