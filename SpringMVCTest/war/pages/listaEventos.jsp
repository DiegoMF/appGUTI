<jsp:include page="../masterpage/superior.jsp" />
<div class="formulario">
    <h2>Lista de Eventos</h2>
    <form>
        <table bgcolor="#FFFFFF" width="1265" height="80%" border="0" cellspacing="0" cellpadding="0">
            <tr height="40px">
                <td>&nbsp;</td>
                <td>C�digo Aplicaci�n:</td>
                <td>EE00</td>
                <td>Nombre Aplicaci�n:</td>
                <td>Gesti�n de Portafolios de Aplicaciones GUTI</td>
                
            </tr>
            <tr height="40px">
                <td>&nbsp;</td>
                <td>Usuario Creaci�n:</td>
                <td><input type="text" name="usuarioCreacion"/> </td>
                <td>Fecha Creaci�n:</td>
                <td><input type="text" name="fechaCreacion"/> </td>
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
                    <input type= "submit" name="buscar" value= "Buscar"></input>
                    <input type= "submit" name="nuevo" value= "Nuevo"></input>
                    <input type= "submit" name="limpiar" value= "Limpiar"></input>
		</td>
                <td>&nbsp;</td>
            </tr>
            <td>&nbsp;</td>
            <tr>
                <td>&nbsp;</td>
                <td colspan="8">
                    <table border="1" width="100%">
                        <thead>
                            <tr align="center">
                                <td>#</td>
                                <td>Descripci�n de Evento</td>
                                <td>Fecha de Creaci�n</td>
                                <td>Usuario Creaci�n</td>
                                <td>Estado</td>
                                <td> </td>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>1</td>
                                <td>Descripci�n 001</td>
                                <td>25/06/2014</td>
                                <td>s32459</td>
                                <td>Activo</td>
                                <td>Eliminar</td>
                            </tr>
                            <tr>
                                <td>2</td>
                                <td>Descripci�n 002</td>
                                <td>25/06/2014</td>
                                <td>s32459</td>
                                <td>Activo</td>
                                <td>Eliminar</td>
                            </tr>
                            <tr>
                                <td>3</td>
                                <td>Descripci�n 003</td>
                                <td>25/06/2014</td>
                                <td>s32459</td>
                                <td>Activo</td>
                                <td>Eliminar</td>
                            </tr>

                        </tbody>
                    </table>
                </td>
                <td>&nbsp;</td>
            </tr>
            <td>&nbsp;</td>
            <tr height="40px">
                <td>&nbsp;</td>
                <td colspan="8" style="background-color: #C0C0C0">
                    <input type= "submit" name="nuevo" value= "Nuevo"></input>
                    <input type= "submit" name="regresar" value= "Regresar"></input>
		</td>
                <td>&nbsp;</td>
            </tr>
           
            <tr>
               <td colspan="50">&nbsp;</td>
            </tr>
        </table>
    </form>
</div>
<jsp:include page="../masterpage/inferior.jsp" />