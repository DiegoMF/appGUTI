<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<%@ page
	import="com.google.appengine.api.blobstore.BlobstoreServiceFactory"%>
<%@ page import="com.google.appengine.api.blobstore.BlobstoreService"%>
<%
	BlobstoreService blobstoreService = BlobstoreServiceFactory
			.getBlobstoreService();
%>

<jsp:include page="../../masterpage/superior.jsp" />

<div class="cabecera">
	<h2>::IMPORTACION DE EXCEL</h2>
</div>

<div class="formulario"> 

	<form
		action="<%=blobstoreService.createUploadUrl("/uploadFile/import")%>"
		method="post" enctype="multipart/form-data"
		onsubmit="return checkFile();">	
		<input type="file" name="file" id="file" accept=".xls,.xlsx,.xlsm" />
		<input type="submit" value="enviar"/>
		<p id="validator" style="color: blue;">${validator_test}</p>
	</form>
</div>

<!-- INICIO DEMO MODAL -->

<div id="basic-modal">
	<input type="button" name="basic" value="Demo" class="basic" />
</div>

<div id="basic-modal-content">
	<h3>Seleccione un archivo con extensión XLS, XLSX, XLSM</h3>
</div>

<div style="display: none">
	<img src="/images/x.png" alt="" />
</div>

<script type="text/javascript" src="/js/bootstrap/jquery.js"></script>
<script type="text/javascript" src="/js/bootstrap/jquery.simplemodal.js"></script>
<script type="text/javascript" src="/js/bootstrap/basic.js"></script>


<!-- FIN DEMO MODAL -->

<jsp:include page="../../masterpage/inferior.jsp" />