/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.uideh.menu.entidades;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "roles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Roles.findAll", query = "SELECT r FROM Roles r"),
    @NamedQuery(name = "Roles.findById", query = "SELECT r FROM Roles r WHERE r.id = :id"),
    @NamedQuery(name = "Roles.findByDescripcion", query = "SELECT r FROM Roles r WHERE r.descripcion = :descripcion"),
    @NamedQuery(name = "Roles.findByUsuarios", query = "SELECT r FROM Roles r WHERE r.usuarios = :usuarios")})
public class Roles implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Size(max = 200)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "usuarios")
    private BigInteger usuarios;
    @OneToMany(mappedBy = "roles")
    private Collection<ItemsMenuRoles> itemsMenuRolesCollection;
    @OneToMany(mappedBy = "rol")
    private Collection<PermisosMenu> permisosMenuCollection;
    @OneToMany(mappedBy = "roles")
    private Collection<UsuariosRoles> usuariosRolesCollection;

    public Roles() {
    }

    public Roles(Long id) {
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

    public BigInteger getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(BigInteger usuarios) {
        this.usuarios = usuarios;
    }

    @XmlTransient
    public Collection<ItemsMenuRoles> getItemsMenuRolesCollection() {
        return itemsMenuRolesCollection;
    }

    public void setItemsMenuRolesCollection(Collection<ItemsMenuRoles> itemsMenuRolesCollection) {
        this.itemsMenuRolesCollection = itemsMenuRolesCollection;
    }

    @XmlTransient
    public Collection<PermisosMenu> getPermisosMenuCollection() {
        return permisosMenuCollection;
    }

    public void setPermisosMenuCollection(Collection<PermisosMenu> permisosMenuCollection) {
        this.permisosMenuCollection = permisosMenuCollection;
    }

    @XmlTransient
    public Collection<UsuariosRoles> getUsuariosRolesCollection() {
        return usuariosRolesCollection;
    }

    public void setUsuariosRolesCollection(Collection<UsuariosRoles> usuariosRolesCollection) {
        this.usuariosRolesCollection = usuariosRolesCollection;
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
        if (!(object instanceof Roles)) {
            return false;
        }
        Roles other = (Roles) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.gob.uideh.menu.entidades.Roles[ id=" + id + " ]";
    }
    
}
