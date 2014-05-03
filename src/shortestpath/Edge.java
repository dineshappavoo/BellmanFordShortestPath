/**
 * 
 */
package shortestpath;

/**
 * @author Dany
 *
 */
public class Edge<T extends Comparable<T>> {

	
	public T u;
	public T v;
	public T w;
	
	public Edge(T u, T v, T w)
	{
		this.u=u;
		this.v=v;
		this.w=w;
	}
	
}
