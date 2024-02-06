package serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class App2 {
    public static void main(String[] args) throws IOException {

        // caminho para representar onde está o arquivo
        Path file = Path.of("file.bin");

        // para ler o arquivo
        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(file))) {
            Client client = (Client) ois.readObject(); // readObject não recebe parâmetros, mas retorna o objeto na forma de Object, e lança exceção (tratado no catch)
            System.out.println(client);

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
