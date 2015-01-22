<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<select name="subDominio"
													id="subDominio">
														<option value="">Seleccione</option>
														<c:forEach items="${subdominio}" var="subdominio">
															<option value="<c:out value="${subdominio.idSubDominio}" />"><c:out
																	value="${subdominio.descripcionSubDominio}" /></option>
														</c:forEach>
													</select>