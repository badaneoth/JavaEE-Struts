<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Enregistrer un développeur</title>
</head>
<body>
	<center><div>
	
		<center><h2>Bienvnue sur developpez.com</h2></center>
		<h1>Infos Développeur</h1>
		Identifiant : <s:property value ="identifiant"/><br/>	
		Pseudo : <s:property value = "pseudo"/><br/>
		Email : <s:property value ="mail"/><br/>
		Email : <s:property value ="codePostal"/><br/>
		Date Inscription : <s:property value="dateInscription"/><br/>
		
		<a href="Saisir_Developpeur.action">Ajouter un développeur</a>
		<a href="lister_Developpeur.action">lister les développeurs</a><br/>
		
	</div>
	</center>
	
</body>
</html>