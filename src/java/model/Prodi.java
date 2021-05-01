/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author putri ramadani rais
 */
@Entity
@Table(name = "prodi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prodi.findAll", query = "SELECT p FROM Prodi p"),
    @NamedQuery(name = "Prodi.getLast", query = "SELECT p FROM Prodi p ORDER BY p.idProdi DESC"),
    @NamedQuery(name = "Prodi.findByIdProdi", query = "SELECT p FROM Prodi p WHERE p.idProdi = :idProdi"),
    @NamedQuery(name = "Prodi.findByNamaProdi", query = "SELECT p FROM Prodi p WHERE p.namaProdi = :namaProdi")})
public class Prodi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "idProdi")
    private String idProdi;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "namaProdi")
    private String namaProdi;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProdi")
    private Collection<Mahasiswa> mahasiswaCollection;

    public Prodi() {
    }

    public Prodi(String idProdi) {
        this.idProdi = idProdi;
    }

    public Prodi(String idProdi, String namaProdi) {
        this.idProdi = idProdi;
        this.namaProdi = namaProdi;
    }

    public String getIdProdi() {
        return idProdi;
    }

    public void setIdProdi(String idProdi) {
        this.idProdi = idProdi;
    }

    public String getNamaProdi() {
        return namaProdi;
    }

    public void setNamaProdi(String namaProdi) {
        this.namaProdi = namaProdi;
    }

    @XmlTransient
    public Collection<Mahasiswa> getMahasiswaCollection() {
        return mahasiswaCollection;
    }

    public void setMahasiswaCollection(Collection<Mahasiswa> mahasiswaCollection) {
        this.mahasiswaCollection = mahasiswaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProdi != null ? idProdi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prodi)) {
            return false;
        }
        Prodi other = (Prodi) object;
        if ((this.idProdi == null && other.idProdi != null) || (this.idProdi != null && !this.idProdi.equals(other.idProdi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return namaProdi;
    }
    
}
