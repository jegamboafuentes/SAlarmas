/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.baz.scc.alarmas.soap;

import com.baz.scc.alarmas.support.CjCRRespuesta;
import com.baz.scc.alarmas.alarmasucursal.model.CjCRTransaccion;
import com.baz.scc.alarmas.service.CjCRAlarmaService;
import com.baz.scc.configuracion.exception.CjCRConfigException;

import javax.jws.WebMethod;
import javax.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <br><br>Copyright 2014 Banco Azteca. Todos los derechos reservados.
 *
 * @author B941337 Mariana Pineda Villa

 Servicio SOAP
 */
@Component("alarmaService")
@WebService(serviceName = "alarma")
public class CjCRSoapAlarma {

    @Autowired
    private CjCRAlarmaService alarmaService;

    @WebMethod(operationName = "monitoreo")
    public CjCRRespuesta monitoreo(CjCRTransaccion transaccion) throws CjCRConfigException {   
       return alarmaService.respuestaService(transaccion);      
    }
}
