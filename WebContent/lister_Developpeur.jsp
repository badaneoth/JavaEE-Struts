<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lister les developpeurs</title>
</head>
<body>
	<center><div>
		<center><h2>Liste des développeurs sur developpez.com</h2></center>
		
		  <s:if test="%{listDeveloppeurs.size()>0}">
				<s:iterator value="listDeveloppeurs"><br/>
				
					Identifiant : <s:property value="identifiant"/><br/>
					Pseudo : <s:property value="pseudo"/><br/>
					Mail : <s:property value="mail"/><br/>
					Code postale : <s:property value="codePostal"/><br/>
					Date d'inscription : <s:property value="dateInscription"/><br/>
					</s:iterator>
					</s:if>
					<s:else>
						Aucun développeur dans la liste
					</s:else>
				

		</div>
		<p></p>
		<a href="saisir_Developpeur.action">Ajouter un développeur</a><br/>
		<a href="supprimer_Developpeur.action">Supprimer les développeurs</a>

		</center>

</body>
</html>