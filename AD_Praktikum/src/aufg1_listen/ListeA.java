package aufg1_listen;

public class ListeA<T> implements IList<T>{
  
  private ElementA<T> array[];
  private int key;
  
  private long zaehler;
 
  
  public long getZaehler() {
    return zaehler;
  }
  
  public void resetZaehler(){
    zaehler = 0;
  }


  public ListeA(){
    zaehler = 0;
    array = new ElementA[0];
    zaehler++;
    
    key=1;
    zaehler++;
    
  }
  

  public ElementA[] getArray() {
    return array;
  }

  public void setArray(ElementA[] array) {
    this.array = array;
    zaehler++;
  }


  @Override
  public void insert(T element, Object pos) {
    
    if(pos instanceof Integer){
      
      int posTemp = (int)pos;
      
      ElementA<T> temp[] = new ElementA[array.length+1];
      zaehler++;
        if(posTemp<=array.length && posTemp>=0){
          zaehler++;  
      
          for(int i=0;i<posTemp;i++){
            zaehler++;
            temp[i]=array[i];
            zaehler++;
          }
      
          ElementA<T> tempEl = new ElementA<T>(Integer.toString(key), element);
          zaehler++;
          temp[posTemp]=tempEl;
          zaehler++;
      
          for(int i=posTemp;i<array.length;i++){
            zaehler++;
            temp[i+1]=array[i];
            zaehler++;
          }
      
        }else{
          if(array.length>0){
        	  System.arraycopy(array, 0, temp, 0, array.length);
          }
          
          zaehler += array.length;

          temp[array.length] = new ElementA<T>(""+key, element);
          zaehler++;
      
        }

    

        array=temp;
        zaehler++;
        key++;
        zaehler++;
    }
    

  }

  @Override
  public void delete(Object pos) {
    
    if(pos instanceof Integer){  
      int posTemp = (int)pos;
      
      if(posTemp<array.length){
        zaehler++;
      
        ElementA<T> temp[] = new ElementA[array.length-1];
        zaehler++;
        for(int i=0;i<array.length;i++){
          zaehler++;
          if(i<posTemp){
            zaehler++;
            temp[i]=array[i];
            zaehler++;
          }
          else if(i>posTemp){
            zaehler++;
            temp[i-1]=array[i];
            zaehler++;
          }
        }
        array=temp;
        zaehler++;
      }else{
        System.out.println("pos zu Gro�");
      }
    }
    
  }

  @Override
  public void delete(String key) {
    int pos = (int)find(key);
    zaehler++;
    if(pos>-1){
      zaehler++;
      delete(pos);
    }else{
      System.out.println("key ist nicht zu finden");
    }
    
  }

  @Override
  public Object find(String key) {
    for(int i=0;i<array.length;i++){
      zaehler++;
      if(array[i].getKey().equals(key)){
        zaehler++;
        return i;
      }
    }
    return -1;
  }

  @Override
  public T retrieve(Object pos) {
    
    if(pos instanceof Integer){
      int posTemp = (int)pos;
      if(!(posTemp < 0 || posTemp > array.length-1))
      {
    	  return (T) array[posTemp].getElement();
      }
    }
    return null;
  }

  @Override
  public void concat(IList<T> liste) {
    
    if( liste instanceof ListeA){
      zaehler++;
      ListeA<T> list = (ListeA<T>)liste;
      zaehler++;
      ElementA<T> temp[] = new ElementA[array.length + list.getArray().length];
      zaehler+=3;
      
      for(int i=0;i<array.length;i++){
        zaehler++;
        temp[i] = array[i];
        zaehler++;
      }
      int j=0;
      zaehler++;
      for(int i=array.length;i<(array.length + list.getArray().length);i++){
        zaehler++;
        temp[i]=list.getArray()[j];
        zaehler++;
        j++;
        zaehler++;
      }
      array=temp;
      zaehler++;
    }
    
  }

}
