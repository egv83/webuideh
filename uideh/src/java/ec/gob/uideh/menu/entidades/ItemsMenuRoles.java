/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.uideh.menu.entidades;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Pablo
 */
@Entity
@Table(name = "items_menu_roles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItemsMenuRoles.findAll", query = "SELECT i FROM ItemsMenuRoles i"),
    @NamedQuery(name = "ItemsMenuRoles.findById", query = "SELECT i FROM ItemsMenuRoles i WHERE i.id = :id")})
public class ItemsMenuRoles implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @JoinColumn(name = "roles", referencedColumnName = "id")
    @ManyToOne
    private Roles roles;
    @JoinColumn(name = "grupos", referencedColumnName = "id")
    @ManyToOne
    private Grupos grupos;
    @JoinColumn(name = "itmesmenu", referencedColumnName = "id")
    @ManyToOne
    private ItemMenu itmesmenu;
    @JoinColumn(name = "subgrupos", referencedColumnName = "id")
    @ManyToOne
    private Subgrupos subgrupos;

    public ItemsMenuRoles() {
    }

    public ItemsMenuRoles(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    public Grupos getGrupos() {
        return grupos;
    }

    public void setGrupos(Grupos grupos) {
        this.grupos = grupos;
    }

    public ItemMenu getItmesmenu() {
        return itmesmenu;
    }

    public void setItmesmenu(ItemMenu itmesmenu) {
        this.itmesmenu = itmesmenu;
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
        if (!(object instanceof ItemsMenuRoles)) {
            return false;
        }
        ItemsMenuRoles other = (ItemsMenuRoles) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.gob.uideh.menu.entidades.ItemsMenuRoles[ id=" + id + " ]";
    }
    
}
