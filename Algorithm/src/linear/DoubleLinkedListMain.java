package linear;

public class DoubleLinkedListMain {

	public static void main(String[] args) {
		DoubleLinkedList list = new DoubleLinkedList();
		list.addElement(100);
		list.addElement(200);
		list.addElement(300);
		
		System.out.println(list.size());
		System.out.println(list.getElement(0).data);
		System.out.println(list.getElement(1).data);
		System.out.println();
		
		System.out.println(list.getElement(-1).data);
		System.out.println(list.getElement(-2).data);
		System.out.println();
		
		Node node = list.getElement(1);
		System.out.println(list.prevElement(node).data);
		System.out.println(list.nextElement(node).data);
		
		list.traversal();
		System.out.println();
		list.reversetraversal();
		System.out.println();
		
		list.insertElement(0, 80);
		list.traversal();
		list.insertElement(2, 150);
		list.traversal();
		list.insertElement(5, 400);
		list.traversal();
		System.out.println();
		
		list.insertElement(-1, 500);
		list.traversal();
		list.insertElement(-8, 10);
		list.traversal();
		System.out.println();
		
		list.updateElement(1, 90);
		list.traversal();
		System.out.println();
		
		list.updateElement(-1, 600);
		list.traversal();
		System.out.println();
		

		list.removeElement(1);
		list.traversal();
		System.out.println();
		
		list.removeElement(-2);
		list.traversal();
		System.out.println();
		
		list.clearElement();
		list.traversal();
		System.out.println();
		
	}
}
