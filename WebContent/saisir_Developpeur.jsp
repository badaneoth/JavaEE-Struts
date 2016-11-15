<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bienvenue</title>
<link href="/css/style.css" rel="stylesheet" type="text/css"/>

</head>
<body>

<center><h2>Bienvenue sur notre site </h2>



		<h3>Ajouter Promotion</h3>
	
		<s:form name="promoForm" action="promos" method="post" >
		<s:actionerror/>
			<s:textfield name="annee" cssClass="abc" id="annee"
				label="annee" labelposition="left">
			</s:textfield>
			
			<s:textfield name="libelle" id="libelle"
				label="libelle" labelposition="left">
			</s:textfield>	
			
			
			<s:submit name = "nouvellePromo" value="nouvellePromo"></s:submit>
		
		</s:form>
		<a href="promos/">lister les promos</a><br/>
	
	
	
	
	
	<h3>Ajouter Entreprise</h3>
		<s:form name="entrepriseForm"  action="entreprises" method ="post">
		<s:actionerror/>
			<s:textfield name="raisonSociale" id="raisonSociale"
				label="RaisonSociale" labelposition="left">
			</s:textfield>
			
			<s:textfield name="cp" id="cp"
				label="Cp" labelposition="left">
			</s:textfield>	
			
			<s:textfield name="ville" id="ville" 
				label="Ville" labelposition="left">
			</s:textfield>
			
			
			
			<s:submit name = "nouvelleEntreprise" value="nouvelleEntreprise"></s:submit>
		
		</s:form>
		<a href="entreprises/">lister les entreprises</a><br/>
		

	
	<h3>Ajouter Ancien</h3>
		
		<s:form name="ancienForm"  action="anciens" method ="post">
		<s:actionerror/>
			<s:textfield name="nom" id="nom"
				label="Nom" labelposition="left">
			</s:textfield>
			
			<s:textfield name="prenom" id="prenom"
				label="Prenom" labelposition="left">
			</s:textfield>	
			
			
			<s:select label="promotion" 
			headerKey="-1" headerValue="Select promo"
			list="%{#application.listPromos}" 
			listValue="annee" listKey="annee"
			name="promo" 
			 />
			
		<s:select label="entrepriseM1" 
			headerKey="-1" headerValue="Select entreprise"
			list="%{#application.listEntreprises}" 
			listValue="nom" listKey="nom"
			name="m1" 
			 />
			 <s:select label="entrepriseM2" 
			headerKey="-1" headerValue="Select entreprise"
			list="%{#application.listEntreprises}" 
			listValue="nom" listKey="nom"
			name="m2" 
			 />
			
			
			
			<s:submit name = "nouvelAncien" value="nouvelAncien"></s:submit>
		
		</s:form>
		<a href="anciens/">lister les anciens</a><br/>
		
	
	
</center>
</body>
</html>