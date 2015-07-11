
package com.baz.scc.alarmas.depficto.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author B229463  Carlos Ever Velazquez E.
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class CjCRSAlrBloqueoDetalleMdl {

    @XmlElement(required = true)
    private CjCRSAlrBloqeoMdl depoFicto;
    
    @XmlElement(required = true)
    private CjCRSAlrDetalleMdl bloqDetalle;
    
    

    public CjCRSAlrBloqeoMdl getDepoFicto() {
        return depoFicto;
    }

    public void setDepoFicto(CjCRSAlrBloqeoMdl depoFicto) {
        this.depoFicto = depoFicto;
    }

    public CjCRSAlrDetalleMdl getBloqDetalle() {
        return bloqDetalle;
    }

    public void setBloqDetalle(CjCRSAlrDetalleMdl bloqDetalle) {
        this.bloqDetalle = bloqDetalle;
    }
}