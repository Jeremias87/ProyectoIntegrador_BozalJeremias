/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.proyect.Dto;

import javax.validation.constraints.NotBlank;

public class dtoSkills {
    
    @NotBlank
    private String nombreS;
    @NotBlank
    private int porcentaje;

    public dtoSkills() {
    }

    public dtoSkills(String nombreS, int porcentaje) {
        this.nombreS = nombreS;
        this.porcentaje = porcentaje;
    }

    public String getNombreS() {
        return nombreS;
    }

    public void setNombreS(String nombreS) {
        this.nombreS = nombreS;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }

   
   
   
}