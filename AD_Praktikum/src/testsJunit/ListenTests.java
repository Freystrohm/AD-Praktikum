/**
 * PM2 Praktikum
 * @author Johannes Kruber
 * @author Luis Nickel 
 */
package testsJunit;

import static org.junit.Assert.*;

import org.junit.Test;
import aufg1_listen.*;


public class ListenTests
{	
	
	
	public void testInsert(IList<String> liste , String key)
	{
		liste.insert("TestElement 1", liste.find(""));
		liste.insert("TestElement 2", liste.find(""));
		liste.insert("TestElement 3", liste.find(""));
		liste.insert("TestElement 4", liste.find(""));
		assertEquals("TestElement 3", liste.retrieve(liste.find(key)));
	}
	
	@Test
	public void testInsertListA()
	{
		IList<String> liste = new ListeA();
		testInsert(liste, "3");
	}
	
	@Test
	public void testInsertListB()
	{
		IList<String> liste = new ListeB<String>();
		testInsert(liste,"Element 4");
	}
	
	@Test
	public void testInsertListC()
	{
		IList<String> liste = new ListeC<String>();
		testInsert(liste,"Element 4");
	}
	
	@Test
	public void testDeleteB()
	{
		IList<String> liste = new ListeB<String>();
		testDelete(liste, "Element 3");
				
	}
	
	@Test
	public void testDeleteC()
	{
		IList<String> liste = new ListeC<String>();
		testDelete(liste, "Element 3");
	}
	
	@Test
	public void testDeleteA()
	{
		IList<String> liste = new ListeA<String>();
		testDelete(liste, "2");
	}
	
	public void testDelete(IList<String> liste, String key)
	{
		liste.insert("TestElement 1", liste.find(""));
		liste.insert("TestElement 2", liste.find(""));
		liste.insert("TestElement 3", liste.find(""));
		liste.insert("TestElement 4", liste.find(""));
		
		assertEquals("TestElement 2", liste.retrieve(liste.find(key)));
		
		liste.delete(key);
		assertEquals(null, liste.retrieve(liste.find(key)));
	}
	
	

}
