
package com.baz.scc.alarmas.service;

import com.baz.scc.alarmas.base.logic.CjCRSAlrBaseLogic;
import com.baz.scc.alarmas.malapract.logic.CjCRMalasPracticasLogic;
import com.baz.scc.alarmas.malapract.model.CjCRMalasPracticasMdl;
import com.baz.scc.alarmas.malapract.model.CjCRRespMalasPracticasMdl;
import com.baz.scc.alarmas.malapract.model.CjCRSAlrMalaPractOpcion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author B233388 Froil&aacute; L&oacute;pez Lemus
 */
@Service
public class CjCRMalasPracticasService {
    
    @Autowired 
    @Qualifier(CjCRMalasPracticasLogic.BEAN_NAME)
    private CjCRSAlrBaseLogic malasPracticasLogic;
    
    public CjCRRespMalasPracticasMdl respuestaService(CjCRMalasPracticasMdl malasPracticas) {
        return (CjCRRespMalasPracticasMdl)
                malasPracticasLogic.execOpcion(CjCRSAlrMalaPractOpcion.INSERT_REGISTRO, malasPracticas);
    }
}
