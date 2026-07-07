package Ordenacao;

public class MetricaOrdenacao {
	int comparacao;
	int troca;
	
	public MetricaOrdenacao(int comparacao, int troca) {
		this.comparacao = comparacao;
		this.troca = troca;
	}
 
	public int getComparacao() {
		return comparacao;
	}
 
	public void setComparacao(int comparacao) {
		this.comparacao = comparacao;
	}
 
	public int getTroca() {
		return troca;
	}
 
	public void setTroca(int troca) {
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
 
