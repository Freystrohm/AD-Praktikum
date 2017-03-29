/**
 * AD Praktikum
 * @author Johannes Kruber 
 */
package aufg1_listen;

class ElementB<T>
{
	private ElementB<T> previous, next;
	//private int index;
	private String key;
	T element;
	
	private static int nextKey = 0;
	public static int zaehler = 0;
	
	public ElementB(T element)
	{
		this.element = element;
		zaehler++;
		key = "Element " + nextKey;
		zaehler++;
		nextKey++;
		zaehler++;
	}
	
	
	//Getter---------------------------------------------	
	public ElementB<T> getNext()
	{
		return next;
	}
	
	public ElementB<T> getPrevious()
	{
		return previous;
	}
	
	public String getKey()
	{
		return key;
	}
	
	//Setter---------------------------------------------
	public void setPrevious(ElementB<T> previous)
	{
		this.previous = previous;
		zaehler++;
	}
	
	public void setNext(ElementB<T> next)
	{
		this.next = next;
		zaehler++;
	}
	//-------------------------------------------------------
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object ele)
	{
		if(ele instanceof ElementB<?>)
		{
			zaehler++;
			if(((ElementB<T>) ele).key.equals(this.key) )
			{
				zaehler++;
				return true;
			}		
		}
		
		return false;
	}
}
