package TrabalhoDeFilas;

public class Aviao {
	private int id;
	private String objetivo;
	private int combustivel;
	private int tempo;
	
	public Aviao(int id, String objetivo, int combustivel, int tempo) {
        this.id = id;
        this.objetivo = objetivo;
        this.combustivel = combustivel;
        this.tempo = tempo;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public int getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(int combustivel) {
		this.combustivel = combustivel;
	}

	public int getTempo() {
		return tempo;
	}

	public void setTempo(int tempo) {
		this.tempo = tempo;
	}
	public void diminuirCombustivel() {
		if(combustivel > 0) {
			combustivel--;
		}
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Aviao [id=");
		builder.append(id);
		builder.append(", objetivo=");
		builder.append(objetivo);
		builder.append(", combustivel=");
		builder.append(combustivel);
		builder.append(", tempo=");
		builder.append(tempo);
		builder.append("]");
		return builder.toString();
	}
	
}
