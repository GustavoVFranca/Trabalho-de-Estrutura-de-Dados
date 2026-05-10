package TrabalhoDeFilas;

public class Nodo {
	private Aviao aviao;
	private Nodo prox;
	
	
	public Nodo(Aviao aviao) {
		this.aviao = aviao;
		this.prox = null;
	}

	public Aviao getAviao() {
		return aviao;
	}


	public void setAviao(Aviao aviao) {
		this.aviao = aviao;
	}


	public Nodo getProx() {
		return prox;
	}


	public void setProx(Nodo prox) {
		this.prox = prox;
	}
}