package serialization.obj;

import serialization.Client;

import java.nio.file.Path;

import static serialization.obj.SerializationUtils.fromFile;

@SuppressWarnings("ALL")
public class App4 {

    public static void main(String[] args) {
        Path file = Path.of("file.bin");

        //Client client = new Client(10, "Maria", LocalDate.of(1980, 6, 1));
        //toFile(client, file);

        Client clientRead = fromFile(file);
        System.out.println(clientRead);

        // o processo de "desserialização" não constrói o objeto da forma tradicional do Java, chamando construtores,
        // isso é importante saber, porque o seu construtor não será chamado se o objeto for chamado no processo de "desserialização".
        // Dependendo da aplicação não haverá problema algum, porém, em alguns cenários o construtor pode ser usado para fazer algumas validações ou alguma outra inicialização no objeto
        // como o construtor não será chamado seu objeto poderá tornar-se inconsistente
    }
}
