package Ordenacao;

public class MetricaOrdenacao {
	long comparacao;
	long troca;
	
	public MetricaOrdenacao(long comparacao, long troca) {
		this.comparacao = comparacao;
		this.troca = troca;
	}

	public long getComparacao() {
		return comparacao;
	}

	public void setComparacao(long comparacao) {
		this.comparacao = comparacao;
	}

	public long getTroca() {
		return troca;
	}

	public void setTroca(long troca) {
		this.troca = troca;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MetricaOrdenacao [comparacao=");
		builder.append(comparacao);
		builder.append(", troca=");
		builder.append(troca);
		builder.append("]");
		return builder.toString();
	}
}