package serialization.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public final class JsonUtils {


    /*
    *
    * Criamos uma classe final para que ninguém herde dela, depois um construtor privado para evitar instanciação fora da classe
    * Depois a criação de um método estático para retornar um ObjectMapper (em uma instância privada e final)
    * Por último um bloco static para gerar o objeto e também fazer o registro do módulo para a API de Data Time
    *
    * */

    private static final ObjectMapper mapper;

    static {
        mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
    }

    private JsonUtils() {}

    public static ObjectMapper mapper() {
        return mapper;
    }
}
