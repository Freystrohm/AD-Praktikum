/**
 * PM2 Praktikum
 * @author Johannes Kruber
 */
package aufg1_listen;

public interface IList<T>
{
	void insert(T element, Object pos);
	void delete(Object pos);
	void delete(String key);
	Object find(String key);
	T retrieve(Object pos);
	void concat(IList<T> liste);
}
