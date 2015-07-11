/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.baz.scc.alarmas.service;

import com.baz.scc.alarmas.alarmasucursal.logic.CjCRAlarmaSucursal;
import com.baz.scc.alarmas.support.CjCRRespuesta;
import com.baz.scc.alarmas.alarmasucursal.model.CjCRTransaccion;
import com.baz.scc.configuracion.exception.CjCRConfigException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <br><br>Copyright 2014 Banco Azteca. Todos los derechos reservados.
 *
 * @author B941337 Mariana Pineda Villa
 */
@Service
public class CjCRAlarmaService {

    @Autowired
    private CjCRAlarmaSucursal alarma;

    public CjCRRespuesta respuestaService(CjCRTransaccion transaccion) throws CjCRConfigException   {          
       return alarma.getMonitoreoSucursal(transaccion) ;
    }
}
