package activitat1.pkg1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Activitat11 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        Multiplicador Multiplicador = new Multiplicador();

        List<Multiplicacio> llistaTasques = new ArrayList<Multiplicacio>();

        /**
         * Amb aquest metode emplenem el future amb els numeros qe compondran la multiplicació.
         */
        for (int i = 0; i < 10; i++) {
            Multiplicacio calcula = new Multiplicacio((int) (Math.random() * 10), (int) (Math.random() * 10));
            llistaTasques.add(calcula);
            //Afegeix al primer lloc buit els 2 numeros que ha agafat amb el Math.Random
        }

        List<Future<Integer>> llistaResultats = new ArrayList<>();
        
        /**
         * Aquest metode crida al metode ejecutarTarea que inicia les multiplicacions amb els fils.
         */
        for (int i = 0; i < llistaTasques.size(); i++) {
            Future<Integer> future = Multiplicador.ejecutarTarea(llistaTasques.get(i));
            llistaResultats.add(future);

        }

        /**
         * Aquest bucle serveix per a recorrer el Future amb els resultats i comprobar 
         * si ja ha acabat.
         */
        for (Future<Integer> result : llistaResultats) {
                while (!result.isDone()) {
                System.out.println("Esperando...");
                Thread.sleep(1000);
            }
        }
        
        
        /**
         * Aquest bucle serveix per a mostrar els resultats quan ja ha acabat el future.
         */
        for (int i = 0; i < llistaResultats.size(); i++) {
            Future<Integer> resultat = llistaResultats.get(i);
            try {
                System.out.println("Resultat tasca " + (i + 1) + " és:" + resultat.get());
            } catch (InterruptedException | ExecutionException e) {
            }
        }
        /**
         * Cridem al metode que serveix per finalitzar el programa.
         */
        Multiplicador.terminarMultiplicador();
        
    }

}
