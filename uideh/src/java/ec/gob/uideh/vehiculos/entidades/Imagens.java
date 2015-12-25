/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.uideh.vehiculos.entidades;

import java.io.Serializable;
import java.util.Collection;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Pablo
 */
@Entity
@Table(name = "imagens")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Imagens.findAll", query = "SELECT i FROM Imagens i"),
    @NamedQuery(name = "Imagens.findById", query = "SELECT i FROM Imagens i WHERE i.id = :id"),
    @NamedQuery(name = "Imagens.findByAgenteId", query = "SELECT i FROM Imagens i WHERE i.agenteId = :agenteId"),
    @NamedQuery(name = "Imagens.findByDescripcion", query = "SELECT i FROM Imagens i WHERE i.descripcion = :descripcion")})
public class Imagens implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "agente_id")
    private Integer agenteId;
    @Size(max = 100)
    @Column(name = "descripcion")
    private String descripcion;
    @JoinColumn(name = "fuente_id", referencedColumnName = "id")
    @ManyToOne
    private Fuentes fuenteId;
    @JoinColumn(name = "vehiculo_id", referencedColumnName = "id")
    @ManyToOne
    private Vehiculo vehiculoId;
    @OneToMany(mappedBy = "imgvehiculoId")
    private Collection<Vehiculo> vehiculoCollection;

    public Imagens() {
    }

    public Imagens(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAgenteId() {
        return agenteId;
    }

    public void setAgenteId(Integer agenteId) {
        this.agenteId = agenteId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Fuentes getFuenteId() {
        return fuenteId;
    }

    public void setFuenteId(Fuentes fuenteId) {
        this.fuenteId = fuenteId;
    }

    public Vehiculo getVehiculoId() {
        return vehiculoId;
    }

    public void setVehiculoId(Vehiculo vehiculoId) {
        this.vehiculoId = vehiculoId;
    }

    @XmlTransient
    public Collection<Vehiculo> getVehiculoCollection() {
        return vehiculoCollection;
    }

    public void setVehiculoCollection(Collection<Vehiculo> vehiculoCollection) {
        this.vehiculoCollection = vehiculoCollection;
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
        if (!(object instanceof Imagens)) {
            return false;
        }
        Imagens other = (Imagens) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.gob.uideh.vehiculos.entidades.Imagens[ id=" + id + " ]";
    }
    
}
