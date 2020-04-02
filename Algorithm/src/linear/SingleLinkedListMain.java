package linear;

public class SingleLinkedListMain {

	public static void main(String[] args) {
		SingleLinkedList list = new SingleLinkedList();
		list.addElement(200);
		list.addElement(300);
		// 두번째 데이터 가져오기
		System.out.println(list.getElement(1).data);

		// 전체 순회 : 200->300
		list.traversal();
		System.out.println();

		// 1번째 위치에 데이터 추가
		list.insertElement(1, 250);
		// 200->250->300
		list.traversal();
		System.out.println();

		// 1번째 데이터 삭제
		list.removeElement(1);
		list.traversal();
		System.out.println();

		// 1번째 데이터 수정
		list.updateElement(1, 230);
		list.traversal();
		System.out.println();

		// 전체 데이터 삭제
		list.clearElement();
		list.traversal();
	}
}
