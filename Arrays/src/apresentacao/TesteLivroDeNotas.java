package apresentacao;

import java.util.Scanner;

public class TesteLivroDeNotas {

    public static void main(String[] args) {
    	
    	Scanner scanner = new Scanner(System.in);
        System.out.println("Quantos alunos você tem?"); 

        int numAlunos = scanner.nextInt();
        scanner.nextLine(); 
        
        System.out.println("Qual o nome da disciplina?");
        String disciplina = scanner.nextLine();
        
        LivroDeNotas livroDeNotas = new LivroDeNotas(disciplina, numAlunos);

        for (int i = 0; i < numAlunos; i++) {
            System.out.println("Digite as notas do aluno " + (i + 1) + ":");
            double nota1 = scanner.nextDouble();
            double nota2 = scanner.nextDouble();
            livroDeNotas.inserirNota(i + 1, nota1, nota2);
        }

        int opcao;
        do {
            System.out.println("1- Exibir médias");
            System.out.println("2- Exibir desvio padrão");
            System.out.println("3- Exibir maior nota");
    
            opcao = scanner.nextInt();
            
            switch (opcao) {
                case 1:
                    livroDeNotas.exibirMedias();
                    break;
                case 2:
                    livroDeNotas.exibirDesvioPadrao();
                    break;
                case 3:
                    double maiorNota = livroDeNotas.obterMaiorNota();
                    System.out.println("Maior nota: " + maiorNota);
                    break;
                case 4:
                    double media = livroDeNotas.exibirMedias();
                    double desvioPadrao = livroDeNotas.exibirDesvioPadrao();
                    double maiorNotaFinal = livroDeNotas.obterMaiorNota();
                    System.out.println("Média das notas dos alunos aprovados: " + media);
                    System.out.println("Média das notas dos alunos reprovados: " + media);
                    System.out.println("Desvio padrão das notas dos alunos aprovados: " + desvioPadrao);
                    System.out.println("Maior nota: " + maiorNotaFinal);
                    break;
                default:
                    System.out.println("");
            }
        } while (opcao != 3);

        scanner.close();
    }
}
