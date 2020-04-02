package nonlinear;

public class AdjMatrixMain {

	public static void main(String[] args) {
		System.out.println("----방향성 그래프----");
		AdjMatrix graph = new AdjMatrix(5, true);
		graph.printAdjMarix();
		System.out.println();
		
		graph.insertEdge(0, 1);
		graph.insertEdge(2, 3);
		graph.printAdjMarix();
		System.out.println();
		
		graph.removeEdge(2, 3);
		graph.printAdjMarix();
		System.out.println();
		
		System.out.println("----무방향성 그래프----");
		graph = new AdjMatrix(5, false);
		graph.printAdjMarix();
		System.out.println();
		
		graph.insertEdge(0, 1);
		graph.insertEdge(2, 3);
		graph.printAdjMarix();
		System.out.println();
		
		graph.removeEdge(2, 3);
		graph.printAdjMarix();
		System.out.println();
	}
}
