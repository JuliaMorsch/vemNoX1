package br.sc.senac.vemnox1.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.sc.senac.vemnox1.model.entity.CartaNaPartidaPk;

@Repository
public interface CartaNaPartidaRepository extends JpaRepository<CartaNaPartidaRepository, CartaNaPartidaPk>, JpaSpecificationExecutor<CartaNaPartidaRepository> {
    
    // Usado @Query porque permite personalizar minha consulta JPQL
    @Query("SELECT cp FROM CartaNaPartida cp WHERE cp.partida.id = :idPartida AND cp.carta.id = :idCarta")
    CartaNaPartidaRepository findByJogador(int idPartida, int idCarta);
}
