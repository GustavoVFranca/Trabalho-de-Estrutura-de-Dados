package Ordenacao;

import java.util.Arrays;
import java.util.Random;

public class TesteOrdenacao {

	public static void main(String[] args) {
		int[] tamanhos = {100000, 1000000};
		Random random = new Random();

		for (int tamanho : tamanhos) {
			int[] vetorAleatorio = new int[tamanho];
			for (int i = 0; i < tamanho; i++) {
				vetorAleatorio[i] = random.nextInt(tamanho);
			}

			int[] vetorOrdenado = vetorAleatorio.clone();
			Arrays.sort(vetorOrdenado);

			int[] vetorInvertido = new int[tamanho];
			for (int i = 0; i < tamanho; i++) {
				vetorInvertido[i] = vetorOrdenado[tamanho - 1 - i];
			}

			System.out.println("Tamanho: " + tamanho + " - Aleatorio");
			testarTodos(vetorAleatorio);

			System.out.println("Tamanho: " + tamanho + " - Ordenado");
			testarTodos(vetorOrdenado);

			System.out.println("Tamanho: " + tamanho + " - Invertido");
			testarTodos(vetorInvertido);
		}
	}

	public static void testarTodos(int[] vetorBase) {
		int[] vetorBubble = vetorBase.clone();
		int[] vetorSelection = vetorBase.clone();
		int[] vetorInsertion = vetorBase.clone();
		int[] vetorMerge = vetorBase.clone();
		int[] vetorQuick = vetorBase.clone();
		int[] vetorShell = vetorBase.clone();
		int[] vetorCounting = vetorBase.clone();

		long inicioBubble = System.nanoTime();
		MetricaOrdenacao mBubble = OrdenacaoQuadratica.bubbleSort(vetorBubble);
		long fimBubble = System.nanoTime();

		long inicioSelection = System.nanoTime();
		MetricaOrdenacao mSelection = OrdenacaoQuadratica.selectionSort(vetorSelection);
		long fimSelection = System.nanoTime();

		long inicioInsertion = System.nanoTime();
		MetricaOrdenacao mInsertion = OrdenacaoQuadratica.insertionSort(vetorInsertion);
		long fimInsertion = System.nanoTime();

		long inicioMerge = System.nanoTime();
		MetricaOrdenacao mMerge = OrdenacaoMergeQuick.mergeSort(vetorMerge);
		long fimMerge = System.nanoTime();

		long inicioQuick = System.nanoTime();
		MetricaOrdenacao mQuick = OrdenacaoMergeQuick.quickSort(vetorQuick);
		long fimQuick = System.nanoTime();

		long inicioShell = System.nanoTime();
		MetricaOrdenacao mShell = ShellSort.shellSort(vetorShell);
		long fimShell = System.nanoTime();

		long inicioCounting = System.nanoTime();
		MetricaOrdenacao mCounting = CountingSort.countingSort(vetorCounting);
		long fimCounting = System.nanoTime();

		if (!GeradorVetores.estaOrdenado(vetorBubble)) {
			System.out.println("ERRO: Bubble Sort nao ordenou corretamente!");
		}
		if (!GeradorVetores.estaOrdenado(vetorSelection)) {
			System.out.println("ERRO: Selection Sort nao ordenou corretamente!");
		}
		if (!GeradorVetores.estaOrdenado(vetorInsertion)) {
			System.out.println("ERRO: Insertion Sort nao ordenou corretamente!");
		}
		if (!GeradorVetores.estaOrdenado(vetorMerge)) {
			System.out.println("ERRO: Merge Sort nao ordenou corretamente!");
		}
		if (!GeradorVetores.estaOrdenado(vetorQuick)) {
			System.out.println("ERRO: Quick Sort nao ordenou corretamente!");
		}
		if (!GeradorVetores.estaOrdenado(vetorShell)) {
			System.out.println("ERRO: Shell Sort nao ordenou corretamente!");
		}
		if (!GeradorVetores.estaOrdenado(vetorCounting)) {
			System.out.println("ERRO: Counting Sort nao ordenou corretamente!");
		}

		System.out.println("Bubble Sort    Comparacoes: " + mBubble.getComparacao()
				+ " | Trocas: " + mBubble.getTroca()
				+ " | Tempo: " + (fimBubble - inicioBubble) / 1000000.0 + "ms");

		System.out.println("Selection Sort Comparacoes: " + mSelection.getComparacao()
				+ " | Trocas: " + mSelection.getTroca()
				+ " | Tempo: " + (fimSelection - inicioSelection) / 1000000.0 + "ms");

		System.out.println("Insertion Sort Comparacoes: " + mInsertion.getComparacao()
				+ " | Trocas: " + mInsertion.getTroca()
				+ " | Tempo: " + (fimInsertion - inicioInsertion) / 1000000.0 + "ms");

		System.out.println("Merge Sort     Comparacoes: " + mMerge.getComparacao()
				+ " | Trocas: " + mMerge.getTroca()
				+ " | Tempo: " + (fimMerge - inicioMerge) / 1000000.0 + "ms");

		System.out.println("Quick Sort     Comparacoes: " + mQuick.getComparacao()
				+ " | Trocas: " + mQuick.getTroca()
				+ " | Tempo: " + (fimQuick - inicioQuick) / 1000000.0 + "ms");

		System.out.println("Shell Sort     Comparacoes: " + mShell.getComparacao()
				+ " | Trocas: " + mShell.getTroca()
				+ " | Tempo: " + (fimShell - inicioShell) / 1000000.0 + "ms");

		System.out.println("Counting Sort  Comparacoes: " + mCounting.getComparacao()
				+ " | Trocas: " + mCounting.getTroca()
				+ " | Tempo: " + (fimCounting - inicioCounting) / 1000000.0 + "ms");

		System.out.println();
	}
}