package aufg1_listen;

public class ElementA<T> {
  private String key;
  private T element;

  
  public ElementA(String key, T element) {
    super();
    this.key = key;
    this.element = element;
  }
  
  public String getKey() {
    return key;
  }
  public void setKey(String key) {
    this.key = key;
  }
  public T getElement() {
    return element;
  }
  public void setElement(T element) {
    this.element = element;
  }
  
  

}
