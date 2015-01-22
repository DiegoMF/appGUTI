<!DOCTYPE html>
<html>
<body>
	<h1>${headerMessage}</h1>
 
	<h3>Congratulations!! the Engineering college has processed your Application form successfully</h3>

	<h2>Details submitted by you:: </h2>

	<table>
		<tr>
			<td>Nombre consulta :</td>
			<td>${listaConsulta.nombreConsulta}</td>
		</tr>
		<tr>
			<td>Prederterminado :</td>
			<td>${listaConsulta.predeterminado}</td>
		</tr>
		<tr>
			<td>Estado :</td>
			<td>${listaConsulta.estado}</td>
		</tr>

		<tr>
			<td>Filtro Origen :</td>
			<td></td>
		</tr>
		<tr>
			<td>Filtro Destino :</td>
			<td>${listaConsulta.filtroDestino}</td>
		</tr>
		
			<tr>
			<td>Columna Origen :</td>
			<td></td>
		</tr>
		<tr>
			<td>Columna Destino :</td>
			<td>${listaConsulta.columnaDestino}</td>
		</tr>

	</table>

</body>
</html>
