package challenge;


import java.util.Objects;

public class Motorista {

    private final String nome;

    private final int idade;

    private final int pontos;

    private final String habilitacao;

    private Motorista(String nome, int idade, int pontos, String habilitacao) throws NullPointerException,IllegalArgumentException {
        this.nome = checkNome(nome);
        this.idade = checkIdade(idade);
        this.pontos = checkPontos(pontos);
        this.habilitacao = checkHabilitacao(habilitacao);
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public int getPontos() {
        return pontos;
    }

    public String getHabilitacao() {
        return habilitacao;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Motorista motorista = (Motorista) o;
        return Objects.equals(habilitacao, motorista.habilitacao);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(habilitacao);
    }

    @Override
    public String toString() {
        return "Motorista{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", pontos=" + pontos +
                ", habilitacao='" + habilitacao + '\'' +
                '}';
    }

    public static MotoristaBuilder builder() {
        return new MotoristaBuilder();
    }


    public static class MotoristaBuilder {

        private String nome;

        private int idade;

        private int pontos;

        private String habilitacao;

        private MotoristaBuilder() {
        }

        public MotoristaBuilder withNome(String nome) throws NullPointerException {
            this.nome =  checkNome(nome);
            return this;
        }

        public MotoristaBuilder withIdade(int idade) throws IllegalArgumentException {
            this.idade = checkIdade(idade);
            return this;
        }

        public MotoristaBuilder withPontos(int pontos) throws NullPointerException {
            this.pontos = checkPontos(pontos);
            return this;
        }

        public MotoristaBuilder withHabilitacao(String habilitacao) throws NullPointerException {
            this.habilitacao = checkHabilitacao(habilitacao);
            return this;
        }


        public Motorista build() {
            return new Motorista(nome, idade, pontos, habilitacao);
        }
    }

    private static String checkHabilitacao(String habilitacao) throws NullPointerException {
        if (habilitacao == null || habilitacao.trim().isEmpty()){
            throw new NullPointerException("Motorista deve conter habilitacao.");
        }
        return habilitacao;
    }

    private static String checkNome(String nome) throws NullPointerException {
        if (nome == null || nome.trim().isEmpty()){
            throw new NullPointerException("Motorista deve conter nome.");
        }
        return nome;
    }

    private static int checkIdade(int idade) throws IllegalArgumentException {
        if (idade < 0){
            throw new IllegalArgumentException("Motorista deve conter idade.");
        }
        return idade;
    }

    private static int checkPontos(int pontos) throws NullPointerException {
        if (pontos < 0){
            throw new IllegalArgumentException("Motorista deve conter pontos igual ou superior a 0.");
        }
        return pontos;
    }
}
