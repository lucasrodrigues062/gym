package br.com.symbiosys.gym.entity.exercicios;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class Musculo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(unique = true)
    private String nome;

    private final LocalDateTime dataCadastro;

    @Deprecated
    private Musculo(){
        this.dataCadastro = LocalDateTime.now();
    }

    public Musculo(String nome) {
        this.nome = nome;
        this.dataCadastro = LocalDateTime.now();
    }
}
