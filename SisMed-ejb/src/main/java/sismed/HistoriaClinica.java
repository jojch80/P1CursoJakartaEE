/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sismed;

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

/**
 *
 * @author jjordan
 */
@Entity
@Table(name = "historia_clinica")
@NamedQueries({
    @NamedQuery(name = "HistoriaClinica.findAll", query = "SELECT h FROM HistoriaClinica h"),
    @NamedQuery(name = "HistoriaClinica.findByIdHisCli", query = "SELECT h FROM HistoriaClinica h WHERE h.idHisCli = :idHisCli"),
    @NamedQuery(name = "HistoriaClinica.findByFechaAperturaHiscli", query = "SELECT h FROM HistoriaClinica h WHERE h.fechaAperturaHiscli = :fechaAperturaHiscli"),
    @NamedQuery(name = "HistoriaClinica.findByNumeroHistoriaClinica", query = "SELECT h FROM HistoriaClinica h WHERE h.numeroHistoriaClinica = :numeroHistoriaClinica")})
public class HistoriaClinica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_his_cli")
    private Integer idHisCli;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_apertura_hiscli")
    @Temporal(TemporalType.DATE)
    private Date fechaAperturaHiscli;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "numero_historia_clinica")
    private String numeroHistoriaClinica;
    @JoinColumn(name = "id_pac", referencedColumnName = "id_pac")
    @ManyToOne(optional = false)
    private Paciente idPac;

    public HistoriaClinica() {
    }

    public HistoriaClinica(Integer idHisCli) {
        this.idHisCli = idHisCli;
    }

    public HistoriaClinica(Integer idHisCli, Date fechaAperturaHiscli, String numeroHistoriaClinica) {
        this.idHisCli = idHisCli;
        this.fechaAperturaHiscli = fechaAperturaHiscli;
        this.numeroHistoriaClinica = numeroHistoriaClinica;
    }

    public Integer getIdHisCli() {
        return idHisCli;
    }

    public void setIdHisCli(Integer idHisCli) {
        this.idHisCli = idHisCli;
    }

    public Date getFechaAperturaHiscli() {
        return fechaAperturaHiscli;
    }

    public void setFechaAperturaHiscli(Date fechaAperturaHiscli) {
        this.fechaAperturaHiscli = fechaAperturaHiscli;
    }

    public String getNumeroHistoriaClinica() {
        return numeroHistoriaClinica;
    }

    public void setNumeroHistoriaClinica(String numeroHistoriaClinica) {
        this.numeroHistoriaClinica = numeroHistoriaClinica;
    }

    public Paciente getIdPac() {
        return idPac;
    }

    public void setIdPac(Paciente idPac) {
        this.idPac = idPac;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHisCli != null ? idHisCli.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HistoriaClinica)) {
            return false;
        }
        HistoriaClinica other = (HistoriaClinica) object;
        if ((this.idHisCli == null && other.idHisCli != null) || (this.idHisCli != null && !this.idHisCli.equals(other.idHisCli))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sismed.HistoriaClinica[ idHisCli=" + idHisCli + " ]";
    }
    
}
