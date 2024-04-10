public class Proceso implements Comparable<Proceso> {
    private String nombreProceso;
    private String nombreUsuario;
    private int valorNice;

    public Proceso(String nombreProceso, String nombreUsuario, int valorNice) {
        this.nombreProceso = nombreProceso;
        this.nombreUsuario = nombreUsuario;
        this.valorNice = valorNice;
    }

    @Override
    public int compareTo(Proceso otroProceso) {
        return Integer.compare(this.valorNice, otroProceso.valorNice);
    }

    @Override
    public String toString() {
        return nombreProceso + "," + nombreUsuario + "," + valorNice + ",PR=" + (20 + valorNice);
    }
}
