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
@Table(name = "comunicados")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comunicados.findAll", query = "SELECT c FROM Comunicados c"),
    @NamedQuery(name = "Comunicados.findByIdComunicado", query = "SELECT c FROM Comunicados c WHERE c.idComunicado = :idComunicado"),
    @NamedQuery(name = "Comunicados.findByFechaDoc", query = "SELECT c FROM Comunicados c WHERE c.fechaDoc = :fechaDoc"),
    @NamedQuery(name = "Comunicados.findByDetalleComun", query = "SELECT c FROM Comunicados c WHERE c.detalleComun = :detalleComun")})
public class Comunicados implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_comunicado")
    private Long idComunicado;
    @Basic(optional = false)
    @Column(name = "fecha_doc")
    @Temporal(TemporalType.DATE)
    private Date fechaDoc;
    @Basic(optional = false)
    @Size(max = 50)
    @Column(name = "detalle_comun")
    private String detalleComun;
    @JoinColumn(name = "id_agente", referencedColumnName = "idAgente")
    @ManyToOne(optional = false)
    private Agente idAgente;
    @JoinColumn(name = "id_tipo_comunicado", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Parametros idTipoComunicado;

    public Comunicados() {
    }

    public Comunicados(Long idComunicado) {
        this.idComunicado = idComunicado;
    }

    public Comunicados(Long idComunicado, Date fechaDoc, String detalleComun) {
        this.idComunicado = idComunicado;
        this.fechaDoc = fechaDoc;
        this.detalleComun = detalleComun;
    }

    public Long getIdComunicado() {
        return idComunicado;
    }

    public void setIdComunicado(Long idComunicado) {
        this.idComunicado = idComunicado;
    }

    public Date getFechaDoc() {
        return fechaDoc;
    }

    public void setFechaDoc(Date fechaDoc) {
        this.fechaDoc = fechaDoc;
    }

    public String getDetalleComun() {
        return detalleComun;
    }

    public void setDetalleComun(String detalleComun) {
        this.detalleComun = detalleComun;
    }

    public Agente getIdAgente() {
        return idAgente;
    }

    public void setIdAgente(Agente idAgente) {
        this.idAgente = idAgente;
    }

    public Parametros getIdTipoComunicado() {
        return idTipoComunicado;
    }

    public void setIdTipoComunicado(Parametros idTipoComunicado) {
        this.idTipoComunicado = idTipoComunicado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idComunicado != null ? idComunicado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comunicados)) {
            return false;
        }
        Comunicados other = (Comunicados) object;
        if ((this.idComunicado == null && other.idComunicado != null) || (this.idComunicado != null && !this.idComunicado.equals(other.idComunicado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.gob.uideh.entidades.Comunicados[ idComunicado=" + idComunicado + " ]";
    }
    
}
