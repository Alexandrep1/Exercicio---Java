package apresentacao;

import java.util.Scanner;

public class LivroDeNotas {
    private String disciplina;
    private double[][] notas;
    private int numAlunos;

    public LivroDeNotas(String disciplina, int numAlunos) {
        this.disciplina = disciplina;
        this.numAlunos = numAlunos;
        notas = new double[numAlunos][2];
    }

    public void inserirNota(int aluno, double nota1, double nota2) {
        notas[aluno - 1][0] = nota1;
        notas[aluno - 1][1] = nota2;
    }

    public double obterMaiorNota() {
        double maior = 0;
        for (int a = 0; a < numAlunos; a++) {
            for (int n = 0; n < notas[a].length; n++) {
                if (notas[a][n] > maior) {
                    maior = notas[a][n];
                }
            }
        }
        return maior;
    }
    
    public double exibirMedias() {
        double soma = 0;
        int contador = 0;
        for (int a = 0; a < numAlunos; a++) {
            double mediaAluno = (notas[a][0] + notas[a][1]) / 2;
            if (mediaAluno >= 6.0) {
                soma += mediaAluno;
                contador++;
                System.out.println("Aprovado");
            } else {
            	System.out.println("Reprovado");
            }
        }
        

        double mediaTurma = soma / contador;
        System.out.println("Média das notas dos alunos aprovados: " + mediaTurma);
		return mediaTurma;
    }

    public double exibirDesvioPadrao() {
        double soma = 0;
        int contador = 0;
        for (int a = 0; a < numAlunos; a++) {
            double mediaAluno = (notas[a][0] + notas[a][1]) / 2;
            if (mediaAluno >= 6.0) {
                soma += Math.pow(mediaAluno - 6.0, 2);
                contador++;
            }
        }
        double variancia = soma / contador;
        double desvioPadrao = Math.sqrt(variancia);
        System.out.println("Desvio padrão das notas dos alunos aprovados: " + desvioPadrao);
		return desvioPadrao;
    }
}
