<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lister les promos</title>
</head>
<body>
	<center><div>

		  <s:if test="%{listPromos.size()>0}">
				<s:iterator value="listPromos"><br/>
				
					Annee : <s:property value ="annee"/><br/>	
		            Libelle : <s:property value = "libelle"/><br/>
					</s:iterator>
					</s:if>
					<s:else>
					Aucune promo dans la liste
					</s:else>
				

		</div>
		<p></p>
		<a href="saisir_Developpeur.action">Ajouter un développeur</a><br/>
		<a href="supprimer_Developpeur.action">Supprimer les développeurs</a>

		</center>

</body>
</html>