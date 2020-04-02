package nonlinear;

public class AdjListMain {

	public static void main(String[] args) {
		System.out.println("---방향성---");
		System.out.println("------간선 추가------");
		AdjList graph = new AdjList(5, true);
		graph.printAdjList();
		graph.insertEdge(0, 0);
		graph.insertEdge(0, 2);
		graph.insertEdge(0, 1);
		graph.insertEdge(1, 2);
		graph.insertEdge(2, 3);
		graph.insertEdge(2, 2);
		graph.insertEdge(2, 1);
		graph.printAdjList();
		System.out.println("------간선 삭제------");
		graph.removeEdge(0, 1);
		graph.printAdjList();
		System.out.println();
		
		System.out.println("---무방향성---");
		System.out.println("------간선 추가------");
		graph = new AdjList(5, false);
		graph.printAdjList();
		graph.insertEdge(0, 3);
		graph.insertEdge(1, 2);
		graph.insertEdge(1, 3);
		graph.insertEdge(2, 2);
		graph.insertEdge(2, 1);
		graph.printAdjList();
		System.out.println("------간선 삭제------");
		graph.removeEdge(0, 1);
		graph.printAdjList();
		System.out.println();
		
		System.out.println("---깊이 우선 탐색---");
		graph.DFS(0);
		System.out.println("---너비 우선 탐색---");
		graph.BFS(0);
		
	}
}
