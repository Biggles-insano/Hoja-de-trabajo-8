import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GestorProcesos {
    private final ColaPrioridad colaPrioridad;

    public GestorProcesos() {
        colaPrioridad = new ColaPrioridad();
    }

    public void ejecutar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--------Menu--------");
        System.out.println("1. Cargar procesos manualmente");
        System.out.println("2. Cargar procesos desde archivo procesos.txt");
        System.out.println("Ingrese la opción deseada (p. ej. '1'): ");
        String respuesta = scanner.nextLine();
        if (respuesta.equalsIgnoreCase("1")) {
            cargarProcesosManualmente();
        }
        else if (respuesta.equalsIgnoreCase("2")) {
            try {
                cargarProcesosDesdeArchivo();
            } catch (FileNotFoundException e) {
                System.err.println("Error al leer el archivo de procesos: " + e.getMessage());
            }
        } else {
            System.err.println("Opción no válida.");
            return;
        }
        procesarProcesos();
    }

    public void cargarProcesosDesdeArchivo() throws FileNotFoundException {
        LectorArchivo lectorArchivo = new LectorArchivo(new File("procesos.txt"));
        while (lectorArchivo.hayLineas()) {
            String linea = lectorArchivo.obtenerSiguienteLinea();
            split(linea);
        }
        lectorArchivo.cerrar();
    }

    private void split(String linea) {
        String[] datos = linea.split(",");
        String nombreProceso = datos[0];
        String nombreUsuario = datos[1];
        int valorNice = Integer.parseInt(datos[2]);
        Proceso proceso = new Proceso(nombreProceso, nombreUsuario, valorNice);
        colaPrioridad.agregarProceso(proceso);
    }

    public void cargarProcesosManualmente() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese los procesos en el formato nombreProceso,nombreUsuario,valorNice. Ingrese 'fin' para terminar:");
        while (true) {
            String linea = scanner.nextLine();
            if (linea.equals("fin")) {
                break;
            }
            split(linea);
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
        gestor.ejecutar();
    }

}
