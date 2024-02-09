package sinerji_test_main;
import java.util.ArrayList;
import java.util.List;
import sinerji_test_users.Users;
public class App {
    public static void main(String[] args) throws Exception {
        Users jorge = new Users("Secretário", 7000, "Jorge Carvalho", "01/2018");
        Users maria = new Users("Secretário", 7000, "Maria Souza", "12/2015");
        Users ana = new Users("Vendedor", 12000, "Ana Silva", "12/2021", 5200, "12/2021");
        Users joao = new Users("Vendedor", 12000, "João Mendes", "12/2021", 3400, "12/2021");
        Users juliana = new Users("Gerente", 20000, "Juliana Alves", "07/2017");
        Users bento = new Users("Gerente", 20000, "Bento Albino", "03/2014");
        /*Para os usuários que são vendedores (Ana e João) eu setei 
        os lucros do PRIMEIRO MÊS APENAS.
        Caso queiram validar outros meses e outros respectivos lucros, 
        alterar manualmente na declaração do objeto. 
         */
        List<Users> list = new ArrayList<>();
        list.add(jorge);
        list.add(maria);
        list.add(ana);
        list.add(joao);
        list.add(juliana);
        list.add(bento);
        System.out.println("Testando o primeiro método:");
        Users.calculateSalaries_Benefits(list);
        System.out.println("-----------------------------");
        System.out.println("Testando o segundo método:");
        Users.calculateSalaries_Without_Benefits(list);
        System.out.println("-----------------------------");
        System.out.println("Testando o terceiro método:");
        /*
         * Foi exigido que o quinto método listasse SOMENTE funcionários com benefícios.
         * Por conta disso eu programei o método para lançar um "exception" (erro) caso
         * um usuário que não possua benefícios esteja na lista. Caso queira validar o
         * erro, basta comentar a linha abaixo:
         */
        list.removeIf(x -> x.getRole() == "Gerente");
        //A linha acima retira usuários sem benefícios para não gerar erro e parar o código.
        Users.calculateBenefits(list);
        System.out.println("-----------------------------");
        System.out.println("Testando o quarto método:");
        //Acrescentando os gerentes novamente
        list.add(juliana);
        list.add(bento);
        Users.calculateHigherSalary(list);
        System.out.println("-----------------------------");
        System.out.println("Testando o quinto método:");
        //Mais uma vez retirando pelos mesmos motivos
        list.removeIf(x -> x.getRole() == "Gerente");
        Users.calculateBenefits(list);
        System.out.println("-----------------------------");
        System.out.println("Testando o sexto método:");
        list.removeIf(x -> x.getRole() != "Vendedor");
        /*O mesmo vale para aqui. O sexto método só aceita vendedores. Se deixar outros
        cargos vai gerar um "expection" também. Por isso estou removendo para não gerar
        essa mensagem. Se quiser validar a mensagem de erro, só comentar esse trecho acima.
         */
        Users.calculateMostSells(list);
    }
}
