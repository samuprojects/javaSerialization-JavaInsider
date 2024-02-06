package serialization.obj;

import serialization.Client;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;

@SuppressWarnings("ALL")
public class App1 {

    public static void main(String[] args) throws IOException {

        Client client = new Client(1, "Pedro", LocalDate.of(1980,5,10));

        Path file = Path.of("file.bin"); // caminho do arquivo de saída

        // a classe ObjectOutputStream é utilizada para serializar objetos, e seu construtor recebe outra ObjectOutputStream para representar a saída
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(file));) { // precisa tratar a IOException, a princípio vamos apenas lançar fora, e fechar com o try-with-resources
            oos.writeObject(client); // na primeira execução erro NotSerializableException, ficar atento para que as classes implementem a interface Serializable
        }

    }
}
