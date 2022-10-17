package com.maple.lps.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "bpr_table")
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int sandi;
    private String name;
    private String address;
    @Column(name = "kab_kota")
    private String city;
    private String provinsi;
    private String wkojk;
    private String phone;
    private String email;

}
