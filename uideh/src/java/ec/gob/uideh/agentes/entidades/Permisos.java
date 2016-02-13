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
@Table(name = "permisos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Permisos.findAll", query = "SELECT p FROM Permisos p"),
    @NamedQuery(name = "Permisos.findByIdPermiso", query = "SELECT p FROM Permisos p WHERE p.idPermiso = :idPermiso"),
    @NamedQuery(name = "Permisos.findByDocumentoPermiso", query = "SELECT p FROM Permisos p WHERE p.documentoPermiso = :documentoPermiso"),
    @NamedQuery(name = "Permisos.findByFechaPermiso", query = "SELECT p FROM Permisos p WHERE p.fechaPermiso = :fechaPermiso"),
    @NamedQuery(name = "Permisos.findByDiasPermiso", query = "SELECT p FROM Permisos p WHERE p.diasPermiso = :diasPermiso"),
    @NamedQuery(name = "Permisos.findByDetallePermiso", query = "SELECT p FROM Permisos p WHERE p.detallePermiso = :detallePermiso")})
public class Permisos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_permiso")
    private Long idPermiso;
    @Size(max = 50)
    @Column(name = "documento_permiso")
    private String documentoPermiso;
    @Basic(optional = false)
    @Column(name = "fecha_permiso")
    @Temporal(TemporalType.DATE)
    private Date fechaPermiso;
    @Basic(optional = false)
    @Column(name = "dias_permiso")
    private Long diasPermiso;
    @Size(max = 500)
    @Column(name = "detalle_permiso")
    private String detallePermiso;
    @JoinColumn(name = "id_agente", referencedColumnName = "idAgente")
    @ManyToOne
    private Agente idAgente;
    @JoinColumn(name = "id_tipo_permiso", referencedColumnName = "id")
    @ManyToOne
    private Parametros idTipoPermiso;

    public Permisos() {
        this.idTipoPermiso = new Parametros();
    }

    public Permisos(Long idPermiso) {
        this.idPermiso = idPermiso;
    }

    public Permisos(Long idPermiso, Date fechaPermiso, Long diasPermiso) {
        this.idPermiso = idPermiso;
        this.fechaPermiso = fechaPermiso;
        this.diasPermiso = diasPermiso;
    }

    public Long getIdPermiso() {
        return idPermiso;
    }

    public void setIdPermiso(Long idPermiso) {
        this.idPermiso = idPermiso;
    }

    public String getDocumentoPermiso() {
        return documentoPermiso;
    }

    public void setDocumentoPermiso(String documentoPermiso) {
        this.documentoPermiso = documentoPermiso;
    }

    public Date getFechaPermiso() {
        return fechaPermiso;
    }

    public void setFechaPermiso(Date fechaPermiso) {
        this.fechaPermiso = fechaPermiso;
    }

    public Long getDiasPermiso() {
        return diasPermiso;
    }

    public void setDiasPermiso(Long diasPermiso) {
        this.diasPermiso = diasPermiso;
    }

    public String getDetallePermiso() {
        return detallePermiso;
    }

    public void setDetallePermiso(String detallePermiso) {
        this.detallePermiso = detallePermiso;
    }

    public Agente getIdAgente() {
        return idAgente;
    }

    public void setIdAgente(Agente idAgente) {
        this.idAgente = idAgente;
    }

    public Parametros getIdTipoPermiso() {
        return idTipoPermiso;
    }

    public void setIdTipoPermiso(Parametros idTipoPermiso) {
        this.idTipoPermiso = idTipoPermiso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPermiso != null ? idPermiso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Permisos)) {
            return false;
        }
        Permisos other = (Permisos) object;
        if ((this.idPermiso == null && other.idPermiso != null) || (this.idPermiso != null && !this.idPermiso.equals(other.idPermiso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.gob.uideh.entidades.Permisos[ idPermiso=" + idPermiso + " ]";
    }
    
}
