package serialization.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;

public class App3 {

    /*
    * a forma mais simples de desserializar utilizando jackson (transformar algo no formato json para um objeto na memória)
    * vamos utilizar como fonte de dados uma própria String para transformá-la em um objeto
    *
    * */

    public static void main(String[] args) throws JsonProcessingException {

        // podemos usar os blocos de String """ xyz """ que nos permite utilizar aspas duplas da forma que quisermos
        String json = """
            { "min": 5, "max": 10 }
        """;

        // Para desserializar chamamos o mapper (para obter o ObjectMapper) e o readValue (que permite ler de vários lugares) no nosso caso de um String content
        Range range = JsonUtils.mapper().readValue(json, Range.class); // passamos a variável seguido do tipo de dado que desejamos como retorno (utilizado na criação do objeto)
        System.out.println(range);
    }

    private record Range (int min, int max) {}
}
