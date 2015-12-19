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
@Table(name = "custodio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Custodio.findAll", query = "SELECT c FROM Custodio c"),
    @NamedQuery(name = "Custodio.findByIdcustodio", query = "SELECT c FROM Custodio c WHERE c.idcustodio = :idcustodio"),
    @NamedQuery(name = "Custodio.findByNombresCustodio", query = "SELECT c FROM Custodio c WHERE c.nombresCustodio = :nombresCustodio"),
    @NamedQuery(name = "Custodio.findByApellidosCustodio", query = "SELECT c FROM Custodio c WHERE c.apellidosCustodio = :apellidosCustodio"),
    @NamedQuery(name = "Custodio.findByFechaEntrega", query = "SELECT c FROM Custodio c WHERE c.fechaEntrega = :fechaEntrega"),
    @NamedQuery(name = "Custodio.findByFechaRecepcion", query = "SELECT c FROM Custodio c WHERE c.fechaRecepcion = :fechaRecepcion"),
    @NamedQuery(name = "Custodio.findByDocumento", query = "SELECT c FROM Custodio c WHERE c.documento = :documento"),
    @NamedQuery(name = "Custodio.findByActavehiculo", query = "SELECT c FROM Custodio c WHERE c.actavehiculo = :actavehiculo")})
public class Custodio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcustodio")
    private Integer idcustodio;
    @Size(max = 255)
    @Column(name = "nombresCustodio")
    private String nombresCustodio;
    @Size(max = 255)
    @Column(name = "apellidosCustodio")
    private String apellidosCustodio;
    @Column(name = "fechaEntrega")
    @Temporal(TemporalType.DATE)
    private Date fechaEntrega;
    @Column(name = "fechaRecepcion")
    @Temporal(TemporalType.DATE)
    private Date fechaRecepcion;
    @Size(max = 255)
    @Column(name = "documento")
    private String documento;
    @Size(max = 255)
    @Column(name = "actavehiculo")
    private String actavehiculo;
    @JoinColumn(name = "vehiculo_id", referencedColumnName = "id")
    @ManyToOne
    private Vehiculo vehiculoId;
    @JoinColumn(name = "grado", referencedColumnName = "id")
    @ManyToOne
    private Parametros grado;

    public Custodio() {
    }

    public Custodio(Integer idcustodio) {
        this.idcustodio = idcustodio;
    }

    public Integer getIdcustodio() {
        return idcustodio;
    }

    public void setIdcustodio(Integer idcustodio) {
        this.idcustodio = idcustodio;
    }

    public String getNombresCustodio() {
        return nombresCustodio;
    }

    public void setNombresCustodio(String nombresCustodio) {
        this.nombresCustodio = nombresCustodio;
    }

    public String getApellidosCustodio() {
        return apellidosCustodio;
    }

    public void setApellidosCustodio(String apellidosCustodio) {
        this.apellidosCustodio = apellidosCustodio;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Date getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(Date fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getActavehiculo() {
        return actavehiculo;
    }

    public void setActavehiculo(String actavehiculo) {
        this.actavehiculo = actavehiculo;
    }

    public Vehiculo getVehiculoId() {
        return vehiculoId;
    }

    public void setVehiculoId(Vehiculo vehiculoId) {
        this.vehiculoId = vehiculoId;
    }

    public Parametros getGrado() {
        return grado;
    }

    public void setGrado(Parametros grado) {
        this.grado = grado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcustodio != null ? idcustodio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Custodio)) {
            return false;
        }
        Custodio other = (Custodio) object;
        if ((this.idcustodio == null && other.idcustodio != null) || (this.idcustodio != null && !this.idcustodio.equals(other.idcustodio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.gob.uideh.vehiculos.entidades.Custodio[ idcustodio=" + idcustodio + " ]";
    }
    
}
