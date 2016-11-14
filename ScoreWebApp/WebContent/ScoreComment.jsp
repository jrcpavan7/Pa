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
     h1{
    color: rgb(255, 189, 88);
    font-family: Georgia, serif;
    font-size: 160%;}
      table{
     color: rgb(255, 189, 88);
    font-family: Georgia, serif;
    font-size: 160%;}</style>
</head>
<body>
 <?php
      $username = "root";
      $password = "murali";
      $host = "localhost";

      $connector = mysql_connect($host,$root,$murali)
          or die("Unable to connect");
        echo "Connections are made successfully::";
      $selected = mysql_select_db("test_db", $connector)
        or die("Unable to connect");

      //execute the SQL query and return records
      $result = mysql_query("SELECT * FROM teamusecases ");
		
      ?>
<div class="container-fluid">
		
			<div class="container-page">
				<div class="col-md-6">
<h1>Team Scores
</h1>
<form action="" method="get">

<table class="table">
  <thead>
    <tr>
      <th>TeamName</th>
      <th>Use Case</th>
      <th>Score</th>
      <th>Comments</th>
    </tr>
  </thead>
  <tbody>
  <?php
          while( $row = mysql_fetch_assoc( $result ) ){
            echo "";
          }
        ?>
   </tbody>
   
</table>
 
       <?php mysql_close($connector); ?>
  
<br/>

</form>
	</div>
	</div>
		
	</div>
	
</body>
</html>