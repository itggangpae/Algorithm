package linear;

public class CircularLinkedListMain {

	public static void main(String[] args) {
		CircularLinkedList list = new CircularLinkedList();
		System.out.println(list.size());
		// 마지막에 데이터 삽입
		list.addElement(100);
		System.out.println(list.size());
		list.addElement(200);
		System.out.println(list.size());
		list.addElement(300);
		System.out.println(list.size());
		System.out.println();

		// 노드를 1개씩 가져오기
		System.out.println("0번째 노드:" + list.getElement(0).data);
		System.out.println("1번째 노드:" + list.getElement(1).data);
		System.out.println("2번째 노드:" + list.getElement(2).data);
		System.out.println();

		// 전체 노드 순회
		list.traversal();
		System.out.println();
		
		
		//1번째 노드의 이전 노드 찾기
		Node node = list.getElement(1);
		Node prevNode = list.prevElement(node);
		System.out.println("1번의 이전 노드:" + prevNode.data);

		// 중간에 노드 추가
		list.insertElement(2, 270);
		list.traversal();
		System.out.println();

		// 0번째와 데이터 수정
		list.updateElement(0, 50);
		list.traversal();
		System.out.println();

		// 0번째와 1번째 데이터 삭제
		list.removeElement(0);
		list.traversal();
		System.out.println();

		list.removeElement(1);
		list.traversal();
		System.out.println();
		
		//전체 삭제
		list.clearElement();
		list.traversal();
		
	}
}
