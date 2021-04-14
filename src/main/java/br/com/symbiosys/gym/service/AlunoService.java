package br.com.symbiosys.gym.service;

import br.com.symbiosys.gym.entity.usuarios.Aluno;
import br.com.symbiosys.gym.repository.usuarios.AlunoRepository;
import org.springframework.stereotype.Service;



@Service
public class AlunoService {


    private AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository){
        this.alunoRepository = alunoRepository;
    }

    public Aluno cadastrar(Aluno aluno) {


           return this.alunoRepository.save(aluno);


    }

    public Aluno encontrarPorId(Long id) throws Exception {

        return (Aluno) alunoRepository.findById(id).orElseThrow(Exception::new);
    }


    public Aluno encontrarPorEmail(String email) throws Exception {
        return (Aluno) alunoRepository.findByEmail(email).orElseThrow(Exception::new);
    }



}
