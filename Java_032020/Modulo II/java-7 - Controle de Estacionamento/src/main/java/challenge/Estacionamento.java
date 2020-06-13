package challenge;

import java.util.ArrayList;
import java.util.List;

public class Estacionamento {

    private final int REF_MAIOR_IDADE = 18;
    private final int REF_PONTOS_MAX = 20;
    private final int REF_NUM_VAGAS = 10;
    private final int REF_MELHOR_IDADE = 55;

    private List<Carro> listaCarrosEstacionados = new ArrayList<>();

    public void estacionar(Carro carro) {
                listaCarrosEstacionados.add(validarEntrada(carro));
    }

    public int carrosEstacionados() {
        return listaCarrosEstacionados.size();
    }

    public boolean carroEstacionado(Carro carro) {
        return listaCarrosEstacionados.contains(carro);
    }

    private Carro validarEntrada(Carro carro){

        if (carro == null ||
                carro.getMotorista() == null ||
                carro.getMotorista().getIdade() < REF_MAIOR_IDADE ||
                carro.getMotorista().getPontos() > REF_PONTOS_MAX ) {
            throw new EstacionamentoException("Proibido estacionar!");
        }


        if (listaCarrosEstacionados.size() >= REF_NUM_VAGAS){
            listaCarrosEstacionados.remove(listaCarrosEstacionados.
                    stream().
                    filter(filter1 -> filter1.getMotorista().getIdade() < REF_MELHOR_IDADE).
                    findFirst().
                    orElseThrow(() -> new EstacionamentoException("Proibido estacionar!"))
            );
        }
        return carro;
    }


}
