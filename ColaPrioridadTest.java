import org.junit.Test;

import static org.junit.Assert.*;

public class ColaPrioridadTest {

    @Test
    public void testAgregarProceso_HeapVacio() {
        ColaPrioridad cola = new ColaPrioridad();
        Proceso proceso1 = new Proceso("Proceso1", "usuario1", 10);
        cola.agregarProceso(proceso1);

        assertEquals(1, cola.heap.size());
        assertEquals(proceso1, cola.heap.getFirst());
    }

    @Test
    public void testAgregarProceso_Orden() {
        ColaPrioridad cola = new ColaPrioridad();
        cola.agregarProceso(new Proceso("Proceso2", "usuario2", 5));
        cola.agregarProceso(new Proceso("Proceso1", "usuario1", 0));
        assertEquals(2, cola.heap.size());
        assertEquals("Proceso1", cola.heap.getFirst().nombreProceso);
    }

    @Test
    public void testOrdenProcesoSiguiente() {
        ColaPrioridad cola = new ColaPrioridad();
        cola.agregarProceso(new Proceso("Proceso2", "usuario2", 15));
        cola.agregarProceso(new Proceso("Proceso1", "usuario1", 5));
        cola.agregarProceso(new Proceso("Proceso3", "usuario3", 10));

        assertEquals("Proceso1", cola.obtenerProcesoSiguiente().nombreProceso);
        assertEquals("Proceso3", cola.obtenerProcesoSiguiente().nombreProceso);
        assertEquals("Proceso2", cola.obtenerProcesoSiguiente().nombreProceso);
    }

    @Test
    public void testHeapVacio_obtenerProceso() {
        ColaPrioridad cola = new ColaPrioridad();
        assertNull(cola.obtenerProcesoSiguiente());
    }
}
