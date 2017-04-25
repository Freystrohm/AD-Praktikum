/**
 * PMT/PT1 Praktikum Aufgabenblatt 
 * @author Johannes Kruber
 * @author Luis Nickel 
 */

package testsJunit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import aufg5_QuickSort.QuickSort;

public class Quicksort
{
	Integer[] array, in;
	int k = 30;
	@Before
	public void init()
	{
		array = new Integer[k];
		for (int i = 1; i <= array.length; i++)
		{
			array[i - 1] = i;
		}
		in = array.clone();
	}

	@Test
	public void rdmTest() throws Exception
	{
		QuickSort<Integer> sort = new QuickSort<Integer>(array);
		sort.shuffle();
		sort.quicksort(0, array.length - 1, 3);

		assertArrayEquals(in, array);
	}
	
	@Test
	public void lastTest() throws Exception
	{
		QuickSort<Integer> sort = new QuickSort<Integer>(array);
		sort.shuffle();
		sort.quicksort(0, array.length - 1, 1);

		assertArrayEquals(in, array);
	}
	
	@Test
	public void medianTest() throws Exception
	{
		QuickSort<Integer> sort = new QuickSort<Integer>(array);
		sort.shuffle();
		sort.quicksort(0, array.length - 1, 2);

		assertArrayEquals(in, array);
	}
	
	

}
