package TrabalhoDeFilas;

public class ListaEncadeada {
	private Nodo inicio;
	
	public ListaEncadeada() {
		inicio = null;
	}

	public Nodo getInicio() {
		return inicio;
	}

	public void setInicio(Nodo inicio) {
		this.inicio = inicio;
	}
	public boolean vazio () {
		return inicio == null;
	}
	
	public void inserirInicio(Aviao aviao) {
		Nodo novoNodo = new Nodo(aviao);
		novoNodo.setProx(inicio);
		inicio = novoNodo;
	}
	/**
	 * Insere um aviao no final da fila.
	 * @param aviao aviao a ser inserido
	 */
	public void inserirFinal(Aviao aviao) {
		if(vazio()) {
			inserirInicio(aviao);
			return;
		}
		Nodo novoNodo = new Nodo(aviao);
		Nodo aux = inicio;
		while(aux.getProx() != null) {
			aux = aux.getProx();
		}
		aux.setProx(novoNodo);
	}
	
	public Aviao removerValor(Aviao aviao) {
		Aviao removido = null;
		if(vazio())	return removido;
		if(inicio.getAviao() == aviao) {
			removido = inicio.getAviao();
			inicio = inicio.getProx();
			return removido;
		}
		Nodo aux = inicio;
		while(aux.getProx() != null) {
			if(aux.getProx().getAviao() == aviao) {
				removido = aux.getProx().getAviao();
				aux.setProx(aux.getProx().getProx());
				return removido;
			}
			aux = aux.getProx();
		}
		return removido;
	}
	/**
	 * Remove e retorna o primeiro aviao da fila,
	 * @return aviao removido ou null se a fila estiver vazia
	 */
	public Aviao removerInicio(){
		if(vazio())	return null;
		Aviao removido = inicio.getAviao();
		inicio = inicio.getProx();
		return removido;
	}

	public void mostrarLista () {
		if(vazio()) {
			System.out.println("Lista Vazia");
			return;
		}
		Nodo aux = inicio;	
		while (aux != null) {
			System.out.println(aux.getAviao());
			aux = aux.getProx();
		}
	}
	public void mostrarIds() {
		if(vazio()) {
			System.out.println("Lista Vazia");
			return;
		}
		Nodo aux = inicio;
		while (aux != null) {
			System.out.print("AviaoId: " + aux.getAviao().getId() + " ");
			aux = aux.getProx();
		}
		System.out.println();
	}
	public int contarLista(){
		if(vazio()) return 0;

		int cont = 0;
		Nodo aux = inicio;	
		while (aux != null) {
			cont++;
			aux = aux.getProx();
		}
		return cont;
	}
	/**
	 * Percorre a fila procurando algum aviao com combustivel menor ou igual a 1
	 * @return aviao em emergencia ou null se nao tiver
	 */
	public Aviao buscarEmergencia() {
		if(vazio()) return null;
		Nodo aux = inicio;	
		while (aux != null) {
			Aviao aviao = aux.getAviao();
			if (aviao.getCombustivel() <= 1) {
				return aviao;
			}
			aux = aux.getProx();
		}
		return null;
	}
	
	/**
	 * Diminui o combustivel de todos os avioes que estao esperando na fila
	 */
	public void diminuirCombustivelTodos(){
		 Nodo aux = inicio;

		    while (aux != null) {
		        aux.getAviao().diminuirCombustivel();
		        aux = aux.getProx();
		    }
	}
}