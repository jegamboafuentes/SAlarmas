
package com.baz.scc.alarmas.rest;

import com.baz.scc.alarmas.malapract.model.CjCRMalasPracticasMdl;
import com.baz.scc.alarmas.support.CjCRRespuesta;
import com.baz.scc.alarmas.service.CjCRMalasPracticasService;
import com.baz.scc.alarmas.support.CjCRConstUtl;
import com.baz.scc.configuracion.exception.CjCRConfigException;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author B233388 Froil&aacute; L&oacute;pez Lemus
 */
@Controller
@RequestMapping(CjCRConstUtl.SERVICES_REST_URL)
public class CjCRMalasPracticasRest {
    
    @Autowired
    CjCRMalasPracticasService malasPracticasService;
    
    @ResponseBody
    @RequestMapping(value = "/malasPracticas/informe",
            method = {RequestMethod.POST},
            consumes = {MediaType.APPLICATION_JSON},
            produces = {MediaType.APPLICATION_JSON})
    public CjCRRespuesta ejecutar(@RequestBody CjCRMalasPracticasMdl malasPracticas)
            throws CjCRConfigException {
        return malasPracticasService.respuestaService(malasPracticas);
    }
}
