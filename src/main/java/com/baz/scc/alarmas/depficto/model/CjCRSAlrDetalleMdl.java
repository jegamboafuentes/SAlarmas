
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
public class CjCRSAlrDetalleMdl {
    
    @XmlElement(required = true)
    private int idBloqueo;
    
    @XmlElement(required = true)
    private int idPais;
    
    @XmlElement(required = true)
    private int idCanal;
    
    @XmlElement(required = true)
    private int idSucursal;
    
    @XmlElement(required = true)
    private int idConsecutivo;
    
    @XmlElement(required = true)
    private double saldoPrincipal;
    
    @XmlElement(required = true)
    private double topePrincipal;
    
    @XmlElement(required = true)
    private double saldoAnclada;
    
    @XmlElement(required = true)
    private double topeAnclada;
    
    @XmlElement(required = true)
    private double saldoReciclador;
    
    @XmlElement(required = true)
    private double topeReciclador;
    
    @XmlElement(required = true)
    private double saldoCajeros;
    
    @XmlElement(required = true)
    private double saldoPared;
    
    @XmlElement(required = true)
    private int idStatus;
    
    
    /*Sustituye constructor default*/
    public CjCRSAlrDetalleMdl() {
    }
                                
    /*Getters ans Setters*/
    public int getIdBloqueo() {
        return idBloqueo;
    }

    public void setIdBloqueo(int idBloqueo) {
        this.idBloqueo = idBloqueo;
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

    public int getIdConsecutivo() {
        return idConsecutivo;
    }

    public void setIdConsecutivo(int idConsecutivo) {
        this.idConsecutivo = idConsecutivo;
    }

    public double getSaldoPrincipal() {
        return saldoPrincipal;
    }

    public void setSaldoPrincipal(double saldoPrincipal) {
        this.saldoPrincipal = saldoPrincipal;
    }

    public double getTopePrincipal() {
        return topePrincipal;
    }

    public void setTopePrincipal(double topePrincipal) {
        this.topePrincipal = topePrincipal;
    }

    public double getSaldoAnclada() {
        return saldoAnclada;
    }

    public void setSaldoAnclada(double saldoAnclada) {
        this.saldoAnclada = saldoAnclada;
    }

    public double getTopeAnclada() {
        return topeAnclada;
    }

    public void setTopeAnclada(double topeAnclada) {
        this.topeAnclada = topeAnclada;
    }

    public double getSaldoReciclador() {
        return saldoReciclador;
    }

    public void setSaldoReciclador(double saldoReciclador) {
        this.saldoReciclador = saldoReciclador;
    }

    public double getTopeReciclador() {
        return topeReciclador;
    }

    public void setTopeReciclador(double topeReciclador) {
        this.topeReciclador = topeReciclador;
    }

    public double getSaldoCajeros() {
        return saldoCajeros;
    }

    public void setSaldoCajeros(double saldoCajeros) {
        this.saldoCajeros = saldoCajeros;
    }

    public double getSaldoPared() {
        return saldoPared;
    }

    public void setSaldoPared(double saldoPared) {
        this.saldoPared = saldoPared;
    }

    public int getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(int idStatus) {
        this.idStatus = idStatus;
    }
    
    
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("CjCRBloqueoDetalle[");
        str.append("\nidBloqueo: ");
        str.append(idBloqueo);                        
        str.append(", \nidPais: ");
        str.append(idPais);
        str.append(", \nidCanal: ");
        str.append(idCanal);
        str.append(", \nidSucursal: ");
        str.append(idSucursal);                        
        str.append(", \nidConsecutivo: ");
        str.append(idConsecutivo);                        
        str.append(", \nsaldoPrincipal: ");
        str.append(saldoPrincipal);        
        str.append(", \ntopePrincipal: ");
        str.append(topePrincipal);        
        str.append(", \nsaldoAnclada: ");
        str.append(saldoAnclada);               
        str.append(", \ntopeAnclada: ");
        str.append(topeAnclada);                
        str.append(", \nsaldoReciclador: ");
        str.append(saldoReciclador);
        str.append(", \ntopeReciclador: ");
        str.append(topeReciclador);
        str.append(", \nsaldoCajeros: ");
        str.append(saldoCajeros);                
        str.append(", \nsaldoPared: ");
        str.append(saldoPared);
        str.append(", \nidStatus: ");
        str.append(idStatus);
        str.append("\n]");        
        return str.toString();
    }
}
