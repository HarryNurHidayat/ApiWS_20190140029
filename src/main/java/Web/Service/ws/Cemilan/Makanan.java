/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Web.Service.ws.Cemilan;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author harry
 */
@Entity
@Table(name = "makanan")
@NamedQueries({
    @NamedQuery(name = "Makanan.findAll", query = "SELECT m FROM Makanan m"),
    @NamedQuery(name = "Makanan.findById", query = "SELECT m FROM Makanan m WHERE m.id = :id"),
    @NamedQuery(name = "Makanan.findByNama", query = "SELECT m FROM Makanan m WHERE m.nama = :nama"),
    @NamedQuery(name = "Makanan.findByHarga", query = "SELECT m FROM Makanan m WHERE m.harga = :harga"),
    @NamedQuery(name = "Makanan.findByDeskripsi", query = "SELECT m FROM Makanan m WHERE m.deskripsi = :deskripsi")})
public class Makanan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "Nama")
    private String nama;
    @Column(name = "Harga")
    private BigInteger harga;
    @Column(name = "Deskripsi")
    private String deskripsi;

    public Makanan() {
    }

    public Makanan(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public BigInteger getHarga() {
        return harga;
    }

    public void setHarga(BigInteger harga) {
        this.harga = harga;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
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
        if (!(object instanceof Makanan)) {
            return false;
        }
        Makanan other = (Makanan) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Web.Service.ws.Cemilan.Makanan[ id=" + id + " ]";
    }
    
}
