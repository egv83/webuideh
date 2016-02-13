/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.uideh.agentes.entidades;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Pablo
 */
@Entity
@Table(name = "dependiente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dependiente.findAll", query = "SELECT d FROM Dependiente d"),
    @NamedQuery(name = "Dependiente.findByIdDependiente", query = "SELECT d FROM Dependiente d WHERE d.idDependiente = :idDependiente"),
    @NamedQuery(name = "Dependiente.findByNomDepen", query = "SELECT d FROM Dependiente d WHERE d.nomDepen = :nomDepen"),
    @NamedQuery(name = "Dependiente.findByApellDepen", query = "SELECT d FROM Dependiente d WHERE d.apellDepen = :apellDepen"),
    @NamedQuery(name = "Dependiente.findByObservacion", query = "SELECT d FROM Dependiente d WHERE d.observacion = :observacion")})
public class Dependiente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_dependiente")
    private Long idDependiente;
    @Basic(optional = false)
    @Size(max = 40)
    @Column(name = "nom_depen")
    private String nomDepen;
    @Basic(optional = false)
    @Size(max = 40)
    @Column(name = "apell_depen")
    private String apellDepen;
    @Basic(optional = false)
    @Size(max = 30)
    @Column(name = "observacion")
    private String observacion;
    @JoinColumn(name = "id_parentesco", referencedColumnName = "id")
    @ManyToOne
    private Parametros idParentesco;
    @JoinColumn(name = "id_agente", referencedColumnName = "idAgente")
    @ManyToOne
    private Agente idAgente;

    public Dependiente() {
        this.idParentesco = new Parametros();
    }

    public Dependiente(Long idDependiente) {
        this.idDependiente = idDependiente;
    }

    public Dependiente(Long idDependiente, String nomDepen, String apellDepen, String observacion) {
        this.idDependiente = idDependiente;
        this.nomDepen = nomDepen;
        this.apellDepen = apellDepen;
        this.observacion = observacion;
    }

    public Long getIdDependiente() {
        return idDependiente;
    }

    public void setIdDependiente(Long idDependiente) {
        this.idDependiente = idDependiente;
    }

    public String getNomDepen() {
        return nomDepen;
    }

    public void setNomDepen(String nomDepen) {
        this.nomDepen = nomDepen;
    }

    public String getApellDepen() {
        return apellDepen;
    }

    public void setApellDepen(String apellDepen) {
        this.apellDepen = apellDepen;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Parametros getIdParentesco() {
        return idParentesco;
    }

    public void setIdParentesco(Parametros idParentesco) {
        this.idParentesco = idParentesco;
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
        hash += (idDependiente != null ? idDependiente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dependiente)) {
            return false;
        }
        Dependiente other = (Dependiente) object;
        if ((this.idDependiente == null && other.idDependiente != null) || (this.idDependiente != null && !this.idDependiente.equals(other.idDependiente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.gob.uideh.entidades.Dependiente[ idDependiente=" + idDependiente + " ]";
    }
    
}
