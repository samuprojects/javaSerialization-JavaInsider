package serialization.jackson;

import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;

public class App6 {

    public static void main(String[] args) throws Exception {

        // a propriedade brand que está com null, com a alteração no mapper da classe utilitária, não constará no arquivo
        Car car = new Car(
                null,
                Car.Color.WHITE,
                LocalDate.of(2020, 6, 13),
                new Car.Engine(
                        "XPTO",
                        89.3
                )
        );

        try (var out = Files.newOutputStream(Path.of("car.json"))) {
            JsonUtils.mapper().writeValue(out, car); // ajustado o mapper na classe utilitária JSON para formatar automaticamente na saída

            // usando a opção abaixo não precisa utilizar a configuração global na classe utilitário do JSON que criamos, porém, valerá apenas para esse writeValue nessa chamada
            //JsonUtils.mapper().writerWithDefaultPrettyPrinter().writeValue(out, car);
        }
    }
}
