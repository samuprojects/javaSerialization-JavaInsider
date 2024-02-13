package serialization.jackson;


import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

/*
*
* Para escrever o objeto JSON
*
* {
  "min" : 1,
  "max" : 10
}
*
*
* como uma String
*
*
*
* {
  "range": "10..20"
}
*
* É necessário um serializador personalizado
*
* */

@SuppressWarnings("ALL")
public class App8 {

    public static void main(String[] args) throws Exception {
        Range range = new Range(5, 15);
        String json = JsonUtils.mapper().writeValueAsString(range);
        System.out.println(json);
    }

    @JsonSerialize(using = RangeSerializer.class) // 3) informando ao jackson para usar o RangeSerializer na serialização do Range
    public record Range(int min, int max) {}

    public static class RangeSerializer extends StdSerializer<Range> {

        public RangeSerializer(){
            this(null);
        }

        protected RangeSerializer(Class<Range> t) {
            super(t);
        }

        @Override
        public void serialize(Range range, JsonGenerator gen, SerializerProvider serializerProvider) throws IOException {
            // JsonGenerator gen é o objeto que vamos utilizar para escrever na saída
            // 1) transformando o range em uma string
            String rangeStr = String.format("%d..%d", range.min(), range.max());

            // 2) escrever o objeto
            gen.writeStartObject();
            gen.writeStringField("range", rangeStr);
            gen.writeEndObject();

            // Dizer pro jackson utilizar o RangeSerializer quando estiver trabalhando com o tipo Range (com a anotação)


        }
    }
}
