package br.com.symbiosys.gym.repository.usuarios;


import br.com.symbiosys.gym.entity.usuarios.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public abstract interface UserRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String email);

}
