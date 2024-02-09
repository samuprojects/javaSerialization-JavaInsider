package serialization.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Map;

@SuppressWarnings("ALL")
public class App4 {

    public static void main(String[] args) throws JsonProcessingException {

        String json = """
            { "min": 5, "max": 10 }
        """;

        // baseado no modelo anterior podemos observar que em nenhum momento temos o nome da classe
        // o local para onde a desserialização ocorrerá vai depender do readValue
        // como essa estrutura parece um Map podemos utilizar para obter o mesmo resultado

        //var range = JsonUtils.mapper().readValue(json, Map.class); // como não definimos um Map diretamente com <K, V> para utilizar um Map diretamente usamos um TypeReference

        // é muito utilizado com Generics
        Map<String, Integer> range = JsonUtils.mapper().readValue(json, new TypeReference<>() {});
        System.out.println(range);

        // ou seja, não é preciso criar classes específicas para o processo de desserialização
        // basta apenas que o local tenha a mesma estrutura que o json carrega dentro dele
        // isso permite utilizar outras classes já existentes do Java como Map, List, Set


        /*
        * Explicação extraída do fórum de dúvidas:
        * O professor tentou usar um Map sem generics e a IDE “reclamou“,
        * pois o Map faz uso do generics, sendo que é mais seguro utilizar generics nesses casos.
        * Para contornar isso, o professor utilizou o método readValue cuja assinatura
        * recebe um TypeReference como segundo parâmetro, então basicamente foi por isso que foi necessário utilizar o TypeReference,
        * para conseguir trabalhar com o generics no readValue no que diz respeito ao Map!
        * Repare que no TypeReference foi utilizado um Map que recebe uma String como chave e Integer como valor, e o retorno é exatamente esse!
         *
        * */
    }
}
