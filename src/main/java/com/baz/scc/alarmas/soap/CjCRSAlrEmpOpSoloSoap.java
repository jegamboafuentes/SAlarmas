
package com.baz.scc.alarmas.soap;

import com.baz.scc.alarmas.empopsolo.model.CjCRSAlrEmpOpSoloDetMdl;
import com.baz.scc.alarmas.support.CjCRRespuesta;
import com.baz.scc.alarmas.service.CjCRSAlrEmpOpSoloService;
import javax.jws.WebMethod;
import javax.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author B233388 Froil&aacute; L&oacute;pez Lemus
 */
@Component(CjCRSAlrEmpOpSoloSoap.BEAN_NAME)
@WebService(serviceName = "empleadoOperandoSolo")
public class CjCRSAlrEmpOpSoloSoap {
    public static final String BEAN_NAME = "empOpSoloSoap";
    
    @Autowired
    private CjCRSAlrEmpOpSoloService empOpSoloService;
    
    @WebMethod(operationName = "evento")
    public CjCRRespuesta empSolo(CjCRSAlrEmpOpSoloDetMdl detalle) {
        return empOpSoloService.insertEvento(detalle);
    }
}
