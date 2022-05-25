import espacoDeEstados.*;
import estrategiasDeBusca.cega.BuscaCega;
import estrategiasDeBusca.cega.BuscaEmLargura;
import estrategiasDeBusca.cega.BuscaEmProfundidade;
import estrategiasDeBusca.cega.BuscaEmProfundidadeLimitada;
import estrategiasDeBusca.heuristica.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    @SuppressWarnings("rawtypes")
    public static void main(String[] args) throws IOException {

//		char[] cfgFim = {' ','2','3','1','4','6','7','5','8'};
        char[] cfgIni = {'2', ' ', '3', '1', '4', '6', '7', '5', '8'};
        char[] cfgFim = {'1', '2', '3', '4', '5', '6', '7', '8', ' '};
//		char[] cfgIni = {'2','3',' ','7','4','1','5','8','6'};
        //char[] cfgIni = {'7','2','3','4',' ','1','5','8','6'}; // OutOfMemory

        boolean canClose = false;
		while (!canClose) {
			Puzzle8 puzzleInicial = new Puzzle8();
			puzzleInicial.setEstado(cfgIni);
			puzzleInicial.setCusto(0);
			puzzleInicial.setAvaliacao(puzzleInicial.heuristica(Puzzle8.TABULEIRO_ORGANIZADO));

			Puzzle8 puzzleFinal = new Puzzle8();
			puzzleFinal.setEstado(cfgFim);
			puzzleFinal.setCusto(0);
			puzzleFinal.setAvaliacao(0);

            //MENU
            System.out.println("1 - Busca em Profundidade Limitada");
            System.out.println("2 - Busca em Profundidade");
            System.out.println("3 - Busca em Profundidade Limitada Interativa");
            System.out.println("4 - Busca em Largura");
            System.out.println("5 - Busca em Best First");
            System.out.println("6 - Busca A*");
            System.out.println("7 - Hillclimbing");
			System.out.println("8 - Sair");
            Scanner option = new Scanner(System.in);
            int opcao = option.nextInt();

            switch (opcao) {
                case 1:
                    BuscaEmProfundidadeLimitada buscaFundaLimitada = new BuscaEmProfundidadeLimitada();
                    buscaFundaLimitada.setLimite(10);
                    buscaFundaLimitada.setInicio(puzzleInicial);
                    buscaFundaLimitada.setObjetivo(puzzleFinal);
                    buscaFundaLimitada.buscar();
                    for (Estado e : buscaFundaLimitada.getCaminhoSolucao()) {
                        System.out.println(e);
                    }
                    break;

                case 2:
                    BuscaCega buscaFunda = new BuscaEmProfundidade();
                    buscaFunda.setInicio(puzzleInicial);
                    buscaFunda.setObjetivo(puzzleFinal);
                    buscaFunda.buscar();
                    for (Estado e : buscaFunda.getCaminhoSolucao()) {
                        System.out.println(e);
                    }
                    break;

                case 3:
                    System.out.println("Digite o Minimo: \n");
                    BufferedReader input1 = new BufferedReader(
                            new InputStreamReader(System.in));
                    int input1Valor = Integer.valueOf(input1.readLine());

                    System.out.println("Digite o Limite: \n");
                    BufferedReader input2 = new BufferedReader(
                            new InputStreamReader(System.in));
                    int input2Valor = Integer.valueOf(input2.readLine());
                    for (int i = input1Valor; i <= input2Valor; i++) {
                        BuscaEmProfundidadeLimitada buscaEmProfundidadeLimitada = new BuscaEmProfundidadeLimitada();
                        buscaEmProfundidadeLimitada.setLimite(i);
                        buscaEmProfundidadeLimitada.setInicio(puzzleInicial);
                        buscaEmProfundidadeLimitada.setObjetivo(puzzleFinal);
                        buscaEmProfundidadeLimitada.buscar();
                        for (Estado e : buscaEmProfundidadeLimitada.getCaminhoSolucao()) {
                            System.out.println(e);
                        }
                    }
                    break;

                case 4:
                    BuscaCega busca = new BuscaEmLargura();
                    busca.setInicio(puzzleInicial);
                    busca.setObjetivo(puzzleFinal);
                    busca.buscar();
                    for (Estado e : busca.getCaminhoSolucao()) {
                        System.out.println(e);
                    }
                    break;

                case 5:
                    BestFirst bestFirst = new BestFirst();
                    bestFirst.setInicio(puzzleInicial);
                    bestFirst.setObjetivo(puzzleFinal);

                    bestFirst.buscar();
                    for (Estado e : bestFirst.getCaminhoSolucao()) {
                        System.out.println(e);
                    }

                    break;

                case 6:
                    AStar buscaAEstrela = new AStar();
                    buscaAEstrela.setInicio(puzzleInicial);
                    buscaAEstrela.setObjetivo(puzzleFinal);
                    buscaAEstrela.buscar();
                    for (Estado e : buscaAEstrela.getCaminhoSolucao()) {
                        System.out.println(e);
                    }

                    break;

                case 7:
                    HillClimbing buscaHill = new HillClimbing();
                    buscaHill.setInicio(puzzleInicial);
                    buscaHill.setObjetivo(puzzleFinal);
                    buscaHill.buscar();
                    for (Estado e : buscaHill.getCaminhoSolucao()) {
                        System.out.println(e);
                    }

                    break;

                case 8:
                    canClose = true;

                default:
                    System.out.print("\nOpção Inválida\n\n");
                    break;
            }
        }
        System.exit(0);
    }
}