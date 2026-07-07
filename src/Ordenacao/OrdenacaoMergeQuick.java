package Ordenacao;

public class OrdenacaoMergeQuick {
	 
	private static int comparacoes;
	private static int trocas;
 
	public static MetricaOrdenacao mergeSort(int[] array) {
		comparacoes = 0;
		trocas = 0;
		if (array == null || array.length <= 1) {
			return new MetricaOrdenacao(comparacoes, trocas);
		}
		mergeSortRecursivo(array, 0, array.length - 1);
		return new MetricaOrdenacao(comparacoes, trocas);
	}
 
	private static void mergeSortRecursivo(int[] array, int inicio, int fim) {
		if (inicio < fim) {
			int meio = (inicio + fim) / 2;
			mergeSortRecursivo(array, inicio, meio);
			mergeSortRecursivo(array, meio + 1, fim);
			merge(array, inicio, meio, fim);
		}
	}
 
	private static void merge(int[] array, int inicio, int meio, int fim) {
 
		int tamanhoEsq = meio - inicio + 1;
		int tamanhoDir = fim - meio;
 
		int[] vetorEsq = new int[tamanhoEsq];
		int[] vetorDir = new int[tamanhoDir];
 
		for (int i = 0; i < tamanhoEsq; i++) {
			vetorEsq[i] = array[inicio + i];
		}
 
		for (int j = 0; j < tamanhoDir; j++) {
			vetorDir[j] = array[meio + 1 + j];
		}
 
		int i = 0;
		int j = 0;
		int k = inicio;
 
		while (i < tamanhoEsq && j < tamanhoDir) {
			comparacoes++;
			if (vetorEsq[i] <= vetorDir[j]) {
				array[k] = vetorEsq[i];
				i++;
			} else {
				array[k] = vetorDir[j];
				j++;
			}
			trocas++;
			k++;
		}
		while (i < tamanhoEsq) {
			array[k] = vetorEsq[i];
			trocas++;
			i++;
			k++;
		}
		while (j < tamanhoDir) {
			array[k] = vetorDir[j];
			trocas++;
			j++;
			k++;
		}
	}
 
	public static MetricaOrdenacao quickSort(int[] array) {
		comparacoes = 0;
		trocas = 0;
		if (array == null || array.length <= 1) {
			return new MetricaOrdenacao(comparacoes, trocas);
		}
		quickSortRecursivo(array, 0, array.length - 1);
		return new MetricaOrdenacao(comparacoes, trocas);
	}
 
	private static void quickSortRecursivo(int[] array, int inicio, int fim) {
		if (inicio < fim) {
			int pontoDeCorte = particao(array, inicio, fim);
			quickSortRecursivo(array, inicio, pontoDeCorte);
			quickSortRecursivo(array, pontoDeCorte + 1, fim);
		}
	}
 
	private static int particao(int[] array, int inicio, int fim) {
		int meio = (inicio + fim) / 2;
		int pivo = array[meio];
 
		int i = inicio;
		int j = fim;
 
		while (true) {
			while (array[i] < pivo) {
				comparacoes++;
				i++;
			}
			comparacoes++;
			while (array[j] > pivo) {
				comparacoes++;
				j--;
			}
			comparacoes++;
 
			if (i >= j) {
				return j;
			}
			int temp = array[i];
			array[i] = array[j];
			array[j] = temp;
			trocas++;
 
			i++;
			j--;
		}
	}
}
