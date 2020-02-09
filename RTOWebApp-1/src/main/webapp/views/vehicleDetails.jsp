<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>



<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js">
	
</script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

<script>
	$(function() {

		$('form[id="vehicleDetails"]').validate({
			rules : {

				companyName : 'required',
				mfdYear : 'required',
				vehicleType : 'required',

				
			},
			messages : {

				companyName : 'please enter company name',
				mfdYear : 'please select manufacture year',
				vehicleType : 'select select vehicle type',
				
			},
			submitHandler : function(form) {
				form.submit();
			}
		});
	});
</script>


<style>
.error {
	color: #FF0000
}
</style>
</head>
<body>
	<div class="container">
		<div class="card">
			<div class="card-header bg-info text-white">
				<h1>Welocme to Vehicle Dtails Page!!</h1>

			</div>

			<div class="card-body">
				<form:form id="vehicleDetails" action="saveVehicleDtls" modelAttribute="vehicleDtls"
				method="post" cssClass="form-group">
				<input type="hidden" name="ownerKey" value="${vehicleOwnerKey}"/>
				<input type="hidden" name="vehicleId" value="${vehicleDtls.vhicleDtlsId}"/>
		
		
					<div class="row">
						<div class="col-4"></div>
						<div class="col-4">
							<label for="companyName">Please Enter Company Name</label>

						</div>
						<div class="col-4">
							<form:input path="companyName" />
						</div>

					</div>
					<br />
					<div class="row">
						<div class="col-4"></div>
						<div class="col-4">
							<label for="mfdYear"> please Select
								ManufacturingYear</label>
						</div>
						<div class="col-4">
							<form:select path="mfdYear" >
								<form:option value="-1">select mfd year</form:option>
								<form:option value="2013">2013</form:option>
								<form:option value="2014">2014</form:option>
								<form:option value="2015">2015</form:option>
								<form:option value="2016">2016</form:option>
								<form:option value="2017">2017</form:option>
								<form:option value="2018">2018</form:option>
								<form:option value="2019">2019</form:option>


							</form:select>
						</div>

					</div>
		
					<div class="row">
						<div class="col-4"></div>
						<div class="col-4">
							<label for="vehicleType">Vehicle Type</label>
						</div>
						<div class="col-4">
							<form:select path="vehicleType">
								<form:option value=" " readOnly="true">--select--</form:option>
								<form:option value="2">Two-Wheeler</form:option>
								<form:option value="3-Wheer">Three-Wheeler</form:option>
								<form:option value="4">Four-Wheeler</form:option>
								<form:option value="6">Six-Wheeler</form:option>
								<form:option value="8">Eight-Wheeler</form:option>
								<form:option value="10">Ten-Wheeler</form:option>
							</form:select>
						</div>
					</div>

		

							<div align="center" class="text-info">
					<a href="prevToOwnerDtls?ownkey=${vehicleOwnerKey}" class="btn btn-outline-info"> &lt; Previous </a> 
					<input id="submitBtn" type="submit" value="Next >" class="btn btn-outline-success" />
				</div>
	

				</form:form>
			</div>
		</div>

	</div>



</body>
</html>