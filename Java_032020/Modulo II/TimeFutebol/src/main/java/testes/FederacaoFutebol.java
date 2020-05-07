package testes;

import br.com.codenation.DesafioMeuTimeApplication;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Random;

public class FederacaoFutebol {


    public static void main(String[] args) {

        try {

            DesafioMeuTimeApplication desafio = new DesafioMeuTimeApplication();

            System.out.println("Buscar lista de times ordenada: "+desafio.buscarTimes().toString());
            System.out.println("Buscar lista de TOP Jogadores: "+desafio.buscarTopJogadores(10).toString());



            desafio.incluirTime(
                    5L,
                    "Avaí",
                    LocalDate.now(),
                    "null",
                    "Branco"
            );

            desafio.incluirTime(
                    1L,
                    "Cruzeiro",
                    LocalDate.now(),
                    "Azul",
                    "Branco"
            );



            for (int i = 11; i >= 1; i--){
                desafio.incluirJogador((long)i ,
                        1L,
                        "Jogador "+i,
                        LocalDate.now(),
                        new Random().ints(0,100).findFirst().getAsInt(),
                        new BigDecimal("550000.00")
                );
                desafio.incluirJogador((long)(i+100) ,
                        1L,
                        "Jogador "+(i+100),
                        LocalDate.now(),
                        new Random().ints(0,100).findFirst().getAsInt(),
                        new BigDecimal("550000.00")
                );
            }

            desafio.incluirTime(
                    2L,
                    "Atlético Mineiro",
                    LocalDate.now(),
                    "Preto",
                    "Branco"
            );

            for (int i = 12; i <= 22; i++){
                desafio.incluirJogador((long)i ,
                        2L,
                        "Jogador "+i,
                        LocalDate.now(),
                        new Random().ints(0,100).findFirst().getAsInt(),
                        new BigDecimal("550000.00")
                );
            }

            desafio.incluirTime(
                    3L,
                    "America Mineiro",
                    LocalDate.now(),
                    "Verde",
                    "Branco"
            );

            for (int i = 23; i <= 26; i++){
                desafio.incluirJogador((long)i ,
                        3L,
                        "Jogador "+i,
                        LocalDate.now(),
                        new Random().ints(0,100).findFirst().getAsInt(),
                        new BigDecimal("550000.00")
                );
            }

            desafio.incluirJogador(27L ,
                    3L,
                    "Jogador mais velho",
                    LocalDate.parse("1984-12-20"),
                    98,//new Random().ints(0,100).findFirst().getAsInt(),
                    new BigDecimal("550000.00")
            );

            desafio.incluirJogador(28L ,
                    3L,
                    "Jogador mais velho",
                    LocalDate.parse("1984-12-20"),
                    99,//new Random().ints(0,100).findFirst().getAsInt(),
                    new BigDecimal("550000.00")
            );

            desafio.incluirJogador(999L ,
                    1L,
                    "Jogador mais velho",
                    LocalDate.parse("1984-12-20"),
                    100,//new Random().ints(0,100).findFirst().getAsInt(),
                    new BigDecimal("550000.01")
            );
            desafio.incluirJogador(998L ,
                    1L,
                    "Jogador mais velho",
                    LocalDate.parse("1984-12-20"),
                    100,//new Random().ints(0,100).findFirst().getAsInt(),
                    new BigDecimal("550000.01")
            );



            //desafio.buscarCapitaoDoTime(1L);

            //desafio.buscarNomeJogador(null);
            System.out.println("Buscar nome do jogardor: "+desafio.buscarNomeJogador(13L));
            System.out.println("Buscar nome do Time: "+desafio.buscarNomeTime(1L));
            System.out.println("Buscar jogadores do Time: "+desafio.buscarJogadoresDoTime(1L).toString());
            System.out.println("Buscar Melhor jogador do Time: "+desafio.buscarMelhorJogadorDoTime(1L));
            System.out.println("Buscar jogador mais velho do Time: "+desafio.buscarJogadorMaisVelho(1L));
            System.out.println("Buscar jogador mais velho do Time: "+desafio.buscarJogadorMaisVelho(5L));
            System.out.println("Buscar lista de times ordenada: "+desafio.buscarTimes().toString());
            System.out.println("Buscar jogador com maior salario do time: "+desafio.buscarJogadorMaiorSalario(1L));
            System.out.println("Buscar salario do jogador: "+desafio.buscarSalarioDoJogador(999L));
            System.out.println("Buscar lista de TOP Jogadores: "+desafio.buscarTopJogadores(10).toString());


            desafio.definirCapitao(5L);
            desafio.definirCapitao(8L);
            desafio.definirCapitao(14L);
            desafio.definirCapitao(12L);
            //desafio.definirCapitao(null);
            //desafio.imprimirTimes();

            System.out.println(desafio.buscarNomeJogador(19L));
            System.out.println(desafio.buscarNomeTime(1L));
            System.out.println(desafio.buscarJogadoresDoTime(5L).toString());

            //System.out.println("Melhor Jogador do Time: "+desafio.buscarMelhorJogadorDoTime(null));
            System.out.println("Melhor Jogador do Time: "+desafio.buscarMelhorJogadorDoTime(1L));
            //System.out.println("Melhor Jogador do Time: "+desafio.buscarMelhorJogadorDoTime(30L));
            System.out.println("Melhor Jogador do Time: "+desafio.buscarMelhorJogadorDoTime(5L));

            //System.out.println("Jogador mais velho do Time: "+desafio.buscarJogadorMaisVelho(null));
            System.out.println("Jogador mais velho do Time: "+desafio.buscarJogadorMaisVelho(1L));
            System.out.println("Jogador mais velho do Time: "+desafio.buscarJogadorMaisVelho(5L));
            //System.out.println("Jogador mais velho do Time: "+desafio.buscarJogadorMaisVelho(30L));

            //System.out.println("Jogador com maior salario: "+desafio.buscarJogadorMaiorSalario(null));
            System.out.println("Jogador com maior salario: "+desafio.buscarJogadorMaiorSalario(1L));
            System.out.println("Jogador com maior salario: "+desafio.buscarJogadorMaiorSalario(5L));
            //System.out.println("Jogador com maior salario: "+desafio.buscarJogadorMaiorSalario(30L));

            //System.out.println("Jogador com maior salario: "+desafio.buscarSalarioDoJogador(null));
            System.out.println("Salario do jogador: "+desafio.buscarSalarioDoJogador(1L));
            System.out.println("Salario do jogador: "+desafio.buscarSalarioDoJogador(26L));
            //System.out.println("Jogador com maior salario: "+desafio.buscarSalarioDoJogador(30L));


           // System.out.println("Uniforme Time Casa/Fora:"+desafio.buscarCorCamisaTimeDeFora(null,2L));
            System.out.println("Uniforme Time Casa/Fora:"+desafio.buscarCorCamisaTimeDeFora(1L,3L));
           // System.out.println("Uniforme Time Casa/Fora:"+desafio.buscarCorCamisaTimeDeFora(30L,2L));
            //System.out.println("Uniforme Time Casa/Fora:"+desafio.buscarCorCamisaTimeDeFora(null,null));

        }
        catch (Exception e) {
           System.out.println(e.getMessage());
           e.printStackTrace();
        }
    }
}
