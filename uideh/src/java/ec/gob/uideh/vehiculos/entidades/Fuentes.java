/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.uideh.vehiculos.entidades;

import ec.gob.uideh.agentes.entidades.Agente;
import ec.gob.uideh.fuentes.entidades.Casos;
import ec.gob.uideh.fuentes.entidades.Pdfs;
import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Pablo
 */
@Entity
@Table(name = "fuentes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fuentes.findAll", query = "SELECT f FROM Fuentes f"),
    @NamedQuery(name = "Fuentes.findById", query = "SELECT f FROM Fuentes f WHERE f.id = :id"),
    @NamedQuery(name = "Fuentes.findByCodigo", query = "SELECT f FROM Fuentes f WHERE f.codigo = :codigo"),
    @NamedQuery(name = "Fuentes.findByDniFuente", query = "SELECT f FROM Fuentes f WHERE f.dniFuente = :dniFuente"),
    @NamedQuery(name = "Fuentes.findByNombreFuente", query = "SELECT f FROM Fuentes f WHERE f.nombreFuente = :nombreFuente"),
    @NamedQuery(name = "Fuentes.findByApellidoFuente", query = "SELECT f FROM Fuentes f WHERE f.apellidoFuente = :apellidoFuente"),
    @NamedQuery(name = "Fuentes.findByAliasFuente", query = "SELECT f FROM Fuentes f WHERE f.aliasFuente = :aliasFuente"),
    @NamedQuery(name = "Fuentes.findByFechaRegistro", query = "SELECT f FROM Fuentes f WHERE f.fechaRegistro = :fechaRegistro")})
public class Fuentes implements Serializable {
    @OneToMany(mappedBy = "fuenteId")
    private Collection<Pdfs> pdfsCollection;
    @OneToMany(mappedBy = "fuenteId")
    private Collection<Casos> casosCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 10)
    @Column(name = "codigo")
    private String codigo;
    @Column(name = "dni_fuente")
    private Integer dniFuente;
    @Size(max = 100)
    @Column(name = "nombre_fuente")
    private String nombreFuente;
    @Size(max = 100)
    @Column(name = "apellido_fuente")
    private String apellidoFuente;
    @Size(max = 100)
    @Column(name = "alias_fuente")
    private String aliasFuente;
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @OneToMany(mappedBy = "fuenteId")
    private Collection<Imagens> imagensCollection;
    @JoinColumn(name = "agente_id", referencedColumnName = "idAgente")
    @ManyToOne
    private Agente agenteId;

    public Fuentes() {
    }

    public Fuentes(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Integer getDniFuente() {
        return dniFuente;
    }

    public void setDniFuente(Integer dniFuente) {
        this.dniFuente = dniFuente;
    }

    public String getNombreFuente() {
        return nombreFuente;
    }

    public void setNombreFuente(String nombreFuente) {
        this.nombreFuente = nombreFuente;
    }

    public String getApellidoFuente() {
        return apellidoFuente;
    }

    public void setApellidoFuente(String apellidoFuente) {
        this.apellidoFuente = apellidoFuente;
    }

    public String getAliasFuente() {
        return aliasFuente;
    }

    public void setAliasFuente(String aliasFuente) {
        this.aliasFuente = aliasFuente;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @XmlTransient
    public Collection<Imagens> getImagensCollection() {
        return imagensCollection;
    }

    public void setImagensCollection(Collection<Imagens> imagensCollection) {
        this.imagensCollection = imagensCollection;
    }

    public Agente getAgenteId() {
        return agenteId;
    }

    public void setAgenteId(Agente agenteId) {
        this.agenteId = agenteId;
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
        if (!(object instanceof Fuentes)) {
            return false;
        }
        Fuentes other = (Fuentes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.gob.uideh.vehiculos.entidades.Fuentes[ id=" + id + " ]";
    }

    @XmlTransient
    public Collection<Pdfs> getPdfsCollection() {
        return pdfsCollection;
    }

    public void setPdfsCollection(Collection<Pdfs> pdfsCollection) {
        this.pdfsCollection = pdfsCollection;
    }

    @XmlTransient
    public Collection<Casos> getCasosCollection() {
        return casosCollection;
    }

    public void setCasosCollection(Collection<Casos> casosCollection) {
        this.casosCollection = casosCollection;
    }
    
}
