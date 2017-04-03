package aufg2_primzahlen;

import java.util.Arrays;

public class Primzahlsuche
{
	public static int zaehlerLangsam = 0;
	public static int zahlerSchnell = 0;

	public Primzahlsuche()
	{
	}

	public static boolean[] langsameSuche(int n)
	{

		boolean[] a = new boolean[n];
		for (int i = 0; i < n; i++)
			a[i] = true;
		for (int i = 2; i < n; i++)
		{
			for (int j = 2; j < n; j++)
			{
				zaehlerLangsam++;
				if ((i % j == 0) && (j != i))
				{
					a[i] = false;
				}
			}
		}
		return a;// alle i fuer die a[i] noch auf true steht, sind Primzahlen
	}

	// Schneller durch: suche bis wurzel i, insert eines breaks und entfernen
	// von (j != i) abfrage
	public static boolean[] schnelleSuche(int n)
	{

		boolean[] a = new boolean[n];
		Arrays.fill(a, Boolean.TRUE);
		for (int i = 0; i < n; i++)
			a[i] = true;
		for (int i = 2; i < n; i++)
		{
			for (int j = 2; j < Math.sqrt(i); j++)
			{
				zahlerSchnell++;
				if ((i % j == 0))
				{
					a[i] = false;
					break;
				}
			}
		}
		return a;// alle i fuer die a[i] noch auf true steht, sind Primzahlen
	}

	public boolean istPrimzahl(int n)
	{
		for (int j = 2; j < Math.sqrt(n); j++)
		{
			if ((n % j == 0))
			{
				return false;
			}
		}
		return true;
	}

}
