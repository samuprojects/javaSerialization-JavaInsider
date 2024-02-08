package serialization.jackson;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class App2 {

    /*
    *
    * O ObjectMapper deve ser único na aplicação e sempre inicializado.
    * Para isso centralizamos isso em uma classe até para utilização em outros cenários
    *
    * */

    public static void main(String[] args) throws Exception { // trocamos o JsonProcessingException por Exception devido a outras exceções como a do newBufferedWriter
        var mapper = JsonUtils.mapper();

        Item item1 = new Item(1, "A");
        Item item2 = new Item(2, "B");
        var list = List.of(item1, item2);

        String json = mapper.writeValueAsString(list); // poderia ser o List.of(item1, item2) direto mas externalizamos para utilizar outras vezes
        System.out.println(json);

        /*
        * Apesar de utilizarmos o writeValueAsString para criar um objeto serializado existem outras formas como, por exemplo:
        * mapper.writeValueAsBytes que escreve um objeto num byte[] → array de bytes
        * e vários outros writeValue que não retornam nada (void) mas que recebem como parâmetro o destino (um OutputStream, ou um Writer, entre outros)
        * Por exemplo, o writeValue que recebe um OutputStream podemos utilizar para serializar para um arquivo conforme a seguir
        *
        * */

        try(var out = Files.newBufferedWriter(Path.of("items.json"))) { // a extensão do arquivo pode ser qualquer coisa
            mapper.writeValue(out, list); // usamos o writeValue que recebe um Writer onde passamos a lista, dessa forma vamos exibir o objeto na tela e salvar no arquivo
        }


    }
}
