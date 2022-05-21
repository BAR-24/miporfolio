package com.miporfoliobackend.bar.services;

import java.util.List;

import com.miporfoliobackend.bar.models.Persona;

public interface IPersonaService {
    //Traer Personas
    public List<Persona> getPersonas();
    
    //Traer Persona
    public Persona findPersona(long id);

    //Guardar Persona
    public void savePersona(Persona persona);

    //Borra Persona
    public void deletePersona(long id);



}
