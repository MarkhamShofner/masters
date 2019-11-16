<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>BHC Receipt</title>
	<jsp:useBean id="hike" class="HelloWorldJSP.Hike" scope="application" />        
</head>
<body>
	<h3><%= new java.util.Date() %></h3>
	<h2>Your first name is <jsp:getProperty name="hike" property="firstName" /></h2>
	<h2>Your last name is <jsp:getProperty name="hike" property="lastName" /></h2>
	<h2>Your hike is <jsp:getProperty name="hike" property="hikingOption" /></h2>
</body>
</html>