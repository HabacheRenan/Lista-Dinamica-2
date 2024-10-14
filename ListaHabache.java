package aula14_10;

public class ListaHabache<T> {

	NoHabache<T> primeiro;

	public ListaHabache() {
		primeiro = null;
	}
	
	public void clean() {
	    primeiro = null;	
	}

	public boolean isEmpty() {
		if (primeiro == null) {
			return true;
		} else {
			return false;
		}
	}

	public int size() {
		int cont = 0;
		if (!isEmpty()) {
			NoHabache<T> auxiliar = primeiro;
			while (auxiliar != null) {
				cont++;
				auxiliar = auxiliar.proximo;
			}
		}
		return cont;
	}

	private NoHabache<T> getNo(int pos) throws Exception {
		if (isEmpty()) {
			throw new Exception("Lista Vazia");
		}
		int tamanho = size();
		if (pos < 0 || pos > tamanho - 1) {
			throw new Exception("Posição Invalida");
		}
		int cont = 0;
		NoHabache<T> auxiliar = primeiro;
		while (cont < pos) {
			cont++;
			auxiliar = auxiliar.proximo;
		}
		return auxiliar;
	}
	
	public void addFirst(T valor) {
		NoHabache<T> elemento = new NoHabache<>();
		elemento.dado = valor;
		elemento.proximo = primeiro;
		primeiro = elemento;
	}
	
	public void addLast(T valor) throws Exception {
		if (isEmpty()) {
//			throw new Exception("Lista Vazia");
			addFirst(valor);
		}
		int tamanho = size();
		NoHabache<T> elemento = new NoHabache<>();
		elemento.dado = valor;
		elemento.proximo = null;
		NoHabache<T> ultimo = getNo(tamanho - 1);
		ultimo.proximo = elemento;
	}
	
	public void add(T valor, int pos) throws Exception {
		int tamanho = size();
		if (pos < 0 || pos > tamanho) {
			throw new Exception("Posição Invalida");
		}
		if (pos == 0) {
			addFirst(valor);
		} else if (pos == tamanho) {
			addLast(valor);
		} else {
			NoHabache<T> anterior = getNo(pos - 1);
			NoHabache<T> elemento = new NoHabache<>();
			elemento.dado = valor;
			elemento.proximo = anterior.proximo;
			anterior.proximo = elemento;
		}
	}
	
	public void removeFirst() throws Exception {
		if (isEmpty()) {
			throw new Exception("Lista Vazia");
		}
		primeiro = primeiro.proximo;
	}

	public void removeLast() throws Exception {
		if (isEmpty()) {
			throw new Exception("Lista Vazia");
		}
		int tamanho = size();
		if (tamanho == 1) {
			removeFirst();
		} else {
			NoHabache<T> penultimo = getNo(tamanho - 2);
			penultimo.proximo = null;
		}
	}
	
	public void remove(int pos) throws Exception {
		if (isEmpty()) {
			throw new Exception("Lista Vazia");
		}
		int tamanho = size();
		if (pos < 0 || pos > tamanho - 1) {
			throw new Exception("Posição Invalida");
		}
		if (pos == 0) {
			removeFirst();
		} else if (pos == tamanho - 1) {
			removeLast();
		} else {
			NoHabache<T> anterior = getNo(pos - 1);
			NoHabache<T> atual = getNo(pos);
			anterior.proximo = atual.proximo;
		}
	}
	
	public T get(int pos) throws Exception {
		if (isEmpty()) {
			throw new Exception("Lista Vazia");
		}
		int tamanho = size();
		if (pos < 0 || pos > tamanho - 1) {
			throw new Exception("Posição Invalida");
		}
		NoHabache<T> auxiliar = getNo(pos);
		return auxiliar.dado;
	}
}

