/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.uideh.vehiculos.entidades;

import ec.gob.uideh.agentes.entidades.Parametros;
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
@Table(name = "historialvehiculo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Historialvehiculo.findAll", query = "SELECT h FROM Historialvehiculo h"),
    @NamedQuery(name = "Historialvehiculo.findById", query = "SELECT h FROM Historialvehiculo h WHERE h.id = :id"),
    @NamedQuery(name = "Historialvehiculo.findByFechaIngresoMantenimiento", query = "SELECT h FROM Historialvehiculo h WHERE h.fechaIngresoMantenimiento = :fechaIngresoMantenimiento"),
    @NamedQuery(name = "Historialvehiculo.findByKilometraje", query = "SELECT h FROM Historialvehiculo h WHERE h.kilometraje = :kilometraje"),
    @NamedQuery(name = "Historialvehiculo.findByDocumentoMantenimiento", query = "SELECT h FROM Historialvehiculo h WHERE h.documentoMantenimiento = :documentoMantenimiento"),
    @NamedQuery(name = "Historialvehiculo.findByLugarMantenimiento", query = "SELECT h FROM Historialvehiculo h WHERE h.lugarMantenimiento = :lugarMantenimiento"),
    @NamedQuery(name = "Historialvehiculo.findByOrdenTrabajo", query = "SELECT h FROM Historialvehiculo h WHERE h.ordenTrabajo = :ordenTrabajo"),
    @NamedQuery(name = "Historialvehiculo.findByTrabajosRealizados", query = "SELECT h FROM Historialvehiculo h WHERE h.trabajosRealizados = :trabajosRealizados"),
    @NamedQuery(name = "Historialvehiculo.findByResponsableMantenimiento", query = "SELECT h FROM Historialvehiculo h WHERE h.responsableMantenimiento = :responsableMantenimiento"),
    @NamedQuery(name = "Historialvehiculo.findByFacturaMantenimiento", query = "SELECT h FROM Historialvehiculo h WHERE h.facturaMantenimiento = :facturaMantenimiento"),
    @NamedQuery(name = "Historialvehiculo.findByObservaciones", query = "SELECT h FROM Historialvehiculo h WHERE h.observaciones = :observaciones")})
public class Historialvehiculo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "fechaIngresoMantenimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaIngresoMantenimiento;
    @Column(name = "kilometraje")
    private Integer kilometraje;
    @Size(max = 255)
    @Column(name = "documentoMantenimiento")
    private String documentoMantenimiento;
    @Size(max = 255)
    @Column(name = "lugarMantenimiento")
    private String lugarMantenimiento;
    @Size(max = 255)
    @Column(name = "ordenTrabajo")
    private String ordenTrabajo;
    @Size(max = 255)
    @Column(name = "trabajos realizados")
    private String trabajosRealizados;
    @Size(max = 255)
    @Column(name = "responsableMantenimiento")
    private String responsableMantenimiento;
    @Size(max = 255)
    @Column(name = "facturaMantenimiento")
    private String facturaMantenimiento;
    @Size(max = 255)
    @Column(name = "observaciones")
    private String observaciones;
    @JoinColumn(name = "vehiculo_id", referencedColumnName = "id")
    @ManyToOne
    private Vehiculo vehiculoId;
    @JoinColumn(name = "tipo_mantenimiento", referencedColumnName = "id")
    @ManyToOne
    private Parametros tipoMantenimiento;

    public Historialvehiculo() {
    }

    public Historialvehiculo(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaIngresoMantenimiento() {
        return fechaIngresoMantenimiento;
    }

    public void setFechaIngresoMantenimiento(Date fechaIngresoMantenimiento) {
        this.fechaIngresoMantenimiento = fechaIngresoMantenimiento;
    }

    public Integer getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(Integer kilometraje) {
        this.kilometraje = kilometraje;
    }

    public String getDocumentoMantenimiento() {
        return documentoMantenimiento;
    }

    public void setDocumentoMantenimiento(String documentoMantenimiento) {
        this.documentoMantenimiento = documentoMantenimiento;
    }

    public String getLugarMantenimiento() {
        return lugarMantenimiento;
    }

    public void setLugarMantenimiento(String lugarMantenimiento) {
        this.lugarMantenimiento = lugarMantenimiento;
    }

    public String getOrdenTrabajo() {
        return ordenTrabajo;
    }

    public void setOrdenTrabajo(String ordenTrabajo) {
        this.ordenTrabajo = ordenTrabajo;
    }

    public String getTrabajosRealizados() {
        return trabajosRealizados;
    }

    public void setTrabajosRealizados(String trabajosRealizados) {
        this.trabajosRealizados = trabajosRealizados;
    }

    public String getResponsableMantenimiento() {
        return responsableMantenimiento;
    }

    public void setResponsableMantenimiento(String responsableMantenimiento) {
        this.responsableMantenimiento = responsableMantenimiento;
    }

    public String getFacturaMantenimiento() {
        return facturaMantenimiento;
    }

    public void setFacturaMantenimiento(String facturaMantenimiento) {
        this.facturaMantenimiento = facturaMantenimiento;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Vehiculo getVehiculoId() {
        return vehiculoId;
    }

    public void setVehiculoId(Vehiculo vehiculoId) {
        this.vehiculoId = vehiculoId;
    }

    public Parametros getTipoMantenimiento() {
        return tipoMantenimiento;
    }

    public void setTipoMantenimiento(Parametros tipoMantenimiento) {
        this.tipoMantenimiento = tipoMantenimiento;
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
        if (!(object instanceof Historialvehiculo)) {
            return false;
        }
        Historialvehiculo other = (Historialvehiculo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.gob.uideh.vehiculos.entidades.Historialvehiculo[ id=" + id + " ]";
    }
    
}
