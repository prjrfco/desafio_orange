package br.com.desafio.orange.controller;

import br.com.desafio.orange.dto.EnderecoDTO;
import br.com.desafio.orange.exceptionhandler.exception.EntidadeNaoEncontradaException;
import br.com.desafio.orange.exceptionhandler.exception.NegocioException;
import br.com.desafio.orange.feignService.Cep;
import br.com.desafio.orange.feignService.CepService;
import br.com.desafio.orange.model.Endereco;
import br.com.desafio.orange.model.Usuario;
import br.com.desafio.orange.repository.EnderecoRepository;
import br.com.desafio.orange.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    private final UsuarioRepository usuarioRepository;

    private final CepService cepService;

    private final EnderecoRepository enderecoRepository;

    public EnderecoController(EnderecoRepository enderecoRepository, CepService cepService, UsuarioRepository usuarioRepository) {
        this.enderecoRepository = enderecoRepository;
        this.cepService = cepService;
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EnderecoDTO save(@Valid @RequestBody Endereco endereco) {

        if (endereco.getCep().length()!=8){
            throw new NegocioException("Cep deve ter 8 números.");
        }

        if (cepService.getCep(endereco.getCep()).getCep()==null) {
            throw new EntidadeNaoEncontradaException("Cep não encontrado!");
        }

        Cep cep = cepService.getCep(endereco.getCep());

        endereco.setCep(cep.getCep());
        endereco.setLogradouro(cep.getLogradouro());
        endereco.setComplemento(cep.getComplemento());
        endereco.setBairro(cep.getBairro());
        endereco.setCidade(cep.getLocalidade());
        endereco.setEstado(cep.getUf());

        if (usuarioRepository.findById(endereco.getUsuario().getId()).isEmpty()) {
            throw new EntidadeNaoEncontradaException("Usuário não encontrado");
        }

        Optional<Usuario> usuario = usuarioRepository.findById(endereco.getUsuario().getId());

        endereco.setUsuario(usuario.get());

        return new EnderecoDTO(enderecoRepository.save(endereco));
    }

}
