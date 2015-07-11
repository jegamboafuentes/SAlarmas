
package com.baz.scc.alarmas.soap;

import com.baz.scc.alarmas.depficto.model.CjCRSAlrBloqueoDetalleMdl;
import com.baz.scc.alarmas.support.CjCRRespuesta;
import com.baz.scc.alarmas.service.CjCRDepositoFictoService;
import javax.jws.WebMethod;
import javax.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
* @author B233388 Froil&aacute;n L&oacute;pez Lemus
* @since V 1.1.2
*/
@Component("depositoFictoService")
@WebService(serviceName = "depositosFictos")
public class CjCRDepositoFictoSoap {
    
    @Autowired
    private CjCRDepositoFictoService depositoFictoService;
    
    @WebMethod(operationName = "bloqueos")        
    public CjCRRespuesta bloqueos(CjCRSAlrBloqueoDetalleMdl depoBloqDetalle) {
        return depositoFictoService.insertEvento(depoBloqDetalle);        
    }
}
