package com.ipn.mx.service;

import com.ipn.mx.domain.entidades.Frases;
import java.util.List;
import java.util.Optional;

public interface FrasesService {
    public List<Frases> readall();
    public Frases FindById(long idFrase);
    public Frases save(Frases frase);
    public void delete(long idFrase);

    public Frases fraseAleatoria(List<Frases> listaFrases);
    Optional<Frases> findRandom();

    // Añade esta línea a la interfaz
    public List<Frases> saveAll(List<Frases> frases);

} 