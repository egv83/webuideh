/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.uideh.menu.entidades;

import ec.gob.uideh.agentes.entidades.Parametros;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 *
 * @author Pablo
 */
@Entity
@Table(name = "user_rol_menu")
public class UserRolMenu implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    /*@JoinColumn(name = "user_rol", referencedColumnName = "id")
    @ManyToOne
    private UsuariosRoles userRol;*/
    @JoinColumn(name = "menu", referencedColumnName = "id")
    @ManyToOne
    private Menuitems menu;
    @JoinColumn(name = "rol", referencedColumnName = "id")
    @ManyToOne
    private Parametros rol;

    public UserRolMenu() {
    }

    public UserRolMenu(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /*public UsuariosRoles getUserRol() {
        return userRol;
    }

    public void setUserRol(UsuariosRoles userRol) {
        this.userRol = userRol;
    }*/

    public Menuitems getMenu() {
        return menu;
    }

    public void setMenu(Menuitems menu) {
        this.menu = menu;
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
        if (!(object instanceof UserRolMenu)) {
            return false;
        }
        UserRolMenu other = (UserRolMenu) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.gob.uideh.menu.entidades.UserRolMenu[ id=" + id + " ]";
    }

    public Parametros getRol() {
        return rol;
    }

    public void setRol(Parametros rol) {
        this.rol = rol;
    }
}
