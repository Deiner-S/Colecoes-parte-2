package Classes;

import java.util.Objects;

public class Pessoas {
	
	private String nome;
	private String genero;
	
	
	
	
	public Pessoas(String nome, String genero) {
		
		this.nome = nome;
		this.genero = genero;
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	
	
	@Override
	public String toString() {
		return "Pessoas [nome=" + nome + ", genero=" + genero + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(genero, nome);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoas other = (Pessoas) obj;
		return Objects.equals(genero, other.genero) && Objects.equals(nome, other.nome);
	}
	


}
