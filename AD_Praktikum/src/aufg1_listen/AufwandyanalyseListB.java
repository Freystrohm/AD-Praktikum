/**
 * PM2 Praktikum
 * @author Johannes Kruber
 * @author Luis Nickel 
 */
package aufg1_listen;

public class AufwandyanalyseListB
{
	private static IList<String> setupListe(IList<String> liste, int anzahl, ElementB<String> tail)
	{
		for (int i = 1; i <= anzahl; i++)
		{
			liste.insert("TestElement " + i, tail);
		}
		return liste;
	}

	public static void main(String[] args)
	{
		int k = 1;
		String key = "Element 5";
		ListeB<String> liste = new ListeB<String>();
		liste = (ListeB<String>) setupListe(liste, (int) Math.pow(10, k), liste.tail);

		liste.zaehler = 0;
		ElementB.zaehler = 0;
		liste.insert("TestText", liste.find(key));
		
		System.out.println("Insert:" + (liste.zaehler + ElementB.zaehler));
		
		liste.zaehler = 0;
		ElementB.zaehler = 0;
		String element = liste.retrieve(liste.find(key));
		
		System.out.println("retrieve:" + (liste.zaehler + ElementB.zaehler) + " TestText: " + element);
		
		liste.zaehler = 0;
		ElementB.zaehler = 0;
		liste.delete(liste.find(key));
		
		System.out.println("delete:" + (liste.zaehler + ElementB.zaehler));

	}

}
