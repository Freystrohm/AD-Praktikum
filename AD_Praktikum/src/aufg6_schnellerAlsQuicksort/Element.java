/**
*PM2 Paktikum
*@autor Johannes Kruber
*@autor Luis Nickel
*/
package aufg6_schnellerAlsQuicksort;

public class Element {
	private Element next;
	private Element prev;

	private int value;
	
	public Integer getValue(){
		return value;
	}
	public Element(int value){
		this.value=value;
	}
	public void setNext(Element next){
		this.next=next;
	}
	public void setPrev(Element prev){
		this.prev=prev;
	}
	public Element getPrev(){
		return prev;
	}
	public Element getNext(){
		return next;
	}
	
	


}
