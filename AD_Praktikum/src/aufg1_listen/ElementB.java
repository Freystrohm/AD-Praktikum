/**
 * AD Praktikum
 * @author Johannes Kruber 
 */
package aufg1_listen;

public class ElementB<T>
{
	private ElementB<T> previous, next;
	private int index;
	T ele;
	
	private static int key;
	
	public int getIndex()
	{
		return index;
	}
	
	public ElementB<T> getNext()
	{
		return next;
	}
	
	public ElementB<T> getPrevious()
	{
		return previous;
	}
}
