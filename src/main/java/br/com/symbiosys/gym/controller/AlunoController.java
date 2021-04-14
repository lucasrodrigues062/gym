package br.com.symbiosys.gym.controller;


import br.com.symbiosys.gym.entity.usuarios.Aluno;
import br.com.symbiosys.gym.service.AlunoService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller

public class AlunoController {

    private AlunoService alunoService;

    public AlunoController(AlunoService alunoService){
        this.alunoService = alunoService;
    }


    @PostMapping("/aluno/novo")
    public ResponseEntity<Aluno> cadastrarAluno(@RequestBody Aluno aluno)  {

        Aluno alunoCadastrado = this.alunoService.cadastrar(aluno);
        alunoCadastrado.setSenha("* * * * *");
        if(alunoCadastrado != null) return ResponseEntity.ok().body(aluno);

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/aluno")
    public ResponseEntity<Aluno> encontrarAluno(@RequestParam(name = "id",required = false) Long id, @RequestParam(name = "email", required = false) String email){

        if(id != null) {

            try {
                Aluno aluno = this.alunoService.encontrarPorId(id);
                aluno.setSenha("* * * * *");

                return ResponseEntity.ok().body(aluno);
            } catch (Exception e) {

                System.out.println("Id nao encontrado");
                return ResponseEntity.notFound().build();
            }
        }
        if (email != null) {
            try {
                Aluno aluno = this.alunoService.encontrarPorEmail(email);
                aluno.setSenha("* * * * *");

                return ResponseEntity.ok().body(aluno);
            } catch (Exception e) {

                System.out.println("Email nao encontrado");
                return ResponseEntity.notFound().build();
            }
        }

        return ResponseEntity.notFound().build();

    }

}
