<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<meta charset="utf-8">
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
	src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"> </script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

<script>
  
  
  
  $(function() {
	    $( "#datepicker" ).datepicker({
	        changeMonth: true,
	        changeYear: true
	      });
	    
	    

	    $('form[id="vehicleOwner"]').validate({
			rules : {
			
				fname :{
					required:true,
					minlength:6,
					maxlength:12
				},
				lname : {
					required:true,
					minlength:6,
					maxlength:12
				},
				dob : 'required',
				email : {
					required : true,
					email : true
				},
				phno :{
					required:true,
					minlength:10,
					maxlength:10
				} ,
				
				zzn  : 'required',
			},
			messages : {
			
				fname:
				{
					required : 'please enter your first name',
					minlength:'minimum 6 characters required',
					maxlength:'maximum 12 characters allowed'
				},
				lname : {
					required : 'please enter your last name',
					minlength:'minimum 6 characters required',
					maxlength:'maximum 12 characters allowed'
				},
				dob: 'enter your date of birth',
				email : 'enter your email address',
				phno: {
					required:'enter your mobile number must be 10 numbers',
				},
				
				zzn : 'enter your ssno',
				
			},
			submitHandler : function(form) {
				form.submit();
			}
		});
	});

  
	$('#zzn').keypress(function(e){
		console.log(e);
		console.log(typeof(e.which));
		if (e.which != 8 && e.which != 0 && (e.which < 48 || e.which > 57)) {
			return false;
		 }	
		else  if (e.which != 8 && e.which != 0 && (e.which <= 57 &&  e.which >= 48)) {
		var zzn1=$('#zzn').val();
				console.log(e);
			if(event.keyCode!='8'){
				console.log("jtkakasm");
				if(zzn1.length==6){
					$('#zzn').val(zzn1+'-');
					}
				else if(zzn1.length==3){
					$('#zzn').val(zzn1+'-');
				}
			}
		}
	});

});


  
  </script>


<style>
.error {
	color: #FF0000
}

.highlight-error {
	border-color: red;
}
</style>



</head>

<body>
	<div class="container">
		<div class="card">
			<div class="card-header bg-info text-white">
				<h1>WELCOME TO VEHICLE OWNER DETAILS PAGE</h1>

			</div>
			<div class="card-body">
				<form:form action="registerOwnerDlts" modelAttribute="vehicleOwnerDtls"
					method="post" cssClass="form-group">
					<input type="hidden" name="ownerId"
						value="${vehicleOwnerDtls.vhclOwnerid}" />
					<div class="row">
						<div class="col-4">
							<label for="fname">Enter your First Name:</label>
						</div>
						<div class="col-4">
							<form:input path="fname" />
						</div>
					</div>
					<br />

					<div class="row">
						<div class="col-4">
							<label for="lname">Enter Your Last Name:</label>
						</div>
						<div class="col-4">
							<form:input path="lname" />

						</div>
					</div>
					<br />

					<div class="row">
						<div class="col-4">
							<label for="dob">DOB</label>
						</div>
						<div class="col-4">
							<form:input path="dob" id="datepicker" />
						</div>
					</div>
					<br />

					<div class="row">
						<div class="col-4">
							<label for="gender">Gender</label>
						</div>
						<div class="col-4">
							<form:radiobutton path="gender" name="Male" />
							Male
							<form:radiobutton path="gender" name="FeMale" />
							FeMale
						</div>
					</div>
					<br />

					<div class="row">
						<div class="col-4">
							<label for="phno">Enter Your Phone Number</label>

						</div>
						<div class="col-4">
							<form:input path="phno" />

						</div>

					</div>
					<br />

					<div class="row">
						<div class="col-4">
							<label for="email">Enter your EmailId</label>
						</div>
						<div class="col-4">
							<form:input path="email" />
						</div>
					</div>
					<br />


					<div class="row">
						<div class="col-4">
							<label for="zzn">Enter Your ssn number:</label>
						</div>
						<div class="col-4">
							
							<form:input path="zzn"  placeholder="123-45-6789" maxLength="11"/>
							<fmt:formatNumber value="${zzn}" pattern="^(\d{3}-\d{3}-\d{4})*$" type=""/>
						</div>
					</div>
					<br />



					<div align="center" class="text-info">
						<input type="reset" value="clear" class="btn btn-outline-danger" />
						<input type="submit" value="Next >"
							class="btn btn-outline-success" />
					</div>

				</form:form>

			</div>
		</div>

	</div>
</body>
</html>