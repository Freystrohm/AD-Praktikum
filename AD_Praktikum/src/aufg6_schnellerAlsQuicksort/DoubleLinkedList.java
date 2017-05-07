/**
*PM2 Paktikum
*@autor Johannes Kruber
*@autor Luis Nickel
*/
package aufg6_schnellerAlsQuicksort;

public class DoubleLinkedList {

	private Element head;
	private Element tail;
	private int anzEle=0;
	
	public DoubleLinkedList() {
		head=new Element(0);
		tail=new Element(0);
		head.setNext(tail);
		head.setPrev(tail);
		tail.setNext(head);
		tail.setPrev(head);
	}
	

	public Element getHead(){
		return head;
	}
	

	public Element getTail(){
		return tail;
	}
	
	public Element insert(Element newEle){
		anzEle++;
		Element nextEle=newEle.getNext();
	
			Element tmpEle=head;
			while(tmpEle.getNext()!=tail && newEle.getValue()>tmpEle.getNext().getValue()){
				tmpEle=tmpEle.getNext();
			}
		newEle.setNext(tmpEle.getNext());
		newEle.setPrev(tmpEle);
		tmpEle.setNext(newEle);
			

		return nextEle;
	}
	
	public int catArray(int index, int[] array){
		
		Element tmp=head;
		for(int i=0;i<anzEle;i++){
			array[index+i]= tmp.getValue();
			tmp=tmp.getNext();
		}
		return index+anzEle;
		
	}
}
