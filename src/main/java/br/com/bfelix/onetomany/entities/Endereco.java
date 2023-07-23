package br.com.bfelix.onetomany.entities;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "enderecos")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String rua;
    private String numero;
    private String cidade;

    // Relacionamento bidirecional com a entidade "Pessoa"
//    @ManyToOne
//    @JoinColumn(name = "pessoa_id")
//    private Pessoa pessoa;
}
