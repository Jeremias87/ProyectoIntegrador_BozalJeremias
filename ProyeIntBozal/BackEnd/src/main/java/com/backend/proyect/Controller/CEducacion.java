package com.backend.proyect.Controller;

import com.backend.proyect.Dto.dtoEducacion;
import com.backend.proyect.Entity.Educacion;
import com.backend.proyect.Security.Controller.Mensaje;
import com.backend.proyect.Service.SEducacion;
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
@RequestMapping("edulab")

@CrossOrigin(origins = "http://localhost:4200")

public class CEducacion {
    
    @Autowired
    SEducacion sEducacion;
    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> list() {
        List<Educacion> list = sEducacion.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoEducacion dtoexp) {
        if (StringUtils.isBlank(dtoexp.getNombreE())) {
            return new ResponseEntity(new Mensaje("Debes ingresar el nombre"), HttpStatus.BAD_REQUEST);
        }
        if (sEducacion.existByNombreE(dtoexp.getNombreE())) {
            return new ResponseEntity(new Mensaje("Ya existe esa Educacion"), HttpStatus.BAD_REQUEST);
        }
        Educacion educacion = new Educacion(dtoexp.getNombreE(), dtoexp.getDescripcionE(), dtoexp.getStartE(), dtoexp.getEndE());
        sEducacion.save(educacion);

        return new ResponseEntity(new Mensaje("Se agregó correctamente!"), HttpStatus.OK);
    }
    
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoEducacion dtoexp) {
        if (!sEducacion.existById(id)) {
            return new ResponseEntity(new Mensaje("No existe ese ID"), HttpStatus.BAD_REQUEST);
        }
        if (sEducacion.existByNombreE(dtoexp.getNombreE()) && sEducacion.getByNombreE(dtoexp.getNombreE()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Ya existe esa Educacion"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoexp.getNombreE())) {
            return new ResponseEntity(new Mensaje("Debes ingresar el nombre"), HttpStatus.BAD_REQUEST);
        }

        Educacion educacion = sEducacion.getOne(id).get();
        educacion.setNombreE(dtoexp.getNombreE());
        educacion.setDescripcionE(dtoexp.getDescripcionE());
        educacion.setStartE(dtoexp.getStartE());
        educacion.setEndE(dtoexp.getEndE());

       sEducacion.save(educacion);

        return new ResponseEntity(new Mensaje("Se actualizó ok la Educacion"), HttpStatus.OK);
    }
    
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sEducacion.existById(id)) {
            return new ResponseEntity(new Mensaje("No existe ese ID"), HttpStatus.BAD_REQUEST);
        }

        sEducacion.delete(id);

        return new ResponseEntity(new Mensaje("Se eliminó la Educacion"), HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") int id) {
        if (!sEducacion.existById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Educacion educacion = sEducacion.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }
    
    
}
