/**
 * @author Johannes Kruber
 */
package aufg5_QuickSort;

public class QuickSort<T extends Comparable<T>>
{
	private T[] array;
	
	public int zaehler = 0;

	public QuickSort(T[] array)
	{
		this.array = array;
	}

	private T findPivotMedian(int links, int rechts)
	{
		T fEle = array[links], lEle = array[rechts],
				mEle = array[(links + rechts) / 2];
		if ((fEle.compareTo(lEle) < 0 && fEle.compareTo(mEle) > 0)
				|| (fEle.compareTo(lEle) > 0 && fEle.compareTo(mEle) < 0))
		{
			return fEle;
		}
		if ((mEle.compareTo(lEle) > 0 && mEle.compareTo(fEle) < 0)
				|| (mEle.compareTo(lEle) < 0 && mEle.compareTo(fEle) > 0))
		{
			return mEle;
		}
		if ((lEle.compareTo(fEle) < 0 && lEle.compareTo(mEle) > 0)
				|| (lEle.compareTo(fEle) > 0 && lEle.compareTo(mEle) < 0))
		{
			return lEle;
		}
		else
		{
			return mEle;
		}

		// return null;
	}

	private T findPivotRdm(int links, int rechts)
	{
		return array[((int) (Math.random() * (rechts - links))) + links];
	}

	private T findPivotLast(int rechts)
	{
		return array[rechts];
	}

	private void sortToLast(T ele, int links, int rechts) throws Exception
	{
		int index = -1;
		for (int i = links; i <= rechts; i++)
		{
			if (ele.compareTo(array[i]) == 0)
			{
				index = i;
				break;
			}
		}

		if (index < 0)
		{
			throw new Exception("Element nicht vorhanden");
		}
		swap(index, rechts);

	}

	private T findPivot(int links, int rechts, int suche) throws Exception
	{
		T pivot;
		switch (suche)
		{
			case 1 :
				pivot = findPivotLast(rechts);
				break;
			case 2 :
				pivot = findPivotMedian(links, rechts);
				break;
			case 3 :
				pivot = findPivotRdm(links, rechts);
				break;
			default :
				pivot = array[links];
		}

		sortToLast(pivot, links, rechts);
		return pivot;
	}

	public void quicksort(int links, int rechts, int suche) throws Exception
	{
		if (links >= rechts)
		{
			return;
		}
		T pivot = findPivot(links, rechts, suche);
		int ilinks = links, irechts = rechts - 1;

		while (true)
		{
			while (array[ilinks].compareTo(pivot) < 0)
			{
				ilinks++;
				zaehler++;
			}
			while (array[irechts].compareTo(pivot) > 0 && irechts != ilinks)
			{
				irechts--;
				zaehler++;
			}

			if (ilinks == irechts)
			{
				break;
			}
			else if (ilinks > irechts)
			{
				irechts = ilinks;
				System.out.println("ilinks > irechts");
				break;
			}
			
			swap(ilinks, irechts);
		}
		swap(irechts, rechts);
		quicksort(links, ilinks - 1, suche);
		quicksort(irechts + 1, rechts, suche);
	}

	private void swap(int ilinks, int irechts)
	{
		T temp = array[ilinks];
		array[ilinks] = array[irechts];
		array[irechts] = temp;
	}

	public void shuffle()
	{
		for (int i = 0; i < array.length * 100; i++)
		{
			swap((int) (Math.random() * (array.length)),
					(int) (Math.random() * (array.length)));
		}
	}

	public static void main(String[] args) throws Exception
	{
		Integer[] array = new Integer[30];
		for (int i = 1; i <= array.length; i++)
		{
			array[i - 1] = i;
		}
		QuickSort<Integer> sort = new QuickSort<Integer>(array);

		sort.shuffle();

		sort.quicksort(0, array.length - 1, 3);
		System.out.println("Ende");
	}

}
