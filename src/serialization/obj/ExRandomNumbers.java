package serialization.obj;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ExRandomNumbers {

    // Exercício para criação de programa de geração de número randômico (Double) que salva o número num arquivo chamado numbers.out
    // Toda vez que o programa for executado deve carregar os números anteriores e gerar um novo que é gravado atualizando o arquivo.
    // Exibir tudo isso na tela a cada execução.

    public static void main(String[] args) {

        Path file = Path.of("numbers.out");

        List<Double> numbers = new ArrayList<>(); // lista para caso não exista no arquivo numbers.out

        if (Files.exists(file)) { // checagem se o arquivo existe
            numbers = SerializationUtils.fromFile(file); // chamando classe utilitária para desserializar
        }

        numbers.add(Math.random()); // com a lista carregada na memória inserir um novo número aleatório
        SerializationUtils.toFile(numbers, file); // serializar o novo número junto aos demais já existentes
        numbers.forEach(System.out::println); // streamAPI com method reference para exibir a lista de números
    }
}
