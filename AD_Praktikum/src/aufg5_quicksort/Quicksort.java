/**
*PM2 Paktikum
*@autor Johannes Kruber
*@autor Luis Nickel
*/
package aufg5_quicksort;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;




public class Quicksort<T extends Comparable<T>> {
	private T[] liste;
	private Suchverfahren sv;
	private int zaehler;

	public Quicksort( Suchverfahren sv, T[] liste) {
		
		this.liste = liste;
		this.sv = sv;
	}
	public T[] getListe(){
		return liste;
	}
/**
 * Init Quicksort
 */
	public void quicksort(){
		zaehler=0;
		quicksort(0,liste.length-1 );
	
	}
	private void printArray(){
		for (int i = 0; i < liste.length; i++) {
			System.out.println(liste[i]);
		}
	}
	/**
	 * Quicksort
	 * @param ilinks
	 * @param irechts
	 */
	public void quicksort(int ilinks, int irechts) {
		T pivot;
		int i, j;
		if (irechts > ilinks) {
			i = ilinks;
			j = irechts - 1;
			int pivotIndex=pivotZuweisung(ilinks, irechts);
			pivot=liste[pivotIndex];
			swap(irechts,pivotIndex);
			while (true) {
				while (liste[i].compareTo(pivot) < 0){
					i++;
					zaehler++;}
				while (liste[j].compareTo(pivot) > 0 && j != 0){
					j--;// Vorsicht:Stop-Element einbauen
					zaehler++;}
				if (i >= j)
					break;// in der Mitte getroffen
				swap(i, j);// vertauschen

			}
			swap(i, irechts);// Pivotelement in die Mitte tauschen
			quicksort(ilinks, i - 1);
			quicksort(i + 1, irechts);
		}
	}

/**
 * Swap-Methode
 * @param i
 * @param j
 */
	void swap(int i, int j) {
		T tmp = liste[i];
		liste[i] = liste[j];
		liste[j] = tmp;
	}
	/**
	 * 
	 * @param ilinks
	 * @param irechts
	 * @return
	 */
	public int pivotZuweisung(int ilinks,int irechts){
		switch (sv) {
		case ENDE:
			return irechts;
		case DREIMEDIAN:
			return indexPivotMedian(ilinks, irechts);
		default:
			return pivotZufall(ilinks, irechts);	
		}
	}
	public static void main(String[] args) {
		Quicksort<Integer> qs = new Quicksort<Integer>( Suchverfahren.ENDE, createBSArray(10000));
			
			qs.quicksort();
			System.out.println(qs.zaehler);
	

	}
	public int getZaehler(){
		return zaehler;
	}
	
	public static Integer[] createBSArray(int arrayGroesse){
		Integer[] array=new Integer[arrayGroesse];
		for (int i = 0; i < array.length; i++) {
			array[i]=i+1;
		}
		return array;
	}
	public static Integer[] createWSArray(int arrayGroesse){
		Integer[] array=new Integer[arrayGroesse];
		for (int i = 0; i < array.length; i++) {
			array[i]=array.length-i;
		}
		return array;
	}
	public void shuffe(int anzahl){
		for(int i=0;i<liste.length*anzahl;i++){
			swap((int)(i*Math.random())/anzahl,(int)(i*Math.random()/anzahl));
		}
	}

	public int indexPivotMedian(int ilinks,int irechts){
		T firstEle=liste[ilinks];
		T middleEle=liste[(int)((ilinks+irechts)/2)];
		T lastEle=liste[irechts];
		if((firstEle.compareTo(middleEle)>0 && firstEle.compareTo(lastEle)<0 ||
				firstEle.compareTo(middleEle)<0 && firstEle.compareTo(lastEle)>0)) {
			
			return ilinks;
		}
		else if((middleEle.compareTo(firstEle)>0 && middleEle.compareTo(lastEle)<0) ||
				(middleEle.compareTo(firstEle)<0 && middleEle.compareTo(lastEle)>0)){
		
			return (int)((ilinks+irechts)/2);
		}
		return irechts;
	}


	private int pivotZufall(int ilinks, int irechts){
		return ((int) (ilinks + (irechts - ilinks) * Math.random()));
	}
	public enum Suchverfahren {
		DREIMEDIAN, ZUFALL, ENDE
	}

}
