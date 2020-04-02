package nonlinear;

class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;
}

class LinkedTree {
	private TreeNode root;

	public LinkedTree(int data) {
		root = new TreeNode();
		root.data = data;
		root.left = null;
		root.right = null;
	}

	public TreeNode getRootNode() {
		return root;
	}

	public void insertLeftChildNode(TreeNode pParentNode, int element) {
		if (pParentNode.left == null) {
			pParentNode.left = new TreeNode();
			pParentNode.left.data = element;
		} else {
			System.out.println("오류, 이미 노드가 존재합니다.");
		}
	}
	public void insertRightChildNode(TreeNode pParentNode, int element) {
		if (pParentNode.right == null) {
			pParentNode.right = new TreeNode();
			pParentNode.right.data = element;
		} else {
			System.out.println("오류, 이미 노드가 존재합니다.");
		}
	}
	public TreeNode getLeftChildNode(TreeNode pNode)
	{
		TreeNode pReturn = pNode.left;
		return pReturn;
	}

	public TreeNode getRightChildNode(TreeNode pNode)
	{
		TreeNode pReturn = pNode.right;
		return pReturn;
	}
	
	public void preorder(TreeNode root){
		if(root != null){
			System.out.print(root.data + "  ");
			preorder(root.left);
			preorder(root.right);
		}
	}
	public void inorder(TreeNode root){
		if(root != null){
			inorder(root.left);
			System.out.print(root.data + "  ");			
			inorder(root.right);
		}
	}
	public void postorder(TreeNode root){
		if(root != null){
			postorder(root.left);					
			postorder(root.right);
			System.out.print(root.data + "  ");
		}
	}
	
	//노드 개수를 세는 메소드
	public int getNodeCount()
	{
		int ret = getNodeCountNode(root);
		return ret;
	}

	private int getNodeCountNode(TreeNode node)
	{
		int ret = 0;
		if(node != null) {
			ret = getNodeCountNode(node.left) + getNodeCountNode(node.right) + 1;
		}
		return ret;
	}
	
	//단말 노드 개수를 세주는 메소드
	public int getLeafNodeCount()
	{
		int ret = 0;
		if (root != null) {
			ret = getLeafNodeCountNode(root);
		}
		return ret;
	}

	private int getLeafNodeCountNode(TreeNode pSource)
	{
		int ret = 0;
		if (pSource != null) {
			if (pSource.left == null && pSource.right == null) {
				ret = 1;
			}
			else {
				ret = getLeafNodeCountNode(pSource.left) + getLeafNodeCountNode(pSource.right);
			}
		}
		return ret;
	}
}
