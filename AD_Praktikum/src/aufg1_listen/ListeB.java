/**
 * AD Praktikum
 * @author Johannes Kruber 
 */
package aufg1_listen;

public class ListeB<T>
{
	private Object[] array;
	ElementB<T> head, tail;
	
	
	@SuppressWarnings("unchecked")
	public ListeB()
	{
		array = new Object[10];
		head = new ElementB<T>(null, 0);
		array[0] = head;
	}
	
	//to be done
	public void insert(T element, int pos)
	{
		if(head.equals(tail))
		{
			tail = new ElementB<T>(element, 1);
			array[1] = tail;
			head.setNext(tail);
		}
		else if(tail.getIndex() >= pos)
		{
			
		}
	}
	
	
	
}
