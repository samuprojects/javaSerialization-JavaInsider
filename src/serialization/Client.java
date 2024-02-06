package serialization;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@SuppressWarnings("ALL")
public class Client implements Serializable { // incluindo a implementação para serializar objetos, toda a hierarquia deve ser serializada senão falhará
    private final int id; // tipos primitivos são serializados por padrão
    private final String name; // String implementa serializable
    private final LocalDate birthDate; // LocalDate implementa serializable
    private transient final String document; // transiente serve para fazer com que os campos com esse modificador seja ignorado no momento da serialização

    public Client(int id, String name, LocalDate birthDate) {
        this (id, name, birthDate, null);
    }

    public Client(int id, String name, LocalDate birthDate, String document) {
        System.out.println("[ Constructor ]"); // adicionando para mostrar na tela quando o objeto é criado
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.document = document;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getDocument() {
        return document;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id == client.id && Objects.equals(name, client.name) && Objects.equals(birthDate, client.birthDate) && Objects.equals(document, client.document);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, birthDate, document);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", document='" + document + '\'' +
                '}';
    }
}

