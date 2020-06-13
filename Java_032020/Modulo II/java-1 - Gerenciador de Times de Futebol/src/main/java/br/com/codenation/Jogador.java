package br.com.codenation;

import java.math.BigDecimal;
import java.text.Format;
import java.time.LocalDate;

public class Jogador {

    private Long id;
    private Long idTime;
    private String nome;
    private LocalDate dataNascimento;
    private Integer nivelHabilidade;
    private BigDecimal salario;
    private final Integer MIN_HABILIDADE = 0;
    private final Integer MAX_HABILIDADE = 100;

    public Jogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {
        this.id = validaId(id);
        this.idTime = validaIdTime(idTime);
        this.nome = validaNome(nome);
        this.dataNascimento = validaDataNasc(dataNascimento);
        this.nivelHabilidade = validaHabilidade(nivelHabilidade);
        this.salario = validaSalario(salario);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = validaId(id);
    }

    public Long getIdTime() {
        return idTime;
    }

    public void setIdTime(Long idTime) {
        this.idTime = validaIdTime(idTime);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = validaNome(nome);
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = validaDataNasc(dataNascimento);
    }

    public Integer getNivelHabilidade() {
        return nivelHabilidade;
    }

    public void setNivelHabilidade(Integer nivelHabilidade) {
        this.nivelHabilidade = validaHabilidade(nivelHabilidade);
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = validaSalario(salario);
    }


    @Override
    public String toString() {
        return "JogadorFutebol{" +
                "id=" + id +
                ", idTime=" + idTime +
                ", nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", nivelHabilidade=" + nivelHabilidade +
                ", salario=" + salario +
                '}';
    }

    private Long validaId(Long idJogador) throws UnsupportedOperationException {
       if (idJogador == null){
           throw new UnsupportedOperationException("Obrigatório informar o id do jogador.");
       }
       return  idJogador;
    }

    private Long validaIdTime(Long idTime) throws UnsupportedOperationException {
        if (idTime == null){
            throw new UnsupportedOperationException("Obrigatório informar o id do time.");
        }
        return  idTime;
    }

    private String validaNome(String nomeJogador) throws UnsupportedOperationException {
        if (nomeJogador == null || nomeJogador.trim().isEmpty()){
            throw new UnsupportedOperationException("Obrigatório informar o nome do jogador.");
        }
        return  nomeJogador;
    }

    private LocalDate validaDataNasc(LocalDate dataNascJogador) throws UnsupportedOperationException {
        if (dataNascJogador == null){
            throw new UnsupportedOperationException("Obrigatório informar a data de nascimento.");
        }
        return  dataNascJogador;
    }

   private Integer validaHabilidade(Integer habilidade) throws UnsupportedOperationException {
       if(habilidade == null || habilidade < MIN_HABILIDADE || habilidade > MAX_HABILIDADE){
           throw new UnsupportedOperationException(String.format("Valor permitido para habilidade é de %d até %d.",MIN_HABILIDADE,MAX_HABILIDADE));
       }
       return habilidade;
    }

    private BigDecimal validaSalario(BigDecimal salarioJogador) throws UnsupportedOperationException {
        if (salarioJogador == null){
            throw new UnsupportedOperationException("Obrigatório informar o salário do jogador.");
        }
        return  salarioJogador;
    }
}
