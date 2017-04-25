/**
*PM2 Paktikum
*@autor Johannes Kruber
*@autor Luis Nickel
*/
package aufg5_quicksort;

public class Quicksort<T extends Comparable<T>> {
	T[] liste;

	void quicksort(int ilinks, int irechts) {
		T pivot;
		int i, j, tmp;
		if (irechts > ilinks) {
			i = ilinks;
			j = irechts - 1;
			pivot = liste[irechts];
			while (true) {
				while (liste[i].compareTo(pivot) > 0)
					i++;
				while (liste[j].compareTo(pivot) <= 0)
					j--;// Vorsicht:Stop-Element einbauen
				if (i >= j)
					break;// in der Mitte getroffen
				swap(i, j);// vertauschen

			}
			swap(i, irechts);// Pivotelement in die Mitte tauschen
			quicksort(ilinks, i - 1);
			quicksort(i + 1, irechts);
		}
	}

	void swap(int i, int j) {
		T tmp = liste[i];
		liste[i] = liste[j];
		liste[j] = tmp;
	}

}
