package mx.itson.turnobanco;


import mx.itson.turnobanco.Nodo;
import mx.itson.turnobanco.Turno;

public class Cola {

    public Nodo inicio;
    public Nodo fin;

    public Cola() {
        this.inicio = null;
        this.fin = null;
    }

    public boolean isEmpty () {
        return this.inicio == null;
    }

    public void displayQueue() {
        
        int amountElements = size();
        
        for(int i = 0; i < amountElements; i++){
            System.out.print("-------");
        }
        System.out.println();
        
        Nodo aux = this.inicio;
        while(aux != null){
            System.out.print("   "+ aux.valor.getNumero()+"-"+aux.valor.getCliente()  +"   ");
            aux = aux.siguiente;
        }
        System.out.println();
        
        for(int i = 0; i < amountElements; i++){
            System.out.print("-------");
        }
        
        System.out.println();
        
    }
    
    public void enqueue(Turno val) {
        if(isEmpty()){
            inicio = new Nodo(val);
            fin = inicio;
        }else{
            fin.siguiente = new Nodo(val);
            fin = fin.siguiente;
        }
    }
    
    public Turno dequeue() {
        Turno eliminado = inicio.valor; 
        
        int contador = size();
        if(contador == 1){
            inicio = null;
            fin = inicio;
        }else{
            inicio = inicio.siguiente; 
        }
        
        return eliminado;
    }
    
    public Turno front() {
        if(inicio != null) {
            return inicio.valor;
        }else{
            return null;
        }
    }
 
    public int size() {
        Nodo aux = this.inicio;
        int contador = 0;
        while(aux != null){
            contador++;
            aux = aux.siguiente;
        }
        return contador;
    }
    
    
    
}
