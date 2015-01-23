<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<%@ page import="com.google.appengine.api.blobstore.BlobstoreServiceFactory" %>
<%@ page import="com.google.appengine.api.blobstore.BlobstoreService" %>
<%
BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
%>

<jsp:include page="../../masterpage/superior.jsp" />

<div class="cabecera">
	<h2>::IMPORTACION DE EXCEL</h2>
</div>

<div class="formulario">
	
	<form action="<%= blobstoreService.createUploadUrl("/upload") %>" method="post" enctype="multipart/form-data" onsubmit="return checkFile();">
		<input type="file" name="file" id="file" accept=".xls,.xlsx,.xlsm"/>
        <input type="submit" value="enviar"/>
    </form>
	
</div>

<jsp:include page="../../masterpage/inferior.jsp" />