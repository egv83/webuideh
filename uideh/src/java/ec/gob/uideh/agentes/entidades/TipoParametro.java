/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.uideh.agentes.entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Pablo
 */
@Entity
@Table(name = "tipo_parametro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoParametro.findAll", query = "SELECT t FROM TipoParametro t"),
    @NamedQuery(name = "TipoParametro.findById", query = "SELECT t FROM TipoParametro t WHERE t.id = :id"),
    @NamedQuery(name = "TipoParametro.findByTipoParametro", query = "SELECT t FROM TipoParametro t WHERE t.tipoParametro = :tipoParametro")})
public class TipoParametro implements Serializable {
    @OneToMany(mappedBy = "idTipoParametro")
    private Collection<Parametros> parametrosCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Size(max = 20)
    @Column(name = "tipo_parametro")
    private String tipoParametro;

    public TipoParametro() {
    }

    public TipoParametro(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoParametro() {
        return tipoParametro;
    }

    public void setTipoParametro(String tipoParametro) {
        this.tipoParametro = tipoParametro;
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
        if (!(object instanceof TipoParametro)) {
            return false;
        }
        TipoParametro other = (TipoParametro) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.gob.uideh.entidades.TipoParametro[ id=" + id + " ]";
    }

    @XmlTransient
    public Collection<Parametros> getParametrosCollection() {
        return parametrosCollection;
    }

    public void setParametrosCollection(Collection<Parametros> parametrosCollection) {
        this.parametrosCollection = parametrosCollection;
    }
    
}
