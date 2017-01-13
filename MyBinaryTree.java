public class MyBinaryTree {

	TreeNode root;
	
	class TreeNode{
		TreeNode left;
		TreeNode right;
		int data;
		
		public TreeNode(int d){
			data = d;
			left = null;
			right = null;
		}
	}
	
	/*
	 * Given a binary search tree and a given Target value, search the tree to see if it 
	 * contains the given target. 
	 */
	public static void main(String args[]){
		
		MyBinaryTree binTree = new MyBinaryTree();
		
		TreeNode rootNode = binTree.new TreeNode(3);
		binTree.addNodeInBST(4, rootNode);
		binTree.addNodeInBST(5, rootNode);
		binTree.addNodeInBST(1, rootNode);
		binTree.addNodeInBST(2, rootNode);
		binTree.addNodeInBST(3, rootNode);

	}
	
	public void printTreeInOrder(){
		
	}
	public TreeNode addNodeInBST(int d, TreeNode rootNode){
		TreeNode newNode = new TreeNode(d);
		
		if(rootNode == null){
			return newNode;
		} else if(rootNode.data <= d){
			rootNode.right = addNodeInBST(d, rootNode.right);
			
		} else if(rootNode.data >= d){
			rootNode.left = addNodeInBST(d, rootNode.left);
		}
			
		return newNode;
	}
}
