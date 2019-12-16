<%-- 
    Document: index
	InspiredBy: Lecture notes on MVC2
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
		<meta charset="ISO-8859-1">
        <title>Beartooth Hiking</title>
        <script type = "text/javascript" src = "nsftoolsDatepicker.js" ></script>
		<script type = "text/javascript" src = "script.js" ></script>
		<link rel="stylesheet" href="nsftoolsDatepicker.css">
	</head>
    <body>
    	<h3><%= new java.util.Date() %></h3>
        <% 
        	if (true) {
        %>
		<h1>Beartooth Hiking Registration Guide:</h1>
       	<h2>Come Hike With Us</h2>
		<br /> Please Fill out the following fields:
		<br />
		<br />
	
	    <jsp:useBean id="hiking" class="HelloWorldJSP.Controller" scope="session" />        
		<form action="Controller" method=GET>
			First name: <input type="TEXT" name="firstName" value="Markham"> <br />
			Last Name: <input type="TEXT" name="lastName" value="Shofner"> <br />
			<br>
			<br>
			
			Hike:
			<input type="RADIO" name="hikingOption" value="Gardiner Lake" checked="checked">Gardiner Lake
			<input type="RADIO" name="hikingOption" value="Hellroaring Plateau">Hellroaring Plateau
			<input type="RADIO" name="hikingOption" value="Beaten Path">Beaten Path
			<br>
			<br>
			
			Party Size: <input type="number" name="partySize" value="1" onChange="partySizeChanged(value)">
			<br>
			<br>
			
			Start Date: <input name="StartDate">
			<input type=button value="select" onclick="displayDatePicker('StartDate', false, 'dmy', '.');">
			<br>
			<br>
			
			Duration:
			<input type="RADIO" name="durationOption" value="2" checked="checked">2
			<input type="RADIO" name="durationOption" value="3">3
			<input type="RADIO" name="durationOption" value="4">4
			<input type="RADIO" name="durationOption" value="5">5
			<input type="RADIO" name="durationOption" value="7">7
			<br>
			<br>
			
			<input type="SUBMIT">
		</form>
        <%
        	} else {
        %>
        	Error state management.
       	<%
        	}
        %>
    </body>
</html>
