package br.com.symbiosys.gym.entity.usuarios;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity
public class Profissional extends Usuario {

    private static final long serialVersionUID = 1L;
    @OneToMany
    private List<Aluno> alunos;

    public Profissional(String nome, String email, String senha) {
        super(nome, email, senha);
    }
}
