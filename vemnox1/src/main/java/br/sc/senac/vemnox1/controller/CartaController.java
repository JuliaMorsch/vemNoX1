package br.sc.senac.vemnox1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import br.sc.senac.vemnox1.exception.VemNoX1Exception;
import br.sc.senac.vemnox1.model.entity.Carta;
import br.sc.senac.vemnox1.service.CartaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/api/cartas")
public class CartaController {

    @Autowired
    private CartaService cartaService;

    @Operation(summary = "Inserir nova carta.", 
                description = "Adiciona uma nova carta ao sistema.", 
                responses = {
                    // @Content, @Schema, e @ExampleObject
                    @ApiResponse(responseCode = "201", description = "Carta criada com sucesso.",
                        content = @Content(mediaType = "application/json", 
                        schema = @Schema(implementation = Carta.class))),
                    @ApiResponse(responseCode = "400", description = "Erro de validação ou regra de negócio", 
                        content = @Content(mediaType = "application/json", 
                        examples = @ExampleObject(value = "{\"message\": \"Erro de validação: campo X é obrigatório\", \"status\": 400}")))
                })

    @PostMapping    
    public ResponseEntity<Carta> save(@Valid @RequestBody Carta carta) {
        try {
            Carta cartaSalva = cartaService.save(carta);
            return new ResponseEntity(cartaSalva, HttpStatus.CREATED);
        } catch (VemNoX1Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @Operation(summary = "Pesquisa carta por ID.",
                description = "Busca uma carta específica pelo seu ID.")
    @GetMapping(path = "/{id}")
    public ResponseEntity<Carta> findById(@PathVariable int id) throws VemNoX1Exception {
        Carta carta = cartaService.findById(id);
        return ResponseEntity.ok(carta);
    }

    @Operation(summary = "Lista todas as cartas.",
                description = "Retorna uma lista de todas as cartas cadastradas no sistema.",
                responses = {
                            @ApiResponse(responseCode = "200", description = "Lista de cartas retornada com sucesso.")
                    })
    @GetMapping
    public List<Carta> listAll(){
        List<Carta> cartas = cartaService.listAll();
        return cartas;
    }

    @Operation(summary = "Atualizar carta existente.", 
                description = "Atualiza os dados de uma carta com base no seu ID.")
    @PutMapping
    public ResponseEntity<Carta> update(@Valid @RequestBody Carta carta) throws VemNoX1Exception {
        return ResponseEntity.ok(cartaService.update(carta));
    }
}
