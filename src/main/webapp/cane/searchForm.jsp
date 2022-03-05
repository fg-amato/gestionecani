<!doctype html>
<%@page import="it.prova.gestionecani.model.Cane"%>
<%@page import="java.text.SimpleDateFormat"%>
<html lang="it" class="h-100" >
	 <head>
	 
	 	<!-- Common imports in pages -->
	 	<jsp:include page="../header.jsp" />
	   
	   <title>Ricerca Cane</title>
	 </head>
	   <body class="d-flex flex-column h-100">
	   
	   		<!-- Fixed navbar -->
	   		<jsp:include page="../navbar.jsp"></jsp:include>
	    
			
			<!-- Begin page content -->
			<main class="flex-shrink-0">
			  <div class="container">
			  
			  
			  	<div class='card'>
				    <div class='card-header'>
				        <h5>Ricerca cane</h5> 
				    </div>
				    <div class='card-body'>
		
							<form method="post" action="ExecuteSearchFormCaneServlet" class="row g-3" novalidate="novalidate">
							
								<div class="col-md-6">
									<label for="nome" class="form-label">Nome </label>
									<input type="text" name="nome" id="nome" class="form-control" placeholder="Inserire il nome da cercare">  
								</div>
								
								<div class="col-md-6">
									<label for="razza" class="form-label">Razza </label>
									<input type="razza" name="razza" id="razza" class="form-control" placeholder="Inserire la razza da cercare"> 
								</div>
							
								<div class="col-md-6">
									<label for="peso" class="form-label">Peso</label>
									<input type="number" class="form-control" name="peso" id="peso" placeholder="Inserire peso">
								</div>
								
								<div class="col-md-3">
									<label for="dataAdozione" class="form-label">Data di Adozione</label>
									<input class="form-control"  name="dataAdozione" id="dataAdozione" type="date" placeholder="dd/MM/yy" title="formato : gg/mm/aaaa"> 
								</div>
								
								<div class="col-md-6">
									<label for="eta" class="form-label">Età</label>
									<input type="number" class="form-control" name="eta" id="eta" placeholder="Inserire età">
								</div>
							<div class="col-12">
								<button type="submit" name="submit" value="submit" id="submit" class="btn btn-outline-primary">Ricerca</button>
								<a href="ListCaniServlet" class='btn btn-outline-secondary' style='width:80px'>
					            	<i class='fa fa-chevron-left'></i> Back
					        	</a>
							</div>
		
						</form>
  
				    
					<!-- end card-body -->			   
				    </div>
				<!-- end card -->
				</div>		
					  
			    
			  <!-- end container -->  
			  </div>
			  
			</main>
			
			<!-- Footer -->
			<jsp:include page="../footer.jsp" />
	  </body>
</html>