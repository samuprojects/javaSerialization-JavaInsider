package serialization.jackson;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/*
* criar programa para serializar e desserializar em formato JSON a estrutura abaixo que representa um conjunto de livros
*
* */

@SuppressWarnings("ALL")
public class ExBooks {

    private static final String BOOKS_JSON = """
            {
               "books": [
                 {
                   "isbn": "43243840983",
                   "title": "Java é demais!",
                   "author": "Peter Programador",
                   "num_pag": 354
                 },
                 {
                    "isbn": "9986748783",
                    "title": "Aprenda Java",
                    "author": "Paulo Pedro",
                    "num_pag": 545
                  },
                  {
                    "isbn": "587763767883",
                    "title": "Java para iniciantes",
                    "author": "Rodrigo Junqueira",
                    "num_pag": 530
                  }
                ]
              }
            """;

    // classe estática para conter a lista de Book
    private static class Books {
        private List<Book> books;

        public Books() {}

        public Books(List<Book> books) {
            this.books = books;
        }

        public List<Book> getBooks() {
            return books;
        }

        @Override
        public String toString() {
            return "Books{" +
                    "books=" + books +
                    '}';
        }
    }

    // criando classe estática para representar um livro
    private static class Book {
        private String isbn;
        private String title;
        private String author;
        @JsonProperty("num_pag")
        private int numPag; // usamos a anotação para mudar a propriedade (por mapeamento) informando o num_pag, isso é necessário para não ferir a convenção do Java quanto ao CamelCase

        public Book() {}

        public Book(String isbn, String title, String author, int numPag) {
            this.isbn = isbn;
            this.title = title;
            this.author = author;
            this.numPag = numPag;
        }

        public String getIsbn() {
            return isbn;
        }

        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }

        public int getNumPag() {
            return numPag;
        }

        @Override
        public String toString() {
            return "Book{" +
                    "isbn='" + isbn + '\'' +
                    ", title='" + title + '\'' +
                    ", author='" + author + '\'' +
                    ", numPag=" + numPag +
                    '}';
        }
    }


    public static void main(String[] args) throws Exception {

        // serialização do JSON para objeto Books
        Books books = JsonUtils.mapper().readValue(BOOKS_JSON, Books.class);
        System.out.println(books);

        // desserialização do objeto Books para String JSON no mesmo formato da original do enunciado apresentado no console
        System.out.println(JsonUtils.mapper().writeValueAsString(books));
    }
}
