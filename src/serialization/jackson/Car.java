package serialization.jackson;

import java.time.LocalDate;

@SuppressWarnings("ALL")
public class Car {

    private String brand;
    private Color color;
    private LocalDate manufacturingDate;
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
        private final String model;
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
