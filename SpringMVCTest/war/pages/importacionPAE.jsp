<jsp:include page="../masterpage/superior.jsp" />
<div class="formulario">
    <h2>Importación de PAE</h2>
    <form>
        <table bgcolor="#FFFFFF" width="1265" height="80%" border="0" cellspacing="0" cellpadding="0">
            
            <tr height="40px">
                <td>&nbsp;</td>
                <td>Seleccionar archivo PAE a importar:</td>
                <td><input type="text" name="seleccionarArchivo" size="60"/><input type= "submit" name="ubicarArchivo" value= "Ubicar archivo PAE"></input> </td>
                
            </tr>
            <tr height="40px">
                <td>&nbsp;</td>
                <td colspan="8" style="background-color: #C0C0C0">
                    <input type= "submit" name="importar" value= "Importar"></input>
                    <input type= "submit" name="limpiar" value= "Limpiar"></input>
                    <input type= "submit" name="regresar" value= "Regresar"></input>
		</td>
                <td>&nbsp;</td>
            </tr>
            <tr>
               <td colspan="50">&nbsp;</td>
            </tr>
            <td>&nbsp;</td>
            <td>Aplicaciones Especializadas Importadas</td>
            <td>&nbsp;</td>
            <tr>
                <td>&nbsp;</td>
                <td colspan="8">
                    <table border="1" width="100%">
                        <thead>
                            <tr align="center">
                                <td>#</td>
                                <td>Código FNA</td>
                                <td>Código de la Aplicación</td>
                                <td>Nombre</td>
                                <td>Estado</td>
                                <td>Fecha de Creación</td>
                                <td>Descripción</td>
                                <td></td>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>1</td>
                                <td>E088</td>
                                <td>HIS</td>
                                <td>Gestión de Portafolios</td>
                                <td>Activo</td>
                                <td>25/05/2014</td>
                                <td>Descripción</td>
                                <td>Ver detalle</td>
                            </tr>
                            <tr>
                                <td>2</td>
                                <td>E088</td>
                                <td>HIS</td>
                                <td>Gestión de Portafolios</td>
                                <td>Activo</td>
                                <td>25/05/2014</td>
                                <td>Descripción</td>
                                <td>Ver detalle</td>
                            </tr>
                            <tr>
                                <td>3</td>
                                <td>E088</td>
                                <td>HIS</td>
                                <td>Gestión de Portafolios</td>
                                <td>Activo</td>
                                <td>25/05/2014</td>
                                <td>Descripción</td>
                                <td>Ver detalle</td>
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
                    <input type= "submit" name="exportar" value= "Exportar"></input>
		</td>
                <td>&nbsp;</td>
            </tr>
           <tr>
               <td colspan="50">&nbsp;</td>
            </tr>
            <td>&nbsp;</td>
            <td>Aplicaciones Especializadas no Importadas</td>
            <td>&nbsp;</td>
            <tr>
                <td>&nbsp;</td>
                <td colspan="8">
                    <table border="1" width="100%">
                        <thead>
                            <tr align="center">
                                <td>#</td>
                                <td>Código FNA</td>
                                <td>Código de la Aplicación</td>
                                <td>Nombre</td>
                                <td>Estado</td>
                                <td>Fecha de Creación</td>
                                <td>Descripción</td>
                                <td></td>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>1</td>
                                <td>E088</td>
                                <td>HIS</td>
                                <td>Gestión de Portafolios</td>
                                <td>Activo</td>
                                <td>25/05/2014</td>
                                <td>Descripción</td>
                                <td>Ver detalle</td>
                            </tr>
                            <tr>
                                <td>2</td>
                                <td>E088</td>
                                <td>HIS</td>
                                <td>Gestión de Portafolios</td>
                                <td>Activo</td>
                                <td>25/05/2014</td>
                                <td>Descripción</td>
                                <td>Ver detalle</td>
                            </tr>
                            <tr>
                                <td>3</td>
                                <td>E088</td>
                                <td>HIS</td>
                                <td>Gestión de Portafolios</td>
                                <td>Activo</td>
                                <td>25/05/2014</td>
                                <td>Descripción</td>
                                <td>Ver detalle</td>
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
                    <input type= "submit" name="exportar" value= "Exportar"></input>
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