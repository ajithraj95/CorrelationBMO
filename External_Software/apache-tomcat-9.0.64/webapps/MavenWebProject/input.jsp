<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BMO Correlation Calculation</title>
<link href="${pageContext.request.contextPath}/WebContent/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
    <h1>Inputs for Start Date and End Date</h1>
	<form action="correlationServlet" method="POST" class="u-clearfix u-form-spacing-10 u-form-vertical u-inner-form" name="form" style="padding: 10px;">
	
    	<div class="u-form-group">
        	<label for="startDate" class="u-label">Start Date</label>
            <input id="startDate" name="startDate" class="u-border-1 u-border-grey-30 u-input u-input-rectangle u-white" type="date">
        </div>
        <br>
        <div class="u-form-group">
        	<label for="endDate" class="u-label">End Date</label>
            <input id="endDate" name="endDate" class="u-border-1 u-border-grey-30 u-input u-input-rectangle u-white" type="date">
        </div>
        <br>
    	<input type="submit" value="Calculate" />
        <h2>${error}</h2>
        <br>
	</form>
</body>
</html>