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
@Table(name = "pases")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pases.findAll", query = "SELECT p FROM Pases p"),
    @NamedQuery(name = "Pases.findByIdPase", query = "SELECT p FROM Pases p WHERE p.idPase = :idPase"),
    @NamedQuery(name = "Pases.findByDocumentoPase", query = "SELECT p FROM Pases p WHERE p.documentoPase = :documentoPase"),
    @NamedQuery(name = "Pases.findByFechaPase", query = "SELECT p FROM Pases p WHERE p.fechaPase = :fechaPase"),
    @NamedQuery(name = "Pases.findByLugarPase", query = "SELECT p FROM Pases p WHERE p.lugarPase = :lugarPase")})
public class Pases implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pase")
    private Long idPase;
    @Basic(optional = false)
    @NotNull
    @Size(max = 50)
    @Column(name = "documento_pase")
    private String documentoPase;
    @Basic(optional = false)
    @Column(name = "fecha_pase")
    @Temporal(TemporalType.DATE)
    private Date fechaPase;
    @Basic(optional = false)
    @NotNull
    @Size(max = 100)
    @Column(name = "lugar_pase")
    private String lugarPase;
    @JoinColumn(name = "id_agente", referencedColumnName = "idAgente")
    @ManyToOne(optional = false)
    private Agente idAgente;
    @JoinColumn(name = "id_tipo_documento", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Parametros idTipoDocumento;

    public Pases() {
        this.idTipoDocumento = new Parametros();
    }

    public Pases(Long idPase) {
        this.idPase = idPase;
    }

    public Pases(Long idPase, String documentoPase, Date fechaPase, String lugarPase) {
        this.idPase = idPase;
        this.documentoPase = documentoPase;
        this.fechaPase = fechaPase;
        this.lugarPase = lugarPase;
    }

    public Long getIdPase() {
        return idPase;
    }

    public void setIdPase(Long idPase) {
        this.idPase = idPase;
    }

    public String getDocumentoPase() {
        return documentoPase;
    }

    public void setDocumentoPase(String documentoPase) {
        this.documentoPase = documentoPase;
    }

    public Date getFechaPase() {
        return fechaPase;
    }

    public void setFechaPase(Date fechaPase) {
        this.fechaPase = fechaPase;
    }

    public String getLugarPase() {
        return lugarPase;
    }

    public void setLugarPase(String lugarPase) {
        this.lugarPase = lugarPase;
    }

    public Agente getIdAgente() {
        return idAgente;
    }

    public void setIdAgente(Agente idAgente) {
        this.idAgente = idAgente;
    }

    public Parametros getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(Parametros idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPase != null ? idPase.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pases)) {
            return false;
        }
        Pases other = (Pases) object;
        if ((this.idPase == null && other.idPase != null) || (this.idPase != null && !this.idPase.equals(other.idPase))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.gob.uideh.entidades.Pases[ idPase=" + idPase + " ]";
    }
    
}
