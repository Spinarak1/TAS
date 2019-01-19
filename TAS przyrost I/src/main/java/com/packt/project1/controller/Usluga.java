package com.packt.project1.controller;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

@Entity
@Table(name = "Usluga")
public class Usluga {
    @Id @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "dataPrzyjecia")
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
    private Date dataPrzyjecia;
    @Column(name = "opis")
    private String opis;
    @ManyToOne(cascade = CascadeType.REMOVE)
    private Klient klient;


    public Usluga(){}
    public Usluga(Klient klient, String opis, Date dataPrzyjecia){
        this.klient = klient;
        this.opis = opis;
        this.dataPrzyjecia = dataPrzyjecia;
    }

    public int getId() {
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public Date getDataPrzyjecia(){
        return dataPrzyjecia;
    }
    public void setDataPrzyjecia(Date dataPrzyjecia){
        this.dataPrzyjecia = dataPrzyjecia;
    }
    public String getOpis(){
        return opis;
    }
    public void setOpis(String opis){
        this.opis = opis;
    }
    public Klient getKlient() {
        return klient;
    }
    public void setKlient(Klient klient) {
        this.klient = klient;
    }

}
