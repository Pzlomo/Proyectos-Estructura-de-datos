public class Pila {

    private Nodo inicio;
    private Nodo fin;

    public Pila() {
        this.inicio = null;
        this.fin = null;
    }

    public boolean isEmpty() {
        return this.inicio == null;
    }

    public void displayStack() {
        System.out.println("");
        Nodo tmp = this.inicio;
        while (tmp != null) {
            System.out.println(" | " + tmp.valor.getValor() + " " + tmp.valor.getTipo() + " |");
            tmp = tmp.siguiente;
        }
        System.out.println("-------");
    }

    public void push(Carta c) {
        if (isEmpty()) {
            inicio = new Nodo(c, inicio);
            fin = inicio;
        } else {
            inicio = new Nodo(c, inicio);
        }
    }

    public Carta pop() {
        Carta eliminado = inicio.valor;
        int count = size();
        if (count == 1) {
            inicio = null;
            fin = inicio;
        } else {
            inicio = inicio.siguiente;
        }
        return eliminado;
    }

    public int size() {
        Nodo tmp = this.inicio;
        int count = 0;
        while (tmp != null) {
            count++;
            tmp = tmp.siguiente;
        }
        return count;
    }

    public Carta top() {
        if (inicio != null) {
            return inicio.valor;
        } else {
            return null;
        }
    }
}
