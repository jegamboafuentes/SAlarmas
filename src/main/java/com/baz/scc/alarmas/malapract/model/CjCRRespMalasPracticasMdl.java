
package com.baz.scc.alarmas.malapract.model;

import com.baz.scc.alarmas.support.CjCRRespuesta;

/**
 *
 * @author B233388 Froil&aacute; L&oacute;pez Lemus
 */
public class CjCRRespMalasPracticasMdl extends CjCRRespuesta{
    
    public static final CjCRRespMalasPracticasMdl RESPUESTA_ERROR_ESTANDAR;
    
    private long idFolio;
    
    static {
        RESPUESTA_ERROR_ESTANDAR  = CjCRRespMalasPracticasMdl.getRespuesta(
                CjCRRespuesta.SERVICE_RESPONSE_ERROR, "Error estándar", 0);
    }
    

    public long getIdFolio() {
        return idFolio;
    }

    public void setIdFolio(long idFolio) {
        this.idFolio = idFolio;
    }

    public static CjCRRespMalasPracticasMdl getRespuesta(int status, String msg, long idFolio) {
        CjCRRespMalasPracticasMdl result = new CjCRRespMalasPracticasMdl();
        
        result.setStatus(status);
        result.setMsg(msg);
        result.setIdFolio(idFolio);
        
        return result;
    }
    
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        
        str.append(super.toString());
        str.append("CjCRRespMalasPracticasMdl[");
        str.append("idFolio=");
        str.append(idFolio);
        str.append("]");
        
        return str.toString();
    }
    
}
