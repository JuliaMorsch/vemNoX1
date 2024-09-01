package br.sc.senac.vemnox1.model.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table
@Data
public class Carta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @NotBlank(message = "O campo nome deve estar preenchido.")
    @Size(min = 3, max = 255)
    private String nome;

    private int forca;
    private int inteligencia;
    private int velocidade;

    @CreationTimestamp
    private LocalDate dataCadastro;
    
}
