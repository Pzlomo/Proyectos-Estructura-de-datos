package mx.itson.turnobanco;

public class Nodo {
    public Turno valor;
    public Nodo siguiente;
    public Nodo(Turno valor, Nodo siguiente) {
        this.valor = valor;
        this.siguiente = siguiente;
    }

    public Nodo(Turno valor) {
        this.valor = valor;
        this.siguiente = null;
    }

    public Turno getValor() {
        return valor;
    }
    
    public void setValor(Turno valor) {
        this.valor = valor;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
    
    
    
}
