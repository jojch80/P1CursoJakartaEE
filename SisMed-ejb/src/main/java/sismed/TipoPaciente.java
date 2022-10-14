/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sismed;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author jjordan
 */
@Entity
@Table(name = "tipo_paciente")
@NamedQueries({
    @NamedQuery(name = "TipoPaciente.findAll", query = "SELECT t FROM TipoPaciente t"),
    @NamedQuery(name = "TipoPaciente.findByIdTippac", query = "SELECT t FROM TipoPaciente t WHERE t.idTippac = :idTippac"),
    @NamedQuery(name = "TipoPaciente.findByNombreTippac", query = "SELECT t FROM TipoPaciente t WHERE t.nombreTippac = :nombreTippac"),
    @NamedQuery(name = "TipoPaciente.findByDescripcionTippac", query = "SELECT t FROM TipoPaciente t WHERE t.descripcionTippac = :descripcionTippac")})
public class TipoPaciente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tippac")
    private Integer idTippac;
    @Size(max = 2147483647)
    @Column(name = "nombre_tippac")
    private String nombreTippac;
    @Size(max = 2147483647)
    @Column(name = "descripcion_tippac")
    private String descripcionTippac;
    @OneToMany(mappedBy = "idTippac")
    private Collection<Paciente> pacienteCollection;

    public TipoPaciente() {
    }

    public TipoPaciente(Integer idTippac) {
        this.idTippac = idTippac;
    }

    public Integer getIdTippac() {
        return idTippac;
    }

    public void setIdTippac(Integer idTippac) {
        this.idTippac = idTippac;
    }

    public String getNombreTippac() {
        return nombreTippac;
    }

    public void setNombreTippac(String nombreTippac) {
        this.nombreTippac = nombreTippac;
    }

    public String getDescripcionTippac() {
        return descripcionTippac;
    }

    public void setDescripcionTippac(String descripcionTippac) {
        this.descripcionTippac = descripcionTippac;
    }

    public Collection<Paciente> getPacienteCollection() {
        return pacienteCollection;
    }

    public void setPacienteCollection(Collection<Paciente> pacienteCollection) {
        this.pacienteCollection = pacienteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTippac != null ? idTippac.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoPaciente)) {
            return false;
        }
        TipoPaciente other = (TipoPaciente) object;
        if ((this.idTippac == null && other.idTippac != null) || (this.idTippac != null && !this.idTippac.equals(other.idTippac))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sismed.TipoPaciente[ idTippac=" + idTippac + " ]";
    }
    
}
