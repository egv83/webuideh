/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.uideh.fuentes.entidades;

import ec.gob.uideh.vehiculos.entidades.Fuentes;
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
@Table(name = "pdfs")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pdfs.findAll", query = "SELECT p FROM Pdfs p"),
    @NamedQuery(name = "Pdfs.findById", query = "SELECT p FROM Pdfs p WHERE p.id = :id"),
    @NamedQuery(name = "Pdfs.findByPdf", query = "SELECT p FROM Pdfs p WHERE p.pdf = :pdf")})
public class Pdfs implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 100)
    @Column(name = "pdf")
    private String pdf;
    @JoinColumn(name = "fuente_id", referencedColumnName = "id")
    @ManyToOne
    private Fuentes fuenteId;

    public Pdfs() {
    }

    public Pdfs(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPdf() {
        return pdf;
    }

    public void setPdf(String pdf) {
        this.pdf = pdf;
    }

    public Fuentes getFuenteId() {
        return fuenteId;
    }

    public void setFuenteId(Fuentes fuenteId) {
        this.fuenteId = fuenteId;
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
        if (!(object instanceof Pdfs)) {
            return false;
        }
        Pdfs other = (Pdfs) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.gob.uideh.fuentes.entidades.Pdfs[ id=" + id + " ]";
    }
    
}
