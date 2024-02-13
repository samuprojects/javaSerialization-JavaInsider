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

    }

    // records para criar os objetos

    private record Square(int size) { }

    private record Rectangle(int width, int height) { }

    private record Circle(int radius) { }


    // classe para representar as configurações dos elementos utilizando um enum
    private static class ShapesConfig{
        public enum ShapeType{
            SQUARE, RECTANGLE, CIRCLE
        }

        private ShapesConfig(List<ShapeConfig> configs) {
            this.configs = configs;
        }

        // atributo lista para representar uma configuração específica com um ShapeConfig
        private final List<ShapeConfig> configs;

        public ShapesConfig create(){
            try {
                return new ShapesConfig(
                        JsonUtils.mapper().readValue(new File("shapesConfig.json"), new TypeReference<>() {})
                );
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

    }

    private static class ShapeConfig {
        private ShapesConfig.ShapeType type; // enum
        private Map<String, String> properties;

        public ShapesConfig.ShapeType getType() {
            return type;
        }

        public Map<String, String> getProperties() {
            return properties;
        }
    }
}
