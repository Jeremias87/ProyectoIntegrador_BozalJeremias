/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.proyect.Controller;


import com.backend.proyect.Dto.dtoSkills;

import com.backend.proyect.Entity.Skills;
import com.backend.proyect.Security.Controller.Mensaje;

import com.backend.proyect.Service.SSkills;
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
@RequestMapping("skillslab")

@CrossOrigin(origins = "http://localhost:4200")

public class CSkills {
    
    @Autowired
    SSkills sSkills;
    @GetMapping("/lista")
    public ResponseEntity<List<Skills>> list() {
        List<Skills> list = sSkills.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoSkills dtoskill) {
        if (StringUtils.isBlank(dtoskill.getNombreS())) {
            return new ResponseEntity(new Mensaje("Debes ingresar el nombre"), HttpStatus.BAD_REQUEST);
        }
        if (sSkills.existByNombreS(dtoskill.getNombreS())) {
            return new ResponseEntity(new Mensaje("Ya existe esa Skill"), HttpStatus.BAD_REQUEST);
        }
        Skills skill = new Skills(dtoskill.getNombreS(),dtoskill.getPorcentaje());
        sSkills.save(skill);

        return new ResponseEntity(new Mensaje("Se agregó correctamente!"), HttpStatus.OK);
    }
    
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoSkills dtoskill) {
        if (!sSkills.existById(id)) {
            return new ResponseEntity(new Mensaje("No existe ese ID"), HttpStatus.BAD_REQUEST);
        }
        if (sSkills.existByNombreS(dtoskill.getNombreS()) && sSkills.getByNombreS(dtoskill.getNombreS()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Ya existe esa Skill"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoskill.getNombreS())) {
            return new ResponseEntity(new Mensaje("Debes ingresar el nombre"), HttpStatus.BAD_REQUEST);
        }

        Skills skill = sSkills.getOne(id).get();
        skill.setNombreS(dtoskill.getNombreS());
        skill.setPorcentaje(dtoskill.getPorcentaje());


        sSkills.save(skill);

        return new ResponseEntity(new Mensaje("Se actualizó ok la Skill"), HttpStatus.OK);
    }
    
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sSkills.existById(id)) {
            return new ResponseEntity(new Mensaje("No existe ese ID"), HttpStatus.BAD_REQUEST);
        }

        sSkills.delete(id);

        return new ResponseEntity(new Mensaje("Se eliminó la Skill"), HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Skills> getById(@PathVariable("id") int id) {
        if (!sSkills.existById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Skills skill = sSkills.getOne(id).get();
        return new ResponseEntity(skill, HttpStatus.OK);
    }
    
    
}
