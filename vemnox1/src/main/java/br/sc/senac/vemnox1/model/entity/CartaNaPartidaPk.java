package br.sc.senac.vemnox1.model.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

// Classe com Chave Composta

@Embeddable
public class CartaNaPartidaPk implements Serializable {
    @Column(name = "id_carta")
    Integer idCarta;

    @Column(name = "id_partida")
    Integer idPartida;

}
