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
@Table(name = "cursos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cursos.findAll", query = "SELECT c FROM Cursos c"),
    @NamedQuery(name = "Cursos.findByIdcurso", query = "SELECT c FROM Cursos c WHERE c.idcurso = :idcurso"),
    @NamedQuery(name = "Cursos.findByFechaCursoInicio", query = "SELECT c FROM Cursos c WHERE c.fechaCursoInicio = :fechaCursoInicio"),
    @NamedQuery(name = "Cursos.findByFechaCursoFin", query = "SELECT c FROM Cursos c WHERE c.fechaCursoFin = :fechaCursoFin"),
    @NamedQuery(name = "Cursos.findByTiempo", query = "SELECT c FROM Cursos c WHERE c.tiempo = :tiempo"),
    @NamedQuery(name = "Cursos.findByDocumento", query = "SELECT c FROM Cursos c WHERE c.documento = :documento"),
    @NamedQuery(name = "Cursos.findByObservacion", query = "SELECT c FROM Cursos c WHERE c.observacion = :observacion")})
public class Cursos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcurso")
    private Long idcurso;
    @Basic(optional = false)
    @Column(name = "fecha_curso_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaCursoInicio;
    @Basic(optional = false)
    @Column(name = "fecha_curso_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaCursoFin;
    @Basic(optional = false)
    @Size(max = 20)
    @Column(name = "tiempo")
    private String tiempo;
    @Basic(optional = false)
    @Size(max = 20)
    @Column(name = "documento")
    private String documento;
    @Basic(optional = false)
    @Size(max = 100)
    @Column(name = "observacion")
    private String observacion;
    @JoinColumn(name = "id_agente", referencedColumnName = "idAgente")
    @ManyToOne(optional = false)
    private Agente idAgente;
    @JoinColumn(name = "id_lugar_curso", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Parametros idLugarCurso;
    @JoinColumn(name = "id_tipo_curso", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Parametros idTipoCurso;

    public Cursos() {
        this.idTipoCurso = new Parametros();
        this.idLugarCurso = new Parametros();
    }

    public Cursos(Long idcurso) {
        this.idcurso = idcurso;
    }

    public Cursos(Long idcurso, Date fechaCursoInicio, Date fechaCursoFin, String tiempo, String documento, String observacion) {
        this.idcurso = idcurso;
        this.fechaCursoInicio = fechaCursoInicio;
        this.fechaCursoFin = fechaCursoFin;
        this.tiempo = tiempo;
        this.documento = documento;
        this.observacion = observacion;
    }

    public Long getIdcurso() {
        return idcurso;
    }

    public void setIdcurso(Long idcurso) {
        this.idcurso = idcurso;
    }

    public Date getFechaCursoInicio() {
        return fechaCursoInicio;
    }

    public void setFechaCursoInicio(Date fechaCursoInicio) {
        this.fechaCursoInicio = fechaCursoInicio;
    }

    public Date getFechaCursoFin() {
        return fechaCursoFin;
    }

    public void setFechaCursoFin(Date fechaCursoFin) {
        this.fechaCursoFin = fechaCursoFin;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Agente getIdAgente() {
        return idAgente;
    }

    public void setIdAgente(Agente idAgente) {
        this.idAgente = idAgente;
    }

    public Parametros getIdLugarCurso() {
        return idLugarCurso;
    }

    public void setIdLugarCurso(Parametros idLugarCurso) {
        this.idLugarCurso = idLugarCurso;
    }

    public Parametros getIdTipoCurso() {
        return idTipoCurso;
    }

    public void setIdTipoCurso(Parametros idTipoCurso) {
        this.idTipoCurso = idTipoCurso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcurso != null ? idcurso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cursos)) {
            return false;
        }
        Cursos other = (Cursos) object;
        if ((this.idcurso == null && other.idcurso != null) || (this.idcurso != null && !this.idcurso.equals(other.idcurso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.gob.uideh.entidades.Cursos[ idcurso=" + idcurso + " ]";
    }
    
}
