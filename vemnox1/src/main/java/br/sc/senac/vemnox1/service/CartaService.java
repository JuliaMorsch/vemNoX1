package br.sc.senac.vemnox1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.sc.senac.vemnox1.model.entity.Carta;
import br.sc.senac.vemnox1.model.repository.CartaRepository;

@Service
public class CartaService {

    @Autowired
    private CartaRepository cartaRepository;
    
    public List<Carta> listAll() {
        return cartaRepository.findAll();
    }

}
