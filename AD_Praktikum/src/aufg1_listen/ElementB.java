/**
 * AD Praktikum
 * @author Johannes Kruber 
 */
package aufg1_listen;

class ElementB<T>
{
	private ElementB<T> previous, next;
	private int index;
	private String key;
	T element;
	
	private static int nextKey = 0;
	
	public ElementB(T element, int index)
	{
		this.element = element;
		this.index = index;
		key = "Element " + nextKey;
		nextKey++;
	}
	
	
	//Getter---------------------------------------------
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
	
	public String getKey()
	{
		return key;
	}
	
	//Setter---------------------------------------------
	public void setPrevious(ElementB<T> previous)
	{
		this.previous = previous;
	}
	
	public void setNext(ElementB<T> next)
	{
		this.next = next;
	}
	
	public void setIndex(int index)
	{
		this.index = index;
	}
	
	
	//-------------------------------------------------------
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object ele)
	{
		if(ele instanceof ElementB<?>)
		{
			if(((ElementB<T>) ele).key.equals(this.key) )
			{
				return true;
			}		
		}
		
		return false;
	}
}
