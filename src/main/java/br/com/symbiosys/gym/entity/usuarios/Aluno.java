package br.com.symbiosys.gym.entity.usuarios;


import lombok.Data;


import javax.persistence.Entity;


@Data
@Entity
public class Aluno extends Usuario{

    private static final long serialVersionUID = 1L;

    private Double peso;

    private Double altura;

    public Aluno(String nome, String email, String senha, Double peso, Double altura) {
        super(nome, email, senha);
        this.peso = peso;
        this.altura = altura;
    }
    @Deprecated
    private Aluno(){
        super();

    }
}
