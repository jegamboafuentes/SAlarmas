
package com.baz.scc.alarmas.base.dao;

import com.baz.scc.alarmas.support.CjCRRespuesta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author B233388 Froil&aacute; L&oacute;pez Lemus
 */
public abstract class CjCRSAlrBaseDao<D,F> {
    
    @Autowired
    @Qualifier("usrcajaJdbcTemplate")
    protected JdbcTemplate usrcajaJdbcTemplate;
    
    public abstract CjCRRespuesta execOpcion(D opc, F detalle);
}
