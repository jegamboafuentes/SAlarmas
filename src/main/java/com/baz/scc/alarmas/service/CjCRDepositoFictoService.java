
package com.baz.scc.alarmas.service;

import com.baz.scc.alarmas.base.logic.CjCRSAlrBaseLogic;
import com.baz.scc.alarmas.depficto.logic.CjCRSAlrDepoFictoLogic;
import com.baz.scc.alarmas.depficto.model.CjCRSAlrBloqueoDetalleMdl;
import com.baz.scc.alarmas.depficto.model.CjCRSAlrDepoFictoOpcion;
import com.baz.scc.alarmas.support.CjCRRespuesta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * <br><br>Copyright 2014 Banco Azteca. Todos los derechos reservados.
 *
 * Capa de acceso a datos para de´&oacute;sitos fictos.
 *
 * @author B229463 Carlos Ever Isai V.E.
 */

@Service
public class CjCRDepositoFictoService {
    
    @Autowired
    @Qualifier(CjCRSAlrDepoFictoLogic.BEAN_NAME)
    private CjCRSAlrBaseLogic depoFictoLogic;

    public CjCRRespuesta insertEvento(CjCRSAlrBloqueoDetalleMdl depoBloqDetalle) {
        return depoFictoLogic.execOpcion(CjCRSAlrDepoFictoOpcion.INSERT_EVENTO, depoBloqDetalle);
    }        
}
