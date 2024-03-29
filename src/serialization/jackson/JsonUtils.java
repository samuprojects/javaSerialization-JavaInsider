package serialization.jackson;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
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
        mapper.enable(SerializationFeature.INDENT_OUTPUT); // vai formatar o objeto na saída globalmente em todos os objetos criados (antes ficava apenas tudo em uma linha)
        mapper().setSerializationInclusion(JsonInclude.Include.NON_NULL); // faz com que dados nulos não sejam serializados, economizando a quantidade de bytes no tráfego da rede
        mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY); // informa ao jackson para considerar todos os campos, independente da visibilidade, no processo de serialização ou desserialização
    }

    private JsonUtils() {}

    public static ObjectMapper mapper() {
        return mapper;
    }
}
