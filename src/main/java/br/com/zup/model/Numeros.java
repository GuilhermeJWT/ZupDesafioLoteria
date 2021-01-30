package br.com.zup.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
public class Numeros implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "Os Números do Sorteio não podem ser vázios")
    @Column(unique = true)
    private String numero_aleatorio;

    @JsonIgnore
    @org.hibernate.annotations.ForeignKey(name = "pessoa_id")
    @ManyToOne(optional = false)
    private Pessoa pessoa;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero_aleatorio() {
        return numero_aleatorio;
    }

    public void setNumero_aleatorio(String numero_aleatorio) {
        this.numero_aleatorio = numero_aleatorio;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}
