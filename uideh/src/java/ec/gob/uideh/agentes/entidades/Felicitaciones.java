/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.uideh.agentes.entidades;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Pablo
 */
@Entity
@Table(name = "felicitaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Felicitaciones.findAll", query = "SELECT f FROM Felicitaciones f"),
    @NamedQuery(name = "Felicitaciones.findByIdFelicitacion", query = "SELECT f FROM Felicitaciones f WHERE f.idFelicitacion = :idFelicitacion"),
    @NamedQuery(name = "Felicitaciones.findByDocFelicitacion", query = "SELECT f FROM Felicitaciones f WHERE f.docFelicitacion = :docFelicitacion"),
    @NamedQuery(name = "Felicitaciones.findByFechaFelicitacion", query = "SELECT f FROM Felicitaciones f WHERE f.fechaFelicitacion = :fechaFelicitacion"),
    @NamedQuery(name = "Felicitaciones.findByDetalleFelic", query = "SELECT f FROM Felicitaciones f WHERE f.detalleFelic = :detalleFelic")})
public class Felicitaciones implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idFelicitacion")
    private Long idFelicitacion;
    @Basic(optional = false)
    @Size(max = 20)
    @Column(name = "doc_felicitacion")
    private String docFelicitacion;
    @Basic(optional = false)
    @Column(name = "fecha_felicitacion")
    @Temporal(TemporalType.DATE)
    private Date fechaFelicitacion;
    @Size(max = 255)
    @Column(name = "detalle_felic")
    private String detalleFelic;
    @JoinColumn(name = "idAgente", referencedColumnName = "idAgente")
    @ManyToOne(optional = false)
    private Agente idAgente;

    public Felicitaciones() {
    }

    public Felicitaciones(Long idFelicitacion) {
        this.idFelicitacion = idFelicitacion;
    }

    public Felicitaciones(Long idFelicitacion, String docFelicitacion, Date fechaFelicitacion) {
        this.idFelicitacion = idFelicitacion;
        this.docFelicitacion = docFelicitacion;
        this.fechaFelicitacion = fechaFelicitacion;
    }

    public Long getIdFelicitacion() {
        return idFelicitacion;
    }

    public void setIdFelicitacion(Long idFelicitacion) {
        this.idFelicitacion = idFelicitacion;
    }

    public String getDocFelicitacion() {
        return docFelicitacion;
    }

    public void setDocFelicitacion(String docFelicitacion) {
        this.docFelicitacion = docFelicitacion;
    }

    public Date getFechaFelicitacion() {
        return fechaFelicitacion;
    }

    public void setFechaFelicitacion(Date fechaFelicitacion) {
        this.fechaFelicitacion = fechaFelicitacion;
    }

    public String getDetalleFelic() {
        return detalleFelic;
    }

    public void setDetalleFelic(String detalleFelic) {
        this.detalleFelic = detalleFelic;
    }

    public Agente getIdAgente() {
        return idAgente;
    }

    public void setIdAgente(Agente idAgente) {
        this.idAgente = idAgente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFelicitacion != null ? idFelicitacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Felicitaciones)) {
            return false;
        }
        Felicitaciones other = (Felicitaciones) object;
        if ((this.idFelicitacion == null && other.idFelicitacion != null) || (this.idFelicitacion != null && !this.idFelicitacion.equals(other.idFelicitacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.gob.uideh.entidades.Felicitaciones[ idFelicitacion=" + idFelicitacion + " ]";
    }
    
}
