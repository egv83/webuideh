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
@Table(name = "menuitems")
public class Menuitems implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id",unique = true, nullable = false)
    private Long id;
    @Size(max = 200)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 200)
    @Column(name = "url")
    private String url;
    @Column(name = "nivel")
    private Long nivel;
    @Column(name = "id_padre")
    private Long idPadre;
    @Column(name = "orden")
    private Long orden;
    @Column(name = "num_izquierda")
    private Long numIzquierda;    
    @Column(name = "num_derecha")
    private Long numDerecha;
    @OneToMany(mappedBy = "menu")
    private Collection<UsuarioMenu> usuarioMenuCollection;
    @OneToMany(mappedBy = "menu")
    private Collection<UserRolMenu> userRolMenuCollection;
    
    public Menuitems() {
    }
    
    public Menuitems(Long id,Long idPadre,String descripcion,String url) {
        this.id=id;
        this.idPadre=idPadre;
        this.descripcion=descripcion;
        this.url=url;
    }
    
    public Menuitems(Long id) {
        this.id = id;
    }
    
    public Menuitems(Long id,Long idPadre) {
        this.idPadre = idPadre;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getIdPadre() {
        return idPadre;
    }

    public void setIdPadre(Long idPadres) {
        this.idPadre = idPadres;
    }

    public Long getNumIzquierda() {
        return numIzquierda;
    }

    public void setNumIzquierda(Long numIzquierda) {
        this.numIzquierda = numIzquierda;
    }

    public Long getNumDerecha() {
        return numDerecha;
    }

    public void setNumDerecha(Long numDerecha) {
        this.numDerecha = numDerecha;
    }

    @XmlTransient
    public Collection<UsuarioMenu> getUsuarioMenuCollection() {
        return usuarioMenuCollection;
    }

    public void setUsuarioMenuCollection(Collection<UsuarioMenu> usuarioMenuCollection) {
        this.usuarioMenuCollection = usuarioMenuCollection;
    }

    @XmlTransient
    public Collection<UserRolMenu> getUserRolMenuCollection() {
        return userRolMenuCollection;
    }

    public void setUserRolMenuCollection(Collection<UserRolMenu> userRolMenuCollection) {
        this.userRolMenuCollection = userRolMenuCollection;
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
        if (!(object instanceof Menuitems)) {
            return false;
        }
        Menuitems other = (Menuitems) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.gob.uideh.menu.entidades.Menuitems[ id=" + id + " ]";
    }    

    public Long getNivel() {
        return nivel;
    }

    public void setNivel(Long nivel) {
        this.nivel = nivel;
    }

    public Long getOrden() {
        return orden;
    }

    public void setOrden(Long orden) {
        this.orden = orden;
    }
}
