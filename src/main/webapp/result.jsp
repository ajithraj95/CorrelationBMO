<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BMO Correlation Calculation</title>
<link href="../css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
    <h1>Results</h1>
	<form class="u-clearfix u-form-spacing-10 u-form-vertical u-inner-form" name="form" style="padding: 10px;">
	
    	<div class="u-form-group">
			<label for="highFX" class="u-label">High USD/CAD</label>
			<input id="highFX" name="highFX" class="u-border-1 u-border-grey-30 u-input u-input-rectangle u-white" type="text" value="${highFX}" readonly>
        </div>
        <br>
        <div class="u-form-group">
        	<label for="lowFX" class="u-label">Low USD/CAD</label>
            <input id="lowFX" name="lowFX" class="u-border-1 u-border-grey-30 u-input u-input-rectangle u-white" type="text" value="${lowFX}" readonly>
        </div>
        <br>
        <div class="u-form-group">
			<label for="meanFX" class="u-label">Mean USD/CAD</label>
			<input id="meanFX" name="meanFX" class="u-border-1 u-border-grey-30 u-input u-input-rectangle u-white" type="text" value="${meanFX}" readonly>
        </div>
        <br>
        <div class="u-form-group">
        	<label for="highCorr" class="u-label">High CORRA</label>
            <input id="highCorr" name="highCorr" class="u-border-1 u-border-grey-30 u-input u-input-rectangle u-white" type="text" value="${highCORRA}" readonly>
        </div>
        <br>
        <div class="u-form-group">
			<label for="lowCorr" class="u-label">Low CORRA</label>
			<input id="lowCorr" name="lowCorr" class="u-border-1 u-border-grey-30 u-input u-input-rectangle u-white" type="text" value="${lowCORRA}" readonly>
        </div>
        <br>
        <div class="u-form-group">
        	<label for="meanCorr" class="u-label">Mean CORRA</label>
            <input id="meanCorr" name="meanCorr" class="u-border-1 u-border-grey-30 u-input u-input-rectangle u-white" type="text" value="${meanCORRA}" readonly>
        </div>
        <br>
        <div class="u-form-group">
			<label for="coefficient" class="u-label">Correlation Coefficient</label>
			<input id="coefficient" name="coefficient" class="u-border-1 u-border-grey-30 u-input u-input-rectangle u-white" type="text" value="${coefficient}" readonly>
        </div>
	</form>
</body>
</html>