<?php

$host="localhost";
$user="root";
$password="";
$database="test_db";

$ID="";
$fname="";
$lname="";
$grupa="";

mysqli_report(MYSQLI_REPORT_ERROR | MYSQLI_REPORT_STRICT);

try{
	$connect =mysqli_connect($host,$user,$password,$database);
}catch(Exception $ex) {
	echo 'Error';
}

function getPosts()
{
	$post=array();
	$post[0]=$_POST['ID'];
	$post[1]=$_POST['fname'];
	$post[2]=$_POST['lname'];
	$post[3]=$_POST['grupa'];
	return $post;
}

//Search

if(isset($_POST['search'])){
$data=getPosts();

$searchQuery="SELECT * FROM users WHERE ID=$data[0]";
$search_Result = mysqli_query($connect,$searchQuery);

if($search_Result)
{
	if(mysqli_num_rows($search_Result))
	{
		while($row=mysqli_fetch_array($search_Result))
		{
			$ID=$row['ID'];
			$fname=$row['fname'];
			$lname=$row['lname'];
			$grupa=$row['grupa'];
		}
	}else{
		echo 'No Data For this ID';
	}
}else{
	echo 'Result ERORO';
}

}

if(isset($_POST['insert']))
{
	$data=getPosts();
	$insert_Query="INSERT INTO `users`(`ID`, `fname`, `lname`, `grupa`) VALUES ($data[0],'$data[1]','$data[2]','$data[3]')";
	try {
		$insert_Result =mysqli_query($connect,$insert_Query);

		if($insert_Result)
		{
			if(mysqli_affected_rows($connect) > 0 )
			{
				echo 'Data Inserted';
			}else{
				echo 'Data Not Inserted';
			}
		}

	} catch (Exception $ex) {
		echo 'EROROR Insert '.$ex->getMessage();
	}
}


if(isset($_POST['delete']))
{
	$data=getPosts();
	$delete_Query="DELETE FROM `users` WHERE `ID`= $data[0]";
	try {
		$delete_Result =mysqli_query($connect,$delete_Query);

		if($delete_Result)
		{
			if(mysqli_affected_rows($connect) > 0 )
			{
				echo 'Data Deleted';
			}else{
				echo 'Data Not Deleted';
			}
		}

	} catch (Exception $ex) {
		echo 'EROROR Delete '.$ex->getMessage();
	}
}


?>



<!DOCTYPE Html>
<html>
<head>
<title>Introducerea Datelor</title>
</head>
<body>
<form action="insert_data.php" method="post">
	<input type "number" name="ID" placeholder="ID-ul" value ="<?php echo $ID; ?>"><br><br>
<input type ="text" name="fname" placeholder="Numele" value ="<?php echo $fname; ?>" ><br><br>
<input type ="text" name="lname" placeholder="Prenumele" value ="<?php echo $lname; ?>" ><br><br>
<input type ="text" name="grupa" placeholder="Grupa" value ="<?php echo $grupa; ?>" ><br><br>
<div>
<input type ="submit" name="insert" value="Add">
<input type ="submit" name="delete" value="Delete">
<input type ="submit" name="search" value="Find">
</div>

</form>

</body>

<form action ="index.html" method="post">
	<br>
	<br>
<input type="submit" name ="search" value ="Inapoi"><br><br>

</form>


</html>