package br.com.desafio.orange.dto;

import br.com.desafio.orange.model.Endereco;

public class EnderecoDTO {

    private String cep;

    private String logradouro;

    private String complemento;

    private String bairro;

    private String cidade;

    private String estado;

    private String numero;

    public EnderecoDTO(Endereco enderecos) {
        setCep(enderecos.getCep());
        setLogradouro(enderecos.getLogradouro());
        setComplemento(enderecos.getComplemento());
        setBairro(enderecos.getBairro());
        setCidade(enderecos.getCidade());
        setEstado(enderecos.getEstado());
        setNumero(enderecos.getNumero());
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
