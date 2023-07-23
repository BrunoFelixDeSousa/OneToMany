package br.com.bfelix.onetomany.services;

import br.com.bfelix.onetomany.DTO.EnderecoDTO;
import br.com.bfelix.onetomany.DTO.PessoaDTO;
import br.com.bfelix.onetomany.entities.Endereco;
import br.com.bfelix.onetomany.entities.Pessoa;
import br.com.bfelix.onetomany.repositories.EnderecoRepository;
import br.com.bfelix.onetomany.repositories.PessoaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;
    private final EnderecoRepository enderecoRepository;

    public PessoaService(PessoaRepository pessoaRepository, EnderecoRepository enderecoRepository) {
        this.pessoaRepository = pessoaRepository;
        this.enderecoRepository = enderecoRepository;
    }

    @Transactional
    public Pessoa salvarPessoaComEndereco(PessoaDTO pessoaDTO) {

        Pessoa pessoa = new Pessoa();
        pessoa.setNome(pessoaDTO.getNome());
        System.out.println(pessoaDTO.getEnderecos());
        List<Endereco> enderecos = new ArrayList<>();
        if (pessoaDTO.getEnderecos() != null) {
            for (EnderecoDTO enderecoDTO : pessoaDTO.getEnderecos()) {
                Endereco endereco = new Endereco();
                endereco.setRua(enderecoDTO.getRua());
                endereco.setNumero(enderecoDTO.getNumero());
                endereco.setCidade(enderecoDTO.getCidade());

                enderecos.add(endereco);
            }
        }

        pessoa.setEnderecos(enderecos);
        pessoaRepository.save(pessoa);

        return pessoa;
    }

    public List<PessoaDTO> listarPessoaComEndereco() {

        List<Pessoa> pessoas = pessoaRepository.findAll();
        List<PessoaDTO> pessoasDTO = new ArrayList<>();

        for (Pessoa pessoa : pessoas) {
            PessoaDTO pessoaDTO = new PessoaDTO();
            pessoaDTO.setNome(pessoa.getNome());

            List<EnderecoDTO> enderecoDTOS = new ArrayList<>();
            for (Endereco endereco : pessoa.getEnderecos()) {
                EnderecoDTO enderecoDTO = new EnderecoDTO();
                enderecoDTO.setRua(endereco.getRua());
                enderecoDTO.setNumero(endereco.getNumero());
                enderecoDTO.setCidade(endereco.getCidade());
                enderecoDTOS.add(enderecoDTO);
            }

            pessoaDTO.setEnderecos(enderecoDTOS);
            pessoasDTO.add(pessoaDTO);
        }

        return pessoasDTO;
    }
}
