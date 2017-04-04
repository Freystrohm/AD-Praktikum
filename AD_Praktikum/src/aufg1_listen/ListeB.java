/**
 * AD Praktikum
 * @author Johannes Kruber 
 */
package aufg1_listen;

public class ListeB<T> implements IList<T>
{
	// private Object[] array;
	ElementB<T> head, tail;
	public int zaehler;

	public ListeB()
	{
		zaehler = 0;
		head = new ElementB<T>(null);
		zaehler++;
		tail = new ElementB<T>(null);
		head.setNext(tail);
		tail.setPrevious(head);
		zaehler++;
	}

	@Override
	public void insert(T element, Object pos)
	{
		if (pos instanceof ElementB)
		{
			zaehler++;
			ElementB<T> temp = (ElementB<T>)pos;
			zaehler++;

			if (head.getNext().equals(tail))
			{
				zaehler++;
				tail.setPrevious(new ElementB<T>(element));
				// array[1] = tail;
				head.setNext(tail.getPrevious());
				tail.getPrevious().setNext(tail);
				tail.getPrevious().setPrevious(head);
			}
			else
			{
				temp.getPrevious().setNext(new ElementB<T>(element));
				temp.getPrevious().getNext().setPrevious(temp.getPrevious());
				temp.setPrevious(temp.getPrevious().getNext());
				temp.getPrevious().setNext(temp);
			}
		}

	}

	@Override
	public void delete(Object pos)
	{
		if (pos instanceof ElementB)
		{
			zaehler++;
			delete((ElementB<T>) pos);
		}

	}

	@Override
	public void delete(String key)
	{
		delete(find(key));
	}

	private void delete(ElementB<T> element)
	{
		if(element!=tail)
		{
				element.getNext().setPrevious(element.getPrevious());
				element.getPrevious().setNext(element.getNext());
				element.setNext(null);
				element.setPrevious(null);
		}
	}

	@Override
	public ElementB<T> find(String key)
	{
		zaehler++;
		return findELe(key);
	}

	private ElementB<T> findELe(String key)
	{
		ElementB<T> temp = head;
		zaehler++;
		while (temp != tail && !temp.getKey().equals(key))
		{
			zaehler++;
			temp = temp.getNext();
			zaehler++;
		}
		return temp;
	}

	// private ElementB<T> findELe(int pos)
	// {
	// ElementB<T> temp = head;
	// while (temp != tail && !(temp.getIndex() == pos))
	// {
	// temp = temp.getNext();
	// }
	// return temp;
	// }

	@Override
	public T retrieve(Object pos)
	{
		if (pos instanceof ElementB)
		{
			zaehler++;
			return ((ElementB<T>) pos).element;
		}
		return null;
	}

	@Override
	public void concat(IList<T> liste)
	{
		ElementB<T> temp = tail.getPrevious();
		zaehler++;
		if (liste instanceof ListeB)
		{
			zaehler++;
			temp.setNext(((ListeB<T>) liste).head.getNext());
			tail.setPrevious(((ListeB<T>) liste).tail.getPrevious());
			((ListeB<T>) liste).tail.getPrevious().setNext(tail);
			((ListeB<T>) liste).head.getNext().setPrevious(temp);
			((ListeB<T>) liste).head.setNext(((ListeB<T>) liste).tail);
			((ListeB<T>) liste).tail.setPrevious(((ListeB<T>) liste).head);
		}
	}

}
