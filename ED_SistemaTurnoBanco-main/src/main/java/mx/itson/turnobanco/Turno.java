package mx.itson.turnobanco;

public class Turno {
    
    private String numero;
    private String cliente;

    public Turno(String numero, String cliente) {
        this.numero = numero;
        this.cliente = cliente;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCliente() {
        return cliente;
    }
    
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
    
    
    
}
