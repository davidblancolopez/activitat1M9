
package activitat1.pkg1;

import java.util.concurrent.Callable;


public class Multiplicacio implements Callable<Integer>{
    int num1;
    int num2;
    
    public Multiplicacio(int numero1, int numero2) {
      this.num1 = numero1;
      this.num2 = numero2;
    }


    /**
     * Aquest metode retorna el resultat de la multiplicació i 
     * també el fil on s'esta executant.
     * @return
     * @throws Exception 
     */
    @Override
    public Integer call() throws Exception{
    int res;
    System.out.println("Esta corriendo en el hilo: " + Thread.currentThread().getId());
    res = num1 * num2;
    
    return res;
    }
}
