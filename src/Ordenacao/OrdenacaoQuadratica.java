package Ordenacao;

public class OrdenacaoQuadratica {
	 
	public static MetricaOrdenacao bubbleSort(int[] vetor) {
        int comparacoes = 0, trocas = 0;
        int n = vetor.length;
 
        for (int i = 0; i < n - 1; i++) {
            boolean trocou = false;
            for (int j = 0; j < n - 1 - i; j++) {
                comparacoes++;                          
                if (vetor[j] > vetor[j + 1]) {
                    int aux = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = aux;
                    trocas++;
                    trocou = true;
                }
            }
            if (!trocou) break;
        }
        return new MetricaOrdenacao(comparacoes, trocas);
    }
 
	public static MetricaOrdenacao selectionSort(int [] vetor) {
		int n = vetor.length;
		int comparacoes = 0;
		int troca = 0;
		
		for (int i = 0; i < n-1; i++) {
			int indiceMenor = i;
			for(int j = i; j < n; j++) {
				comparacoes++;
				if(vetor[j] < vetor[indiceMenor]) {
					indiceMenor = j;
				}
			}
			if(indiceMenor != i) {
				int temp = vetor[i];
				vetor[i] = vetor [indiceMenor];
				vetor[indiceMenor] = temp;
				troca++;
			}
		}
		return new MetricaOrdenacao(comparacoes, troca);
	}
	
	public static MetricaOrdenacao insertionSort(int [] vetor) {
		int n = vetor.length;
		int comparacoes = 0;
		int troca = 0;
		
		for(int i = 1; i < n; i++) {
			int chave = vetor[i];
			int j = i - 1;
			while(j >= 0 && vetor[j] > chave) {
				comparacoes++;
				vetor[j+1] = vetor[j];
				troca++;
				j--;
			}
			
			vetor[j+1] = chave;
		}
		return new MetricaOrdenacao(comparacoes, troca);
	}
}
