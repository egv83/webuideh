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
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Pablo
 */
@Entity
@Table(name = "usuarios_roles")
public class UsuariosRoles implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @JoinColumn(name = "usuarios", referencedColumnName = "id")
    @ManyToOne
    private Usuarios usuarios;
    @JoinColumn(name = "roles", referencedColumnName = "id")
    @ManyToOne
    private Roles roles;
    /*@OneToMany(mappedBy = "userRol")
    private Collection<UserRolMenu> userRolMenuCollection;*/
    @JoinColumn(name = "rol", referencedColumnName = "id")
    @ManyToOne
    private Parametros rol;
    
    /*@JoinColumn(name = "rol", referencedColumnName = "id")
    @ManyToOne
    private Parametros rol;*/

    public UsuariosRoles() {
    }

    public UsuariosRoles(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
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
        if (!(object instanceof UsuariosRoles)) {
            return false;
        }
        UsuariosRoles other = (UsuariosRoles) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.gob.uideh.agentes.entidades.Parametros.UsuariosRoles[ id=" + id + " ]";
    }

    @XmlTransient
    /*public Collection<UserRolMenu> getUserRolMenuCollection() {
        return userRolMenuCollection;
    }

    public void setUserRolMenuCollection(Collection<UserRolMenu> userRolMenuCollection) {
        this.userRolMenuCollection = userRolMenuCollection;
    }*/

    public Parametros getRol() {
        return rol;
    }

    public void setRol(Parametros rol) {
        this.rol = rol;
    }

    /*public Parametros getRol() {
        return rol;
    }

    public void setRol(Parametros rol) {
        this.rol = rol;
    }*/
    
}
