package Ordenacao;

public class CountingSort {
	 
	public static MetricaOrdenacao countingSort(int[] vetor) {
		int n = vetor.length;
		int comparacoes = 0;
		int troca = 0;
 
		if (n == 0) {
			return new MetricaOrdenacao(comparacoes, troca);
		}
 
		int maior = vetor[0];
		for (int i = 1; i < n; i++) {
			if (vetor[i] > maior) {
				maior = vetor[i];
			}
		}
 
		int[] contagem = new int[maior + 1];
		for (int i = 0; i < n; i++) {
			contagem[vetor[i]]++;
			troca++;
		}
 
		int indice = 0;
		for (int valor = 0; valor < contagem.length; valor++) {
			while (contagem[valor] > 0) {
				vetor[indice] = valor;
				indice++;
				contagem[valor]--;
				troca++;
			}
		}
		return new MetricaOrdenacao(comparacoes, troca);
	}
}
