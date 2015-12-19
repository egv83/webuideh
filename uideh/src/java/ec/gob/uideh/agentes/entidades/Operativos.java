/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.uideh.agentes.entidades;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Pablo
 */
@Entity
@Table(name = "operativos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Operativos.findAll", query = "SELECT o FROM Operativos o"),
    @NamedQuery(name = "Operativos.findByIdOperativo", query = "SELECT o FROM Operativos o WHERE o.idOperativo = :idOperativo"),
    @NamedQuery(name = "Operativos.findByNombreOperativo", query = "SELECT o FROM Operativos o WHERE o.nombreOperativo = :nombreOperativo"),
    @NamedQuery(name = "Operativos.findByFechaOperativo", query = "SELECT o FROM Operativos o WHERE o.fechaOperativo = :fechaOperativo"),
    @NamedQuery(name = "Operativos.findByOrdServicio", query = "SELECT o FROM Operativos o WHERE o.ordServicio = :ordServicio")})
public class Operativos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_operativo")
    private Long idOperativo;
    @Size(max = 50)
    @Column(name = "nombre_operativo")
    private String nombreOperativo;
    @Basic(optional = false)
    @Column(name = "fecha_operativo")
    @Temporal(TemporalType.DATE)
    private Date fechaOperativo;
    @Basic(optional = false)
    @Size(max = 50)
    @Column(name = "ord_servicio")
    private String ordServicio;
    @JoinColumn(name = "id_ciudad", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Parametros idCiudad;
    @JoinColumn(name = "id_agente", referencedColumnName = "idAgente")
    @ManyToOne(optional = false)
    private Agente idAgente;

    public Operativos() {
    }

    public Operativos(Long idOperativo) {
        this.idOperativo = idOperativo;
    }

    public Operativos(Long idOperativo, Date fechaOperativo, String ordServicio) {
        this.idOperativo = idOperativo;
        this.fechaOperativo = fechaOperativo;
        this.ordServicio = ordServicio;
    }

    public Long getIdOperativo() {
        return idOperativo;
    }

    public void setIdOperativo(Long idOperativo) {
        this.idOperativo = idOperativo;
    }

    public String getNombreOperativo() {
        return nombreOperativo;
    }

    public void setNombreOperativo(String nombreOperativo) {
        this.nombreOperativo = nombreOperativo;
    }

    public Date getFechaOperativo() {
        return fechaOperativo;
    }

    public void setFechaOperativo(Date fechaOperativo) {
        this.fechaOperativo = fechaOperativo;
    }

    public String getOrdServicio() {
        return ordServicio;
    }

    public void setOrdServicio(String ordServicio) {
        this.ordServicio = ordServicio;
    }

    public Parametros getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(Parametros idCiudad) {
        this.idCiudad = idCiudad;
    }

    public Agente getIdAgente() {
        return idAgente;
    }

    public void setIdAgente(Agente idAgente) {
        this.idAgente = idAgente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOperativo != null ? idOperativo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Operativos)) {
            return false;
        }
        Operativos other = (Operativos) object;
        if ((this.idOperativo == null && other.idOperativo != null) || (this.idOperativo != null && !this.idOperativo.equals(other.idOperativo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.gob.uideh.entidades.Operativos[ idOperativo=" + idOperativo + " ]";
    }
    
}
