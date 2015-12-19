/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.uideh.vehiculos.entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Pablo
 */
@Entity
@Table(name = "combustibles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Combustibles.findAll", query = "SELECT c FROM Combustibles c"),
    @NamedQuery(name = "Combustibles.findById", query = "SELECT c FROM Combustibles c WHERE c.id = :id"),
    @NamedQuery(name = "Combustibles.findByFechaIngreso", query = "SELECT c FROM Combustibles c WHERE c.fechaIngreso = :fechaIngreso")})
public class Combustibles implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "fecha_ingreso")
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    @OneToMany(mappedBy = "fechaIngresoId")
    private Collection<TablaValores> tablaValoresCollection;

    public Combustibles() {
    }

    public Combustibles(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    @XmlTransient
    public Collection<TablaValores> getTablaValoresCollection() {
        return tablaValoresCollection;
    }

    public void setTablaValoresCollection(Collection<TablaValores> tablaValoresCollection) {
        this.tablaValoresCollection = tablaValoresCollection;
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
        if (!(object instanceof Combustibles)) {
            return false;
        }
        Combustibles other = (Combustibles) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.gob.uideh.vehiculos.entidades.Combustibles[ id=" + id + " ]";
    }
    
}
