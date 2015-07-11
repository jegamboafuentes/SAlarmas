/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.baz.scc.alarmas.rest;

import com.baz.scc.alarmas.support.CjCRRespuesta;
import com.baz.scc.alarmas.alarmasucursal.model.CjCRTransaccion;
import com.baz.scc.alarmas.service.CjCRAlarmaService;
import com.baz.scc.configuracion.exception.CjCRConfigException;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <br><br>Copyright 2014 Banco Azteca. Todos los derechos reservados.
 *
 * @author B941337 Mariana Pineda Villa
 */
@Controller
@RequestMapping("/services/rest")
public class CjCRRestAlarma {

    @Autowired
    private CjCRAlarmaService alarmaService;

    @ResponseBody
    @RequestMapping(value = "/alarma",
            method = {RequestMethod.POST},
            consumes = {MediaType.APPLICATION_JSON},
            produces = {MediaType.APPLICATION_JSON})
    public CjCRRespuesta ejecutar(
            @RequestBody CjCRTransaccion transaccion) throws CjCRConfigException {
       return alarmaService.respuestaService(transaccion);
    }
}
