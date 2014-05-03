/**
 * 
 */
package shortestpath;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Dinesh Appavoo
 *
 */
public class BellmanFordAlgorithm {

	/**
	 * @param args
	 */
	
	public static boolean[] pathDetermined;
	public static int noOfVertices,noOfEdges;
	public static Graph<Integer> graph=null;
	public static int[] d;
	public final static int INFINITY=Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new BellmanFordAlgorithm().findShortestPath();
	}
	
	public void constructGraph()
	{
		
		int u, v, w;
		Scanner scanner=new Scanner(System.in);
		while(scanner.hasNext())
		{
			noOfVertices=scanner.nextInt();
			noOfEdges=scanner.nextInt();
			
			//For the next function 'doDepthFirstSearch'
			pathDetermined=new boolean[noOfVertices+1];
			d=new int[noOfVertices+1];
			
			
			graph=new Graph<Integer>(noOfVertices);
			for(int i=0;i<noOfEdges;i++)
			{
				u=scanner.nextInt();
				v=scanner.nextInt();
				w=scanner.nextInt();
				graph.addEdge(u, v, w);
				//graph.addEdge(v, u, w);
			}
			break;
		}
		//graph.printGraph();

	}

	/**
	 * Initialize a single source graph
	 * INITIALIZE-SINGLE-SOURCE(G, s)
		for each vertex v in V [G]
			do d[v] <- Infinity
			¹[v] <- NIL
		d[s] <- 0
	 * 
	 */
	public void initializeSingleSource()
	{
		//Initialize source distance as zero
		d[1]=0; 
		
		//Initialize all vertices distance as infinity
		for(int i=2;i<=noOfVertices;i++)
		{
			d[i]=INFINITY;
		}
	}
	
	/**
	 * Method to relax an edge
	 * 
	 * RELAX(u, v, w)
			if d[v] > d[u] +w(u, v)
				then d[v] <- d[u] +w(u, v)
					¹[v] <- u
	 * 
	 * @param u
	 * @param v
	 * @param w
	 */
	public void doRelax(int u, int v, int w)
	{
		if(d[v]>d[u]+w)
			d[v]=d[u]+w;
	}
	
	
	/**
	 * Method to find the shortest path using BellMan Ford algorithm
	 * 
	 * BELLMAN-FORD(G, w, s)
			INITIALIZE-SINGLE-SOURCE(G, s)
			for i <- 1 to size(V [G])-1
				do for each edge (u, v) in E[G]
					do RELAX(u, v, w)
			for each edge (u, v) in E[G]
				do if d[v] > d[u] +w(u, v)
					then return FALSE
			return TRUE
	 * 
	 * 
	 * @return
	 */
	public boolean findBellmanFordShortestPath()
	{
		initializeSingleSource();
		
		for(int i=1;i<noOfVertices;i++)
		{
			for(int j=1;j<=noOfVertices;j++)
			{
				ArrayList<Edge> adjList=graph.getOutEdges(j);
				if(adjList!=null)
				for(Edge e : adjList)
				{
					doRelax((Integer)e.u, (Integer)e.v, (Integer)e.w);
				}
			}
		}
		
		for(int k=1;k<=noOfVertices;k++)
		{
			ArrayList<Edge> adjList=graph.getOutEdges(k);
			if(adjList!=null)
			for(Edge e : adjList)
			{
				if(d[(Integer)e.v]>d[(Integer)e.u]+(Integer)e.w)
					return false;
			}
		}
		
		return true;
	}
	
	public void findShortestPath()
	{
		constructGraph();
		findBellmanFordShortestPath();
		
		for(int i=1;i<=noOfVertices;i++)
		{
			System.out.println("Distance for "+i+" is "+d[i] );
		}
	}

}
