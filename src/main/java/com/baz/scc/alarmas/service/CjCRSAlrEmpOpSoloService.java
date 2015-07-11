
package com.baz.scc.alarmas.service;

import com.baz.scc.alarmas.base.logic.CjCRSAlrBaseLogic;
import com.baz.scc.alarmas.empopsolo.logic.CjCRSAlrEmpOpSoloLogic;
import com.baz.scc.alarmas.empopsolo.model.CjCRSAlrEmpOpSoloDetMdl;
import com.baz.scc.alarmas.empopsolo.model.CjCRSAlrEmpOpSoloOpcion;
import com.baz.scc.alarmas.support.CjCRRespuesta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author B233388 Froil&aacute; L&oacute;pez Lemus
 */
@Service
public class CjCRSAlrEmpOpSoloService {
    
    @Autowired
    @Qualifier(CjCRSAlrEmpOpSoloLogic.BEAN_NAME)
    private CjCRSAlrBaseLogic empOpSoloLogic;
    
    public CjCRRespuesta insertEvento(CjCRSAlrEmpOpSoloDetMdl  detalle) {
        return empOpSoloLogic.execOpcion(CjCRSAlrEmpOpSoloOpcion.INSERT_EVENTO, detalle);
    }
}
