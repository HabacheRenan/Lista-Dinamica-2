package aula14_10;

public class Main {
	static ListaHabache l = new ListaHabache();
	public static void main(String[] args) throws Exception {
		
		
		int vet[] = {10,5,8,1,9,2,4,7,3,6};
		
		insert(vet);
		mostrar(insert(sort(listToArray())));
		
		
	}
	
	public static int[] insert(int[] vet) throws Exception {
		int j = 0;
		for(int i : vet) {
			l.add(i, j);
			j++;
		}
		return vet;
	}
	
	public static int[] listToArray() throws Exception {
		int[] vet = new int[10];
			
		for(int i = 0; i < 10; i++) {
			vet[i] = (int) l.get(i);
		}
		
		return vet;
	}
	
	public static int[] sort(int[]vet) {
		for(int i = 0; i < vet.length; i ++) {
			for(int j = i +1; j < vet.length; j++) {
				if(vet[i] > vet[j]) {
					int aux = vet[i];
					vet[i] = vet[j];
					vet[j] = aux;
				}
					
			}
		}
		return vet;
	}
	
	static void mostrar(int vet[]) throws Exception {
		for(int i = 0; i < vet.length; i++) {
			System.out.println(l.get(i));
		}
	}

}
