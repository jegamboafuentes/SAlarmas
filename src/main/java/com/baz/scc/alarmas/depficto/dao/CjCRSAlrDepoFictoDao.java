package com.baz.scc.alarmas.depficto.dao;

import com.baz.scc.alarmas.base.dao.CjCRSAlrBaseDao;
import com.baz.scc.alarmas.base.dao.CjCRSAlrBaseQueryDao;
import com.baz.scc.alarmas.depficto.model.CjCRSAlrBloqueoDetalleMdl;
import com.baz.scc.alarmas.depficto.model.CjCRSAlrDepoFictoOpcion;
import com.baz.scc.alarmas.support.CjCRConstUtl;
import com.baz.scc.alarmas.support.CjCRRespuesta;
import com.baz.scc.commons.util.CjCRDaoUtils;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.SQLException;
import oracle.jdbc.OracleTypes;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.stereotype.Component;

/**
 * <br><br>Copyright 2014 Banco Azteca. Todos los derechos reservados.
 *
 * Capa de acceso a datos para dep&oacute;sitos fictos.
 *
 * @author B229463 Carlos Ever Isa&iacute; V.E.
 */
@Component
public class CjCRSAlrDepoFictoDao
        extends CjCRSAlrBaseDao<CjCRSAlrDepoFictoOpcion, CjCRSAlrBloqueoDetalleMdl> {
    
    public static final String BEAN_NAME = "cjCRSAlrDepoFictoDao";
    
    private static final Logger LOG;

    static {
        LOG = Logger.getLogger(CjCRSAlrDepoFictoDao.class);
    }

    @Autowired
    @Qualifier(CjCRSAlrDepoFictoQueryDao.BEAN_NAME)
    private CjCRSAlrBaseQueryDao queryDao;

    @Override
    public CjCRRespuesta execOpcion(CjCRSAlrDepoFictoOpcion opc, CjCRSAlrBloqueoDetalleMdl detalle) {
        CjCRRespuesta result;

        switch (opc) {

            case INSERT_BLOQUEO:
                result = insertBloqueo(opc, detalle);
                break;
            case INSERT_DETALLE:
                result = insertDetalle(opc, detalle);
                break;
            default:
                result = CjCRRespuesta.RESPUESTA_ERROR_ESTANDAR;
        }

        return result;
    }

    public CjCRRespuesta insertBloqueo(CjCRSAlrDepoFictoOpcion opc,
            final CjCRSAlrBloqueoDetalleMdl detalle) {
        CjCRRespuesta result;
        String query;

        query = queryDao.getQuery(opc);

        try {
            result = usrcajaJdbcTemplate.execute(query,
                    new CallableStatementCallback<CjCRRespuesta>() {

                        @Override
                        public CjCRRespuesta doInCallableStatement(CallableStatement cs)
                        throws SQLException, DataAccessException {
                            int index;
                            int indexOutInteger;
                            int indexOutString;
                            int codeStatus;
                            String messageStatus;

                            index = 0;
                            CjCRDaoUtils.addInt(cs, ++index, detalle.getDepoFicto().getIdPais());
                            CjCRDaoUtils.addInt(cs, ++index, detalle.getDepoFicto().getIdCanal());
                            CjCRDaoUtils.addInt(cs, ++index, detalle.getDepoFicto().getIdSucursal());
                            CjCRDaoUtils.addInt(cs, ++index, detalle.getDepoFicto().getIdBloqueo());
                            CjCRDaoUtils.addString(cs, ++index, detalle.getDepoFicto().getFechaBloqueo());
                            CjCRDaoUtils.addInt(cs, ++index, detalle.getDepoFicto().getIdDivisa());
                            CjCRDaoUtils.addBigDecimal(cs, ++index, new BigDecimal(detalle.getDepoFicto().getMontoBloqueo()));
                            CjCRDaoUtils.addInt(cs, ++index, detalle.getDepoFicto().getIdArqueo());
                            CjCRDaoUtils.addString(cs, ++index, detalle.getDepoFicto().getFechaDesbloqueo());
                            CjCRDaoUtils.addInt(cs, ++index, detalle.getDepoFicto().getExisteFraude());
                            CjCRDaoUtils.addBigDecimal(cs, ++index, new BigDecimal(detalle.getDepoFicto().getMontoDiferencia()));
                            CjCRDaoUtils.addString(cs, ++index, detalle.getDepoFicto().getFolioRecoleccion());
                            CjCRDaoUtils.addBigDecimal(cs, ++index, new BigDecimal(detalle.getDepoFicto().getImporteRecoleccion()));
                            CjCRDaoUtils.addBigDecimal(cs, ++index, new BigDecimal(detalle.getDepoFicto().getSaldoGlobalDesbloqueo()));
                            CjCRDaoUtils.addInt(cs, ++index, detalle.getDepoFicto().getIdStatus());
                            CjCRDaoUtils.addInt(cs, ++index, detalle.getDepoFicto().getIdTipoBloqueo());
                            CjCRDaoUtils.addInt(cs, ++index, detalle.getDepoFicto().getIdTipoArqueo());
                            CjCRDaoUtils.addString(cs, ++index, CjCRConstUtl.USER_ALARMA);

                            indexOutInteger = ++index;
                            cs.registerOutParameter(indexOutInteger, OracleTypes.NUMBER);
                            indexOutString = ++index;
                            cs.registerOutParameter(indexOutString, OracleTypes.VARCHAR);

                            cs.executeQuery();

                            codeStatus = (int) cs.getInt(indexOutInteger);
                            messageStatus = (String) cs.getString(indexOutString);

                            return CjCRRespuesta.getRespuesta(codeStatus, messageStatus);
                        }
                    });
        } catch (DataAccessException dae) {
            LOG.error(dae);
            result = CjCRRespuesta.RESPUESTA_ERROR_ESTANDAR;
        }
        return result;
    }

    public CjCRRespuesta insertDetalle(CjCRSAlrDepoFictoOpcion opc,
            final CjCRSAlrBloqueoDetalleMdl detalle) {

        CjCRRespuesta result;
        String query;

        query = queryDao.getQuery(opc);

        try {
            result = usrcajaJdbcTemplate.execute(query,
                    new CallableStatementCallback<CjCRRespuesta>() {

                        @Override
                        public CjCRRespuesta doInCallableStatement(CallableStatement cs)
                        throws SQLException, DataAccessException {
                            int index;
                            int indexOutInteger;
                            int indexOutString;
                            int codeStatus;
                            String messageStatus;

                            index = 0;

                            CjCRDaoUtils.addInt(cs, ++index, detalle.getBloqDetalle().getIdBloqueo());
                            CjCRDaoUtils.addInt(cs, ++index, detalle.getBloqDetalle().getIdPais());
                            CjCRDaoUtils.addInt(cs, ++index, detalle.getBloqDetalle().getIdCanal());
                            CjCRDaoUtils.addInt(cs, ++index, detalle.getBloqDetalle().getIdSucursal());
                            CjCRDaoUtils.addInt(cs, ++index, detalle.getBloqDetalle().getIdConsecutivo());
                            CjCRDaoUtils.addBigDecimal(cs, ++index, new BigDecimal(detalle.getBloqDetalle().getSaldoPrincipal()));
                            CjCRDaoUtils.addBigDecimal(cs, ++index, new BigDecimal(detalle.getBloqDetalle().getTopePrincipal()));
                            CjCRDaoUtils.addBigDecimal(cs, ++index, new BigDecimal(detalle.getBloqDetalle().getSaldoAnclada()));
                            CjCRDaoUtils.addBigDecimal(cs, ++index, new BigDecimal(detalle.getBloqDetalle().getTopeAnclada()));
                            CjCRDaoUtils.addBigDecimal(cs, ++index, new BigDecimal(detalle.getBloqDetalle().getSaldoReciclador()));
                            CjCRDaoUtils.addBigDecimal(cs, ++index, new BigDecimal(detalle.getBloqDetalle().getTopeReciclador()));
                            CjCRDaoUtils.addBigDecimal(cs, ++index, new BigDecimal(detalle.getBloqDetalle().getSaldoCajeros()));
                            CjCRDaoUtils.addBigDecimal(cs, ++index, new BigDecimal(detalle.getBloqDetalle().getSaldoPared()));
                            CjCRDaoUtils.addInt(cs, ++index, detalle.getBloqDetalle().getIdStatus());
                            CjCRDaoUtils.addString(cs, ++index, CjCRConstUtl.USER_ALARMA);

                            indexOutInteger = ++index;
                            cs.registerOutParameter(indexOutInteger, OracleTypes.NUMBER);
                            indexOutString = ++index;
                            cs.registerOutParameter(indexOutString, OracleTypes.VARCHAR);

                            cs.executeQuery();

                            codeStatus = (int) cs.getInt(indexOutInteger);
                            messageStatus = (String) cs.getString(indexOutString);

                            return CjCRRespuesta.getRespuesta(codeStatus, messageStatus);
                        }
                    });
        } catch (DataAccessException dae) {
            LOG.error(dae);
            result = CjCRRespuesta.RESPUESTA_ERROR_ESTANDAR;
        }
        return result;
    }
}
