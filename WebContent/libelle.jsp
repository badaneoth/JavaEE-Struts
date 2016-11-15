<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Entreprises</title>
</head>
<body>
	<center>
		<div>

			<h1>ancienpromo</h1>

			<s:if test="%{#application.listAnciens.size()>0}">
				<s:iterator value="%{#application.listAnciens}">
      
		Nom : <s:property value="nom" />
					<br />
					
			<s:url action="carriereancien" var="urlTag" >
    	<s:param name="nomancien"><s:property value ="nom"/></s:param>
    	<s:param name="idAncien"><s:property value ="id"/></s:param>
		</s:url>
		
		<s:a href="%{urlTag}"><s:property value ="nom"/></s:a>
		
		</br>		
				</s:iterator>


			</s:if>
			<s:else>
		liste entreprises vides
		</s:else>


			<a href="/Projetstruts/">Ajouter une entreprise</a>




		</div>
	</center>

</body>
</html>


