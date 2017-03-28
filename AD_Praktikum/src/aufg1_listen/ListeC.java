/**
 * AD Praktikum
 * @author Johannes Kruber 
 */
package aufg1_listen;

public class ListeC<T> implements IList<T>
{
	// private Object[] array;
	private ElementC<T> head, tail;

	public ListeC()
	{
		// array = new Object[10];
		head = new ElementC<T>(null, 0);
		tail = new ElementC<T>(null, 0);
		// array[0] = head;
	}

	@Override
	public void insert(T element, int pos)
	{
		ElementC<T> temp = tail;

		if (tail.getIndex() <= pos)
		{
			ElementC<T> neuesElement=new ElementC<T>(element, tail.getIndex());
			findELe(tail.getIndex()-1).setNext(neuesElement);	
			neuesElement.setNext(tail);
		}
		else
		{
			do{
				temp = temp.getNext();
			}
			while (!(temp.getNext().getIndex() == pos));
			ElementC<T> neuesElement=new ElementC<T>(element, pos);
			neuesElement.setNext(temp.getNext());
			temp.setNext(neuesElement);
			temp=neuesElement;
			while(temp.getNext()!=tail){
				temp.getNext().setIndex(temp.getIndex()+1);
			}
			
		}
		tail.setIndex(tail.getIndex()+1);

	}

	@Override
	public void delete(int pos)
	{
		delete(findELe(pos));

	}

	@Override
	public void delete(String key)
	{
		delete(findELe(key));
	}

	private void delete(ElementC<T> element)
	{
		ElementC<T> temp = head;
		tail=element;
		while (temp.getNext()!=element){
			temp=temp.getNext();
		}
		temp.setNext(temp.getNext().getNext());
		while(temp.getNext()!=tail){
			temp.getNext().setIndex(temp.getIndex()-1);
		}
		tail.setIndex(tail.getIndex()-1);
		
	}

	@Override
	public int find(String key)
	{
		return findELe(key).getIndex();
	}

	private ElementC<T> findELe(String key)
	{	
		tail.setKey(key);
		ElementC<T> temp = tail;
		
		do{
			temp = temp.getNext();
		}while (temp.getKey().equals(key));
		return temp;
	}

	private ElementC<T> findELe(int pos)
	{
		ElementC<T> temp = tail;
		if(pos>=tail.getIndex()){
			return tail;
		}
		do{
			temp = temp.getNext();
		}while (temp.getIndex() == pos);
		
		return temp;
	}

	@Override
	public T retrieve(int pos)
	{
		return findELe(pos).element;
	}

	@Override
	public void concat(IList<T> liste)
	{
		if (liste instanceof ListeC)
		{
			ElementC<T> temp = findELe(tail.getIndex()-1);
			temp.setNext(((ListeC<T>) liste).head.getNext());
			tail=((ListeC<T>)liste).tail;
			tail.setNext(head);
			while(temp.getNext()!=tail){
				temp.getNext().setIndex(temp.getIndex()+1);
				temp=temp.getNext();
			}
			tail.setIndex(temp.getIndex()+1);
		}
	}

}
