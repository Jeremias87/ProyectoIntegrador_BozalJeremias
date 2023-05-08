/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.proyect.Service;


import com.backend.proyect.Entity.Skills;

import com.backend.proyect.Repository.RSkills;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SSkills {
    
    @Autowired
    RSkills rSkills;
    
    public List<Skills> list(){
        return rSkills.findAll();
    }        
    
    public Optional<Skills> getOne(int id){
        return rSkills.findById(id);
    }
    
    public Optional<Skills> getByNombreS(String nombreS){
        return rSkills.findByNombreS(nombreS);
    }
    
    public void save(Skills skill){
        rSkills.save(skill);
    }
    
    public void delete(int id){
        rSkills.deleteById(id);
    }
    
    public boolean existById(int id){
        return rSkills.existsById(id);
    }
    
    public boolean existByNombreS(String nombreS){
        return rSkills.existsByNombreS(nombreS);
    }
}