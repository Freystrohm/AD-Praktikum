package aufg2_primzahlen;

public class Main {

  public static void main(String[] args) {
    SiebDesEratosthenes test = new SiebDesEratosthenes(20);
    test.sieben();
    test.siebAusgeben();
    System.out.println("");
    System.out.println(test.getZaehler());
  }
}
