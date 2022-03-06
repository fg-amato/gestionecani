<!doctype html>
<%@page import="it.prova.gestionecani.model.Cane"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="it" class="h-100" >
	 <head>
	 
	 	<!-- Common imports in pages -->
	 	<jsp:include page="../header.jsp" />
	   
	   <title>Modifica Cane</title>
	 </head>
	   <body class="d-flex flex-column h-100">
	   
	   		<!-- Fixed navbar -->
	   		<jsp:include page="../navbar.jsp"></jsp:include>
	    
			
			<!-- Begin page content -->
			<main class="flex-shrink-0">
			  <div class="container">
			  
			  		<div class="alert alert-danger alert-dismissible fade show ${errorMessage==null?'d-none':'' }" role="alert">
					  ${errorMessage}
					  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close" ></button>
					</div>
					<div class="alert alert-danger alert-dismissible fade show d-none" role="alert">
					  Esempio di operazione fallita!
					  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close" ></button>
					</div>
					<div class="alert alert-info alert-dismissible fade show d-none" role="alert">
					  Aggiungere d-none nelle class per non far apparire
					   <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close" ></button>
					</div>
			  
			  <div class='card'>
				    <div class='card-header'>
				        <h5>Modifica cane</h5> 
				    </div>
				    <div class='card-body'>
		
							<h6 class="card-title">I campi con <span class="text-danger">*</span> sono obbligatori</h6>
		
		
							<form method="post" action="ExecuteEditCaneServlet" class="row g-3" novalidate="novalidate">
							
								<% Cane caneInPagina = (Cane)request.getAttribute("update_cane_attr"); %>
							
								<div class="col-md-6">
									<label for="nome" class="form-label">Nome <span class="text-danger">*</span></label>
									<input type="text" name="nome" id="nome" class="form-control" placeholder="Inserire il nome"  
										value="<%=caneInPagina.getNome()!=null?caneInPagina.getNome():"" %>" required>
								</div>
								
								<div class="col-md-6">
									<label for="razza" class="form-label">Razza <span class="text-danger">*</span></label>
									<input type="razza" name="razza" id="razza" class="form-control" placeholder="Inserire la razza"  
										value="<%=caneInPagina.getRazza()!=null?caneInPagina.getRazza():"" %>" required>
								</div>
							
								<div class="col-md-6">
									<label for="peso" class="form-label">Peso <span class="text-danger">*</span></label>
									<input type="number" class="form-control" name="peso" id="peso" placeholder="Inserire peso" 
									value="<%=caneInPagina.getPeso()!=null?caneInPagina.getPeso():"" %>" required>
								</div>
								
								<div class="col-md-3">
									<label for="dataAdozione" class="form-label">Data di Adozione<span class="text-danger">*</span></label>
									<input class="form-control"  name="dataAdozione" id="dataAdozione" type="date" placeholder="dd/MM/yy" title="formato : gg/mm/aaaa" 
										value="<%=caneInPagina.getDataAdozione()!=null? new SimpleDateFormat("yyyy-MM-dd").format(caneInPagina.getDataAdozione()):""  %>" required/>
								</div>
								
								<div class="col-md-6">
									<label for="eta" class="form-label">Età<span class="text-danger">*</span></label>
									<input type="number" class="form-control" name="eta" id="eta" placeholder="Inserire età" 
									value="<%=caneInPagina.getEta()!=null?caneInPagina.getEta():"" %>" required>
								</div>
							<div class='card-footer'>
							
									<input type ="hidden" name= "idCane" value = <%= caneInPagina.getId() %>>
								
								
									<button type="submit" name="submit" value="submit" id="submit" class="btn btn-outline-info">Conferma modifica</button>
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