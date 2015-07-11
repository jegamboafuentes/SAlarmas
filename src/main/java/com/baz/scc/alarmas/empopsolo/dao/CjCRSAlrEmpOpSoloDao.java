
package com.baz.scc.alarmas.empopsolo.dao;

import com.baz.scc.alarmas.base.dao.CjCRSAlrBaseDao;
import com.baz.scc.alarmas.base.dao.CjCRSAlrBaseQueryDao;
import com.baz.scc.alarmas.empopsolo.model.CjCRSAlrEmpOpSoloDetMdl;
import com.baz.scc.alarmas.empopsolo.model.CjCRSAlrEmpOpSoloOpcion;
import com.baz.scc.alarmas.support.CjCRRespuesta;
import com.baz.scc.alarmas.support.CjCRConstUtl;
import com.baz.scc.commons.support.CjCRDaoConfig;
import com.baz.scc.commons.util.CjCRDaoUtils;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.OracleTypes;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author B233388 Froil&aacute; L&oacute;pez Lemus
 */
@Repository(CjCRSAlrEmpOpSoloDao.BEAN_NAME)
public class CjCRSAlrEmpOpSoloDao 
        extends CjCRSAlrBaseDao<CjCRSAlrEmpOpSoloOpcion, CjCRSAlrEmpOpSoloDetMdl> {
    public static final String BEAN_NAME = "cjCRSAlrEmpOpSoloDao";
    private static final Logger CLASS_LOG;
    
    static {
            CLASS_LOG = Logger.getLogger(CjCRSAlrEmpOpSoloDao.class);
    }
    
    // temporal
    //@Autowired
    //protected CjCRDaoConfig usuarioCaja;
    
    // temporal
    //@Autowired
    //@Qualifier("usrinfcajaJdbcTemplate")
    //protected JdbcTemplate usrInfcajaJdbcTemplate;

    @Autowired
    @Qualifier(CjCRSAlrEmpOpSoloQueryDao.BEAN_NAME)
    private CjCRSAlrBaseQueryDao queryDao;
    
    @Override
    public CjCRRespuesta execOpcion(CjCRSAlrEmpOpSoloOpcion opc, CjCRSAlrEmpOpSoloDetMdl detalle) {
        CjCRRespuesta result;
        
        switch(opc) {
            case INSERT_EVENTO:
                result = insertEvento(opc, detalle);
                //result = insertEventoStirng(opc, detalle);
                break;
            default:
                result = CjCRRespuesta.RESPUESTA_ERROR_ESTANDAR;
        }
        
        return result;
    }
    
    private CjCRRespuesta insertEvento(CjCRSAlrEmpOpSoloOpcion opc,
            final CjCRSAlrEmpOpSoloDetMdl detalle) {
        CjCRRespuesta result;
        String query;
        
        query = queryDao.getQuery(opc);
        
        try {
            result = usrcajaJdbcTemplate.execute(query, 
                    new CallableStatementCallback<CjCRRespuesta>(){

                @Override
                public CjCRRespuesta doInCallableStatement(CallableStatement cs) 
                        throws SQLException, DataAccessException {
                    CjCRRespuesta result;
                    
                    CjCRDaoUtils.addInt(cs, 1, detalle.getIdPais());
                    CjCRDaoUtils.addInt(cs, 2, detalle.getIdCanal());
                    CjCRDaoUtils.addInt(cs, 3, detalle.getIdSucursal());
                    CjCRDaoUtils.addString(cs, 4, detalle.getFecha());
                    CjCRDaoUtils.addString(cs, 5, detalle.getIdEmpleado());
                    CjCRDaoUtils.addString(cs, 6, detalle.getEmpleado());
                    CjCRDaoUtils.addInt(cs, 7, detalle.getIdPuesto());
                    CjCRDaoUtils.addInt(cs, 8, detalle.getIdRol());
                    CjCRDaoUtils.addInt(cs, 9, detalle.getStatusBloq());
                    CjCRDaoUtils.addString(cs, 10, CjCRConstUtl.USER_ALARMA);
                    cs.registerOutParameter(11, OracleTypes.NUMBER);
                    cs.registerOutParameter(12, OracleTypes.VARCHAR);
                    
                    cs.executeQuery();
                    
                    result = CjCRRespuesta.getRespuesta(cs.getInt(11), cs.getString(12));
                    
                    return result;
                }
            });
        } catch (DataAccessException dae) {
            result = CjCRRespuesta.RESPUESTA_ERROR_DAO;
            CLASS_LOG.error("SQL - Error al procesar petición: ", dae);
        }
        
        return result;
    }
    
    
    
    // temporal
//    private CjCRRespuesta insertEventoStirng(CjCRSAlrEmpOpSoloOpcion opc,
//            final CjCRSAlrEmpOpSoloDetMdl detalle) {
//        CjCRRespuesta result;
//        String query;
//        
//        query = getQryStringInsert(detalle);
//        
//        try {
//            result = usrInfcajaJdbcTemplate.execute(query, 
//                    new CallableStatementCallback<CjCRRespuesta>(){
//
//                @Override
//                public CjCRRespuesta doInCallableStatement(CallableStatement cs) 
//                        throws SQLException, DataAccessException {
//                    CjCRRespuesta result;
//                    
////                    CjCRDaoUtils.addInt(cs, 1, detalle.getIdPais());
////                    CjCRDaoUtils.addInt(cs, 2, detalle.getIdCanal());
////                    CjCRDaoUtils.addInt(cs, 3, detalle.getIdSucursal());
////                    CjCRDaoUtils.addString(cs, 4, detalle.getFecha());
////                    CjCRDaoUtils.addString(cs, 5, detalle.getIdEmpleado());
////                    CjCRDaoUtils.addString(cs, 6, detalle.getEmpleado());
////                    CjCRDaoUtils.addInt(cs, 7, detalle.getIdPuesto());
////                    CjCRDaoUtils.addInt(cs, 8, detalle.getIdRol());
////                    CjCRDaoUtils.addInt(cs, 9, detalle.getStatusBloq());
////                    CjCRDaoUtils.addString(cs, 10, CjCRConstUtl.USER_ALARMA);
////                    cs.registerOutParameter(11, OracleTypes.NUMBER);
////                    cs.registerOutParameter(12, OracleTypes.VARCHAR);
//                    
//                    cs.executeQuery();
//                    
//                    int i = usrInfcajaJdbcTemplate.queryForInt(getComproInsert(detalle));
//                    
//                    //result = CjCRRespuesta.getRespuesta(cs.getInt(11), cs.getString(12));
//                    
//                    if (i > 0 ) {
//                        result = CjCRRespuesta.RESPUESTA_SUCCESS;
//                    } else {
//                        result = CjCRRespuesta.RESPUESTA_ERROR_ESTANDAR;
//                    }
//                    
//                    
//                    return result;
//                }
//            });
//        } catch (DataAccessException dae) {
//            result = CjCRRespuesta.RESPUESTA_ERROR_DAO;
//            CLASS_LOG.error("SQL - Error al procesar petición: ", dae);
//        }
//        
//        return result;
//        
//    }
//    
//    
//    // temporal
//    private String getQryStringInsert(CjCRSAlrEmpOpSoloDetMdl detalle) {
//        StringBuilder str = new StringBuilder();
//        
//        str.append("INSERT INTO ");
//        str.append(usuarioCaja.getObjectUser());
//        str.append(".TACJALREMPSOLO (");
//        str.append("FIPAISID,");
//        str.append("FICANALID,");
//        str.append("FISUCURSALID,");
//        str.append("FDFECHAID,");
//        str.append("FCNOEMP,");
//        str.append("FCEMPLEADO,");
//        str.append("FIIDPUESTO,");
//        str.append("FIIDROL,");
//        str.append("FISTATUSBLOQ, ");
//        str.append("FCUSRINSMOV, ");
//        str.append("FDFECHAINSMOV, ");
//        str.append("FCUSRMODIF, ");
//        str.append("FDFECHAMODIF ");
//        str.append(") VALUES (");
//        str.append(detalle.getIdPais());
//        str.append(", ");
//        str.append(detalle.getIdCanal());
//        str.append(", ");
//        str.append(detalle.getIdSucursal());
//        str.append(", TO_DATE('");
//        str.append(detalle.getFecha());
//        str.append("', 'yyyy-MM-dd HH24:MI:SS'),'");
//        str.append(detalle.getIdEmpleado());
//        str.append("', '");
//        str.append(detalle.getEmpleado());
//        str.append("', ");
//        str.append(detalle.getIdPuesto());
//        str.append(", ");
//        str.append(detalle.getIdRol());
//        str.append(", ");
//        str.append(detalle.getStatusBloq());
//        str.append(", ");
//        str.append("'USRALRB', SYSDATE, 'USRALRB', SYSDATE )");
//        
//        return str.toString();
//    }
//    
//    
//    private String getComproInsert(CjCRSAlrEmpOpSoloDetMdl detalle) {
//        StringBuilder str = new StringBuilder();
//        
//        str.append("SELECT COUNT(FDFECHAID) ");
//        str.append("from ");
//        str.append(usuarioCaja.getObjectUser());
//        str.append(".TACJALREMPSOLO  ");
//        str.append(" WHERE ");
//        str.append(" FIPAISID = ");
//        str.append(detalle.getIdPais() );
//        str.append(" AND FICANALID = ");
//        str.append(detalle.getIdCanal() );
//        str.append(" AND FISUCURSALID = ");
//        str.append(detalle.getIdSucursal() );
//        str.append(" AND  FDFECHAID = ");
//        str.append(" TO_DATE('");
//        str.append(detalle.getFecha());
//        str.append("', 'yyyy-MM-dd HH24:MI:SS')");
//        str.append(" GROUP BY FIPAISID, FICANALID, FISUCURSALID, FDFECHAID");
//        
//        
//        return str.toString();
//    }
}
