package serialization.jackson;

@SuppressWarnings("ALL")
public class Birthday {

    private int day; // atributos privados não são serializados, o jacskon só considera o que é público
    private int month; // colocando um getter já resolve o problema tanto na serialização quanto na desserialização
    private int year; // no exemplo da aula criando um setter apenas para o ano, cenário incomum, significa que não é serializado, mas, pode ser desserializado.

    // PORÉM EXISTE UMA FORMA DE CONSIDERAR A SERIALIZAÇÃO E DESSERIALIZAÇÃO DE CAMPOS PRIVADOS NO JACKSON INCLUÍDO NA CLASSE UTILITÁRIA JsonUtils

    public Birthday() {} // o construtor padrão é importante na desserialização executada pelo jackson, pois primeiro ele constrói o objeto vazio e depois injeta os valores lidos do JSON dentro das propriedades

    public Birthday(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Birthday{" + "dat=" + day + ", month=" + month + ", year=" + year + '}';
    }
}
