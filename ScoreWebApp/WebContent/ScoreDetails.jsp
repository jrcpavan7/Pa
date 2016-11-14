<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<style>
body {
      background-image:url('image.jpg');
          background-position: 0 0;
    background-size: cover;
    }
    h3{
     color: rgb(255, 189, 88);
    font-family: Georgia, serif;
    font-size: 160%;}</style>
   
</head>
<body>
<div class="container-fluid">
		
			<div class="container-page">
				<div class="col-md-6">
<h3>Team Registration</h3>

<form action="ScoreController" method="get">
<h3>
Name: <br/><input type="text" name="teamname" >
 </h3><br/>
<h3>Team Members (Maximum of 4):
<input type="text" name="teammembers" onkeypress='return event.charCode >= 48 && event.charCode <= 57'>
 </h3><br/>
<h3>Name of Team Leader:<br/>
<input type="text" name="teamleadername">
 <br/>
 </h3>
 <h3>Use case:<br/><input type="text" name="usecasegiven" ><br/>
     <br/>
  </h3>   
   
	  <button type="submit" class="btn btn-default">Submit</a></button>
<br/>

</form>
	</div>
	</div>
			
	</div>
	
</body>
</html>