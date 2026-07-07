package Ordenacao;

import java.util.Arrays;
import java.util.Random;

public class GeradorVetores {
	 
	public static int[] gerarVetorAleatorio(int tamanho) {
		Random random = new Random();
		int[] vetor = new int[tamanho];
		for (int i = 0; i < tamanho; i++) {
			vetor[i] = random.nextInt(tamanho);
		}
		return vetor;
	}
 
	public static int[] gerarVetorOrdenado(int[] vetorAleatorio) {
		int[] vetor = vetorAleatorio.clone();
		Arrays.sort(vetor);
		return vetor;
	}
 
	public static int[] gerarVetorInvertido(int[] vetorOrdenado) {
		int n = vetorOrdenado.length;
		int[] vetor = new int[n];
		for (int i = 0; i < n; i++) {
			vetor[i] = vetorOrdenado[n - 1 - i];
		}
		return vetor;
	}
 
	public static boolean estaOrdenado(int[] vetor) {
		for (int i = 1; i < vetor.length; i++) {
			if (vetor[i - 1] > vetor[i]) {
				return false;
			}
		}
		return true;
	}
}