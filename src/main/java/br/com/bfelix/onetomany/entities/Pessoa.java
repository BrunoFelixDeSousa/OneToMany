package br.com.bfelix.onetomany.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "pessoas")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    // Relacionamento bidirecional com a entidade "Endereco"
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "pessoa_id")
    private List<Endereco> enderecos = new ArrayList<>();

    public void adicionarEndereco(Endereco endereco) {
        enderecos.add(endereco);
    }
}
