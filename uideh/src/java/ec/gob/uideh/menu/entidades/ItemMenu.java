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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
@Table(name = "item_menu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItemMenu.findAll", query = "SELECT i FROM ItemMenu i"),
    @NamedQuery(name = "ItemMenu.findById", query = "SELECT i FROM ItemMenu i WHERE i.id = :id"),
    @NamedQuery(name = "ItemMenu.findByDescripcion", query = "SELECT i FROM ItemMenu i WHERE i.descripcion = :descripcion"),
    @NamedQuery(name = "ItemMenu.findByEtiqueta", query = "SELECT i FROM ItemMenu i WHERE i.etiqueta = :etiqueta"),
    @NamedQuery(name = "ItemMenu.findByExpandible", query = "SELECT i FROM ItemMenu i WHERE i.expandible = :expandible"),
    @NamedQuery(name = "ItemMenu.findByNombre", query = "SELECT i FROM ItemMenu i WHERE i.nombre = :nombre"),
    @NamedQuery(name = "ItemMenu.findByOrden", query = "SELECT i FROM ItemMenu i WHERE i.orden = :orden")})
public class ItemMenu implements Serializable {
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
    @Lob
    @Size(max = 2147483647)
    @Column(name = "link")
    private String link;
    @Size(max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "orden")
    private Integer orden;
    @OneToMany(mappedBy = "itmesmenu")
    private Collection<ItemsMenuRoles> itemsMenuRolesCollection;
    @JoinColumn(name = "grupos", referencedColumnName = "id")
    @ManyToOne
    private Grupos grupos;
    @JoinColumn(name = "subgrupos", referencedColumnName = "id")
    @ManyToOne
    private Subgrupos subgrupos;

    public ItemMenu() {
    }

    public ItemMenu(Long id) {
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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
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
    public Collection<ItemsMenuRoles> getItemsMenuRolesCollection() {
        return itemsMenuRolesCollection;
    }

    public void setItemsMenuRolesCollection(Collection<ItemsMenuRoles> itemsMenuRolesCollection) {
        this.itemsMenuRolesCollection = itemsMenuRolesCollection;
    }

    public Grupos getGrupos() {
        return grupos;
    }

    public void setGrupos(Grupos grupos) {
        this.grupos = grupos;
    }

    public Subgrupos getSubgrupos() {
        return subgrupos;
    }

    public void setSubgrupos(Subgrupos subgrupos) {
        this.subgrupos = subgrupos;
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
        if (!(object instanceof ItemMenu)) {
            return false;
        }
        ItemMenu other = (ItemMenu) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.gob.uideh.menu.entidades.ItemMenu[ id=" + id + " ]";
    }
    
}
