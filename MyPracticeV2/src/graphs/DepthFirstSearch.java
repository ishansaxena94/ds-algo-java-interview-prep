package graphs;

public class DepthFirstSearch {

	public static void main(String[] args) {
		// Total 5 vertices in graph
		Graph g = new Graph(5);

		g.addEdge(1, 0);
		g.addEdge(0, 2);
		g.addEdge(2, 1);
		g.addEdge(0, 3);
		g.addEdge(1, 4);

		System.out.println("Following is the Depth First Traversal");
		g.DFS(0); // 0 3 4 2 1
	}

}
