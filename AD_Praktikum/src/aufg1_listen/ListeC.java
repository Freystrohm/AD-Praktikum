/**
 * AD Praktikum
 * @author Johannes Kruber 
 */
package aufg1_listen;

public class ListeC<T> implements IList<T>
{
	// private Object[] array;
	 ElementC<T> head, tail;
	public int zaehler;

	public ListeC()
	{
		zaehler=0;
		// array = new Object[10];
		head = new ElementC<T>(null);
		tail = new ElementC<T>(null);
		head.setNext(tail);
		tail.setNext(head);
		zaehler+=2;
	
		// array[0] = head;
	}

	@Override
	public void insert(T element, Object pos)
	{
		if(pos instanceof ElementC){
			tail=(ElementC<T>)pos;
			ElementC<T> temp = head;
			
			zaehler++;
			do{
				zaehler++;
				temp = temp.getNext();
				zaehler++;
			}while (temp.getNext()!= tail);
			zaehler++;
			ElementC<T> neuesElement=new ElementC<T>(element);
			neuesElement.setNext(temp.getNext());
			temp.setNext(neuesElement);
			zaehler++;
			temp=neuesElement;	
		}
		

	}

	@Override
	public void delete(Object pos)
	{
		zaehler++;
		if(pos instanceof ElementC){
			delete((ElementC)pos);
		}
		

	}

	@Override
	public void delete(String key)
	{
		delete((ElementC<T>)find(key));
	}

	private void delete(ElementC<T> element)
	{
		zaehler++;
		ElementC<T> temp = head;
		zaehler++;
		tail=element;
		while (temp.getNext()!=element){
			zaehler++;
			zaehler++;
			temp=temp.getNext();
		}
		if(temp.getNext().getNext()!=head){
		temp.setNext(temp.getNext().getNext());
		}
	}

	@Override
	public Object find(String key)
	{
		tail.setKey(key);
		zaehler++;
		ElementC<T> temp = head;
		
		do{
			zaehler++;
			temp = temp.getNext();
			zaehler++;
		}while (!temp.getKey().equals(key));
		return temp;
	}

	@Override
	public T retrieve(Object pos)
	{
		if(pos instanceof ElementC){
			
		return ((ElementC<T>)pos).element;
		}
		return null;
	}

	@Override
	public void concat(IList<T> liste)
	{
		if (liste instanceof ListeC)
		{
			zaehler++;
			ElementC<T> temp=head;
			while(temp.getNext()!=tail){
				zaehler++;
				temp=temp.getNext();
				zaehler++;
			}
			temp.setNext(((ListeC<T>) liste).head.getNext());
			zaehler++;
			tail=((ListeC<T>)liste).tail;
			tail.setNext(head);
			
		}
	}

	public ElementC<T> getHead(){
		return head;
	}
}
