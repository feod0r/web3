<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Регистрация</title>
	<script>

//alert(inputName);

function validate(){
	
}
function isValidForm(){
var inputName=document.getElementById("inputName").value;
	
	if(inputName == ""){
		alert("name field is empty");
		
		return false;
	
	} else {
		for(var i = 0; i < inputName.length - 1; i++){
		console.log(inputName);
		if((inputName[i]=="0" || inputName[i]=="1"|| inputName[i]=="2"|| inputName[i]=="3"|| inputName[i]=="4"|| inputName[i]=="5"|| inputName[i]=="6"|| inputName[i]=="7"|| inputName[i]=="8"|| inputName[i]=="9")){
			
			console.log("имя содержит цифры!");
					alert("поле Имя содержит цифры");
					return false;
		}
		}
		return true;
	}	
}
</script>
</head>
<body>
	<H1>Регистрация</H1>
	<form action = "MainServlet" method="POST" onsubmit="return isValidForm()">
		<input name="first_name" type="text" id="inputName"/>
		<input name="password" type="password"/><br>
		<input type="submit" onclick = "validate()"/>
	</form>
	<a href="SecondServlet">Авторизация</a>
</body>

</html>
