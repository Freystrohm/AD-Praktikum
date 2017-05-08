/**
 * PM2 Praktikum
 * @author Johannes Kruber
 * @author Luis Nickel 
 */
package rddlSort;

public class Sort<T>
{
	private RddlElement<T>[] array;
	private RddlElement<T> max, min;

	public Sort(RddlElement<T>[] array, RddlElement<T> max, RddlElement<T> min)
	{
		this.array = array;
		this.max = max;
		this.min = min;
	}
}
