<jsp:include page="../masterpage/superior.jsp" />
<div class="formulario">
    <h2>Reporte de Variaci�n</h2>
    <form>
        <table bgcolor="#FFFFFF" width="1265" height="80%" border="0" cellspacing="0" cellpadding="0">
        <tr>
        <table>
            <td>
                <fieldset><legend align="left">Base del Reporte</legend>
                <table>
                   
                    <tr>
			<td><select id="pantallas" name="D3" style="width:200px;">
						<option>Seleccionar</option>
                                                <option>Estructura Organizacional</option>
                                                <option>Informaci�n general</option>
                                                <option>Funcionalidad</option>
                                                <option>Dominio</option>
                                                <option>Clasificaci�n de activos</option>
                                                <option>Caracter�sticas t�cnicas</option>
                                                <option>Datamart</option>
                                                <option>Impacto</option>
                                                <option>Informaci�n plan de roadmap</option>
                                                <option>Pre Atenci�n - Software Base - Est�ndares Tecnol�gico</option>
                                                <option>Pre Atenci�n - Lineamientos</option>
                                                <option>Pre Atenci�n - Niveles de cumplimiento</option>
                                                <option>Post Atenci�n - Software Base - Est�ndares Tecnol�gicos</option>
                                                <option>Post Atenci�n - Lineamientos</option>
                                                <option>Post Atenci�n - Niveles de cumplimiento</option>
                                                <option>Seguridad de la informaci�n</option>
                                                <option>Caracter�sticas particulares</option>
                                                <option>Fuente de origen</option>
                                                <option>Hist�rico de actualizaciones</option>
				</select>
                            <select NAME="SelectList" ID="SelectList" SIZE="5" multiple="multiple" style="width: 200px">
						<option VALUE="01sel">Unidad</option>
						<option VALUE="02sel">C�digo FNA</option>
						<option VALUE="03sel">C�digo de aplicaci�n</option>
                            </select>
			</td>
                        <td>
                            <input TYPE="BUTTON" VALUE="->" ONCLICK="addIt();"></input>
				<br />
					<input TYPE="BUTTON" VALUE="<-" ONCLICK="delIt();"></input>
			</td>
			<td>Filtros:
                            <select NAME="PickList" ID="PickList" SIZE="5" multiple="multiple" style="width: 200px">
				<option VALUE="04sel">Gerencia General</option>
                                <option VALUE="04sel">Divisi�n</option>
                                <option VALUE="04sel">Area</option>
                            </select>
			</td>
                    </tr>
                </table>
            </fieldset>

            </td>
            <td>
                <fieldset><legend align="left">Rango de Tiempo</legend>
                <table>
                    <tr>
                        <td>Periodo:</td>
                    </tr>
                    <tr>
                        <td>
				<select id="pantallas" name="D3" sytle="width:200px;">
						<option>Seleccionar</option>
                                                <option>Anual</option>
				</select>
                         </td>
                    </tr>
                </table>
                </fieldset>
            </td>
            <td>
                <fieldset><legend align="left">Criterio de Agrupaci�n</legend>
                <table>
                    <tr>
			<td><select id="pantallas" name="D3" sytle="width:200px;">
						<option>Seleccionar</option>
                                                <option>Clasificaci�n de actividades</option>
				</select>
                            <select NAME="SelectList" ID="SelectList" SIZE="5" multiple="multiple" style="width: 200px">
						<option VALUE="01sel">Confidencialidad</option>
						<option VALUE="02sel">Integridad</option>
						<option VALUE="03sel">Disponibilidad</option>
                                                <option VALUE="04sel">Privacidad</option>
                                                <option VALUE="05sel">Clasificaci�n</option>
                            </select>
			</td>
                        <td>
                            <input TYPE="BUTTON" VALUE="->" ONCLICK="addIt();"></input>
				<br />
					<input TYPE="BUTTON" VALUE="<-" ONCLICK="delIt();"></input>
			</td>
			<td>Agrupaciones
                            <select NAME="PickList" ID="PickList" SIZE="5" multiple="multiple" style="width: 200px">
				<option VALUE="01sel">Criticidad Final</option>
                                <option VALUE="01sel">Vigencia</option>
                            </select>
			</td>
                    </tr>
                </table>
                </fieldset>
            </td>
            <tr height="40px">
                        <td colspan="8" style="background-color: #C0C0C0">
                            <input type= "submit" name="generarReporte" value= "Generar Reporte"></input>
                            <input type= "submit" name="limpiar" value= "Limpiar"></input>
                            <input type= "submit" name="exportar" value= "Exportar"></input>
                        </td>
            </tr>
        </table>
            
        </tr>
        
        
        
</table>
</form>
    </div>
<jsp:include page="../masterpage/inferior.jsp" />