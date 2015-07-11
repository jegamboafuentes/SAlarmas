
package com.baz.scc.alarmas.malapract.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author B233388 Froil&aacute; L&oacute;pez Lemus
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class CjCRMalasPracticasMdl {
    
    @XmlElement(required = true)
    private int idPais;
    
    @XmlElement(required = true)
    private int idCanal;
    
    @XmlElement(required = true)
    private int idSucursal;
    
    @XmlElement(required = true)
    private String idEmpleado;
    
    @XmlElement(required = true)
    private int idRol;
    
    @XmlElement(required = true)
    private int idPuesto;
    
    @XmlElement(required = true)
    private String fechaEvento;
    
    @XmlElement(required = true)
    private int idTipoReporte;
    
    @XmlElement(required = true)
    private String detallePersonal;
    
    @XmlElement(required = true)
    private String detalleEvento;
    
    @XmlElement(required = false)
    private String detalleExtra;
    

    public CjCRMalasPracticasMdl() {
    
    }

    public int getIdPais() {
        return idPais;
    }

    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }

    public int getIdCanal() {
        return idCanal;
    }

    public void setIdCanal(int idCanal) {
        this.idCanal = idCanal;
    }

    public int getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public int getIdPuesto() {
        return idPuesto;
    }

    public void setIdPuesto(int idPuesto) {
        this.idPuesto = idPuesto;
    }

    public String getFechaEvento() {
        return fechaEvento;
    }

    public void setFechaEvento(String fechaEvento) {
        this.fechaEvento = fechaEvento;
    }

    public int getIdTipoReporte() {
        return idTipoReporte;
    }

    public void setIdTipoReporte(int idTipoReporte) {
        this.idTipoReporte = idTipoReporte;
    }

    public String getDetallePersonal() {
        return detallePersonal;
    }

    public void setDetallePersonal(String detallePersonal) {
        this.detallePersonal = detallePersonal;
    }

    public String getDetalleEvento() {
        return detalleEvento;
    }

    public void setDetalleEvento(String detalleEvento) {
        this.detalleEvento = detalleEvento;
    }

    public String getDetalleExtra() {
        return detalleExtra;
    }

    public void setDetalleExtra(String detalleExtra) {
        this.detalleExtra = detalleExtra;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        
        str.append("CjCRMalasPracticasMdl[");
        str.append("idPais=");
        str.append(idPais);
        str.append(", idCanal=");
        str.append(idCanal);
        str.append(", idSucursal=");
        str.append(idSucursal);
        str.append(", idEmpleado=");
        str.append(idEmpleado);
        str.append(", idRol=");
        str.append(idRol);
        str.append(", idPuesto=");
        str.append(idPuesto);
        str.append(", fechaEvento=");
        str.append(fechaEvento);
        str.append(", idTipoReporte=");
        str.append(idTipoReporte);
        str.append(", detallePersonal=");
        str.append(detallePersonal);
        str.append(", detalleEvento=");
        str.append(detalleEvento);
        str.append(", detalleExtra=");
        str.append(detalleExtra);
        str.append("]");
        
        return str.toString();
    }
    
}
