package br.com.desafio.orange.controller;

import br.com.desafio.orange.dto.UsuarioDTO;
import br.com.desafio.orange.exceptionhandler.exception.EntidadeNaoEncontradaException;
import br.com.desafio.orange.exceptionhandler.exception.NegocioException;
import br.com.desafio.orange.model.Usuario;
import br.com.desafio.orange.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UsuarioDTO findAllByUsuarioId(@PathVariable Long id) {

        if (usuarioRepository.findById(id).isEmpty()){
            throw new EntidadeNaoEncontradaException("Usuário não encontrado!");
        }

        return new UsuarioDTO(usuarioRepository.findById(id).get());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioDTO save(@Valid @RequestBody Usuario usuario) {

        if (usuarioRepository.findByEmail(usuario.getEmail()) != null) {
            throw new NegocioException("Email já cadastrado!");
        }

        if (usuarioRepository.findByCpf(usuario.getCpf()) != null) {
            throw new NegocioException("CPF já cadastrado!");
        }

        return new UsuarioDTO(usuarioRepository.save(usuario));
    }

}
