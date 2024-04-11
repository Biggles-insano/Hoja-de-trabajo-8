import java.util.Scanner;

public class GestorProcesos {
    private ColaPrioridad colaPrioridad;

    public GestorProcesos() {
        colaPrioridad = new ColaPrioridad();
    }

    public void cargarProcesosManualmente() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese los procesos en el formato nombreProceso,nombreUsuario,valorNice. Ingrese 'fin' para terminar:");
        while (true) {
            String linea = scanner.nextLine();
            if (linea.equals("fin")) {
                break;
            }
            String[] datos = linea.split(",");
            String nombreProceso = datos[0];
            String nombreUsuario = datos[1];
            int valorNice = Integer.parseInt(datos[2]);
            Proceso proceso = new Proceso(nombreProceso, nombreUsuario, valorNice);
            colaPrioridad.agregarProceso(proceso);
        }
        scanner.close();
    }

    public void procesarProcesos() {
        while (colaPrioridad.hayProcesos()) {
            Proceso proceso = colaPrioridad.obtenerProcesoSiguiente();
            System.out.println("Proceso: " + proceso);
        }
    }

    public static void main(String[] args) {
        GestorProcesos gestor = new GestorProcesos();
        gestor.cargarProcesosManualmente();
        gestor.procesarProcesos();
    }
}
