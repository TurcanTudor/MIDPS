<?php


if(isset($_POST['search'])){

$valueToSearch=$_POST['valueToSearch'];
$query="SELECT * FROM `users` WHERE CONCAT(`ID`, `fname`, `lname`, `grupa`)LIKE'%".$valueToSearch."%'";
$search_result=filterTable($query);

}
else {

$query="SELECT * FROM `users`";
$search_result= filterTable($query);
}


function filterTable($query)
{
	$connect = mysqli_connect("localhost","root","","test_db");
	$filter_Result = mysqli_query($connect,$query);
	return $filter_Result;
}





?>

<!DOCTYPE html>
<html>
<head>
	<title>Filtru de Date</title>

<style>
table,tr,th,td{
	border:1px solid black;
}

</style>
</head>

<body>
<form action="table_data.php"method="post">

<input type ="text" name="valueToSearch" placeholder="valoarea pentru a Cauta"><br><br>
<input type="submit" name ="search" value ="Filtru"><br><br>

<table>
	<tr>
<th>ID</th>
<th>First name</th>
<th>Last Name </th>
<th>Grupa</th>



	</tr>
<?php while ($row=mysqli_fetch_array($search_result)):?>

<tr>
<td><?php echo $row['ID'];?></td>
<td><?php echo $row['fname'];?></td>
<td><?php echo $row['lname'];?></td>
<td><?php echo $row['grupa'];?></td>
</tr>
<?php endwhile;?>
</table>




	</body>
	</form>

<form action ="index.html" method="post">
	<br>
	<br>
<input type="submit" name ="search" value ="Inapoi"><br><br>

</form>

	</html>