import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {

        // Estruturas e tipos -------------------------
        Soma teste = null;
        Integer idade = null;
        String nome = "Murilo";
        int numero = 7;
        double decimal = 1.2;
        // char letra = 'M';
        byte pequeno = 19;
        idade = 19;
        // float decimal2 = 19;
        // Integer numero2 = 5;

        int soma = numero + pequeno;
        double multiplicacao = pequeno * decimal;
        double divisao = numero / decimal;
        boolean par = numero % 2 == 0;
        double AoQuadrado = Math.pow(numero, 2);
        double RaizQuadrada = Math.sqrt(soma);
        String eleE = par ? "Ele é par" : "Ele é impar";
        System.out.printf("Meu nome é %s começa com a letra %s, e tem %s anos a quantidade de letras no nome é := %s",
                nome, nome.charAt(0), idade, nome.length());
        System.out.printf("\nSoma = %s || Multiplicação = %s || Divisão = %.2f || %s || %s ao quadrado é %s\n", soma,
                multiplicacao, divisao, eleE, numero, AoQuadrado);
        System.out.printf("A raiz quadrada de %s é %.2f\n", soma, RaizQuadrada);
        teste = new Soma(2, 5);
        System.out.println(teste.getX()); // 1
        System.out.println(teste.getY()); // 5

        // Ultilizando interfaces -------------------------
        Interface somar = new Soma(4, 2);
        System.out.println(somar.executar(4, 2)); // 6

        Interface executar = (a, b) -> {
            return a * b; // executa normal caso seja o unico
        };

        executar = (a, b) -> {
            return a + b; // executa sempre o ultimo
        };

        System.out.println(executar.executar(5, 2));

        // Listas -------------------------

        ArrayList<String> lista = new ArrayList<>();
        lista.add("Roberto");
        lista.add("Luiz");
        lista.add("Gilberto");
        lista.add("Murilo");
        lista.add("Julio");
        System.out.println(lista);

        List<String> lista2 = Arrays.asList("AAAAA", "BBBBB");
        // System.out.println(lista2);

        // Estruturas de controle - FOR com operador ternario.
        int contador = 1;
        for (String nomes : lista2) { // FOREACH percorrendo uma lista
            String existe = nomes.equalsIgnoreCase("Murilo") ? String.format("Está na posição %s", contador)
                    : String.format("Não está na posição %s", contador);
            contador += 1;
            System.out.println(existe);
        }

        for (int c = 0; c < lista.size(); c++) { // For padrão
            System.out.printf("\nNa posição %s tem %s\n", c + 1, lista.get(c));
        }

        lista.forEach(a -> System.out.println(a)); // 2 tipo de foreach percorrendo a lista

        // Matriz

        int z = 0;
        while (z <= 4) {
            System.out.println(z);
            z += 1;
        }
        // // --------- |4 - 2 - 2|
        // // --------- |3 - 2 - 2|
        // // --------- |2 - 2 - 2|
        // // --------- |1 - 2 - 2|

        // Matrizes
        int somaTotal = 0;
        double matriz[][] = new double[4][2];
        for (int v = 0; v < matriz.length; v++) {
            for (int k = 0; k < matriz[v].length; k++) {
                matriz[v][k] = 2.0;
                somaTotal += matriz[v][k];
            }
        }

        System.out.println(somaTotal);
        int somaMatriz1 = 0;
        int f = 0;
        for (int r = 0; r < matriz[f].length; r++) {
            somaMatriz1 += matriz[f][r];
        }
        System.out.println(somaMatriz1);
        int a = 2;

        // Casos e estruturas de casos

        switch (a) {
            case 1:
                System.out.println("Numero 1");
                break;
            case 2:
                System.out.println("Numero 2");
                break;
            default:
                System.out.println("nada");
        }
        // Dicionario e seus tipos.
        HashMap<Integer, String> dicionario = new HashMap<>();

        dicionario.put(1, "M");
        dicionario.put(2, "u");
        dicionario.put(3, "r");
        dicionario.put(4, "i");
        dicionario.put(5, "l");
        dicionario.put(6, "o");

        System.out.println(dicionario.keySet());
        System.out.println(dicionario);

        // Predicados funcionam com interface, exemplo abaixo ultiliza a classe e usando
        // lambda para definir um numero
        Predicate<Soma> ePar = num -> (num.getX() + num.getY()) % 2 == 0;

        Predicate<Integer> eMaior = m -> m >= 100 && m <= 99;

        System.out.println(eMaior.test(102));
        Soma somando = new Soma(1, 2);
        System.out.println(ePar.test(somando));

        // Consumer funciona da mesma forma porém funciona como um metodo aonde você
        // passa a instancia dentor e ele volta os resultados
        Consumer<Soma> imprimirSoma = p -> System.out.printf("%s\n", (p.getX() + p.getY()));

        Soma soma1 = new Soma(1, 1);

        imprimirSoma.accept(soma1);
        Soma soma2 = new Soma(1, 2);
        Soma soma3 = new Soma(1, 3);
        Soma soma4 = new Soma(1, 4);
        Soma soma5 = new Soma(1, 5);

        List<Soma> listinha = Arrays.asList(soma1, soma2, soma3, soma4, soma5); // Jogando todas as somas dentro de uma
                                                                                // lista

        listinha.forEach(imprimirSoma); // <- funcional
        listinha.forEach(p -> System.out.println(p.executar(p.getX(), p.getY()))); // Percorrendo ultilizando foreach e
                                                                                   // lambda

        // Funções
        Function<Integer, String> parOuImpar = num -> num % 2 == 0 ? "Par" : "Impar";
        Function<String, String> oResultado = valor -> "O resultado é: " + valor;

        String resultadoFinal = parOuImpar.andThen(oResultado).apply(32);
        System.out.println(resultadoFinal);
        System.out.println(parOuImpar.apply(10));

        // Operador unario

        UnaryOperator<Integer> sum = n -> n + n;
        UnaryOperator<Integer> multi = n -> n * n;
        System.out.println(sum.apply(5));
        System.out.println(multi.apply(5));

        // Operador binario
        BinaryOperator<Double> media = (x, j) -> (x + j) / 2;
        System.out.println(media.apply(5.5, 2.1));

        BiFunction<Double, Double, String> resultado2 = (n1, n2) -> {
            double notaFinal = (n1 + n2) / 2;
            return notaFinal >= 7 ? "Aprovado" : "Reprovado";
        };
        // ~Pode utilizar o .andThen para mais tratar mais de uma vez o resultado.
        System.out.println(resultado2.apply(5.0, 2.2));

        // -------------------------------- COLLECTIONS - STREAM API
        Stream<String> st = lista2.stream(); // Stream é ultilizado para percorrer, tanto algo generico ou não.
        st.forEach(System.out::println); // Stream como foreach, ultiliza :: para pegar o print do proprio no caso st.

        Iterator<String> iterator = lista2.iterator(); // Iterator funciona da mesma forma que o foreach
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        Consumer<String> print = System.out::print; // Um consumer funciona como uma função também, apenas para definir
        Consumer<String> println = System.out::println; // uma variavel para tratar informações o Predicate vai retornar
                                                        // um
        // boolean, e uma função é um metodo generico.
        // Formas de passar informações criando stream
        Stream<String> langs = Stream.of("Java ", "Lua ", "JS\n"); // 1 - OPÇÃO
        langs.forEach(print);
        String[] maisLangs = { "Python ", "Lisp ", "Perl ", "Go\n" }; // 2 - OPÇÃO
        Stream.of(maisLangs).forEach(print);
        Arrays.stream(maisLangs).forEach(print); // 3 - OPCÃO
        Arrays.stream(maisLangs, 1, 3).forEach(print); // Ele pega da posição 1 até a ultima

        List<String> lista3 = Arrays.asList("\nMurilo ", "Roberto ", "João \n"); // Outra forma de Lista.
        lista3.stream().forEach(print);

        Function<String, String> existindo = exis -> exis.equalsIgnoreCase("Marvel ") ? "\nExiste" : "Não existe";

        // - STREAM API - MAP.

        List<String> estudios = Arrays.asList("Marvel ", "Sony ", "DC ");
        estudios.stream().map(es -> es.toUpperCase()).forEach(print);

        estudios.stream().map(es -> existindo.apply(es)).forEach(println);

        UnaryOperator<Integer> aoQuadrado = n -> n * n;
        BinaryOperator<Double> newAoQuadrado = (n, b) -> Math.pow(n, b);
        System.out.println(newAoQuadrado.apply(5.0, 2.0));
        System.out.println(aoQuadrado.apply(2));

        // Usando o final
        // Exemplo de try e catch
        try {
            final UnaryOperator<Double> ruido = v -> v + 3 * v + 6 * v + Math.pow(v, 9);
            System.out.println(ruido.apply(2.1));

        } catch (Exception e) { // Mostrando erros
            System.out.println(e);
        }

        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        UnaryOperator<String> inverter = s -> new StringBuilder(s).reverse().toString();
        Function<String, Integer> binarioParaInt = b -> Integer.parseInt(b, 2);

        nums.stream().map(Integer::toBinaryString).map(inverter).map(binarioParaInt).forEach(System.out::println);

        // Stream API - FILTER

        Aluno a1 = new Aluno("Murilo", 9.1);
        Aluno a2 = new Aluno("Roberto", 8.1);
        Aluno a3 = new Aluno("João", 7.1);

        Aluno a4 = new Aluno("Luan", 10.0);

        List<Aluno> alunos = Arrays.asList(a1, a2, a3, a4);

        Predicate<Aluno> passou = j -> j.notaAluno >= 7; // Regra que retorna apenas se existe passando como parametro o
                                                         // Aluno
        Predicate<Aluno> naoPassou = p -> p.notaAluno <= 7;

        Consumer<String> printando = System.out::println;
        Function<Aluno, String> vocePassou = m -> "Parabéns você passou " + m.nomeAluno + "!!!"; // Criando regras
        Function<Aluno, String> voceNaoPassou = o -> "Você não passou " + o.nomeAluno + " faltou "
                + Math.round(7.0 - o.notaAluno) + " Ponto!!";

        alunos.stream().filter(passou).map(vocePassou).forEach(printando);
        alunos.stream().filter(naoPassou).map(voceNaoPassou).forEach(printando);

        // STREAM API - REDUCE

        List<Integer> newCount = Arrays.asList(1, 2, 3, 4, 5); // A soma de todos é igual a 15

        BinaryOperator<Double> countt = (ac, ab) -> ac + ab; // Criar uma regra
        BinaryOperator<Integer> countt2 = (ad, av) -> ad + av;
        System.out.println(newCount.stream().reduce(countt2).get()); // Usando reduce com .get para retornar a soma

        // Outra maneira

        Integer total = newCount.stream().reduce(2, countt2); // valor inicial 1, e a função.
        System.out.println(total);

        Function<Aluno, Double> al = rm -> rm.notaAluno; // Pegando todas notas dos alunos da lista, somando e pegando a
                                                         // media pela classe dos 4 alunos;

        Double mediaPorAlunos = alunos.stream().map(al).reduce(countt).get();
        System.out.println(Math.round(mediaPorAlunos / alunos.size()));

        // STREAM API - MATCH
        // Voltando um boolean como validação de existe ou não
        Predicate<Double> existeA = v -> v >= 7.0;
        Predicate<Double> existeB = v -> v < 1.0;
        Predicate<Double> existeC = v -> v == 10.0;

        System.out.println(alunos.stream().map(al).allMatch(existeA)); // Todos os valores são maiores ou iguais a 7 ?
                                                                       // TRUE
        System.out.println(alunos.stream().map(al).allMatch(existeB)); // Todos os valores são maiores que 1 ? //FALSE

        System.out.println(alunos.stream().map(al).anyMatch(existeC)); // ANY, existe pelo menos um valor igual
                                                                       // a 10 ? //TRUE
        // STREAM API - MIN AND MAX

        Comparator<Aluno> melhorNota = (aluno1, aluno2) -> { // Comprar dois valores de acordo com a regra.
            if (aluno1.notaAluno > aluno2.notaAluno)
                return 1;
            if (aluno1.notaAluno < aluno2.notaAluno)
                return -1; // Tratando de uma forma que ele entenda que é menor que 1.
            return 0;
        };

        System.out.println("A melhor nota é de " + alunos.stream().max(melhorNota).get()); // Usando max - pegando a
                                                                                           // maior nota
        System.out.println("A menor nota é de " + alunos.stream().min(melhorNota).get()); // Usando min - pegando a
                                                                                          // menor nota

    }
}