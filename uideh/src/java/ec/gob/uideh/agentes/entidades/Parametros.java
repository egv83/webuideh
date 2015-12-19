/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.uideh.agentes.entidades;

import ec.gob.uideh.menu.entidades.UserRolMenu;
import ec.gob.uideh.menu.entidades.UsuariosRoles;
import ec.gob.uideh.vehiculos.entidades.Custodio;
import ec.gob.uideh.vehiculos.entidades.Historialvehiculo;
import ec.gob.uideh.vehiculos.entidades.Vehiculo;
import java.io.Serializable;
import java.util.Collection;
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
@Table(name = "parametros")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Parametros.findAll", query = "SELECT p FROM Parametros p"),
    @NamedQuery(name = "Parametros.findById", query = "SELECT p FROM Parametros p WHERE p.id = :id"),
    @NamedQuery(name = "Parametros.findByParametro", query = "SELECT p FROM Parametros p WHERE p.parametro = :parametro")})
public class Parametros implements Serializable {
    @OneToMany(mappedBy = "tipoMantenimiento")
    private Collection<Historialvehiculo> historialvehiculoCollection;
    @OneToMany(mappedBy = "cilindrajeId")
    private Collection<Vehiculo> vehiculoCollection;
    @OneToMany(mappedBy = "modeloId")
    private Collection<Vehiculo> vehiculoCollection1;
    @OneToMany(mappedBy = "estadoId")
    private Collection<Vehiculo> vehiculoCollection2;
    @OneToMany(mappedBy = "grado")
    private Collection<Custodio> custodioCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Size(max = 20)
    @Column(name = "Parametro")
    private String parametro;
    @OneToMany(mappedBy = "idParam")
    private Collection<Parametros> parametrosCollection;
    @JoinColumn(name = "idParam", referencedColumnName = "id")
    @ManyToOne
    private Parametros idParam;
    @JoinColumn(name = "idTipoParametro", referencedColumnName = "id")
    @ManyToOne
    private TipoParametro idTipoParametro;
    
    @OneToMany(mappedBy = "rol")
    private Collection<UserRolMenu> userRolMenuCollection;
    @OneToMany(mappedBy = "rol")
    private Collection<UsuariosRoles> usuariosRolesCollection;

    public Parametros() {
    }

    public Parametros(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getParametro() {
        return parametro;
    }

    public void setParametro(String parametro) {
        this.parametro = parametro;
    }

    @XmlTransient
    public Collection<Parametros> getParametrosCollection() {
        return parametrosCollection;
    }

    public void setParametrosCollection(Collection<Parametros> parametrosCollection) {
        this.parametrosCollection = parametrosCollection;
    }

    public Parametros getIdParam() {
        return idParam;
    }

    public void setIdParam(Parametros idParam) {
        this.idParam = idParam;
    }

    public TipoParametro getIdTipoParametro() {
        return idTipoParametro;
    }

    public void setIdTipoParametro(TipoParametro idTipoParametro) {
        this.idTipoParametro = idTipoParametro;
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
        if (!(object instanceof Parametros)) {
            return false;
        }
        Parametros other = (Parametros) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.gob.uideh.entidades.Parametros[ id=" + id + " ]";
    }

    @XmlTransient
    public Collection<Historialvehiculo> getHistorialvehiculoCollection() {
        return historialvehiculoCollection;
    }

    public void setHistorialvehiculoCollection(Collection<Historialvehiculo> historialvehiculoCollection) {
        this.historialvehiculoCollection = historialvehiculoCollection;
    }

    @XmlTransient
    public Collection<Vehiculo> getVehiculoCollection() {
        return vehiculoCollection;
    }

    public void setVehiculoCollection(Collection<Vehiculo> vehiculoCollection) {
        this.vehiculoCollection = vehiculoCollection;
    }

    @XmlTransient
    public Collection<Vehiculo> getVehiculoCollection1() {
        return vehiculoCollection1;
    }

    public void setVehiculoCollection1(Collection<Vehiculo> vehiculoCollection1) {
        this.vehiculoCollection1 = vehiculoCollection1;
    }

    @XmlTransient
    public Collection<Vehiculo> getVehiculoCollection2() {
        return vehiculoCollection2;
    }

    public void setVehiculoCollection2(Collection<Vehiculo> vehiculoCollection2) {
        this.vehiculoCollection2 = vehiculoCollection2;
    }

    @XmlTransient
    public Collection<Custodio> getCustodioCollection() {
        return custodioCollection;
    }

    public void setCustodioCollection(Collection<Custodio> custodioCollection) {
        this.custodioCollection = custodioCollection;
    }
    
     @XmlTransient
    public Collection<UsuariosRoles> getUsuariosRolesCollection() {
        return usuariosRolesCollection;
    }

    public void setUsuariosRolesCollection(Collection<UsuariosRoles> usuariosRolesCollection) {
        this.usuariosRolesCollection = usuariosRolesCollection;
    }
    
       @XmlTransient
    public Collection<UserRolMenu> getUserRolMenuCollection() {
        return userRolMenuCollection;
    }

    public void setUserRolMenuCollection(Collection<UserRolMenu> userRolMenuCollection) {
        this.userRolMenuCollection = userRolMenuCollection;
    }
}
