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
    @NamedQuery(name = "Vehiculo.findByActivo", query = "SELECT v FROM Vehiculo v WHERE v.activo = :activo")})
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
    private Integer anio;
    @Size(max = 20)
    @Column(name = "color")
    private String color;
    @Size(max = 20)
    @Column(name = "unidadServicio")
    private String unidadServicio;
    @Column(name = "activo")
    private Boolean activo;
    @OneToMany(mappedBy = "vehiculoId")
    private Collection<Imagens> imagensCollection;
    @JoinColumn(name = "imgvehiculo_id", referencedColumnName = "id")
    @ManyToOne
    private Imagens imgvehiculoId;
    @JoinColumn(name = "cilindraje_id", referencedColumnName = "id")
    @ManyToOne
    private Parametros cilindrajeId;
    @JoinColumn(name = "modelo_id", referencedColumnName = "id")
    @ManyToOne
    private Parametros modeloId;
    @JoinColumn(name = "estado_id", referencedColumnName = "id")
    @ManyToOne
    private Parametros estadoId;

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

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
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

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    @XmlTransient
    public Collection<Imagens> getImagensCollection() {
        return imagensCollection;
    }

    public void setImagensCollection(Collection<Imagens> imagensCollection) {
        this.imagensCollection = imagensCollection;
    }

    public Imagens getImgvehiculoId() {
        return imgvehiculoId;
    }

    public void setImgvehiculoId(Imagens imgvehiculoId) {
        this.imgvehiculoId = imgvehiculoId;
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
