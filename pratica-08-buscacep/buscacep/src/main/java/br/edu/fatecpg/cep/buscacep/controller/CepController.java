package br.edu.fatecpg.cep.buscacep.controller;

import br.edu.fatecpg.cep.buscacep.model.Endereco;
import br.edu.fatecpg.cep.buscacep.service.CepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ceps")
public class CepController {

    @Autowired
    private CepService cepService;

    @GetMapping("/{cep}")
    public ResponseEntity<Endereco> consultarCep(@PathVariable String cep) {
        Endereco endereco = cepService.consultarCep(cep);
        if (endereco == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(endereco);
    }

    @GetMapping
    public List<Endereco> listarTodos() {
        return cepService.listarTodos();
    }
}

