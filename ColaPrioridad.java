import java.util.ArrayList;
import java.util.List;

public class ColaPrioridad {
    List<Proceso> heap;

    public ColaPrioridad() {
        heap = new ArrayList<>();
    }

    public void agregarProceso(Proceso proceso) {
        heap.add(proceso);
        int indiceActual = heap.size() - 1;
        while (indiceActual > 0) {
            int indicePadre = (indiceActual - 1) / 2;
            if (heap.get(indiceActual).compareTo(heap.get(indicePadre)) < 0) {
                Proceso temp = heap.get(indiceActual);
                heap.set(indiceActual, heap.get(indicePadre));
                heap.set(indicePadre, temp);
                indiceActual = indicePadre;
            } else {
                break;
            }
        }
    }

    public Proceso obtenerProcesoSiguiente() {
        if (heap.isEmpty()) {
            return null;
        }
        Proceso proceso = heap.getFirst();
        heap.set(0, heap.getLast());
        heap.removeLast();
        int indiceActual = 0;
        while (true) {
            int hijoIzquierdo = 2 * indiceActual + 1;
            int hijoDerecho = 2 * indiceActual + 2;
            if (hijoIzquierdo >= heap.size()) {
                break;
            }
            int indiceMinimo = hijoIzquierdo;
            if (hijoDerecho < heap.size() && heap.get(hijoDerecho).compareTo(heap.get(hijoIzquierdo)) < 0) {
                indiceMinimo = hijoDerecho;
            }
            if (heap.get(indiceActual).compareTo(heap.get(indiceMinimo)) > 0) {
                Proceso temp = heap.get(indiceActual);
                heap.set(indiceActual, heap.get(indiceMinimo));
                heap.set(indiceMinimo, temp);
                indiceActual = indiceMinimo;
            } else {
                break;
            }
        }
        return proceso;
    }

    public boolean hayProcesos() {
        return !heap.isEmpty();
    }
}
