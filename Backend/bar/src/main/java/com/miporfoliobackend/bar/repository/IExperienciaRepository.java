package com.miporfoliobackend.bar.repository;

import com.miporfoliobackend.bar.models.Experiencia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExperienciaRepository extends JpaRepository<Experiencia, Long>{
    
}
