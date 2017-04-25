/**
 * PM2 Praktikum
 * @author Johannes Kruber
 * @author Luis Nickel 
 */
package aufg5_QuickSort;

public class QuickSort<T extends Comparable<T>>
{
	T[] array;

	public QuickSort(T[] array)
	{
		this.array = array;
	}

	public T findPivotMedian()
	{
		T fEle = array[0], lEle = array[array.length - 1],
				mEle = array[array.length / 2];
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

		return null;
	}

	public T findPivotRdm()
	{
		return array[(int) (Math.random() * (array.length - 1))];
	}

	@SuppressWarnings("unchecked")
	private T[] sortToLast(T ele, T[] array) throws Exception
	{
		int index = -1;
		for (int i = 0; i < array.length; i++)
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

		Object[] temp = new Object[array.length];
		System.arraycopy(array, 0, temp, 0, index);
		System.arraycopy(array, index + 1, temp, index,
				array.length - index - 1);
		temp[temp.length - 1] = ele;
		return (T[]) temp;
	}

	public T findPivotLast()
	{
		return array[array.length - 1];
	}

	public void quicksort(int links, int rechts, T pivot)
	{
		int ilinks = 0, irechts = array.length - 2;

	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
