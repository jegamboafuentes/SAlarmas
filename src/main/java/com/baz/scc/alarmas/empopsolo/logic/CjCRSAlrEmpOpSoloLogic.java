
package com.baz.scc.alarmas.empopsolo.logic;

import com.baz.scc.alarmas.base.dao.CjCRSAlrBaseDao;
import com.baz.scc.alarmas.base.logic.CjCRSAlrBaseLogic;
import com.baz.scc.alarmas.empopsolo.dao.CjCRSAlrEmpOpSoloDao;
import com.baz.scc.alarmas.empopsolo.model.CjCRSAlrEmpOpSoloDetMdl;
import com.baz.scc.alarmas.empopsolo.model.CjCRSAlrEmpOpSoloOpcion;
import com.baz.scc.alarmas.support.CjCRRespuesta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 *
 * @author B233388 Froil&aacute; L&oacute;pez Lemus
 */
@Component(CjCRSAlrEmpOpSoloLogic.BEAN_NAME)
public class CjCRSAlrEmpOpSoloLogic 
        extends CjCRSAlrBaseLogic<CjCRSAlrEmpOpSoloOpcion, CjCRSAlrEmpOpSoloDetMdl>{
    public static final String BEAN_NAME = "cjCRSAlrEmpOpSoloLogic";
    
    @Autowired
    @Qualifier(CjCRSAlrEmpOpSoloDao.BEAN_NAME)
    private CjCRSAlrBaseDao empOpSoloDao;

    @Override
    public CjCRRespuesta execOpcion(CjCRSAlrEmpOpSoloOpcion opc, CjCRSAlrEmpOpSoloDetMdl detalle) {
        return empOpSoloDao.execOpcion(opc, detalle);
    }
}
