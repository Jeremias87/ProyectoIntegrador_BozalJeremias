/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.proyect.Controller;

import com.backend.proyect.Dto.dtoProyectos;

import com.backend.proyect.Entity.Proyectos;
import com.backend.proyect.Security.Controller.Mensaje;

import com.backend.proyect.Service.SProyectos;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("proylab")

@CrossOrigin(origins = "http://localhost:4200")

public class CProyectos {
    
    @Autowired
    SProyectos sProyectos;
    @GetMapping("/lista")
    public ResponseEntity<List<Proyectos>> list() {
        List<Proyectos> list = sProyectos.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoProyectos dtoproy) {
        if (StringUtils.isBlank(dtoproy.getNombreP())) {
            return new ResponseEntity(new Mensaje("Debes ingresar el nombre"), HttpStatus.BAD_REQUEST);
        }
        if (sProyectos.existByNombreP(dtoproy.getNombreP())) {
            return new ResponseEntity(new Mensaje("Ya existe este Proyecto"), HttpStatus.BAD_REQUEST);
        }
        Proyectos experiencia = new Proyectos(dtoproy.getNombreP(), dtoproy.getDescripcionP(), dtoproy.getImgP());
        sProyectos.save(experiencia);

        return new ResponseEntity(new Mensaje("Se agregó correctamente!"), HttpStatus.OK);
    }
    
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoProyectos dtoproy) {
        if (!sProyectos.existById(id)) {
            return new ResponseEntity(new Mensaje("No existe ese ID"), HttpStatus.BAD_REQUEST);
        }
        if (sProyectos.existByNombreP(dtoproy.getNombreP()) && sProyectos.getByNombreP(dtoproy.getNombreP()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Ya existe este Proyecto"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoproy.getNombreP())) {
            return new ResponseEntity(new Mensaje("Debes ingresar el nombre"), HttpStatus.BAD_REQUEST);
        }

        Proyectos experiencia = sProyectos.getOne(id).get();
        experiencia.setNombreP(dtoproy.getNombreP());
        experiencia.setDescripcionP(dtoproy.getDescripcionP());
        experiencia.setImgP(dtoproy.getImgP());

        sProyectos.save(experiencia);

        return new ResponseEntity(new Mensaje("Se actualizó El Proyecto"), HttpStatus.OK);
    }
    
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sProyectos.existById(id)) {
            return new ResponseEntity(new Mensaje("No existe ese ID"), HttpStatus.BAD_REQUEST);
        }

        sProyectos.delete(id);

        return new ResponseEntity(new Mensaje("Se eliminó el Proyecto"), HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyectos> getById(@PathVariable("id") int id) {
        if (!sProyectos.existById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Proyectos experiencia = sProyectos.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }
    
    
}
