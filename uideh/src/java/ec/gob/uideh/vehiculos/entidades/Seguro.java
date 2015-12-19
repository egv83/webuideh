/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.uideh.vehiculos.entidades;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Pablo
 */
@Entity
@Table(name = "seguro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Seguro.findAll", query = "SELECT s FROM Seguro s"),
    @NamedQuery(name = "Seguro.findById", query = "SELECT s FROM Seguro s WHERE s.id = :id"),
    @NamedQuery(name = "Seguro.findByFechaSiniestro", query = "SELECT s FROM Seguro s WHERE s.fechaSiniestro = :fechaSiniestro"),
    @NamedQuery(name = "Seguro.findByFechaIngreso", query = "SELECT s FROM Seguro s WHERE s.fechaIngreso = :fechaIngreso"),
    @NamedQuery(name = "Seguro.findByFechaSalida", query = "SELECT s FROM Seguro s WHERE s.fechaSalida = :fechaSalida"),
    @NamedQuery(name = "Seguro.findByTaller", query = "SELECT s FROM Seguro s WHERE s.taller = :taller"),
    @NamedQuery(name = "Seguro.findByDireccion", query = "SELECT s FROM Seguro s WHERE s.direccion = :direccion"),
    @NamedQuery(name = "Seguro.findByDanio", query = "SELECT s FROM Seguro s WHERE s.danio = :danio"),
    @NamedQuery(name = "Seguro.findByResponsable", query = "SELECT s FROM Seguro s WHERE s.responsable = :responsable"),
    @NamedQuery(name = "Seguro.findBySeguro", query = "SELECT s FROM Seguro s WHERE s.seguro = :seguro"),
    @NamedQuery(name = "Seguro.findByImagen1", query = "SELECT s FROM Seguro s WHERE s.imagen1 = :imagen1"),
    @NamedQuery(name = "Seguro.findByImagen2", query = "SELECT s FROM Seguro s WHERE s.imagen2 = :imagen2"),
    @NamedQuery(name = "Seguro.findByImagen3", query = "SELECT s FROM Seguro s WHERE s.imagen3 = :imagen3")})
public class Seguro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "fechaSiniestro")
    @Temporal(TemporalType.DATE)
    private Date fechaSiniestro;
    @Column(name = "fechaIngreso")
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    @Column(name = "fechaSalida")
    @Temporal(TemporalType.DATE)
    private Date fechaSalida;
    @Size(max = 255)
    @Column(name = "taller")
    private String taller;
    @Size(max = 255)
    @Column(name = "direccion")
    private String direccion;
    @Size(max = 255)
    @Column(name = "danio")
    private String danio;
    @Size(max = 255)
    @Column(name = "responsable")
    private String responsable;
    @Size(max = 255)
    @Column(name = "seguro")
    private String seguro;
    @Size(max = 255)
    @Column(name = "imagen1")
    private String imagen1;
    @Size(max = 255)
    @Column(name = "imagen2")
    private String imagen2;
    @Size(max = 255)
    @Column(name = "imagen3")
    private String imagen3;
    @JoinColumn(name = "vehiculo_id", referencedColumnName = "id")
    @ManyToOne
    private Vehiculo vehiculoId;

    public Seguro() {
    }

    public Seguro(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaSiniestro() {
        return fechaSiniestro;
    }

    public void setFechaSiniestro(Date fechaSiniestro) {
        this.fechaSiniestro = fechaSiniestro;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getTaller() {
        return taller;
    }

    public void setTaller(String taller) {
        this.taller = taller;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDanio() {
        return danio;
    }

    public void setDanio(String danio) {
        this.danio = danio;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getSeguro() {
        return seguro;
    }

    public void setSeguro(String seguro) {
        this.seguro = seguro;
    }

    public String getImagen1() {
        return imagen1;
    }

    public void setImagen1(String imagen1) {
        this.imagen1 = imagen1;
    }

    public String getImagen2() {
        return imagen2;
    }

    public void setImagen2(String imagen2) {
        this.imagen2 = imagen2;
    }

    public String getImagen3() {
        return imagen3;
    }

    public void setImagen3(String imagen3) {
        this.imagen3 = imagen3;
    }

    public Vehiculo getVehiculoId() {
        return vehiculoId;
    }

    public void setVehiculoId(Vehiculo vehiculoId) {
        this.vehiculoId = vehiculoId;
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
        if (!(object instanceof Seguro)) {
            return false;
        }
        Seguro other = (Seguro) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.gob.uideh.vehiculos.entidades.Seguro[ id=" + id + " ]";
    }
    
}
