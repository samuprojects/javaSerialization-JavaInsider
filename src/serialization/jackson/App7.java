package serialization.jackson;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.File;
import java.io.IOException;

@SuppressWarnings("ALL")
public class App7 {

    public static void main(String[] args) throws Exception {

        Range range = JsonUtils.mapper().readValue(new File("randomConfig.json"), Range.class); // o arquivo indicado representa um config externa
        System.out.println(range); // dará erro porque não reconhece o field range, para isso é necessário um desserializador específico

    }

    // record para representar o min e max do arquivo JSON com range
    // 10) para indicar ao jackson que precisa utilizar o desserializador para montar o Range usar a anotação abaixo passando a referência da classe de desserialização
    @JsonDeserialize(using = RangeDeserializer.class)
    public record Range(int min, int max) {}

    // 1) classe para servir de desserializador personalizado e automático) (poderia ser fora de App7)
    public static class RangeDeserializer extends StdDeserializer<Range> { // 2) precisa estender e dizer o tipo da desserialização

        public  RangeDeserializer() { // 5) construtor público que chama o construtor abaixo passando null deixando o compilador feliz e permitindo o jackson instanciar o RangeDeserializer
            this(null);
        }

        protected RangeDeserializer(Class<?> vc) { // 4) construtor vazio necessário ao RangeDeserializer que passa para o nível acima
            super(vc);
        }

        @Override // desserializador automático
        public Range deserialize(JsonParser parser, DeserializationContext context) throws IOException, JacksonException { // 3) implementar o método
            JsonNode node = parser.getCodec().readTree(parser); // 6) JsonNode objeto de baixo nível que representa um nó do JSON (o objeto), permite navegar no documento
            String rangeStr = node.get("range").asText(); // 7) acessar o node e chamar o asText para retornar a String associada que é o 5..10
            String[] tokens = rangeStr.split("\\.\\."); // 8) quebrar a string em dois com split para retornar um array de String com os tokens (duas posições, 0 e 1)
            return new Range(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1])); // 9) como Range recebe 2 inteiros converter as Strings com parseInt da classe Integer passando os índices do array de tokens

        }
    }
}
