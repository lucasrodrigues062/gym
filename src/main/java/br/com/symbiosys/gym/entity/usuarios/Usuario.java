package br.com.symbiosys.gym.entity.usuarios;


import lombok.Data;


import javax.persistence.*;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;



@Data
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Usuario implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idUsuario;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String senha;

    @Column(nullable = false)
    private final LocalDateTime dataCadastro = LocalDateTime.now();


    public Usuario(String nome, String email, String senha){
        this.nome = nome;
        this.senha = criptografarSenha(senha);
        this.email = email;

    }

    @Deprecated
    public Usuario() {

    }

    public String  criptografarSenha(String senha) {

        try {
            MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
            byte messageDigest[] = algorithm.digest(senha.getBytes("UTF-8"));

            StringBuilder hexString = new StringBuilder();
            for (byte b : messageDigest) {
                hexString.append(String.format("%02X", 0xFF & b));
            }
            String senhahex = hexString.toString();

            System.out.println(senhahex);

            return senhahex;


        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean verificaSenha(String senha){

        String hexSenha = criptografarSenha(senha);
        return hexSenha.equals(this.senha);
    }

}
