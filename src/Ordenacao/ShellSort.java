package Ordenacao;

public class ShellSort {
	 
	public static MetricaOrdenacao shellSort(int[] vetor) {
		int n = vetor.length;
		int comparacoes = 0;
		int troca = 0;
 
		for (int gap = n / 2; gap > 0; gap /= 2) {
			for (int i = gap; i < n; i++) {
				int chave = vetor[i];
				int j = i - gap;
 
				while (j >= 0) {
					comparacoes++;
					if (vetor[j] > chave) {
						vetor[j + gap] = vetor[j];
						troca++;
						j -= gap;
					} else {
						break;
					}
				}
				vetor[j + gap] = chave;
			}
		}
		return new MetricaOrdenacao(comparacoes, troca);
	}
}
