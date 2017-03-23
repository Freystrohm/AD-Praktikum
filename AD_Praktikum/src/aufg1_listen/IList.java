/**
 * PM2 Praktikum
 * @author Johannes Kruber
 * @author Luis Nickel 
 */
package aufg1_listen;

public interface IList
{
	void insert(Object element, int pos);
	void delete(int pos);
	void delete(String key);
	int find(String key);
	Object retrieve(int pos);
	void concat(IList liste);
}
