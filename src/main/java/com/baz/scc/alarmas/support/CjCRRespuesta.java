
package com.baz.scc.alarmas.support;

/**
 *
 * @author B941337
 */
public class CjCRRespuesta {
    public static final CjCRRespuesta RESPUESTA_SUCCESS;
    public static final CjCRRespuesta RESPUESTA_ERROR_ESTANDAR;
    public static final CjCRRespuesta RESPUESTA_ERROR_DAO;
    
    static {
        RESPUESTA_SUCCESS = getRespuesta(CjCRRespuesta.SERVICE_RESPONSE_SUCCESS, "");
        RESPUESTA_ERROR_ESTANDAR  = getRespuesta(CjCRRespuesta.SERVICE_RESPONSE_ERROR, 
                "SQL - Error estándar");
        RESPUESTA_ERROR_DAO  = getRespuesta(CjCRRespuesta.SERVICE_RESPONSE_ERROR_DAO, 
                "Error al procesar la petición");
    }
    
    public static final int SERVICE_RESPONSE_ERROR = -1;
    public static final int SERVICE_RESPONSE_ERROR_DAO = -5;
    public static final int SERVICE_RESPONSE_SUCCESS = 0;
    
    private int status;
    private String msg;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static CjCRRespuesta getRespuesta(int status, String msg) {
        CjCRRespuesta result = new CjCRRespuesta();
        
        result.setStatus(status);
        result.setMsg(msg);
        
        return result;
    }
}
