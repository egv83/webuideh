/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.uideh.agentes.entidades;

import ec.gob.uideh.vehiculos.entidades.Fuentes;
import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Pablo
 */
@Entity
@Table(name = "agente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Agente.findAll", query = "SELECT a FROM Agente a"),
    @NamedQuery(name = "Agente.findByIdAgente", query = "SELECT a FROM Agente a WHERE a.idAgente = :idAgente"),
    @NamedQuery(name = "Agente.findByCedAgente", query = "SELECT a FROM Agente a WHERE a.cedAgente = :cedAgente"),
    @NamedQuery(name = "Agente.findByApellAgente", query = "SELECT a FROM Agente a WHERE a.apellAgente = :apellAgente"),
    @NamedQuery(name = "Agente.findByNomAgente", query = "SELECT a FROM Agente a WHERE a.nomAgente = :nomAgente"),
    @NamedQuery(name = "Agente.findByFechaNac", query = "SELECT a FROM Agente a WHERE a.fechaNac = :fechaNac"),
    @NamedQuery(name = "Agente.findByCorreoAgente", query = "SELECT a FROM Agente a WHERE a.correoAgente = :correoAgente"),
    @NamedQuery(name = "Agente.findByNomCombate", query = "SELECT a FROM Agente a WHERE a.nomCombate = :nomCombate"),
    @NamedQuery(name = "Agente.findByTallaAgente", query = "SELECT a FROM Agente a WHERE a.tallaAgente = :tallaAgente"),
    @NamedQuery(name = "Agente.findByCalzadoAgente", query = "SELECT a FROM Agente a WHERE a.calzadoAgente = :calzadoAgente"),
    @NamedQuery(name = "Agente.findByGorraAgente", query = "SELECT a FROM Agente a WHERE a.gorraAgente = :gorraAgente"),
    @NamedQuery(name = "Agente.findByDirecAgente", query = "SELECT a FROM Agente a WHERE a.direcAgente = :direcAgente"),
    @NamedQuery(name = "Agente.findByFotoAgente", query = "SELECT a FROM Agente a WHERE a.fotoAgente = :fotoAgente"),
    @NamedQuery(name = "Agente.findByTelefono1", query = "SELECT a FROM Agente a WHERE a.telefono1 = :telefono1"),
    @NamedQuery(name = "Agente.findByTelefono2", query = "SELECT a FROM Agente a WHERE a.telefono2 = :telefono2")})
public class Agente implements Serializable {
    @Column(name = "cedAgente")
    private Integer cedAgente;
    @Column(name = "tallaAgente")
    private Integer tallaAgente;
    @Column(name = "calzadoAgente")
    private Integer calzadoAgente;
    @Column(name = "gorraAgente")
    private Integer gorraAgente;
    @Column(name = "telefono1")
    private Integer telefono1;
    @Column(name = "telefono2")
    private Integer telefono2;
    @Column(name = "activo")
    private Boolean activo;
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @OneToMany(mappedBy = "agenteId")
    private Collection<Fuentes> fuentesCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAgente")
    private Long idAgente;
    @Size(max = 40)
    @Column(name = "apellAgente")
    private String apellAgente;
    @Size(max = 40)
    @Column(name = "nomAgente")
    private String nomAgente;
    @Column(name = "fechaNac")
    @Temporal(TemporalType.DATE)
    private Date fechaNac;
    @Size(max = 50)
    @Column(name = "correoAgente")
    private String correoAgente;
    @Size(max = 10)
    @Column(name = "nomCombate")
    private String nomCombate;
    @Size(max = 50)
    @Column(name = "direcAgente")
    private String direcAgente;
    @Size(max = 100)
    @Column(name = "fotoAgente")
    private String fotoAgente;
    @JoinColumn(name = "idNiveleduc", referencedColumnName = "id")
    @ManyToOne
    private Parametros idNiveleduc;
    @JoinColumn(name = "idAgencia", referencedColumnName = "id")
    @ManyToOne
    private Parametros idAgencia;
    @JoinColumn(name = "idEstacivil", referencedColumnName = "id")
    @ManyToOne
    private Parametros idEstacivil;
    @JoinColumn(name = "statusAgente", referencedColumnName = "id")
    @ManyToOne
    private Parametros statusAgente;
    @JoinColumn(name = "idGrado", referencedColumnName = "id")
    @ManyToOne
    private Parametros idGrado;
    @JoinColumn(name = "idServicio", referencedColumnName = "id")
    @ManyToOne
    private Parametros idServicio;
    @JoinColumn(name = "idSexo", referencedColumnName = "id")
    @ManyToOne
    private Parametros idSexo;
    @JoinColumn(name = "idTiposangre", referencedColumnName = "id")
    @ManyToOne
    private Parametros idTiposangre;
    @JoinColumn(name = "idTituloUniv", referencedColumnName = "id")
    @ManyToOne
    private Parametros idTituloUniv;
    @JoinColumn(name = "idDepartamento", referencedColumnName = "id")
    @ManyToOne
    private Parametros idDepartamento;
    @JoinColumn(name = "idLicenCond", referencedColumnName = "id")
    @ManyToOne
    private Parametros idLicenCond;

    public Agente() {
        this.idGrado = new Parametros();
        this.idSexo = new Parametros();
        this.idEstacivil = new Parametros();
        this.idTiposangre = new Parametros();
        this.idNiveleduc = new Parametros();
        this.idTituloUniv = new Parametros();
        this.idServicio = new Parametros();
        this.idAgencia = new Parametros();
        this.idDepartamento = new Parametros();
        this.idLicenCond = new Parametros();
    }

    public Agente(Long idAgente) {
        this.idAgente = idAgente;
    }

    public Long getIdAgente() {
        return idAgente;
    }

    public void setIdAgente(Long idAgente) {
        this.idAgente = idAgente;
    }


    public String getApellAgente() {
        return apellAgente;
    }

    public void setApellAgente(String apellAgente) {
        this.apellAgente = apellAgente;
    }

    public String getNomAgente() {
        return nomAgente;
    }

    public void setNomAgente(String nomAgente) {
        this.nomAgente = nomAgente;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getCorreoAgente() {
        return correoAgente;
    }

    public void setCorreoAgente(String correoAgente) {
        this.correoAgente = correoAgente;
    }

    public String getNomCombate() {
        return nomCombate;
    }

    public void setNomCombate(String nomCombate) {
        this.nomCombate = nomCombate;
    }


    public String getDirecAgente() {
        return direcAgente;
    }

    public void setDirecAgente(String direcAgente) {
        this.direcAgente = direcAgente;
    }

    public String getFotoAgente() {
        return fotoAgente;
    }

    public void setFotoAgente(String fotoAgente) {
        this.fotoAgente = fotoAgente;
    }


    public Parametros getIdNiveleduc() {
        return idNiveleduc;
    }

    public void setIdNiveleduc(Parametros idNiveleduc) {
        this.idNiveleduc = idNiveleduc;
    }

    public Parametros getIdAgencia() {
        return idAgencia;
    }

    public void setIdAgencia(Parametros idAgencia) {
        this.idAgencia = idAgencia;
    }

    public Parametros getIdEstacivil() {
        return idEstacivil;
    }

    public void setIdEstacivil(Parametros idEstacivil) {
        this.idEstacivil = idEstacivil;
    }

    public Parametros getStatusAgente() {
        return statusAgente;
    }

    public void setStatusAgente(Parametros statusAgente) {
        this.statusAgente = statusAgente;
    }

    public Parametros getIdGrado() {
        return idGrado;
    }

    public void setIdGrado(Parametros idGrado) {
        this.idGrado = idGrado;
    }

    public Parametros getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Parametros idServicio) {
        this.idServicio = idServicio;
    }

    public Parametros getIdSexo() {
        return idSexo;
    }

    public void setIdSexo(Parametros idSexo) {
        this.idSexo = idSexo;
    }

    public Parametros getIdTiposangre() {
        return idTiposangre;
    }

    public void setIdTiposangre(Parametros idTiposangre) {
        this.idTiposangre = idTiposangre;
    }

    public Parametros getIdTituloUniv() {
        return idTituloUniv;
    }

    public void setIdTituloUniv(Parametros idTituloUniv) {
        this.idTituloUniv = idTituloUniv;
    }

    public Parametros getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Parametros idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public Parametros getIdLicenCond() {
        return idLicenCond;
    }

    public void setIdLicenCond(Parametros idLicenCond) {
        this.idLicenCond = idLicenCond;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAgente != null ? idAgente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Agente)) {
            return false;
        }
        Agente other = (Agente) object;
        if ((this.idAgente == null && other.idAgente != null) || (this.idAgente != null && !this.idAgente.equals(other.idAgente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.gob.uideh.entidades.Agente[ idAgente=" + idAgente + " ]";
    }

    public Integer getCedAgente() {
        return cedAgente;
    }

    public void setCedAgente(Integer cedAgente) {
        this.cedAgente = cedAgente;
    }

    public Integer getTallaAgente() {
        return tallaAgente;
    }

    public void setTallaAgente(Integer tallaAgente) {
        this.tallaAgente = tallaAgente;
    }

    public Integer getCalzadoAgente() {
        return calzadoAgente;
    }

    public void setCalzadoAgente(Integer calzadoAgente) {
        this.calzadoAgente = calzadoAgente;
    }

    public Integer getGorraAgente() {
        return gorraAgente;
    }

    public void setGorraAgente(Integer gorraAgente) {
        this.gorraAgente = gorraAgente;
    }

    public Integer getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(Integer telefono1) {
        this.telefono1 = telefono1;
    }

    public Integer getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(Integer telefono2) {
        this.telefono2 = telefono2;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @XmlTransient
    public Collection<Fuentes> getFuentesCollection() {
        return fuentesCollection;
    }

    public void setFuentesCollection(Collection<Fuentes> fuentesCollection) {
        this.fuentesCollection = fuentesCollection;
    }
    
}
