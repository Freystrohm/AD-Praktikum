/**
 * RDDL-Sort
 * @author Johannes Kruber
 */
package rddlSort;

public class RddlElement<T>
{
	private int key;
	private RddlElement next, previous;
	T ele;

	public RddlElement(T ele, int key)
	{
		this.key = key;
		this.ele = ele;
	}

	public RddlElement(T ele, int key, RddlElement<T> next,
			RddlElement<T> previous)

	{
		this(ele, key);
		this.next = next;
		this.previous = previous;
	}

	public T getEle()
	{
		return ele;
	}

	public int getKey()
	{
		return key;
	}

	public RddlElement<T> getNext()
	{
		return next;
	}

	public RddlElement<T> getPrevious()
	{
		return previous;
	}

	public void setNext(RddlElement<T> next)
	{
		this.next = next;
	}

	public void setPrevious(RddlElement<T> previous)
	{
		this.previous = previous;
	}

}
