<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="/js/canvasjs.min.js"  type="text/javascript"></script>
<script type="text/javascript" >


</script>

				<input type="hidden" id="nCumplimientoTotal" name="nCumplimientoTotal"	value="${listaFiltros.nivelCumplimientoEstandaresPorcentaje}">
				<input type="hidden" id="nCumplimientoLineamientoTotal" name="nCumplimientoLineamientoTotal"	value="${listaFiltros.nivelCumplimientoLineamientosPorcentaje}">
				<input type="hidden" id="nCumplimientoGeneral" name="nCumplimientoGeneral" value="${listaFiltros.nivelCumplimientoTotal}">
					<table  width="100%" >
						<tr>
								<td>
									
										
										<table  width="100%" >
											<tr>
												<td>
													<table class="tablaGrilla">
													<thead>
														<tr align="center">
															<th>Nivel de cumplimiento - Estándares Tecnológicos</th>
														</tr>
													</thead>
													<tbody>
														<tr>
															<td><div id="chartContainer" style="height: 300px; width: 100%;"></div></td>
														</tr>
													</tbody>
													</table>
												</td>
												<td>
													<table class="tablaGrilla">
													<thead>
														<tr align="center">
															<th>Nive de cumplimiento - General</th>
														</tr>
													</thead>
													<tbody>
														<tr>
															<td><div id="chartContainerGeneral" style="height: 300px; width: 100%;"></div></td>
														</tr>
													</tbody>
													</table>
												</td>
												<td>
													<table class="tablaGrilla">
													<thead>
														<tr align="center">
															<th>Nivel de cumplimiento - Lineamientos</th>
														</tr>
													</thead>
													<tbody>
														<tr>
															<td><div id="chartContainerLineamientos" style="height: 300px; width: 100%;"></div></td>
														</tr>
													</tbody>
													</table>
												</td>
											
												
												
											</tr>
										</table>
									
								</td>
							</tr>
					
					</table>
	