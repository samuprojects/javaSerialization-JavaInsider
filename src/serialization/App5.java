package serialization;

import serialization.jackson.JsonUtils;

import java.nio.file.Files;
import java.nio.file.Path;

@SuppressWarnings("ALL")
public class App5 {

    public static void main(String[] args) throws Exception {

        // como a origem agora é um arquivo podemos utilizar no readValue um File, um Reader ou InputStream, neste exemplo vários Readers
        try (var in = Files.newBufferedReader(Path.of("letters.json"))) {

            //var letters = JsonUtils.mapper().readValue(in, List.class); // desserializando para lista
            //List<String> letters = JsonUtils.mapper().readValue(in, new TypeReference<>() {}); // desserializando para lista usando Generics

            String[] letters = JsonUtils.mapper().readValue(in, String[].class); // desserializando para array de String

            System.out.println(letters);
        }
    }
}
