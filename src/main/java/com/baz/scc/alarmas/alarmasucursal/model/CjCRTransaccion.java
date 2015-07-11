/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.baz.scc.alarmas.alarmasucursal.model;
 
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * <br><br>Copyright 2014 Banco Azteca. Todos los derechos reservados.
 *
 * @author B941337 Mariana Pineda Villa
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class CjCRTransaccion {

    @XmlElement(required = true)
    private int idPais;

    @XmlElement(required = true)
    private int idCanal;

    @XmlElement(required = true)
    private int idSucursal;

    @XmlElement(required = true)
    private int idEmpleado;
   
    @XmlElement(required = true)
    private String nombreEmpleado;
    
    @XmlElement(required = true)
    private int idPuesto;
    
    @XmlElement(required = true)
    private int idRol;
    
    @XmlElement(required = true)
    private String horaSucursal;

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

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
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

    public String getHoraSucursal() {
        return horaSucursal;
    }

    public void setHoraSucursal(String horaSucursal) {
        this.horaSucursal = horaSucursal;
    }

   
}
