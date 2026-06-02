package br.com.alunoonline.api.controller;

import br.com.alunoonline.api.model.Aluno;
import br.com.alunoonline.api.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController          // "Esta classe é um controller REST!"
@RequestMapping("/alunos")  // URL base: /alunos
public class AlunoController {

    @Autowired
    AlunoService alunoService;

    @PostMapping                     // POST /alunos
    @ResponseStatus(HttpStatus.CREATED)  // Retorna 201
    public void criarAluno(@RequestBody Aluno aluno) {
        alunoService.criarAluno(aluno);
    }

    @GetMapping                      // GET /alunos
    @ResponseStatus(HttpStatus.OK)
    public List<Aluno> listarTodosAlunos() {
        return alunoService.listarTodosAlunos();
    }

    @GetMapping("/{id}")              // GET /alunos/1
    @ResponseStatus(HttpStatus.OK)
    public Optional<Aluno> buscarAlunoPorId(@PathVariable Long id) {
        return alunoService.buscarAlunoPorId(id);
    }

    @PutMapping("/{id}")              // PUT /alunos/1
    @ResponseStatus(HttpStatus.NO_CONTENT)  // 204
    public void atualizarAlunoPorId(@PathVariable Long id,
                                    @RequestBody Aluno aluno) {
        alunoService.atualizarAlunoPorId(id, aluno);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarAlunoPorId(@PathVariable Long id) {
        alunoService.deletarAlunoPorId(id);
    }
}