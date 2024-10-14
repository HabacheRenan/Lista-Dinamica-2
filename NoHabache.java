package aula14_10;

public class NoHabache<T> {

	T dado;
	NoHabache<T> proximo;
	
	@Override
	public String toString() {
		return "No [dado=" + dado + "]";
	}
	
}

