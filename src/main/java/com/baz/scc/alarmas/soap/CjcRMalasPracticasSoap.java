
package com.baz.scc.alarmas.soap;

import com.baz.scc.alarmas.malapract.model.CjCRMalasPracticasMdl;
import com.baz.scc.alarmas.malapract.model.CjCRRespMalasPracticasMdl;
import com.baz.scc.alarmas.service.CjCRMalasPracticasService;
import javax.jws.WebMethod;
import javax.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author B233388 Froil&aacute; L&oacute;pez Lemus
 */
@Component("malasPracticasSoap")
@WebService(serviceName = "malasPracticas")
public class CjcRMalasPracticasSoap {
    
    @Autowired
    private CjCRMalasPracticasService malasPracticasService;
    
    @WebMethod(operationName = "informe")
    public CjCRRespMalasPracticasMdl practicas(CjCRMalasPracticasMdl malasPracticas) {
        return malasPracticasService.respuestaService(malasPracticas);
    }
    
}
