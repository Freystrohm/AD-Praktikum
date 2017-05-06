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
	
	
	public void setHead(Element head){
		this.head=head;
	}
	public Element getHead(){
		return head;
	}
	
	public void setTail(Element tail){
		this.tail=tail;
	}
	public Element getTail(){
		return tail;
	}
	
	public void insert(Element newEle){
		anzEle++;
		if(head==null){
			head=newEle;
			tail=newEle;
		}
		else{
			Element tmpEle=head;
			while(tmpEle.getValue()>newEle.getValue()&&tmpEle!=tail){
				tmpEle=tmpEle.getNext();
			}
			newEle.setPrev(tmpEle);
			newEle.setNext(tmpEle);
			tmpEle.setPrev(newEle);
			if(newEle.getPrev()==null){
				head=newEle;
			}
			if(newEle.getNext()==null){
				tail=newEle;
			}
		}

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
