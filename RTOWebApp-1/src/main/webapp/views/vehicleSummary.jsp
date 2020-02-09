<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./views/css/bootstrap.min.css" />
<style type="text/css">
.text-right{
margin-left: 510px;
}

</style>
<meta charset="ISO-8859-1">
<title>Vehicle Details</title>
</head>
<body>
	<h2 class="h2 text-center text-primary">Vehicle Registration Summary...!!</h2>
	<span class="h4 text-left text-success">${msg} :: ${vchlReg.vehicleRegNumber}</span><a href="getForm" class="text-right btn btn-primary btn-lg" >Go Back To Home</a>
	<table class="table table-striped table-bordered">
		<tr><th colspan="2" class=" h3 text-center text-danger">Vehicle Registration Details</th></tr>
		<tr>
			<th>Vehicle Registration Id</th>
			<td>${vchlReg.vehicleRegId}</td>
		</tr>
		<tr>
			<th>Vehicle Reg. Number</th>
			<td>${vchlReg.vehicleRegNumber}</td>
		</tr>
		<tr>
			<th>Registration Center</th>
			<td>${vchlReg.regCenter}</td>
		</tr>
		<tr>
			<th>Registration Date</th>
			<td>${vchlReg.regDate}</td>
		</tr>
		<tr><th colspan="2" class=" h3 text-center text-danger">Vehicle Owner Details...</th></tr>
			<tr>
			<th>Vehicle Owner Name</th>
			<td>${vehicleOwnerDtls.fname} ${vehicleOwnerDtls.lname}</td>
		</tr>
		<tr>
			<th>Gender</th>
			<td>${vehicleOwnerDtls.gender}</td>
		</tr>
		<tr>
			<th>Birth Date</th>
			<td>${vehicleOwnerDtls.dob}</td>
		</tr>
		<tr>
			<th>Email</th>
			<td>${vehicleOwnerDtls.email}</td>
		</tr>
		<tr>
			<th>Contact Number</th>
			<td>${vehicleOwnerDtls.phno}</td>
		</tr>
			<tr>
			<th>SSN ID</th>
			<td>${vehicleOwnerDtls.zzn}</td>
		</tr>
		<tr><th colspan="2" class=" h3 text-center text-danger">Vehicle Information</th></tr>
		<tr>
			<th>Vehicle Type</th>
			<td>${vehicleDtls.vehicleType}</td>
		</tr>
		<tr>
			<th>Vehicle Company Name</th>
			<td>${vehicleDtls.companyName}</td>
		</tr>
		<tr>
		   <th>Manufactured Year</th>
			<td>${vehicleDtls.mfdYear}</td>
		</tr>
		<tr><th colspan="2" class=" h3 text-center text-danger" >Vehicle Owner Address....</th></tr>
		<tr>
			<th>House Number</th>
			<td>${ownerAddr.houseNo}</td>
		</tr>
		<tr>
			<th>Street Name</th>
			<td>${ownerAddr.streetName}</td>
		</tr>
		<tr>
			<th>City Name</th>
			<td>${ownerAddr.city}</td>
		</tr>
		<tr>
			<th>ZIP Code</th>
			<td>${ownerAddr.zip}</td>
		</tr>
	</table><br>
	<a href="registerForm" class="text-center btn btn-primary btn-lg" >Go Back To Home</a>
</body>
</html>