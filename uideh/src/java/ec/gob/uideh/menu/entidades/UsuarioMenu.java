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
@Table(name = "usuario_menu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioMenu.findAll", query = "SELECT u FROM UsuarioMenu u"),
    @NamedQuery(name = "UsuarioMenu.findById", query = "SELECT u FROM UsuarioMenu u WHERE u.id = :id")})
public class UsuarioMenu implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @JoinColumn(name = "menu", referencedColumnName = "id")
    @ManyToOne
    private Menuitems menu;
    @JoinColumn(name = "usuario", referencedColumnName = "id")
    @ManyToOne
    private Usuarios usuario;

    public UsuarioMenu() {
    }

    public UsuarioMenu(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Menuitems getMenu() {
        return menu;
    }

    public void setMenu(Menuitems menu) {
        this.menu = menu;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
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
        if (!(object instanceof UsuarioMenu)) {
            return false;
        }
        UsuarioMenu other = (UsuarioMenu) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.gob.uideh.menu.entidades.UsuarioMenu[ id=" + id + " ]";
    }
    
}
