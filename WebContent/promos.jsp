<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Promotions</title>
</head>
<body>
	<center><div>
	
		<h1>Infos Promo</h1>
		<s:if test="%{#application.listPromos.size()>0}">
       <s:iterator value="%{#application.listPromos}">
		annee : <s:property value ="annee"/><br/>	
		
		libelle :<s:property value = "nom"/><br/>
		
		<s:url action="libelle" var="urlTag" >
    	<s:param name="libellepromo"><s:property value ="nom"/></s:param>
    	<s:param name="idPromo"><s:property value ="annee"/></s:param>
		</s:url>
		
		<s:a href="%{urlTag}"><s:property value ="nom"/></s:a>
		<br/>	
		</s:iterator>
		</s:if>
		<s:else>
		
		la liste est vide
		</s:else>
		
		<a href="/Projetstruts/">Ajouter une promo</a>
	
		
	</div>
	</center>
	
</body>
</html>