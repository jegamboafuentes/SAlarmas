
package com.baz.scc.alarmas.base.dao;

import com.baz.scc.commons.support.CjCRDaoConfig;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author B233388 Froil&aacute; L&oacute;pez Lemus
 */
public abstract class CjCRSAlrBaseQueryDao<D> {
    
    @Autowired
    protected CjCRDaoConfig usuarioCaja;
    
    public abstract String getQuery(D opc);
}
