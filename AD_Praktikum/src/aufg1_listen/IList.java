/**
 * PM2 Praktikum
 * @author Johannes Kruber
 */
package aufg1_listen;

public interface IList<T>
{
	void insert(T element, int pos);
	void delete(int pos);
	void delete(String key);
	int find(String key);
	T retrieve(int pos);
	void concat(IList<T> liste);
}
