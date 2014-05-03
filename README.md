BellmanFordShortestPath
=======================

BellmanFord Shortest Path algorithm implementation in java.

The Bellman–Ford algorithm is an algorithm that computes shortest paths from a single source vertex to all of the other
vertices in aweighted digraph.It is slower than Dijkstra's algorithm for the same problem, but more versatile, as it is
capable of handling graphs in which some of the edge weights are negative numbers. The algorithm is usually named after
two of its developers, Richard Bellman andLester Ford, Jr., who published it in 1958 and 1956, respectively.

##Complexity
  Worst case performance  O (|V| |E|)
  Worst case space complexity O (|V|)

##Functionality

This library has the implementaion of Bellamn Ford algorithm to find the shortest path in a directed graph G=[V,E].The 
following code snippet shows how to get the shortest path,

    BellmanFordAlgorithm belmanFord=new BellmanFordAlgorithm();
		belmanFord.findShortestPath();

#Input
3 3
1 2 1
2 3 2
1 3 3

First integer is the total number of vertices |V| in the graph G. The next integer is the number of edges |E| in the graph.
Next |E| linesh has the edges information (u, v, w) 

#Output
  Distance for 1 is 0
  Distance for 2 is 1
  Distance for 3 is 3
  
##Project Contributor

* Dinesh Appavoo ([@DineshAppavoo](https://twitter.com/DineshAppavoo))