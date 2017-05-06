/**
*PM2 Paktikum
*@autor Johannes Kruber
*@autor Luis Nickel
*/
package aufg6_schnellerAlsQuicksort;

public class Element <T extends Comparable<T>>{
	private Element<T> next;
	private Element<T> prev;
	private static Element head;
	private static Element tail;
	private T value;
	
	public void setTail(Element<T> tail){
		this.tail=tail;
	}
	public Element<T> getTail(){
		return tail;
	}
	public void setHead(Element<T> head){
		this.head=head;
	}
	public Element<T> getHead(){
		return head;
	}
	
	public T getValue(){
		return value;
	}
	public Element(T value){
		this.value=value;
	}
	public void setNext(Element<T> next){
		this.next=next;
	}
	public void setPrev(Element<T> prev){
		this.prev=prev;
	}
	public Element<T> getPrev(){
		return prev;
	}
	public Element<T> getNext(){
		return next;
	}
	
	public int compareTo(Element<T> e2){
		return value.compareTo(e2.value);
	}


}
