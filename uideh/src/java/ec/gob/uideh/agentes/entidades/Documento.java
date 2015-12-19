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
@Table(name = "documento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Documento.findAll", query = "SELECT d FROM Documento d"),
    @NamedQuery(name = "Documento.findByIdDoc", query = "SELECT d FROM Documento d WHERE d.idDoc = :idDoc"),
    @NamedQuery(name = "Documento.findByIdTipoDoc", query = "SELECT d FROM Documento d WHERE d.idTipoDoc = :idTipoDoc"),
    @NamedQuery(name = "Documento.findByIdAgente", query = "SELECT d FROM Documento d WHERE d.idAgente = :idAgente"),
    @NamedQuery(name = "Documento.findByParIdParam", query = "SELECT d FROM Documento d WHERE d.parIdParam = :parIdParam"),
    @NamedQuery(name = "Documento.findByFechaDoc", query = "SELECT d FROM Documento d WHERE d.fechaDoc = :fechaDoc"),
    @NamedQuery(name = "Documento.findByDetalleDoc", query = "SELECT d FROM Documento d WHERE d.detalleDoc = :detalleDoc")})
public class Documento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_doc")
    private Integer idDoc;
    @Column(name = "id_tipo_doc")
    private Integer idTipoDoc;
    @Column(name = "id_agente")
    private Integer idAgente;
    @Column(name = "PAR_ID_PARAM")
    private Integer parIdParam;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_doc")
    @Temporal(TemporalType.DATE)
    private Date fechaDoc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "detalle_doc")
    private String detalleDoc;

    public Documento() {
    }

    public Documento(Integer idDoc) {
        this.idDoc = idDoc;
    }

    public Documento(Integer idDoc, Date fechaDoc, String detalleDoc) {
        this.idDoc = idDoc;
        this.fechaDoc = fechaDoc;
        this.detalleDoc = detalleDoc;
    }

    public Integer getIdDoc() {
        return idDoc;
    }

    public void setIdDoc(Integer idDoc) {
        this.idDoc = idDoc;
    }

    public Integer getIdTipoDoc() {
        return idTipoDoc;
    }

    public void setIdTipoDoc(Integer idTipoDoc) {
        this.idTipoDoc = idTipoDoc;
    }

    public Integer getIdAgente() {
        return idAgente;
    }

    public void setIdAgente(Integer idAgente) {
        this.idAgente = idAgente;
    }

    public Integer getParIdParam() {
        return parIdParam;
    }

    public void setParIdParam(Integer parIdParam) {
        this.parIdParam = parIdParam;
    }

    public Date getFechaDoc() {
        return fechaDoc;
    }

    public void setFechaDoc(Date fechaDoc) {
        this.fechaDoc = fechaDoc;
    }

    public String getDetalleDoc() {
        return detalleDoc;
    }

    public void setDetalleDoc(String detalleDoc) {
        this.detalleDoc = detalleDoc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDoc != null ? idDoc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Documento)) {
            return false;
        }
        Documento other = (Documento) object;
        if ((this.idDoc == null && other.idDoc != null) || (this.idDoc != null && !this.idDoc.equals(other.idDoc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.gob.uideh.entidades.Documento[ idDoc=" + idDoc + " ]";
    }
    
}
