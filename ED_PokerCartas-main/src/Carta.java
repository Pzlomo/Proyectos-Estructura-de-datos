public class Carta {

    private String valorInt;
    private String tipoInt;
    private String colorInt;

    public Carta(String v, String t, String c) {
        this.valorInt = v;
        this.tipoInt  = t;
        this.colorInt = c;
    }

    public Carta() { }

    public String getValor() {
        return valorInt;
    }

    public void setValor(String v) {
        this.valorInt = v;
    }

    public String getTipo() {
        return tipoInt;
    }

    public void setTipo(String t) {
        this.tipoInt = t;
    }

    public String getColor() {
        return colorInt;
    }

    public void setColor(String c) {
        this.colorInt = c;
    }
}
