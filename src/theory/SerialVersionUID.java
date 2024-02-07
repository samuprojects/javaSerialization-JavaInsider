package theory;

@SuppressWarnings("ALL")
public class SerialVersionUID {

    // O serialVersionUID é uma informação interna que é armazenada com a serialização.
    // É criado automaticamente pelo Java, quando não especificado pelo programador, considerando o nome da classe e a estrutura dela.
    // Por exemplo, os campos (atributos) que fazem parte dessa classe.
    // Com isso ao serializar um objeto, se mudar alguma coisa na classe e tentar desserializar dará um erro de InvalidClassException
    // Apontando para uma incompatibilidade com o serialVersionUID
    // O mesmo para inclusão ou alteração de métodos, bem como a simples alteração no nome da classe.
    // Qualquer mudança na estrutura da classe alterará o número serialVersionUID fazendo com que o mecanismo de proteção do Java na desserialização aponte o erro.



}
