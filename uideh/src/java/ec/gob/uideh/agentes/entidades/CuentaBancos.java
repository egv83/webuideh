/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.uideh.agentes.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Pablo
 */
@Entity
@Table(name = "cuenta_bancos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CuentaBancos.findAll", query = "SELECT c FROM CuentaBancos c"),
    @NamedQuery(name = "CuentaBancos.findByIdBanco", query = "SELECT c FROM CuentaBancos c WHERE c.idBanco = :idBanco"),
    @NamedQuery(name = "CuentaBancos.findByNroCuenta", query = "SELECT c FROM CuentaBancos c WHERE c.nroCuenta = :nroCuenta")})
public class CuentaBancos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_banco")
    private Long idBanco;
    @Basic(optional = false)
    @Column(name = "nro_cuenta")
    private Long nroCuenta;
    @JoinColumn(name = "id_agente", referencedColumnName = "idAgente")
    @ManyToOne
    private Agente idAgente;
    @JoinColumn(name = "id_nombrebanco", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Parametros idNombrebanco;
    @JoinColumn(name = "id_tipocuenta", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Parametros idTipocuenta;

    public CuentaBancos() {
    }

    public CuentaBancos(Long idBanco) {
        this.idBanco = idBanco;
    }

    public CuentaBancos(Long idBanco, Long nroCuenta) {
        this.idBanco = idBanco;
        this.nroCuenta = nroCuenta;
    }

    public Long getIdBanco() {
        return idBanco;
    }

    public void setIdBanco(Long idBanco) {
        this.idBanco = idBanco;
    }

    public Long getNroCuenta() {
        return nroCuenta;
    }

    public void setNroCuenta(Long nroCuenta) {
        this.nroCuenta = nroCuenta;
    }

    public Agente getIdAgente() {
        return idAgente;
    }

    public void setIdAgente(Agente idAgente) {
        this.idAgente = idAgente;
    }

    public Parametros getIdNombrebanco() {
        return idNombrebanco;
    }

    public void setIdNombrebanco(Parametros idNombrebanco) {
        this.idNombrebanco = idNombrebanco;
    }

    public Parametros getIdTipocuenta() {
        return idTipocuenta;
    }

    public void setIdTipocuenta(Parametros idTipocuenta) {
        this.idTipocuenta = idTipocuenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBanco != null ? idBanco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CuentaBancos)) {
            return false;
        }
        CuentaBancos other = (CuentaBancos) object;
        if ((this.idBanco == null && other.idBanco != null) || (this.idBanco != null && !this.idBanco.equals(other.idBanco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.gob.uideh.entidades.CuentaBancos[ idBanco=" + idBanco + " ]";
    }
    
}
