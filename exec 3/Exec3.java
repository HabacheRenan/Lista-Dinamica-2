package aula14_10;

public class Exec3 {

    public static void main(String[] args) throws Exception {
        int[] a = {3, 5, 8, 12, 9, 7, 16};
        int[] b = {9, 6, 2, 3, 7};

        ListaHabache l1 = new ListaHabache();
        insert(l1, a);
        ListaHabache l2 = new ListaHabache();
        insert(l2, b);

        ListaHabache intersec = intersecção(l1, l2);
        ListaHabache u = união(l1, l2);
        System.out.println("União:");
        mostrar(u);
        System.out.println("Interseção:");
        mostrar(intersec);
    }

    private static void mostrar(ListaHabache lista) throws Exception {
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i));
        }
    }

    private static ListaHabache união(ListaHabache l1, ListaHabache l2) throws Exception {
        ListaHabache lista = new ListaHabache();
        int tamanho1 = l1.size();
        int tamanho2 = l2.size();

        for (int i = 0; i < tamanho1; i++) {
            lista.add(l1.get(i), lista.size());
        }
        for (int i = 0; i < tamanho2; i++) {
            boolean existe = false;
            for (int j = 0; j < lista.size(); j++) {
                if (lista.get(j) == l2.get(i)) {
                    existe = true;
                    break;
                }
            }
            if (!existe) {
                lista.add(l2.get(i), lista.size());
            }
        }
        return lista;
    }

    private static ListaHabache intersecção(ListaHabache l1, ListaHabache l2) throws Exception {
        ListaHabache lista = new ListaHabache();
        int tamanho1 = l1.size();
        int tamanho2 = l2.size();

        for (int i = 0; i < tamanho1; i++) {
            for (int j = 0; j < tamanho2; j++) {
                if (l1.get(i) == l2.get(j)) {
                    lista.add(l1.get(i), lista.size());
                    break; 
                }
            }
        }
        return lista;
    }

    static ListaHabache insert(ListaHabache lista, int[] vet) throws Exception {
        for (int i = 0; i < vet.length; i++) {
            lista.add(vet[i], lista.size());
        }
        return lista;
    }
}
