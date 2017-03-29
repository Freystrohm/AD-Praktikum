/**
 * PM2 Praktikum
 * @author Johannes Kruber
 * @author Luis Nickel 
 */
package aufg1_listen;

public class AufwandyanalyseListC
{
	private static IList<String> setupListe(IList<String> liste, int anzahl, ElementC<String> tail)
	{
		for (int i = 1; i <= anzahl; i++)
		{
			liste.insert("TestElement " + i, tail);
		}
		return liste;
	}

	public static void main(String[] args)
	{
		int k = 2;
		String key = "Element 5";
		ListeC<String> liste = new ListeC<String>();
		liste = (ListeC<String>) setupListe(liste, (int) Math.pow(10, k), liste.tail);

		liste.zaehler = 0;
		ElementC.zaehler = 0;
		liste.insert("TestText", liste.find(key));
		
		System.out.println("Insert:" + (liste.zaehler + ElementC.zaehler));
		
		liste.zaehler = 0;
		ElementC.zaehler = 0;
		String element = liste.retrieve(liste.find(key));
		
		System.out.println("retrieve:" + (liste.zaehler + ElementC.zaehler) + " TestText: " + element);
		
		liste.zaehler = 0;
		ElementC.zaehler = 0;
		liste.delete(liste.find(key));
		
		System.out.println("delete:" + (liste.zaehler + ElementC.zaehler));

	}

}
