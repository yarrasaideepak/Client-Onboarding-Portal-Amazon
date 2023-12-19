<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<!DOCTYPE html>
<html>
<head>
	
	<!-- Adding BootStrap and giving reference to the styling page -->
		
	<meta charset="UTF-8">

	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

	<link href="${pageContext.request.contextPath}/resources/CSS/Style1.css" rel="stylesheet">

	<title>Update TPS</title>

</head>

<body>
	
	<!-- Adding Top Black color bar which you find on the top -->
	
	<div class="BlackBar">
  		<a class="active" href="#home" style="font-weight: bold;">TPS Request</a>	
  		<a href="val1" style="font-weight: bold;">Entity Access Request</a>
  		<a href="val2" style="font-weight: bold;">G2S2</a>
		<a href="#val2" style="margin-left: 900px;">Home</a>
		<a href="#val3" >ContactUs</a>
	</div>
	
	<!-- Adding Top Blue color bar which you find below blue bar -->
	
	<div class="BlueBar" style="background-color: #6666ff;">
  		<a  href="#Val4" >ALL CONFIGURED TPS</a>	
  		<a href="#Val5">TPS USAGE</a>
  		<a class="active" href="#Val6" style="text-decoration: underline;color:black;font-weight: bold;" >UPDATE TPS</a>
  		
	</div>
	
	<br><br>
	
	<!-- Adding some text to be displayed on the screen -->
	
	<h3 style="text-align:center;">Update TPS Value</h3><br>
	<h5 style="text-align:center;">Please Enter the Required Details</h5><br>
	
	
	<!-- Creating a form to taken input details like Fleet;Region;Stable TPS;Current TPS and Submitting the form -->
	
	<form style="text-align:center;"  id="Form1" onsubmit="Updated()">
		
		<!-- Drop-down menu for fleet selection -->
  		
  		Select Fleet: <select required name="Fleet" id="Fleet1"  onchange="CapOfFleet()" required>
  	 	<option value="" selected="selected" hidden="hidden"></option>
     	<option value="Tier1" >Tier1</option>
    	<option value="Tier2">Tier2</option>
    	<option value="Tier3">Tier3</option>
		<option value="Batch">Batch</option>  		
  		</select>
  	
  		<br></br>
		<!-- Drop-down menu for Region selection -->
		
		Select Region: <select required name="Region" id="Region1" onchange="CapOfFleet()" required>
		<option value= "" selected="selected" hidden="hidden"></option>
		<option value="NRT">NRT</option>
    	<option value="NA">NA</option>
    	<option value="EU">EU</option>
		<option value="PDX">PDX</option>  
		<option value="CN">CN</option>  		
  		</select>
	
		<br></br>
		
		<!-- Input-Boxes to enter details of TPS -->
		
		StableTPS (per host) : <input type="number " name="StableTPS"  required> <br><br>
		No of Hosts :  <input type="number" name="NoOfHosts"  required><br><br>
		CurrentTPS : <input type="number" name="CurrentTPS"  required><br><br> 
		
		<!-- Button to submit form -->
		<input type="submit" value="Update Values"  class="button button1"><br><br>
		

	</form>
	
	<!-- Function to be called after submission -->
	<script>
	function Updated(){
		if(${Result}==1){
			window.history.back();
			alert("Successfully Updated :)");
		}
		else{
			alert("Failed to Updated :(");
		}
	}
	</script>
	
	<!-- Adding a footer -->
	
	<footer>
    	<a href="1" style="color:white;">On-boarding Guide</a>
    	<a href="2" style="color:white;">Documentation</a>
    	<a href="2" style="color:white;">Report a Bug</a>
    </footer>


</body>

</html>
