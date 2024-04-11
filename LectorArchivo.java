import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LectorArchivo {
    private final Scanner scanner;

    public LectorArchivo(File archivo) throws FileNotFoundException {
        scanner = new Scanner(archivo);
    }

    public boolean hayLineas() {
        return scanner.hasNextLine();
    }

    public String obtenerSiguienteLinea() {
        return scanner.nextLine();
    }

    public void cerrar() {
        scanner.close();
    }
}
