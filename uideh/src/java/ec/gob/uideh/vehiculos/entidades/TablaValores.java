/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.uideh.vehiculos.entidades;

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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Pablo
 */
@Entity
@Table(name = "tabla_valores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TablaValores.findAll", query = "SELECT t FROM TablaValores t"),
    @NamedQuery(name = "TablaValores.findById", query = "SELECT t FROM TablaValores t WHERE t.id = :id"),
    @NamedQuery(name = "TablaValores.findByPlaca", query = "SELECT t FROM TablaValores t WHERE t.placa = :placa"),
    @NamedQuery(name = "TablaValores.findByModelo", query = "SELECT t FROM TablaValores t WHERE t.modelo = :modelo"),
    @NamedQuery(name = "TablaValores.findByTipo", query = "SELECT t FROM TablaValores t WHERE t.tipo = :tipo"),
    @NamedQuery(name = "TablaValores.findByCilindraje", query = "SELECT t FROM TablaValores t WHERE t.cilindraje = :cilindraje"),
    @NamedQuery(name = "TablaValores.findByKilometrejeInicial", query = "SELECT t FROM TablaValores t WHERE t.kilometrejeInicial = :kilometrejeInicial"),
    @NamedQuery(name = "TablaValores.findByKilimetrejeFinal", query = "SELECT t FROM TablaValores t WHERE t.kilimetrejeFinal = :kilimetrejeFinal"),
    @NamedQuery(name = "TablaValores.findByKilometrosRecorridos", query = "SELECT t FROM TablaValores t WHERE t.kilometrosRecorridos = :kilometrosRecorridos"),
    @NamedQuery(name = "TablaValores.findByTotalGalones", query = "SELECT t FROM TablaValores t WHERE t.totalGalones = :totalGalones"),
    @NamedQuery(name = "TablaValores.findByPrecioUnitario", query = "SELECT t FROM TablaValores t WHERE t.precioUnitario = :precioUnitario"),
    @NamedQuery(name = "TablaValores.findByTotal", query = "SELECT t FROM TablaValores t WHERE t.total = :total")})
public class TablaValores implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 100)
    @Column(name = "placa")
    private String placa;
    @Size(max = 100)
    @Column(name = "modelo")
    private String modelo;
    @Size(max = 100)
    @Column(name = "tipo")
    private String tipo;
    @Size(max = 100)
    @Column(name = "cilindraje")
    private String cilindraje;
    @Column(name = "kilometreje_inicial")
    private Integer kilometrejeInicial;
    @Column(name = "kilimetreje_final")
    private Integer kilimetrejeFinal;
    @Column(name = "kilometros_recorridos")
    private Integer kilometrosRecorridos;
    @Column(name = "total_galones")
    private Integer totalGalones;
    @Column(name = "precio_unitario")
    private Integer precioUnitario;
    @Column(name = "total")
    private Integer total;
    @JoinColumn(name = "vehiculo_id", referencedColumnName = "id")
    @ManyToOne
    private Vehiculo vehiculoId;
    @JoinColumn(name = "fecha_ingreso_id", referencedColumnName = "id")
    @ManyToOne
    private Combustibles fechaIngresoId;

    public TablaValores() {
    }

    public TablaValores(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(String cilindraje) {
        this.cilindraje = cilindraje;
    }

    public Integer getKilometrejeInicial() {
        return kilometrejeInicial;
    }

    public void setKilometrejeInicial(Integer kilometrejeInicial) {
        this.kilometrejeInicial = kilometrejeInicial;
    }

    public Integer getKilimetrejeFinal() {
        return kilimetrejeFinal;
    }

    public void setKilimetrejeFinal(Integer kilimetrejeFinal) {
        this.kilimetrejeFinal = kilimetrejeFinal;
    }

    public Integer getKilometrosRecorridos() {
        return kilometrosRecorridos;
    }

    public void setKilometrosRecorridos(Integer kilometrosRecorridos) {
        this.kilometrosRecorridos = kilometrosRecorridos;
    }

    public Integer getTotalGalones() {
        return totalGalones;
    }

    public void setTotalGalones(Integer totalGalones) {
        this.totalGalones = totalGalones;
    }

    public Integer getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Integer precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Vehiculo getVehiculoId() {
        return vehiculoId;
    }

    public void setVehiculoId(Vehiculo vehiculoId) {
        this.vehiculoId = vehiculoId;
    }

    public Combustibles getFechaIngresoId() {
        return fechaIngresoId;
    }

    public void setFechaIngresoId(Combustibles fechaIngresoId) {
        this.fechaIngresoId = fechaIngresoId;
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
        if (!(object instanceof TablaValores)) {
            return false;
        }
        TablaValores other = (TablaValores) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.gob.uideh.vehiculos.entidades.TablaValores[ id=" + id + " ]";
    }
    
}
