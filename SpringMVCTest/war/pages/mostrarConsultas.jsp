<jsp:include page="../masterpage/superior.jsp" />
<div class="formulario">
    <h2>Bitácora de Consultas</h2>
    <form>
        <table bgcolor="#FFFFFF" width="1265" height="80%" border="0" cellspacing="0" cellpadding="0">
            <tr height="40px">
                <td>&nbsp;</td>
                <td>Nombre de Consulta:</td>
                <td><input type="text" name="nombreConsulta" size="80"/> </td>
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
                                <td>Nombre de consulta</td>
                                <td>Fecha de creación</td>
                                <td>Usuario creación</td>
                                <td>Predeterminado</td>
                                <td>Estado</td>
                                <td> </td>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>1</td>
                                <td>Mi consulta 001</td>
                                <td>25/06/2014</td>
                                <td>s32459</td>
                                <td>NO</td>
                                <td>Activo</td>
                                <td>Ver</td>
                            </tr>
                            <tr>
                                <td>2</td>
                                <td>Mi consulta 002</td>
                                <td>25/06/2014</td>
                                <td>s32459</td>
                                <td>NO</td>
                                <td>Activo</td>
                                <td>Ver</td>
                            </tr>
                            <tr>
                                <td>3</td>
                                <td>Mi consulta 003</td>
                                <td>25/06/2014</td>
                                <td>s32459</td>
                                <td>NO</td>
                                <td>Activo</td>
                                <td>Ver</td>
                            </tr>

                        </tbody>
                    </table>
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