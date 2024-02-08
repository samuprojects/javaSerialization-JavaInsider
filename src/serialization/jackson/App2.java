package serialization.jackson;

@SuppressWarnings("ALL")
public class App2 {

    /*
    *
    * O ObjectMapper deve ser único na aplicação e sempre inicializado.
    * Para isso centralizamos isso em uma classe até para utilização em outros cenários
    *
    * */

    public static void main(String[] args) {
        var mapper = JsonUtils.mapper();
    }
}
