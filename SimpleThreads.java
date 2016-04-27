public class SimpleThreads{
  //Display a message, preceded by
  //the name of the current thread
  static void threadMessage(String message){
    String threadMessage = Thread.currentThread().getName();
    System.out.format("%s: %s%n", threadName, message);
  }

  private static class MessageLoop
    implements Runnable {
      public void run(){
        String importantInfo[] = {
          "Muy cerca de mi ocaso, yo te bendigo, vida",
          "por que nunca me diste ni esperanza fallida",
          "ni trabajos injustos, ni pena inmerecia",
          "porque veo al final de mi rudo camino",
          "que you fui el arquitecto de mi propio destino"
        };
        try{
          for(int i=0, i < importantInfo.length; i++){
            //Pause for 4 seconds
            Thread.sleep(4000);
            //Print a message
            threadMessage(importantInfo[i]);
          }
        }catch(InterruptedException e){
          threadMessage("No esta terminado adios pues ");
        }
      }
    }

    public static void main(String[] args) {
      throws InterruptedException {
        //Delay, in milliseconds before
        //we interrupted MessageLoop
        //thread (default one hour).
        long patience = 1000 * 60 * 60;

        //if command line argument
        //present, gives patience
        //in seconds
        if(args.length > 0){
          try{
            patience = Long.parseLong(args[0]) *1000;
          }catch(NumberFormatException e){
            System.err.println("El argumento debe ser entero");
            System.exit(1);
          }
        }

        threadMessage("Iniciando el hilo del ciclo de mensajes");
        long startTime = System.currentTimeMillis();
        Thread t = new Thread(new MessageLoop());
        t.start();

        threadMessage("Esperando que el hilo de ciclo de mensajes termine");
        //loop until MessageLoop
        //thread exits
        while(t.isAlive()){
          threadMessage("Aun esperando...");
          //wait maximun of 1 second
          //for MessageLoop thread
          //to finish
          t.join(1000);
          
        }
      }
    }
}
