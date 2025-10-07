public class Nodo {

    public Carta valor;
    public Nodo siguiente;

    public Nodo(Carta c, Nodo n) {
        this.valor = c;
        this.siguiente = n;
    }

    public Nodo(Carta c) {
        this.valor = c;
        this.siguiente = null;
    }

    public Carta getValor() {
        return valor;
    }

    public void setValor(Carta c) {
        this.valor = c;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo n) {
        this.siguiente = n;
    }
}
