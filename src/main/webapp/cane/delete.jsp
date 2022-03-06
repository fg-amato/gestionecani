<%@page import="it.prova.gestionecani.model.Cane"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="it" class="h-100"> 
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
	<!-- Common imports in pages -->
	 <jsp:include page="../header.jsp" />
	 <title>Rimozione Cane</title>
</head>
		<body class="d-flex flex-column h-100">
	   
	   		<!-- Fixed navbar -->
	   		<jsp:include page="../navbar.jsp"></jsp:include>
	    
			
			<!-- Begin page content -->
			<main class="flex-shrink-0">
			  <div class="container">
			  
			  		<div class='card'>
					    <div class='card-header'>
					        <h5>Sei sicuro di voler rimuovere il cane?</h5>
					    </div>
					       <c:set var = "caneInPagina" value = "${caneRichiesto}"></c:set>
					    
					
					    <div class='card-body'>
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Nome</dt>
							  <dd class="col-sm-9">${caneInPagina.nome}</dd>
					    	</dl>
					    	
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Razza:</dt>
							  <dd class="col-sm-9">${caneInPagina.razza}</dd>
					    	</dl>
					    	
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Peso:</dt>
							  <dd class="col-sm-9">${caneInPagina.peso}</dd>
					    	</dl>
					    	
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Data di Adozione:</dt>
							  <dd class="col-sm-9"><fmt:formatDate pattern="dd/MM/yyyy" value="${attivitaInPagina.data}" /></dd>
					    	</dl>
					    	
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Età:</dt>
							  <dd class="col-sm-9">${caneInPagina.peso}</dd>
					    	</dl>
					    	
					    </div>
					    
					    <div class='card-footer'>
					    	<form method="post" action="ExecuteDeleteCaneServlet" novalidate="novalidate">
							
								<input type ="hidden" name= "idCane" value = <%= caneInPagina.getId() %>>
								
								
								<button type="submit" name="submit" value="submit" id="submit" class="btn btn-outline-danger">Conferma rimozione</button>
		 						<a href="ListCaniServlet" class='btn btn-outline-secondary' style='width:80px'>
					            	<i class='fa fa-chevron-left'></i> Back
					        	</a>
							</form>
					    </div>
					<!-- end card -->
					</div>	
			  <!-- end container -->  
			  </div>
			  <!-- Footer -->
			
		</main>		
		
		<jsp:include page="../footer.jsp" />	
	</body>
</html>