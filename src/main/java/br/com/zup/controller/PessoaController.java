package br.com.zup.controller;

import br.com.zup.model.Pessoa;
import br.com.zup.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping(value = "/sorteio")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @PostMapping(value = "/cadastro", produces = "application/json")
    public ResponseEntity<Pessoa> salvarPessoaSorteio(@RequestBody @Valid Pessoa pessoa){

         for (int posicao = 0; posicao < pessoa.getNumeros().size(); posicao++){
            pessoa.getNumeros().get(posicao).setPessoa(pessoa);
        }

        Pessoa pessoaSorteio = pessoaRepository.save(pessoa);

        return new ResponseEntity<Pessoa>(pessoaSorteio, HttpStatus.OK);

    }

    @GetMapping(value = "/{email}", produces = "application/json")
    public ResponseEntity<Pessoa> listarPessoaSorteio(@PathVariable (value = "email") String email ) {

        Optional<Pessoa> pessoa = pessoaRepository.findUserByEmail(email);

        return new ResponseEntity<Pessoa>(pessoa.get(), HttpStatus.OK);

    }

}
