
package com.baz.scc.alarmas.empopsolo.dao;

import com.baz.scc.alarmas.base.dao.CjCRSAlrBaseQueryDao;
import com.baz.scc.alarmas.empopsolo.model.CjCRSAlrEmpOpSoloOpcion;
import org.springframework.stereotype.Component;

/**
 *
 * @author B233388 Froil&aacute; L&oacute;pez Lemus
 */
@Component(CjCRSAlrEmpOpSoloQueryDao.BEAN_NAME)
public class CjCRSAlrEmpOpSoloQueryDao extends CjCRSAlrBaseQueryDao<CjCRSAlrEmpOpSoloOpcion>{
    public static final String BEAN_NAME = "cjCRSAlrEmpOpSoloQueryDao";
    
    @Override
    public String getQuery(CjCRSAlrEmpOpSoloOpcion opc) {
        String result;
        
        switch(opc) {
            case INSERT_EVENTO:
                result =  getQryInsertEvento();
                break;
            default:
                result = "";
                break;
        }
        return result;
    }
    
    
    private String getQryInsertEvento() {
        return usuarioCaja.getSentence("{call %s.PQCJALR0002.PACJALRLI0001(?,?,?,?,?,?,?,?,?,?,?,?)}");
    }
    
}
