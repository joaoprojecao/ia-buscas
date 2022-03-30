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

public class Main {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws IOException {

//		char[] cfgFim = {' ','2','3','1','4','6','7','5','8'};
		char[] cfgIni = {'2','4','3','7','1','6','5',' ','8'};
		char[] cfgFim = {'2','4','3','7','1','6','5',' ','8'};
//		char[] cfgIni = {'2','3',' ','7','4','1','5','8','6'};
		//char[] cfgIni = {'7','2','3','4',' ','1','5','8','6'}; // OutOfMemory

		Puzzle8 puzzleInicial = new Puzzle8();
		puzzleInicial.setEstado(cfgIni);
		puzzleInicial.setCusto(0);
		puzzleInicial.setAvaliacao( puzzleInicial.heuristica(Puzzle8.TABULEIRO_ORGANIZADO) );

		Puzzle8 puzzleFinal = new Puzzle8();
		puzzleFinal.setEstado(cfgFim);
		puzzleFinal.setCusto(0);
		puzzleFinal.setAvaliacao(0);
////////////////////////////////////////////////////////////////
//		BuscaCega busca = new BuscaEmLargura();
//		busca.setInicio(puzzleInicial);
//		busca.setObjetivo(puzzleFinal);
//		busca.buscar();
//		for(Estado e : busca.getCaminhoSolucao()) {
//			System.out.println(e);
//		}
////////////////////////////////////////////////////////////////
//		BuscaCega buscaFunda = new BuscaEmProfundidade();
//		buscaFunda.setInicio(puzzleInicial);
//		buscaFunda.setObjetivo(puzzleFinal);
//		buscaFunda.buscar();
//		for(Estado e : buscaFunda.getCaminhoSolucao()) {
//			System.out.println(e);
//		}
////////////////////////////////////////////////////////////////
//		BuscaEmProfundidadeLimitada buscaFundaLimitada = new BuscaEmProfundidadeLimitada();
//		buscaFundaLimitada.setLimite(10);
//		buscaFundaLimitada.setInicio(puzzleInicial);
//		buscaFundaLimitada.setObjetivo(puzzleFinal);
//		buscaFundaLimitada.buscar();
//		for(Estado e : buscaFundaLimitada.getCaminhoSolucao()) {
//			System.out.println(e);
//		}
////////////////////////////////////////////////////////////////
		System.out.println("Digite o Inicio: \n");
		BufferedReader input1 = new BufferedReader(
				new InputStreamReader(System.in));
		int input1Valor =Integer.valueOf(input1.readLine());

		System.out.println("Digite o Limite: \n");
		BufferedReader input2 = new BufferedReader(
				new InputStreamReader(System.in));
		int input2Valor = Integer.valueOf(input2.readLine());
		for(int i = input1Valor; i <= input2Valor; i++) {
			BuscaEmProfundidadeLimitada buscaEmProfundidadeLimitada = new BuscaEmProfundidadeLimitada();
			buscaEmProfundidadeLimitada.setLimite(i);
			buscaEmProfundidadeLimitada.setInicio(puzzleInicial);
			buscaEmProfundidadeLimitada.setObjetivo(puzzleFinal);
			buscaEmProfundidadeLimitada.buscar();
			for(Estado e : buscaEmProfundidadeLimitada.getCaminhoSolucao()) {
				System.out.println(e);
			}
		}
////////////////////////////////////////////////////////////////
		System.exit(0);
	}
}