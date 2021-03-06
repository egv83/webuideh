/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.uideh.menu.entidades;

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
@Table(name = "grupos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Grupos.findAll", query = "SELECT g FROM Grupos g"),
    @NamedQuery(name = "Grupos.findById", query = "SELECT g FROM Grupos g WHERE g.id = :id"),
    @NamedQuery(name = "Grupos.findByDescripcion", query = "SELECT g FROM Grupos g WHERE g.descripcion = :descripcion"),
    @NamedQuery(name = "Grupos.findByEtiqueta", query = "SELECT g FROM Grupos g WHERE g.etiqueta = :etiqueta"),
    @NamedQuery(name = "Grupos.findByExpandible", query = "SELECT g FROM Grupos g WHERE g.expandible = :expandible"),
    @NamedQuery(name = "Grupos.findByNombre", query = "SELECT g FROM Grupos g WHERE g.nombre = :nombre"),
    @NamedQuery(name = "Grupos.findByOrden", query = "SELECT g FROM Grupos g WHERE g.orden = :orden")})
public class Grupos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Size(max = 100)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 30)
    @Column(name = "etiqueta")
    private String etiqueta;
    @Column(name = "expandible")
    private Boolean expandible;
    @Size(max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "orden")
    private Integer orden;
    @OneToMany(mappedBy = "grupos")
    private Collection<Subgrupos> subgruposCollection;
    @OneToMany(mappedBy = "grupos")
    private Collection<ItemsMenuRoles> itemsMenuRolesCollection;
    @OneToMany(mappedBy = "grupos")
    private Collection<ItemMenu> itemMenuCollection;

    public Grupos() {
    }

    public Grupos(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public Boolean getExpandible() {
        return expandible;
    }

    public void setExpandible(Boolean expandible) {
        this.expandible = expandible;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    @XmlTransient
    public Collection<Subgrupos> getSubgruposCollection() {
        return subgruposCollection;
    }

    public void setSubgruposCollection(Collection<Subgrupos> subgruposCollection) {
        this.subgruposCollection = subgruposCollection;
    }

    @XmlTransient
    public Collection<ItemsMenuRoles> getItemsMenuRolesCollection() {
        return itemsMenuRolesCollection;
    }

    public void setItemsMenuRolesCollection(Collection<ItemsMenuRoles> itemsMenuRolesCollection) {
        this.itemsMenuRolesCollection = itemsMenuRolesCollection;
    }

    @XmlTransient
    public Collection<ItemMenu> getItemMenuCollection() {
        return itemMenuCollection;
    }

    public void setItemMenuCollection(Collection<ItemMenu> itemMenuCollection) {
        this.itemMenuCollection = itemMenuCollection;
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
        if (!(object instanceof Grupos)) {
            return false;
        }
        Grupos other = (Grupos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.gob.uideh.menu.entidades.Grupos[ id=" + id + " ]";
    }
    
}
