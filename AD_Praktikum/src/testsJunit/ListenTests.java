/**
 * PM2 Praktikum
 * @author Johannes Kruber
 * @author Luis Nickel 
 */
package testsJunit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import aufg1_listen.*;
import junit.framework.TestCase;

public class ListenTests
{
	int k = 1;
	int anzahl = 0;

	@Before
	public void setUp()
	{
		anzahl = (int) Math.pow(10, k);
	}

	public IList setUpListeB(int anzahl)
	{
		IList<String> liste = new ListeB();
		liste = setupListe(liste, anzahl);
		return liste;
	}

	private IList setupListe(IList liste, int anzahl)
	{
		for (int i = 1; i <= anzahl; i++)
		{
			liste.insert("TestElement " + i, i);
		}
		return liste;
	}

	@Test
	public void analyse()
	{
		IList liste = setUpListeB(anzahl);

	}

}
