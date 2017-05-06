/**
*PM2 Paktikum
*@autor Johannes Kruber
*@autor Luis Nickel
*/
package aufg6_schnellerAlsQuicksort;

public class SchnelleSuche {

	private int min;
	private final double factor;
	Element<Integer>[] liste;
	Integer[] array;;
	
	public SchnelleSuche(Integer[] array){
		this.array=array;
		min=array[0];
		int max=array[0];
		for(int i=0;i<array.length;i++){
			Element<Integer> newEle=new Element<Integer>(array[i]);
			this.liste[i]=newEle;
			if(min>array[i]){
				min=array[i];
			}
			if(max<array[i]){
				max=array[i];
			}
			
		}
	
		double range=Math.abs(max)+Math.abs(min);
		factor=Math.abs(min)/range;
	}

	public void sort(){
		int index;
		DoubleLinkedList<Integer>[] tmpListe=new DoubleLinkedList[liste.length];
		for(int i=0;i<liste.length;i++){
			index=(int)((liste[i].getValue()-min)*factor);
			tmpListe[index].insert( liste[i]);
		}
		int anzEle=0;
		
		for(int i=0;i<liste.length;i++){
			anzEle+=tmpListe[i].catArray(anzEle, array);
		}
	}
	public static void main(String[] args) {
		Integer[] array={1,4,2,53,21,51};
		SchnelleSuche ss=new SchnelleSuche(array);
		ss.sort();
	}
}
