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

			<h1>listeCarriere</h1>






			<s:form name="carriereForm" action="carriere" method="post">



				<s:select label="nouvelleEntreprise" headerKey="-1"
					headerValue="Select entreprise"
					list="%{#application.listEntreprises}" listValue="nom"
					listKey="nom" name="nouvelleEntreprise" />
				<select name="idAncien">
					
						<option value="${param.idAncien}">${param.idAncien}</option>
					
				</select>
				<s:submit name="majCarriere" value="majCarriere"></s:submit>

			</s:form>






			<a href="/Projetstruts/">Ajouter une entreprise</a>




		</div>
	</center>

</body>
</html>


