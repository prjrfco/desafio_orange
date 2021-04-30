package br.com.desafio.orange.dto;

import br.com.desafio.orange.model.Usuario;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UsuarioDTO {

    private String nome;

    private String email;

    private String cpf;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    private List<EnderecoDTO> enderecos;

    public UsuarioDTO(Usuario usuario) {
        setNome(usuario.getNome());
        setEmail(usuario.getEmail());
        setCpf(usuario.getCpf());
        setDataNascimento(usuario.getDataNascimento());
        if (usuario.getEnderecos()!=null){
            setEnderecos(usuario.getEnderecos().stream().map(EnderecoDTO::new).collect(Collectors.toList()));
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public List<EnderecoDTO> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<EnderecoDTO> enderecos) {
        this.enderecos = enderecos;
    }
}
