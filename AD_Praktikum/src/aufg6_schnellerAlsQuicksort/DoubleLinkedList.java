/**
*PM2 Paktikum
*@autor Johannes Kruber
*@autor Luis Nickel
*/
package aufg6_schnellerAlsQuicksort;

public class DoubleLinkedList <T extends Comparable<T>> {

	private Element<T> head;
	private Element<T> tail;
	private int anzEle=0;
	
	public void setHead(Element<T> head){
		this.head=head;
	}
	public Element<T> getHead(){
		return head;
	}
	
	public void setTail(Element<T> tail){
		this.tail=tail;
	}
	public Element<T> getTail(){
		return tail;
	}
	
	public void insert(Element<T> newEle){
		anzEle++;
		Element<T> tmpEle=head;
		while(tmpEle.compareTo(newEle)>0&&tmpEle!=tail){
			tmpEle=tmpEle.getNext();
		}
		tmpEle.getPrev().setNext(newEle);
		newEle.setPrev(tmpEle.getPrev());
		newEle.setNext(tmpEle);
		tmpEle.setPrev(newEle);
		if(newEle.getPrev()==null){
			head=newEle;
		}
		if(newEle.getNext()==null){
			tail=newEle;
		}
	}
	
	public int catArray(int index, T[] array){
		
		Element<T> tmp=head;
		for(int i=0;i<anzEle;i++){
			array[index+i]=tmp.getValue();
			tmp=tmp.getNext();
		}
		return index+anzEle;
		
	}
}
