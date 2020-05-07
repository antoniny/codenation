package br.com.codenation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Time {
    private Long id;
    private String nome;
    private LocalDate dataCriacao;
    private String corUniformePrincipal;
    private String corUniformeSecundario;
    private Long idJogadorCapitao;
    private List<Jogador> jogadores = new ArrayList<>();

    public Time(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) throws UnsupportedOperationException {
        this.id = validaIdTime(id);
        this.nome = validaNomeTime(nome);
        this.dataCriacao = validaData(dataCriacao);
        this.corUniformePrincipal = validaCorUniformeUm(corUniformePrincipal);
        this.corUniformeSecundario = validaCorUniformeDois(corUniformeSecundario);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = validaIdTime(id);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = validaNomeTime(nome);
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = validaData(dataCriacao);
    }

    public String getCorUniformePrincipal() {
        return corUniformePrincipal;
    }

    public void setCorUniformePrincipal(String corUniformePrincipal) {
        this.corUniformePrincipal = validaCorUniformeUm(corUniformePrincipal);
    }

    public String getCorUniformeSecundario() {
        return corUniformeSecundario;
    }

    public void setCorUniformeSecundario(String corUniformeSecundario) {
        this.corUniformeSecundario = validaCorUniformeDois(corUniformeSecundario);
    }

    public Long getIdJogadorCapitao() {
        return idJogadorCapitao;
    }

    public void setIdJogadorCapitao(Long idJogadorCapitao) {
        this.idJogadorCapitao = idJogadorCapitao;
    }

    private Long validaIdTime (Long idTime) throws UnsupportedOperationException {
        if (idTime == null) {
            throw new UnsupportedOperationException("Id do time não pode ser nulo.");
        };

        return  idTime;
    }

    private String validaNomeTime (String nomeTime) throws UnsupportedOperationException {
        if ( nomeTime == null || nomeTime.trim().isEmpty()) {
            throw new UnsupportedOperationException("Nome do time deve ser informado.");
        };
        return  nomeTime;
    }

    private LocalDate validaData(LocalDate dataTime) throws UnsupportedOperationException {
        if (dataTime == null) {
            throw new UnsupportedOperationException("Data de Criaçao do time não pode ser nulo.");
        };
        return  dataTime;
    }

    private String validaCorUniformeUm (String uniforme) throws UnsupportedOperationException {
        if (uniforme == null || uniforme.trim().isEmpty()) {
            throw new UnsupportedOperationException("Cor do Uniforme Um deve ser informada.");
        };
        return  uniforme;
    }

    private String validaCorUniformeDois (String uniforme) throws UnsupportedOperationException {
        if (uniforme == null || uniforme.trim().isEmpty()) {
            throw new UnsupportedOperationException("Cor do Uniforme Dois deve ser informada.");
        };
        return  uniforme;
    }

    @Override
    public String toString() {
        return "TimeFutebol{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", dataCriacao=" + dataCriacao +
                ", corUniformePrincipal='" + corUniformePrincipal + '\'' +
                ", corUniformeSecundario='" + corUniformeSecundario + '\'' +
                ", idJogadorCapitao=" + idJogadorCapitao +
                ", jogadores=" + jogadores +
                '}';
    }

    public void registrarJogador(Jogador jogador){
        this.jogadores.add(jogador);
    }

    public List<Jogador> getListJogadores(){
        return jogadores;
    }

    public List<Long> getListIdJogadores(){
        List<Long> listIdJogadores = new ArrayList<>();
        for (Jogador jogador: jogadores) {
           listIdJogadores.add(jogador.getId());
        }
        return listIdJogadores;
    }


}
