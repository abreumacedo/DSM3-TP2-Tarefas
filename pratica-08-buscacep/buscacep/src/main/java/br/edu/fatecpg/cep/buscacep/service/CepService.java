package br.edu.fatecpg.cep.buscacep.service;

import br.edu.fatecpg.cep.buscacep.model.Endereco;
import br.edu.fatecpg.cep.buscacep.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CepService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    private final RestTemplate restTemplate = new RestTemplate();

    public Endereco consultarCep(String cep) {
        if (enderecoRepository.existsByCep(cep)) {
            return null;
        }

        String url = "https://viacep.com.br/ws/" + cep + "/json/";
        Endereco endereco = restTemplate.getForObject(url, Endereco.class);

        if (endereco != null) {
            enderecoRepository.save(endereco);
        }

        return endereco;
    }

    public List<Endereco> listarTodos() {
        return enderecoRepository.findAll();
    }
}
