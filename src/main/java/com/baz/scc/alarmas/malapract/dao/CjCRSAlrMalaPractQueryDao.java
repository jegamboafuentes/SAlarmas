
package com.baz.scc.alarmas.malapract.dao;

import com.baz.scc.alarmas.base.dao.CjCRSAlrBaseQueryDao;
import com.baz.scc.alarmas.malapract.model.CjCRSAlrMalaPractOpcion;
import org.springframework.stereotype.Component;

/**
 *
 * @author B233388 Froil&aacute; L&oacute;pez Lemus
 */
@Component(CjCRSAlrMalaPractQueryDao.BEAN_NAME)
public class CjCRSAlrMalaPractQueryDao 
        extends CjCRSAlrBaseQueryDao<CjCRSAlrMalaPractOpcion> {
    public static final String BEAN_NAME = "cjCRSAlrMalaPractQueryDao";
    
    @Override
    public String getQuery(CjCRSAlrMalaPractOpcion opc) {
        String result;
        
        switch(opc) {
            case  INSERT_REGISTRO:
                result =  getQueryInsertReg();
                break;
            default:
                result = "";
                break;
        }
        return result;
    }
    
    private String getQueryInsertReg() {
        return usuarioCaja.getSentence("{call %s.PQCJALR0001.PACJALRLI0003(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
    }
}
