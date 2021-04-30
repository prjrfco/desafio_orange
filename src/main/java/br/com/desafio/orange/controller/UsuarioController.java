package br.com.desafio.orange.controller;

import br.com.desafio.orange.dto.UsuarioDTO;
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
        return new UsuarioDTO(usuarioRepository.findById(id).get());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioDTO save(@RequestBody Usuario usuario) {
        return new UsuarioDTO(usuarioRepository.save(usuario));
    }

}
