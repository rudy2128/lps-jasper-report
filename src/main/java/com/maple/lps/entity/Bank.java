package com.maple.lps.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "bpr_table")
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer sandi;
    private String name;
    private String address;
    private String kab_kota;
    private String provinsi;
    private String wkojk;
    private String phone;
    private String email;

}
