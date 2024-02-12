package serialization.jackson;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

@SuppressWarnings("ALL")
public class Car {

    private String brand;
    private Color color;

    // caso necessite formatar algum atributo em específico pode utilizar a anotação abaixo que também serve para datas
    // recebe dois parâmetros, o shape que define como será serializado (por exemplo String), e o pattern que define qual será o padrão dessa String utilizando os placeHolders de formatação de data do SimpleDateFormat
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate manufacturingDate; // com a anotação o que era um array virará uma String, que também serve no processo de desserialização
    private Engine engine;

    public Car(String brand, Color color, LocalDate manufacturingDate, Engine engine) {
        this.brand = brand;
        this.color = color;
        this.manufacturingDate = manufacturingDate;
        this.engine = engine;
    }

    public String getBrand() {
        return brand;
    }

    public Color getColor() {
        return color;
    }

    public LocalDate getManufacturingDate() {
        return manufacturingDate;
    }

    public Engine getEngine() {
        return engine;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", color=" + color +
                ", manufacturingDate=" + manufacturingDate +
                ", engine=" + engine +
                '}';
    }

    public enum Color {
        WHITE, BLACK, RED
    }

    public static class Engine {

        // para exportar com outro nome o atributo sem alterar o código da aplicação (geralmente para integrar sistemas externos) utilizar a anotação abaixo
        @JsonProperty("engineModel")
        private final String model; // com essa anotação será serializado com o nome informado (que serve na desserialização também)

        // caso não tenha intenção de serializar um atributo específico pode utilizar a anotação abaixo
        @JsonIgnore
        private final double hp;

        public Engine(String model, double hp) {
            this.model = model;
            this.hp = hp;
        }

        public String getModel() {
            return model;
        }

        public double getHp() {
            return hp;
        }

        @Override
        public String toString() {
            return "Engine{" +
                    "model='" + model + '\'' +
                    ", hp=" + hp +
                    '}';
        }
    }
}
