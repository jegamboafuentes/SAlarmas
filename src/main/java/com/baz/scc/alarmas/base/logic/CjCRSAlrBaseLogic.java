
package com.baz.scc.alarmas.base.logic;

import com.baz.scc.alarmas.support.CjCRAppConfig;
import com.baz.scc.alarmas.support.CjCRRespuesta;
import com.baz.scc.commons.support.CjCRMailDispatcher;
import com.baz.scc.configuracion.logic.CjCRConfiguracionLogic;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author B233388 Froil&aacute; L&oacute;pez Lemus
 */
public abstract class CjCRSAlrBaseLogic<D,F> {
    
    @Autowired
    protected CjCRConfiguracionLogic configuracion;
    
    @Autowired
    protected CjCRAppConfig appConfig;
    
    @Autowired
    protected CjCRMailDispatcher mail;
    
    public abstract CjCRRespuesta execOpcion(D opc, F detalle);
}
