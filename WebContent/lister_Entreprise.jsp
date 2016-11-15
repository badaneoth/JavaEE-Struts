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
		
		
		  <s:if test="%{listEntreprises.size()>0}">
				<s:iterator value="listEntreprises"><br/>
				
					RaisonSociale : <s:property value ="Nom"/><br/>	
						Cp : <s:property value = "Codepostale"/><br/>
						Ville : <s:property value = "Ville"/><br/>
					</s:iterator>
					</s:if>
					<s:else>
						Aucune entreprise dans la liste
					</s:else>
				

		</div>
		<p></p>
		<a href="saisir_Developpeur.action">Ajouter une entreprise</a><br/>
		<a href="supprimer_Developpeur.action">Supprimer les développeurs</a>

		</center>

</body>
</html>