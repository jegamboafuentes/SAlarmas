package com.baz.scc.alarmas.depficto.logic;

import com.baz.scc.alarmas.base.dao.CjCRSAlrBaseDao;
import com.baz.scc.alarmas.base.logic.CjCRSAlrBaseLogic;
import com.baz.scc.alarmas.depficto.model.CjCRSAlrBloqueoDetalleMdl;
import com.baz.scc.alarmas.depficto.model.CjCRSAlrDepoFictoOpcion;
import com.baz.scc.alarmas.depficto.dao.CjCRSAlrDepoFictoDao;
import com.baz.scc.alarmas.support.CjCRRespuesta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * <br><br>Copyright 2014 Banco Azteca. Todos los derechos reservados.
 *
 * Capa de acceso a datos para de´&oacute;sitos fictos.
 *
 * @author B229463 Carlos Ever Isai V.E.
 */
@Component(CjCRSAlrDepoFictoLogic.BEAN_NAME)
public class CjCRSAlrDepoFictoLogic
        extends CjCRSAlrBaseLogic<CjCRSAlrDepoFictoOpcion, CjCRSAlrBloqueoDetalleMdl> {

    public static final String BEAN_NAME = "cjCRDepoFictoLogic";

    @Autowired
    @Qualifier(CjCRSAlrDepoFictoDao.BEAN_NAME)
    private CjCRSAlrBaseDao depoFictoDao;

    @Override
    public CjCRRespuesta execOpcion(CjCRSAlrDepoFictoOpcion opc, CjCRSAlrBloqueoDetalleMdl detalle) {
        CjCRRespuesta bloqueo;
        CjCRRespuesta bloqDetalle;

        bloqueo = depoFictoDao.execOpcion(CjCRSAlrDepoFictoOpcion.INSERT_BLOQUEO, detalle);

        if (bloqueo.getStatus() == 0) {

            bloqDetalle = depoFictoDao.execOpcion(CjCRSAlrDepoFictoOpcion.INSERT_DETALLE, detalle);

            return bloqDetalle;

        } else {
            return bloqueo;
        }
    }
}
