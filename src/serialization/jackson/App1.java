package serialization.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import serialization.Client;

import java.time.LocalDate;

public class App1 {

    public static void main(String[] args) throws JsonProcessingException {

        // para serializar precisamos de um dos principais objetos do Jackson que é o ObjectMapper, faz parte do pacote com.fasterxml.jackson.databind
        ObjectMapper mapper = new ObjectMapper();

        // para que o jackson suporte a New Date and Time API precisamos registrar um módulo extra
        mapper.registerModule(new JavaTimeModule());

        // vamos serializar um objeto da classe Client utilizada anteriormente
        Client client = new Client(10, "Pedro", LocalDate.of(1990,4, 10), "123");

        // chamando o método writeValueAsString passando o objeto que vai retornar uma String formatada em JSON
        String json = mapper.writeValueAsString(client); // como lança uma exceção optamos por lançar fora do método main

        System.out.println(json);

        // para ficar mais didático, com as formatações do JSON, criamos um arquivo client.json, colamos o resultado do console no arquivo
        // e formatamos utilizando Ctrl + Alt + L do intellij
    }
}
