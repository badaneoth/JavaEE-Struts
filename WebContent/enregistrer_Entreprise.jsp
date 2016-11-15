<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Entreprises</title>
</head>
<body>
	<center><div>
	
		<h1>Infos Entreprise</h1>
		<s:if test="%{#application.listEntreprises.size()>0}">
       <s:iterator value="%{#application.listEntreprises}">
		RaisonSociale : <s:property value ="nom"/><br/>	
		Cp : <s:property value = "codepostale"/><br/>
				Ville : <s:property value = "ville"/><br/>
		
		</s:iterator>
		</s:if>
		<s:else>
		liste entreprises vides
		</s:else>
		<a href="Saisir_Developpeur.action">Ajouter une entreprise</a>
		<a href="lister_Entreprise.action">lister les entreprises</a><br/>
		
	</div>
	</center>
	
</body>
</html>