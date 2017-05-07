/**
*PM2 Paktikum
*@autor Johannes Kruber
*@autor Luis Nickel
*/
package aufg6_schnellerAlsQuicksort;

public class SchnelleSuche {

	private int min;
	private final double factor;
	Element listenHead;
	int[] array;
	
	public SchnelleSuche(int[] array){
		this.array=array;
		min=array[0];
		int max=array[0];
		 listenHead=new Element (array[0]);
		 Element tmpEle=listenHead;			;
		
		for(int i=1;i<array.length;i++){
			Element  newEle=new Element (array[i]);
			tmpEle.setNext(newEle);
			if(min>array[i]){
				min=array[i];
			}
			if(max<array[i]){
				max=array[i];
			}
			
			tmpEle=tmpEle.getNext();
		}
	
		double range=Math.abs(max)+Math.abs(min);
		factor=Math.abs(min)/range;
	}

	public void sort(){
		int index=0;
		DoubleLinkedList[] tmpListe=new DoubleLinkedList[array.length];
		Element  elementI=listenHead;
		while(elementI.getNext()!=null){
			index=(int)((elementI.getValue()-min)*factor);
			if(tmpListe[index]==null){
				tmpListe[index]=new DoubleLinkedList();
			}
			elementI=tmpListe[index].insert(elementI);
			
		}
		int anzEle=0;
		
		for(int i=0;i<array.length;i++){
			if(tmpListe[i]!=null){
			anzEle+=tmpListe[i].catArray(anzEle, array);
			}
		}
		
	}
	public void printArray(){
		for(int i=0;i<array.length;i++){
			System.out.println(array[i]);
		}
	}
	public static void main(String[] args) {
		int[] array={1,3,5,2,7,3};
		SchnelleSuche ss=new SchnelleSuche(array);
		ss.sort();
		ss.printArray();
	}
}
