public class SleepMessagesIn{
  public static void main(String[] args) {
    String importantInfo[] = {
      "Muy cerca de mi ocaso, yo te bendigo, vida",
      "por que nunca me diste ni esperanza fallida",
      "ni trabajos injustos, ni pena inmerecida",
      "por que veo al final de mi rudo camino",
      "que yo fui el arquitecto de mi propio destino"
    };

    for(int i=0; i< importantInfo.length; i++){
      try{
        Thread.sleep(4000);
      }catch(InterruptedException e){
        //We've been interrupted: no more messages.
        return;
      }
      //Print a message
      System.out.println(importantInfo[i]);
    }
  }
}
