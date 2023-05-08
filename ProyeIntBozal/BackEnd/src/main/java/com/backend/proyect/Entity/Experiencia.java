
package com.backend.proyect.Entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Experiencia implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreE;
    @Column(length=1000)
    private String descripcionE;
    private String startE;
    private String endE;
    
    //Const

    public Experiencia() {
    }

    public Experiencia(String nombreE, String descripcionE, String startE, String endE) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        this.startE = startE;
        this.endE = endE;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getDescripcionE() {
        return descripcionE;
    }

    public void setDescripcionE(String descripcionE) {
        this.descripcionE = descripcionE;
    }

    public String getStartE() {
        return startE;
    }

    public void setStartE(String startE) {
        this.startE = startE;
    }

    public String getEndE() {
        return endE;
    }

    public void setEndE(String endE) {
        this.endE = endE;
    }

       
}
