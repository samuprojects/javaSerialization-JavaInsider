package serialization.jackson;


/*
*
* Quando utilizamos o jackson o Serializable não faz diferença nenhuma. Ele consegue serializar objetos que não implementam a interface Serializable.
* O Serializable é extremamente importante quando serializamos utilizando a API nativa do Java
* Também não é necessário a utilização do serialVersionUID e nem annotation @Serial
* O jackson pode trabalhar com classes padrão Java (pojo - Plain Old Java Objects), são aquelas que possuem um conjunto de atributos com seus construtores, etc.
*
*
* */
public record Item(int id, String name) {
}
