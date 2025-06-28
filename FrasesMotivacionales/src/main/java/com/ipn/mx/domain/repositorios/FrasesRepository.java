package com.ipn.mx.domain.repositorios;

import java.util.Optional; // <-- Importación nueva
import org.springframework.data.jpa.repository.Query; // <-- Importación nueva
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.ipn.mx.domain.entidades.Frases;

@Repository
public interface FrasesRepository extends CrudRepository<Frases, Long> {
    
    /**
     * Selecciona una fila aleatoria de la tabla Frases.
     * Nota: ORDER BY RAND() puede ser lento en tablas muy grandes, 
     * pero es perfecto para este caso de uso.
     */
    @Query(value = "SELECT * FROM Frases ORDER BY RANDOM() LIMIT 1", nativeQuery = true)
    Optional<Frases> findRandomFrase(); 
}  