
package com.baz.scc.alarmas.rest;

import com.baz.scc.alarmas.depficto.model.CjCRSAlrBloqueoDetalleMdl;
import com.baz.scc.alarmas.support.CjCRRespuesta;
import com.baz.scc.alarmas.service.CjCRDepositoFictoService;
import com.baz.scc.configuracion.exception.CjCRConfigException;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
* @author B233388 Froil&aacute;n L&oacute;pez Lemus
* @since V 1.1.2
*/
@Controller
@RequestMapping("/services/rest")
public class CjcRDepositoFictoRest {
    
    @Autowired
    private CjCRDepositoFictoService depositoFictoService;
    
    @ResponseBody
    @RequestMapping(value = "/depositosFictos/bloqueos",
            method = {RequestMethod.POST},
            consumes = {MediaType.APPLICATION_JSON},
            produces = {MediaType.APPLICATION_JSON})    
    public CjCRRespuesta ejecutar(@RequestBody CjCRSAlrBloqueoDetalleMdl depoBloqDetalle)
            throws CjCRConfigException {        
        return depositoFictoService.insertEvento(depoBloqDetalle);        
    }
}
