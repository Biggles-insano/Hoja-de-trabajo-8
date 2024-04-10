import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class GestorProcesos {
    private ColaPrioridad colaPrioridad;

    public GestorProcesos() {
        colaPrioridad = new ColaPrioridad();
    }

    public void cargarProcesosDesdeArchivo(String nombreArchivo) {
        try {
            File archivo = new File(nombreArchivo);
            Scanner scanner = new Scanner(archivo);
            while (scanner.hasNextLine()) {
                String[] datos = scanner.nextLine().split(",");
                String nombreProceso = datos[0];
                String nombreUsuario = datos[1];
                int valorNice = Integer.parseInt(datos[2]);
                Proceso proceso = new Proceso(nombreProceso, nombreUsuario, valorNice);
                colaPrioridad.agregarProceso(proceso);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("Archivo no encontrado: " + nombreArchivo);
        }
    }

    public void procesarProcesos() {
        while (colaPrioridad.hayProcesos()) {
            Proceso proceso = colaPrioridad.obtenerProcesoSiguiente();
            System.out.println("Proceso: " + proceso);
        }
    }

    public static void main(String[] args) {
        GestorProcesos gestor = new GestorProcesos();
        gestor.cargarProcesosDesdeArchivo("procesos.txt");
        gestor.procesarProcesos();
    }
}
