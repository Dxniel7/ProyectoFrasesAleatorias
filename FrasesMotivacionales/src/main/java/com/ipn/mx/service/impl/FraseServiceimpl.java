package com.ipn.mx.service.impl;

import com.ipn.mx.domain.entidades.Frases;
import com.ipn.mx.domain.repositorios.FrasesRepository;
import com.ipn.mx.service.FrasesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class FraseServiceimpl implements FrasesService {
    
    @Autowired
    private FrasesRepository dao;

    @Override
    public List<Frases> readall() {
        return (List<Frases>) dao.findAll();
    }

    @Override
    public Frases FindById(long idFrase) {
        return dao.findById(idFrase).orElse(null);
    }

    @Override
    public Frases save(Frases frase) {
        return dao.save(frase);
    } 

    @Override
    public void delete(long idFrase) {
        dao.deleteById(idFrase);
    }

    @Override
    public Frases fraseAleatoria(List<Frases> listaFrases) {
        int randomIndex = (int) (Math.random() * listaFrases.size());
        return listaFrases.get(randomIndex);
    }

    // Añade este método completo a la clase
    @Override
    public List<Frases> saveAll(List<Frases> frases) {
        return (List<Frases>) dao.saveAll(frases);
    }

    // Añade este método
    @Override
    public Optional<Frases> findRandom() {
        return dao.findRandomFrase();
    }
}
