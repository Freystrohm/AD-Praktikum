/**
 * AD Praktikum
 * @author Johannes Kruber 
 */
package aufg1_listen;

class ElementC<T>
{
	private ElementC<T> next;
	private int index;
	private String key;
	T element;
	
	private static int nextKey = 0;
	
	public ElementC(T element, int index)
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
	
	public ElementC<T> getNext()
	{
		return next;
	}
	

	
	public String getKey()
	{
		return key;
	}
	
	//Setter---------------------------------------------

	public void setNext(ElementC<T> next)
	{
		this.next = next;
	}
	
	public void setIndex(int index)
	{
		this.index = index;
	}
	public void setKey(String key){
		this.key=key;
	}
	
	
	//-------------------------------------------------------
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object ele)
	{
		if(ele instanceof ElementC<?>)
		{
			if(((ElementC<T>) ele).key.equals(this.key) )
			{
				return true;
			}		
		}
		
		return false;
	}
}
