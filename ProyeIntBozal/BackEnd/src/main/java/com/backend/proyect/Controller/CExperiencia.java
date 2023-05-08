
package com.backend.proyect.Controller;

import com.backend.proyect.Dto.dtoExperiencia;
import com.backend.proyect.Entity.Experiencia;
import com.backend.proyect.Security.Controller.Mensaje;
import com.backend.proyect.Service.SExperiencia;
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
@RequestMapping("explab")

@CrossOrigin(origins = "http://localhost:4200")

public class CExperiencia {
    
    @Autowired
    SExperiencia sExperiencia;
    @GetMapping("/lista")
    public ResponseEntity<List<Experiencia>> list() {
        List<Experiencia> list = sExperiencia.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoExperiencia dtoexp) {
        if (StringUtils.isBlank(dtoexp.getNombreE())) {
            return new ResponseEntity(new Mensaje("Debes ingresar el nombre"), HttpStatus.BAD_REQUEST);
        }
        if (sExperiencia.existByNombreE(dtoexp.getNombreE())) {
            return new ResponseEntity(new Mensaje("Ya existe esa experiencia"), HttpStatus.BAD_REQUEST);
        }
        Experiencia experiencia = new Experiencia(dtoexp.getNombreE(), dtoexp.getDescripcionE(), dtoexp.getStartE(), dtoexp.getEndE());
        sExperiencia.save(experiencia);

        return new ResponseEntity(new Mensaje("Se agregó correctamente!"), HttpStatus.OK);
    }
    
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoExperiencia dtoexp) {
        if (!sExperiencia.existById(id)) {
            return new ResponseEntity(new Mensaje("No existe ese ID"), HttpStatus.BAD_REQUEST);
        }
        if (sExperiencia.existByNombreE(dtoexp.getNombreE()) && sExperiencia.getByNombreE(dtoexp.getNombreE()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Ya existe esa experiencia"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoexp.getNombreE())) {
            return new ResponseEntity(new Mensaje("Debes ingresar el nombre"), HttpStatus.BAD_REQUEST);
        }

        Experiencia experiencia = sExperiencia.getOne(id).get();
        experiencia.setNombreE(dtoexp.getNombreE());
        experiencia.setDescripcionE(dtoexp.getDescripcionE());
        experiencia.setStartE(dtoexp.getStartE());
        experiencia.setEndE(dtoexp.getEndE());

        sExperiencia.save(experiencia);

        return new ResponseEntity(new Mensaje("Se actualizó ok la experiencia"), HttpStatus.OK);
    }
    
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sExperiencia.existById(id)) {
            return new ResponseEntity(new Mensaje("No existe ese ID"), HttpStatus.BAD_REQUEST);
        }

        sExperiencia.delete(id);

        return new ResponseEntity(new Mensaje("Se eliminó la experiencia"), HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") int id) {
        if (!sExperiencia.existById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Experiencia experiencia = sExperiencia.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }
    
    
}
