/**
 * AD Praktikum
 * @author Johannes Kruber 
 */
package aufg1_listen;

class ElementC<T>
{
	private ElementC<T> next;
	private String key;
	T element;
	public static int zaehler=0;
	
	private static int nextKey = 0;
	
	public ElementC(T element)
	{
		zaehler++;
		this.element = element;
		zaehler++;
		key = "Element " + nextKey;
		zaehler++;
		nextKey++;
	}
	
	
	//Getter---------------------------------------------
	
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
		zaehler++;
		this.next = next;
	}
	
	public void setKey(String key){
		zaehler++;
		this.key=key;
	}
	
	
	//-------------------------------------------------------
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object ele)
	{
		zaehler++;
		if(ele instanceof ElementC<?>)
		{
			zaehler++;
			if(((ElementC<T>) ele).key.equals(this.key) )
			{
				return true;
			}		
		}
		
		return false;
	}
}
