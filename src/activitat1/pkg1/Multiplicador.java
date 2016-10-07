package activitat1.pkg1;

import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Multiplicador {

    private final ThreadPoolExecutor executor;

    /**
     * El metode indiquem que nomes volem crear 3 fils per a realitzar les multiplicacions.
     */
    public Multiplicador() {
        this.executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);
        
    }

    /**
     * En aquest metode s'executen les multiplicacions i s'emmagatzemen en el future.
     * @param multiplicacio
     * @return 
     */
    public Future<Integer> ejecutarTarea(Multiplicacio multiplicacio) {
        Future<Integer> future = executor.submit(multiplicacio);
        return future;
    }

    /**
     * Aquest metode serveix per a finalitzar el programa.
     */
    public void terminarMultiplicador() {
        executor.shutdown();
    }
}
