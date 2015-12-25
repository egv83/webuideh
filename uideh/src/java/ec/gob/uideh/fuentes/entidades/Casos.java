/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.uideh.fuentes.entidades;

import ec.gob.uideh.agentes.entidades.Parametros;
import ec.gob.uideh.vehiculos.entidades.Fuentes;
import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Pablo
 */
@Entity
@Table(name = "casos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Casos.findAll", query = "SELECT c FROM Casos c"),
    @NamedQuery(name = "Casos.findById", query = "SELECT c FROM Casos c WHERE c.id = :id"),
    @NamedQuery(name = "Casos.findByCaso", query = "SELECT c FROM Casos c WHERE c.caso = :caso"),
    @NamedQuery(name = "Casos.findByPago", query = "SELECT c FROM Casos c WHERE c.pago = :pago"),
    @NamedQuery(name = "Casos.findByFechaPago", query = "SELECT c FROM Casos c WHERE c.fechaPago = :fechaPago"),
    @NamedQuery(name = "Casos.findByNovedad", query = "SELECT c FROM Casos c WHERE c.novedad = :novedad")})
public class Casos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 100)
    @Column(name = "caso")
    private String caso;
    @Column(name = "pago")
    private Integer pago;
    @Column(name = "fecha_pago")
    @Temporal(TemporalType.DATE)
    private Date fechaPago;
    @Size(max = 255)
    @Column(name = "novedad")
    private String novedad;
    @JoinColumn(name = "ubicacion_id", referencedColumnName = "id")
    @ManyToOne
    private Parametros ubicacionId;
    @JoinColumn(name = "fuente_id", referencedColumnName = "id")
    @ManyToOne
    private Fuentes fuenteId;

    public Casos() {
    }

    public Casos(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCaso() {
        return caso;
    }

    public void setCaso(String caso) {
        this.caso = caso;
    }

    public Integer getPago() {
        return pago;
    }

    public void setPago(Integer pago) {
        this.pago = pago;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public String getNovedad() {
        return novedad;
    }

    public void setNovedad(String novedad) {
        this.novedad = novedad;
    }

    public Parametros getUbicacionId() {
        return ubicacionId;
    }

    public void setUbicacionId(Parametros ubicacionId) {
        this.ubicacionId = ubicacionId;
    }

    public Fuentes getFuenteId() {
        return fuenteId;
    }

    public void setFuenteId(Fuentes fuenteId) {
        this.fuenteId = fuenteId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Casos)) {
            return false;
        }
        Casos other = (Casos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.gob.uideh.fuentes.entidades.Casos[ id=" + id + " ]";
    }
    
}
