package nonlinear;

public class LinkedTreeMain {

	public static void main(String[] args) {
		LinkedTree tree = new LinkedTree(100);
		
		TreeNode root = tree.getRootNode();
	
		tree.insertLeftChildNode(root, 200);
		tree.insertRightChildNode(root, 300);
		
		TreeNode node = tree.getLeftChildNode(root);
		tree.insertLeftChildNode(node, 400);
		tree.insertRightChildNode(node, 500);
		
		tree.inorder(root);
		System.out.println();
		
		tree.preorder(root);
		System.out.println();
		
		tree.postorder(root);
		System.out.println();
		
		System.out.println("노드 개수:" + tree.getNodeCount() + "");
		System.out.println("단말 노드 개수:" + tree.getLeafNodeCount() + "");
	}
}
