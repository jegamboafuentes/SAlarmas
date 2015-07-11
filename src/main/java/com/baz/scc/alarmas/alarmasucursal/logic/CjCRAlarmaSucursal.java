/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.baz.scc.alarmas.alarmasucursal.logic;

import com.baz.scc.alarmas.support.CjCRRespuesta;
import com.baz.scc.alarmas.alarmasucursal.model.CjCRTransaccion;
import com.baz.scc.alarmas.service.CjCRAlarmaService;
import com.baz.scc.alarmas.support.CjCRAppConfig;
import com.baz.scc.commons.dao.CjCRGeoSucursalDao;
import com.baz.scc.commons.model.CjCRGeoSucursal;
import com.baz.scc.commons.support.CjCRMailDispatcher;
import com.baz.scc.configuracion.exception.CjCRConfigException;
import com.baz.scc.configuracion.logic.CjCRConfiguracionLogic;
import com.baz.scc.configuracion.model.CjCRBusqueda;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author B941337
 */
@Component
public class CjCRAlarmaSucursal {

    @Autowired
    private CjCRConfiguracionLogic configuracion;

    @Autowired
    private CjCRAppConfig appConfig;

    @Autowired
    private CjCRMailDispatcher mail;

    @Autowired
    private CjCRGeoSucursalDao sucursalDao;

    private static final int ON = 1;
    private static final int MODULO1 = 1;
    private static final int FOLIO1 = 0;
    private static final int FOLIO2 = 1;
    private static final int FOLIO3 = 2;
    private static final int FOLIO4 = 3;
    private static final Logger LOG = Logger.getLogger(CjCRAlarmaService.class);

    public CjCRRespuesta getMonitoreoSucursal(CjCRTransaccion transaccion) throws CjCRConfigException {

        CjCRRespuesta respuesta = new CjCRRespuesta();
        respuesta.setStatus(0);
        respuesta.setMsg("");

        try {
            int idSucursal = transaccion.getIdSucursal();
            int idPais = transaccion.getIdPais();
            int idCanal = transaccion.getIdCanal();
            int idEmpleado = transaccion.getIdEmpleado();
            int idPuesto = transaccion.getIdPuesto();
            int idRol = transaccion.getIdRol();

            String horaSucursal = transaccion.getHoraSucursal();
            String nombreEmpleado = transaccion.getNombreEmpleado();
            
            LOG.info("Se recibe solicitud - par\u00E1metros de entrada: Pa\u00EDs: " + idPais + " Canal: " + idCanal + " Sucursal: " + idSucursal + " Id Empleado: " + idEmpleado + " Nombre Empleado: " + nombreEmpleado
                    + " Puesto: " + idPuesto + " Rol: " + idRol + " Hora: " + horaSucursal);

            boolean sucursalInvalida = false;
            boolean puestoValido = false;
            
            List<CjCRBusqueda> paramsConfiguracion = configuracion.getParamsConfiguracion(MODULO1, null, null);
            
            
            Collections.sort(paramsConfiguracion, new Comparator<CjCRBusqueda>() {
                @Override
                public int compare(CjCRBusqueda element1, CjCRBusqueda element2) {
                    return element1.getFolio() - element2.getFolio();
                }
            });
            
            Integer estadoAlarma = (Integer.parseInt(paramsConfiguracion.get(FOLIO1).getValor()));

            String sucursales = paramsConfiguracion.get(FOLIO3).getValor();
            String puestos = paramsConfiguracion.get(FOLIO4).getValor();
            
            if (sucursales == null){            
                sucursales = "";
            }                            
            
            if (puestos == null){            
                puestos = "";
            }
            
            String[] arraySucursales = sucursales.split(",");
            String[] arrayPuestos = puestos.split(",");                        
            
            for (String sucursal : arraySucursales) {
                if (String.valueOf(idSucursal).equals(sucursal)) {
                    sucursalInvalida = true;
                }
            }
            
            if("".equals(puestos)){
                puestoValido = true;
            } else {
                for (String puesto : arrayPuestos) {
                    if (String.valueOf(idPuesto).equals(puesto)||String.valueOf(idRol).equals(puesto)) {
                        puestoValido = true;
                    }
                }
            }
            
            
            String destinatarios = paramsConfiguracion.get(FOLIO2).getValor();
            String mensaje = null;
            String asunto = appConfig.getAsuntoUnEmpleado()+ idSucursal;

            if ((estadoAlarma == ON)) {
                if (!sucursalInvalida) {
                    if (puestoValido) {
                        getAlarma(transaccion, destinatarios, asunto);
                    }else{
                        mensaje = " PUESTO: " + idPuesto + ", ROL: "+ idRol +" NO APLICAN PARA ENVÍO DE ALARMA POR CORREO";
                        LOG.warn(mensaje);                                
                    }                    
                } else {
                    mensaje = " SUCURSAL: " + idSucursal + " NO ES VALIDA";
                    LOG.warn(mensaje);
                }
            } else {
                mensaje = "LA ALARMA SE ENCUENTRA APAGADA";
                LOG.warn(mensaje);
            }
        } catch (Exception ex) {
            respuesta.setStatus(-1);
            respuesta.setMsg("Error al procesar petición: "+ex.getMessage());
            LOG.error("Status, se responde con error -1 --> " + ex.getMessage() , ex);            
        }finally{
            LOG.info("Respuesta status: " + respuesta.getStatus());
            LOG.info("Respuesta mensaje: " + respuesta.getMsg());
        }           
        return respuesta;
    }

    public void getAlarma(CjCRTransaccion transaccion, String destinatarios, String asunto) throws Exception {
        List<Integer> sucurs = new ArrayList<Integer>();
        int idSucursal = transaccion.getIdSucursal();
        int idEmpleado = transaccion.getIdEmpleado();
        int idPuesto = transaccion.getIdPuesto();
        int idRol = transaccion.getIdRol();
        int idPais = transaccion.getIdPais();
        int idCanal = transaccion.getIdCanal();

        String nombreEmpleado = transaccion.getNombreEmpleado();
        String fecha = transaccion.getHoraSucursal();
        String mensaje = null;
        String nombreSucursal = "";
        String body = "";
        sucurs.add(Integer.valueOf(idSucursal));

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
                body += "<center><strong> Correo de Prueba </strong></center><br/>";
            }

            body += "<table align='center' border='0' style='background-color:#BDBDBD;border:0px dotted #BDBDBD;width:50%;border-collapse:collapse;'>";
            body += "<tr style='background-color:white;color:black; border:1px dotted white; '>";
            body += "<th colspan='2' style='padding:3px;'>Alarma de operación con un empleado.</th>";
            body += "</tr>";

            body += "<tr style='background-color:white;color:black; border:0 px dotted white;'>";
            body += "<td align='left' colspan='2' style='padding:3px;'>&nbsp; </td> ";
            body += "</tr>";

            body += "<tr style='background-color:white;color:black; border:0px dotted white;'>";
            body += "<td align='left' colspan='2' style='padding:3px;'>La sucursal " + idSucursal + " " + nombreSucursal + "   reporta operaci\u00F3n con un solo empleado.</td> ";
            body += "</tr>";

            body += "<tr style='background-color:white;color:black; border:1px dotted white;'>";
            body += "<td align='left' colspan='2' style='padding:3px;'>&nbsp; </td> ";
            body += "</tr>";
            body += "<tr>";

            body += "<td style='padding:3px;width:20%;'>No. de Empleado:</td><td style='padding:3px;width:80%;'>" + idEmpleado + "</td>";
            body += "</tr>";
            body += "</tr>";
            body += "<tr>";

            body += "<td style='padding:3px;width:20%;'>Nombre:</td><td style='padding:3px;width:80%;'>" + nombreEmpleado + "</td>";
            body += "</tr>";

            body += "<tr style='background-color:white;color:black; border:1px dotted white;'>";
            body += "<td align='left' colspan='2' style='padding:3px;'>&nbsp; </td> ";
            body += "</tr>";

            body += "<tr style='background-color:white;color:black; border:1px dotted white;'>";
            body += "<td align='left' colspan='2' style='padding:3px;'>Se ecuentra operando con un Puesto: " + idPuesto + "  Rol: " + idRol + "</td> ";
            body += "</tr>";

            body += "<tr style='background-color:white;color:black; border:1px dotted white;'>";
            body += "<td align='left' colspan='2' style='padding:3px;'>Hora de detecci\u00F3n en sucursal: " + fecha + ".</td> ";
            body += "</tr>";
            body += "</table>";

            CjCRMailDispatcher.Mail nuevoMail = mail.getMail(destinatarios, asunto);
            nuevoMail.setAddresses(destinatarios);
            nuevoMail.setBody(body);
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
