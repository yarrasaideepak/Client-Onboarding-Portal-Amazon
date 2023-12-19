<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">


<title>COP Portal</title>
<link rel="shortcut icon" type="image/jpg" href="${pageContext.request.contextPath}/resources/images/Logo2.jpg">

<link href="${pageContext.request.contextPath}/resources/CSS/Look.css" rel="stylesheet">

<script src="${pageContext.request.contextPath}/resources/JS/Functions.js"></script>

</head>

<body >

	<div class="topnav">
  		<a class="active" href="#home" style="font-weight: bold;">TPS Request</a>	
  		<a href="#news" style="font-weight: bold;">Entity Access Request</a>
  		<a href="#contact" style="font-weight: bold;">G2S2</a>
		<a href="#news1" style="margin-left: 900px;">Home</a>
		<a href="#news2" >ContactUs</a>
	</div>
	
	<div class="topnav1" style="background-color: #6666ff;">
		
  		<a  href="#home3" >ALL CONFIGURED TPS</a>	
  		<a href="#news3">TPS USAGE</a>
  		<a class="active" href="#contact3" style="text-decoration: underline;color:black;font-weight: bold;" >REQUESTS</a>
  		
	</div>

	<link href="${pageContext.request.contextPath}/resources/CSS/Look.css" rel="stylesheet">

	<br><br>	
	<h3 style="text-align:center;">Client Onboarding Portal</h3><br>
	<h5 style="text-align:center;">Please Enter the Required Details to Onboard</h5><br>
	
	<form style="text-align:center;"  id="Form1" onsubmit="return false">
		
  		Select Fleet: <select required name="Fleet" id="Fleet1"  onchange="CapOfFleet()" >
  	 	<option value="" selected="selected" hidden="hidden"></option>
     	<option value="Tier1" >Tier1</option>
    	<option value="Tier2">Tier2</option>
    	<option value="Tier3">Tier3</option>
		<option value="Batch">Batch</option>  		
  		</select>
  		
  		
		<br></br>
		
		Select Region: <select required name="Region" id="Region1" onchange="CapOfFleet()" required>
		<option value= "" selected="selected" hidden="hidden"></option>
		<option value="NRT">NRT</option>
    	<option value="NA">NA</option>
    	<option value="EU">EU</option>
		<option value="PDX">PDX</option>  
		<option value="CN">CN</option>  		
  		</select>
		<br></br>
		
		<script>
			var Reg = "${RegionName}";
			var Flet = "${FleetName}";
			setVal(Reg,Flet)
		</script>
		
		Fleet selected : <b>  ${FleetName} </b>  <br><br>
		Region Selected : <b> ${RegionName} </b> <br><br>
		
		
	
		
		TPS Fleet can Handle: <b> ${Capacity} </b> <br><br>
		
		Enter TPS Required:<input style="text-align:center;" type="number" name="TPS" id="TPSVal" style="width: 6%" value=0 min=0 required><br><br> 
		
		<button type="submit"  onclick="showResult();" class="button">Process</button>
	
	</form>
	
	
	<script>
	
	function showResult() {
		if(("${RegionName}"=="")|| ("${FleetName}"=="")){
			alert("Please choose the Fleet and Region");
		}
		
		else {if((document.getElementById("TPSVal").value) <= ${Capacity}){
	  		alert("Congrats!! your container has been created :)");
	  		/* document.getElementById("Form1").reset(); */
	  		window.history. back();
	  	}
	  	else {
	  		alert("Sorry your container cannot be created :(");
	  	}}
	}

  	</script>
  	
  	<footer>
    	<a href="1" style="color:white;">On-boarding Guide</a>
    	<a href="2" style="color:white;">Documentation</a>
    	<a href="3" style="color:white;">Report a Bug</a>
    </footer>

	
	
</body>
</html>