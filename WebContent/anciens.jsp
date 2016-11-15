<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

    
<%@ taglib prefix="s" uri="/struts-tags" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Anciens</title>
</head>
<body>
	<center><div>
	
		<h1>Infos Anciens</h1>
		
		<s:if test="%{#application.listAnciens.size()>0}">
       <s:iterator value="%{#application.listAnciens}">
		nom : <s:property value ="nom"/><br/>	
		prenom : <s:property value = "prenom"/><br/>
		promo : <s:property value = "promotion.annee"/><br/>
		libellepromo : <s:property value = "promotion.nom"/><br/>
		nomentreprise m1 : <s:property value = "m1.nom"/><br/>
		nomentreprise m2: <s:property value = "m2.nom"/><br/>
		
		</s:iterator>
		</s:if>
		<s:else>
		liste Anciens vides
		</s:else>
		<a href="/Projetstruts/">Ajouter un ancien</a>
	</div>
	</center>
	
</body>
</html>