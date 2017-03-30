package aufg2_primzahlen;

public class Primzahlsuche {

	
	public Primzahlsuche(){
	}
	
	public static boolean[] langsameSuche(int n){
		
		boolean[] a=new boolean[n];
		for ( int i = 0; i < n ; i++)
		a[i] = true;
		for (int  i = 2; i < n; i++){
			for ( int j = 2; j < n; j++){
				if ( (i%j == 0) && (j!=i) ){
					a[i] = false;
				}		
			}
		}
		return a;// alle i fuer die a[i] noch auf true steht, sind Primzahlen
	}
	public static boolean[] schnelleSuche(int n){
		
		boolean[] a=new boolean[n];
		for ( int i = 0; i < n ; i++)
		a[i] = true;
		for (int  i = 2; i < n; i++){
			for ( int j = 2; j < Math.sqrt(i); j++){
				if ( (i%j == 0) && (j!=i) ){
					a[i] = false;
				}		
			}
		}
		return a;// alle i fuer die a[i] noch auf true steht, sind Primzahlen
	}

}
