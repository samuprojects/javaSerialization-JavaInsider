package serialization.jackson;

import com.fasterxml.jackson.core.type.TypeReference;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/*
*
* criar programa para instanciar 3 figuras geométricas: 1 quadrado (Square), 1 retângulo (Rectangle) e um círculo (Circle) usando as configurações do arquivo
* shapesConfig.json
*
* */

@SuppressWarnings("ALL")
public class ExShapes {

    public static void main(String[] args) {

        ShapesConfig shapesConfig = ShapesConfig .create();

        ShapeConfig rectangleConfig = shapesConfig.getConfig(ShapesConfig.ShapeType.RECTANGLE);

        var rectangle = new Rectangle(
                Integer.parseInt(rectangleConfig.getProperties().get("width")),
                Integer.parseInt(rectangleConfig.getProperties().get("height"))
        );
        System.out.println(rectangle);

        ShapeConfig squareConfig = shapesConfig.getConfig(ShapesConfig.ShapeType.SQUARE);
        var square = new Square(Integer.parseInt(squareConfig.getProperties().get("size")));
        System.out.println(square);

        ShapeConfig circleConfig = shapesConfig.getConfig(ShapesConfig.ShapeType.CIRCLE);
        var circle = new Circle(Integer.parseInt(circleConfig.getProperties().get("radius")));
        System.out.println(circle);

        // é um exemplo de como utilizar um arquivo JSON como uma fonte de configuração para criar objetos dentro da aplicação.
    }

    // records para criar os objetos

    private record Square(int size) { }

    private record Rectangle(int width, int height) { }

    private record Circle(int radius) { }


    /**
     * @param configs atributo lista para representar uma configuração específica com um ShapeConfig
     */ // classe para representar as configurações dos elementos utilizando um enum
        private record ShapesConfig(List<ShapeConfig> configs) { // encapsula todos os configs
            public enum ShapeType {
                SQUARE, RECTANGLE, CIRCLE
            }

        public static ShapesConfig create() {
                try {
                    return new ShapesConfig(
                            JsonUtils.mapper().readValue(new File("shapesConfig.json"), new TypeReference<>() {})
                    );
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }

            public ShapeConfig getConfig(ShapeType type) { // método utilitário para retornar a informação de determinado shape
                return configs
                        .stream()
                        .filter(c -> c.type == type)
                        .findFirst()
                        .orElseThrow();
            }

        }

    private static class ShapeConfig { // representa a configuração de 1 shape, que é a estrutura que contém o type (enum) e properties (que é o Map) mapeia uma String Propriedade com outra String que é o Valor
        private ShapesConfig.ShapeType type; // enum
        private Map<String, String> properties;

        public ShapesConfig.ShapeType getType() {
            return type;
        }

        public Map<String, String> getProperties() {
            return properties;
        }

        @Override
        public String toString() {
            return "ShapeConfig{" +
                    "type=" + type +
                    ", properties=" + properties +
                    '}';
        }
    }
}
