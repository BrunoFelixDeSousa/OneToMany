package br.com.bfelix.onetomany.controllers;

import br.com.bfelix.onetomany.DTO.PessoaDTO;
import br.com.bfelix.onetomany.entities.Endereco;
import br.com.bfelix.onetomany.entities.Pessoa;
import br.com.bfelix.onetomany.services.PessoaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
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

        return ResponseEntity.status(HttpStatus.OK).body(pessoa);
    }

}
