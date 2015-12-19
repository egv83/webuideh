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
@Table(name = "permisos_menu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PermisosMenu.findAll", query = "SELECT p FROM PermisosMenu p"),
    @NamedQuery(name = "PermisosMenu.findById", query = "SELECT p FROM PermisosMenu p WHERE p.id = :id"),
    @NamedQuery(name = "PermisosMenu.findByCrear", query = "SELECT p FROM PermisosMenu p WHERE p.crear = :crear"),
    @NamedQuery(name = "PermisosMenu.findByEliminar", query = "SELECT p FROM PermisosMenu p WHERE p.eliminar = :eliminar"),
    @NamedQuery(name = "PermisosMenu.findByImprimir", query = "SELECT p FROM PermisosMenu p WHERE p.imprimir = :imprimir"),
    @NamedQuery(name = "PermisosMenu.findByModificar", query = "SELECT p FROM PermisosMenu p WHERE p.modificar = :modificar"),
    @NamedQuery(name = "PermisosMenu.findByVer", query = "SELECT p FROM PermisosMenu p WHERE p.ver = :ver")})
public class PermisosMenu implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "crear")
    private Short crear;
    @Column(name = "eliminar")
    private Short eliminar;
    @Column(name = "imprimir")
    private Short imprimir;
    @Column(name = "modificar")
    private Short modificar;
    @Column(name = "ver")
    private Short ver;
    @JoinColumn(name = "rol", referencedColumnName = "id")
    @ManyToOne
    private Roles rol;

    public PermisosMenu() {
    }

    public PermisosMenu(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Short getCrear() {
        return crear;
    }

    public void setCrear(Short crear) {
        this.crear = crear;
    }

    public Short getEliminar() {
        return eliminar;
    }

    public void setEliminar(Short eliminar) {
        this.eliminar = eliminar;
    }

    public Short getImprimir() {
        return imprimir;
    }

    public void setImprimir(Short imprimir) {
        this.imprimir = imprimir;
    }

    public Short getModificar() {
        return modificar;
    }

    public void setModificar(Short modificar) {
        this.modificar = modificar;
    }

    public Short getVer() {
        return ver;
    }

    public void setVer(Short ver) {
        this.ver = ver;
    }

    public Roles getRol() {
        return rol;
    }

    public void setRol(Roles rol) {
        this.rol = rol;
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
        if (!(object instanceof PermisosMenu)) {
            return false;
        }
        PermisosMenu other = (PermisosMenu) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.gob.uideh.menu.entidades.PermisosMenu[ id=" + id + " ]";
    }
    
}
