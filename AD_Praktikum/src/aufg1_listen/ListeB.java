/**
 * AD Praktikum
 * @author Johannes Kruber 
 */
package aufg1_listen;

public class ListeB<T> implements IList<T>
{
	//private Object[] array;
	ElementB<T> head, tail;

	public ListeB()
	{
		//array = new Object[10];
		head = new ElementB<T>(null, 0);
		tail = head;
		//array[0] = head;
	}

	@Override
	public void insert(T element, int pos)
	{
		ElementB<T> temp = head;
		
		if(head.equals(tail))
		{
			tail = new ElementB<T>(element, 1);
			//array[1] = tail;
			head.setNext(tail);
			tail.setPrevious(head);
		}
		else if(tail.getIndex() <= pos)
		{
			temp = tail;
			tail = new ElementB<T>(element, temp.getIndex() + 1);
			tail.setPrevious(temp);
			temp.setNext(tail);
		}
		else
		{
			while(!(temp.getIndex() == pos))
			{
				temp = temp.getNext();
			}
			temp.getPrevious().setNext(new ElementB<T>(element, pos));
			temp.getPrevious().getNext().setPrevious(temp.getPrevious());
			temp.setPrevious(temp.getPrevious().getNext());
			temp.getPrevious().setNext(temp);
		}
		
	}

	@Override
	public void delete(int pos)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String key)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public int find(String key)
	{
		return findELe(key).getIndex();
	}
	
	private ElementB<T> findELe(String key)
	{
		ElementB<T> temp = head;
		while(temp != tail && !temp.getKey().equals(key))
		{
			temp = temp.getNext();
		}
		return temp;
	}
	
	private ElementB<T> findELe(int pos)
	{
		ElementB<T> temp = head;
		while(temp != tail && !(temp.getIndex() == pos))
		{
			temp = temp.getNext();
		}
		return temp;
	}
	

	@Override
	public T retrieve(int pos)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void concat(IList<T> liste)
	{
		// TODO Auto-generated method stub
		
	}

}
