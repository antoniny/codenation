package br.com.codenation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import br.com.codenation.desafio.annotation.Desafio;
import br.com.codenation.desafio.app.MeuTimeInterface;
import br.com.codenation.desafio.exceptions.CapitaoNaoInformadoException;
import br.com.codenation.desafio.exceptions.JogadorNaoEncontradoException;
import br.com.codenation.desafio.exceptions.TimeNaoEncontradoException;
import br.com.codenation.desafio.exceptions.IdentificadorUtilizadoException;

public class DesafioMeuTimeApplication implements MeuTimeInterface {

	private  List<Time> timesList = new ArrayList<>();


	private final String IDENTIFICADOR_UTILIZADO_EXCEPTION = "IdentificadorUtilizadoException";
	private final String TIME_NAO_ENCONTRADO_EXCEPTION = "TimeNaoEncontradoException";
	private final String JOGADOR_NAO_ENCONTRADO_EXCEPTION = "JogadorNaoEncontradoException";
	private final String CAPITAO_NAO_INFORMADO_EXCEPTION = "CapitaoNaoInformadoException";
	private final String UNSUPPORTED_OPERATION_EXCEPTION = "UnsupportedOperationException";


	@Desafio("incluirTime")
	public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {

		timesList.add(new Time(validaTimeExiste(id), nome, dataCriacao, corUniformePrincipal, corUniformeSecundario));

	}

    @Desafio("incluirJogador")
	public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {

		getTimeValido(idTime).registrarJogador(new Jogador(validaJogadorExiste(id), idTime, nome, dataNascimento, nivelHabilidade, salario));

	}

	@Desafio("definirCapitao")
	public void definirCapitao(Long idJogador) {

		getTimeValido(getJogadorValido(idJogador).getIdTime()).setIdJogadorCapitao(idJogador);

	}

	@Desafio("buscarCapitaoDoTime")
	public Long buscarCapitaoDoTime(Long idTime) {

		if (getTimeValido(idTime).getIdJogadorCapitao() == null){
			gerarException(CAPITAO_NAO_INFORMADO_EXCEPTION,String.format("O Time informado está sem capitão. [%s]",idTime));
		}

		return getTimeValido(idTime).getIdJogadorCapitao();
	}

	@Desafio("buscarNomeJogador")
	public String buscarNomeJogador(Long idJogador) {

		return getJogadorValido(idJogador).getNome();

	}

	@Desafio("buscarNomeTime")
	public String buscarNomeTime(Long idTime) {

		return getTimeValido(idTime).getNome();

	}

	@Desafio("buscarJogadoresDoTime")
	public List<Long> buscarJogadoresDoTime(Long idTime) {

		return getTimeValido(idTime).
				getListIdJogadores().
				stream().
				sorted().
				collect(Collectors.toList());
	}

	@Desafio("buscarMelhorJogadorDoTime")
	public Long buscarMelhorJogadorDoTime(Long idTime) {

		Jogador jogador = getTimeValido(idTime).
				getListJogadores().
				stream().
				sorted(Comparator.
						comparingInt(Jogador::getNivelHabilidade).
						reversed()).
				findFirst().orElse(null)
				;
		if (jogador == null) {
			return null;
		}
		return jogador.getId();
	}

	@Desafio("buscarJogadorMaisVelho")
	public Long buscarJogadorMaisVelho(Long idTime) {


		Jogador jogador = getTimeValido(idTime).
				getListJogadores().
				stream().
				sorted(Comparator.comparing(Jogador::getDataNascimento).thenComparingLong(Jogador::getId)).
				findFirst().
				orElse(null);
        if (jogador == null) {
        	return null;
		}
		return jogador.getId();
	}

	@Desafio("buscarTimes")
	public List<Long> buscarTimes() {

       return obterListaIdTimes().
			   stream().
			   sorted(Comparator.comparingLong(Long::longValue)).
			   collect(Collectors.toList());
	}

	@Desafio("buscarJogadorMaiorSalario")
	public Long buscarJogadorMaiorSalario(Long idTime) {

		Jogador jogador = getTimeValido(idTime).
				getListJogadores().
				stream().
				sorted(Comparator.
						comparing(Jogador::getSalario).reversed().
						thenComparingLong(Jogador::getId)).
				findFirst().
				orElse(null);

		if (jogador == null){
			return null;
		}

		return jogador.getId();
	}

	@Desafio("buscarSalarioDoJogador")
	public BigDecimal buscarSalarioDoJogador(Long idJogador) {

		return getJogadorValido(idJogador).getSalario();

	}

	@Desafio("buscarTopJogadores")
	public List<Long> buscarTopJogadores(Integer top) {

		if (top == null) {
			gerarException(UNSUPPORTED_OPERATION_EXCEPTION,"É necessário informar o valor do parâmetro top.");
		}

        List<Long> listTopReturn = new ArrayList<>();

		obterListaJogadores().
				stream().
				sorted(Comparator.
						comparing(Jogador::getNivelHabilidade).reversed().
						thenComparingLong(Jogador::getId)).
				limit(top).
				forEach(e -> listTopReturn.add(e.getId()));

		return listTopReturn;
	}

	@Desafio("buscarCorCamisaTimeDeFora")
	public String buscarCorCamisaTimeDeFora(Long timeDaCasa, Long timeDeFora) {

		Time timeCasa = getTimeValido(timeDaCasa);
		Time timeFora = getTimeValido(timeDeFora);

        return (timeCasa.getCorUniformePrincipal().equals(timeFora.getCorUniformePrincipal())) ?
				timeFora.getCorUniformeSecundario() :
				timeFora.getCorUniformePrincipal();

	}

	//=======================================================================================================/

	private Long validaTimeExiste(Long idTime){
		if (getTimeFutebol(idTime) != null){
			gerarException(IDENTIFICADOR_UTILIZADO_EXCEPTION,"Codigo do time já foi cadastrado.");
		}
		return idTime;
	}

	private Time getTimeValido(Long idTime){
		Time time = getTimeFutebol(idTime);
		 if (time == null){
			gerarException(TIME_NAO_ENCONTRADO_EXCEPTION,String.format("Id do time [%s] não encontrado na base.",idTime));
		}
		return time;
	}

	private Time getTimeFutebol(Long idTime){
		for (Time time : timesList ) {
			if (time.getId().equals(idTime)){
				return time;
			}
		}
		return null;
	}

	private Long validaJogadorExiste(Long idJogador){
		if (getJogador(idJogador) != null) {
			gerarException(IDENTIFICADOR_UTILIZADO_EXCEPTION,String.format("Jogador [%s] já existe na base.",idJogador));
		}
		return idJogador;
	}

	private Jogador getJogadorValido(Long idJogador){
        Jogador jogador = getJogador(idJogador);
		if (jogador == null) {
			gerarException(JOGADOR_NAO_ENCONTRADO_EXCEPTION,String.format("Jogador [%s] não encontrado na base.",idJogador));
		}
        return jogador;
	}

	private Jogador getJogador(Long idJogador){
		for (Time time : timesList ) {
			for (Jogador jogador : time.getListJogadores()) {
				if (jogador.getId().equals(idJogador)){
					return  jogador;
				}
			}
		}
		return null;
	}

	private List<Long> obterListaIdTimes(){
		List<Long> listIdTimes = new ArrayList<>();
		for (Time time: timesList) {
			listIdTimes.add(time.getId());
		}
		return listIdTimes;
	}

	private List<Jogador> obterListaJogadores(){
		List<Jogador> listJogadores = new ArrayList<>();
		for (Time time: timesList) {
			listJogadores.addAll(time.getListJogadores());
		}
		return listJogadores;
	}

	private void gerarException(String tipoException, String eMessage) {

		switch (tipoException.trim()){
			case IDENTIFICADOR_UTILIZADO_EXCEPTION :
				throw new IdentificadorUtilizadoException(eMessage);
			case TIME_NAO_ENCONTRADO_EXCEPTION :
				throw new TimeNaoEncontradoException(eMessage);
			case JOGADOR_NAO_ENCONTRADO_EXCEPTION :
				throw new JogadorNaoEncontradoException(eMessage);
			case CAPITAO_NAO_INFORMADO_EXCEPTION :
				throw new CapitaoNaoInformadoException(eMessage);
			case UNSUPPORTED_OPERATION_EXCEPTION :
				throw new UnsupportedOperationException(eMessage);
			default:
				throw new UnsupportedOperationException("Unexpected value: " + tipoException.trim().toLowerCase());
		}

	};

}
