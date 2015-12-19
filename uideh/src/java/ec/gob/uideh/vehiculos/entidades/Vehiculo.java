/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.uideh.vehiculos.entidades;

import ec.gob.uideh.agentes.entidades.Parametros;
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
@Table(name = "vehiculo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vehiculo.findAll", query = "SELECT v FROM Vehiculo v"),
    @NamedQuery(name = "Vehiculo.findById", query = "SELECT v FROM Vehiculo v WHERE v.id = :id"),
    @NamedQuery(name = "Vehiculo.findByCodigoVehiculo", query = "SELECT v FROM Vehiculo v WHERE v.codigoVehiculo = :codigoVehiculo"),
    @NamedQuery(name = "Vehiculo.findByPlaca", query = "SELECT v FROM Vehiculo v WHERE v.placa = :placa"),
    @NamedQuery(name = "Vehiculo.findByMotor", query = "SELECT v FROM Vehiculo v WHERE v.motor = :motor"),
    @NamedQuery(name = "Vehiculo.findByChasis", query = "SELECT v FROM Vehiculo v WHERE v.chasis = :chasis"),
    @NamedQuery(name = "Vehiculo.findByMarca", query = "SELECT v FROM Vehiculo v WHERE v.marca = :marca"),
    @NamedQuery(name = "Vehiculo.findByTipo", query = "SELECT v FROM Vehiculo v WHERE v.tipo = :tipo"),
    @NamedQuery(name = "Vehiculo.findByAnio", query = "SELECT v FROM Vehiculo v WHERE v.anio = :anio"),
    @NamedQuery(name = "Vehiculo.findByColor", query = "SELECT v FROM Vehiculo v WHERE v.color = :color"),
    @NamedQuery(name = "Vehiculo.findByUnidadServicio", query = "SELECT v FROM Vehiculo v WHERE v.unidadServicio = :unidadServicio"),
    @NamedQuery(name = "Vehiculo.findByImgvehiculo1", query = "SELECT v FROM Vehiculo v WHERE v.imgvehiculo1 = :imgvehiculo1"),
    @NamedQuery(name = "Vehiculo.findByImgvehiculo2", query = "SELECT v FROM Vehiculo v WHERE v.imgvehiculo2 = :imgvehiculo2"),
    @NamedQuery(name = "Vehiculo.findByImgvehiculo3", query = "SELECT v FROM Vehiculo v WHERE v.imgvehiculo3 = :imgvehiculo3"),
    @NamedQuery(name = "Vehiculo.findByImgvehiculo4", query = "SELECT v FROM Vehiculo v WHERE v.imgvehiculo4 = :imgvehiculo4")})
public class Vehiculo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "codigoVehiculo")
    private String codigoVehiculo;
    @Size(max = 255)
    @Column(name = "placa")
    private String placa;
    @Size(max = 255)
    @Column(name = "motor")
    private String motor;
    @Size(max = 255)
    @Column(name = "chasis")
    private String chasis;
    @Size(max = 255)
    @Column(name = "marca")
    private String marca;
    @Size(max = 255)
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "anio")
    private Long anio;
    @Size(max = 20)
    @Column(name = "color")
    private String color;
    @Size(max = 20)
    @Column(name = "unidadServicio")
    private String unidadServicio;
    @Size(max = 255)
    @Column(name = "imgvehiculo1")
    private String imgvehiculo1;
    @Size(max = 255)
    @Column(name = "imgvehiculo2")
    private String imgvehiculo2;
    @Size(max = 255)
    @Column(name = "imgvehiculo3")
    private String imgvehiculo3;
    @Size(max = 255)
    @Column(name = "imgvehiculo4")
    private String imgvehiculo4;
    @OneToMany(mappedBy = "vehiculoId")
    private Collection<Seguro> seguroCollection;
    @OneToMany(mappedBy = "vehiculoId")
    private Collection<TablaValores> tablaValoresCollection;
    @OneToMany(mappedBy = "vehiculoId")
    private Collection<Historialvehiculo> historialvehiculoCollection;
    @JoinColumn(name = "cilindraje_id", referencedColumnName = "id")
    @ManyToOne
    private Parametros cilindrajeId;
    @JoinColumn(name = "modelo_id", referencedColumnName = "id")
    @ManyToOne
    private Parametros modeloId;
    @JoinColumn(name = "estado_id", referencedColumnName = "id")
    @ManyToOne
    private Parametros estadoId;
    @OneToMany(mappedBy = "vehiculoId")
    private Collection<Custodio> custodioCollection;

    public Vehiculo() {
    }

    public Vehiculo(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigoVehiculo() {
        return codigoVehiculo;
    }

    public void setCodigoVehiculo(String codigoVehiculo) {
        this.codigoVehiculo = codigoVehiculo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public String getChasis() {
        return chasis;
    }

    public void setChasis(String chasis) {
        this.chasis = chasis;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Long getAnio() {
        return anio;
    }

    public void setAnio(Long anio) {
        this.anio = anio;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getUnidadServicio() {
        return unidadServicio;
    }

    public void setUnidadServicio(String unidadServicio) {
        this.unidadServicio = unidadServicio;
    }

    public String getImgvehiculo1() {
        return imgvehiculo1;
    }

    public void setImgvehiculo1(String imgvehiculo1) {
        this.imgvehiculo1 = imgvehiculo1;
    }

    public String getImgvehiculo2() {
        return imgvehiculo2;
    }

    public void setImgvehiculo2(String imgvehiculo2) {
        this.imgvehiculo2 = imgvehiculo2;
    }

    public String getImgvehiculo3() {
        return imgvehiculo3;
    }

    public void setImgvehiculo3(String imgvehiculo3) {
        this.imgvehiculo3 = imgvehiculo3;
    }

    public String getImgvehiculo4() {
        return imgvehiculo4;
    }

    public void setImgvehiculo4(String imgvehiculo4) {
        this.imgvehiculo4 = imgvehiculo4;
    }

    @XmlTransient
    public Collection<Seguro> getSeguroCollection() {
        return seguroCollection;
    }

    public void setSeguroCollection(Collection<Seguro> seguroCollection) {
        this.seguroCollection = seguroCollection;
    }

    @XmlTransient
    public Collection<TablaValores> getTablaValoresCollection() {
        return tablaValoresCollection;
    }

    public void setTablaValoresCollection(Collection<TablaValores> tablaValoresCollection) {
        this.tablaValoresCollection = tablaValoresCollection;
    }

    @XmlTransient
    public Collection<Historialvehiculo> getHistorialvehiculoCollection() {
        return historialvehiculoCollection;
    }

    public void setHistorialvehiculoCollection(Collection<Historialvehiculo> historialvehiculoCollection) {
        this.historialvehiculoCollection = historialvehiculoCollection;
    }

    public Parametros getCilindrajeId() {
        return cilindrajeId;
    }

    public void setCilindrajeId(Parametros cilindrajeId) {
        this.cilindrajeId = cilindrajeId;
    }

    public Parametros getModeloId() {
        return modeloId;
    }

    public void setModeloId(Parametros modeloId) {
        this.modeloId = modeloId;
    }

    public Parametros getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(Parametros estadoId) {
        this.estadoId = estadoId;
    }

    @XmlTransient
    public Collection<Custodio> getCustodioCollection() {
        return custodioCollection;
    }

    public void setCustodioCollection(Collection<Custodio> custodioCollection) {
        this.custodioCollection = custodioCollection;
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
        if (!(object instanceof Vehiculo)) {
            return false;
        }
        Vehiculo other = (Vehiculo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.gob.uideh.vehiculos.entidades.Vehiculo[ id=" + id + " ]";
    }
    
}
