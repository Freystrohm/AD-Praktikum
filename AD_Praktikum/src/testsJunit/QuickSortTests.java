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

public class QuickSortTests
{
	Integer[] array, in;
	int k = 10000;
	int piv = 3;
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
		sort.zaehler = 0;
		sort.shuffle();
		sort.quicksort(0, array.length - 1, 3);
		// System.out.println("RDM: " + sort.zaehler);
		assertArrayEquals(in, array);
	}

	@Test
	public void lastTest() throws Exception
	{
		QuickSort<Integer> sort = new QuickSort<Integer>(array);
		sort.zaehler = 0;
		sort.shuffle();
		sort.quicksort(0, array.length - 1, 1);
		// System.out.println("last: " + sort.zaehler);
		assertArrayEquals(in, array);
	}

	@Test
	public void medianTest() throws Exception
	{
		QuickSort<Integer> sort = new QuickSort<Integer>(array);
		sort.zaehler = 0;
		sort.shuffle();
		sort.quicksort(0, array.length - 1, 2);
		// System.out.println("Median: " + sort.zaehler);
		assertArrayEquals(in, array);
	}

	@Test
	public void analyseav() throws Exception
	{
		Integer[] array;
		QuickSort<Integer> sort;
		System.out.println("\nAvg:");
		for (int k = 1; k <= 10000; k = k * 10)
		{
			array = new Integer[k];
			for (int i = 1; i <= array.length; i++)
			{
				array[i - 1] = i;
			}
			in = array.clone();

			sort = new QuickSort<Integer>(array);
			sort.zaehler = 0;
			sort.shuffle();
			sort.quicksort(0, array.length - 1, piv);
			System.out.println("N=" + k + "\nAufwand: " + sort.zaehler);
			assertArrayEquals(in, array);
		}
	}

	@Test
	public void analysebest() throws Exception
	{
		Integer[] array;
		QuickSort<Integer> sort;
		System.out.println("\nBest:");
		for (int k = 1; k <= 10000; k = k * 10)
		{
			array = new Integer[k];
			for (int i = 1; i <= array.length; i++)
			{
				array[i - 1] = i;
			}
			in = array.clone();

			sort = new QuickSort<Integer>(array);
			sort.zaehler = 0;
			sort.quicksort(0, array.length - 1, piv);
			System.out.println("N=" + k + "\nAufwand: " + sort.zaehler);
			assertArrayEquals(in, array);
		}
	}

	@Test
	public void analyseworst() throws Exception
	{
		Integer[] array;
		QuickSort<Integer> sort;
		System.out.println("\nWorst:");
		for (int k = 1; k <= 10000; k = k * 10)
		{
			array = new Integer[k];
			for (int i = 0; i < array.length; i++)
			{
				array[i] = array.length - i;
			}
			in = new Integer[k];

			for (int i = 1; i <= array.length; i++)
			{
				in[i - 1] = i;
			}

			sort = new QuickSort<Integer>(array);
			sort.zaehler = 0;
			sort.quicksort(0, array.length - 1, piv);
			System.out.println("N=" + k + "\nAufwand: " + sort.zaehler);
			assertArrayEquals(in, array);
		}
	}

}
