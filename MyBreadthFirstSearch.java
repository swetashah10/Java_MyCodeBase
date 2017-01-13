import java.util.ArrayList;
import java.util.LinkedList;


public class MyBreadthFirstSearch {

	// Vertex.
	int numOfVertices; 
	// Data structure to hold edge information. 
	ArrayList<Integer> adj[];
	
	public MyBreadthFirstSearch(int V){
		// Initializes the vertex and the adjacency lists containing the edges information. 
		numOfVertices = V;
		adj = new ArrayList[numOfVertices*numOfVertices];
		for(int i=0; i<numOfVertices; ++i)
			adj[i] = new ArrayList<Integer>();
	}
	
	public void addEdge(int v, int w){
		
		// Adds an edge in between specified vertices.
		adj[v].add(w);
	}
	
	public void doBFS(int v){
		
		// logic to do breadth first search starting from vertex v.
		// Have a boolean array of all vertices for which value is true if visited. 
		boolean[] isVisited = new boolean[numOfVertices];
		
		isVisited[v] = false;
		LinkedList<Integer> queueOfNodesNotVisited = new LinkedList<Integer>();
		queueOfNodesNotVisited.add(v);
		
		while(!queueOfNodesNotVisited.isEmpty()){
		
		// travel and get its adjacent points.
		int vertexToTravelFrom = queueOfNodesNotVisited.poll();
		if(!isVisited[vertexToTravelFrom]){
			System.out.println(vertexToTravelFrom + " ");
			if(adj[vertexToTravelFrom].size() > 0){
				for(int i: adj[vertexToTravelFrom]){
				   queueOfNodesNotVisited.add(i);
				}
			}
			
			isVisited[vertexToTravelFrom] = true;
		}
	}
	
   }
	
	public static void main(String[] args){
		
		MyBreadthFirstSearch myBFS = new MyBreadthFirstSearch(4);
		myBFS.addEdge(0, 2);
		myBFS.addEdge(0, 3);
		myBFS.addEdge(2, 1);
		myBFS.addEdge(1, 3);
		myBFS.addEdge(1, 0);
		
		myBFS.doBFS(1);
	}
}

