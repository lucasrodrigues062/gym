package br.com.symbiosys.gym.entity.exercicios;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Exercicio {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String nome;

    private final LocalDateTime dataCadastro;


    @ManyToMany
    private List<Musculo> musculos;


    @Deprecated
    private Exercicio(){this.dataCadastro = LocalDateTime.now();}

    public Exercicio(String nome, List<Musculo> musculos) {
        this.nome = nome;
        this.musculos = musculos;
        this.dataCadastro = LocalDateTime.now();
    }
}
