

package com.baz.scc.alarmas.support;

/**
 *
 * @author B941337
 * @since 20/11/14 B229463
 */

public class CjCRAppConfig {
    private String asuntoUnEmpleado;
    private String asuntoMalasPract;
    private boolean produccion;

    public String getAsuntoUnEmpleado() {
        return asuntoUnEmpleado;
    }

    public void setAsuntoUnEmpleado(String asuntoUnEmpleado) {
        this.asuntoUnEmpleado = asuntoUnEmpleado;
    }

    public String getAsuntoMalasPract() {
        return asuntoMalasPract;
    }

    public void setAsuntoMalasPract(String asuntoMalasPract) {
        this.asuntoMalasPract = asuntoMalasPract;
    }

    public boolean isProduccion() {
        return produccion;
    }

    public void setProduccion(boolean produccion) {
        this.produccion = produccion;
    }    
}
