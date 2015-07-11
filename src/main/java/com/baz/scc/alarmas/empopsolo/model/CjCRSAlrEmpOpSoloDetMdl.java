
package com.baz.scc.alarmas.empopsolo.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author B233388 Froil&aacute; L&oacute;pez Lemus
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class CjCRSAlrEmpOpSoloDetMdl {
    
    @XmlElement(required = true)
    private int idPais;
    
    @XmlElement(required = true)
    private int idCanal;
    
    @XmlElement(required = true)
    private int idSucursal;
    
    @XmlElement(required = true)
    private String fecha;
    
    @XmlElement(required = true)
    private String idEmpleado;
    
    @XmlElement(required = true)
    private String empleado;
    
    @XmlElement(required = true)
    private int idPuesto;
    
    @XmlElement(required = true)
    private int idRol;
    
    @XmlElement(required = true)
    private int statusBloq;

    
    
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }

    public int getIdPuesto() {
        return idPuesto;
    }

    public void setIdPuesto(int idPuesto) {
        this.idPuesto = idPuesto;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public int getStatusBloq() {
        return statusBloq;
    }

    public void setStatusBloq(int statusBloq) {
        this.statusBloq = statusBloq;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        
        str.append("CjCRSAlrEmpOpSoloDetMdl[");
        str.append("idPais=");
        str.append(idPais);
        str.append(", idCanal=");
        str.append(idCanal);
        str.append(", idSucursal=");
        str.append(idSucursal);
        str.append(", fecha=");
        str.append(fecha);
        str.append(", idEmpleado=");
        str.append(idEmpleado);
        str.append(", empleado=");
        str.append(empleado);
        str.append(", idPuesto=");
        str.append(idPuesto);
        str.append(", idRol=");
        str.append(idRol);
        str.append(", statusBloq=");
        str.append(statusBloq);
        str.append("]");
        
        return str.toString();
    }
    
}
