package com.maple.lps.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Setter
@Getter
@Entity
@Table(name = "bpr_table")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Bank implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int sandi;
    @Column(name = "nama_bpr")
    private String name;
    @Column(name = "alamat")
    private String address;
    @Column(name = "kab_kota")
    private String city;
    private String provinsi;
    private String wkojk;
    @Column(name = "telp")
    private String phone;
    private String email;

    @Override
    public String toString() {
        return "Bank{" +
                "id=" + id +
                ", sandi=" + sandi +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", provinsi='" + provinsi + '\'' +
                ", wkojk='" + wkojk + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
