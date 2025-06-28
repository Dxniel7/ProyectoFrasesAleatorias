package com.ipn.mx.infrastructure;

import java.util.List;
import java.util.Optional; // <-- Importación para el manejo de opcionales
import jakarta.validation.Valid; // <-- Importación para activar la validación

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.ipn.mx.domain.entidades.Frases;
import com.ipn.mx.service.FrasesService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class FrasesController {
    
    @Autowired
    private FrasesService service;

    /**
     * Endpoint para OBTENER TODAS las frases.
     */
    @GetMapping("/frases")
    public List<Frases> getAllFrases() {
        return service.readall();
    }

    /**
     * Endpoint para OBTENER UNA frase por su ID.
     */
    @GetMapping("/frases/{idFrase}")
    public Frases read(@PathVariable long idFrase) {
        return service.FindById(idFrase);
    }

    /**
     * Endpoint para CREAR una nueva frase (con validación).
     */
    @PostMapping("/frases")
    @ResponseStatus(HttpStatus.CREATED)
    public Frases create(@Valid @RequestBody Frases frase) { // <-- CAMBIO: Se añadió @Valid
        return service.save(frase);
    }

    /**
     * Endpoint para CREAR un lote de frases nuevas (con validación).
     */
    @PostMapping("/frases/lote")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Frases> createMultiple(@Valid @RequestBody List<Frases> frases) { // <-- CAMBIO: Se añadió @Valid
        return service.saveAll(frases);
    }

    /**
     * Endpoint para ACTUALIZAR una frase (con validación).
     */
    @PutMapping("/frases/{idFrase}")
    public Frases update(@PathVariable long idFrase, @Valid @RequestBody Frases frase) { // <-- CAMBIO: Se añadió @Valid
        frase.setId(idFrase); 
        return service.save(frase);
    }

    /**
     * Endpoint para ELIMINAR una frase.
     */
    @DeleteMapping("/frases/{idFrase}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long idFrase) {
        service.delete(idFrase);
    }

    /**
     * Endpoint para OBTENER UNA frase ALEATORIA de forma eficiente.
     */
    @GetMapping("/frases/aleatoria")
    public ResponseEntity<Frases> getFraseAleatoria() {
        // --- CAMBIO: Lógica completamente nueva y optimizada ---
        Optional<Frases> fraseOptional = service.findRandom();

        if (fraseOptional.isPresent()) {
            return ResponseEntity.ok(fraseOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
} 