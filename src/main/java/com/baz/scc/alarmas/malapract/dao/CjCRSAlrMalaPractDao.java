
package com.baz.scc.alarmas.malapract.dao;

import com.baz.scc.alarmas.base.dao.CjCRSAlrBaseDao;
import com.baz.scc.alarmas.base.dao.CjCRSAlrBaseQueryDao;
import com.baz.scc.alarmas.malapract.model.CjCRMalasPracticasMdl;
import com.baz.scc.alarmas.malapract.model.CjCRRespMalasPracticasMdl;
import com.baz.scc.alarmas.malapract.model.CjCRSAlrMalaPractOpcion;
import com.baz.scc.alarmas.support.CjCRConstUtl;
import com.baz.scc.alarmas.support.CjCRRespuesta;
import com.baz.scc.commons.util.CjCRDaoUtils;
import java.sql.CallableStatement;
import java.sql.SQLException;
import oracle.jdbc.OracleTypes;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.stereotype.Repository;

/**
 *
 * @author B233388 Froil&aacute; L&oacute;pez Lemus
 */
@Repository(CjCRSAlrMalaPractDao.BEAN_NAME)
public class CjCRSAlrMalaPractDao 
        extends CjCRSAlrBaseDao<CjCRSAlrMalaPractOpcion, CjCRMalasPracticasMdl> {
    public static final String BEAN_NAME = "cjCRSAlrMalaPractDao";
    private static final Logger CLASS_LOG;
    
    static {
        CLASS_LOG = Logger.getLogger(CjCRSAlrMalaPractDao.class);
    }
    
    @Autowired
    @Qualifier(CjCRSAlrMalaPractQueryDao.BEAN_NAME)
    private CjCRSAlrBaseQueryDao queryDao;
    
    
    @Override
    public CjCRRespuesta execOpcion(CjCRSAlrMalaPractOpcion opc, CjCRMalasPracticasMdl detalle) {
        CjCRRespuesta result;
        
        switch(opc) {
            case INSERT_REGISTRO:
                result = insertRegistro(opc, detalle);
                break;
            default:
                result = CjCRRespuesta.RESPUESTA_ERROR_ESTANDAR;
        }
        
        return result;
    }
    
    private CjCRRespuesta insertRegistro(CjCRSAlrMalaPractOpcion opc, 
            final CjCRMalasPracticasMdl detalle){
        CjCRRespuesta result;
        String query;
        
        query = queryDao.getQuery(opc);
        
        try {
            result = usrcajaJdbcTemplate.execute(query, 
                    new CallableStatementCallback<CjCRRespuesta>(){

                @Override
                public CjCRRespMalasPracticasMdl doInCallableStatement(CallableStatement cs) 
                        throws SQLException, DataAccessException {
                    CjCRRespMalasPracticasMdl result;
                    
                    CjCRDaoUtils.addInt(cs, 1, detalle.getIdPais());
                    CjCRDaoUtils.addInt(cs, 2, detalle.getIdCanal());
                    CjCRDaoUtils.addInt(cs, 3, detalle.getIdSucursal());
                    CjCRDaoUtils.addString(cs, 4, detalle.getIdEmpleado());
                    CjCRDaoUtils.addInt(cs, 5, detalle.getIdRol());
                    CjCRDaoUtils.addInt(cs, 6, detalle.getIdPuesto());
                    CjCRDaoUtils.addInt(cs, 7, detalle.getIdTipoReporte());
                    CjCRDaoUtils.addString(cs, 8, detalle.getFechaEvento());
                    CjCRDaoUtils.addString(cs, 9, detalle.getDetallePersonal());
                    CjCRDaoUtils.addString(cs, 10, detalle.getDetalleEvento());
                    CjCRDaoUtils.addString(cs, 11, detalle.getDetalleExtra());
                    CjCRDaoUtils.addString(cs, 12, CjCRConstUtl.USER_ALARMA);
                    cs.registerOutParameter(13, OracleTypes.NUMBER);
                    cs.registerOutParameter(14, OracleTypes.VARCHAR);
                    cs.registerOutParameter(15, OracleTypes.NUMBER);
                    
                    cs.executeQuery();
                    
                    result = new CjCRRespMalasPracticasMdl();
                    
                    result.setStatus(cs.getInt(13));
                    result.setMsg(cs.getString(14));
                    result.setIdFolio(cs.getInt(15));
                    
                    return result;
                }
            });
        } catch (DataAccessException dae) {
            result = CjCRRespMalasPracticasMdl.RESPUESTA_ERROR_ESTANDAR;
            CLASS_LOG.error("Error al ejecutar SP Malas Prácticas", dae);
        }
        
        return result;
    }
}
