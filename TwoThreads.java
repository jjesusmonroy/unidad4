public class TwoThreads {
  public static class Thread1 extends Thread{
    public void run(){
      System.out.println("A");
      System.out.println("B");
      System.out.println("C");
      System.out.println("D");

    }
  }
  public static class Thread2 extends Thread{
    public void run(){
      System.out.println("1");
      System.out.println("2");
      System.out.println("3");

    }
  }
  public static void main(String[] args) {
    new Thread1().start();
    new Thread2().start();
    //Al correr podra cambiar el orden que tienen las salidas en vez de
    //ABCD123, estos pueden alterarse debido a que es programación concurrente
    //y no secuencial
  }
}
