<jsp:include page="../masterpage/superior.jsp" />
<div class="formulario">
    <h2>Registro de Eventos</h2>
    <form>
        <table bgcolor="#FFFFFF" width="1265" height="80%" border="0" cellspacing="0" cellpadding="0">
            <tr height="40px">
                <td>&nbsp;</td>
                <td>Código Aplicación:</td>
                <td>EE00</td>
                <td>Nombre Aplicación:</td>
                <td>Gestión de Portafolios de Aplicaciones GUTI</td>
                
            </tr>
            <tr height="40px">
                <td>&nbsp;</td>
                <td>Descripción de Evento </td>
                <td><input type="text" name="usuarioCreacion" size="60"/> </td>
                <td>Estado:</td>
                <td> 
                    <select name="estado">
                        <option value="activo">Activo</option>
                        <option value="inactivo">Inactivo</option>
                    </select>
                </td>
            </tr>
            <tr height="40px">
                <td>&nbsp;</td>
                <td colspan="8" style="background-color: #C0C0C0">
                    <input type= "submit" name="grabar" value= "Grabar"></input>
                    <input type= "submit" name="regresar" value= "Regresar"></input>
		</td>
                <td>&nbsp;</td>
            </tr>
            <td>&nbsp;</td>
           
            <tr>
               <td colspan="50">&nbsp;</td>
            </tr>
        </table>
    </form>
</div>
<jsp:include page="../masterpage/inferior.jsp" />