
package com.baz.scc.alarmas.depficto.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author B233388
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class CjCRSAlrBloqeoMdl {
    
    @XmlElement(required = true)
    private int idPais;
    
    @XmlElement(required = true)
    private int idCanal;
    
    @XmlElement(required = true)
    private int idSucursal;
    
    @XmlElement(required = true)
    private int idBloqueo;
    
    @XmlElement(required = true)
    private int idTipoBloqueo;
    
    @XmlElement(required = true)
    private String fechaBloqueo;
    
    @XmlElement(required = true)
    private int idDivisa;
    
    @XmlElement(required = true)
    private double montoBloqueo;
    
    @XmlElement(required = true)
    private int idArqueo;
    
    @XmlElement(required = true)
    private int idTipoArqueo;
    
    @XmlElement(required = true)
    private String fechaDesbloqueo;
    
    @XmlElement(required = true)
    private int existeFraude;
    
    @XmlElement(required = true)
    private double montoDiferencia;
    
    @XmlElement(required = true)
    private String folioRecoleccion;
    
    @XmlElement(required = true)
    private double importeRecoleccion;
    
    @XmlElement(required = true)
    private double saldoGlobalDesbloqueo;
    
    @XmlElement(required = true)
    private int idStatus;
    
    
    public CjCRSAlrBloqeoMdl() { }

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

    public int getIdBloqueo() {
        return idBloqueo;
    }

    public void setIdBloqueo(int idBloqueo) {
        this.idBloqueo = idBloqueo;
    }

    public int getIdTipoBloqueo() {
        return idTipoBloqueo;
    }

    public void setIdTipoBloqueo(int idTipoBloqueo) {
        this.idTipoBloqueo = idTipoBloqueo;
    }

    public String getFechaBloqueo() {
        return fechaBloqueo;
    }

    public void setFechaBloqueo(String fechaBloqueo) {
        this.fechaBloqueo = fechaBloqueo;
    }

    public int getIdDivisa() {
        return idDivisa;
    }

    public void setIdDivisa(int idDivisa) {
        this.idDivisa = idDivisa;
    }

    public double getMontoBloqueo() {
        return montoBloqueo;
    }

    public void setMontoBloqueo(double montoBloqueo) {
        this.montoBloqueo = montoBloqueo;
    }

    public int getIdArqueo() {
        return idArqueo;
    }

    public void setIdArqueo(int idArqueo) {
        this.idArqueo = idArqueo;
    }

    public int getIdTipoArqueo() {
        return idTipoArqueo;
    }

    public void setIdTipoArqueo(int idTipoArqueo) {
        this.idTipoArqueo = idTipoArqueo;
    }

    public String getFechaDesbloqueo() {
        return fechaDesbloqueo;
    }

    public void setFechaDesbloqueo(String fechaDesbloqueo) {
        this.fechaDesbloqueo = fechaDesbloqueo;
    }

    public int getExisteFraude() {
        return existeFraude;
    }

    public void setExisteFraude(int existeFraude) {
        this.existeFraude = existeFraude;
    }

    public double getMontoDiferencia() {
        return montoDiferencia;
    }

    public void setMontoDiferencia(double montoDiferencia) {
        this.montoDiferencia = montoDiferencia;
    }

    public String getFolioRecoleccion() {
        return folioRecoleccion;
    }

    public void setFolioRecoleccion(String folioRecoleccion) {
        this.folioRecoleccion = folioRecoleccion;
    }

    public double getImporteRecoleccion() {
        return importeRecoleccion;
    }

    public void setImporteRecoleccion(double importeRecoleccion) {
        this.importeRecoleccion = importeRecoleccion;
    }

    public double getSaldoGlobalDesbloqueo() {
        return saldoGlobalDesbloqueo;
    }

    public void setSaldoGlobalDesbloqueo(double saldoGlobalDesbloqueo) {
        this.saldoGlobalDesbloqueo = saldoGlobalDesbloqueo;
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
        str.append("CjCRDepositoFictoMdl[");
        str.append("idPais=");
        str.append(idPais);
        str.append(", idCanal=");
        str.append(idCanal);
        str.append(", idSucursal=");
        str.append(idSucursal);
        str.append(", idBloqueo=");
        str.append(idBloqueo);
        str.append(", idTipoBloqueo=");
        str.append(idTipoBloqueo);
        str.append(", fechaBloqueo=");
        str.append(fechaBloqueo);
        str.append(", idDivisa=");
        str.append(idDivisa);
        str.append(", montoBloqueo=");
        str.append(montoBloqueo);
        str.append(", idArqueo=");
        str.append(idArqueo);
        str.append(", idTipoArqueo=");
        str.append(idTipoArqueo);
        str.append(", fechaDesbloqueo=");
        str.append(fechaDesbloqueo);
        str.append(", existeFraude=");
        str.append(existeFraude);
        str.append(", montoDiferencia=");
        str.append(montoDiferencia);
        str.append(", folioRecoleccion=");
        str.append(folioRecoleccion);
        str.append(", importeRecoleccion=");
        str.append(importeRecoleccion);
        str.append(", saldoGlobalDesbloqueo=");
        str.append(saldoGlobalDesbloqueo);
        str.append(", idStatus=");
        str.append(idStatus);
        str.append("]");
        
        return str.toString();
    }
    
}
