<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
response.setContentType ("application/vnd.ms-excel");
response.setHeader ("Content-Disposition", "attachment;filename=\"Inventario de Aplicaciones.xls\"");
%>



<table border="1" width="100%" class="tablaGrilla">
                        <thead>
                        	<tralign="center">
                        		<th colspan="1"></th>
                        		<th colspan="4">Estructura organizacional</th>
                        		<th colspan="2">Identificación de aplicación</th>
                        		<th colspan="16">Información general</th>
                        		<th colspan="19">Características técnicas</th>
                        		<th colspan="22">Dominio</th>
                        		<th colspan="5">Clasificación de activos</th>
                        		<th colspan="2">Criticidad</th>
                        		<th colspan="11">Software base - Estándares tecnológicos</th>
                        		<th colspan="4">Compatibilidad</th>
                        		<th colspan="20">Lineamientos</th>
                        		<th colspan="5">Niveles de cumplimientos</th>
                        		<th colspan="8">Información plan de roadmap</th>
                        		<th colspan="11">Post atención - Software base - Estándares tecnológicos</th>
                        		<th colspan="20">Post atención - Lineamientos</th>
                        		<th colspan="5">Post atención - Niveles de cumplimiento</th>
                        		<th colspan="10">Datamart</th>
                        		<th colspan="2">Seguridad de la información</th>
                        	</tr>
                            <tr align="center">
                                <th>#</th>
                                <th>Gerencia central</th>
                                <th>Division</th>
                                <th>Area</th>
                                <th>Unidad</th>
                                
                                <th>Código FNA</th>
                                <th>Código de aplicación especializada</th>
                                <th>Nombre aplicación No IT</th>
                                <th>Descripción de la aplicación</th>
                                
                                
                                <th>Funcionalidades de la aplicación</th>
                                <th>Estado de la aplicación</th>
                                <th>Tipo de operaciones que procesa</th>
                                <th>Frecuencia de las operaciones que procesa</th>
                                
                                <th>Cantidad de operaciones</th>
                                <th>Fecha de creación de la aplicación</th>
                                <th>Motivo de creación de la aplicación</th>
                                <th>Motivo de creación de la aplicación (En caso de haber elegido "Otros")</th>
                                
                                <th>N° Funcionalidades transacciones</th>
                                <th>N° Reportes</th>
                                <th>N° Consultas</th>
                                <th>N° Entidades externas</th>
                                <th>N° Entidades internas</th>
                                <th>Observaciones generales</th>
                               
                                <th>Categoría tecnológica</th>
                                <th>Categoría tecnológica (En caso de haber elegido "Otros")</th>
                                <th>Tipo de desarrollo</th>
                                <th>Ubicación física</th>
                                <th>Ambiente del AppNoIT</th>
                                
                                <th>Detallar la ubicación física del AppNoIT en caso de haber elegido "Otros"</th>
                                <th>Nombre de la ubicación</th>
                                <th>Infraestructura de la aplicación</th>
                                <th>¿La solución es stand alone?</th>
                                <th>¿Cuántas interfaces tienen con otras aplicaciones, servicios web, servicios en host, sistemas, BD externas, DWH?</th>
                                
                                <th>¿Cuáles son esas interfaces?</th>
                                <th>¿Quién da mantenimiento a la aplicación?</th>
                                <th>Si seleccionó proveedor, indicar el nombre</th>
                                <th>¿Quién realiza el soporte a la aplicación?</th>
                                <th>Si seleccionó proveedor, indicar el nombre</th>
                                <th>¿Quién brinda los accesos a la aplicación?</th>
                                <th>Si seleccionó proveedor, indicar el nombre</th>
    
                                <th>Nombre del servidor</th>
                                <th>Ubicación del Servidor</th>
                                <th>Owner o dueño</th>
                                <th>Gestor de aplicaciones</th>
                                <th>Especialista de aplicaciones</th>
                                
                                <th>Broker de sistemas</th>
                                <th>Broker de negocios</th>
                                <th>Asesor GUTI</th>
                                <th>Arquitecto de dominio</th>
                                <th>Entidades Usuarias</th>
                                
                                <th>Dominio</th>
                                <th>Sub-Dominio</th>
                                <th>¿Cuántas unidades utilizan la aplicación?</th>
                                <th>Nombre de la unidad 1</th>
                                <th>Nombre de la unidad 2</th>
                                
                                <th>Nombre de la uniadd 3</th>
                                <th>¿Cuántos usuarios utilizan la aplicación en total?</th>
                                <th>Proceso de auditoría</th>
                                <th>Procesos de auditoría (En caso de haber elegido "Otros")</th>
                                <th>¿Toca algún proceso clave?</th>
                                
                                
                                <th>Indicar proceso clave</th>
                                <th>Proceso clave (En caso haya elegido la opción "Otros")</th>
                                <th>Actividad</th>
                                <th>Relación con CIF</th>
                                <th>Confidencialidad</th>
                                
                                <th>Integridad</th>
                                <th>Disponibilidad</th>
                                <th>Privacidad</th>
                                <th>Clasificación</th>
                                <th>Criticidad final</th>
                                
                                <th>Descripción estado revisión aplicación</th>
                                <th>Estándar sistema operativo</th>
                                <th>Estándar sistema operativo (en caso haber elegido "Otros")</th>
                                <th>Estándar herramienta de programación</th>
                                <th>Estándar herramientas de programación (En caso de haber elegido "Otros")</th>
                                
                                <th>Lenguaje de programación</th>
                                <th>Lenguaje de programación (En caso haber elegido "Otros")</th>
                                <th>Estándar - Gestor de base de datos</th>
                                <th>Estándar - Gestor de base de datos (En caso haber elegido "Otros")</th>
                                <th>Estándar - Framework</th>
                                
                                <th>Estándar - Framework (En caso haber elegido "Otros")</th>
                                <th>Observaciones adicionales</th>
                                <th>Compatible con Windows 7</th>
                                <th>Compatible con Internet Explorer 8</th>
                                <th>Compatible con Pterminal</th>
                                <th>Segurinet/ Active Directory</th>
                                
                                <th>Accesos - Gestión de privilegios de los sistemas</th>
                                <th>Accesos - Revisión de los privilegios de los usuarios</th>
                                <th>Accesos - Gestión de contraseñas</th>
                                <th>Accesos - Política de contraseñas</th>
                                <th>Accesos - Gestión de claves </th>
                                <th>Accesos - Gestión de claves</th>
                                <th>Accesos - Gestión de claves</th>
                                <th>Auditoría - Registro de auditorías</th>
                                <th>Auditoría - Protección de los registros de auditoría</th>
                                <th>Auditoría - Registro de eventos de los administradores de los sistemas o administradores de seguridad </th>
                                <th>Auditoría - Conformidad con las políticas de seguridad y los estándares</th>
                                <th>Contingencia - Contingencia</th>
                                <th>Control de cambios - Procedimientos de control de cambios de software</th>
                                <th>Control de cambios - Procedimientos de control de cambios de infraestructura</th>
                                <th>Documentación - Manejo de documentación</th>
                                
                                <th>Incidentes - Cumplimiento de las políticas de antivirus de la organización</th>
                                <th>Incidentes - Cumplimiento con las políticas de gestión de parches</th>
                                <th>Incidentes - Cumplimiento de los controles contra código malicioso</th>
                                <th>Integridad y Confidencialidad - Protección de datos de prueba</th>
                                <th>Respaldos - Gestión de respaldo y recuperación</th>
                                
                                <th>Estándares tecnológicos</th>
                                <th>Cumplimiento de estándares %</th>
                                <th>Lineamientos</th>
                                <th>Cumplimiento lineamientos %</th>
                                <th>Nivel de cumplimiento</th>
                                <th>Roadmap corto plazo</th>
                                
                              
                                <th>Roadmap largo plazo</th>
                                <th>Estado de atención de roadmap</th>
                                <th>Etapa de atención de roadmap</th>
                                
                                
                                <th>Fecha inicio planificado</th>
                                <th>Fecha de comprimiso</th>
                                <th>Roadmap ejecutado actual</th>
                                <th>Track de atención</th>
                                
                                
                                
                                <th>Estándar sistema operativo</th>
                                <th>Estándar sistema operativo (En caso de haber elegido "Otros")</th>
                                <th>Estándar herramienta de programación</th>
                                
                                <th>Estándar herramientas de programación en caso de haber elegido "Otros"</th>
                                <th>Lenguaje de programación</th>
                                <th>Lenguaje de programación (En caso haber elegido "Otros")</th>
                                <th>Estándar - Gestor de base de datos</th>
                                <th>Estándar - Gestor de base de datos (En caso haber elegido "Otros")</th>
                                
                                <th>Estándar - Framework</th>
                                <th>Estándar - Framework (En caso de haber elegido "Otros")</th>
                                <th>Observaciones adicionales</th>
                                
                                <th>Accesos - Gestión de privilegios en los sistemas</th>
                                <th>Accesos - Revisión de los privilegios de los usuarios</th>
                                <th>Accesos - Gestión de contraseñas</th>
                                <th>Accesos - Políticas de contraseñas</th>
                                <th>Accesos - Gestión de claves</th>
                                
                                <th>Accesos - Gestión de claves</th>
                                <th>Accesos - Gestión de claves</th>
                                <th>Auditoría - Registro de auditorías</th>
                                <th>Auditoría - Protección de los registros de auditoría</th>
                                <th>Auditoría - Registro de eventos de los administradores de los sistemas o administradores de seguridad </th>
                                
                                <th>Auditoría - Conformidad con las políticas de seguridad y los estándares</th>
                                <th>Contingencia - Contingencia</th>
                                <th>Control de cambios - Procedimientos de control de cambios de software</th>
                                <th>Control de cambios - Procedimientos de control de cambios de infraestructura</th>
                                <th>Documentación - Manejo de documentación</th>
                                
                                <th>Incidentes - Cumplimiento de las políticas de antivirus de la organización</th>
                                <th>Incidentes - Cumplimiento con las políticas de gestión de parches</th>
                                <th>Incidentes - Cumplimiento de los controles contra código malicioso</th>
                                <th>Integridad y Confidencialidad - Protección de datos de prueba</th>
                                <th>Respaldos - Gestión de respaldo y recuperación</th>
                                
                                <th>Estándares tecnológicos</th>
                                <th>Cumplimiento estándares %</th>
                                <th>Lineamientos</th>
                                <th>Cumplimiento lineamientos %</th>
                                <th>Nivel cumplimiento %</th>
                                <th>Nombre datamart</th>
                                
                                <th>Frecuencia</th>
                                <th>¿Cuántas tablas tiene?</th>
                                <th>¿Cuántas tablas descriptivas tiene?</th>
                                <th>¿Cuántas tablas de hechos tiene?</th>
                                <th>Herramientas de explotación que utiliza</th>
                                
                                <th>Herramientas de explotación que utiliza (En caso de haber elegido "Otros")</th>
                                <th>¿Cuántos reportes genera?</th>
                                <th>¿Cuántos usuarios tienen accesos?</th>
                                <th>Cantidad de espacio en tablespace</th>
                                <th>Evaluación con seguridad informática</th>
                                <th>Nivel de exposición al riesgo (USD)</th>
                                
                                
                                
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="listValue" items="${listaAplicaciones}">
                            <tr>
                                <td>${listValue.numero}</td>
                                <td>${listValue.desGerenciaCentral}</td>
                                <td>${listValue.desDivision}</td>
                                <td>${listValue.desArea}</td>
                                <td>${listValue.desUnidad}</td>
                              
                              	<td>${listValue.codigoFNA}</td>
                                <td>${listValue.codigoAplicacion}</td>
                                <td>${listValue.nombreAplicacion}</td>
                                <td>${listValue.descripcionAplicacion}</td>
                                
                                <td>${listValue.funcionalidadesAplicacion}</td>
                                <td>${listValue.estadoAplicacion}</td>
                                <td>${listValue.tipoOperacionesProcesa}</td>
                                <td>${listValue.frecuenciaOperacionesProcesa}</td>
                                
                                
                                <td>${listValue.cantidadOperaciones}</td>
                                <td>${listValue.fechaCreacionAplicacion}</td>
                                <td>${listValue.motivoCreacionAplicacion}</td>
                                <td>${listValue.motivoCreacionAplicacionOtros}</td>
                                
                                <td>${listValue.nroFuncionalidadesTransacciones}</td>
                                <td>${listValue.nroReportes}</td>
                                <td>${listValue.nroConsultas}</td>
                                <td>${listValue.nroEntidadesExternas}</td>
                                <td>${listValue.nroEntidadesInternas}</td>
                                <td>${listValue.observacionesGenerales}</td>
                                
                                <td>${listValue.categoriaTecnologica}</td>
                                <td>${listValue.categoriaTecnologicaOtros}</td>
                                <td>${listValue.tipoDesarrollo}</td>
                                <td>${listValue.ubicacionFisica}</td>
                                <td>${listValue.ambienteAppNOIT}</td>
                                
                                <td>${listValue.ambienteAppNOITOtros}</td>
                                <td>${listValue.nombreUbicacion}</td>
                                <td>${listValue.descripcionInfraestructuraAplicacion}</td>
                                <td>${listValue.esSolucionStandAlone}</td>
                                <td>${listValue.nroInterfacesOtrasApp}</td>
                                
                                <td>${listValue.nombresInterfaces}</td>
                                <td>${listValue.descripcionMantenimientoAplicacion}</td>
                                <td>${listValue.mantenimientoNombreProveedor}</td>
                                <td>${listValue.descripcionSoporteAplicacion}</td>
                                <td>${listValue.soporteNombrePorveedor}</td>
                                <td>${listValue.descripcionAccesosAplicacion}</td>
                                <td>${listValue.accesosNombreProveedor}</td>
                                
                                <td>${listValue.nombreServidor}</td>
                                <td>${listValue.ubicacionServidor}</td>
                                <td>${listValue.frontUserLiderUsuario}</td>
                                <td>${listValue.gestorAplicaciones}</td>
                                <td>${listValue.especialistaAplicaciones}</td>
                                
                                <td>${listValue.brokerSistemas}</td>
                                <td>${listValue.brokerNegocios}</td>
                                <td>${listValue.asesorGUTI}</td>
                                <td>${listValue.arquitectoDominio}</td>
                                <td>${listValue.descripcionEntidadesUsuarias}</td>
                                
                                <td>${listValue.descripcionDominio}</td>
                                <td>${listValue.descripcionSubDominio}</td>
                                <td>${listValue.nroUnidadesUtilizanAplicacion}</td>
                                <td>${listValue.nombreUnidad1}</td>
                                <td>${listValue.nombreUnidad2}</td>
                                
                                <td>${listValue.nombreUnidad3}</td>
                                <td>${listValue.descripcionCantidadUsuariosAplicacionTotal}</td>
                                <td>${listValue.descripcionProcesoAuditoria}</td>
                                <td>${listValue.procesoAuditoriaOtros}</td>
                                <td>${listValue.impactaProcesoClave}</td>
                                
                               
                                <td>${listValue.descripcionProcesoClave}</td>
                                <td>${listValue.nombreProcesoClaveOtros}</td>
                                <td>${listValue.descripcionActividad}</td>
                                <td>${listValue.relacionCIF}</td>
                                <td>${listValue.descripcionConfidencialidad}</td>
                                
                                <td>${listValue.descripcionIntegridad}</td>
                                <td>${listValue.descripcionDisponibilidad}</td>
                                <td>${listValue.descripcionPrivacidad}</td>
                                <td>${listValue.clasificacionActivosObservacion}</td>
                                <td>${listValue.descripcionCriticidadFinal}</td>
                                
                                <td>${listValue.descripcionEstadoRevisionAplicacion}</td>
                                <td>${listValue.descripcionSwBaseEstandarSistemaOperativo}</td>
                                <td>${listValue.swBaseSistemaOperativoOtros}</td>
                                <td>${listValue.descripcionSwBaseEstandarHerramientaProgramacion}</td>
                                <td>${listValue.swBaseHerramientaProgramacionOtros}</td>
                                
                                <td>${listValue.descripcionSwBaseEstandarLenguajeProgramacion}</td>
                                <td>${listValue.swBaseLenguajeProgramacionOtros}</td>
                                <td>${listValue.decripcionSwBaseEstandarGestorBD}</td>
                                <td>${listValue.swBaseGestorBDOtros}</td>
                                <td>${listValue.descripcionSwBaseEstandarFramework}</td>
                                
                                <td>${listValue.swBaseFrameworkOtros}</td>
                                <td>${listValue.swBaseObservacionesAdicionales}</td>
                                <td>${listValue.compatibleWindows7}</td>
                                <td>${listValue.compatibleIExplorer8}</td>
                                <td>${listValue.compatiblePTerminal}</td>
                                
                                <td>${listValue.segurinetActiveDirectory}</td>
                                
                                 <td>${listValue.descripcionAccesosGestionPrivilegiosSistemas}</td>
                                <td>${listValue.descripcionAccesosRevisionPrivilegiosUsuarios}</td>
                                <td>${listValue.descripcionAccesosGestionContrasenas}</td>
                                <td>${listValue.descripcionAccesosPoliticaContrasenas}</td>
                                <td>${listValue.descripcionAccesosGestionClaves1}</td>
                                
                                <td>${listValue.descripcionAccesosGestionClaves2}</td>
                                <td>${listValue.descripcionAccesosGestionClaves3}</td>
                                <td>${listValue.descripcionAuditoriaRegistroAuditoria}</td>
                                <td>${listValue.descripcionAuditoriaProteccionRegistrosAuditoria}</td>
                                <td>${listValue.descripcionAuditoriaRegistroEventosAdministradores}</td>
                                
                                <td>${listValue.descripcionAuditoriaConformidadPoliticas}</td>
                                <td>${listValue.descripcionContingencia}</td>
                                <td>${listValue.descripcionControlCambiosProcedimientosSw}</td>
                                <td>${listValue.descripcionControlCambiosProcedimientoInfraestructura}</td>
                                <td>${listValue.descripcionDocumentacionManejo}</td>
                                
                                <td>${listValue.descripcionIncidentesCumplimientoPoliticasAntivirus}</td>
                                <td>${listValue.descripcionIncidentesCumplimientoGestionParches}</td>
                                <td>${listValue.descripcionIncidentesCumplimientoCodigoMalicioso}</td>
                                <td>${listValue.descripcionIntegridadConfidencialidadDatosPrueba}</td>
                                <td>${listValue.descripcionRespaldosGestionRespaldoRecuperacion}</td>
                                
                                
                        		<td>${listValue.nivelCumplimientoEstandaresTecnologico}</td>
                                <td>${listValue.nivelCumplimientoEstandaresPorcentaje}</td>
                                <td>${listValue.nivelCumplimientoLineamientos}</td>
                                <td>${listValue.nivelCumplimientoLineamientosPorcentaje}</td>
                                <td>${listValue.nivelCumplimientoTotal}</td>
                                <td>${listValue.roadmapCortoPlazo}</td>
                                
                                <td>${listValue.roadmapLargoPlazo}</td>
                                <td>${listValue.descripcionEstadoAtencionRoadmap}</td>
                                <td>${listValue.descripcionEtapaAtencionRoadmap}</td>
                                
                                <td>${listValue.fechaInicioPlanificado}</td>
                                <td>${listValue.fechaCompromiso}</td>
                                <td>${listValue.roadmapEjecutadoActual}</td>
                                <td>${listValue.trackAtencion}</td>
                                
                                
                                <td>${listValue.descripcionPostSwBaseEstandarSistemaOperativo}</td>
                                <td>${listValue.postSwBaseSistemaOperativoOtros}</td>
                                <td>${listValue.decripcionPostSwBaseEstandarHerramientaProgramación}</td>
                                
                                <td>${listValue.postSwBaseHerramientaProgramacionOtros}</td>
                                <td>${listValue.descripcionPostSwBaseEstandarLenguajeProgramacion}</td>
                                <td>${listValue.postSwBaseLenguajeProgramacionOtros}</td>
                                <td>${listValue.descripcionPostSwBaseEstandarGestorBD}</td>
                                <td>${listValue.postSwBaseGestorBDOtros}</td>
                                
                                <td>${listValue.descripcionPostSwBaseEstandarFramework}</td>
                                <td>${listValue.postSwBaseFrameworkOtros}</td>
                                <td>${listValue.postSwBaseObservacionesAdicionales}</td>
                                
                           
                                
                                <td>${listValue.postDescripcionAccesosGestionPrivilegiosSistemas}</td>
                                <td>${listValue.postDescripcionAccesosRevisionPrivileggiosUsuarios}</td>
                                <td>${listValue.postDescripcionAccesosGestionContrasenas}</td>
                                <td>${listValue.postDescripcionAccesosPoliticaContrasenas}</td>
                                <td>${listValue.postDescripcionAccesosGestionClaves1}</td>
                                
                                <td>${listValue.postDescripcionAccesosGestionClaves2}</td>
                                <td>${listValue.postDescripcionAccesosGestionClaves3}</td>
                                <td>${listValue.postDescripcionAuditoriaRegistroAuditoria}</td>
                                <td>${listValue.postDescripcionAuditoriaProteccionRegistrosAuditoria}</td>
                                <td>${listValue.postDescripcionAuditoriaRegistroEventosAdministradores}</td>
                                
                                <td>${listValue.postDescripcionAuditoriaConformidadPolitias}</td>
                                <td>${listValue.postDescripcionContingencia}</td>
                                <td>${listValue.postDescripcionControlCambiosProcedimientosSw}</td>
                                <td>${listValue.postDescripcionControlCambiosProcedimientosInfraestructura}</td>
                                <td>${listValue.postDescripcionDocumentacionManejo}</td>
                                
                                <td>${listValue.postDescripcionIncidentesCumplimientoPoliticaAntivirus}</td>
                                <td>${listValue.postDescripcionIncidentesCumplimientoGestionParches}</td>
                                <td>${listValue.postDescripcionIncidentesCumplimientodCodigoMalicioso}</td>
                                <td>${listValue.postDescripcionIntegridadConfidencialidadDatosPrueba}</td>
                                <td>${listValue.postDescripcionRespaldosGestionRespaldoRecuperacion}</td>
                                
                                <td>${listValue.postNivelCumplimientoEstandaresTecnologico}</td>
                                <td>${listValue.postNivelCumplimientoEstandaresPorcentaje}</td>
                                <td>${listValue.postNivelCumplimientoLineamientos}</td>
                                <td>${listValue.postNivelCumplimientoLineamientosPorcentaje}</td>
                                <td>${listValue.postNivelCumplimientoTotal}</td>
                                
                                <td>${listValue.nombre_datamart}</td>
                                
                                <td>${listValue.frecuencia}</td>
                                <td>${listValue.cantidadTablas}</td>
                                <td>${listValue.cantidadTablasDescriptivas}</td>
                                <td>${listValue.cantidadTablasHechos}</td>
                                <td>${listValue.descripcionHerramientaExplotacionDatos}</td>
                                
                                <td>${listValue.herramientaExplotacionDatosOtros}</td>
                                <td>${listValue.cantidadReportes}</td>
                                <td>${listValue.cantidadUsuarios}</td>
                                <td>${listValue.cantidadEspacioTablespace}</td>
                                <td>${listValue.evaluacionSeguridadInformacion}</td>
                                <td>${listValue.seguridadNivelExposicion}</td>
                                                            
                            </tr>
                          </c:forEach>
                                

                        </tbody>
                    </table>