package com.miporfoliobackend.bar.controller;

import java.util.List;

import com.miporfoliobackend.bar.models.Persona;
import com.miporfoliobackend.bar.services.IPersonaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonaController {

    @Autowired IPersonaService ipersonaService;

    @GetMapping("/personas/traer")
    public List<Persona> getPersona(){
        return ipersonaService.getPersonas();
    }

    @PostMapping("/personas/crear")
    public String crearPersona(@RequestBody Persona persona){
    
        ipersonaService.savePersona(persona);
        return "Se creo persona con exito!";
    }

    @PostMapping("/personas/editar")
    public Persona editPersona(@RequestBody Persona persona){
    
        ipersonaService.savePersona(persona);
        return persona;
    }

    

    @PutMapping("/personas/editar/{id}")
    public Persona editPersona(@PathVariable Long id, 
    @RequestParam("prsNombre") String nuevoNombre,
    @RequestParam("prsApellido") String nuevoApellido,
    @RequestParam("prsEdad") String nuevoEdad,
    @RequestParam("prsOcupacion") String nuevoOcupacion,
    @RequestParam("prsAcercaDeMi") String nuevoAcercaDeMi,
    @RequestParam("prsImgPerfilUrl") String nuevoImgPerfilUrl,
    @RequestParam("prsImgPortadaUrl") String nuevoImgPortadoUrl 
    ){
       Persona persona = ipersonaService.findPersona(id);
       persona.setPrsNombre(nuevoNombre);
       persona.setPrsApellido(nuevoApellido);
       persona.setPrsEdad(Integer.parseInt(nuevoEdad));
       persona.setPrsOcupacion(nuevoOcupacion);
       persona.setPrsAcercaDeMi(nuevoAcercaDeMi);
       persona.setPrsImgPerfilUrl(nuevoImgPerfilUrl);
       persona.setPrsImgPortadaUrl(nuevoImgPortadoUrl);

       ipersonaService.savePersona(persona);
       
       return persona;     

    }

    @GetMapping("/personas/traer/{id}")
    public Persona findPersona(Long id){
        return ipersonaService.findPersona(id);
    }

    @DeleteMapping("/personas/borrar/{id}")
    public String deletePersona(@PathVariable Long id){
        ipersonaService.deletePersona(id);
        return "Se elimino persona con exito";
    }

    


}
