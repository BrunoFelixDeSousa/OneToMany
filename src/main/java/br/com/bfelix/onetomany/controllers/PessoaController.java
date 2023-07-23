package br.com.bfelix.onetomany.controllers;

import br.com.bfelix.onetomany.DTO.PessoaDTO;
import br.com.bfelix.onetomany.entities.Pessoa;
import br.com.bfelix.onetomany.services.PessoaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    private final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @PostMapping
    public ResponseEntity<Object> CriarPessoa(@RequestBody PessoaDTO pessoaDTO) {

        Pessoa pessoa = pessoaService.salvarPessoaComEndereco(pessoaDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(pessoa);
    }

    @GetMapping
    public ResponseEntity<List<PessoaDTO>> listarPessoas() {

        List<PessoaDTO> pessoasDTO = pessoaService.listarPessoaComEndereco();

        return ResponseEntity.status(HttpStatus.OK).body(pessoasDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaDTO> pegarPessoa(@PathVariable("id") Long id) {

        PessoaDTO pessoaDTO = pessoaService.pegarPessoaComEndereco(id);

        return ResponseEntity.status(HttpStatus.OK).body(pessoaDTO);
    }

}
