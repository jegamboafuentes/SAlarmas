package com.baz.scc.alarmas.malapract.logic;


import com.baz.scc.alarmas.base.dao.CjCRSAlrBaseDao;
import com.baz.scc.alarmas.base.logic.CjCRSAlrBaseLogic;
import com.baz.scc.alarmas.malapract.dao.CjCRSAlrMalaPractDao;
import com.baz.scc.alarmas.malapract.model.CjCRMalasPracticasMdl;
import com.baz.scc.alarmas.malapract.model.CjCRRespMalasPracticasMdl;
import com.baz.scc.alarmas.malapract.model.CjCRSAlrMalaPractOpcion;
import com.baz.scc.alarmas.support.CjCRValidatorUtl;
import com.baz.scc.commons.dao.CjCRGeoSucursalDao;
import com.baz.scc.commons.model.CjCRGeoSucursal;
import com.baz.scc.commons.support.CjCRMailDispatcher;
import com.baz.scc.configuracion.exception.CjCRConfigException;
import com.baz.scc.configuracion.model.CjCRBusqueda;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 *
 * @author B233388 Froil&aacute; L&oacute;pez Lemus
 */
@Component(CjCRMalasPracticasLogic.BEAN_NAME)
public class CjCRMalasPracticasLogic 
        extends CjCRSAlrBaseLogic<CjCRSAlrMalaPractOpcion, CjCRMalasPracticasMdl>{
    public static final String BEAN_NAME = "cjCRMalasPracticasLogic";
    private static final Logger LOG = Logger.getLogger(CjCRMalasPracticasLogic.class);
    private static final int ON = 1;
    private static final int MODULO9 = 9;
    private static final int FOLIO1 = 0;
    private static final int FOLIO2 = 1;
    
              
    @Autowired
    @Qualifier(CjCRSAlrMalaPractDao.BEAN_NAME)
    private CjCRSAlrBaseDao malasPracticasDao;
    
    @Autowired
    private CjCRGeoSucursalDao sucursalDao;
    
    
    @Override
    public CjCRRespMalasPracticasMdl execOpcion(CjCRSAlrMalaPractOpcion opc, CjCRMalasPracticasMdl detalle) {
        CjCRRespMalasPracticasMdl result;
        
        switch(opc) {
            case INSERT_REGISTRO:
                result = getMalasPracticas(opc, detalle);
                break;
            default:
                result = CjCRRespMalasPracticasMdl.RESPUESTA_ERROR_ESTANDAR;
                break;
        }
        
        return result;
    }
    
            
    private CjCRRespMalasPracticasMdl getMalasPracticas(CjCRSAlrMalaPractOpcion opc,
            CjCRMalasPracticasMdl malasPracticas) {
        CjCRRespMalasPracticasMdl respuesta = null;
        String mensaje;       
        LOG.info(String.format("Parámetros recibidos: %s",malasPracticas));
        int idSucursal = malasPracticas.getIdSucursal();
        
        try {                                                            
            List<CjCRBusqueda> paramsConfiguracion = configuracion.getParamsConfiguracion(MODULO9, null, null);
            
            Collections.sort(paramsConfiguracion, new Comparator<CjCRBusqueda>() {
                @Override
                public int compare(CjCRBusqueda element1, CjCRBusqueda element2) {
                    return element1.getFolio() - element2.getFolio();
                }
            });
            
            Integer estadoAlarma = (Integer.parseInt(paramsConfiguracion.get(FOLIO1).getValor()));
            String destinatarios = paramsConfiguracion.get(FOLIO2).getValor();                                                           
            String asunto = appConfig.getAsuntoMalasPract()+ idSucursal;

            if (!appConfig.isProduccion()) {
                asunto = String.format("%s (Prueba)", asunto);
            }
           
            
            if ((estadoAlarma == ON)) {
                getAlarma(malasPracticas, destinatarios, asunto);
            } else {
                mensaje = "LA ALARMA SE ENCUENTRA APAGADA";
                LOG.warn(mensaje);
            }
            
            if (validaArgumento(malasPracticas)) {
                espaciosDatos(malasPracticas);
                respuesta = (CjCRRespMalasPracticasMdl) malasPracticasDao.execOpcion(opc, malasPracticas);
            } else {
                respuesta = CjCRRespMalasPracticasMdl.RESPUESTA_ERROR_ESTANDAR;
            }
                    
            
        } catch (CjCRConfigException ex) {
            LOG.error("Error en configuraciones : --> " + ex.getMessage() , ex);
        } catch (Exception ex) {
            LOG.error("Error : --> " + ex.getMessage() , ex);
        } 
        return respuesta;
    }
    
    
    private boolean validaArgumento(CjCRMalasPracticasMdl malasPracticas) {
        boolean result  = false;
        
        if (malasPracticas != null                
                && CjCRValidatorUtl.validateDate1(malasPracticas.getFechaEvento())
                /*&& CjCRValidatorUtl.validateDateTime1(depoBloqDetalle.getDepoFicto().getFechaBloqueo())
                && CjCRValidatorUtl.validateFolioRecoleccion(depoBloqDetalle.getDepoFicto().getFolioRecoleccion())*/) {
            result = true;
        } 
        
        return result;
    }
    
    private void espaciosDatos(CjCRMalasPracticasMdl malPrac) {
        malPrac.setIdEmpleado(getSpaceOnBlank(malPrac.getIdEmpleado()));
        malPrac.setFechaEvento(getSpaceOnBlank(malPrac.getFechaEvento()));
        malPrac.setDetallePersonal(getSpaceOnBlank(malPrac.getDetallePersonal()));
        malPrac.setDetalleEvento(getSpaceOnBlank(malPrac.getDetalleEvento()));
        malPrac.setDetalleExtra(getSpaceOnBlank(malPrac.getDetalleExtra()));
    }
    
    private String getSpaceOnBlank(String fieldValue) {
        String result;
        
        result = " ";
        if (fieldValue != null && !fieldValue.isEmpty()) {
            result = fieldValue;
        }
        
        return result;
    }
    
     public void getAlarma(CjCRMalasPracticasMdl malasPracticas, String destinatarios, String asunto) throws Exception {
        List<Integer> sucurs = new ArrayList<Integer>();
        
        int idSucursal = malasPracticas.getIdSucursal();
        int idPais = malasPracticas.getIdPais();
        int idCanal = malasPracticas.getIdCanal();
        String idEmpleado = malasPracticas.getIdEmpleado();
        int idPuesto = malasPracticas.getIdPuesto();
        int idRol = malasPracticas.getIdRol();
        String fechaEvento = malasPracticas.getFechaEvento();
        int idTipoReporte = malasPracticas.getIdTipoReporte();
        String detallePersonal = malasPracticas.getDetallePersonal();
        String detalleEvento = malasPracticas.getDetalleEvento();
        String detalleExtra = malasPracticas.getDetalleExtra();
        
        Map<Integer, String> tipoReporte = new HashMap<Integer, String>();
        
        tipoReporte.put(1, "CRÉDITO PREPAGO");
        tipoReporte.put(2, "DESHONESTIDAD");
        tipoReporte.put(3, "OPERACIÓN SOSPECHOSA");
        tipoReporte.put(4, "OTROS");                
        
        String reporte = tipoReporte.get(idTipoReporte);
        
         if (reporte == null) {
             reporte = "OTROS";
         }
        
        StringBuilder body = new StringBuilder();
        body.append("");
        
        String mensaje = null;
        String nombreSucursal = "";        
        sucurs.add(idSucursal);

        try {     
            
            Map<Integer, CjCRGeoSucursal> suc = sucursalDao.getSucursales(idPais, idCanal, sucurs);
            if (!suc.isEmpty()) {
                Iterator it = suc.keySet().iterator();
                while (it.hasNext()) {
                    Object key = it.next();
                    nombreSucursal = suc.get(key).getNombre();
                }
            }

            if (!appConfig.isProduccion()) {
                body.append("<center><strong> Correo de Prueba </strong></center><br/>");                
            }

            body.append("<table align='center' border='0' style='background-color:#BDBDBD;border:0px dotted #BDBDBD;width:50%;border-collapse:collapse;'> "); 			
            body.append("<tr style='background-color:white;color:black; border:1px dotted white; '> "); 			
            body.append("<th colspan='2' style='padding:3px;'>Alarma de malas prácticas.</th> "); 			
            body.append("</tr>"); 			
            body.append("<tr style='background-color:white;color:black; border:0 px dotted white;'> "); 			
            body.append("<td align='left' colspan='2' style='padding:3px;'>&nbsp; </td>"); 			
            body.append("</tr>"); 
            body.append("<tr style='background-color:white;color:black; border:0px dotted white;'>"); 			
            body.append("<td align='left' colspan='2' style='padding:3px;'>La sucursal <strong>");
            body.append(idSucursal);
            body.append("&nbsp</strong>");
            body.append(nombreSucursal);
            body.append("   reporta operación de malas prácticas.</td>"); 			
            body.append("</tr>"); 
            body.append("<tr style='background-color:white;color:black; border:1px dotted white;'> "); 			
            body.append("<td align='left' colspan='2' style='padding:3px;'>&nbsp; </td>"); 			
            body.append("</tr>");            
            body.append("<tr>");                        
            body.append("<td style='padding:2px;width:20%;'><strong>No. de Empleado:</strong></td><td style='padding:2px;width:50%;'>");
            body.append(idEmpleado);                                                        
            body.append("</td></tr>");                         
            body.append("<tr>"); 
            body.append("<td style='padding:3px;width:20%;'><strong>Tipo de reporte:</strong></td><td style='padding:3px;width:50%;'>");
            body.append(reporte);
            body.append("</td> "); 			
            body.append("</tr>"); 
            body.append("<tr style='background-color:white;color:black; border:1px dotted white;'>"); 			
            body.append("<td align='left' colspan='2' style='padding:3px;'>Se ecuentra operando con un Puesto: ");
            body.append(idPuesto);
            body.append("&nbsp&nbsp&nbsp&nbsp;Rol: ");
            body.append(idRol);
            body.append("</td>");
            body.append("</tr>");
            body.append("<tr style='background-color:white;color:black; border:1px dotted white;'>");
            body.append("<td align='left' colspan='2' style='padding:3px;'>Detalle personal: ");
            body.append(detallePersonal);
            body.append("</td>");
            body.append("</tr>");
            body.append("<tr style='background-color:white;color:black; border:1px dotted white;'>");
            body.append("<td align='left' colspan='2' style='padding:3px;'>Detalle evento: ");
            body.append(detalleEvento);
            body.append("</td>");
            body.append("</tr>");	   
            body.append("<tr style='background-color:white;color:black; border:1px dotted white;'>");
            body.append("<td align='left' colspan='2' style='padding:3px;'>Detalle extra:");
            body.append(detalleExtra);
            body.append("</td>");
            body.append("</tr>");
            body.append("<tr style='background-color:white;color:black; border:1px dotted white;'>");
            body.append("<td align='left' colspan='2' style='padding:3px;'></td>");
            body.append("</tr>");
            body.append("<tr style='background-color:white;color:black; border:1px dotted white;'>");
            body.append("<td align='left' colspan='2' style='padding:3px;'>Hora de detección en sucursal: ");
            body.append(fechaEvento);
            body.append(".</td>");
            body.append("</tr>");
            body.append("</table>");

            CjCRMailDispatcher.Mail nuevoMail = mail.getMail(destinatarios, asunto);
            nuevoMail.setAddresses(destinatarios);
            nuevoMail.setBody(body.toString());
            mail.send(nuevoMail);
            mensaje = "CORREO ENVIADO EXITOSAMENTE";
            LOG.info(mensaje);
            
        } catch (Exception ex) {
            mensaje = "*ERROR - ";
            LOG.error(mensaje + ex);
            throw ex;
        }
    }

    
}
