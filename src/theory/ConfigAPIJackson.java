package theory;

@SuppressWarnings("ALL")
public class ConfigAPIJackson {

    /*
    *
    * Acessar a central do Maven em https://central.sonatype.com
    *
    * Browse all components, em namespace inserir com.fasterxml.jackson.core e ENTER
    * O resultado previsto é jackson-databind, jackson-core, jackson-annotations
    *
    * Clicar sobre cada uma das opções e seguir em Versions, selecionar a atual, Browse file directory, selecionar o arquivo jar (ignorar as versões javadoc, source e outras)
    *
    * Na sequência baixar Add-on específico, que possui um módulo extra do Jackson, que permite trabalhar com a new Date and Time API
    * Para isso no namespace inserir o filtro com.fasterxml.jackson.datatype e selecionar jackson-datatype-jsr310
    *
    * No intellij, pasta do projeto, criar um new / Directory com nome libs, em seguida na pasta libs colar os arquivos para inserir os 4 jars todos na mesma versão
    * para evitar problemas de incompatibilidade
    * Para usar essa pasta libs, durante a execução o projeto, clicar sobre a pasta ela e Add as Library..., mantém o nome padrão libs e ok
    *
    *
    *
    * */
}
