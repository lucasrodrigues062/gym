package br.com.symbiosys.gym.entity.exercicios;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Data
public class Grupo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nomeGrupo;

    private final LocalDateTime dataCadastro;

    @OneToMany
    List<Musculo> musculos;

    public Grupo(String nomeGrupo) {
        this.nomeGrupo = nomeGrupo;
        this.dataCadastro = LocalDateTime.now();
    }

    @Deprecated
    private Grupo(){this.dataCadastro = LocalDateTime.now();};
}
