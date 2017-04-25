package testsJunit;

import static org.junit.Assert.*;

import org.junit.Test;

import com.sun.jmx.remote.security.NotificationAccessController;

import aufg5_quicksort.Quicksort;
import aufg5_quicksort.Quicksort.Suchverfahren;

public class QuicksortTest {

	
	@Test
	public void testQuicksortZufall() {
		int arraygroesse=50;
		Integer[] testArray=Quicksort.createBSArray(arraygroesse);
		Quicksort<Integer> qs = new Quicksort<Integer>( Suchverfahren.ZUFALL, Quicksort.createBSArray(arraygroesse));
		qs.shuffe(200);
		qs.quicksort();
		assertArrayEquals(testArray, qs.getListe());
	}
	@Test
	public void testQuicksortEnde() {
		int arraygroesse=50;
		Integer[] testArray=Quicksort.createBSArray(arraygroesse);
		Quicksort<Integer> qs = new Quicksort<Integer>( Suchverfahren.ENDE, Quicksort.createBSArray(arraygroesse));
		qs.shuffe(200);
		qs.quicksort();
		assertArrayEquals(testArray, qs.getListe());
	}
	
	@Test
	public void testQuicksortMedian() {
		int arraygroesse=50;
		Integer[] testArray=Quicksort.createBSArray(arraygroesse);
		Quicksort<Integer> qs = new Quicksort<Integer>( Suchverfahren.DREIMEDIAN, Quicksort.createBSArray(arraygroesse));
		qs.shuffe(200);
		qs.quicksort();
		assertArrayEquals(testArray, qs.getListe());
	}

	@Test
	public void testIndexPivotMedian() {
		int arraygroesse=5;
		Quicksort<Integer> qs = new Quicksort<Integer>( Suchverfahren.DREIMEDIAN, Quicksort.createBSArray(arraygroesse));
		
		assertTrue(qs.indexPivotMedian(0, 4)==2);
	
	}
	@Test
	public void testShuffle() {
		int arraygroesse=50;
		Integer[] testArray=Quicksort.createBSArray(arraygroesse);
		Quicksort<Integer> qs = new Quicksort<Integer>( Suchverfahren.ZUFALL, Quicksort.createBSArray(arraygroesse));
		qs.shuffe(1000);
		boolean istUnterschiedlich=false;
		for (int i = 0; i < testArray.length; i++) {
			if(qs.getListe()[i]!=testArray[i]){
				istUnterschiedlich=true;
				break;
			}	
		}
		assertTrue(istUnterschiedlich);
	}
}
