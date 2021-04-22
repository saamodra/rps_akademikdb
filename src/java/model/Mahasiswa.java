/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @author putri ramadani rais
 */
@Entity
@Table(name = "mahasiswa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mahasiswa.findAll", query = "SELECT m FROM Mahasiswa m"),
    @NamedQuery(name = "Mahasiswa.findByNim", query = "SELECT m FROM Mahasiswa m WHERE m.nim = :nim"),
    @NamedQuery(name = "Mahasiswa.findByNamaMahasiswa", query = "SELECT m FROM Mahasiswa m WHERE m.namaMahasiswa = :namaMahasiswa"),
    @NamedQuery(name = "Mahasiswa.findByTempatLahir", query = "SELECT m FROM Mahasiswa m WHERE m.tempatLahir = :tempatLahir"),
    @NamedQuery(name = "Mahasiswa.findByTanggalLahir", query = "SELECT m FROM Mahasiswa m WHERE m.tanggalLahir = :tanggalLahir"),
    @NamedQuery(name = "Mahasiswa.findByJenisKelamin", query = "SELECT m FROM Mahasiswa m WHERE m.jenisKelamin = :jenisKelamin"),
    @NamedQuery(name = "Mahasiswa.findByAlamat", query = "SELECT m FROM Mahasiswa m WHERE m.alamat = :alamat"),
    @NamedQuery(name = "Mahasiswa.findByEmail", query = "SELECT m FROM Mahasiswa m WHERE m.email = :email"),
    @NamedQuery(name = "Mahasiswa.findByNoHp", query = "SELECT m FROM Mahasiswa m WHERE m.noHp = :noHp"),
    @NamedQuery(name = "Mahasiswa.findByAngkatan", query = "SELECT m FROM Mahasiswa m WHERE m.angkatan = :angkatan")})
public class Mahasiswa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "NIM")
    private String nim;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NamaMahasiswa")
    private String namaMahasiswa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "TempatLahir")
    private String tempatLahir;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TanggalLahir")
    @Temporal(TemporalType.DATE)
    private Date tanggalLahir;
    @Basic(optional = false)
    @NotNull
    @Column(name = "JenisKelamin")
    private int jenisKelamin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Alamat")
    private String alamat;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "Email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 14)
    @Column(name = "NoHp")
    private String noHp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Angkatan")
    private int angkatan;
    @JoinColumn(name = "idProdi", referencedColumnName = "idProdi")
    @ManyToOne(optional = false)
    private Prodi idProdi;

    public Mahasiswa() {
    }

    public Mahasiswa(String nim) {
        this.nim = nim;
    }

    public Mahasiswa(String nim, String namaMahasiswa, String tempatLahir, Date tanggalLahir, int jenisKelamin, String alamat, String email, String noHp, int angkatan) {
        this.nim = nim;
        this.namaMahasiswa = namaMahasiswa;
        this.tempatLahir = tempatLahir;
        this.tanggalLahir = tanggalLahir;
        this.jenisKelamin = jenisKelamin;
        this.alamat = alamat;
        this.email = email;
        this.noHp = noHp;
        this.angkatan = angkatan;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNamaMahasiswa() {
        return namaMahasiswa;
    }

    public void setNamaMahasiswa(String namaMahasiswa) {
        this.namaMahasiswa = namaMahasiswa;
    }

    public String getTempatLahir() {
        return tempatLahir;
    }

    public void setTempatLahir(String tempatLahir) {
        this.tempatLahir = tempatLahir;
    }

    public Date getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(Date tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public int getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(int jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public Integer getAngkatan() {
        return angkatan == 0 ? null : angkatan;
    }

    public void setAngkatan(Integer angkatan) {
        this.angkatan = angkatan;
    }

    public Prodi getIdProdi() {
        return idProdi;
    }

    public void setIdProdi(Prodi idProdi) {
        this.idProdi = idProdi;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nim != null ? nim.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mahasiswa)) {
            return false;
        }
        Mahasiswa other = (Mahasiswa) object;
        if ((this.nim == null && other.nim != null) || (this.nim != null && !this.nim.equals(other.nim))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Mahasiswa[ nim=" + nim + " ]";
    }
    
}
