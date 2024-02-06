package serialization.obj;

import serialization.Client;

import java.nio.file.Path;
import java.time.LocalDate;

import static serialization.obj.SerializationUtils.*;

public class App5 {
    public static void main(String[] args) {
        Path file = Path.of("file.bin");

        Client client = new Client(10, "Maria", LocalDate.of(1980, 6, 1), "111222"); // document foi ignorado devido ao transient
        toFile(client, file);

        Client clientRead = fromFile(file);
        System.out.println(clientRead);
    }
}
