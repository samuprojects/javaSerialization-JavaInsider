package serialization.obj;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class SerializationUtils {

    private SerializationUtils() {} // construtor privado permitindo apenas o uso dos métodos estáticos

    public static void toFile(Object obj, Path file) { // método para serializar
        try (ObjectOutputStream oos = new ObjectOutputStream((Files.newOutputStream(file)))) {
            oos.writeObject(obj);
        } catch (IOException e) { // capturando as exceções de IO e relançando internamente
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> T fromFile(Path file) {
        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(file))) {
            return (T) ois.readObject(); // como isso é uma operação não muito segura vamos inserir um SuppressWarnings com unchecked

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
